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

package com.ihg.calendar.service.base;

import com.ihg.calendar.model.CalendarWorkflow;
import com.ihg.calendar.service.CalendarWorkflowLocalService;
import com.ihg.calendar.service.persistence.CalendarWorkflowPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the calendar workflow local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ihg.calendar.service.impl.CalendarWorkflowLocalServiceImpl}.
 * </p>
 *
 * @author vishal.rangras
 * @see com.ihg.calendar.service.impl.CalendarWorkflowLocalServiceImpl
 * @see com.ihg.calendar.service.CalendarWorkflowLocalServiceUtil
 * @generated
 */
public abstract class CalendarWorkflowLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements CalendarWorkflowLocalService,
		IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.ihg.calendar.service.CalendarWorkflowLocalServiceUtil} to access the calendar workflow local service.
	 */

	/**
	 * Adds the calendar workflow to the database. Also notifies the appropriate model listeners.
	 *
	 * @param calendarWorkflow the calendar workflow
	 * @return the calendar workflow that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CalendarWorkflow addCalendarWorkflow(
		CalendarWorkflow calendarWorkflow) throws SystemException {
		calendarWorkflow.setNew(true);

		return calendarWorkflowPersistence.update(calendarWorkflow);
	}

	/**
	 * Creates a new calendar workflow with the primary key. Does not add the calendar workflow to the database.
	 *
	 * @param calendarWorkflowId the primary key for the new calendar workflow
	 * @return the new calendar workflow
	 */
	@Override
	public CalendarWorkflow createCalendarWorkflow(long calendarWorkflowId) {
		return calendarWorkflowPersistence.create(calendarWorkflowId);
	}

	/**
	 * Deletes the calendar workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param calendarWorkflowId the primary key of the calendar workflow
	 * @return the calendar workflow that was removed
	 * @throws PortalException if a calendar workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CalendarWorkflow deleteCalendarWorkflow(long calendarWorkflowId)
		throws PortalException, SystemException {
		return calendarWorkflowPersistence.remove(calendarWorkflowId);
	}

	/**
	 * Deletes the calendar workflow from the database. Also notifies the appropriate model listeners.
	 *
	 * @param calendarWorkflow the calendar workflow
	 * @return the calendar workflow that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CalendarWorkflow deleteCalendarWorkflow(
		CalendarWorkflow calendarWorkflow) throws SystemException {
		return calendarWorkflowPersistence.remove(calendarWorkflow);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(CalendarWorkflow.class,
			clazz.getClassLoader());
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
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return calendarWorkflowPersistence.findWithDynamicQuery(dynamicQuery);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return calendarWorkflowPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
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
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return calendarWorkflowPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return calendarWorkflowPersistence.countWithDynamicQuery(dynamicQuery);
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
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return calendarWorkflowPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public CalendarWorkflow fetchCalendarWorkflow(long calendarWorkflowId)
		throws SystemException {
		return calendarWorkflowPersistence.fetchByPrimaryKey(calendarWorkflowId);
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
	public CalendarWorkflow getCalendarWorkflow(long calendarWorkflowId)
		throws PortalException, SystemException {
		return calendarWorkflowPersistence.findByPrimaryKey(calendarWorkflowId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return calendarWorkflowPersistence.findByPrimaryKey(primaryKeyObj);
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
	public List<CalendarWorkflow> getCalendarWorkflows(int start, int end)
		throws SystemException {
		return calendarWorkflowPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of calendar workflows.
	 *
	 * @return the number of calendar workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getCalendarWorkflowsCount() throws SystemException {
		return calendarWorkflowPersistence.countAll();
	}

	/**
	 * Updates the calendar workflow in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param calendarWorkflow the calendar workflow
	 * @return the calendar workflow that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CalendarWorkflow updateCalendarWorkflow(
		CalendarWorkflow calendarWorkflow) throws SystemException {
		return calendarWorkflowPersistence.update(calendarWorkflow);
	}

	/**
	 * Returns the calendar workflow local service.
	 *
	 * @return the calendar workflow local service
	 */
	public com.ihg.calendar.service.CalendarWorkflowLocalService getCalendarWorkflowLocalService() {
		return calendarWorkflowLocalService;
	}

	/**
	 * Sets the calendar workflow local service.
	 *
	 * @param calendarWorkflowLocalService the calendar workflow local service
	 */
	public void setCalendarWorkflowLocalService(
		com.ihg.calendar.service.CalendarWorkflowLocalService calendarWorkflowLocalService) {
		this.calendarWorkflowLocalService = calendarWorkflowLocalService;
	}

	/**
	 * Returns the calendar workflow remote service.
	 *
	 * @return the calendar workflow remote service
	 */
	public com.ihg.calendar.service.CalendarWorkflowService getCalendarWorkflowService() {
		return calendarWorkflowService;
	}

	/**
	 * Sets the calendar workflow remote service.
	 *
	 * @param calendarWorkflowService the calendar workflow remote service
	 */
	public void setCalendarWorkflowService(
		com.ihg.calendar.service.CalendarWorkflowService calendarWorkflowService) {
		this.calendarWorkflowService = calendarWorkflowService;
	}

	/**
	 * Returns the calendar workflow persistence.
	 *
	 * @return the calendar workflow persistence
	 */
	public CalendarWorkflowPersistence getCalendarWorkflowPersistence() {
		return calendarWorkflowPersistence;
	}

	/**
	 * Sets the calendar workflow persistence.
	 *
	 * @param calendarWorkflowPersistence the calendar workflow persistence
	 */
	public void setCalendarWorkflowPersistence(
		CalendarWorkflowPersistence calendarWorkflowPersistence) {
		this.calendarWorkflowPersistence = calendarWorkflowPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.ihg.calendar.model.CalendarWorkflow",
			calendarWorkflowLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.ihg.calendar.model.CalendarWorkflow");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return CalendarWorkflow.class;
	}

	protected String getModelClassName() {
		return CalendarWorkflow.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = calendarWorkflowPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.ihg.calendar.service.CalendarWorkflowLocalService.class)
	protected com.ihg.calendar.service.CalendarWorkflowLocalService calendarWorkflowLocalService;
	@BeanReference(type = com.ihg.calendar.service.CalendarWorkflowService.class)
	protected com.ihg.calendar.service.CalendarWorkflowService calendarWorkflowService;
	@BeanReference(type = CalendarWorkflowPersistence.class)
	protected CalendarWorkflowPersistence calendarWorkflowPersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private CalendarWorkflowLocalServiceClpInvoker _clpInvoker = new CalendarWorkflowLocalServiceClpInvoker();
}