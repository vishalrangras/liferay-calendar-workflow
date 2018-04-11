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

package com.ihg.calendar.service.persistence;

import com.ihg.calendar.model.CalendarWorkflow;

import com.liferay.portal.service.persistence.BasePersistence;

/**
 * The persistence interface for the calendar workflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vishal.rangras
 * @see CalendarWorkflowPersistenceImpl
 * @see CalendarWorkflowUtil
 * @generated
 */
public interface CalendarWorkflowPersistence extends BasePersistence<CalendarWorkflow> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CalendarWorkflowUtil} to access the calendar workflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the calendar workflow where calendarWorkflowId = &#63; or throws a {@link com.ihg.calendar.NoSuchCalendarWorkflowException} if it could not be found.
	*
	* @param calendarWorkflowId the calendar workflow ID
	* @return the matching calendar workflow
	* @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow findByCalendarWorkflowId(
		long calendarWorkflowId)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the calendar workflow where calendarWorkflowId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param calendarWorkflowId the calendar workflow ID
	* @return the matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow fetchByCalendarWorkflowId(
		long calendarWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the calendar workflow where calendarWorkflowId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param calendarWorkflowId the calendar workflow ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow fetchByCalendarWorkflowId(
		long calendarWorkflowId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the calendar workflow where calendarWorkflowId = &#63; from the database.
	*
	* @param calendarWorkflowId the calendar workflow ID
	* @return the calendar workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow removeByCalendarWorkflowId(
		long calendarWorkflowId)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of calendar workflows where calendarWorkflowId = &#63;.
	*
	* @param calendarWorkflowId the calendar workflow ID
	* @return the number of matching calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countByCalendarWorkflowId(long calendarWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the calendar workflow where calendarBookingId = &#63; or throws a {@link com.ihg.calendar.NoSuchCalendarWorkflowException} if it could not be found.
	*
	* @param calendarBookingId the calendar booking ID
	* @return the matching calendar workflow
	* @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow findByCalendarBookingId(
		long calendarBookingId)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the calendar workflow where calendarBookingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param calendarBookingId the calendar booking ID
	* @return the matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow fetchByCalendarBookingId(
		long calendarBookingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the calendar workflow where calendarBookingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param calendarBookingId the calendar booking ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow fetchByCalendarBookingId(
		long calendarBookingId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the calendar workflow where calendarBookingId = &#63; from the database.
	*
	* @param calendarBookingId the calendar booking ID
	* @return the calendar workflow that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow removeByCalendarBookingId(
		long calendarBookingId)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of calendar workflows where calendarBookingId = &#63;.
	*
	* @param calendarBookingId the calendar booking ID
	* @return the number of matching calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countByCalendarBookingId(long calendarBookingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the calendar workflows where groupId = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param inTrash the in trash
	* @return the matching calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> findByGroupId(
		long groupId, boolean inTrash)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the calendar workflows where groupId = &#63; and inTrash = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.calendar.model.impl.CalendarWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param inTrash the in trash
	* @param start the lower bound of the range of calendar workflows
	* @param end the upper bound of the range of calendar workflows (not inclusive)
	* @return the range of matching calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> findByGroupId(
		long groupId, boolean inTrash, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the calendar workflows where groupId = &#63; and inTrash = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.calendar.model.impl.CalendarWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param inTrash the in trash
	* @param start the lower bound of the range of calendar workflows
	* @param end the upper bound of the range of calendar workflows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> findByGroupId(
		long groupId, boolean inTrash, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first calendar workflow in the ordered set where groupId = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching calendar workflow
	* @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow findByGroupId_First(
		long groupId, boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first calendar workflow in the ordered set where groupId = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow fetchByGroupId_First(
		long groupId, boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last calendar workflow in the ordered set where groupId = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching calendar workflow
	* @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow findByGroupId_Last(
		long groupId, boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last calendar workflow in the ordered set where groupId = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow fetchByGroupId_Last(
		long groupId, boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the calendar workflows before and after the current calendar workflow in the ordered set where groupId = &#63; and inTrash = &#63;.
	*
	* @param calendarWorkflowId the primary key of the current calendar workflow
	* @param groupId the group ID
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next calendar workflow
	* @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a calendar workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow[] findByGroupId_PrevAndNext(
		long calendarWorkflowId, long groupId, boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the calendar workflows where groupId = &#63; and inTrash = &#63; from the database.
	*
	* @param groupId the group ID
	* @param inTrash the in trash
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId, boolean inTrash)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of calendar workflows where groupId = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param inTrash the in trash
	* @return the number of matching calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId, boolean inTrash)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the calendar workflows where groupId = &#63; and status = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param inTrash the in trash
	* @return the matching calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> findByG_S(
		long groupId, int status, boolean inTrash)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the calendar workflows where groupId = &#63; and status = &#63; and inTrash = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.calendar.model.impl.CalendarWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param inTrash the in trash
	* @param start the lower bound of the range of calendar workflows
	* @param end the upper bound of the range of calendar workflows (not inclusive)
	* @return the range of matching calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> findByG_S(
		long groupId, int status, boolean inTrash, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the calendar workflows where groupId = &#63; and status = &#63; and inTrash = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.calendar.model.impl.CalendarWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param inTrash the in trash
	* @param start the lower bound of the range of calendar workflows
	* @param end the upper bound of the range of calendar workflows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> findByG_S(
		long groupId, int status, boolean inTrash, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first calendar workflow in the ordered set where groupId = &#63; and status = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching calendar workflow
	* @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow findByG_S_First(
		long groupId, int status, boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first calendar workflow in the ordered set where groupId = &#63; and status = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow fetchByG_S_First(
		long groupId, int status, boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last calendar workflow in the ordered set where groupId = &#63; and status = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching calendar workflow
	* @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow findByG_S_Last(
		long groupId, int status, boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last calendar workflow in the ordered set where groupId = &#63; and status = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow fetchByG_S_Last(
		long groupId, int status, boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the calendar workflows before and after the current calendar workflow in the ordered set where groupId = &#63; and status = &#63; and inTrash = &#63;.
	*
	* @param calendarWorkflowId the primary key of the current calendar workflow
	* @param groupId the group ID
	* @param status the status
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next calendar workflow
	* @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a calendar workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow[] findByG_S_PrevAndNext(
		long calendarWorkflowId, long groupId, int status, boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the calendar workflows where groupId = &#63; and status = &#63; and inTrash = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @param inTrash the in trash
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_S(long groupId, int status, boolean inTrash)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of calendar workflows where groupId = &#63; and status = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param inTrash the in trash
	* @return the number of matching calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_S(long groupId, int status, boolean inTrash)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the calendar workflows where groupId = &#63; and status = &#63; and startTime = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param startTime the start time
	* @param inTrash the in trash
	* @return the matching calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> findByG_S_S(
		long groupId, int status, long startTime, boolean inTrash)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the calendar workflows where groupId = &#63; and status = &#63; and startTime = &#63; and inTrash = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.calendar.model.impl.CalendarWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param startTime the start time
	* @param inTrash the in trash
	* @param start the lower bound of the range of calendar workflows
	* @param end the upper bound of the range of calendar workflows (not inclusive)
	* @return the range of matching calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> findByG_S_S(
		long groupId, int status, long startTime, boolean inTrash, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the calendar workflows where groupId = &#63; and status = &#63; and startTime = &#63; and inTrash = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.calendar.model.impl.CalendarWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param startTime the start time
	* @param inTrash the in trash
	* @param start the lower bound of the range of calendar workflows
	* @param end the upper bound of the range of calendar workflows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> findByG_S_S(
		long groupId, int status, long startTime, boolean inTrash, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first calendar workflow in the ordered set where groupId = &#63; and status = &#63; and startTime = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param startTime the start time
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching calendar workflow
	* @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow findByG_S_S_First(
		long groupId, int status, long startTime, boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first calendar workflow in the ordered set where groupId = &#63; and status = &#63; and startTime = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param startTime the start time
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow fetchByG_S_S_First(
		long groupId, int status, long startTime, boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last calendar workflow in the ordered set where groupId = &#63; and status = &#63; and startTime = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param startTime the start time
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching calendar workflow
	* @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow findByG_S_S_Last(
		long groupId, int status, long startTime, boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last calendar workflow in the ordered set where groupId = &#63; and status = &#63; and startTime = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param startTime the start time
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow fetchByG_S_S_Last(
		long groupId, int status, long startTime, boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the calendar workflows before and after the current calendar workflow in the ordered set where groupId = &#63; and status = &#63; and startTime = &#63; and inTrash = &#63;.
	*
	* @param calendarWorkflowId the primary key of the current calendar workflow
	* @param groupId the group ID
	* @param status the status
	* @param startTime the start time
	* @param inTrash the in trash
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next calendar workflow
	* @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a calendar workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow[] findByG_S_S_PrevAndNext(
		long calendarWorkflowId, long groupId, int status, long startTime,
		boolean inTrash,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the calendar workflows where groupId = &#63; and status = &#63; and startTime = &#63; and inTrash = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @param startTime the start time
	* @param inTrash the in trash
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_S_S(long groupId, int status, long startTime,
		boolean inTrash)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of calendar workflows where groupId = &#63; and status = &#63; and startTime = &#63; and inTrash = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @param startTime the start time
	* @param inTrash the in trash
	* @return the number of matching calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_S_S(long groupId, int status, long startTime,
		boolean inTrash)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the calendar workflow in the entity cache if it is enabled.
	*
	* @param calendarWorkflow the calendar workflow
	*/
	public void cacheResult(
		com.ihg.calendar.model.CalendarWorkflow calendarWorkflow);

	/**
	* Caches the calendar workflows in the entity cache if it is enabled.
	*
	* @param calendarWorkflows the calendar workflows
	*/
	public void cacheResult(
		java.util.List<com.ihg.calendar.model.CalendarWorkflow> calendarWorkflows);

	/**
	* Creates a new calendar workflow with the primary key. Does not add the calendar workflow to the database.
	*
	* @param calendarWorkflowId the primary key for the new calendar workflow
	* @return the new calendar workflow
	*/
	public com.ihg.calendar.model.CalendarWorkflow create(
		long calendarWorkflowId);

	/**
	* Removes the calendar workflow with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param calendarWorkflowId the primary key of the calendar workflow
	* @return the calendar workflow that was removed
	* @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a calendar workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow remove(
		long calendarWorkflowId)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.ihg.calendar.model.CalendarWorkflow updateImpl(
		com.ihg.calendar.model.CalendarWorkflow calendarWorkflow)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the calendar workflow with the primary key or throws a {@link com.ihg.calendar.NoSuchCalendarWorkflowException} if it could not be found.
	*
	* @param calendarWorkflowId the primary key of the calendar workflow
	* @return the calendar workflow
	* @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a calendar workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow findByPrimaryKey(
		long calendarWorkflowId)
		throws com.ihg.calendar.NoSuchCalendarWorkflowException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the calendar workflow with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param calendarWorkflowId the primary key of the calendar workflow
	* @return the calendar workflow, or <code>null</code> if a calendar workflow with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.ihg.calendar.model.CalendarWorkflow fetchByPrimaryKey(
		long calendarWorkflowId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the calendar workflows.
	*
	* @return the calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the calendar workflows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.ihg.calendar.model.impl.CalendarWorkflowModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of calendar workflows
	* @param end the upper bound of the range of calendar workflows (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.ihg.calendar.model.CalendarWorkflow> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the calendar workflows from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of calendar workflows.
	*
	* @return the number of calendar workflows
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}