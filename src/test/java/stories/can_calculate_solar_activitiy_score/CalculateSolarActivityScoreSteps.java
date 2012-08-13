package stories.can_calculate_solar_activitiy_score;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.model.ExamplesTable;
import org.willjt.solaractivity.calculation.SolarActivityScoreCalculator;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.willjt.solaractivity.grid.IntegerGridParser.parseIntegerGridFromListOfValues;
import static stories.helper_classes.ExamplesTableToListOfHeatMeasurementsConverter.toListOfMeasurements;

public class CalculateSolarActivityScoreSteps {

    private int[][] gridOfMeasurements;
    private int calculatedScore;

    @Given("an area with the following heat measurements: $exampleMeasurements")
    public void aGridOfMeasurements(ExamplesTable exampleMeasurements) {
        List<Integer> measurementValues = toListOfMeasurements(exampleMeasurements);
        int numberOfRowsInGrid = exampleMeasurements.getRowCount();
        int numberOfColumnsInGrid = exampleMeasurements.getHeaders().size();
        gridOfMeasurements = parseIntegerGridFromListOfValues(measurementValues, numberOfRowsInGrid, numberOfColumnsInGrid);
    }

    @When("I calculate the solar activity score of location ($column,$row)")
    public void calculateTheSolarActivityScoreFor(int row, int column) {
        SolarActivityScoreCalculator calculator = new SolarActivityScoreCalculator(gridOfMeasurements);
        calculatedScore = calculator.scoreForLocation(column, row);
    }

    @Then("the result should be $expectedScore")
    public void theResultShouldBe(int expectedScore) {
        assertThat(calculatedScore, equalTo(expectedScore));
    }
}
