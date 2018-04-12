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

import com.ihg.calendar.NoSuchCalendarWorkflowException;
import com.ihg.calendar.model.CalendarWorkflow;
import com.ihg.calendar.model.impl.CalendarWorkflowImpl;
import com.ihg.calendar.model.impl.CalendarWorkflowModelImpl;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the calendar workflow service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author vishal.rangras
 * @see CalendarWorkflowPersistence
 * @see CalendarWorkflowUtil
 * @generated
 */
public class CalendarWorkflowPersistenceImpl extends BasePersistenceImpl<CalendarWorkflow>
	implements CalendarWorkflowPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link CalendarWorkflowUtil} to access the calendar workflow persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = CalendarWorkflowImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED,
			CalendarWorkflowImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED,
			CalendarWorkflowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_CALENDARWORKFLOWID = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED,
			CalendarWorkflowImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCalendarWorkflowId", new String[] { Long.class.getName() },
			CalendarWorkflowModelImpl.CALENDARWORKFLOWID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CALENDARWORKFLOWID = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCalendarWorkflowId", new String[] { Long.class.getName() });

	/**
	 * Returns the calendar workflow where calendarWorkflowId = &#63; or throws a {@link com.ihg.calendar.NoSuchCalendarWorkflowException} if it could not be found.
	 *
	 * @param calendarWorkflowId the calendar workflow ID
	 * @return the matching calendar workflow
	 * @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a matching calendar workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow findByCalendarWorkflowId(long calendarWorkflowId)
		throws NoSuchCalendarWorkflowException, SystemException {
		CalendarWorkflow calendarWorkflow = fetchByCalendarWorkflowId(calendarWorkflowId);

		if (calendarWorkflow == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("calendarWorkflowId=");
			msg.append(calendarWorkflowId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCalendarWorkflowException(msg.toString());
		}

		return calendarWorkflow;
	}

	/**
	 * Returns the calendar workflow where calendarWorkflowId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param calendarWorkflowId the calendar workflow ID
	 * @return the matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow fetchByCalendarWorkflowId(long calendarWorkflowId)
		throws SystemException {
		return fetchByCalendarWorkflowId(calendarWorkflowId, true);
	}

	/**
	 * Returns the calendar workflow where calendarWorkflowId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param calendarWorkflowId the calendar workflow ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow fetchByCalendarWorkflowId(long calendarWorkflowId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { calendarWorkflowId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CALENDARWORKFLOWID,
					finderArgs, this);
		}

		if (result instanceof CalendarWorkflow) {
			CalendarWorkflow calendarWorkflow = (CalendarWorkflow)result;

			if ((calendarWorkflowId != calendarWorkflow.getCalendarWorkflowId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CALENDARWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_CALENDARWORKFLOWID_CALENDARWORKFLOWID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(calendarWorkflowId);

				List<CalendarWorkflow> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CALENDARWORKFLOWID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CalendarWorkflowPersistenceImpl.fetchByCalendarWorkflowId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CalendarWorkflow calendarWorkflow = list.get(0);

					result = calendarWorkflow;

					cacheResult(calendarWorkflow);

					if ((calendarWorkflow.getCalendarWorkflowId() != calendarWorkflowId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CALENDARWORKFLOWID,
							finderArgs, calendarWorkflow);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CALENDARWORKFLOWID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CalendarWorkflow)result;
		}
	}

	/**
	 * Removes the calendar workflow where calendarWorkflowId = &#63; from the database.
	 *
	 * @param calendarWorkflowId the calendar workflow ID
	 * @return the calendar workflow that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow removeByCalendarWorkflowId(long calendarWorkflowId)
		throws NoSuchCalendarWorkflowException, SystemException {
		CalendarWorkflow calendarWorkflow = findByCalendarWorkflowId(calendarWorkflowId);

		return remove(calendarWorkflow);
	}

	/**
	 * Returns the number of calendar workflows where calendarWorkflowId = &#63;.
	 *
	 * @param calendarWorkflowId the calendar workflow ID
	 * @return the number of matching calendar workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCalendarWorkflowId(long calendarWorkflowId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CALENDARWORKFLOWID;

		Object[] finderArgs = new Object[] { calendarWorkflowId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CALENDARWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_CALENDARWORKFLOWID_CALENDARWORKFLOWID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(calendarWorkflowId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CALENDARWORKFLOWID_CALENDARWORKFLOWID_2 =
		"calendarWorkflow.calendarWorkflowId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_CALENDARBOOKINGID = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED,
			CalendarWorkflowImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByCalendarBookingId", new String[] { Long.class.getName() },
			CalendarWorkflowModelImpl.CALENDARBOOKINGID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_CALENDARBOOKINGID = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCalendarBookingId", new String[] { Long.class.getName() });

	/**
	 * Returns the calendar workflow where calendarBookingId = &#63; or throws a {@link com.ihg.calendar.NoSuchCalendarWorkflowException} if it could not be found.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the matching calendar workflow
	 * @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a matching calendar workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow findByCalendarBookingId(long calendarBookingId)
		throws NoSuchCalendarWorkflowException, SystemException {
		CalendarWorkflow calendarWorkflow = fetchByCalendarBookingId(calendarBookingId);

		if (calendarWorkflow == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("calendarBookingId=");
			msg.append(calendarBookingId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchCalendarWorkflowException(msg.toString());
		}

		return calendarWorkflow;
	}

	/**
	 * Returns the calendar workflow where calendarBookingId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow fetchByCalendarBookingId(long calendarBookingId)
		throws SystemException {
		return fetchByCalendarBookingId(calendarBookingId, true);
	}

	/**
	 * Returns the calendar workflow where calendarBookingId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow fetchByCalendarBookingId(long calendarBookingId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { calendarBookingId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_CALENDARBOOKINGID,
					finderArgs, this);
		}

		if (result instanceof CalendarWorkflow) {
			CalendarWorkflow calendarWorkflow = (CalendarWorkflow)result;

			if ((calendarBookingId != calendarWorkflow.getCalendarBookingId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_CALENDARWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_CALENDARBOOKINGID_CALENDARBOOKINGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(calendarBookingId);

				List<CalendarWorkflow> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CALENDARBOOKINGID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"CalendarWorkflowPersistenceImpl.fetchByCalendarBookingId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					CalendarWorkflow calendarWorkflow = list.get(0);

					result = calendarWorkflow;

					cacheResult(calendarWorkflow);

					if ((calendarWorkflow.getCalendarBookingId() != calendarBookingId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CALENDARBOOKINGID,
							finderArgs, calendarWorkflow);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CALENDARBOOKINGID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (CalendarWorkflow)result;
		}
	}

	/**
	 * Removes the calendar workflow where calendarBookingId = &#63; from the database.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the calendar workflow that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow removeByCalendarBookingId(long calendarBookingId)
		throws NoSuchCalendarWorkflowException, SystemException {
		CalendarWorkflow calendarWorkflow = findByCalendarBookingId(calendarBookingId);

		return remove(calendarWorkflow);
	}

	/**
	 * Returns the number of calendar workflows where calendarBookingId = &#63;.
	 *
	 * @param calendarBookingId the calendar booking ID
	 * @return the number of matching calendar workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCalendarBookingId(long calendarBookingId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_CALENDARBOOKINGID;

		Object[] finderArgs = new Object[] { calendarBookingId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_CALENDARWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_CALENDARBOOKINGID_CALENDARBOOKINGID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(calendarBookingId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CALENDARBOOKINGID_CALENDARBOOKINGID_2 =
		"calendarWorkflow.calendarBookingId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED,
			CalendarWorkflowImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByGroupId",
			new String[] {
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED,
			CalendarWorkflowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName(), Boolean.class.getName() },
			CalendarWorkflowModelImpl.GROUPID_COLUMN_BITMASK |
			CalendarWorkflowModelImpl.INTRASH_COLUMN_BITMASK |
			CalendarWorkflowModelImpl.STARTTIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName(), Boolean.class.getName() });

	/**
	 * Returns all the calendar workflows where groupId = &#63; and inTrash = &#63;.
	 *
	 * @param groupId the group ID
	 * @param inTrash the in trash
	 * @return the matching calendar workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CalendarWorkflow> findByGroupId(long groupId, boolean inTrash)
		throws SystemException {
		return findByGroupId(groupId, inTrash, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CalendarWorkflow> findByGroupId(long groupId, boolean inTrash,
		int start, int end) throws SystemException {
		return findByGroupId(groupId, inTrash, start, end, null);
	}

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
	@Override
	public List<CalendarWorkflow> findByGroupId(long groupId, boolean inTrash,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, inTrash };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] {
					groupId, inTrash,
					
					start, end, orderByComparator
				};
		}

		List<CalendarWorkflow> list = (List<CalendarWorkflow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CalendarWorkflow calendarWorkflow : list) {
				if ((groupId != calendarWorkflow.getGroupId()) ||
						(inTrash != calendarWorkflow.getInTrash())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_CALENDARWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_INTRASH_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CalendarWorkflowModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(inTrash);

				if (!pagination) {
					list = (List<CalendarWorkflow>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CalendarWorkflow>(list);
				}
				else {
					list = (List<CalendarWorkflow>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

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
	@Override
	public CalendarWorkflow findByGroupId_First(long groupId, boolean inTrash,
		OrderByComparator orderByComparator)
		throws NoSuchCalendarWorkflowException, SystemException {
		CalendarWorkflow calendarWorkflow = fetchByGroupId_First(groupId,
				inTrash, orderByComparator);

		if (calendarWorkflow != null) {
			return calendarWorkflow;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", inTrash=");
		msg.append(inTrash);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCalendarWorkflowException(msg.toString());
	}

	/**
	 * Returns the first calendar workflow in the ordered set where groupId = &#63; and inTrash = &#63;.
	 *
	 * @param groupId the group ID
	 * @param inTrash the in trash
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow fetchByGroupId_First(long groupId, boolean inTrash,
		OrderByComparator orderByComparator) throws SystemException {
		List<CalendarWorkflow> list = findByGroupId(groupId, inTrash, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CalendarWorkflow findByGroupId_Last(long groupId, boolean inTrash,
		OrderByComparator orderByComparator)
		throws NoSuchCalendarWorkflowException, SystemException {
		CalendarWorkflow calendarWorkflow = fetchByGroupId_Last(groupId,
				inTrash, orderByComparator);

		if (calendarWorkflow != null) {
			return calendarWorkflow;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", inTrash=");
		msg.append(inTrash);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCalendarWorkflowException(msg.toString());
	}

	/**
	 * Returns the last calendar workflow in the ordered set where groupId = &#63; and inTrash = &#63;.
	 *
	 * @param groupId the group ID
	 * @param inTrash the in trash
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching calendar workflow, or <code>null</code> if a matching calendar workflow could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow fetchByGroupId_Last(long groupId, boolean inTrash,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId, inTrash);

		if (count == 0) {
			return null;
		}

		List<CalendarWorkflow> list = findByGroupId(groupId, inTrash,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CalendarWorkflow[] findByGroupId_PrevAndNext(
		long calendarWorkflowId, long groupId, boolean inTrash,
		OrderByComparator orderByComparator)
		throws NoSuchCalendarWorkflowException, SystemException {
		CalendarWorkflow calendarWorkflow = findByPrimaryKey(calendarWorkflowId);

		Session session = null;

		try {
			session = openSession();

			CalendarWorkflow[] array = new CalendarWorkflowImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, calendarWorkflow,
					groupId, inTrash, orderByComparator, true);

			array[1] = calendarWorkflow;

			array[2] = getByGroupId_PrevAndNext(session, calendarWorkflow,
					groupId, inTrash, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CalendarWorkflow getByGroupId_PrevAndNext(Session session,
		CalendarWorkflow calendarWorkflow, long groupId, boolean inTrash,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CALENDARWORKFLOW_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUPID_INTRASH_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CalendarWorkflowModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(inTrash);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(calendarWorkflow);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CalendarWorkflow> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the calendar workflows where groupId = &#63; and inTrash = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param inTrash the in trash
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId, boolean inTrash)
		throws SystemException {
		for (CalendarWorkflow calendarWorkflow : findByGroupId(groupId,
				inTrash, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(calendarWorkflow);
		}
	}

	/**
	 * Returns the number of calendar workflows where groupId = &#63; and inTrash = &#63;.
	 *
	 * @param groupId the group ID
	 * @param inTrash the in trash
	 * @return the number of matching calendar workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId, boolean inTrash)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId, inTrash };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_CALENDARWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUPID_INTRASH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(inTrash);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "calendarWorkflow.groupId = ? AND ";
	private static final String _FINDER_COLUMN_GROUPID_INTRASH_2 = "calendarWorkflow.inTrash = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED,
			CalendarWorkflowImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED,
			CalendarWorkflowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName()
			},
			CalendarWorkflowModelImpl.GROUPID_COLUMN_BITMASK |
			CalendarWorkflowModelImpl.STATUS_COLUMN_BITMASK |
			CalendarWorkflowModelImpl.INTRASH_COLUMN_BITMASK |
			CalendarWorkflowModelImpl.STARTTIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Boolean.class.getName()
			});

	/**
	 * Returns all the calendar workflows where groupId = &#63; and status = &#63; and inTrash = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param inTrash the in trash
	 * @return the matching calendar workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CalendarWorkflow> findByG_S(long groupId, int status,
		boolean inTrash) throws SystemException {
		return findByG_S(groupId, status, inTrash, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CalendarWorkflow> findByG_S(long groupId, int status,
		boolean inTrash, int start, int end) throws SystemException {
		return findByG_S(groupId, status, inTrash, start, end, null);
	}

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
	@Override
	public List<CalendarWorkflow> findByG_S(long groupId, int status,
		boolean inTrash, int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] { groupId, status, inTrash };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S;
			finderArgs = new Object[] {
					groupId, status, inTrash,
					
					start, end, orderByComparator
				};
		}

		List<CalendarWorkflow> list = (List<CalendarWorkflow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CalendarWorkflow calendarWorkflow : list) {
				if ((groupId != calendarWorkflow.getGroupId()) ||
						(status != calendarWorkflow.getStatus()) ||
						(inTrash != calendarWorkflow.getInTrash())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_CALENDARWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STATUS_2);

			query.append(_FINDER_COLUMN_G_S_INTRASH_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CalendarWorkflowModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				qPos.add(inTrash);

				if (!pagination) {
					list = (List<CalendarWorkflow>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CalendarWorkflow>(list);
				}
				else {
					list = (List<CalendarWorkflow>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

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
	@Override
	public CalendarWorkflow findByG_S_First(long groupId, int status,
		boolean inTrash, OrderByComparator orderByComparator)
		throws NoSuchCalendarWorkflowException, SystemException {
		CalendarWorkflow calendarWorkflow = fetchByG_S_First(groupId, status,
				inTrash, orderByComparator);

		if (calendarWorkflow != null) {
			return calendarWorkflow;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", inTrash=");
		msg.append(inTrash);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCalendarWorkflowException(msg.toString());
	}

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
	@Override
	public CalendarWorkflow fetchByG_S_First(long groupId, int status,
		boolean inTrash, OrderByComparator orderByComparator)
		throws SystemException {
		List<CalendarWorkflow> list = findByG_S(groupId, status, inTrash, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CalendarWorkflow findByG_S_Last(long groupId, int status,
		boolean inTrash, OrderByComparator orderByComparator)
		throws NoSuchCalendarWorkflowException, SystemException {
		CalendarWorkflow calendarWorkflow = fetchByG_S_Last(groupId, status,
				inTrash, orderByComparator);

		if (calendarWorkflow != null) {
			return calendarWorkflow;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", inTrash=");
		msg.append(inTrash);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCalendarWorkflowException(msg.toString());
	}

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
	@Override
	public CalendarWorkflow fetchByG_S_Last(long groupId, int status,
		boolean inTrash, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_S(groupId, status, inTrash);

		if (count == 0) {
			return null;
		}

		List<CalendarWorkflow> list = findByG_S(groupId, status, inTrash,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CalendarWorkflow[] findByG_S_PrevAndNext(long calendarWorkflowId,
		long groupId, int status, boolean inTrash,
		OrderByComparator orderByComparator)
		throws NoSuchCalendarWorkflowException, SystemException {
		CalendarWorkflow calendarWorkflow = findByPrimaryKey(calendarWorkflowId);

		Session session = null;

		try {
			session = openSession();

			CalendarWorkflow[] array = new CalendarWorkflowImpl[3];

			array[0] = getByG_S_PrevAndNext(session, calendarWorkflow, groupId,
					status, inTrash, orderByComparator, true);

			array[1] = calendarWorkflow;

			array[2] = getByG_S_PrevAndNext(session, calendarWorkflow, groupId,
					status, inTrash, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CalendarWorkflow getByG_S_PrevAndNext(Session session,
		CalendarWorkflow calendarWorkflow, long groupId, int status,
		boolean inTrash, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CALENDARWORKFLOW_WHERE);

		query.append(_FINDER_COLUMN_G_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_STATUS_2);

		query.append(_FINDER_COLUMN_G_S_INTRASH_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CalendarWorkflowModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		qPos.add(inTrash);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(calendarWorkflow);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CalendarWorkflow> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the calendar workflows where groupId = &#63; and status = &#63; and inTrash = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param inTrash the in trash
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_S(long groupId, int status, boolean inTrash)
		throws SystemException {
		for (CalendarWorkflow calendarWorkflow : findByG_S(groupId, status,
				inTrash, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(calendarWorkflow);
		}
	}

	/**
	 * Returns the number of calendar workflows where groupId = &#63; and status = &#63; and inTrash = &#63;.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param inTrash the in trash
	 * @return the number of matching calendar workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByG_S(long groupId, int status, boolean inTrash)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S;

		Object[] finderArgs = new Object[] { groupId, status, inTrash };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_CALENDARWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_G_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_STATUS_2);

			query.append(_FINDER_COLUMN_G_S_INTRASH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				qPos.add(inTrash);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_S_GROUPID_2 = "calendarWorkflow.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_S_STATUS_2 = "calendarWorkflow.status = ? AND ";
	private static final String _FINDER_COLUMN_G_S_INTRASH_2 = "calendarWorkflow.inTrash = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S_S = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED,
			CalendarWorkflowImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByG_S_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), Boolean.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_S = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED,
			CalendarWorkflowImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByG_S_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			},
			CalendarWorkflowModelImpl.GROUPID_COLUMN_BITMASK |
			CalendarWorkflowModelImpl.STATUS_COLUMN_BITMASK |
			CalendarWorkflowModelImpl.STARTTIME_COLUMN_BITMASK |
			CalendarWorkflowModelImpl.INTRASH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_G_S_S = new FinderPath(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByG_S_S",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(), Boolean.class.getName()
			});

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
	@Override
	public List<CalendarWorkflow> findByG_S_S(long groupId, int status,
		long startTime, boolean inTrash) throws SystemException {
		return findByG_S_S(groupId, status, startTime, inTrash,
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<CalendarWorkflow> findByG_S_S(long groupId, int status,
		long startTime, boolean inTrash, int start, int end)
		throws SystemException {
		return findByG_S_S(groupId, status, startTime, inTrash, start, end, null);
	}

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
	@Override
	public List<CalendarWorkflow> findByG_S_S(long groupId, int status,
		long startTime, boolean inTrash, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_S;
			finderArgs = new Object[] { groupId, status, startTime, inTrash };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_G_S_S;
			finderArgs = new Object[] {
					groupId, status, startTime, inTrash,
					
					start, end, orderByComparator
				};
		}

		List<CalendarWorkflow> list = (List<CalendarWorkflow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (CalendarWorkflow calendarWorkflow : list) {
				if ((groupId != calendarWorkflow.getGroupId()) ||
						(status != calendarWorkflow.getStatus()) ||
						(startTime != calendarWorkflow.getStartTime()) ||
						(inTrash != calendarWorkflow.getInTrash())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(6 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(6);
			}

			query.append(_SQL_SELECT_CALENDARWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_G_S_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_S_STATUS_2);

			query.append(_FINDER_COLUMN_G_S_S_STARTTIME_2);

			query.append(_FINDER_COLUMN_G_S_S_INTRASH_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(CalendarWorkflowModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				qPos.add(startTime);

				qPos.add(inTrash);

				if (!pagination) {
					list = (List<CalendarWorkflow>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CalendarWorkflow>(list);
				}
				else {
					list = (List<CalendarWorkflow>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

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
	@Override
	public CalendarWorkflow findByG_S_S_First(long groupId, int status,
		long startTime, boolean inTrash, OrderByComparator orderByComparator)
		throws NoSuchCalendarWorkflowException, SystemException {
		CalendarWorkflow calendarWorkflow = fetchByG_S_S_First(groupId, status,
				startTime, inTrash, orderByComparator);

		if (calendarWorkflow != null) {
			return calendarWorkflow;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", startTime=");
		msg.append(startTime);

		msg.append(", inTrash=");
		msg.append(inTrash);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCalendarWorkflowException(msg.toString());
	}

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
	@Override
	public CalendarWorkflow fetchByG_S_S_First(long groupId, int status,
		long startTime, boolean inTrash, OrderByComparator orderByComparator)
		throws SystemException {
		List<CalendarWorkflow> list = findByG_S_S(groupId, status, startTime,
				inTrash, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CalendarWorkflow findByG_S_S_Last(long groupId, int status,
		long startTime, boolean inTrash, OrderByComparator orderByComparator)
		throws NoSuchCalendarWorkflowException, SystemException {
		CalendarWorkflow calendarWorkflow = fetchByG_S_S_Last(groupId, status,
				startTime, inTrash, orderByComparator);

		if (calendarWorkflow != null) {
			return calendarWorkflow;
		}

		StringBundler msg = new StringBundler(10);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", startTime=");
		msg.append(startTime);

		msg.append(", inTrash=");
		msg.append(inTrash);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchCalendarWorkflowException(msg.toString());
	}

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
	@Override
	public CalendarWorkflow fetchByG_S_S_Last(long groupId, int status,
		long startTime, boolean inTrash, OrderByComparator orderByComparator)
		throws SystemException {
		int count = countByG_S_S(groupId, status, startTime, inTrash);

		if (count == 0) {
			return null;
		}

		List<CalendarWorkflow> list = findByG_S_S(groupId, status, startTime,
				inTrash, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public CalendarWorkflow[] findByG_S_S_PrevAndNext(long calendarWorkflowId,
		long groupId, int status, long startTime, boolean inTrash,
		OrderByComparator orderByComparator)
		throws NoSuchCalendarWorkflowException, SystemException {
		CalendarWorkflow calendarWorkflow = findByPrimaryKey(calendarWorkflowId);

		Session session = null;

		try {
			session = openSession();

			CalendarWorkflow[] array = new CalendarWorkflowImpl[3];

			array[0] = getByG_S_S_PrevAndNext(session, calendarWorkflow,
					groupId, status, startTime, inTrash, orderByComparator, true);

			array[1] = calendarWorkflow;

			array[2] = getByG_S_S_PrevAndNext(session, calendarWorkflow,
					groupId, status, startTime, inTrash, orderByComparator,
					false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected CalendarWorkflow getByG_S_S_PrevAndNext(Session session,
		CalendarWorkflow calendarWorkflow, long groupId, int status,
		long startTime, boolean inTrash, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_CALENDARWORKFLOW_WHERE);

		query.append(_FINDER_COLUMN_G_S_S_GROUPID_2);

		query.append(_FINDER_COLUMN_G_S_S_STATUS_2);

		query.append(_FINDER_COLUMN_G_S_S_STARTTIME_2);

		query.append(_FINDER_COLUMN_G_S_S_INTRASH_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(CalendarWorkflowModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(status);

		qPos.add(startTime);

		qPos.add(inTrash);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(calendarWorkflow);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<CalendarWorkflow> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the calendar workflows where groupId = &#63; and status = &#63; and startTime = &#63; and inTrash = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param status the status
	 * @param startTime the start time
	 * @param inTrash the in trash
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByG_S_S(long groupId, int status, long startTime,
		boolean inTrash) throws SystemException {
		for (CalendarWorkflow calendarWorkflow : findByG_S_S(groupId, status,
				startTime, inTrash, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(calendarWorkflow);
		}
	}

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
	@Override
	public int countByG_S_S(long groupId, int status, long startTime,
		boolean inTrash) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_G_S_S;

		Object[] finderArgs = new Object[] { groupId, status, startTime, inTrash };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_COUNT_CALENDARWORKFLOW_WHERE);

			query.append(_FINDER_COLUMN_G_S_S_GROUPID_2);

			query.append(_FINDER_COLUMN_G_S_S_STATUS_2);

			query.append(_FINDER_COLUMN_G_S_S_STARTTIME_2);

			query.append(_FINDER_COLUMN_G_S_S_INTRASH_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(status);

				qPos.add(startTime);

				qPos.add(inTrash);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_G_S_S_GROUPID_2 = "calendarWorkflow.groupId = ? AND ";
	private static final String _FINDER_COLUMN_G_S_S_STATUS_2 = "calendarWorkflow.status = ? AND ";
	private static final String _FINDER_COLUMN_G_S_S_STARTTIME_2 = "calendarWorkflow.startTime = ? AND ";
	private static final String _FINDER_COLUMN_G_S_S_INTRASH_2 = "calendarWorkflow.inTrash = ?";

	public CalendarWorkflowPersistenceImpl() {
		setModelClass(CalendarWorkflow.class);
	}

	/**
	 * Caches the calendar workflow in the entity cache if it is enabled.
	 *
	 * @param calendarWorkflow the calendar workflow
	 */
	@Override
	public void cacheResult(CalendarWorkflow calendarWorkflow) {
		EntityCacheUtil.putResult(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowImpl.class, calendarWorkflow.getPrimaryKey(),
			calendarWorkflow);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CALENDARWORKFLOWID,
			new Object[] { calendarWorkflow.getCalendarWorkflowId() },
			calendarWorkflow);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CALENDARBOOKINGID,
			new Object[] { calendarWorkflow.getCalendarBookingId() },
			calendarWorkflow);

		calendarWorkflow.resetOriginalValues();
	}

	/**
	 * Caches the calendar workflows in the entity cache if it is enabled.
	 *
	 * @param calendarWorkflows the calendar workflows
	 */
	@Override
	public void cacheResult(List<CalendarWorkflow> calendarWorkflows) {
		for (CalendarWorkflow calendarWorkflow : calendarWorkflows) {
			if (EntityCacheUtil.getResult(
						CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
						CalendarWorkflowImpl.class,
						calendarWorkflow.getPrimaryKey()) == null) {
				cacheResult(calendarWorkflow);
			}
			else {
				calendarWorkflow.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all calendar workflows.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(CalendarWorkflowImpl.class.getName());
		}

		EntityCacheUtil.clearCache(CalendarWorkflowImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the calendar workflow.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CalendarWorkflow calendarWorkflow) {
		EntityCacheUtil.removeResult(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowImpl.class, calendarWorkflow.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(calendarWorkflow);
	}

	@Override
	public void clearCache(List<CalendarWorkflow> calendarWorkflows) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (CalendarWorkflow calendarWorkflow : calendarWorkflows) {
			EntityCacheUtil.removeResult(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
				CalendarWorkflowImpl.class, calendarWorkflow.getPrimaryKey());

			clearUniqueFindersCache(calendarWorkflow);
		}
	}

	protected void cacheUniqueFindersCache(CalendarWorkflow calendarWorkflow) {
		if (calendarWorkflow.isNew()) {
			Object[] args = new Object[] {
					calendarWorkflow.getCalendarWorkflowId()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CALENDARWORKFLOWID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CALENDARWORKFLOWID,
				args, calendarWorkflow);

			args = new Object[] { calendarWorkflow.getCalendarBookingId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CALENDARBOOKINGID,
				args, Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CALENDARBOOKINGID,
				args, calendarWorkflow);
		}
		else {
			CalendarWorkflowModelImpl calendarWorkflowModelImpl = (CalendarWorkflowModelImpl)calendarWorkflow;

			if ((calendarWorkflowModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CALENDARWORKFLOWID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						calendarWorkflow.getCalendarWorkflowId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CALENDARWORKFLOWID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CALENDARWORKFLOWID,
					args, calendarWorkflow);
			}

			if ((calendarWorkflowModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_CALENDARBOOKINGID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						calendarWorkflow.getCalendarBookingId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_CALENDARBOOKINGID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_CALENDARBOOKINGID,
					args, calendarWorkflow);
			}
		}
	}

	protected void clearUniqueFindersCache(CalendarWorkflow calendarWorkflow) {
		CalendarWorkflowModelImpl calendarWorkflowModelImpl = (CalendarWorkflowModelImpl)calendarWorkflow;

		Object[] args = new Object[] { calendarWorkflow.getCalendarWorkflowId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CALENDARWORKFLOWID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CALENDARWORKFLOWID,
			args);

		if ((calendarWorkflowModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CALENDARWORKFLOWID.getColumnBitmask()) != 0) {
			args = new Object[] {
					calendarWorkflowModelImpl.getOriginalCalendarWorkflowId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CALENDARWORKFLOWID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CALENDARWORKFLOWID,
				args);
		}

		args = new Object[] { calendarWorkflow.getCalendarBookingId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CALENDARBOOKINGID,
			args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CALENDARBOOKINGID,
			args);

		if ((calendarWorkflowModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_CALENDARBOOKINGID.getColumnBitmask()) != 0) {
			args = new Object[] {
					calendarWorkflowModelImpl.getOriginalCalendarBookingId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_CALENDARBOOKINGID,
				args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_CALENDARBOOKINGID,
				args);
		}
	}

	/**
	 * Creates a new calendar workflow with the primary key. Does not add the calendar workflow to the database.
	 *
	 * @param calendarWorkflowId the primary key for the new calendar workflow
	 * @return the new calendar workflow
	 */
	@Override
	public CalendarWorkflow create(long calendarWorkflowId) {
		CalendarWorkflow calendarWorkflow = new CalendarWorkflowImpl();

		calendarWorkflow.setNew(true);
		calendarWorkflow.setPrimaryKey(calendarWorkflowId);

		return calendarWorkflow;
	}

	/**
	 * Removes the calendar workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param calendarWorkflowId the primary key of the calendar workflow
	 * @return the calendar workflow that was removed
	 * @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a calendar workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow remove(long calendarWorkflowId)
		throws NoSuchCalendarWorkflowException, SystemException {
		return remove((Serializable)calendarWorkflowId);
	}

	/**
	 * Removes the calendar workflow with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the calendar workflow
	 * @return the calendar workflow that was removed
	 * @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a calendar workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow remove(Serializable primaryKey)
		throws NoSuchCalendarWorkflowException, SystemException {
		Session session = null;

		try {
			session = openSession();

			CalendarWorkflow calendarWorkflow = (CalendarWorkflow)session.get(CalendarWorkflowImpl.class,
					primaryKey);

			if (calendarWorkflow == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCalendarWorkflowException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(calendarWorkflow);
		}
		catch (NoSuchCalendarWorkflowException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected CalendarWorkflow removeImpl(CalendarWorkflow calendarWorkflow)
		throws SystemException {
		calendarWorkflow = toUnwrappedModel(calendarWorkflow);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(calendarWorkflow)) {
				calendarWorkflow = (CalendarWorkflow)session.get(CalendarWorkflowImpl.class,
						calendarWorkflow.getPrimaryKeyObj());
			}

			if (calendarWorkflow != null) {
				session.delete(calendarWorkflow);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (calendarWorkflow != null) {
			clearCache(calendarWorkflow);
		}

		return calendarWorkflow;
	}

	@Override
	public CalendarWorkflow updateImpl(
		com.ihg.calendar.model.CalendarWorkflow calendarWorkflow)
		throws SystemException {
		calendarWorkflow = toUnwrappedModel(calendarWorkflow);

		boolean isNew = calendarWorkflow.isNew();

		CalendarWorkflowModelImpl calendarWorkflowModelImpl = (CalendarWorkflowModelImpl)calendarWorkflow;

		Session session = null;

		try {
			session = openSession();

			if (calendarWorkflow.isNew()) {
				session.save(calendarWorkflow);

				calendarWorkflow.setNew(false);
			}
			else {
				session.merge(calendarWorkflow);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !CalendarWorkflowModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((calendarWorkflowModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						calendarWorkflowModelImpl.getOriginalGroupId(),
						calendarWorkflowModelImpl.getOriginalInTrash()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] {
						calendarWorkflowModelImpl.getGroupId(),
						calendarWorkflowModelImpl.getInTrash()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((calendarWorkflowModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						calendarWorkflowModelImpl.getOriginalGroupId(),
						calendarWorkflowModelImpl.getOriginalStatus(),
						calendarWorkflowModelImpl.getOriginalInTrash()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);

				args = new Object[] {
						calendarWorkflowModelImpl.getGroupId(),
						calendarWorkflowModelImpl.getStatus(),
						calendarWorkflowModelImpl.getInTrash()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S,
					args);
			}

			if ((calendarWorkflowModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_S.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						calendarWorkflowModelImpl.getOriginalGroupId(),
						calendarWorkflowModelImpl.getOriginalStatus(),
						calendarWorkflowModelImpl.getOriginalStartTime(),
						calendarWorkflowModelImpl.getOriginalInTrash()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_S,
					args);

				args = new Object[] {
						calendarWorkflowModelImpl.getGroupId(),
						calendarWorkflowModelImpl.getStatus(),
						calendarWorkflowModelImpl.getStartTime(),
						calendarWorkflowModelImpl.getInTrash()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_G_S_S, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_G_S_S,
					args);
			}
		}

		EntityCacheUtil.putResult(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
			CalendarWorkflowImpl.class, calendarWorkflow.getPrimaryKey(),
			calendarWorkflow);

		clearUniqueFindersCache(calendarWorkflow);
		cacheUniqueFindersCache(calendarWorkflow);

		return calendarWorkflow;
	}

	protected CalendarWorkflow toUnwrappedModel(
		CalendarWorkflow calendarWorkflow) {
		if (calendarWorkflow instanceof CalendarWorkflowImpl) {
			return calendarWorkflow;
		}

		CalendarWorkflowImpl calendarWorkflowImpl = new CalendarWorkflowImpl();

		calendarWorkflowImpl.setNew(calendarWorkflow.isNew());
		calendarWorkflowImpl.setPrimaryKey(calendarWorkflow.getPrimaryKey());

		calendarWorkflowImpl.setCalendarWorkflowId(calendarWorkflow.getCalendarWorkflowId());
		calendarWorkflowImpl.setCompanyId(calendarWorkflow.getCompanyId());
		calendarWorkflowImpl.setGroupId(calendarWorkflow.getGroupId());
		calendarWorkflowImpl.setCalendarBookingId(calendarWorkflow.getCalendarBookingId());
		calendarWorkflowImpl.setTitle(calendarWorkflow.getTitle());
		calendarWorkflowImpl.setStartTime(calendarWorkflow.getStartTime());
		calendarWorkflowImpl.setStartDateTime(calendarWorkflow.getStartDateTime());
		calendarWorkflowImpl.setStatus(calendarWorkflow.getStatus());
		calendarWorkflowImpl.setStatusByUserId(calendarWorkflow.getStatusByUserId());
		calendarWorkflowImpl.setStatusByUserName(calendarWorkflow.getStatusByUserName());
		calendarWorkflowImpl.setStatusDate(calendarWorkflow.getStatusDate());
		calendarWorkflowImpl.setInTrash(calendarWorkflow.isInTrash());

		return calendarWorkflowImpl;
	}

	/**
	 * Returns the calendar workflow with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the calendar workflow
	 * @return the calendar workflow
	 * @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a calendar workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCalendarWorkflowException, SystemException {
		CalendarWorkflow calendarWorkflow = fetchByPrimaryKey(primaryKey);

		if (calendarWorkflow == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCalendarWorkflowException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return calendarWorkflow;
	}

	/**
	 * Returns the calendar workflow with the primary key or throws a {@link com.ihg.calendar.NoSuchCalendarWorkflowException} if it could not be found.
	 *
	 * @param calendarWorkflowId the primary key of the calendar workflow
	 * @return the calendar workflow
	 * @throws com.ihg.calendar.NoSuchCalendarWorkflowException if a calendar workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow findByPrimaryKey(long calendarWorkflowId)
		throws NoSuchCalendarWorkflowException, SystemException {
		return findByPrimaryKey((Serializable)calendarWorkflowId);
	}

	/**
	 * Returns the calendar workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the calendar workflow
	 * @return the calendar workflow, or <code>null</code> if a calendar workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		CalendarWorkflow calendarWorkflow = (CalendarWorkflow)EntityCacheUtil.getResult(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
				CalendarWorkflowImpl.class, primaryKey);

		if (calendarWorkflow == _nullCalendarWorkflow) {
			return null;
		}

		if (calendarWorkflow == null) {
			Session session = null;

			try {
				session = openSession();

				calendarWorkflow = (CalendarWorkflow)session.get(CalendarWorkflowImpl.class,
						primaryKey);

				if (calendarWorkflow != null) {
					cacheResult(calendarWorkflow);
				}
				else {
					EntityCacheUtil.putResult(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
						CalendarWorkflowImpl.class, primaryKey,
						_nullCalendarWorkflow);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(CalendarWorkflowModelImpl.ENTITY_CACHE_ENABLED,
					CalendarWorkflowImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return calendarWorkflow;
	}

	/**
	 * Returns the calendar workflow with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param calendarWorkflowId the primary key of the calendar workflow
	 * @return the calendar workflow, or <code>null</code> if a calendar workflow with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CalendarWorkflow fetchByPrimaryKey(long calendarWorkflowId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)calendarWorkflowId);
	}

	/**
	 * Returns all the calendar workflows.
	 *
	 * @return the calendar workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CalendarWorkflow> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	public List<CalendarWorkflow> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<CalendarWorkflow> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<CalendarWorkflow> list = (List<CalendarWorkflow>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_CALENDARWORKFLOW);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_CALENDARWORKFLOW;

				if (pagination) {
					sql = sql.concat(CalendarWorkflowModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<CalendarWorkflow>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<CalendarWorkflow>(list);
				}
				else {
					list = (List<CalendarWorkflow>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the calendar workflows from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (CalendarWorkflow calendarWorkflow : findAll()) {
			remove(calendarWorkflow);
		}
	}

	/**
	 * Returns the number of calendar workflows.
	 *
	 * @return the number of calendar workflows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_CALENDARWORKFLOW);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the calendar workflow persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.ihg.calendar.model.CalendarWorkflow")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<CalendarWorkflow>> listenersList = new ArrayList<ModelListener<CalendarWorkflow>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<CalendarWorkflow>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(CalendarWorkflowImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_CALENDARWORKFLOW = "SELECT calendarWorkflow FROM CalendarWorkflow calendarWorkflow";
	private static final String _SQL_SELECT_CALENDARWORKFLOW_WHERE = "SELECT calendarWorkflow FROM CalendarWorkflow calendarWorkflow WHERE ";
	private static final String _SQL_COUNT_CALENDARWORKFLOW = "SELECT COUNT(calendarWorkflow) FROM CalendarWorkflow calendarWorkflow";
	private static final String _SQL_COUNT_CALENDARWORKFLOW_WHERE = "SELECT COUNT(calendarWorkflow) FROM CalendarWorkflow calendarWorkflow WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "calendarWorkflow.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No CalendarWorkflow exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No CalendarWorkflow exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(CalendarWorkflowPersistenceImpl.class);
	private static CalendarWorkflow _nullCalendarWorkflow = new CalendarWorkflowImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<CalendarWorkflow> toCacheModel() {
				return _nullCalendarWorkflowCacheModel;
			}
		};

	private static CacheModel<CalendarWorkflow> _nullCalendarWorkflowCacheModel = new CacheModel<CalendarWorkflow>() {
			@Override
			public CalendarWorkflow toEntityModel() {
				return _nullCalendarWorkflow;
			}
		};
}