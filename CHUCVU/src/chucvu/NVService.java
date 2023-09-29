/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chucvu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 24dom
 */
public class NVService {

    String sql = "";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<thongtin> getAll() {
        sql = "SELECT MANV,HOTEN,NGAYSINH,GIOITINH,CHUCVU.MACV,CHUCVU.TENCHUCVU "
                + "FROM NHANVIEN JOIN CHUCVU ON NHANVIEN.MACV=CHUCVU.MACV";
        List<thongtin> list = new ArrayList<thongtin>();
        try {
            con = DBcn1.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String ma = rs.getString(1);
                String name = rs.getString(2);
                String born = rs.getString(3);
                String gender = rs.getString(4);
                CHUCVU cv = new CHUCVU(rs.getString(5), rs.getString(6));
                thongtin nv = new thongtin(ma, name, born, gender, cv);
                list.add(nv);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int add(thongtin tt) {
        sql = "INSERT INTO NHANVIEN(MANV,HOTEN,NGAYSINH,GIOITINH,MACV) VALUES (?,?,?,?,?)";
        try {
            con = DBcn1.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, tt.getMaNV());
            ps.setObject(2, tt.getHoTen());
            ps.setObject(3, tt.getNgaySinh());
            ps.setObject(4, tt.getGioiTinh());
            ps.setObject(5, tt.getMaChucvu().getMaChucVu());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
