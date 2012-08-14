package org.willjt.solaractivity.analyser;

import java.util.ArrayList;
import java.util.List;

public class AnalyserResults {
    private int highestScore;
    private int columnOfLocationWithHighestScore;
    private int rowOfLocationWithHighestScore;
    private List<SolarActivityMeasurement> topAreasForSolarActivity;

    public AnalyserResults(SolarActivityMeasurement topAreaForSolarActivity) {
        topAreasForSolarActivity = new ArrayList<SolarActivityMeasurement>();
        topAreasForSolarActivity.add(topAreaForSolarActivity);
    }

    public AnalyserResults(List<SolarActivityMeasurement> topAreasForSolarActivity) {
        this.topAreasForSolarActivity = topAreasForSolarActivity;
    }

    @Override
    public String toString() {
        StringBuffer output = new StringBuffer();

        for(SolarActivityMeasurement area : topAreasForSolarActivity) {
            output.append("(" + area.column() + "," + area.row() +" score:" + area.solarActivityScore() +")");
        }

        return output.toString();
    }
}
