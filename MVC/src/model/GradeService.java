/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import service.DBconnect;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import static model.SinhVienDAO.ls;

/**
 *
 * @author 24dom
 */
public class GradeService {

    String sql = "";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<Grade> list = new ArrayList<Grade>();

    public int add(Grade gr) {
        list.add(gr);
        return 1;
    }

    public List<Grade> getAll() {
        return list;
    }

    public int addGrade(Grade g) {
        sql = "INSERT INTO GRADE(MASV,TIENGANH,TINHOC,GDTC) VALUES ( ?, ?, ?, ?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, g.getMaSV().getMaSDV());
            ps.setObject(2, g.getTiengAnh());
            ps.setObject(3, g.getTinHoc());
            ps.setObject(4, g.getTheChat());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int updateGrade(Grade g, int id) {
        sql = "Update Grade set masv=?,tienganh=?,TinHoc=?,thechat=? where id=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, g.getMaSV().getMaSDV());
            ps.setObject(2, g.getTiengAnh());
            ps.setObject(3, g.getTinHoc());
            ps.setObject(4, g.getTheChat());
            ps.setObject(5, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int deleteGrade(int id) {
        sql = "Delete from grade where id=?";
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

    public List<Grade> getAllGrade() {
        sql = "	SELECT GRADE.MASV,STUDENT.HoTen,TiengAnh,TinHoc,TheChat FROM GRADE JOIN STUDENT ON GRADE.MASV=STUDENT.MASV";
        List<Grade> list = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareCall(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Grade g = new Grade();
                g.setId(rs.getInt(1));
                g.setMaSV(new SinhVien(rs.getString(2), rs.getString(3)));
                g.setTiengAnh(rs.getInt(4));
                g.setTinHoc(rs.getInt(5));
                g.setTheChat(rs.getInt(6));
                list.add(g);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Grade getGrade(String ma) {
        for (Grade gr : list) {
            if (gr.getMaSV().equals(ma)) {
                return gr;
            }
        }
        return null;
    }

    public Grade getOne(String ma) {
        sql = "SELECT GRADE.MASV,STUDENT.HoTen,GRADE.TiengAnh,GRADE.TinHoc,GRADE.TheChat FROM GRADE INNER JOIN STUDENT ON GRADE.MASV=STUDENT.MASV";
        Grade g = null;
        try {
            con = DBconnect.getConnection();
            ps = con.prepareCall(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {

                g.setMaSV(new SinhVien(rs.getString(1), rs.getString(2)));
                g.setTiengAnh(rs.getInt(3));
                g.setTinHoc(rs.getInt(4));
                g.setTheChat(rs.getInt(5));

            }
            return g;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
