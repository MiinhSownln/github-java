/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.HocVien;
import com.edusys.entity.NguoiHoc;
import com.edusys.util.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 24dom
 */
public class HocVienDao extends EduSysDAO<HocVien, Integer> {

    String INSERT_SQL = "INSERT INTO HocVien(MaKH, MaNH, Diem) VALUES(?, ?, ?)";
    String UPDATE_SQL = "UPDATE HocVien SET MaKH=?, MaNH=?, Diem=? WHERE MaHV=?";
    String DELETE_SQL = "DELETE FROM HocVien WHERE MaHV=?";
    String SELECT_ALL_SQL = "SELECT * FROM HocVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM HocVien WHERE MaHV=?";

    @Override
    public void insert(HocVien entity) {
        JdbcHelper.update(INSERT_SQL,
                entity.getMaKH(),
                entity.getMaNH(),
                entity.getDiem());
    }

    @Override
    public void update(HocVien entity) {
        JdbcHelper.update(UPDATE_SQL,
                entity.getMaKH(),
                entity.getMaNH(),
                entity.getDiem(),
                entity.getMaHV());
    }

    @Override
    public void delete(Integer id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<HocVien> selectAll() {
        return this.selecBySql(SELECT_ALL_SQL);
    }

    @Override
    public HocVien selectById(Integer id) {
        List<HocVien> list = this.selecBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<HocVien> selecBySql(String sql, Object... args) {
        List<HocVien> list = new ArrayList<>();
        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                HocVien entity = new HocVien();
                entity.setMaHV(rs.getInt("MaHV"));
                entity.setMaKH(rs.getInt("MaKH"));
                entity.setMaNH(rs.getString("MaNH"));
                entity.setDiem(rs.getDouble("Diem"));
                list.add(entity);
            }
            rs.getStatement().getConnection().close();
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
 

    public List<HocVien> selectByKhoaHoc(int makh) {
        String SQL = "SELECT * FROM HocVien WHERE MaKH = ?";
        return this.selecBySql(SQL, makh);
    }
}
