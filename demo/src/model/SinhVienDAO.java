/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 24dom
 */
public class SinhVienDAO {

    List<SinhVien> dssv = new ArrayList<>();

    public int add(SinhVien sv) {
        dssv.add(sv);
        return 1;
    }

    public List<SinhVien> getAllSinhVien() {
        return dssv;
    }

    public int delSinhVienByID(String ma) {
        for (SinhVien sv : dssv) {
            if (sv.getMaSDV().equalsIgnoreCase(ma)) {
                dssv.remove(sv);
                return 1;
            }
        }
        return -1;
    }
    public SinhVien getSinhVienByID(String id){
        for(SinhVien sv:dssv){
            if(sv.getMaSDV().equalsIgnoreCase(id)){
                return sv;
            }
        }
        return null;
    }
}
