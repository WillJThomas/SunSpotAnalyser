package org.willjt.solaractivity.analyser;

import org.willjt.solaractivity.grid.IntegerGridParser;

import java.util.List;

public class HeatMeasurementsAnalyser {
    private int[][] values;

    public HeatMeasurementsAnalyser(int gridSize, List<Integer> measurementValues) {
        int numberOfRows = gridSize;
        int numberOfColumns = gridSize;

        values = IntegerGridParser.parseIntegerGridFromListOfValues(measurementValues, numberOfRows, numberOfColumns);
    }

    public AnalyserResults areaWithHighestSolarActivityScore() {
        return null;
    }
}
