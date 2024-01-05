package app;

import java.util.HashMap;
import java.util.Map;

public class Population {
    private int id;
    private String countryName;
    private String countryCode;
    Map<Integer, Double> temperatureData;

    public String getCountryCode() {
        return countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public int getId() {
        return id;
    }

    public Map<Integer, Double> getTemperatureData() {
        return temperatureData;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setId(int id) {
        this.id = id;
    }
}
