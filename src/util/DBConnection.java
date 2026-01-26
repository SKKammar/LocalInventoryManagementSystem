package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/inventory_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Santosh";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static boolean testConnection() {
        Connection con = getConnection();
        if (con != null) {
            try {
                con.close();
            } catch (Exception ignored) {}
            return true;
        }
        return false;
    }

}
