package stories.helper_classes;

import org.jbehave.core.model.ExamplesTable;
import org.jbehave.core.steps.Parameters;

import java.util.ArrayList;
import java.util.List;

public class ExamplesTableToListOfHeatMeasurementsConverter {

    public static List<Integer> toListOfMeasurements(ExamplesTable table) {
        ArrayList<Integer> values = new ArrayList<Integer>();
        int numberOfColumns = numberOfColumnsInExampleTable(table);

        for (Parameters row : table.getRowsAsParameters()) {
            for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
                String columnHeaderName = "Col" + columnIndex;
                int measurementValue = row.valueAs(columnHeaderName, Integer.class);
                values.add(measurementValue);
            }
        }
        return values;
    }

    private static int numberOfColumnsInExampleTable(ExamplesTable table) {
        return table.getHeaders().size();
    }
}
