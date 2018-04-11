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
import com.ihg.calendar.service.CalendarWorkflowLocalServiceUtil;
import com.ihg.calendar.service.base.CalendarWorkflowLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
	
	public CalendarWorkflow addCalendarWorkflow(long companyId, long groupId, long userId, long calendarBookingId, long startTime, Map<Locale, String> titleMap, ServiceContext serviceContext ) throws SystemException, PortalException{
		
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());
		
		CalendarWorkflow calendarWorkflow = calendarWorkflowPersistence.create(CounterLocalServiceUtil.increment());
		calendarWorkflow.setCalendarWorkflowId(CounterLocalServiceUtil.increment());
		calendarWorkflow.setGroupId(groupId);
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
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(companyId, groupId, userId, CalendarWorkflow.class.getName(), calendarWorkflow.getPrimaryKey(), calendarWorkflow, serviceContext);
		return calendarWorkflow;
	}
	
	public CalendarWorkflow updateCalendarWorkflow(long companyId, long groupId, long userId, long calendarBookingId, long startTime, Map<Locale, String> titleMap, ServiceContext serviceContext ) throws SystemException, PortalException{
		
		CalendarWorkflow calendarWorkflow = calendarWorkflowPersistence.findByCalendarBookingId(calendarBookingId);
		calendarWorkflowPersistence.remove(calendarWorkflow);
		calendarWorkflow = addCalendarWorkflow(companyId, groupId, userId, calendarBookingId, startTime, titleMap, serviceContext);
		return calendarWorkflow;
		
	}
	
	public void moveToTrashCalendarWorkflow(long userId, long calendarBookingId, ServiceContext serviceContext) throws SystemException{
		CalendarWorkflow calendarWorkflow;
		try {
			calendarWorkflow = calendarWorkflowPersistence.findByCalendarBookingId(calendarBookingId);
			calendarWorkflow.setInTrash(true);
			calendarWorkflowPersistence.update(calendarWorkflow);
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
	
	public void removeCalendarWorkflow(long calendarBookingId) throws SystemException{
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
	
	public List<CalendarWorkflow> getCalendarWorkflowByStatus(long groupId, int status) throws SystemException{
		return calendarWorkflowPersistence.findByG_S(groupId, status, false);
	}
	
	public List<CalendarWorkflow> getCalendarWorkflowByStatus(long groupId, int status, int start, int end) throws SystemException{
		return calendarWorkflowPersistence.findByG_S(groupId, status, false, start, end);
	}
	
	public int getCalendarWorkflowCountByStatus(long groupId, int status) throws SystemException{
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
	
	public List<CalendarWorkflow> getAllCalendarWorkflow() throws SystemException{
		return calendarWorkflowPersistence.findAll();
	}
	
	public List<CalendarWorkflow> getAllCalendarWorkflow(int start, int end) throws SystemException{
		return calendarWorkflowPersistence.findAll(start, end);
	}
	
	public int getAllCalendarWorkflowCounts() throws SystemException{
		return calendarWorkflowPersistence.countAll();
	}
	
	private static Log _log = LogFactoryUtil.getLog(CalendarWorkflowLocalServiceImpl.class);
	
	
}