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
 * Provides a wrapper for {@link CalendarWorkflowLocalService}.
 *
 * @author vishal.rangras
 * @see CalendarWorkflowLocalService
 * @generated
 */
public class CalendarWorkflowLocalServiceWrapper
	implements CalendarWorkflowLocalService,
		ServiceWrapper<CalendarWorkflowLocalService> {
	public CalendarWorkflowLocalServiceWrapper(
		CalendarWorkflowLocalService calendarWorkflowLocalService) {
		_calendarWorkflowLocalService = calendarWorkflowLocalService;
	}

	/**
	* Adds the calendar workflow to the database. Also notifies the appropriate model listeners.
	*
	* @param calendarWorkflow the calendar workflow
	* @return the calendar workflow that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.calendar.model.CalendarWorkflow addCalendarWorkflow(
		com.ihg.calendar.model.CalendarWorkflow calendarWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.addCalendarWorkflow(calendarWorkflow);
	}

	/**
	* Creates a new calendar workflow with the primary key. Does not add the calendar workflow to the database.
	*
	* @param calendarWorkflowId the primary key for the new calendar workflow
	* @return the new calendar workflow
	*/
	@Override
	public com.ihg.calendar.model.CalendarWorkflow createCalendarWorkflow(
		long calendarWorkflowId) {
		return _calendarWorkflowLocalService.createCalendarWorkflow(calendarWorkflowId);
	}

	/**
	* Deletes the calendar workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param calendarWorkflowId the primary key of the calendar workflow
	* @return the calendar workflow that was removed
	* @throws PortalException if a calendar workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.calendar.model.CalendarWorkflow deleteCalendarWorkflow(
		long calendarWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.deleteCalendarWorkflow(calendarWorkflowId);
	}

	/**
	* Deletes the calendar workflow from the database. Also notifies the appropriate model listeners.
	*
	* @param calendarWorkflow the calendar workflow
	* @return the calendar workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.calendar.model.CalendarWorkflow deleteCalendarWorkflow(
		com.ihg.calendar.model.CalendarWorkflow calendarWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.deleteCalendarWorkflow(calendarWorkflow);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _calendarWorkflowLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.calendar.model.impl.CalendarWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.calendar.model.impl.CalendarWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.ihg.calendar.model.CalendarWorkflow fetchCalendarWorkflow(
		long calendarWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.fetchCalendarWorkflow(calendarWorkflowId);
	}

	/**
	* Returns the calendar workflow with the primary key.
	*
	* @param calendarWorkflowId the primary key of the calendar workflow
	* @return the calendar workflow
	* @throws PortalException if a calendar workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.calendar.model.CalendarWorkflow getCalendarWorkflow(
		long calendarWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getCalendarWorkflow(calendarWorkflowId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the calendar workflows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.calendar.model.impl.CalendarWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of calendar workflows
	* @param end the upper bound of the range of calendar workflows (not inclusive)
	* @return the range of calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> getCalendarWorkflows(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getCalendarWorkflows(start, end);
	}

	/**
	* Returns the number of calendar workflows.
	*
	* @return the number of calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCalendarWorkflowsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getCalendarWorkflowsCount();
	}

	/**
	* Updates the calendar workflow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param calendarWorkflow the calendar workflow
	* @return the calendar workflow that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.ihg.calendar.model.CalendarWorkflow updateCalendarWorkflow(
		com.ihg.calendar.model.CalendarWorkflow calendarWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.updateCalendarWorkflow(calendarWorkflow);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _calendarWorkflowLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_calendarWorkflowLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _calendarWorkflowLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.ihg.calendar.model.CalendarWorkflow addCalendarWorkflow(
		long companyId, long groupId, long userId, long calendarBookingId,
		long startTime,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.addCalendarWorkflow(companyId,
			groupId, userId, calendarBookingId, startTime, titleMap,
			serviceContext);
	}

	@Override
	public void approveEvent(long companyId, long userId,
		long calendarWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_calendarWorkflowLocalService.approveEvent(companyId, userId,
			calendarWorkflowId);
	}

	@Override
	public void rejectEvent(long companyId, long userId, long calendarWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_calendarWorkflowLocalService.rejectEvent(companyId, userId,
			calendarWorkflowId);
	}

	@Override
	public com.ihg.calendar.model.CalendarWorkflow updateCalendarWorkflow(
		long companyId, long groupId, long userId, long calendarBookingId,
		long startTime,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.updateCalendarWorkflow(companyId,
			groupId, userId, calendarBookingId, startTime, titleMap,
			serviceContext);
	}

	@Override
	public void moveToTrashCalendarWorkflow(long userId,
		long calendarBookingId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		_calendarWorkflowLocalService.moveToTrashCalendarWorkflow(userId,
			calendarBookingId, serviceContext);
	}

	@Override
	public void restoreCalendarWorkflow(long calendarBookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_calendarWorkflowLocalService.restoreCalendarWorkflow(calendarBookingId);
	}

	@Override
	public void removeCalendarWorkflow(long calendarBookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		_calendarWorkflowLocalService.removeCalendarWorkflow(calendarBookingId);
	}

	@Override
	public com.ihg.calendar.model.CalendarWorkflow updateStatus(long userId,
		long calendarWorkflowId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.updateStatus(userId,
			calendarWorkflowId, status, serviceContext);
	}

	@Override
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> getCalendarWorkflowByStatus(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getCalendarWorkflowByStatus(groupId,
			status);
	}

	@Override
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> getCalendarWorkflowByStatus(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getCalendarWorkflowByStatus(groupId,
			status, start, end);
	}

	@Override
	public int getCalendarWorkflowCountByStatus(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getCalendarWorkflowCountByStatus(groupId,
			status);
	}

	@Override
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> getCalendarWorkflowByStatusAndStartTime(
		long groupId, int status, long startTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getCalendarWorkflowByStatusAndStartTime(groupId,
			status, startTime);
	}

	@Override
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> getCalendarWorkflowByStatusAndStartTime(
		long groupId, int status, long startTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getCalendarWorkflowByStatusAndStartTime(groupId,
			status, startTime, start, end);
	}

	@Override
	public int getCalendarWorkflowCountByStatusAndStartTime(long groupId,
		int status, long startTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getCalendarWorkflowCountByStatusAndStartTime(groupId,
			status, startTime);
	}

	@Override
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> getAllCalendarWorkflowByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getAllCalendarWorkflowByGroupId(groupId);
	}

	@Override
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> getAllCalendarWorkflowByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getAllCalendarWorkflowByGroupId(groupId,
			start, end);
	}

	@Override
	public int getAllCalendarWorkflowCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getAllCalendarWorkflowCountByGroupId(groupId);
	}

	@Override
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> getAllCalendarWorkflow()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getAllCalendarWorkflow();
	}

	@Override
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> getAllCalendarWorkflow(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getAllCalendarWorkflow(start, end);
	}

	@Override
	public int getAllCalendarWorkflowCounts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflowLocalService.getAllCalendarWorkflowCounts();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CalendarWorkflowLocalService getWrappedCalendarWorkflowLocalService() {
		return _calendarWorkflowLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCalendarWorkflowLocalService(
		CalendarWorkflowLocalService calendarWorkflowLocalService) {
		_calendarWorkflowLocalService = calendarWorkflowLocalService;
	}

	@Override
	public CalendarWorkflowLocalService getWrappedService() {
		return _calendarWorkflowLocalService;
	}

	@Override
	public void setWrappedService(
		CalendarWorkflowLocalService calendarWorkflowLocalService) {
		_calendarWorkflowLocalService = calendarWorkflowLocalService;
	}

	private CalendarWorkflowLocalService _calendarWorkflowLocalService;
}