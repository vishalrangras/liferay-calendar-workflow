<%@include file="/html/init.jsp"%>


This is the <b>Calendar Workflow</b> portlet in View mode.

<liferay-ui:search-container
	total="<%=CalendarWorkflowLocalServiceUtil.getAllCalendarWorkflowCounts()%>">
	
	<liferay-ui:search-container-results
		results="<%=CalendarWorkflowLocalServiceUtil.getAllCalendarWorkflow(searchContainer.getStart(), searchContainer.getEnd())%>" />

	<liferay-ui:search-container-row
		className="com.ihg.calendar.model.CalendarWorkflow" modelVar="calendarWorkflow">

		<liferay-ui:search-container-column-text property="calendarWorkflowId" name="ID"/>

		<liferay-ui:search-container-column-text name="Event" ><%= calendarWorkflow.getTitle(locale)%></liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text property="startDateTime" name="Start Time"/>
		
		<liferay-ui:search-container-column-text property="statusByUserName" name="User"/>
		
		<liferay-ui:search-container-column-text property="statusDate" name="Status Date"/>
		
		<liferay-ui:search-container-column-text name="status">
        	<aui:workflow-status showIcon="<%= false %>" showLabel="<%= false %>"
            status="<%= calendarWorkflow.getStatus() %>" />
    	</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>