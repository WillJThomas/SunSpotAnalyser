package org.willjt.analyser;

import java.util.List;

public class IntegerGridParser {
    public static int[][] fromListOfValues(List<Integer> listOfValues, int rowsRequired, int columnsRequired) {
        int[][] ourIntegerGrid = new int[rowsRequired][columnsRequired];

        int indexInValuesListWeReached = 0;
        for (int row = 0; row < rowsRequired; row++) {
            for (int column = 0; column < columnsRequired; column++) {
                int gridValue = 0;
                if (indexInValuesListWeReached < listOfValues.size()) {
                    gridValue = listOfValues.get(indexInValuesListWeReached);
                }
                ourIntegerGrid[row][column] = gridValue;
                indexInValuesListWeReached++;
            }
        }

        return ourIntegerGrid;
    }
}
