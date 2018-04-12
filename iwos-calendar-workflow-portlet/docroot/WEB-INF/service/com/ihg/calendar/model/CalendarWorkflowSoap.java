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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ihg.calendar.service.http.CalendarWorkflowServiceSoap}.
 *
 * @author vishal.rangras
 * @see com.ihg.calendar.service.http.CalendarWorkflowServiceSoap
 * @generated
 */
public class CalendarWorkflowSoap implements Serializable {
	public static CalendarWorkflowSoap toSoapModel(CalendarWorkflow model) {
		CalendarWorkflowSoap soapModel = new CalendarWorkflowSoap();

		soapModel.setCalendarWorkflowId(model.getCalendarWorkflowId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCalendarBookingId(model.getCalendarBookingId());
		soapModel.setTitle(model.getTitle());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setStartDateTime(model.getStartDateTime());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setInTrash(model.getInTrash());

		return soapModel;
	}

	public static CalendarWorkflowSoap[] toSoapModels(CalendarWorkflow[] models) {
		CalendarWorkflowSoap[] soapModels = new CalendarWorkflowSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CalendarWorkflowSoap[][] toSoapModels(
		CalendarWorkflow[][] models) {
		CalendarWorkflowSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CalendarWorkflowSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CalendarWorkflowSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CalendarWorkflowSoap[] toSoapModels(
		List<CalendarWorkflow> models) {
		List<CalendarWorkflowSoap> soapModels = new ArrayList<CalendarWorkflowSoap>(models.size());

		for (CalendarWorkflow model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CalendarWorkflowSoap[soapModels.size()]);
	}

	public CalendarWorkflowSoap() {
	}

	public long getPrimaryKey() {
		return _calendarWorkflowId;
	}

	public void setPrimaryKey(long pk) {
		setCalendarWorkflowId(pk);
	}

	public long getCalendarWorkflowId() {
		return _calendarWorkflowId;
	}

	public void setCalendarWorkflowId(long calendarWorkflowId) {
		_calendarWorkflowId = calendarWorkflowId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCalendarBookingId() {
		return _calendarBookingId;
	}

	public void setCalendarBookingId(long calendarBookingId) {
		_calendarBookingId = calendarBookingId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public long getStartTime() {
		return _startTime;
	}

	public void setStartTime(long startTime) {
		_startTime = startTime;
	}

	public String getStartDateTime() {
		return _startDateTime;
	}

	public void setStartDateTime(String startDateTime) {
		_startDateTime = startDateTime;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public boolean getInTrash() {
		return _inTrash;
	}

	public boolean isInTrash() {
		return _inTrash;
	}

	public void setInTrash(boolean inTrash) {
		_inTrash = inTrash;
	}

	private long _calendarWorkflowId;
	private long _companyId;
	private long _groupId;
	private long _calendarBookingId;
	private String _title;
	private long _startTime;
	private String _startDateTime;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private boolean _inTrash;
}