/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edusys.dao;

import com.edusys.entity.NhanVien;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 24dom
 */
public class test {

    public static void main(String[] args) {
  //      NhanVienDAO dao = new NhanVienDAO();
//        List<NhanVien> ls=dao.selectAll();
//        for(NhanVien nv:ls){
//            System.out.println("=>"+nv.toString());
//       
//      }
//         dao.insert(new NhanVien("Nvb01", "son", "123", true));
//    
ThongKeDAO tkDao=new ThongKeDAO();
List<Object[]> list=tkDao.getBangDiem(1);
        for (Object[] objects : list) {
            System.out.println(""+objects[0]);
        }
}
}
