/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 24dom
 */
public class DBconnect {

    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DBNAME = "EduSys";
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "123";
    

    public static java.sql.Connection getConnection() {
        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";"
                + "databaseName=" + DBNAME + ";encrypt=true;trustservercertificate=true;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(connectionUrl, USERNAME, PASSWORD);

        } // Handle any errors that may have occurred.
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
     public static PreparedStatement getSttm(String sql, Object... args) throws SQLException {
        Connection conncet = DriverManager.getConnection(DBNAME, USERNAME, PASSWORD);
        PreparedStatement pstmt = null;
        if (sql.trim().startsWith("{")) {
            pstmt = conncet.prepareCall(sql);
        } else {
            pstmt = conncet.prepareStatement(sql);
        }
        for (int i = 0; i < args.length; i++) {
            pstmt.setObject(i + 1, args[i]);
        }
        return pstmt;

    }

    public static int update(String sql, Object... args) {
        try {
            PreparedStatement stms = getSttm(sql, args);
            try {
                return stms.executeUpdate();
            } finally {
                stms.getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static ResultSet query(String sql, Object... agrs) {
        try {
            PreparedStatement stms = getSttm(sql, agrs);
            return stms.executeQuery();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            throw new RuntimeException(e);

        }
        return null;
    }

    public static void main(String[] args) throws SQLException {
        java.sql.Connection conn = getConnection();
        DatabaseMetaData dbmt = conn.getMetaData();
        System.out.println(dbmt.getDriverName());
        System.out.println(dbmt.getDatabaseProductName());
        System.out.println(dbmt.getDatabaseProductVersion());

    }

   

}
