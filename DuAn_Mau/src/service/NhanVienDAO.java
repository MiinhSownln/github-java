/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import utils.DBconnect;

/**
 *
 * @author 24dom
 */
public class NhanVienDAO {

    Connection con = null;
    String sql = "";
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<NhanVien> SELECT_ALL() {
        String sql = "SELECT * FROM NHANVIEN";
        List<NhanVien> list = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getBoolean(4));
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int INSERT(NhanVien nv) {
        sql = "insert into NhanVien(MaNV,MatKhau,HoTen,VaiTro) values(?,?,?,?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, nv.getMaNV());
            ps.setObject(2, nv.getMatKhau());
            ps.setObject(3, nv.getHoTen());
            ps.setObject(4, nv.isVaiTro());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int DELETE(String ID) {
        sql = "DELETE FROM NhanVien WHERE MaNV=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ID);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int UPDATE(NhanVien nv, String ID) {
        sql = "UPDATE NHANVIEN SET MatKhau=?,HoTen=?,VaiTro=? WHERE MaNV=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(4, nv.getMaNV());
            ps.setObject(1, nv.getMatKhau());
            ps.setObject(2, nv.getHoTen());
            ps.setObject(3, nv.isVaiTro());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public NhanVien SELECT_BY_ID(String ID) {
        NhanVien nv = null;
        sql = " SELECT *FROM NHANVIEN WHERE MANV=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ID);
            rs = ps.executeQuery();
            while (rs.next()) {
                nv = new NhanVien(rs.getString(1),
                        rs.getString(2), rs.getString(3), rs.getBoolean(4));
            }
            return nv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
