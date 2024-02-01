package app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.lang.Integer;

import io.javalin.http.Context;
import io.javalin.http.Handler;

public class PageDashboard_s3a implements Handler  {
    private static final String TEMPLATE = ("dashboard_s3a.html");

    @Override
    public void handle(Context context) throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        JDBCConnection jdbc = new JDBCConnection();

        ArrayList<String> regions = new ArrayList<String>();
        regions.add("Global");
        regions.add("Country");
        regions.add("State");
        regions.add("City");
        model.put("regions", regions);

        String startYear = context.formParam("StartYear");
        System.out.println(startYear);
        String yearRange = context.formParam("YearRange");
        System.out.println(yearRange);
        int intStartYear = startYear != null ? Integer.valueOf(startYear) : 0;
        int intYearRange = yearRange != null ? Integer.valueOf(yearRange) : 0;
        String selectedRegion = context.formParam("Region");
        model.put("selectedRegion", selectedRegion);

        if(intStartYear != 0 && intYearRange != 0 && selectedRegion != null && intStartYear >= 1750 && intStartYear + intYearRange <= 2015){
            jdbc.submitAverageTemp(selectedRegion, intStartYear, intYearRange);
        }

        ArrayList<AverageTempByRegion> averageTempByRegion = jdbc.getAverageTempByRegion();

        for (AverageTempByRegion temp : averageTempByRegion) {
            System.out.println("Region: " + temp.getRegion());
            System.out.println("Year: " + temp.getYear());
            System.out.println("Year Range: " + temp.getYearRange());
            System.out.println("Average Temp: " + temp.getAverageTemp());
            System.out.println("-----------------------------");
        }

        model.put("AverageTempByRegion", averageTempByRegion);
        
        context.render(TEMPLATE, model);
    }
}
