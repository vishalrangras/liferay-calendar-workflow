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

package com.ihg.calendar.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CalendarWorkflowService}.
 *
 * @author vishal.rangras
 * @see CalendarWorkflowService
 * @generated
 */
public class CalendarWorkflowServiceWrapper implements CalendarWorkflowService,
	ServiceWrapper<CalendarWorkflowService> {
	public CalendarWorkflowServiceWrapper(
		CalendarWorkflowService calendarWorkflowService) {
		_calendarWorkflowService = calendarWorkflowService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _calendarWorkflowService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_calendarWorkflowService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _calendarWorkflowService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CalendarWorkflowService getWrappedCalendarWorkflowService() {
		return _calendarWorkflowService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCalendarWorkflowService(
		CalendarWorkflowService calendarWorkflowService) {
		_calendarWorkflowService = calendarWorkflowService;
	}

	@Override
	public CalendarWorkflowService getWrappedService() {
		return _calendarWorkflowService;
	}

	@Override
	public void setWrappedService(
		CalendarWorkflowService calendarWorkflowService) {
		_calendarWorkflowService = calendarWorkflowService;
	}

	private CalendarWorkflowService _calendarWorkflowService;
}