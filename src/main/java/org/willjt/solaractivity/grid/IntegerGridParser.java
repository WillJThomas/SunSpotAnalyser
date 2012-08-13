package org.willjt.solaractivity.grid;

import java.util.List;

public class IntegerGridParser {
    public static int[][] parseIntegerGridFromListOfValues(List<Integer> listOfValues, int columnsRequired, int rowsRequired) {
        int[][] ourIntegerGrid = new int[columnsRequired][rowsRequired];

        int indexInValuesListWeReached = 0;
        for (int row = 0; row < rowsRequired; row++) {
            for (int column = 0; column < columnsRequired; column++) {
                int gridValue = 0;
                if (indexInValuesListWeReached < listOfValues.size()) {
                    gridValue = listOfValues.get(indexInValuesListWeReached);
                }
                ourIntegerGrid[column][row] = gridValue;
                indexInValuesListWeReached++;
            }
        }

        return ourIntegerGrid;
    }
}
