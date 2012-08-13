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
        if (column >= measurementsGrid.length || row >= measurementsGrid[0].length) {
            throw new IllegalArgumentException("This location is out of the grid bounds: " + column + "," + row);
        }

        int locationScore = 0;

        int indexOfFirstColumnToCount = column - 1;
        int indexOfFirstRowToCount = row - 1;

        while (indexOfFirstColumnToCount < 0) {
            indexOfFirstColumnToCount++;
        }

        while (indexOfFirstRowToCount < 0) {
            indexOfFirstRowToCount++;
        }

        int indexOflastColumnToCount = column + 1;
        int indexOfLastRowToCount = row + 1;

        while (indexOflastColumnToCount >= measurementsGrid.length) {
            indexOflastColumnToCount--;
        }

        while (indexOfLastRowToCount >= measurementsGrid[0].length) {
            indexOfLastRowToCount--;
        }

        for (int columnIndex = indexOfFirstColumnToCount; columnIndex <= indexOflastColumnToCount; columnIndex++) {
            for (int rowIndex = indexOfFirstRowToCount; rowIndex <= indexOfLastRowToCount; rowIndex++) {
                locationScore += measurementsGrid[columnIndex][rowIndex];
            }
        }

        return locationScore;
    }
}
