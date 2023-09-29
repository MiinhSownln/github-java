/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import service.DBcn;

/**
 *
 * @author 24dom
 */
public class SachService {

    String sql = "";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Sach> getAll() {
        String sql = "Select *from SACH";
        List<Sach> list = new ArrayList<>();
        try {
            con = DBcn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sach book = new Sach(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
                list.add(book);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addSinhVien(Sach book) {
        sql = "INSERT INTO SACH(MASACH,TENSACH,THELOAI,DONGIA) VALUES(?,?,?,?)";
        try {
            con = DBcn.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, book.getMaSach());
            ps.setObject(2, book.getTenSach());
            ps.setObject(3, book.getTheLoai());
            ps.setObject(4, book.getDonGia());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(Sach book, int id) {
        String sql = "update sach set masach=?,tensach=?,theloai=?,dongia=? where id=?";
        try {
            con = DBcn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, book.getMaSach());
            ps.setObject(2, book.getTenSach());
            ps.setObject(3, book.getTheLoai());
            ps.setObject(4, book.getDonGia());
            ps.setObject(5, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Sach> find(String theLoai) {
        sql = "select *from Sach where THELOAI=?";
        List<Sach> list = new ArrayList<>();
        try {
            con = DBcn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, theLoai);
            rs = ps.executeQuery();
            while (rs.next()) {
                Sach book = new Sach(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
                list.add(book);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public Sach getSach(String ma) {
        sql = "SELECT * FROM sach  WHERE masach=?";
        Sach book = null;
        try {
            con = DBcn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                 book = new Sach(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
            }
            return book;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
