package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String HOST = "localhost";
    private static final int PORT = 3306;
    private static final String DBNAME = "LibraryManagementSystem2";
    private static final String USER = "root";
    private static final String PASSWORD = "9828807288";
    private static final String URL = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DBNAME;

    static {
        try {
            Class.forName(DRIVER); 
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. ");
            e.printStackTrace();
        }
    }

    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to database successfully");
        } catch (SQLException e) {
            System.err.println("Connection failed. Check output console");
            e.printStackTrace();
        }
        return conn;
    }
}
