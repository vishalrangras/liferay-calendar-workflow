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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CalendarWorkflow in entity cache.
 *
 * @author vishal.rangras
 * @see CalendarWorkflow
 * @generated
 */
public class CalendarWorkflowCacheModel implements CacheModel<CalendarWorkflow>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{calendarWorkflowId=");
		sb.append(calendarWorkflowId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", calendarBookingId=");
		sb.append(calendarBookingId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", startDateTime=");
		sb.append(startDateTime);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", inTrash=");
		sb.append(inTrash);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CalendarWorkflow toEntityModel() {
		CalendarWorkflowImpl calendarWorkflowImpl = new CalendarWorkflowImpl();

		calendarWorkflowImpl.setCalendarWorkflowId(calendarWorkflowId);
		calendarWorkflowImpl.setGroupId(groupId);
		calendarWorkflowImpl.setCalendarBookingId(calendarBookingId);

		if (title == null) {
			calendarWorkflowImpl.setTitle(StringPool.BLANK);
		}
		else {
			calendarWorkflowImpl.setTitle(title);
		}

		calendarWorkflowImpl.setStartTime(startTime);

		if (startDateTime == null) {
			calendarWorkflowImpl.setStartDateTime(StringPool.BLANK);
		}
		else {
			calendarWorkflowImpl.setStartDateTime(startDateTime);
		}

		calendarWorkflowImpl.setStatus(status);
		calendarWorkflowImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			calendarWorkflowImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			calendarWorkflowImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			calendarWorkflowImpl.setStatusDate(null);
		}
		else {
			calendarWorkflowImpl.setStatusDate(new Date(statusDate));
		}

		calendarWorkflowImpl.setInTrash(inTrash);

		calendarWorkflowImpl.resetOriginalValues();

		return calendarWorkflowImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		calendarWorkflowId = objectInput.readLong();
		groupId = objectInput.readLong();
		calendarBookingId = objectInput.readLong();
		title = objectInput.readUTF();
		startTime = objectInput.readLong();
		startDateTime = objectInput.readUTF();
		status = objectInput.readInt();
		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		inTrash = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(calendarWorkflowId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(calendarBookingId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeLong(startTime);

		if (startDateTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(startDateTime);
		}

		objectOutput.writeInt(status);
		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);
		objectOutput.writeBoolean(inTrash);
	}

	public long calendarWorkflowId;
	public long groupId;
	public long calendarBookingId;
	public String title;
	public long startTime;
	public String startDateTime;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public boolean inTrash;
}