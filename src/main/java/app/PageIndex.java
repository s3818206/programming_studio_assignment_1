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


        
        // ArrayList<WorldPopulation> worldPopulations = jdbc.getGlobalPopulation();
    
        // TODO: Your work for Thymeleaf and JDBC
        ArrayList<String> Year = new ArrayList<String>();
        ArrayList<Long> WorldPopulationlist = new ArrayList<Long>();
     

        model.put("year", Year);
        model.put("worldPopulation", WorldPopulationlist);
        

        // ArrayList<GlobalTemp> GlobalYearlyTempList = jdbc.getGlobalTemp();
        // model.put("GlobalYearlyTemp", GlobalYearlyTempList);




        // No code below this
        context.render(TEMPLATE, model);
    }
}
