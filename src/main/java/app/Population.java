package app;
import java.util.HashMap;

public class Population {
    private String countryName;
    private String countryCode;
    private HashMap<Integer, Long> population = new HashMap<Integer, Long>();

    public String getCountryCode() { return this.countryCode; }
    public String getCountryName() { return this.countryName;}
    public Long getPopulation(int year) { return population.get(year); }
    public void setCountryName(String countryName) { this.countryName = countryName; }
    public void setCountryCode(String countryCode) { this.countryCode = countryCode; }
    public void setPopulations(int year, long yearPopulation) { this.population.put(year, yearPopulation); }
}
