package backend.src.main.java;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class App {
    public static void main(String[] args) {
        JDBCConnection jdbc = new JDBCConnection();
        ArrayList<Member> members = jdbc.getMembers();
        for (Member member : members) {
            System.out.println("\t" + member.getName() + ":" + member.getStudentId());
        }
    }
}