/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.util.List;
import model.Ban;
import interfaceban.MqhInterface;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import model.MoiQuanHe;

/**
 *
 * @author 24dom
 */
public class BanService implements MqhInterface {

    SimpleDateFormat format_date = new SimpleDateFormat("yyyy-MM-dd");

    String sql = "";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public int add(Ban ban) {
        sql = "INSERT INTO BAN(MA,TEN,NGAYSINH,SOTHICH,GIOITINH,IdMQH) VALUES(?,?,?,?,?,?)";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ban.getMa());
            ps.setObject(2, ban.getTen());
            ps.setObject(3, format_date.format(ban.getNgaySinh()));
            ps.setObject(4, ban.getSoThich());
            ps.setObject(5, ban.getGioiTinh());

            ps.setObject(6, ban.getIdmqh().getId());
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public int delete(String id) {
        sql = "DELETE FROM BAN WHERE ID=?";
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

    @Override
    public int update(Ban ban, String id) {
        sql = "UPDATE BAN SET Ma=?,Ten=?,NgaySinh=?,SoThich=?,GioiTinh=?,IdMQH=? WHERE ID=?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ban.getMa());
            ps.setObject(2, ban.getTen());
            ps.setObject(3, ban.getNgaySinh());
            ps.setObject(4, ban.getSoThich());
            ps.setObject(5, ban.getGioiTinh());
            ps.setObject(6, ban.getIdmqh().getId());
            ps.setObject(7, id);
            return ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public List<Ban> getAll() {
        List<Ban> list = new ArrayList<>();
        sql = "SELECT Ban.Id,Ban.Ma,Ban.Ten,NgaySinh,SoThich,GioiTinh,IdMQH,MoiQuanHe.Ma,MoiQuanHe.Ten,MoiQuanHe.Ma FROM Ban \n"
                + "JOIN MoiQuanHe ON Ban.IdMQH=MoiQuanHe.Id";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                // String id, String ma, String ten, Date ngaySinh, String soThich, int gioiTinh, MoiQuanHe idmqh, int trangThai
                String id = rs.getString(1);
                String ma = rs.getString(2);
                String ten = rs.getString(3);
                String sothich = rs.getString(5);
                Date d = rs.getDate(4);
                int gt = rs.getInt(6);
                MoiQuanHe bang = new MoiQuanHe(rs.getString(7), rs.getString(8), rs.getString(9));

                //String id, String ma, String ten, Date ngaySinh, String soThich, int gioiTinh, MoiQuanHe idmqh, int trangThai
                Ban ban = new Ban(id, ma, ten, d, sothich, gt, bang);
                list.add(ban);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Ban> getByMa(String ma) {
        List<Ban> list = new ArrayList<>();
        sql = "SELECT Ban.Id,Ban.Ma,Ban.Ten,NGAYSINH,SoThich,GioiTinh,IdMQH,MoiQuanHe.Ma,MoiQuanHe.Ten FROM Ban join MoiQuanHe on ban.IdMQH=MoiQuanHe.id WHERE BAN.Ma LIKE ?";
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1, ma);
            rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String maF = rs.getString(2);
                String ten = rs.getString(3);
                String sothich = rs.getString(5);
                Date d = rs.getDate(4);
                int gt = rs.getInt(6);
                MoiQuanHe bang = new MoiQuanHe(rs.getString(7), rs.getString(8), rs.getString(9));

                //String id, String ma, String ten, Date ngaySinh, String soThich, int gioiTinh, MoiQuanHe idmqh, int trangThai
                Ban ban = new Ban(id,maF,ten,d,sothich,gt,bang);
                list.add(ban);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
