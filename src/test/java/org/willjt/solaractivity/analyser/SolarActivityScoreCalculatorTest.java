package org.willjt.solaractivity.analyser;

import org.junit.Test;

public class SolarActivityScoreCalculatorTest {

    @Test
    public void aLocationsScoreEqualsItsHeatMeasurementPlusTheMeasurementsForImmediatelySurroundingAreas() {
        int[][] measurements = new int[3][3];
        measurements [0][0] = 5;
        measurements [0][1] = 3;
        measurements [0][2] = 1;
        measurements [1][0] = 4;
        measurements [1][1] = 1;
        measurements [1][2] = 1;
        measurements [2][0] = 2;
        measurements [2][1] = 3;
        measurements [2][2] = 2;




    }
}
