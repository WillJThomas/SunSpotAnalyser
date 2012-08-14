package org.willjt.solaractivity.analyser;

import org.willjt.solaractivity.calculation.SolarActivityScoreCalculator;
import org.willjt.solaractivity.grid.IntegerGridParser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HeatMeasurementsAnalyser {
    public static final Comparator<Object> DESCENDING_ORDER_BY_SOLAR_ACTIVITY_SCORE = Collections.reverseOrder();
    private int[][] values;
    private int numberOfColumns;
    private int numberOfRows;

    public HeatMeasurementsAnalyser(int gridSize, List<Integer> measurementValues) {
        numberOfColumns = gridSize;
        numberOfRows = gridSize;

        values = IntegerGridParser.parseIntegerGridFromListOfValues(measurementValues, numberOfColumns, numberOfRows);
    }

    public AnalyserResults areaWithHighestSolarActivityScore() {
        List<SolarActivityMeasurement> listOfMeasurements = measurementsListedFromHighestToLowestSolarActivityScore();

        SolarActivityMeasurement areaWithHighestScore = listOfMeasurements.get(0);

        return new AnalyserResults(areaWithHighestScore);
    }

    public AnalyserResults topNAreasWithHighestSolarActivityScores(int n) {
        List<SolarActivityMeasurement> listOfMeasurements = measurementsListedFromHighestToLowestSolarActivityScore();

        List<SolarActivityMeasurement> topNAreas = listOfMeasurements.subList(0, n);

        return new AnalyserResults(topNAreas);
    }

    private List<SolarActivityMeasurement> measurementsListedFromHighestToLowestSolarActivityScore() {
        List<SolarActivityMeasurement> listOfMeasurements = new ArrayList<SolarActivityMeasurement>();

        SolarActivityScoreCalculator scoreCalculator = new SolarActivityScoreCalculator(values);

        for (int columnIndex = 0; columnIndex < numberOfColumns; columnIndex++) {
            for (int rowIndex = 0; rowIndex < numberOfRows; rowIndex++) {
                int locationScore = scoreCalculator.scoreForLocation(columnIndex, rowIndex);

                SolarActivityMeasurement measurement = new SolarActivityMeasurement(columnIndex, rowIndex, locationScore);
                listOfMeasurements.add(measurement);
            }
        }

        Collections.sort(listOfMeasurements, DESCENDING_ORDER_BY_SOLAR_ACTIVITY_SCORE);
        return listOfMeasurements;
    }
}
