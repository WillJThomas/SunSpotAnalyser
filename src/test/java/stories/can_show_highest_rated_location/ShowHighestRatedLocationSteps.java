package stories.can_show_highest_rated_location;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.model.ExamplesTable;
import org.willjt.solaractivity.analyser.AnalyserResults;
import org.willjt.solaractivity.analyser.HeatMeasurementsAnalyser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static stories.helper_classes.ExamplesTableToHeatMeasurementsAnalyserImporter.heatMeasurementsAnalyserFor;


public class ShowHighestRatedLocationSteps extends Embedder {

    private HeatMeasurementsAnalyser measurementsAnalyser;
    private AnalyserResults areaWithHighestScore;

    @Given("an area with the following heat measurements: $exampleMeasurements")
    @Pending
    public void aHeatMeasurementsAnalyserUsing(ExamplesTable exampleMeasurements) {
        measurementsAnalyser = heatMeasurementsAnalyserFor(exampleMeasurements);
    }

    @When("I request the single highest solar activity score")
    @Pending
    public void highestSolarActivityScore() {
        areaWithHighestScore = measurementsAnalyser.areaWithHighestSolarActivityScore();
    }

    @Then("the analyser displays: $expectedOutput")
    @Pending
    public void theAnalyserShouldDisplay(String expectedOutput) {
        String textDisplayed = areaWithHighestScore.printResult();
        assertThat(textDisplayed, equalTo(expectedOutput));
    }
}
