/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Inf.NewInterface;
import model.XeMay;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 24dom
 */
public class XeMayService implements NewInterface {

    Connection con = null;
    String sql = "";
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<XeMay> getAll() {
        sql = "SELECT Ma,Ten,GiaNhap,GiaBan,SoLuong,TrangThai FROM Xemay";
        List<XeMay> list = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                XeMay xm = new XeMay(rs.getString(1), rs.getString(2), rs.getDouble(3),
                        rs.getDouble(4), rs.getInt(5), rs.getInt(6));
                list.add(xm);
            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }

    }

    @Override
    public int add(XeMay xm) {
        sql = "INSERT INTO xemay(Ma,Ten,GiaNhap,GiaBan,SoLuong,TrangThai) VALUES (?,?,?,?,?,?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, xm.getMa());
            ps.setObject(2, xm.getTen());
            ps.setObject(3, xm.getGiaNhap());
            ps.setObject(4, xm.getGiaBan());
            ps.setObject(5, xm.getSoLuong());
            ps.setObject(6, xm.getTrangThai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(String ma) {
        sql = "DELETE FROM XeMay WHERE MA=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int update(XeMay xm, String ma) {
        sql = "UPDATE Xemay Set Ten=?,GiaNhap=?,GiaBan=?,SoLuong=?,TrangThai=? WHERE Ma=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, xm.getTen());
            ps.setObject(2, xm.getGiaNhap());
            ps.setObject(3, xm.getGiaBan());
            ps.setObject(4, xm.getSoLuong());
            ps.setObject(5, xm.getTrangThai());
            ps.setObject(6, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public XeMay getXeMay(String ma) {
        XeMay xm = null;
        sql = "SELECT Ma,Ten,GiaNhap,GiaBan,SoLuong,TrangThai FROM XeMay WHERE MA=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                xm = new XeMay(rs.getString(1), rs.getString(2), rs.getDouble(3),
                        rs.getDouble(4), rs.getInt(5), rs.getInt(6));
            }
            return xm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
