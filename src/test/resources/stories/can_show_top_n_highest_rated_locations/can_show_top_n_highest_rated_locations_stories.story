Narrative:
As a user NASA scientist
I want to view the top n areas with elevated solar activity
So that ...

Scenario: Top n areas with elevated solar activity
Given an area with the following heat measurements:
|Col0|Col1|Col2|Col3|
|2|3|2|1|
|4|4|2|0|
|3|4|1|1|
|2|3|4|4|
When I request the top 3 highest solar activity scores
Then the analyser displays: (1,2 score:27)(1,1 score:25)(2,2 score:23)