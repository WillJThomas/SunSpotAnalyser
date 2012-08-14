package org.willjt.solaractivity.analyser;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SolarActivityMeasurementTest {

    public static final int ANY_COLUMN_INDEX = 1;
    public static final int ANY_ROW_INDEX = 1;

    @Test
    public void compareToShouldReturnMinusOneIfOtherObjectHasHigherSolarActivityScore() {
        int ourLocationScore = 2;
        int higherLocationScore = 9;

        SolarActivityMeasurement ourMeasurement = new SolarActivityMeasurement(ANY_COLUMN_INDEX, ANY_ROW_INDEX, ourLocationScore);
        SolarActivityMeasurement measurementWithHigherScore = new SolarActivityMeasurement(ANY_COLUMN_INDEX, ANY_ROW_INDEX, higherLocationScore);

        assertThat(ourMeasurement.compareTo(measurementWithHigherScore), equalTo(-1));
    }

    @Test
    public void compareToShouldReturnZeroIfOtherObjectHasSameSolarActivityScore() {
        int locationScoreForBoth = 2;

        SolarActivityMeasurement ourMeasurement = new SolarActivityMeasurement(ANY_COLUMN_INDEX, ANY_ROW_INDEX, locationScoreForBoth);
        SolarActivityMeasurement measurementWithSameScore = new SolarActivityMeasurement(ANY_COLUMN_INDEX, ANY_ROW_INDEX, locationScoreForBoth);

        assertThat(ourMeasurement.compareTo(measurementWithSameScore), equalTo(0));
    }


    @Test
    public void compareToShouldReturnOneIfOtherObjectHasLowerSolarActivityScore() {
        int ourLocationScore = 9;
        int lowerLocationScore = 2;


        SolarActivityMeasurement ourMeasurement = new SolarActivityMeasurement(ANY_COLUMN_INDEX, ANY_ROW_INDEX, ourLocationScore);
        SolarActivityMeasurement measurementWithLowerScore = new SolarActivityMeasurement(ANY_COLUMN_INDEX, ANY_ROW_INDEX, lowerLocationScore);

        assertThat(ourMeasurement.compareTo(measurementWithLowerScore), equalTo(1));
    }
}
