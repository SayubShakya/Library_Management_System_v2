package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestJDBCUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/libmanage";
    private static final String USER = "root";
    private static final String PASSWORD = "9828807288";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database.");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student");

            while (rs.next()) {
                System.out.println("Student ID: " + rs.getInt("sid") + ", Name: " + rs.getString("sname"));
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


