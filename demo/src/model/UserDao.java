/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 24dom
 */
public class UserDao {
    List<User> list=new ArrayList<>();
    public UserDao(){
        list.add(new User("son","123",true));
    }
    public boolean checkLogin(String username,String password){
        for(User us:list){
            if(us.getUsername().equalsIgnoreCase(username)&&us.getPassword().equalsIgnoreCase(password)){
                return  true;
            }
        }
        return false;
    }
}
