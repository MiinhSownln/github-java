/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;
import java.sql.*;
/**
 *
 * @author 24dom
 */
public class App {
        public static void main(String[] args) {
        try (Connection con = DbUntil.getConnection();) {
            System.out.println("Connected to MySql Server.");
        } catch (SQLException ex) {
            System.out.println("Connection Error!");
        }
    }
}
