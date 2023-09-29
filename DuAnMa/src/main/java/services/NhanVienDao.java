/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;


import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import model.NhanVien;

/**
 *
 * @author 24dom
 */
public class NhanVienDao extends EduSysDao<NhanVien, String> {

    final String Insert = "INSERT INTO NHANVIEN(maNV,matKhau,hoTen,vaiTro) Values(?,?,?,?)";
    final String Update = "Update NhanVien SET matKhau=?,hoTen=?,vaiTro=? WHERE MaNV=?";
    final String Delete = "Delete form NhanVien Where maNV=?";
    final String Select_All = "SELECT* FROM NHANVIEN";
    final String ByID = "SELECT* FROM NHANVIEN WHERE MANV=?";

    @Override
    public void insert(NhanVien entity) {
        JDBCHelper.update(Insert, entity.getMaNV(), entity.getMatKhau(), entity.getHoTen(), entity.isVaiTro());
    }

    @Override
    public void update(NhanVien entity) {
        JDBCHelper.update(Update, entity.getMatKhau(), entity.getHoTen(), entity.isVaiTro(), entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        JDBCHelper.update(Delete, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selecBySql(Select_All);
    }

    @Override
    public NhanVien selectById(String id) {
       
        List<NhanVien> list=selecBySql(ByID, id);
        if(list.isEmpty()){
            return null;
        }
        return list.get(0);
       
        
   }

    @Override
    public List<NhanVien> selecBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();
        try {
            ResultSet rs = DBconnect.query(sql, args);
            while (rs.next()) {
                NhanVien enity = new NhanVien();
                enity.setMaNV(rs.getString(1));
                enity.setMatKhau(rs.getString(2));
                enity.setHoTen(rs.getString(3));
                enity.setVaiTro(rs.getBoolean(4));
                list.add(enity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
