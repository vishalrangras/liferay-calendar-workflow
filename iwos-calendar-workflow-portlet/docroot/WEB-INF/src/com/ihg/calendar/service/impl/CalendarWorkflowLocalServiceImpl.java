/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.ihg.calendar.service.impl;

import com.ihg.calendar.NoSuchCalendarWorkflowException;
import com.ihg.calendar.model.CalendarWorkflow;
import com.ihg.calendar.service.base.CalendarWorkflowLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.model.WorkflowInstanceLink;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * The implementation of the calendar workflow local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.calendar.service.CalendarWorkflowLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author vishal.rangras
 * @see com.ihg.calendar.service.base.CalendarWorkflowLocalServiceBaseImpl
 * @see com.ihg.calendar.service.CalendarWorkflowLocalServiceUtil
 */
public class CalendarWorkflowLocalServiceImpl
	extends CalendarWorkflowLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.calendar.service.CalendarWorkflowLocalServiceUtil} to access the calendar workflow local service.
	 */
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");
	
	private static final String IWOS_ADMIN_FROM_MAIL_ID = "iwos.admin.from.email.address";
	private static final String IWOS_ADMIN_FROM_NAME = "iwos.admin.from.name";
	private static final String IWOS_ADMIN_TO_MAIL_ID = "iwos.admin.to.email.address";
	private static final String EVENT_ADDED_SUBJECT = "calendar.event.added.email.subject";
	private static final String EVENT_ADDED_BODY = "calendar.event.added.email.body";
	private static final String EVENT_APPROVED_SUBJECT = "calendar.event.approved.email.subject";
	private static final String EVENT_APPROVED_BODY = "calendar.event.approved.email.body";
	private static final String EVENT_REJECTED_SUBJECT = "calendar.event.rejected.email.subject";
	private static final String EVENT_REJECTED_BODY = "calendar.event.rejected.email.body";
	private static final String EVENT_DELETED_SUBJECT = "calendar.event.deleted.email.subject";
	private static final String EVENT_DELETED_BODY = "calendar.event.deleted.email.body";
	
	public CalendarWorkflow addCalendarWorkflow(long companyId, long groupId, long userId, long calendarBookingId, long startTime, Map<Locale, String> titleMap, ServiceContext serviceContext ) throws SystemException, PortalException{
		
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		
		CalendarWorkflow calendarWorkflow = calendarWorkflowPersistence.create(CounterLocalServiceUtil.increment());
		calendarWorkflow.setCalendarWorkflowId(CounterLocalServiceUtil.increment());
		calendarWorkflow.setGroupId(groupId);
		calendarWorkflow.setUserId(userId);
		calendarWorkflow.setCalendarBookingId(calendarBookingId);
		calendarWorkflow.setStartTime(startTime);
		Date startDateTime = new Date(startTime);
		calendarWorkflow.setStartDateTime(sdf.format(startDateTime));
		calendarWorkflow.setStatus(WorkflowConstants.STATUS_DRAFT);
		calendarWorkflow.setStatusByUserId(userId);
		calendarWorkflow.setStatusByUserName(user.getFullName());
		calendarWorkflow.setStatusDate(new Date());
		calendarWorkflow.setTitleMap(titleMap, serviceContext.getLocale());
		calendarWorkflowPersistence.update(calendarWorkflow);
		sendEmailNotification("eventAdded", PortletProps.get(IWOS_ADMIN_TO_MAIL_ID), calendarWorkflow.getTitle(LocaleThreadLocal.getDefaultLocale()), user.getFullName(), user.getFullName(), "http://localhost:12080");
		WorkflowHandlerRegistryUtil.startWorkflowInstance(companyId, groupId, userId, CalendarWorkflow.class.getName(), calendarWorkflow.getPrimaryKey(), calendarWorkflow, serviceContext);
		return calendarWorkflow;
	}
	
	public void approveEvent(long companyId, long userId, long calendarWorkflowId) throws SystemException, PortalException {
		try {
			CalendarWorkflow calendarWorkflow = calendarWorkflowPersistence.findByCalendarWorkflowId(calendarWorkflowId);
			WorkflowInstanceLink workflowInstanceLink = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(companyId, calendarWorkflow.getGroupId(), CalendarWorkflow.class.getName(), calendarWorkflow.getPrimaryKey());
			WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId, workflowInstanceLink.getWorkflowInstanceId());
			
			WorkflowStatusManagerUtil.updateStatus(WorkflowConstants.getLabelStatus("approved"), workflowInstance.getWorkflowContext());
			
			User originalUser = userPersistence.findByPrimaryKey(calendarWorkflow.getUserId());
			sendEmailNotification("eventApproved", originalUser.getEmailAddress(), calendarWorkflow.getTitle(LocaleThreadLocal.getDefaultLocale()), StringPool.BLANK, StringPool.BLANK, StringPool.BLANK);
			
			_log.info("================approve event completed =========================");
			
		} catch (NoSuchCalendarWorkflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WorkflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void rejectEvent(long companyId, long userId, long calendarWorkflowId) throws PortalException, SystemException {
		try {
			CalendarWorkflow calendarWorkflow = calendarWorkflowPersistence.findByCalendarWorkflowId(calendarWorkflowId);
			WorkflowInstanceLink workflowInstanceLink = WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(companyId, calendarWorkflow.getGroupId(), CalendarWorkflow.class.getName(), calendarWorkflow.getPrimaryKey());
			WorkflowInstance workflowInstance = WorkflowInstanceManagerUtil.getWorkflowInstance(companyId, workflowInstanceLink.getWorkflowInstanceId());
			
			WorkflowStatusManagerUtil.updateStatus(WorkflowConstants.getLabelStatus("denied"), workflowInstance.getWorkflowContext());
			WorkflowStatusManagerUtil.updateStatus(WorkflowConstants.getLabelStatus("pending"), workflowInstance.getWorkflowContext());
			
			User originalUser = userPersistence.findByPrimaryKey(calendarWorkflow.getUserId());
			sendEmailNotification("eventRejected", originalUser.getEmailAddress(), calendarWorkflow.getTitle(LocaleThreadLocal.getDefaultLocale()), StringPool.BLANK, StringPool.BLANK, StringPool.BLANK);
			
			_log.info("================reject event completed =========================");
			
		} catch (NoSuchCalendarWorkflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WorkflowException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public CalendarWorkflow updateCalendarWorkflow(long companyId, long groupId, long userId, long calendarBookingId, long startTime, Map<Locale, String> titleMap, ServiceContext serviceContext ) throws SystemException, PortalException{
		
		CalendarWorkflow calendarWorkflow = calendarWorkflowPersistence.findByCalendarBookingId(calendarBookingId);
		calendarWorkflowPersistence.remove(calendarWorkflow);
		calendarWorkflow = addCalendarWorkflow(companyId, groupId, userId, calendarBookingId, startTime, titleMap, serviceContext);
		return calendarWorkflow;
		
	}
	
	public void moveToTrashCalendarWorkflow(long userId, long calendarBookingId, ServiceContext serviceContext) throws SystemException, PortalException{
		CalendarWorkflow calendarWorkflow;
		try {
			calendarWorkflow = calendarWorkflowPersistence.findByCalendarBookingId(calendarBookingId);
			calendarWorkflow.setInTrash(true);
			calendarWorkflowPersistence.update(calendarWorkflow);
			User originalUser = userPersistence.findByPrimaryKey(calendarWorkflow.getUserId());
			User currentUser = userPersistence.findByPrimaryKey(userId);
			sendEmailNotification("eventDeleted", PortletProps.get(IWOS_ADMIN_TO_MAIL_ID), calendarWorkflow.getTitle(LocaleThreadLocal.getDefaultLocale()), originalUser.getFullName(), currentUser.getFullName(), StringPool.BLANK);
		} catch (NoSuchCalendarWorkflowException e) {
			_log.info("No Such Calendar Workflow exist with the Calendar Booking ID:"+calendarBookingId);
		}		
	}
	
	public void restoreCalendarWorkflow(long calendarBookingId) throws SystemException{
		CalendarWorkflow calendarWorkflow;
		try {
			calendarWorkflow = calendarWorkflowPersistence.findByCalendarBookingId(calendarBookingId);
			calendarWorkflow.setInTrash(false);
			calendarWorkflowPersistence.update(calendarWorkflow);
		} catch (NoSuchCalendarWorkflowException e) {
			_log.info("No Such Calendar Workflow exist with the Calendar Booking ID:"+calendarBookingId);
		}
		
	}
	
	public void removeCalendarWorkflow(long calendarBookingId)throws PortalException, SystemException{
		try {
			calendarWorkflowPersistence.removeByCalendarBookingId(calendarBookingId);			
		} catch (NoSuchCalendarWorkflowException e) {
			// TODO Auto-generated catch block
			_log.info("No Such Calendar Workflow exist with the Calendar Booking ID:"+calendarBookingId);
		}
	}
	
	public CalendarWorkflow updateStatus(long userId, long calendarWorkflowId, int status,
		       ServiceContext serviceContext) throws PortalException, SystemException{
		
		User user = userLocalService.getUser(userId);
		CalendarWorkflow calendarWorkflow = getCalendarWorkflow(calendarWorkflowId);
		calendarWorkflow.setStatus(status);
		calendarWorkflow.setStatusByUserId(userId);
		calendarWorkflow.setStatusByUserName(user.getFullName());
		calendarWorkflow.setStatusDate(new Date());
		calendarWorkflowPersistence.update(calendarWorkflow);
		
		return calendarWorkflow;
	}
	
	public List<CalendarWorkflow> getCalendarWorkflowByM_G_S(int viewMode, long groupId, int start, int end) throws SystemException{
		if(viewMode==0){
			return getCalendarWorkflowByGroupAndStatus(groupId, WorkflowConstants.STATUS_PENDING, start, end);
		}else if(viewMode==1){
			return getCalendarWorkflowByGroupAndStatus(groupId, WorkflowConstants.STATUS_APPROVED, start, end);
		}else if(viewMode==2){
			return getAllCalendarWorkflowInTrashByGroupId(groupId, start, end);
		}else{
			List<CalendarWorkflow> trashedCalendarWorkflows = getAllCalendarWorkflowInTrashByGroupId(groupId, start, end);
			List<CalendarWorkflow> untrashedCalendarWorkflows =  getAllCalendarWorkflowByGroupId(groupId, start, end);
			List<CalendarWorkflow> allCalendarWorkflows = new ArrayList<CalendarWorkflow>();
			allCalendarWorkflows.addAll(trashedCalendarWorkflows);
			allCalendarWorkflows.addAll(untrashedCalendarWorkflows);
			return allCalendarWorkflows;
		}
	}
	
	public int getCalendarWorkflowCountByM_G_S(int viewMode, long groupId) throws SystemException{
		if(viewMode==0){
			return getCalendarWorkflowCountByGroupAndStatus(groupId, WorkflowConstants.STATUS_PENDING);
		}else if(viewMode==1){
			return getCalendarWorkflowCountByGroupAndStatus(groupId, WorkflowConstants.STATUS_APPROVED);
		}else if(viewMode==2){
			return getAllCalendarWorkflowInTrashCountByGroupId(groupId);
		}else{
			return getAllCalendarWorkflowCountByGroupId(groupId)+getAllCalendarWorkflowInTrashCountByGroupId(groupId);
		}
	}
	
	public List<CalendarWorkflow> getCalendarWorkflowByGroupAndStatus(long groupId, int status) throws SystemException{
		return calendarWorkflowPersistence.findByG_S(groupId, status, false);
	}
	
	public List<CalendarWorkflow> getCalendarWorkflowByGroupAndStatus(long groupId, int status, int start, int end) throws SystemException{
		return calendarWorkflowPersistence.findByG_S(groupId, status, false, start, end);
	}
	
	public int getCalendarWorkflowCountByGroupAndStatus(long groupId, int status) throws SystemException{
		return calendarWorkflowPersistence.countByG_S(groupId, status, false);
	}
	
	public List<CalendarWorkflow> getCalendarWorkflowByStatusAndStartTime(long groupId, int status, long startTime) throws SystemException{
		return calendarWorkflowPersistence.findByG_S_S(groupId, status, startTime, false);
	}
	
	public List<CalendarWorkflow> getCalendarWorkflowByStatusAndStartTime(long groupId, int status, long startTime, int start, int end) throws SystemException{
		return calendarWorkflowPersistence.findByG_S_S(groupId, status, startTime, false, start, end);
	}
	
	public int getCalendarWorkflowCountByStatusAndStartTime(long groupId, int status, long startTime) throws SystemException{
		return calendarWorkflowPersistence.countByG_S_S(groupId, status, startTime, false);
	}
	
	public List<CalendarWorkflow> getAllCalendarWorkflowByGroupId(long groupId) throws SystemException{
		return calendarWorkflowPersistence.findByGroupId(groupId, false);
	}
	
	public List<CalendarWorkflow> getAllCalendarWorkflowByGroupId(long groupId, int start, int end) throws SystemException{
		return calendarWorkflowPersistence.findByGroupId(groupId, false, start, end);
	}
	
	public int getAllCalendarWorkflowCountByGroupId(long groupId) throws SystemException{
		return calendarWorkflowPersistence.countByGroupId(groupId, false);
	}
	
	public List<CalendarWorkflow> getAllCalendarWorkflowInTrashByGroupId(long groupId) throws SystemException{
		return calendarWorkflowPersistence.findByGroupId(groupId, true);
	}
	
	public List<CalendarWorkflow> getAllCalendarWorkflowInTrashByGroupId(long groupId, int start, int end) throws SystemException{
		return calendarWorkflowPersistence.findByGroupId(groupId, true, start, end);
	}
	
	public int getAllCalendarWorkflowInTrashCountByGroupId(long groupId) throws SystemException{
		return calendarWorkflowPersistence.countByGroupId(groupId, true);
	}
	
	public List<CalendarWorkflow> getAllCalendarWorkflow() throws SystemException{
		return calendarWorkflowPersistence.findAll();
	}
	
	public List<CalendarWorkflow> getAllCalendarWorkflow(int start, int end) throws SystemException{
		return calendarWorkflowPersistence.findAll(start, end);
	}
	
	public int getAllCalendarWorkflowCounts() throws SystemException{
		return calendarWorkflowPersistence.countAll();
	}
	
	public void sendEmailNotification(String type, String toEmail, String eventTitle, String originalUser, String currentUser, String url){
		
		String template = StringPool.BLANK;
		String[] oldSubs = null;
		String[] newSubs = null;
		
		String subject = StringPool.BLANK;
		String body = StringPool.BLANK;
		
		try {
			
			MailMessage message = new MailMessage();
			message.setHTMLFormat(true);
			message.setFrom(new InternetAddress(PortletProps.get(IWOS_ADMIN_FROM_MAIL_ID), PortletProps.get(IWOS_ADMIN_FROM_NAME)));
			
			InternetAddress[] toEmailAddress = InternetAddress.parse(toEmail);
			message.setTo(toEmailAddress);
			
			if(type.equals("eventAdded")){
				subject = PortletProps.get(EVENT_ADDED_SUBJECT);
				template = PortletProps.get(EVENT_ADDED_BODY);
				oldSubs = new String[] { "[$EVENT_TITLE$]", "[$ORIGINAL_USER$]", "[$URL$]"};
				newSubs = new String[] { eventTitle, originalUser, url};
			}else if(type.equals("eventApproved")){
				subject = PortletProps.get(EVENT_APPROVED_SUBJECT);
				template = PortletProps.get(EVENT_APPROVED_BODY);
				oldSubs = new String[] { "[$EVENT_TITLE$]"};
				newSubs = new String[] { eventTitle};
			}else if(type.equals("eventRejected")){
				subject = PortletProps.get(EVENT_REJECTED_SUBJECT);
				template = PortletProps.get(EVENT_REJECTED_BODY);
				oldSubs = new String[] { "[$EVENT_TITLE$]"};
				newSubs = new String[] { eventTitle};
			}else if(type.equals("eventDeleted")){
				subject = PortletProps.get(EVENT_DELETED_SUBJECT);
				template = PortletProps.get(EVENT_DELETED_BODY);
				oldSubs = new String[] { "[$EVENT_TITLE$]", "[$ORIGINAL_USER$]", "[$CURRENT_USER$]"};
				newSubs = new String[] { eventTitle, originalUser, currentUser};
			}else{
				return;
			}
			
			body = StringUtil.replace(template, oldSubs, newSubs);
			message.setSubject(subject);
			message.setBody(body);
			MailServiceUtil.sendEmail(message);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static Log _log = LogFactoryUtil.getLog(CalendarWorkflowLocalServiceImpl.class);
	
	
}