/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.LoaiSanPham;
import model.SanPham;

/**
 *
 * @author 24dom
 */
public class SanPhamService {

    String sql = "";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<SanPham> getAll() {
        List<SanPham> list = new ArrayList<>();
        sql = "SELECT MASANPHAM,TENSANPHAM,LOAISANPHAM.MALOAI,TENLOAI FROM LOAISANPHAM "
                + "JOIN SANPHAM ON SANPHAM.MALOAI=LOAISANPHAM.MALOAI";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString(1);
                String tenSp = rs.getString(2);
                //public SanPham(String maSanPham, String tenSanPham, LoaiSanPham maLoai)
                LoaiSanPham lsp = new LoaiSanPham(rs.getString(3), rs.getString(4));
                SanPham sp = new SanPham(maSP, tenSp, lsp);
                list.add(sp);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public List<SanPham> getSanPhamByMaLoai(String maLoai) {
        sql = "SELECT MASANPHAM,TENSANPHAM,LOAISANPHAM.MALOAI,TENLOAI FROM LOAISANPHAM JOIN SANPHAM ON "
                + "SANPHAM.MALOAI=LOAISANPHAM.MALOAI WHERE LOAISANPHAM.MALOAI=?";
        List<SanPham> list = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, maLoai);
            rs = ps.executeQuery();
            while (rs.next()) {
                String maSP = rs.getString(1);
                String tenSp = rs.getString(2);
                //public SanPham(String maSanPham, String tenSanPham, LoaiSanPham maLoai)
                LoaiSanPham lsp = new LoaiSanPham(rs.getString(3), rs.getString(4));
                SanPham sp = new SanPham(maSP, tenSp, lsp);
                list.add(sp);

            }
            return list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int addSanPham(SanPham sp) {
        try {
            sql = "INSERT INTO SANPHAM(MASANPHAM,TENSANPHAM,MALOAI) VALUES (?,?,?) ";
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getMaSanPham());
            ps.setObject(2, sp.getTenSanPham());
            ps.setObject(3, sp.getMaLoai().getMaLoai());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteSanPham(String ma) {
        sql = "delete from sanpham where masanpham=?";
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

    public int updateSanPham(SanPham sp) {
        sql = "update sanpham set tensanpham=?,maloai=? where masanpham=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, sp.getTenSanPham());
            ps.setObject(2, sp.getMaLoai().getMaLoai());
            ps.setObject(3, sp.getMaSanPham());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

}
