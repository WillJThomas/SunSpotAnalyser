Narrative:
As a NASA scientist
I want to calculate a solar activity score for a given area of the sun
So that I can find areas of elevated solar activity

Scenario: Calculate solar activity score for location (1,1) in 3x3 grid area
Given an area with the following heat measurements:
      |Col0|Col1|Col2|
      |5|3|1|
      |4|1|1|
      |2|3|2|

When I calculate the solar activity score of location (1,1)
Then the result should be 22

Scenario: Calculate solar activity score for location (1,2) in 4x4 grid area
Given an area with the following heat measurements:
|Col0|Col1|Col2|Col3|
|2|3|2|1|
|4|4|2|0|
|3|4|1|1|
|2|3|4|4|

When I calculate the solar activity score of location (1,2)
Then the result should be 27

Scenario: Calculate solar activity score for location (1,1) in 4x4 grid area
Given an area with the following heat measurements:
|Col0|Col1|Col2|Col3|
|2|3|2|1|
|4|4|2|0|
|3|4|1|1|
|2|3|4|4|

When I calculate the solar activity score of location (1,1)
Then the result should be 25

Scenario: Calculate solar activity score for location (2,2) in 4x4 grid area
Given an area with the following heat measurements:
|Col0|Col1|Col2|Col3|
|2|3|2|1|
|4|4|2|0|
|3|4|1|1|
|2|3|4|4|

When I calculate the solar activity score of location (2,2)
Then the result should be 23