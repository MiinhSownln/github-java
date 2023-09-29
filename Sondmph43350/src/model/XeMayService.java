/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import service.ketnoi;

/**
 *
 * @author 24dom
 */
public class XeMayService {

    Connection con = null;
    String sql = "";
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<XeMay> getAll() {
        sql = "Select *from XeMay";
        List<XeMay> list = new ArrayList<>();
        try {
            con = ketnoi.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                XeMay xm = new XeMay(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getFloat(5));
                list.add(xm);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int delete(String ma) {
        sql = "delete from XeMay where maXe=?";
        try {
            con = ketnoi.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int add(XeMay xm) {
        sql = "INSERT INTO XEMAY(maXe,loaiXe,soPhanKhoi,mauXe,giaBan) VALUES\n" + "(?,?,?,?,?)";
        try {
            con = ketnoi.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, xm.getMaXe());
            ps.setObject(2, xm.getLoaiXe());
            ps.setObject(3, xm.getSoPhanKhoi());
            ps.setObject(4, xm.getMauXe());
            ps.setObject(5, xm.getGiaBan());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(XeMay xm, String ma) {
        sql = "UPDATE XEMAY SET loaiXe=?,soPhanKhoi=?,mauXe=?,giaBan=? WHERE maXe=?";
        try {
            con = ketnoi.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, xm.getLoaiXe());
            ps.setObject(2, xm.getSoPhanKhoi());
            ps.setObject(3, xm.getMauXe());
            ps.setObject(4, xm.getGiaBan());
            ps.setObject(5, ma);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public XeMay getXeMay(String ma) {
        sql = "Select *from xemay where maxe=?";
        XeMay xm = null;
        try {
            con = ketnoi.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                xm = new XeMay(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getFloat(5));
            }
            return xm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
