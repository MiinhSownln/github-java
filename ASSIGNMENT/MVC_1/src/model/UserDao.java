/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import service.DBconnect;

/**
 *
 * @author 24dom
 */
public class UserDao {

    List<User> list = new ArrayList<>();
    String sql = "";
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    UserDao use;

    public User getByID(String username) {
        sql = "Select*from USERS where username=?";
        User user = null;
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                user = new User(rs.getString(1), rs.getString(2), rs.getBoolean(3));

            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserDao() {
        list.add(new User("son", "123", true));
    }

//    public boolean checkLogin(String username, String password) {
//        for (User us : list) {
//            if (us.getUsername().equalsIgnoreCase(username) && us.getPassword().equalsIgnoreCase(password)) {
//                return true;
//            }
//        }
//        return false;
//    }
    
       public boolean checkLogin(String username, String password) {
           User user=getByID(username);
           if(user!=null){//cos
               if(user.getPassword().equals(password)){
                   return true;
               }
           }
        return false;
       }
}
