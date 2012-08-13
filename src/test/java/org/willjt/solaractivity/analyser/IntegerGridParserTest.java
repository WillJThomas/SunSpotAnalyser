package org.willjt.solaractivity.analyser;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class IntegerGridParserTest {

    @Test
    public void returnsAnEmptyGridIfDimensionsRequestedAreZeroByZero() throws Exception {
        List<Integer> emptyList = new ArrayList<Integer>();
        int rows = 0;
        int columns = 0;

        int[][] gridReturned = IntegerGridParser.parseIntegerGridFromListOfValues(emptyList, rows, columns);

        assertThat(gridReturned.length, is(0));
    }

    @Test
    public void transformsAListOfValuesIntoATwoDimensionalArray() {
        List<Integer> listOfValues = new ArrayList<Integer>();
        listOfValues.add(Integer.valueOf(1));
        listOfValues.add(Integer.valueOf(2));
        listOfValues.add(Integer.valueOf(3));
        listOfValues.add(Integer.valueOf(4));
        int rows = 2;
        int columns = 2;

        int[][] gridReturned = IntegerGridParser.parseIntegerGridFromListOfValues(listOfValues, rows, columns);

        assertThat(gridReturned[0][0], equalTo(1));
        assertThat(gridReturned[0][1], equalTo(2));
        assertThat(gridReturned[1][0], equalTo(3));
        assertThat(gridReturned[1][1], equalTo(4));
    }

    @Test
    public void fillsRemainingCellsWithZerosIfNumberOfValuesPassedIsLessThanSizeOfTheGrid() {
        List<Integer> listOfValues = new ArrayList<Integer>();
        listOfValues.add(Integer.valueOf(1));
        listOfValues.add(Integer.valueOf(2));
        int rows = 2;
        int columns = 2;

        int[][] gridReturned = IntegerGridParser.parseIntegerGridFromListOfValues(listOfValues, rows, columns);

        assertThat(gridReturned[0][0], equalTo(1));
        assertThat(gridReturned[0][1], equalTo(2));
        assertThat(gridReturned[1][0], equalTo(0));
        assertThat(gridReturned[1][1], equalTo(0));
    }


}