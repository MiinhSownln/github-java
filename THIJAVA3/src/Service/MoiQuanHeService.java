/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.MoiQuanHe;

/**
 *
 * @author 24dom
 */
public class MoiQuanHeService {

    String sql = "";
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<MoiQuanHe> getAll() {
        sql = "SELECT *FROM MoiQuanHe";
        List<MoiQuanHe> list = new ArrayList<>();
        try {
            con = DBconnect.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                MoiQuanHe mqh = new MoiQuanHe(rs.getString(1), rs.getString(2), rs.getString(3));
                list.add(mqh);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
