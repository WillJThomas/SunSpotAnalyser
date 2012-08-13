package org.willjt.solaractivity.calculation;

public class SolarActivityScoreCalculator {
    private int[][] measurementsGrid;

    public SolarActivityScoreCalculator(int[][] measurementsGrid) {
        this.measurementsGrid = measurementsGrid;
    }

    public int scoreForLocation(int column, int row) {
        if (locationIsNotWithinGridBounds(column, row)) {
            throw new IllegalArgumentException("This (column,row) location is not within the grid bounds: (" + column + "," + row + ")");
        }
        ;

        int indexOfFirstColumnToCount = indexMinusOneOrIndexIfZero(column);
        int indexOflastColumnToCount = indexPlusOneOrIndexIfLastColumn(column);
        int indexOfFirstRowToCount = indexMinusOneOrIndexIfZero(row);
        int indexOfLastRowToCount = indexPlusOneOrIndexIfLastRow(row);

        int locationScore = sumOfMeasurementsInGridArea(indexOfFirstColumnToCount, indexOflastColumnToCount, indexOfFirstRowToCount, indexOfLastRowToCount);

        return locationScore;
    }

    private int sumOfMeasurementsInGridArea(int indexOfFirstColumn, int indexOflastColumn, int indexOfFirstRow, int indexOfLastRow) {
        int sum = 0;

        for (int columnIndex = indexOfFirstColumn; columnIndex <= indexOflastColumn; columnIndex++) {
            for (int rowIndex = indexOfFirstRow; rowIndex <= indexOfLastRow; rowIndex++) {
                sum += measurementsGrid[columnIndex][rowIndex];
            }
        }
        return sum;
    }

    private int indexPlusOneOrIndexIfLastRow(int rowIndex) {
        int indexToUse = rowIndex + 1;
        while (indexToUse == measurementsGrid[0].length) {
            indexToUse--;
        }
        return indexToUse;
    }

    private int indexPlusOneOrIndexIfLastColumn(int columnIndex) {
        int indexToUse = columnIndex + 1;
        if (indexToUse == measurementsGrid.length) {
            indexToUse--;
        }
        return indexToUse;
    }

    private int indexMinusOneOrIndexIfZero(int index) {
        int indexToUse = index - 1;

        if (indexToUse < 0) {
            indexToUse++;
        }

        return indexToUse;
    }

    private boolean locationIsNotWithinGridBounds(int column, int row) {
        if (column < 0 || row < 0) {
            return true;
        }
        if (column >= measurementsGrid.length || row >= measurementsGrid[0].length) {
            return true;
        }

        return false;
    }
}
