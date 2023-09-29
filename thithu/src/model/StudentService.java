/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import service.DBconnect;

/**
 *
 * @author 24dom
 */
public class StudentService implements InfStudent {

    String sql = "";
    PreparedStatement ps = null;
    Connection con = null;
    ResultSet rs = null;

    @Override
    public int add(Student st) {
        sql = "INSERT INTO STUDENT(NAME,PASSWORD,MARK) VALUES(?,?,?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, st.getName());
            ps.setObject(2, st.getPass());
            ps.setObject(3, st.getMark());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(Student st, int id) {
        sql = "UPDATE STUDENT SET NAME=?,PASSWORD=?,MARK=? WHERE ID=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, st.getName());
            ps.setObject(2, st.getPass());
            ps.setObject(3, st.getMark());
            ps.setObject(4, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(int id) {
        sql = "Delete from student where id=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Student> getAll() {
        sql = "SELECT *FROM STUDENT";
        List<Student> list = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Student st = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
                list.add(st);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
