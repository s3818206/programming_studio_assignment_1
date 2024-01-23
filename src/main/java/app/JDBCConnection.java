package app;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

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

    public long getWorldPopulation_2013() {
        long worldPopulation_2013 = 0 ;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATASET_DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30); 

            String query = "SELECT SUM(\"2013\") AS total FROM Population";
            ResultSet results = statement.executeQuery(query);
            if(results.next()){
                worldPopulation_2013 = results.getLong("total");
            }
            return worldPopulation_2013;
        
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
        return worldPopulation_2013;
    }

    public ArrayList<WorldPopulation> getWorldPopulation() {
        ArrayList<WorldPopulation> worldPopulations = new ArrayList<WorldPopulation>();
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(DATASET_DATABASE);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            String query = "SELECT * FROM WORLDPOPULATION";
            ResultSet results = statement.executeQuery(query);
            while(results.next()){
                WorldPopulation worldPopulation = new WorldPopulation(); 
                worldPopulation.setYear(results.getString("Year"));
                worldPopulation.setPopulation(results.getLong("WorldPopulation"));
                worldPopulations.add(worldPopulation);
            }
            return worldPopulations;
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
        return worldPopulations;
    }
    
}
