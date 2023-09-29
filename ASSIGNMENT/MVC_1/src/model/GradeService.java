/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import service.DBconnect;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import static model.SinhVienService.ls;

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

    public List<Grade> getAll() {
        List<Grade> list = new ArrayList<>();
        sql = "	SELECT ID,STUDENTS.MASV,STUDENTS.HoTen,TiengAnh,TinHoc,GDTC FROM GRADE JOIN STUDENTS ON GRADE.MASV=STUDENTS.MASV ";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt(1);
                SinhVien sv = new SinhVien(rs.getString(2), rs.getString(3));
                double ta = rs.getDouble(4);
                double th = rs.getDouble(5);
                double gdtc = rs.getDouble(6);
                Grade g = new Grade(id, sv, ta, th, gdtc
                );
                list.add(g);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int add(Grade g) {
        sql = "INSERT INTO GRADE(MASV,TiengAnh,TinHoc,GDTC) VALUES (?,?,?,?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, g.getMaSV().getMaSV());
            ps.setObject(2, g.getTiengAnh());
            ps.setObject(3, g.getTinHoc());
            ps.setObject(4, g.getGdtc());
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public Grade getOneGrade(String ma) {
        sql = "	SELECT STUDENTS.HoTen,TiengAnh,"
                + "TinHoc,GDTC FROM GRADE JOIN STUDENTS ON GRADE.MASV=STUDENTS.MASV WHERE MASV=?";
        Grade g = null;
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            while (rs.next()) {

                SinhVien sv = new SinhVien(rs.getString(1), rs.getString(2));
                double ta = rs.getDouble(3);
                double th = rs.getDouble(4);
                double gdtc = rs.getDouble(5);
                g = new Grade(sv, ta, th, gdtc
                );
            }
            return g;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int delete(int id) {
        sql = "DELETE FROM GRADE WHERE ID=?";
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

    public int update(Grade g) {
        sql = "	UPDATE GRADE SET TiengAnh=?,TinHoc=?,GDTC=? WHERE MASV=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);

            ps.setObject(1, g.getTiengAnh());
            ps.setObject(2, g.getTinHoc());
            ps.setObject(3, g.getGdtc());
            ps.setObject(4, g.getMaSV().getMaSV());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Grade> top3() {
        sql = "	select TOP 3 ID,Students.HoTen,Grade.MaSV,Grade.TiengAnh,Grade.TinHoc,grade.GDTC from Grade inner join Students on Grade.MaSV = Students.MaSV\n"
                + "					group by  ID,Students.HoTen,Grade.MaSV,Grade.TiengAnh,"
                + "Grade.TinHoc,grade.GDTC order by AVG(TiengAnh+TinHoc+GDTC)/3 desc";
        List<Grade> list = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                int id=rs.getInt(1);
                SinhVien sv = new SinhVien(rs.getString(2), rs.getString(3));
                int ta = rs.getInt(4);
                int th = rs.getInt(5);
                int gdtc = rs.getInt(6);
                Grade g = new Grade( id,sv, ta, th, gdtc
                );
                list.add(g);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
