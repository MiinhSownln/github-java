/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.LoaiSanPham;

/**
 *
 * @author 24dom
 */
public class LoaiSanPhamService {

    String sql = "";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<LoaiSanPham> getAll() {
        List<LoaiSanPham> list = new ArrayList<>();
        sql = "SELECT MALOAI,TENLOAI FROM LOAISANPHAM";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                //public SanPham(String maSanPham, String tenSanPham, LoaiSanPham maLoai)
                LoaiSanPham lsp = new LoaiSanPham(rs.getString(1), rs.getString(2));

                list.add(lsp);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
