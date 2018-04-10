create table calendar_workflow (
	calendarWorkflowId LONG not null primary key,
	groupId LONG,
	calendarBookingId LONG,
	title STRING null,
	startTime LONG,
	startDateTime VARCHAR(75) null,
	status INTEGER,
	statusByUserId LONG,
	statusByUserName VARCHAR(75) null,
	statusDate DATE null
);