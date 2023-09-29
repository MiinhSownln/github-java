/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import service.DBconnect;

/**
 *
 * @author 24dom
 */
public class SinhVienDAO {

    String sql = "";
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    public static List<SinhVien> ls = new ArrayList<>();

    public SinhVienDAO() {
        ls.add(new SinhVien("SV01", "Son"));
        ls.add(new SinhVien("SV02", "Duy"));
    }

    public List<SinhVien> getAll() {
        sql = "SELECT *FROM STUDENT";
        List<SinhVien> list = new ArrayList<SinhVien>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getBoolean(5), rs.getString(6), rs.getString(7));
                list.add(sv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addSinhVien(SinhVien sv) {
        sql = "INSERT INTO STUDENT(MASV,HOTEN,EMAIL,SODT,GIOITINH,DIACHI,HINH) VALUES\n" + "(?,?,?,?,?,?,?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sv.getMaSDV());
            ps.setObject(2, sv.getTenSV());
            ps.setObject(3, sv.getEmail());
            ps.setObject(4, sv.getSoDienThoai());
            ps.setObject(5, sv.isGioiTinh());
            ps.setObject(6, sv.getDiaChi());
            ps.setObject(7, sv.getImages());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteSinhVien(String id) {
        sql = "DELETE FROM STUDENT WHERE MASV=?";
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

    public int updateSinhVien(SinhVien sv, String id) {
        sql = "UPDATE STUDENT SET HOTEN=?,EMAIL=?,SODT=?,GIOITINH=?,DIACHI=?,HINH=? WHERE MASV=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sv.getTenSV());
            ps.setObject(2, sv.getEmail());
            ps.setObject(3, sv.getSoDienThoai());
            ps.setObject(4, sv.isGioiTinh());
            ps.setObject(5, sv.getDiaChi());
            ps.setObject(6, sv.getImages());
            ps.setObject(7, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public SinhVien getSinhVien(String ma) {
        sql = "SELECT *FROM STUDENT WHERE MASV=?";
        SinhVien sv = null;
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                sv = new SinhVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getBoolean(5), rs.getString(6), rs.getString(7));
            }
            return sv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public SinhVien getSinhVienByID(String ma) {
        for (SinhVien sv : ls) {
            if (sv.getMaSDV().equals(ma)) {
                return sv;
            }
        }
        return null;
    }
}
