== Welcome ==

I've implemented this problem in Java, using JBehave tests to verify my application can transform the listed test inputs into the expected outputs.

=== Getting started ===

1. Obviously Java should be installed (Java 6 SDK recommended)
2. This application uses maven to manage it's dependencies, so you will need maven installed
3. A git client should be installed to pull this code from the repository

To run:

    git clone https://bitbucket.org/willjthomas/sunspotanalyser.git
    cd sunspotanalyser
    mvn clean install

You should see a list of tests run, and they should all pass! 

=== Understanding the maven output ===

Maven produces a lot of output, so I'll highlight a few key things to look for. Assuming you ran the 'clean install' command as directed, if all tests passed you should see a message like this:

    [INFO] ---------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ---------------------------------------------------------

Since I've used JBehave, buried in the console output should also be easy to read plain-text descriptions for some of the test scenarios run. Look out for something like:

    Scenario: Top n areas with elevated solar activity
    Given an area with the following heat measurements:
    |Col0|Col1|Col2|Col3|
    |2|3|2|1|
    |4|4|2|0|
    |3|4|1|1|
    |2|3|4|4|
    When I request the top 3 highest solar activity scores
    Then the analyser displays: (1,2 score:27)(1,1 score:25)(2,2 score:23)


=== Running individual tests ===

If you'd prefer to run tests using a JUnit runner, for example through an IDE, then that's not a  problem. 

In the 'src/test/java' directory all purely JUnit tests will contain some methods annotated with JUnit 4's '@Test' annotation....these classes can obviously be run using a JUnit runner. 

JBehave tests can also be run in the same way, just look for classes with a name matching the pattern *Stories.java in the 'src/test/java/stories' directory e.g. CanShowTopNHighestRatedLocationsStories.java. These can be run in exactly the same way as pure JUnit tests, and they will execute the corresponding plain-text scenario in 'src/test/resources/stories' e.g. can_show_top_n_highest_rated_locations_stories.story.


=== Inspecting the code ===

My advice would be to start by reading the plain-text test scenarios in src/test/resources/stories.

Here's a bit of information about the whole directory structure though:

    |-- src/main/java - holds all the core application source code
    |-- src/test/java - holds all the automated tests, this includes a few lower-level unit tests
    |-- src/test/java/stories - the Java implementation of each high-level JBehave test
    |-- src/test/resources/stories - plain text JBehave test scenarios which map to Java classes in src/test/java/stories|

For some of the classes e.g. HeatMeasurementsAnalyser, I decided against writing JUnit-based unit tests. The main reason was working with grid test inputs in Junit classes was messy and ineffective. Instead I focussed on purely JBehave tests that already tested the core expected behaviour for these types of classes. If you can suggest improvements to my testing approach, I'd be happy to hear some alternative points of view though.


=== Configuration ===

This section is for information purposes only. *You shouldn't need to change any configuration within the source directories to run the application.*

The only configuration file in the application source is the pom.xml file in the base directory. This is an application descriptor, which maven uses.

In this file is a list of a few dependencies the application uses e.g. JUnit, Mockito. These dependencies are automatically downloaded when running the maven build command. They will be downloaded from apache maven's central online repository if you leave the default configuration in place after installing maven.

The pom.xml file also has some configuration for JBehave, which ensures the JBehave test scenarios are run in the same build phase as integration tests would normally run. I configured this largely based on this guide:

[http://jbehave.org/reference/stable/maven-goals.html](http://jbehave.org/reference/stable/maven-goals.html)

You may notice, maven searches for any java file in the test sources with a name matching the pattern: /*/*Stories.java. Each one it finds, it tries to run using a JUnit runner.

