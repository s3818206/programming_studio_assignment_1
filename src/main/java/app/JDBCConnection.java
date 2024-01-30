package app;
import java.util.ArrayList;

import javax.swing.plaf.PopupMenuUI;

import java.io.PipedOutputStream;

// import javax.naming.spi.DirStateFactory.Result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
    private static final String MEMBER_DATABASE = "jdbc:sqlite:database/member.db";
    private static final String DATASET_DATABASE = "jdbc:sqlite:database/dataSet.db";

    public ArrayList<Member> getMembers() {
        ArrayList<Member> members = new ArrayList<Member>();
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(MEMBER_DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); 

            String query = "SELECT * FROM MEMBER";
            ResultSet results = statement.executeQuery(query);

            while (results.next()) {
                Member member = new Member(); 
                member.setId(results.getInt("id"));
                member.setName(results.getString("studentName"));
                member.setStudentId(results.getString("studentId"));

                members.add(member);
            }
        } catch (SQLException error ) {
            System.err.println(error.getMessage());
        } finally { 
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException error) {
                System.err.println(error.getMessage());
            }
        }
        return members;
    }
    
    public ArrayList<String> getCountryList(){
        ArrayList<String> CountryList = new ArrayList<String>();
        Connection connection = null; 
        try {
            connection = DriverManager.getConnection(DATASET_DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query= "SELECT COUNTRYNAME FROM POPULATION";
            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                CountryList.add(results.getString("CountryName"));
            }
            return CountryList; 
        } catch (SQLException error ) {
            System.err.println(error.getMessage());
        } finally { 
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException error) {
                System.err.println(error.getMessage());
            }
        }
        return CountryList;
    }

    public ArrayList<String> getCityList(String country){
        ArrayList<String> cityList = new ArrayList<String>();
        Connection connection = null; 
        try {
            connection = DriverManager.getConnection(DATASET_DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query= "SELECT City FROM GlobalYearlyLandTempByCity WHERE Country = '" + country + "'";
            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                cityList.add(results.getString("City"));
            }
            return cityList; 
        } catch (SQLException error ) {
            System.err.println(error.getMessage());
        } finally { 
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException error) {
                System.err.println(error.getMessage());
            }
        }
        return cityList;
    }

    public ArrayList<String> getStateList(String country){
        ArrayList<String> stateList = new ArrayList<String>();
        Connection connection = null; 
        try {
            connection = DriverManager.getConnection(DATASET_DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query= "SELECT State FROM GlobalYearlyLandTempByState WHERE Country = '" + country + "'";
            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                stateList.add(results.getString("State"));
            }
            return stateList; 
        } catch (SQLException error ) {
            System.err.println(error.getMessage());
        } finally { 
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException error) {
                System.err.println(error.getMessage());
            }
        }
        return stateList;
    }

    public Population getPopulation(String country, int startYear, int endYear ){
        Population population = new Population(); 
        Connection connection = null; 
        try {
            connection = DriverManager.getConnection(DATASET_DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);
            if(country == null){
                
            } else if(country.equals("Global")){
                String query= "SELECT CountryName, CountryCode";
                for(int i = startYear; i <= endYear; i++){
                    query+= ", [" + i + "]"; 
                }
                query+= "FROM Population WHERE CountryName = \"World\"";
                ResultSet results = statement.executeQuery(query);
                while(results.next()){
                    population.setCountryName(results.getString("CountryName"));
                    population.setCountryCode(results.getString("CountryCode"));
                    for(int i = startYear; i <= endYear; i++){
                        population.setPopulations(i, results.getLong(Integer.toString(i)));
                    }
                }
            }else {
                String query= "SELECT CountryName, CountryCode";
                for(int i = startYear; i <= endYear; i++){
                    query+= ", [" + i + "]"; 
                }
                query+= "FROM Population WHERE CountryName = \"" + country + "\"";
                ResultSet results = statement.executeQuery(query);
                while(results.next()){
                    population.setCountryName(results.getString("CountryName"));
                    population.setCountryCode(results.getString("CountryCode"));
                    for(int i = startYear; i <= endYear; i++){
                        population.setPopulations(i, results.getLong(Integer.toString(i)));
                    }
                }
            }
            return population; 
        } catch (SQLException error ) {
            System.err.println(error.getMessage());
        } finally { 
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException error) {
                System.err.println(error.getMessage());
            }
        }
        return population;
    }

    public ArrayList<GlobalTemp> getGlobalTemp(int startYear, int endYear){
        ArrayList<GlobalTemp> globalYearlyTemps = new ArrayList<GlobalTemp>();
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATASET_DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT * FROM GlobalYearlyTemp WHERE Year BETWEEN " + startYear + " AND " + endYear;
            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                GlobalTemp globalYearlyTemp = new GlobalTemp();
                globalYearlyTemp.setYear(results.getInt("Year"));
                globalYearlyTemp.setAverageTemp(results.getDouble("AverageTemperature"));
                globalYearlyTemp.setMinTemp(results.getDouble("MinimumTemperature"));
                globalYearlyTemp.setMaxTemp(results.getDouble("MaximumTemperature"));
                globalYearlyTemp.setLandOceanAverageTemp(results.getDouble("LandOceanAverageTemperature"));
                globalYearlyTemp.setLandOceanMinTemp(results.getDouble("LandOceanMinimumTemperature"));
                globalYearlyTemp.setLandOceanMaxTemp(results.getDouble("LandOceanMaximumTemperature"));

                globalYearlyTemps.add(globalYearlyTemp);
            }
            return globalYearlyTemps;
        } catch (SQLException error ) {
            System.err.println(error.getMessage());
        } finally { 
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException error) {
                System.err.println(error.getMessage());
            }
        }
        return globalYearlyTemps;
    }


    public ArrayList<Temperature>  getCountryTemp(String country, int startYear, int endYear){
        ArrayList<Temperature> countryTemperatures = new ArrayList<Temperature>();
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATASET_DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT * FROM GlobalYearlyLandTempByCountry WHERE (Year BETWEEN " + startYear + " AND " + endYear + ") AND Country = '" + country + "'";
            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                Temperature newCountryTemperature = new Temperature(); 
                newCountryTemperature.setYear(results.getInt("Year"));
                newCountryTemperature.setAverageTemp(results.getDouble("AverageTemperature"));
                newCountryTemperature.setMinTemp(results.getDouble("MinimumTemperature"));
                newCountryTemperature.setMaxTemp(results.getDouble("MaximumTemperature"));
                countryTemperatures.add(newCountryTemperature);
            }
            return countryTemperatures;
        } catch (SQLException error ) {
            System.err.println(error.getMessage());
        } finally { 
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException error) {
                System.err.println(error.getMessage());
            }
        }
        return countryTemperatures;
    }
    
}
