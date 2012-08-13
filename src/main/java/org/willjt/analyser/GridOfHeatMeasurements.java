package org.willjt.analyser;

import java.util.ArrayList;

public class GridOfHeatMeasurements {
    private int[][] values;

    public GridOfHeatMeasurements(int gridSize, ArrayList<Integer> measurementValues) {
        int numberOfRows = gridSize;
        int numberOfColumns = gridSize;

        values = IntegerGridParser.fromListOfValues(measurementValues, numberOfRows, numberOfColumns);
    }

    public AnalyserResults areasWithHighestSolarActivity(int numberOfResultsRequested) {
        return null;
    }
}
