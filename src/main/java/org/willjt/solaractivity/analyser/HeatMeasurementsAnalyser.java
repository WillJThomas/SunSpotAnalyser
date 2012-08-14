package org.willjt.solaractivity.analyser;

import org.willjt.solaractivity.calculation.SolarActivityScoreCalculator;
import org.willjt.solaractivity.grid.IntegerGridParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HeatMeasurementsAnalyser {
    private int[][] values;
    private int numberOfColumns;
    private int numberOfRows;

    public HeatMeasurementsAnalyser(int gridSize, List<Integer> measurementValues) {
        numberOfColumns = gridSize;
        numberOfRows = gridSize;

        values = IntegerGridParser.parseIntegerGridFromListOfValues(measurementValues, numberOfColumns, numberOfRows);
    }

    public AnalyserResults areaWithHighestSolarActivityScore() {
        int highestScore = 0;
        int columnOfLocationWithHighestScore = 0;
        int rowOfLocationWithHighestScore = 0;

        SolarActivityScoreCalculator scoreCalculator = new SolarActivityScoreCalculator(values);

        for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
            for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
                int locationScore = scoreCalculator.scoreForLocation(columnIndex, rowIndex);

                if (locationScore >= highestScore) {
                    highestScore = locationScore;
                    columnOfLocationWithHighestScore = columnIndex;
                    rowOfLocationWithHighestScore = rowIndex;
                }
            }
        }

        SolarActivityMeasurement areaWithHighestScore = new SolarActivityMeasurement(columnOfLocationWithHighestScore, rowOfLocationWithHighestScore, highestScore);

        return new AnalyserResults(areaWithHighestScore);
    }

    public AnalyserResults topNAreasWithHighestSolarActivityScores(int n) {
        SolarActivityScoreCalculator scoreCalculator = new SolarActivityScoreCalculator(values);
        
        List<SolarActivityMeasurement> listOfMeasurements = new ArrayList<SolarActivityMeasurement>();

        for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
            for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
                int locationScore = scoreCalculator.scoreForLocation(columnIndex, rowIndex);

                SolarActivityMeasurement measurement = new SolarActivityMeasurement(columnIndex, rowIndex, locationScore);
                listOfMeasurements.add(measurement);
            }
        }

        Collections.sort(listOfMeasurements, Collections.reverseOrder());

        List<SolarActivityMeasurement> topNAreas = listOfMeasurements.subList(0, n);

        return new AnalyserResults(topNAreas);
    }
}
