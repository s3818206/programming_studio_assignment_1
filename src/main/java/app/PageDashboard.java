package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.lang.Integer;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class PageDashboard implements Handler  {
    private static final String TEMPLATE = ("dashboard.html");

    @Override
    public void handle(Context context) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        JDBCConnection jdbc = new JDBCConnection();

        // Set up selected option
        ArrayList<String> temperatureOrPopulation = new ArrayList<String>();
        temperatureOrPopulation.add("Temperature");
        temperatureOrPopulation.add("Population");
        model.put("TemperatureOrPopulation", temperatureOrPopulation);

        ArrayList<String> countryOrGlobal = new ArrayList<String>();
        countryOrGlobal.add("Global");
        countryOrGlobal.add("Country");
        model.put("CountryOrGlobal", countryOrGlobal);

        ArrayList<String> countries = jdbc.getCountryList();
        model.put("countries", countries);

        // Form submit handler
        String selectedTemperatureOrPopulation = context.formParam("TemperatureOrPopulation");
        model.put("selectedTemperatureOrPopulation", selectedTemperatureOrPopulation);
        if(selectedTemperatureOrPopulation != null ){
            if(selectedTemperatureOrPopulation.equals("Population")){
                ArrayList<Integer> year = new ArrayList<Integer>();
                for(int i = 1960 ; i <= 2013 ; i++) {
                    year.add(i);
                }
                model.put("startYears", year);
                model.put("endYears", year);

            }else{
                ArrayList<Integer> year = new ArrayList<Integer>();
                for(int i = 1750 ; i <= 2015 ; i++) {
                    year.add(i);
                }
                model.put("startYears", year);
                model.put("endYears", year);
            }
        }
        
        String selectedCountryOrGlobal = context.formParam("CountryOrGlobal");
        model.put("selectedCountryOrGlobal", selectedCountryOrGlobal);

        String selectedCountry = context.formParam("Country");
        model.put("selectedCountry", selectedCountry);

        ArrayList<String> cities = jdbc.getCityList(selectedCountry);
        model.put("cities", cities);
        ArrayList<String> states = jdbc.getStateList(selectedCountry);
        model.put("states", states);

        String selectedCity = context.formParam("City");
        model.put("selectedCity", selectedCity);
        String selectedState = context.formParam("State");
        model.put("selectedState", selectedState);
    
        String startYear = context.formParam("StartYear");
        String endYear = context.formParam("EndYear");         

        try{
            int intStartYear = startYear != null ? Integer.valueOf(startYear) : 0;
            int intEndYear = endYear != null ? Integer.valueOf(endYear) : 0;
            if(selectedCountryOrGlobal == null) {
                System.out.println("Null input type error");
            } else if(selectedCountryOrGlobal.equals("Global") && selectedTemperatureOrPopulation.equals("Population")) {
                
                Population globalPopulation = jdbc.getPopulation(selectedCountryOrGlobal, intStartYear, intEndYear);
                model.put("GlobalPopulation", globalPopulation);
                ArrayList<Integer> years = new ArrayList<Integer>();
                ArrayList<Long> populations = new ArrayList<Long>();
                for(int i = intStartYear; i <= intEndYear; i++){
                    years.add(i);
                    populations.add(globalPopulation.getPopulation(i));
                }
                
                model.put("globalYears", years);
                model.put("globalPopulations", populations);

            } else if(selectedCountryOrGlobal.equals("Global") && selectedTemperatureOrPopulation.equals("Temperature")){
                ArrayList<GlobalTemp> globalTemp = jdbc.getGlobalTemp(intStartYear, intEndYear);
                model.put("GlobalTemps", globalTemp);
                List<Integer> globalTemperatureYear = globalTemp.stream().map(GlobalTemp::getYear).collect(Collectors.toList());
                List<Double> globalAverageTemp = globalTemp.stream().map(GlobalTemp::getAverageTemp).collect(Collectors.toList()); 
                List<Double> globalMinTemp = globalTemp.stream().map(GlobalTemp::getMinTemp).collect(Collectors.toList());
                List<Double> globalMaxTemp = globalTemp.stream().map(GlobalTemp::getMaxTemp).collect(Collectors.toList());
                List<Double> globalLandOceanAverageTemp = globalTemp.stream().map(GlobalTemp::getLandOceanAverageTemp).collect(Collectors.toList());
                List<Double> globalLandOceanMinTemp = globalTemp.stream().map(GlobalTemp::getLandOceanMinTemp).collect(Collectors.toList());
                List<Double> globalLandOceanMaxTemp = globalTemp.stream().map(GlobalTemp::getLandOceanMaxTemp).collect(Collectors.toList());

                model.put("GlobalTemperatureYear", globalTemperatureYear);
                model.put("globalAverageTemp", globalAverageTemp);
                model.put("globalMinTemp", globalMinTemp);
                model.put("globalMaxTemp", globalMaxTemp);
                model.put("globalLandOceanAverageTemp", globalLandOceanAverageTemp);
                model.put("globalLandOceanMinTemp", globalLandOceanMinTemp);
                model.put("globalLandOceanMaxTemp", globalLandOceanMaxTemp);
            } else if (selectedCountryOrGlobal.equals("Country") && selectedTemperatureOrPopulation.equals("Population")){
                Population countryPopulation = jdbc.getPopulation(selectedCountry, intStartYear, intEndYear);
                System.out.println(countryPopulation.getCountryName());
                model.put("CountryPopulation", countryPopulation);
                ArrayList<Integer> years = new ArrayList<Integer>();
                ArrayList<Long> populations = new ArrayList<Long>();
                
                for(int i = intStartYear; i <= intEndYear; i++){
                    years.add(i);
                    populations.add(countryPopulation.getPopulation(i));
                }
                
                model.put("countryYears", years);
                model.put("countryPopulations", populations);
            } else if (selectedCountryOrGlobal.equals("Country") && selectedTemperatureOrPopulation.equals("Temperature")){
                ArrayList<Temperature> countryTemperatures = jdbc.getCountryTemp(selectedCountry, intStartYear, intEndYear);
                model.put("CountryTemperatures", countryTemperatures);
                List<Integer> countryTemperatureYear = countryTemperatures.stream().map(Temperature::getYear).collect(Collectors.toList());
                List<Double> countryAverageTemp = countryTemperatures.stream().map(Temperature::getAverageTemp).collect(Collectors.toList());
                List<Double> countryMinTemp = countryTemperatures.stream().map(Temperature::getMinTemp).collect(Collectors.toList());
                List<Double> countryMaxTemp = countryTemperatures.stream().map(Temperature::getMaxTemp).collect(Collectors.toList());

                System.out.println(countryTemperatures);

                model.put("CountryTemperatureYear", countryTemperatureYear);
                model.put("countryAverageTemp", countryAverageTemp);
                model.put("countryMinTemp", countryMinTemp);
                model.put("countryMaxTemp", countryMaxTemp);
            }
        } catch (NumberFormatException e) {
            System.out.println("Error converting to integer: " + e.getMessage());
        }
        
        context.render(TEMPLATE, model);
    }
}
