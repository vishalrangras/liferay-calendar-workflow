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

package com.ihg.calendar.model.impl;

import com.ihg.calendar.model.CalendarWorkflow;
import com.ihg.calendar.model.CalendarWorkflowModel;
import com.ihg.calendar.model.CalendarWorkflowSoap;

import com.liferay.portal.LocaleException;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * The base model implementation for the CalendarWorkflow service. Represents a row in the &quot;calendar_workflow&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.ihg.calendar.model.CalendarWorkflowModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CalendarWorkflowImpl}.
 * </p>
 *
 * @author vishal.rangras
 * @see CalendarWorkflowImpl
 * @see com.ihg.calendar.model.CalendarWorkflow
 * @see com.ihg.calendar.model.CalendarWorkflowModel
 * @generated
 */
@JSON(strict = true)
public class CalendarWorkflowModelImpl extends BaseModelImpl<CalendarWorkflow>
	implements CalendarWorkflowModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a calendar workflow model instance should use the {@link com.ihg.calendar.model.CalendarWorkflow} interface instead.
	 */
	public static final String TABLE_NAME = "calendar_workflow";
	public static final Object[][] TABLE_COLUMNS = {
			{ "calendarWorkflowId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "calendarBookingId", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "startTime", Types.BIGINT },
			{ "startDateTime", Types.VARCHAR },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP },
			{ "inTrash", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table calendar_workflow (calendarWorkflowId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,calendarBookingId LONG,title STRING null,startTime LONG,startDateTime VARCHAR(75) null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null,inTrash BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table calendar_workflow";
	public static final String ORDER_BY_JPQL = " ORDER BY calendarWorkflow.startTime ASC, calendarWorkflow.calendarWorkflowId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY calendar_workflow.startTime ASC, calendar_workflow.calendarWorkflowId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.ihg.calendar.model.CalendarWorkflow"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.ihg.calendar.model.CalendarWorkflow"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.ihg.calendar.model.CalendarWorkflow"),
			true);
	public static long CALENDARBOOKINGID_COLUMN_BITMASK = 1L;
	public static long CALENDARWORKFLOWID_COLUMN_BITMASK = 2L;
	public static long GROUPID_COLUMN_BITMASK = 4L;
	public static long INTRASH_COLUMN_BITMASK = 8L;
	public static long STARTTIME_COLUMN_BITMASK = 16L;
	public static long STATUS_COLUMN_BITMASK = 32L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CalendarWorkflow toModel(CalendarWorkflowSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CalendarWorkflow model = new CalendarWorkflowImpl();

		model.setCalendarWorkflowId(soapModel.getCalendarWorkflowId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setGroupId(soapModel.getGroupId());
		model.setUserId(soapModel.getUserId());
		model.setCalendarBookingId(soapModel.getCalendarBookingId());
		model.setTitle(soapModel.getTitle());
		model.setStartTime(soapModel.getStartTime());
		model.setStartDateTime(soapModel.getStartDateTime());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());
		model.setInTrash(soapModel.getInTrash());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CalendarWorkflow> toModels(
		CalendarWorkflowSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<CalendarWorkflow> models = new ArrayList<CalendarWorkflow>(soapModels.length);

		for (CalendarWorkflowSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.ihg.calendar.model.CalendarWorkflow"));

	public CalendarWorkflowModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _calendarWorkflowId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCalendarWorkflowId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _calendarWorkflowId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CalendarWorkflow.class;
	}

	@Override
	public String getModelClassName() {
		return CalendarWorkflow.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("calendarWorkflowId", getCalendarWorkflowId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("calendarBookingId", getCalendarBookingId());
		attributes.put("title", getTitle());
		attributes.put("startTime", getStartTime());
		attributes.put("startDateTime", getStartDateTime());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("inTrash", getInTrash());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long calendarWorkflowId = (Long)attributes.get("calendarWorkflowId");

		if (calendarWorkflowId != null) {
			setCalendarWorkflowId(calendarWorkflowId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long calendarBookingId = (Long)attributes.get("calendarBookingId");

		if (calendarBookingId != null) {
			setCalendarBookingId(calendarBookingId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		Long startTime = (Long)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		String startDateTime = (String)attributes.get("startDateTime");

		if (startDateTime != null) {
			setStartDateTime(startDateTime);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Boolean inTrash = (Boolean)attributes.get("inTrash");

		if (inTrash != null) {
			setInTrash(inTrash);
		}
	}

	@JSON
	@Override
	public long getCalendarWorkflowId() {
		return _calendarWorkflowId;
	}

	@Override
	public void setCalendarWorkflowId(long calendarWorkflowId) {
		_columnBitmask = -1L;

		if (!_setOriginalCalendarWorkflowId) {
			_setOriginalCalendarWorkflowId = true;

			_originalCalendarWorkflowId = _calendarWorkflowId;
		}

		_calendarWorkflowId = calendarWorkflowId;
	}

	public long getOriginalCalendarWorkflowId() {
		return _originalCalendarWorkflowId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public long getCalendarBookingId() {
		return _calendarBookingId;
	}

	@Override
	public void setCalendarBookingId(long calendarBookingId) {
		_columnBitmask |= CALENDARBOOKINGID_COLUMN_BITMASK;

		if (!_setOriginalCalendarBookingId) {
			_setOriginalCalendarBookingId = true;

			_originalCalendarBookingId = _calendarBookingId;
		}

		_calendarBookingId = calendarBookingId;
	}

	public long getOriginalCalendarBookingId() {
		return _originalCalendarBookingId;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	@Override
	public String getTitle(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId);
	}

	@Override
	public String getTitle(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getTitle(languageId, useDefault);
	}

	@Override
	public String getTitle(String languageId) {
		return LocalizationUtil.getLocalization(getTitle(), languageId);
	}

	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(getTitle(), languageId,
			useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return _titleCurrentLanguageId;
	}

	@JSON
	@Override
	public String getTitleCurrentValue() {
		Locale locale = getLocale(_titleCurrentLanguageId);

		return getTitle(locale);
	}

	@Override
	public Map<Locale, String> getTitleMap() {
		return LocalizationUtil.getLocalizationMap(getTitle());
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@Override
	public void setTitle(String title, Locale locale) {
		setTitle(title, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setTitle(String title, Locale locale, Locale defaultLocale) {
		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(title)) {
			setTitle(LocalizationUtil.updateLocalization(getTitle(), "Title",
					title, languageId, defaultLanguageId));
		}
		else {
			setTitle(LocalizationUtil.removeLocalization(getTitle(), "Title",
					languageId));
		}
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		_titleCurrentLanguageId = languageId;
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap) {
		setTitleMap(titleMap, LocaleUtil.getDefault());
	}

	@Override
	public void setTitleMap(Map<Locale, String> titleMap, Locale defaultLocale) {
		if (titleMap == null) {
			return;
		}

		setTitle(LocalizationUtil.updateLocalization(titleMap, getTitle(),
				"Title", LocaleUtil.toLanguageId(defaultLocale)));
	}

	@JSON
	@Override
	public long getStartTime() {
		return _startTime;
	}

	@Override
	public void setStartTime(long startTime) {
		_columnBitmask = -1L;

		if (!_setOriginalStartTime) {
			_setOriginalStartTime = true;

			_originalStartTime = _startTime;
		}

		_startTime = startTime;
	}

	public long getOriginalStartTime() {
		return _originalStartTime;
	}

	@JSON
	@Override
	public String getStartDateTime() {
		if (_startDateTime == null) {
			return StringPool.BLANK;
		}
		else {
			return _startDateTime;
		}
	}

	@Override
	public void setStartDateTime(String startDateTime) {
		_startDateTime = startDateTime;
	}

	@JSON
	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@JSON
	@Override
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	@Override
	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	@Override
	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@JSON
	@Override
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	@Override
	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	@Override
	public Date getStatusDate() {
		return _statusDate;
	}

	@Override
	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	@JSON
	@Override
	public boolean getInTrash() {
		return _inTrash;
	}

	@Override
	public boolean isInTrash() {
		return _inTrash;
	}

	@Override
	public void setInTrash(boolean inTrash) {
		_columnBitmask |= INTRASH_COLUMN_BITMASK;

		if (!_setOriginalInTrash) {
			_setOriginalInTrash = true;

			_originalInTrash = _inTrash;
		}

		_inTrash = inTrash;
	}

	public boolean getOriginalInTrash() {
		return _originalInTrash;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #isApproved}
	 */
	@Override
	public boolean getApproved() {
		return isApproved();
	}

	@Override
	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDenied() {
		if (getStatus() == WorkflowConstants.STATUS_DENIED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isInactive() {
		if (getStatus() == WorkflowConstants.STATUS_INACTIVE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isIncomplete() {
		if (getStatus() == WorkflowConstants.STATUS_INCOMPLETE) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean isScheduled() {
		if (getStatus() == WorkflowConstants.STATUS_SCHEDULED) {
			return true;
		}
		else {
			return false;
		}
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			CalendarWorkflow.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> titleMap = getTitleMap();

		for (Map.Entry<Locale, String> entry : titleMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getTitle();

		if (xml == null) {
			return StringPool.BLANK;
		}

		return LocalizationUtil.getDefaultLanguageId(xml);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		prepareLocalizedFieldsForImport(null);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {
		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String title = getTitle(defaultLocale);

		if (Validator.isNull(title)) {
			setTitle(getTitle(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setTitle(getTitle(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public CalendarWorkflow toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (CalendarWorkflow)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CalendarWorkflowImpl calendarWorkflowImpl = new CalendarWorkflowImpl();

		calendarWorkflowImpl.setCalendarWorkflowId(getCalendarWorkflowId());
		calendarWorkflowImpl.setCompanyId(getCompanyId());
		calendarWorkflowImpl.setGroupId(getGroupId());
		calendarWorkflowImpl.setUserId(getUserId());
		calendarWorkflowImpl.setCalendarBookingId(getCalendarBookingId());
		calendarWorkflowImpl.setTitle(getTitle());
		calendarWorkflowImpl.setStartTime(getStartTime());
		calendarWorkflowImpl.setStartDateTime(getStartDateTime());
		calendarWorkflowImpl.setStatus(getStatus());
		calendarWorkflowImpl.setStatusByUserId(getStatusByUserId());
		calendarWorkflowImpl.setStatusByUserName(getStatusByUserName());
		calendarWorkflowImpl.setStatusDate(getStatusDate());
		calendarWorkflowImpl.setInTrash(getInTrash());

		calendarWorkflowImpl.resetOriginalValues();

		return calendarWorkflowImpl;
	}

	@Override
	public int compareTo(CalendarWorkflow calendarWorkflow) {
		int value = 0;

		if (getStartTime() < calendarWorkflow.getStartTime()) {
			value = -1;
		}
		else if (getStartTime() > calendarWorkflow.getStartTime()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (getCalendarWorkflowId() < calendarWorkflow.getCalendarWorkflowId()) {
			value = -1;
		}
		else if (getCalendarWorkflowId() > calendarWorkflow.getCalendarWorkflowId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CalendarWorkflow)) {
			return false;
		}

		CalendarWorkflow calendarWorkflow = (CalendarWorkflow)obj;

		long primaryKey = calendarWorkflow.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		CalendarWorkflowModelImpl calendarWorkflowModelImpl = this;

		calendarWorkflowModelImpl._originalCalendarWorkflowId = calendarWorkflowModelImpl._calendarWorkflowId;

		calendarWorkflowModelImpl._setOriginalCalendarWorkflowId = false;

		calendarWorkflowModelImpl._originalGroupId = calendarWorkflowModelImpl._groupId;

		calendarWorkflowModelImpl._setOriginalGroupId = false;

		calendarWorkflowModelImpl._originalCalendarBookingId = calendarWorkflowModelImpl._calendarBookingId;

		calendarWorkflowModelImpl._setOriginalCalendarBookingId = false;

		calendarWorkflowModelImpl._originalStartTime = calendarWorkflowModelImpl._startTime;

		calendarWorkflowModelImpl._setOriginalStartTime = false;

		calendarWorkflowModelImpl._originalStatus = calendarWorkflowModelImpl._status;

		calendarWorkflowModelImpl._setOriginalStatus = false;

		calendarWorkflowModelImpl._originalInTrash = calendarWorkflowModelImpl._inTrash;

		calendarWorkflowModelImpl._setOriginalInTrash = false;

		calendarWorkflowModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CalendarWorkflow> toCacheModel() {
		CalendarWorkflowCacheModel calendarWorkflowCacheModel = new CalendarWorkflowCacheModel();

		calendarWorkflowCacheModel.calendarWorkflowId = getCalendarWorkflowId();

		calendarWorkflowCacheModel.companyId = getCompanyId();

		calendarWorkflowCacheModel.groupId = getGroupId();

		calendarWorkflowCacheModel.userId = getUserId();

		calendarWorkflowCacheModel.calendarBookingId = getCalendarBookingId();

		calendarWorkflowCacheModel.title = getTitle();

		String title = calendarWorkflowCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			calendarWorkflowCacheModel.title = null;
		}

		calendarWorkflowCacheModel.startTime = getStartTime();

		calendarWorkflowCacheModel.startDateTime = getStartDateTime();

		String startDateTime = calendarWorkflowCacheModel.startDateTime;

		if ((startDateTime != null) && (startDateTime.length() == 0)) {
			calendarWorkflowCacheModel.startDateTime = null;
		}

		calendarWorkflowCacheModel.status = getStatus();

		calendarWorkflowCacheModel.statusByUserId = getStatusByUserId();

		calendarWorkflowCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = calendarWorkflowCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			calendarWorkflowCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			calendarWorkflowCacheModel.statusDate = statusDate.getTime();
		}
		else {
			calendarWorkflowCacheModel.statusDate = Long.MIN_VALUE;
		}

		calendarWorkflowCacheModel.inTrash = getInTrash();

		return calendarWorkflowCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{calendarWorkflowId=");
		sb.append(getCalendarWorkflowId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", calendarBookingId=");
		sb.append(getCalendarBookingId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", startTime=");
		sb.append(getStartTime());
		sb.append(", startDateTime=");
		sb.append(getStartDateTime());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append(", inTrash=");
		sb.append(getInTrash());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.ihg.calendar.model.CalendarWorkflow");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>calendarWorkflowId</column-name><column-value><![CDATA[");
		sb.append(getCalendarWorkflowId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>calendarBookingId</column-name><column-value><![CDATA[");
		sb.append(getCalendarBookingId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startTime</column-name><column-value><![CDATA[");
		sb.append(getStartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDateTime</column-name><column-value><![CDATA[");
		sb.append(getStartDateTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>inTrash</column-name><column-value><![CDATA[");
		sb.append(getInTrash());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = CalendarWorkflow.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			CalendarWorkflow.class
		};
	private long _calendarWorkflowId;
	private long _originalCalendarWorkflowId;
	private boolean _setOriginalCalendarWorkflowId;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private long _calendarBookingId;
	private long _originalCalendarBookingId;
	private boolean _setOriginalCalendarBookingId;
	private String _title;
	private String _titleCurrentLanguageId;
	private long _startTime;
	private long _originalStartTime;
	private boolean _setOriginalStartTime;
	private String _startDateTime;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private boolean _inTrash;
	private boolean _originalInTrash;
	private boolean _setOriginalInTrash;
	private long _columnBitmask;
	private CalendarWorkflow _escapedModel;
}