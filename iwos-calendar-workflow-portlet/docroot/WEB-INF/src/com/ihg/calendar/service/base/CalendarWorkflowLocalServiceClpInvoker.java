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

import com.ihg.calendar.service.CalendarWorkflowLocalServiceUtil;

import java.util.Arrays;

/**
 * @author vishal.rangras
 * @generated
 */
public class CalendarWorkflowLocalServiceClpInvoker {
	public CalendarWorkflowLocalServiceClpInvoker() {
		_methodName0 = "addCalendarWorkflow";

		_methodParameterTypes0 = new String[] {
				"com.ihg.calendar.model.CalendarWorkflow"
			};

		_methodName1 = "createCalendarWorkflow";

		_methodParameterTypes1 = new String[] { "long" };

		_methodName2 = "deleteCalendarWorkflow";

		_methodParameterTypes2 = new String[] { "long" };

		_methodName3 = "deleteCalendarWorkflow";

		_methodParameterTypes3 = new String[] {
				"com.ihg.calendar.model.CalendarWorkflow"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "dynamicQueryCount";

		_methodParameterTypes9 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery",
				"com.liferay.portal.kernel.dao.orm.Projection"
			};

		_methodName10 = "fetchCalendarWorkflow";

		_methodParameterTypes10 = new String[] { "long" };

		_methodName11 = "getCalendarWorkflow";

		_methodParameterTypes11 = new String[] { "long" };

		_methodName12 = "getPersistedModel";

		_methodParameterTypes12 = new String[] { "java.io.Serializable" };

		_methodName13 = "getCalendarWorkflows";

		_methodParameterTypes13 = new String[] { "int", "int" };

		_methodName14 = "getCalendarWorkflowsCount";

		_methodParameterTypes14 = new String[] {  };

		_methodName15 = "updateCalendarWorkflow";

		_methodParameterTypes15 = new String[] {
				"com.ihg.calendar.model.CalendarWorkflow"
			};

		_methodName34 = "getBeanIdentifier";

		_methodParameterTypes34 = new String[] {  };

		_methodName35 = "setBeanIdentifier";

		_methodParameterTypes35 = new String[] { "java.lang.String" };

		_methodName40 = "addCalendarWorkflow";

		_methodParameterTypes40 = new String[] {
				"long", "long", "long", "long", "long", "java.util.Map",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName41 = "updateCalendarWorkflow";

		_methodParameterTypes41 = new String[] {
				"long", "long", "long", "long", "long", "java.util.Map",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName42 = "updateStatus";

		_methodParameterTypes42 = new String[] {
				"long", "long", "int",
				"com.liferay.portal.service.ServiceContext"
			};

		_methodName43 = "getCalendarWorkflowByStatus";

		_methodParameterTypes43 = new String[] { "long", "int" };

		_methodName44 = "getCalendarWorkflowByStatus";

		_methodParameterTypes44 = new String[] { "long", "int", "int", "int" };

		_methodName45 = "getCalendarWorkflowCountByStatus";

		_methodParameterTypes45 = new String[] { "long", "int" };

		_methodName46 = "getCalendarWorkflowByStatusAndStartTime";

		_methodParameterTypes46 = new String[] { "long", "int", "long" };

		_methodName47 = "getCalendarWorkflowByStatusAndStartTime";

		_methodParameterTypes47 = new String[] {
				"long", "int", "long", "int", "int"
			};

		_methodName48 = "getCalendarWorkflowCountByStatusAndStartTime";

		_methodParameterTypes48 = new String[] { "long", "int", "long" };

		_methodName49 = "getAllCalendarWorkflowByGroupId";

		_methodParameterTypes49 = new String[] { "long" };

		_methodName50 = "getAllCalendarWorkflowByGroupId";

		_methodParameterTypes50 = new String[] { "long", "int", "int" };

		_methodName51 = "getAllCalendarWorkflowCountByGroupId";

		_methodParameterTypes51 = new String[] { "long" };

		_methodName52 = "getAllCalendarWorkflow";

		_methodParameterTypes52 = new String[] {  };

		_methodName53 = "getAllCalendarWorkflow";

		_methodParameterTypes53 = new String[] { "int", "int" };

		_methodName54 = "getAllCalendarWorkflowCounts";

		_methodParameterTypes54 = new String[] {  };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.addCalendarWorkflow((com.ihg.calendar.model.CalendarWorkflow)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.createCalendarWorkflow(((Long)arguments[0]).longValue());
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.deleteCalendarWorkflow(((Long)arguments[0]).longValue());
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.deleteCalendarWorkflow((com.ihg.calendar.model.CalendarWorkflow)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				(com.liferay.portal.kernel.dao.orm.Projection)arguments[1]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.fetchCalendarWorkflow(((Long)arguments[0]).longValue());
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getCalendarWorkflow(((Long)arguments[0]).longValue());
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getCalendarWorkflows(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getCalendarWorkflowsCount();
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.updateCalendarWorkflow((com.ihg.calendar.model.CalendarWorkflow)arguments[0]);
		}

		if (_methodName34.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes34, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName35.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes35, parameterTypes)) {
			CalendarWorkflowLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName40.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes40, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.addCalendarWorkflow(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[5],
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName41.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes41, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.updateCalendarWorkflow(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Long)arguments[2]).longValue(),
				((Long)arguments[3]).longValue(),
				((Long)arguments[4]).longValue(),
				(java.util.Map<java.util.Locale, java.lang.String>)arguments[5],
				(com.liferay.portal.service.ServiceContext)arguments[6]);
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.updateStatus(((Long)arguments[0]).longValue(),
				((Long)arguments[1]).longValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.service.ServiceContext)arguments[3]);
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getCalendarWorkflowByStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getCalendarWorkflowByStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				((Integer)arguments[3]).intValue());
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getCalendarWorkflowCountByStatus(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getCalendarWorkflowByStatusAndStartTime(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getCalendarWorkflowByStatusAndStartTime(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue(),
				((Integer)arguments[3]).intValue(),
				((Integer)arguments[4]).intValue());
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getCalendarWorkflowCountByStatusAndStartTime(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Long)arguments[2]).longValue());
		}

		if (_methodName49.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes49, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getAllCalendarWorkflowByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getAllCalendarWorkflowByGroupId(((Long)arguments[0]).longValue(),
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName51.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes51, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getAllCalendarWorkflowCountByGroupId(((Long)arguments[0]).longValue());
		}

		if (_methodName52.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes52, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getAllCalendarWorkflow();
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getAllCalendarWorkflow(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return CalendarWorkflowLocalServiceUtil.getAllCalendarWorkflowCounts();
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName34;
	private String[] _methodParameterTypes34;
	private String _methodName35;
	private String[] _methodParameterTypes35;
	private String _methodName40;
	private String[] _methodParameterTypes40;
	private String _methodName41;
	private String[] _methodParameterTypes41;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName49;
	private String[] _methodParameterTypes49;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName51;
	private String[] _methodParameterTypes51;
	private String _methodName52;
	private String[] _methodParameterTypes52;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
}