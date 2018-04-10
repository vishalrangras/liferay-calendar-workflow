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
import com.ihg.calendar.service.CalendarWorkflowLocalServiceUtil;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * @author vishal.rangras
 * @generated
 */
public abstract class CalendarWorkflowActionableDynamicQuery
	extends BaseActionableDynamicQuery {
	public CalendarWorkflowActionableDynamicQuery() throws SystemException {
		setBaseLocalService(CalendarWorkflowLocalServiceUtil.getService());
		setClass(CalendarWorkflow.class);

		setClassLoader(com.ihg.calendar.service.ClpSerializer.class.getClassLoader());

		setPrimaryKeyPropertyName("calendarWorkflowId");
	}
}