/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.ChuyenDe;
import com.edusys.util.JdbcHelper;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import javax.swing.text.html.parser.Entity;

/**
 *
 * @author 24dom
 */
public class ChuyenDeDAO extends EduSysDAO<ChuyenDe, String> {

    final String INSERT_SQL = "insert into ChuyenDe(MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa)  values(?,?,?,?,?,?)";
    final String UPDATE_SQL = "UPDATE ChuyenDe SET TenCD=?,HocPhi=?,ThoiLuong=?,Hinh=?,MoTa=? WHERE MaCD=?";
    final String DELETE_SQL = "DELETE FROM ChuyenDe WHERE MaCD=?";
    final String SELECT_ALL_SQL = "SELECT* FROM CHUYENDE";
    final String SELECT_BY_ID_SQL = "select MaCD,TenCD,HocPhi,ThoiLuong,Hinh,MoTa from ChuyenDe where MaCD=?";

    @Override
    public void insert(ChuyenDe entity) {
        JdbcHelper.update(INSERT_SQL, entity.getMaCD(), entity.getTenCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getHinh(), entity.getMoTa());
    }

    @Override
    public void update(ChuyenDe entity) {
        JdbcHelper.update(UPDATE_SQL, entity.getTenCD(), entity.getHocPhi(), entity.getThoiLuong(), entity.getHinh(), entity.getMoTa(), entity.getMaCD());
    }

    @Override
    public void delete(String id) {
        JdbcHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<ChuyenDe> selectAll() {
        return selecBySql(SELECT_ALL_SQL);
    }

    @Override
    public ChuyenDe selectById(String id) {
        List<ChuyenDe> list = selecBySql(SELECT_BY_ID_SQL, id);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    public List<ChuyenDe> selecBySql(String sql, Object... args) {
        List<ChuyenDe> list = new ArrayList<>();

        try {
            ResultSet rs = JdbcHelper.query(sql, args);
            while (rs.next()) {
                ChuyenDe enity = new ChuyenDe();
                enity.setMaCD(rs.getString("MaCD"));
                enity.setTenCD(rs.getString("TenCD"));
                enity.setHocPhi(rs.getDouble("HocPhi"));
                enity.setThoiLuong(rs.getInt("ThoiLuong"));
                enity.setHinh(rs.getString("Hinh"));
                //enity.setMoTa(rs.getString("MoTa"));
                list.add(enity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
