/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.sql.*;
import javax.management.RuntimeErrorException;

/**
 *
 * @author 24dom
 */
public class JDBCHelper {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dbUrl = "jdbc:sqlserver://localhost;database=EduSys";
    private static String user = "sa";
    private static String pass = "123";

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static PreparedStatement getSttm(String sql, Object... args) throws SQLException {
        Connection conncet = DriverManager.getConnection(dbUrl, user, pass);
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
}
