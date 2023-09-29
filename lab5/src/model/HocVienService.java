/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import service.kn;

/**
 *
 * @author 24dom
 */
public class HocVienService {

    Connection conn = null;//biến đêr kết nối
    PreparedStatement ps = null;//thục thi câu lệnh
    String sql = null;
    ResultSet rs = null;//kéte quả select

    public List<HOCVIEN> getAll() {// lấy hết dữu liệu từ database
        sql = "SELECT * FROM SINH_VIEN";
        List<HOCVIEN> listSV = new ArrayList<>();
        try {// lấy dc dữ liệu
            conn = kn.getConnection();// kết nôi
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {// đọc từng dòng dữ liệu
                HOCVIEN sv = new HOCVIEN(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getFloat(7), rs.getBoolean(8));
                //  HOCVIEN sv=new HOCVIEN(rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getFloat(7),  rs.getBoolean(8));
                listSV.add(sv);
            }
            return listSV;
        } catch (Exception e) {// k lấy dc dữ liệu
            e.printStackTrace();
            return null;
        }
    }

    public int add(HOCVIEN hv) {

        String sql = "INSERT INTO sinh_vien(ma_sinh_vien,ten_sinh_vien,tuoi,ky_hoc,nganh_hoc,diem_trung_binh,gioi_tinh) VALUES\n" + "(?,?,?,?,?,?,?)";
        try {
            conn = kn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, hv.getMa());
            ps.setObject(2, hv.getTen());
            ps.setObject(3, hv.getTuoi());
            ps.setObject(4, hv.getKyhoc());
            ps.setObject(5, hv.getNganhHoc());
            ps.setObject(6, hv.getDiemTb());
            ps.setObject(7, hv.isGioitinh());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(int id) {
        sql = "DELETE FROM SINH_VIEN WHERE ID=?";
        try {
            conn = kn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();
            // insert,delete,update

        } catch (Exception e) {
            e.printStackTrace();

            return 0;
        }
    }

    public int update(HOCVIEN hv, int id) {
        sql = "UPDATE SINH_VIEN SET MA_SINH_VIEN=?,ten_sinh_vien=?,tuoi=?,ky_hoc=?,nganh_hoc=?,diem_trung_binh=?,gioi_tinh=? WHERE ID=?";
        try {
            conn = kn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, hv.getMa());
            ps.setObject(2, hv.getTen());
            ps.setObject(3, hv.getTuoi());
            ps.setObject(4, hv.getKyhoc());
            ps.setObject(5, hv.getNganhHoc());
            ps.setObject(6, hv.getDiemTb());
            ps.setObject(7, hv.isGioitinh());
            ps.setObject(8, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public HOCVIEN getHocVien(String ma) {
        sql = "SELECT * FROM SINH_VIEN  WHERE ma_sinh_vien=?";
        HOCVIEN hv = null;
        try {
            conn = kn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                hv = new HOCVIEN(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getFloat(7), rs.getBoolean(8));
            }
            return hv;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<HOCVIEN> sort() {
        sql = "SELECT *FROM SINH_VIEN ORDER BY DIEM_TRUNG_BINH DESC";
        List<HOCVIEN> listSV = new ArrayList<>();
        try {
            conn = kn.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HOCVIEN hv = new HOCVIEN(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getFloat(7), rs.getBoolean(8));
                listSV.add(hv);
            }
            return listSV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<HOCVIEN> find(String ma) {
        List<HOCVIEN> listSV = new ArrayList<>();
        sql = "select *from sinh_vien where ma_sinh_vien like ?";
        try {
            conn = kn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                HOCVIEN hv = new HOCVIEN(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6), rs.getFloat(7), rs.getBoolean(8));
                listSV.add(hv);
            }
            return listSV;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
