<%@include file="/html/init.jsp"%>

This is the <b>Calendar Workflow</b> portlet in View mode.

<liferay-ui:search-container
	total="<%=CalendarWorkflowLocalServiceUtil.getAllCalendarWorkflowCounts()%>">
	
	<liferay-ui:search-container-results
		results="<%=CalendarWorkflowLocalServiceUtil.getAllCalendarWorkflowByGroupId( scopeGroupId, searchContainer.getStart(), searchContainer.getEnd())%>" />

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
    	
    		<portlet:actionURL name='approveCalendarEvent' var="approveEventURL" >
    			<portlet:param name="calendarWorkflowId" value="<%=String.valueOf(calendarWorkflow.getCalendarWorkflowId())%>" />
    		</portlet:actionURL>
    	
    		<portlet:actionURL name='rejectCalendarEvent' var="rejectEventURL" >
    			<portlet:param name="calendarWorkflowId" value="<%=String.valueOf(calendarWorkflow.getCalendarWorkflowId())%>" />
    		</portlet:actionURL>
    		
    		<liferay-ui:search-container-column-text name="Action"><%= calendarWorkflow.getStatus() != 0 ? "<a href=\""+approveEventURL.toString()+"\">Approve</a> | <a href=\""+rejectEventURL.toString()+"\">Reject</a>" : "No Action Required" %></liferay-ui:search-container-column-text>
    		<%-- <liferay-ui:search-container-column-text name="Reject"><a href="<%= rejectEventURL.toString() %>" <%= calendarWorkflow.getStatus() != 0 ?"" :"disabled" %>>Reject</a></liferay-ui:search-container-column-text> --%>
    	
    	<%-- <aui:button-row>
    		<aui:button onClick="<%= approveEventURL.toString() %>"
                        value="Approve" />
			<aui:button onClick="<%= rejectEventURL.toString() %>"
                        value="Reject" />
		</aui:button-row> --%>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>