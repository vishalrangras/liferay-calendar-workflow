package com.ihg.calendar.portlet;

import com.ihg.calendar.model.CalendarWorkflow;
import com.ihg.calendar.service.CalendarWorkflowLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * Portlet implementation class CalendarWorkflowPortlet
 */
public class CalendarWorkflowPortlet extends MVCPortlet {
	
	
	@Override
	public void render(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		// TODO Auto-generated method stub
		try {
			List<CalendarWorkflow> calendarWorkflowList = CalendarWorkflowLocalServiceUtil.getAllCalendarWorkflow();
			int calendarWorkflowCount = CalendarWorkflowLocalServiceUtil.getAllCalendarWorkflowCounts();
			request.setAttribute("count", calendarWorkflowCount);
			request.setAttribute("calendarWorkflowList", calendarWorkflowList);
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.render(request, response);
	}

}
