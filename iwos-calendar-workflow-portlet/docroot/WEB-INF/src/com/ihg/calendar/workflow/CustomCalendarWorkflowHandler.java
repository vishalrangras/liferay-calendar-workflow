package com.ihg.calendar.workflow;

import com.ihg.calendar.model.CalendarWorkflow;
import com.ihg.calendar.service.CalendarWorkflowLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

public class CustomCalendarWorkflowHandler extends BaseWorkflowHandler{
	
	public static final String CLASS_NAME = CalendarWorkflow.class.getName();
	
	@Override
	public String getClassName() {
		// TODO Auto-generated method stub
		return CLASS_NAME;
	}

	@Override
	public String getType(Locale locale) {
		// TODO Auto-generated method stub
		String type = ResourceActionsUtil.getModelResource(locale, getClassName());
		return "Calendar Workflow";
	}

	@Override
	public Object updateStatus(int status, Map<String, Serializable> workflowContext) throws PortalException, SystemException {
		// TODO Auto-generated method stub
		long userId = GetterUtil.getLong(
                (String)workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		
		long calendarWorkflowId = GetterUtil.getLong(
                (String)workflowContext.get(
                    WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
                    
        ServiceContext serviceContext = (ServiceContext)workflowContext.get(
                            "serviceContext");
		
		return CalendarWorkflowLocalServiceUtil.updateStatus(userId, calendarWorkflowId, status, serviceContext);
	}
	
	@Override
	public String getTitle(long classPK, Locale locale) {
		// TODO Auto-generated method stub
		String title = null;
		try {
			CalendarWorkflow calendarWorkflow = CalendarWorkflowLocalServiceUtil.getCalendarWorkflow(classPK);
			title = calendarWorkflow.getTitle(locale);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}
	
	@Override
	public String getSummary(long classPK, Locale locale) {
		// TODO Auto-generated method stub
		String summary = null;
		try {
			CalendarWorkflow calendarWorkflow = CalendarWorkflowLocalServiceUtil.getCalendarWorkflow(classPK);
			summary = calendarWorkflow.getTitle(locale);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return summary;
	}
	
}
