package org.willjt.solaractivity.analyser;

public class AnalyserResults {
    private int highestScore;
    private int columnOfLocationWithHighestScore;
    private int rowOfLocationWithHighestScore;

    public AnalyserResults(int highestScore, int columnOfLocationWithHighestScore, int rowOfLocationWithHighestScore) {
        this.highestScore = highestScore;
        this.columnOfLocationWithHighestScore = columnOfLocationWithHighestScore;
        this.rowOfLocationWithHighestScore = rowOfLocationWithHighestScore;
    }

    @Override
    public String toString() {
        return "(" + columnOfLocationWithHighestScore + "," + rowOfLocationWithHighestScore +" score:" + highestScore +")";
    }
}
