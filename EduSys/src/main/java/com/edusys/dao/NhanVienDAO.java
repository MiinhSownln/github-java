/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.NhanVien;
import com.edusys.util.DBconnect;
import com.edusys.util.JdbcHelper;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 24dom
 */
public class NhanVienDAO extends EduSysDAO<NhanVien, String> {

    final String INSERT_SQL = "insert into NhanVien(MaNV,MatKhau,HoTen,VaiTro) values(?,?,?,?)";
    final String UPDATE_SQL = "UPDATE NHANVIEN SET MatKhau=?,HoTen=?,VaiTro=? WHERE MaNV=?";
    final String DELETE_SQL = "DELETE FROM NhanVien WHERE MaNV=?";
    final String SELECT_ALL_SQL = "SELECT* FROM NHANVIEN";
    final String SELECT_BY_ID_SQL = "select MaNV,MatKhau,HoTen,VaiTro from NhanVien where MaNV=?";

    @Override
    public void insert(NhanVien entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaNV(), entity.getMatKhau(), entity.getHoTen(), entity.isVaiTro());
    }

    @Override
    public void update(NhanVien entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getMatKhau(), entity.getHoTen(), entity.isVaiTro(), entity.getMaNV());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<NhanVien> selectAll() {
        return selecBySql(SELECT_ALL_SQL);
    }

    @Override
    public NhanVien selectById(String id) {

        List<NhanVien> list = selecBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);

    }

    @Override
    public List<NhanVien> selecBySql(String sql, Object... args) {
        List<NhanVien> list = new ArrayList<>();

        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                NhanVien enity = new NhanVien();
                enity.setMaNV(rs.getString("MaNV"));
                enity.setMatKhau(rs.getString("MatKhau"));
                enity.setHoTen(rs.getString("HoTen"));
                enity.setVaiTro(rs.getBoolean("VaiTro"));
                list.add(enity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
