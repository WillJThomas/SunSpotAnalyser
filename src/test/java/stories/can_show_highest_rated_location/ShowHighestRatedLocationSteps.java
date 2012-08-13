package stories.can_show_highest_rated_location;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.model.ExamplesTable;
import org.willjt.solaractivity.analyser.AnalyserResults;
import org.willjt.solaractivity.analyser.HeatMeasurementsAnalyser;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static stories.helper_classes.ExamplesTableIntoHeatMeasurementsAnalyserImporter.heatMeasurementsAnalyserFor;


public class ShowHighestRatedLocationSteps extends Embedder {

    private HeatMeasurementsAnalyser measurementsAnalyser;
    private AnalyserResults analysisResults;

    @Given("an area with the following heat measurements: $exampleMeasurements")
    public void aHeatMeasurementsAnalyserUsing(ExamplesTable exampleMeasurements) {
        measurementsAnalyser = heatMeasurementsAnalyserFor(exampleMeasurements);
    }

    @When("I request the single highest solar activity score")
    public void highestSolarActivityScore() {
        analysisResults = measurementsAnalyser.areaWithHighestSolarActivityScore();
    }

    @Then("the analyser displays: $expectedOutput")
    public void theAnalyserShouldDisplay(String expectedOutput) {
        String textDisplayed = analysisResults.toString();
        assertThat(textDisplayed, equalTo(expectedOutput));
    }
}
