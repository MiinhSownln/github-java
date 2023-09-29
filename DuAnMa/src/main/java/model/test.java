/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import model.NhanVien;
import services.NhanVienDao;

/**
 *
 * @author 24dom
 */
public class test {

    public static void main(String[] args) {
        NhanVienDao dao = new NhanVienDao();
        List<NhanVien> ls = dao.selectAll();
        for (NhanVien nv : ls) {
            System.out.println(" " + nv.toString());
        }
    }
}
