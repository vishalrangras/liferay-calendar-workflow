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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for CalendarWorkflow. This utility wraps
 * {@link com.ihg.calendar.service.impl.CalendarWorkflowLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author vishal.rangras
 * @see CalendarWorkflowLocalService
 * @see com.ihg.calendar.service.base.CalendarWorkflowLocalServiceBaseImpl
 * @see com.ihg.calendar.service.impl.CalendarWorkflowLocalServiceImpl
 * @generated
 */
public class CalendarWorkflowLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.ihg.calendar.service.impl.CalendarWorkflowLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the calendar workflow to the database. Also notifies the appropriate model listeners.
	*
	* @param calendarWorkflow the calendar workflow
	* @return the calendar workflow that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.calendar.model.CalendarWorkflow addCalendarWorkflow(
		com.ihg.calendar.model.CalendarWorkflow calendarWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addCalendarWorkflow(calendarWorkflow);
	}

	/**
	* Creates a new calendar workflow with the primary key. Does not add the calendar workflow to the database.
	*
	* @param calendarWorkflowId the primary key for the new calendar workflow
	* @return the new calendar workflow
	*/
	public static com.ihg.calendar.model.CalendarWorkflow createCalendarWorkflow(
		long calendarWorkflowId) {
		return getService().createCalendarWorkflow(calendarWorkflowId);
	}

	/**
	* Deletes the calendar workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param calendarWorkflowId the primary key of the calendar workflow
	* @return the calendar workflow that was removed
	* @throws PortalException if a calendar workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.calendar.model.CalendarWorkflow deleteCalendarWorkflow(
		long calendarWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCalendarWorkflow(calendarWorkflowId);
	}

	/**
	* Deletes the calendar workflow from the database. Also notifies the appropriate model listeners.
	*
	* @param calendarWorkflow the calendar workflow
	* @return the calendar workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.calendar.model.CalendarWorkflow deleteCalendarWorkflow(
		com.ihg.calendar.model.CalendarWorkflow calendarWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteCalendarWorkflow(calendarWorkflow);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ihg.calendar.model.CalendarWorkflow fetchCalendarWorkflow(
		long calendarWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchCalendarWorkflow(calendarWorkflowId);
	}

	/**
	* Returns the calendar workflow with the primary key.
	*
	* @param calendarWorkflowId the primary key of the calendar workflow
	* @return the calendar workflow
	* @throws PortalException if a calendar workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.calendar.model.CalendarWorkflow getCalendarWorkflow(
		long calendarWorkflowId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getCalendarWorkflow(calendarWorkflowId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.ihg.calendar.model.CalendarWorkflow> getCalendarWorkflows(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCalendarWorkflows(start, end);
	}

	/**
	* Returns the number of calendar workflows.
	*
	* @return the number of calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public static int getCalendarWorkflowsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCalendarWorkflowsCount();
	}

	/**
	* Updates the calendar workflow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param calendarWorkflow the calendar workflow
	* @return the calendar workflow that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.ihg.calendar.model.CalendarWorkflow updateCalendarWorkflow(
		com.ihg.calendar.model.CalendarWorkflow calendarWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateCalendarWorkflow(calendarWorkflow);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.ihg.calendar.model.CalendarWorkflow addCalendarWorkflow(
		long companyId, long groupId, long userId, long calendarBookingId,
		long startTime,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addCalendarWorkflow(companyId, groupId, userId,
			calendarBookingId, startTime, titleMap, serviceContext);
	}

	public static com.ihg.calendar.model.CalendarWorkflow updateCalendarWorkflow(
		long companyId, long groupId, long userId, long calendarBookingId,
		long startTime,
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateCalendarWorkflow(companyId, groupId, userId,
			calendarBookingId, startTime, titleMap, serviceContext);
	}

	public static void moveToTrashCalendarWorkflow(long userId,
		long calendarBookingId,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService()
			.moveToTrashCalendarWorkflow(userId, calendarBookingId,
			serviceContext);
	}

	public static void restoreCalendarWorkflow(long calendarBookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().restoreCalendarWorkflow(calendarBookingId);
	}

	public static void removeCalendarWorkflow(long calendarBookingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getService().removeCalendarWorkflow(calendarBookingId);
	}

	public static com.ihg.calendar.model.CalendarWorkflow updateStatus(
		long userId, long calendarWorkflowId, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, calendarWorkflowId, status,
			serviceContext);
	}

	public static java.util.List<com.ihg.calendar.model.CalendarWorkflow> getCalendarWorkflowByStatus(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCalendarWorkflowByStatus(groupId, status);
	}

	public static java.util.List<com.ihg.calendar.model.CalendarWorkflow> getCalendarWorkflowByStatus(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCalendarWorkflowByStatus(groupId, status, start, end);
	}

	public static int getCalendarWorkflowCountByStatus(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getCalendarWorkflowCountByStatus(groupId, status);
	}

	public static java.util.List<com.ihg.calendar.model.CalendarWorkflow> getCalendarWorkflowByStatusAndStartTime(
		long groupId, int status, long startTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCalendarWorkflowByStatusAndStartTime(groupId, status,
			startTime);
	}

	public static java.util.List<com.ihg.calendar.model.CalendarWorkflow> getCalendarWorkflowByStatusAndStartTime(
		long groupId, int status, long startTime, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCalendarWorkflowByStatusAndStartTime(groupId, status,
			startTime, start, end);
	}

	public static int getCalendarWorkflowCountByStatusAndStartTime(
		long groupId, int status, long startTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getCalendarWorkflowCountByStatusAndStartTime(groupId,
			status, startTime);
	}

	public static java.util.List<com.ihg.calendar.model.CalendarWorkflow> getAllCalendarWorkflowByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCalendarWorkflowByGroupId(groupId);
	}

	public static java.util.List<com.ihg.calendar.model.CalendarWorkflow> getAllCalendarWorkflowByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCalendarWorkflowByGroupId(groupId, start, end);
	}

	public static int getAllCalendarWorkflowCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCalendarWorkflowCountByGroupId(groupId);
	}

	public static java.util.List<com.ihg.calendar.model.CalendarWorkflow> getAllCalendarWorkflow()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCalendarWorkflow();
	}

	public static java.util.List<com.ihg.calendar.model.CalendarWorkflow> getAllCalendarWorkflow(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCalendarWorkflow(start, end);
	}

	public static int getAllCalendarWorkflowCounts()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllCalendarWorkflowCounts();
	}

	public static void clearService() {
		_service = null;
	}

	public static CalendarWorkflowLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					CalendarWorkflowLocalService.class.getName());

			if (invokableLocalService instanceof CalendarWorkflowLocalService) {
				_service = (CalendarWorkflowLocalService)invokableLocalService;
			}
			else {
				_service = new CalendarWorkflowLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(CalendarWorkflowLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(CalendarWorkflowLocalService service) {
	}

	private static CalendarWorkflowLocalService _service;
}