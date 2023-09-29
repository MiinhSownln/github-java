/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 *
 * @author 24dom
 */
public class DbUntil {

    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/EduSys";
    private static String user = "sa";
    private static String password = "123";

    public static Connection getConnection() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        return connection;
    }

    public static Connection getConnection(String dbConfigFile) throws SQLException {
        try (FileInputStream f = new FileInputStream(dbConfigFile)) {
            // load the properties file
            Properties pros = new Properties();
            pros.load(f);
            // assign db parameters
            url = pros.getProperty("url");
            user = pros.getProperty("user");
            password = pros.getProperty("password");
            // create a connection to the database
            return getConnection();
        } catch (IOException e) {
            return null;
        }
    }
}
