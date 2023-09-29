/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Student;
 
/**
 *
 * @author 24dom
 */
public class StudentService {

    String sql = "";
    PreparedStatement ps = null;
    Connection con = null;
    ResultSet rs = null;

    public List<Student> getAll() {
        sql = "SELECT *FROM STUDENT";
        List<Student> list = new ArrayList<>();
        try {
            con = ketnoi.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student sv = new Student(rs.getString(1),
                        rs.getBoolean(2), rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(sv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public int delete(String id) {
        sql = "DELETE FROM STUDENT WHERE ID=?";
        try {
            con = ketnoi.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int add(Student st) {
        sql = "INSERT INTO STUDENT(ID,GIOITINH,DIACHI,PHONE,EMAIL) VALUES(?,?,?,?,?)";
        try {
            con = ketnoi.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, st.getId());
            ps.setObject(2, st.isGender());
            ps.setObject(3, st.getAddress());
            ps.setObject(4, st.getPhone());
            ps.setObject(5, st.getEmail());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    public Student getStudent(String id){
        sql="SELECT *FROM STUDENT WHERE ID=?";
        Student st=null;
        try {
            con = ketnoi.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            rs=ps.executeQuery();
            while(rs.next()){
               st=new Student(rs.getString(1),rs.getBoolean(2),rs.getString(3),rs.getString(4),rs.getString(5));
            }
            return st;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    }

