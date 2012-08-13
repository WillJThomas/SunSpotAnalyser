package org.willjt.solaractivity.calculation;

public class SolarActivityScoreCalculator {
    private int[][] measurementsGrid;

    public SolarActivityScoreCalculator(int[][] measurementsGrid) {
        this.measurementsGrid = measurementsGrid;
    }

    public int scoreForLocation(int column, int row) {
        if (column < 0 || row < 0) {
            throw new IllegalArgumentException("Both column and row number of location must both be at least 0.");
        }
        if (column > measurementsGrid.length || row > measurementsGrid[0].length) {
            throw new IllegalArgumentException("This location is out of the grid bounds: " + column + "," + row);
        }

        int locationScore = 0;

        int firstColumnToCount = column - 1;
        int firstRowToCount = row - 1;

        while (firstColumnToCount < 0) {
            firstColumnToCount++;
        }

        while (firstRowToCount < 0) {
            firstRowToCount++;
        }

        int lastColumnToCount = column + 1;
        int lastRowToCount = row + 1;

        while (lastColumnToCount > measurementsGrid.length) {
            lastColumnToCount--;
        }

        while (lastRowToCount > measurementsGrid[0].length) {
            lastRowToCount--;
        }

        for (int columnIndex = firstColumnToCount; columnIndex <= lastColumnToCount; columnIndex++) {
            for (int rowIndex = firstRowToCount; rowIndex <= lastRowToCount; rowIndex++) {
                locationScore += measurementsGrid[columnIndex][rowIndex];
            }
        }

        return locationScore;
    }
}
