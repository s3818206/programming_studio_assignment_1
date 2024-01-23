package app;
import java.util.Map;

public class Population {
    private int id;
    private String countryName;
    private String countryCode;
    Map<Integer, Double> populationData;

    public int getId() { return this.id; }
    public String getCountryCode() { return this.countryCode; }
    public String getCountryName() { return this.countryName;}
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
    public void setCountryName(String countryName) { this.countryName = countryName; }
    public void setId(int id) { this.id = id; }
    public Map<Integer, Double> getPopulationData() { return populationData; }
    public void setPopulationData(int year, double population) { this.populationData.put(year, population); }
}
