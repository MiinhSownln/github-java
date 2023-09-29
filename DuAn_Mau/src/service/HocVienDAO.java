/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import utils.DBconnect;
import java.sql.*;
import model.HocVien;
import utils.JDBCHelper;

/**
 *
 * @author 24dom
 */
public class HocVienDAO extends EduSysDAO<HocVien, Integer> {

    String INSERT_SQL = "INSERT INTO HocVien(MaKH, MaNH, Diem) VALUES(?, ?, ?)";
    String UPDATE_SQL = "UPDATE HocVien SET MaKH=?, MaNH=?, Diem=? WHERE MaHV=?";
    String DELETE_SQL = "DELETE FROM HocVien WHERE MaHV=?";
    String SELECT_ALL_SQL = "SELECT * FROM HocVien";
    String SELECT_BY_ID_SQL = "SELECT * FROM HocVien WHERE MaHV=?";

    @Override
    public void add(HocVien entity) {
        JDBCHelper.update(INSERT_SQL,
                entity.getMaKH(),
                entity.getMaNH(),
                entity.getDiem());
    }

    @Override
    public void update(HocVien entity, Integer id) {
        JDBCHelper.update(UPDATE_SQL,
                entity.getMaKH(),
                entity.getMaNH(),
                entity.getDiem(),
                entity.getMaHV());
    }

    @Override
    public void delete(Integer id) {
        JDBCHelper.update(DELETE_SQL, id);
    }

    @Override
    public List<HocVien> getAll() {
        return this.getBySql(SELECT_ALL_SQL);
    }

    @Override
    public HocVien getByID(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<HocVien> getBySql(String sql, Object... args) {
        List<HocVien> list = new ArrayList<>();
        try {
            ResultSet rs = JDBCHelper.query(sql, args);
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

    @Override
    public void updateMK(HocVien entity, Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public HocVien getByMa(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<HocVien> selectByKhoaHoc(int makh) {
        String SQL = "SELECT * FROM HocVien WHERE MaKH = ?";
        return this.getBySql(SQL, makh);
    }

}
