<%@include file="/html/init.jsp"%>

<% int viewMode = (Integer)request.getAttribute("viewMode"); %>

<aui:nav cssClass="nav-tabs">
	
	<portlet:renderURL var="pendingPageURL">
		<portlet:param name="mvcPath" value="/html/calendarworkflow/view.jsp" />
		<portlet:param name="viewMode"
			value="0" />
	</portlet:renderURL>
	
	<portlet:renderURL var="approvedPageURL">
		<portlet:param name="mvcPath" value="/html/calendarworkflow/view.jsp" />
		<portlet:param name="viewMode"
			value="1" />
	</portlet:renderURL>
	
	<portlet:renderURL var="trashPageURL">
		<portlet:param name="mvcPath" value="/html/calendarworkflow/view.jsp" />
		<portlet:param name="viewMode"
			value="2" />
	</portlet:renderURL>
	
	<portlet:renderURL var="allPageURL">
		<portlet:param name="mvcPath" value="/html/calendarworkflow/view.jsp" />
		<portlet:param name="viewMode"
			value="3" />
	</portlet:renderURL>
	
		
	
	<aui:nav-item cssClass="<%=viewMode == 0?\"active\":\"\"%>" href="<%=pendingPageURL%>" label="Pending" />
		
	<aui:nav-item cssClass="<%=viewMode == 1?\"active\":\"\"%>" href="<%=approvedPageURL%>" label="Approved" />
	
	<aui:nav-item cssClass="<%=viewMode == 2?\"active\":\"\"%>" href="<%=trashPageURL%>" label="In Trash" />
	
	<aui:nav-item cssClass="<%=viewMode == 3?\"active\":\"\"%>" href="<%=allPageURL%>" label="All" />
</aui:nav>

<liferay-ui:search-container
			total="<%=CalendarWorkflowLocalServiceUtil.getCalendarWorkflowCountByM_G_S(viewMode, scopeGroupId)%>">
	
		<liferay-ui:search-container-results
			results="<%=CalendarWorkflowLocalServiceUtil.getCalendarWorkflowByM_G_S( viewMode, scopeGroupId, searchContainer.getStart(), searchContainer.getEnd())%>" />

	<liferay-ui:search-container-row
		className="com.ihg.calendar.model.CalendarWorkflow" modelVar="calendarWorkflow">

		<liferay-ui:search-container-column-text property="calendarWorkflowId" name="ID"/>

		<liferay-ui:search-container-column-text name="Event" ><a href="#"><%= calendarWorkflow.getTitle(locale)%></a></liferay-ui:search-container-column-text>
		
		<liferay-ui:search-container-column-text property="startDateTime" name="Start Time"/>
		
		<liferay-ui:search-container-column-text property="statusByUserName" name="User"/>
		
		<liferay-ui:search-container-column-text property="statusDate" name="Status Date"/>
		
		<liferay-ui:search-container-column-text name="status">
        	<aui:workflow-status showIcon="<%= false %>" showLabel="<%= false %>"
            status="<%= calendarWorkflow.isInTrash() ? WorkflowConstants.STATUS_IN_TRASH : calendarWorkflow.getStatus()%>" />
    	</liferay-ui:search-container-column-text>
    	
    		<portlet:actionURL name='approveCalendarEvent' var="approveEventURL" >
    			<portlet:param name="calendarWorkflowId" value="<%=String.valueOf(calendarWorkflow.getCalendarWorkflowId())%>" />
    		</portlet:actionURL>
    	
    		<portlet:actionURL name='rejectCalendarEvent' var="rejectEventURL" >
    			<portlet:param name="calendarWorkflowId" value="<%=String.valueOf(calendarWorkflow.getCalendarWorkflowId())%>" />
    		</portlet:actionURL>
    		<c:if test="${viewMode == 0 }">
    			<liferay-ui:search-container-column-text name="Action"><%= calendarWorkflow.getStatus() != 0 ? "<a href=\""+approveEventURL.toString()+"\">Approve</a>|<a href=\""+rejectEventURL.toString()+"\">Reject</a>" : "No Action Required" %></liferay-ui:search-container-column-text>
			</c:if>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
	
</liferay-ui:search-container>