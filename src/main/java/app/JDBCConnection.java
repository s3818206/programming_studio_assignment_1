package app;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {
    private static final String MEMBER_DATABASE = "jdbc:sqlite:database/member.db";

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
}
