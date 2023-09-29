/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author macbookpro
 */
public class DuAn implements Serializable{
    
    private String chuyenNganh;
    private String maDeTai;
    private String tenDeThi;
    private String ngayThucHien;

    public DuAn() {
    }

    public DuAn(String chuyenNganh, String maDeTai, String tenDeThi, String ngayThucHien) {
        this.chuyenNganh = chuyenNganh;
        this.maDeTai = maDeTai;
        this.tenDeThi = tenDeThi;
        this.ngayThucHien = ngayThucHien;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh) {
        this.chuyenNganh = chuyenNganh;
    }

    public String getMaDeTai() {
        return maDeTai;
    }

    public void setMaDeTai(String maDeTai) {
        this.maDeTai = maDeTai;
    }

    public String getTenDeThi() {
        return tenDeThi;
    }

    public void setTenDeThi(String tenDeThi) {
        this.tenDeThi = tenDeThi;
    }

    public String getNgayThucHien() {
        return ngayThucHien;
    }

    public void setNgayThucHien(String ngayThucHien) {
        this.ngayThucHien = ngayThucHien;
    }
    
    
    
}
