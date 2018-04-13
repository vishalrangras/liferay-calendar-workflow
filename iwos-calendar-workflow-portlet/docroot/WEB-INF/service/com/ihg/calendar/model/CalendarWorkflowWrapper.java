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

package com.ihg.calendar.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CalendarWorkflow}.
 * </p>
 *
 * @author vishal.rangras
 * @see CalendarWorkflow
 * @generated
 */
public class CalendarWorkflowWrapper implements CalendarWorkflow,
	ModelWrapper<CalendarWorkflow> {
	public CalendarWorkflowWrapper(CalendarWorkflow calendarWorkflow) {
		_calendarWorkflow = calendarWorkflow;
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

	/**
	* Returns the primary key of this calendar workflow.
	*
	* @return the primary key of this calendar workflow
	*/
	@Override
	public long getPrimaryKey() {
		return _calendarWorkflow.getPrimaryKey();
	}

	/**
	* Sets the primary key of this calendar workflow.
	*
	* @param primaryKey the primary key of this calendar workflow
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_calendarWorkflow.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the calendar workflow ID of this calendar workflow.
	*
	* @return the calendar workflow ID of this calendar workflow
	*/
	@Override
	public long getCalendarWorkflowId() {
		return _calendarWorkflow.getCalendarWorkflowId();
	}

	/**
	* Sets the calendar workflow ID of this calendar workflow.
	*
	* @param calendarWorkflowId the calendar workflow ID of this calendar workflow
	*/
	@Override
	public void setCalendarWorkflowId(long calendarWorkflowId) {
		_calendarWorkflow.setCalendarWorkflowId(calendarWorkflowId);
	}

	/**
	* Returns the company ID of this calendar workflow.
	*
	* @return the company ID of this calendar workflow
	*/
	@Override
	public long getCompanyId() {
		return _calendarWorkflow.getCompanyId();
	}

	/**
	* Sets the company ID of this calendar workflow.
	*
	* @param companyId the company ID of this calendar workflow
	*/
	@Override
	public void setCompanyId(long companyId) {
		_calendarWorkflow.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this calendar workflow.
	*
	* @return the group ID of this calendar workflow
	*/
	@Override
	public long getGroupId() {
		return _calendarWorkflow.getGroupId();
	}

	/**
	* Sets the group ID of this calendar workflow.
	*
	* @param groupId the group ID of this calendar workflow
	*/
	@Override
	public void setGroupId(long groupId) {
		_calendarWorkflow.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this calendar workflow.
	*
	* @return the user ID of this calendar workflow
	*/
	@Override
	public long getUserId() {
		return _calendarWorkflow.getUserId();
	}

	/**
	* Sets the user ID of this calendar workflow.
	*
	* @param userId the user ID of this calendar workflow
	*/
	@Override
	public void setUserId(long userId) {
		_calendarWorkflow.setUserId(userId);
	}

	/**
	* Returns the user uuid of this calendar workflow.
	*
	* @return the user uuid of this calendar workflow
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflow.getUserUuid();
	}

	/**
	* Sets the user uuid of this calendar workflow.
	*
	* @param userUuid the user uuid of this calendar workflow
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_calendarWorkflow.setUserUuid(userUuid);
	}

	/**
	* Returns the calendar booking ID of this calendar workflow.
	*
	* @return the calendar booking ID of this calendar workflow
	*/
	@Override
	public long getCalendarBookingId() {
		return _calendarWorkflow.getCalendarBookingId();
	}

	/**
	* Sets the calendar booking ID of this calendar workflow.
	*
	* @param calendarBookingId the calendar booking ID of this calendar workflow
	*/
	@Override
	public void setCalendarBookingId(long calendarBookingId) {
		_calendarWorkflow.setCalendarBookingId(calendarBookingId);
	}

	/**
	* Returns the title of this calendar workflow.
	*
	* @return the title of this calendar workflow
	*/
	@Override
	public java.lang.String getTitle() {
		return _calendarWorkflow.getTitle();
	}

	/**
	* Returns the localized title of this calendar workflow in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param locale the locale of the language
	* @return the localized title of this calendar workflow
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale) {
		return _calendarWorkflow.getTitle(locale);
	}

	/**
	* Returns the localized title of this calendar workflow in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param locale the local of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this calendar workflow. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	*/
	@Override
	public java.lang.String getTitle(java.util.Locale locale, boolean useDefault) {
		return _calendarWorkflow.getTitle(locale, useDefault);
	}

	/**
	* Returns the localized title of this calendar workflow in the language. Uses the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @return the localized title of this calendar workflow
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId) {
		return _calendarWorkflow.getTitle(languageId);
	}

	/**
	* Returns the localized title of this calendar workflow in the language, optionally using the default language if no localization exists for the requested language.
	*
	* @param languageId the ID of the language
	* @param useDefault whether to use the default language if no localization exists for the requested language
	* @return the localized title of this calendar workflow
	*/
	@Override
	public java.lang.String getTitle(java.lang.String languageId,
		boolean useDefault) {
		return _calendarWorkflow.getTitle(languageId, useDefault);
	}

	@Override
	public java.lang.String getTitleCurrentLanguageId() {
		return _calendarWorkflow.getTitleCurrentLanguageId();
	}

	@Override
	public java.lang.String getTitleCurrentValue() {
		return _calendarWorkflow.getTitleCurrentValue();
	}

	/**
	* Returns a map of the locales and localized titles of this calendar workflow.
	*
	* @return the locales and localized titles of this calendar workflow
	*/
	@Override
	public java.util.Map<java.util.Locale, java.lang.String> getTitleMap() {
		return _calendarWorkflow.getTitleMap();
	}

	/**
	* Sets the title of this calendar workflow.
	*
	* @param title the title of this calendar workflow
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_calendarWorkflow.setTitle(title);
	}

	/**
	* Sets the localized title of this calendar workflow in the language.
	*
	* @param title the localized title of this calendar workflow
	* @param locale the locale of the language
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale) {
		_calendarWorkflow.setTitle(title, locale);
	}

	/**
	* Sets the localized title of this calendar workflow in the language, and sets the default locale.
	*
	* @param title the localized title of this calendar workflow
	* @param locale the locale of the language
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitle(java.lang.String title, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_calendarWorkflow.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(java.lang.String languageId) {
		_calendarWorkflow.setTitleCurrentLanguageId(languageId);
	}

	/**
	* Sets the localized titles of this calendar workflow from the map of locales and localized titles.
	*
	* @param titleMap the locales and localized titles of this calendar workflow
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap) {
		_calendarWorkflow.setTitleMap(titleMap);
	}

	/**
	* Sets the localized titles of this calendar workflow from the map of locales and localized titles, and sets the default locale.
	*
	* @param titleMap the locales and localized titles of this calendar workflow
	* @param defaultLocale the default locale
	*/
	@Override
	public void setTitleMap(
		java.util.Map<java.util.Locale, java.lang.String> titleMap,
		java.util.Locale defaultLocale) {
		_calendarWorkflow.setTitleMap(titleMap, defaultLocale);
	}

	/**
	* Returns the start time of this calendar workflow.
	*
	* @return the start time of this calendar workflow
	*/
	@Override
	public long getStartTime() {
		return _calendarWorkflow.getStartTime();
	}

	/**
	* Sets the start time of this calendar workflow.
	*
	* @param startTime the start time of this calendar workflow
	*/
	@Override
	public void setStartTime(long startTime) {
		_calendarWorkflow.setStartTime(startTime);
	}

	/**
	* Returns the start date time of this calendar workflow.
	*
	* @return the start date time of this calendar workflow
	*/
	@Override
	public java.lang.String getStartDateTime() {
		return _calendarWorkflow.getStartDateTime();
	}

	/**
	* Sets the start date time of this calendar workflow.
	*
	* @param startDateTime the start date time of this calendar workflow
	*/
	@Override
	public void setStartDateTime(java.lang.String startDateTime) {
		_calendarWorkflow.setStartDateTime(startDateTime);
	}

	/**
	* Returns the status of this calendar workflow.
	*
	* @return the status of this calendar workflow
	*/
	@Override
	public int getStatus() {
		return _calendarWorkflow.getStatus();
	}

	/**
	* Sets the status of this calendar workflow.
	*
	* @param status the status of this calendar workflow
	*/
	@Override
	public void setStatus(int status) {
		_calendarWorkflow.setStatus(status);
	}

	/**
	* Returns the status by user ID of this calendar workflow.
	*
	* @return the status by user ID of this calendar workflow
	*/
	@Override
	public long getStatusByUserId() {
		return _calendarWorkflow.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this calendar workflow.
	*
	* @param statusByUserId the status by user ID of this calendar workflow
	*/
	@Override
	public void setStatusByUserId(long statusByUserId) {
		_calendarWorkflow.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this calendar workflow.
	*
	* @return the status by user uuid of this calendar workflow
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _calendarWorkflow.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this calendar workflow.
	*
	* @param statusByUserUuid the status by user uuid of this calendar workflow
	*/
	@Override
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_calendarWorkflow.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this calendar workflow.
	*
	* @return the status by user name of this calendar workflow
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _calendarWorkflow.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this calendar workflow.
	*
	* @param statusByUserName the status by user name of this calendar workflow
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_calendarWorkflow.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this calendar workflow.
	*
	* @return the status date of this calendar workflow
	*/
	@Override
	public java.util.Date getStatusDate() {
		return _calendarWorkflow.getStatusDate();
	}

	/**
	* Sets the status date of this calendar workflow.
	*
	* @param statusDate the status date of this calendar workflow
	*/
	@Override
	public void setStatusDate(java.util.Date statusDate) {
		_calendarWorkflow.setStatusDate(statusDate);
	}

	/**
	* Returns the in trash of this calendar workflow.
	*
	* @return the in trash of this calendar workflow
	*/
	@Override
	public boolean getInTrash() {
		return _calendarWorkflow.getInTrash();
	}

	/**
	* Returns <code>true</code> if this calendar workflow is in trash.
	*
	* @return <code>true</code> if this calendar workflow is in trash; <code>false</code> otherwise
	*/
	@Override
	public boolean isInTrash() {
		return _calendarWorkflow.isInTrash();
	}

	/**
	* Sets whether this calendar workflow is in trash.
	*
	* @param inTrash the in trash of this calendar workflow
	*/
	@Override
	public void setInTrash(boolean inTrash) {
		_calendarWorkflow.setInTrash(inTrash);
	}

	/**
	* @deprecated As of 6.1.0, replaced by {@link #isApproved()}
	*/
	@Override
	public boolean getApproved() {
		return _calendarWorkflow.getApproved();
	}

	/**
	* Returns <code>true</code> if this calendar workflow is approved.
	*
	* @return <code>true</code> if this calendar workflow is approved; <code>false</code> otherwise
	*/
	@Override
	public boolean isApproved() {
		return _calendarWorkflow.isApproved();
	}

	/**
	* Returns <code>true</code> if this calendar workflow is denied.
	*
	* @return <code>true</code> if this calendar workflow is denied; <code>false</code> otherwise
	*/
	@Override
	public boolean isDenied() {
		return _calendarWorkflow.isDenied();
	}

	/**
	* Returns <code>true</code> if this calendar workflow is a draft.
	*
	* @return <code>true</code> if this calendar workflow is a draft; <code>false</code> otherwise
	*/
	@Override
	public boolean isDraft() {
		return _calendarWorkflow.isDraft();
	}

	/**
	* Returns <code>true</code> if this calendar workflow is expired.
	*
	* @return <code>true</code> if this calendar workflow is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _calendarWorkflow.isExpired();
	}

	/**
	* Returns <code>true</code> if this calendar workflow is inactive.
	*
	* @return <code>true</code> if this calendar workflow is inactive; <code>false</code> otherwise
	*/
	@Override
	public boolean isInactive() {
		return _calendarWorkflow.isInactive();
	}

	/**
	* Returns <code>true</code> if this calendar workflow is incomplete.
	*
	* @return <code>true</code> if this calendar workflow is incomplete; <code>false</code> otherwise
	*/
	@Override
	public boolean isIncomplete() {
		return _calendarWorkflow.isIncomplete();
	}

	/**
	* Returns <code>true</code> if this calendar workflow is pending.
	*
	* @return <code>true</code> if this calendar workflow is pending; <code>false</code> otherwise
	*/
	@Override
	public boolean isPending() {
		return _calendarWorkflow.isPending();
	}

	/**
	* Returns <code>true</code> if this calendar workflow is scheduled.
	*
	* @return <code>true</code> if this calendar workflow is scheduled; <code>false</code> otherwise
	*/
	@Override
	public boolean isScheduled() {
		return _calendarWorkflow.isScheduled();
	}

	@Override
	public boolean isNew() {
		return _calendarWorkflow.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_calendarWorkflow.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _calendarWorkflow.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_calendarWorkflow.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _calendarWorkflow.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _calendarWorkflow.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_calendarWorkflow.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _calendarWorkflow.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_calendarWorkflow.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_calendarWorkflow.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_calendarWorkflow.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.String[] getAvailableLanguageIds() {
		return _calendarWorkflow.getAvailableLanguageIds();
	}

	@Override
	public java.lang.String getDefaultLanguageId() {
		return _calendarWorkflow.getDefaultLanguageId();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.LocaleException {
		_calendarWorkflow.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
		java.util.Locale defaultImportLocale)
		throws com.liferay.portal.LocaleException {
		_calendarWorkflow.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	public java.lang.Object clone() {
		return new CalendarWorkflowWrapper((CalendarWorkflow)_calendarWorkflow.clone());
	}

	@Override
	public int compareTo(
		com.ihg.calendar.model.CalendarWorkflow calendarWorkflow) {
		return _calendarWorkflow.compareTo(calendarWorkflow);
	}

	@Override
	public int hashCode() {
		return _calendarWorkflow.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.ihg.calendar.model.CalendarWorkflow> toCacheModel() {
		return _calendarWorkflow.toCacheModel();
	}

	@Override
	public com.ihg.calendar.model.CalendarWorkflow toEscapedModel() {
		return new CalendarWorkflowWrapper(_calendarWorkflow.toEscapedModel());
	}

	@Override
	public com.ihg.calendar.model.CalendarWorkflow toUnescapedModel() {
		return new CalendarWorkflowWrapper(_calendarWorkflow.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _calendarWorkflow.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _calendarWorkflow.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_calendarWorkflow.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CalendarWorkflowWrapper)) {
			return false;
		}

		CalendarWorkflowWrapper calendarWorkflowWrapper = (CalendarWorkflowWrapper)obj;

		if (Validator.equals(_calendarWorkflow,
					calendarWorkflowWrapper._calendarWorkflow)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CalendarWorkflow getWrappedCalendarWorkflow() {
		return _calendarWorkflow;
	}

	@Override
	public CalendarWorkflow getWrappedModel() {
		return _calendarWorkflow;
	}

	@Override
	public void resetOriginalValues() {
		_calendarWorkflow.resetOriginalValues();
	}

	private CalendarWorkflow _calendarWorkflow;
}