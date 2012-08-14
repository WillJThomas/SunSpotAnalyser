package org.willjt.solaractivity.analyser;

public class SolarActivityMeasurement implements Comparable<SolarActivityMeasurement> {
    private int columnIndex;
    private int rowIndex;
    private int solarActivityScore;

    public SolarActivityMeasurement(int columnIndex, int rowIndex, int solarActivityScore) {
        this.columnIndex = columnIndex;
        this.rowIndex = rowIndex;
        this.solarActivityScore = solarActivityScore;
    }

    @Override
    public int compareTo(SolarActivityMeasurement otherMeasurement) {
        if(solarActivityScore < otherMeasurement.solarActivityScore) {
            return -1;
        }
        else if (solarActivityScore == otherMeasurement.solarActivityScore) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public int column() {
        return columnIndex;
    }

    public int row() {
        return rowIndex;
    }

    public int solarActivityScore() {
        return solarActivityScore;
    }
}
