/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SinhViens;

/**
 *
 * @author 24dom
 */
public class SinhVienServices {

    Connection conn = null;//biến đêr kết nối
    PreparedStatement ps = null;//thục thi câu lệnh
    String sql = null;
    ResultSet rs = null;//kéte quả select

    public List<SinhViens> getAll() {// lấy hết dữu liệu từ database
        sql = "SELECT ID,NAME FROM SINHVIEN";
        List<SinhViens> listSV = new ArrayList<>();
        try {// lấy dc dữ liệu
            conn = connect.getConnection();// kết nôi
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {// đọc từng dòng dữ liệu
                SinhViens sv = new SinhViens(rs.getInt(1), rs.getString(2));
                listSV.add(sv);
            }
            return listSV;
        } catch (Exception e) {// k lấy dc dữ liệu
            e.printStackTrace();
            return null;
        }
    }

    public int addSinhVien(SinhViens sv) {
        sql = "INSERT INTO SINHVIEN(ID,NAME) VALUES\n"
                + "(?,?)";
        try {
            conn = connect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, sv.getId());
            ps.setObject(2, sv.getName());
            return ps.executeUpdate();
            // insert,delete,update
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteSinhVien(String id) {
        sql = "DELETE FROM SINHVIEN WHERE ID=?";
        try {
            conn = connect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, id);
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

}
