package stories.helper_classes;

import org.jbehave.core.model.ExamplesTable;
import org.willjt.solaractivity.analyser.HeatMeasurementsAnalyser;

import java.util.List;

public class ExamplesTableToHeatMeasurementsAnalyserImporter {


    public static HeatMeasurementsAnalyser heatMeasurementsAnalyserFor(ExamplesTable table) {
        if (numberOfColumnsInExampleTable(table) != numberOfRowsInExampleTable(table)) {
            throw new IllegalArgumentException("We are only able to analyse grid areas with equal dimensions");
        }

        List<Integer> values = ExamplesTableToListOfHeatMeasurementsConverter.toListOfMeasurements(table);

        int gridSize = numberOfColumnsInExampleTable(table);

        return new HeatMeasurementsAnalyser(gridSize, values);
    }

    private static int numberOfRowsInExampleTable(ExamplesTable table) {
        return table.getRowCount();
    }

    private static int numberOfColumnsInExampleTable(ExamplesTable table) {
        return table.getHeaders().size();
    }
}