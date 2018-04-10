create index IX_CDEE98C0 on calendar_workflow (calendarBookingId);
create index IX_DD06F9F2 on calendar_workflow (calendarWorkflowId);
create index IX_2345F804 on calendar_workflow (groupId);
create index IX_331DF2EA on calendar_workflow (groupId, status);
create index IX_2D20D115 on calendar_workflow (groupId, status, startTime);