package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import java.text.NumberFormat;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class PageIndex implements Handler  {
    private static final String TEMPLATE = ("index.html");

    @Override
    public void handle(Context context) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();

        JDBCConnection jdbc = new JDBCConnection();

        long worldPopulation = jdbc.getWorldPopulation_2013();  
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        String formattedPopulation = numberFormat.format(worldPopulation);
        model.put("worldPopulation_2013", formattedPopulation); 
        
        ArrayList<WorldPopulation> worldPopulations = jdbc.getWorldPopulation();
        model.put("worldPopulation", worldPopulations);
    
        // TODO: Your work for Thymeleaf and JDBC
        ArrayList<String> Year = new ArrayList<String>();
        ArrayList<Long> WorldPopulationlist = new ArrayList<Long>();
        for (WorldPopulation oneWorldPopulation : worldPopulations){
            Year.add(oneWorldPopulation.getYear());
            WorldPopulationlist.add(oneWorldPopulation.getPopulation());
        }

        model.put("year", Year);
        model.put("worldPopulation", WorldPopulationlist);
        

        // No code below this
        context.render(TEMPLATE, model);
    }
}
