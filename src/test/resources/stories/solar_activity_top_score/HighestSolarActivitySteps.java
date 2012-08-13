package stories.solar_activity_top_score;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Pending;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;
import org.willjt.analyser.AnalyserResults;
import org.willjt.analyser.GridOfHeatMeasurements;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class HighestSolarActivitySteps extends Embedder {

    private GridOfHeatMeasurements measurementsGrid;
    private AnalyserResults areasWithHighestScores;

    @Given("an area with the following heat measurements: $exampleMeasurements")
    @Pending
    public void aGridOfMeasurements(ExamplesTable exampleMeasurements) {
        measurementsGrid = toGridOfHeatMeasurements(exampleMeasurements);
    }

    private GridOfHeatMeasurements toGridOfHeatMeasurements(ExamplesTable table) {
        int gridSize = table.getRowCount();
        ArrayList<Integer> measurementValues = new ArrayList<Integer>();

        for (Parameters row : table.getRowsAsParameters()) {
            for (int columnIndex = 0; columnIndex < gridSize; columnIndex++) {
                int measurement = row.valueAs("Col" + columnIndex, Integer.class);
                measurementValues.add(measurement);
            }
        }

        return new GridOfHeatMeasurements(gridSize, measurementValues);
    }

    @When("I request the single highest solar activity score")
    @Pending
    public void highestSolarActivityScore() {
        areasWithHighestScores = measurementsGrid.areasWithHighestSolarActivity(1);
    }

    @Then("the analyser displays: $expectedOutput")
    @Pending
    public void theAnalyserShouldDisplay(String expectedOutput) {
        String textDisplayed = areasWithHighestScores.printResults();
        assertThat(textDisplayed, equalTo(expectedOutput));
    }



}
