Narrative:
As a NASA scientist
I want to pinpoint an area with elevated solar activity
So that ...

Scenario: Area with highest level of solar activity
Given an area with the following heat measurements:
|Col0|Col1|Col2|Col3|Col4|
|5|3|1|2|0|
|4|1|1|3|2|
|2|3|2|4|3|
|0|2|3|3|2|
|1|0|2|4|3|
When I request the single highest solar activity score
Then the analyser displays: (3,3 score:26)