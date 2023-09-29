/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 24dom
 */
public class SanPham {

    private String maSanPham, tenSanPham;
    private LoaiSanPham maLoai;

    public SanPham() {
    }
    
    public SanPham(String maSanPham, String tenSanPham, LoaiSanPham maLoai) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.maLoai = maLoai;
    }

    public SanPham(String maSanPham, String tenSanPham) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public LoaiSanPham getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(LoaiSanPham maLoai) {
        this.maLoai = maLoai;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.maSanPham, this.tenSanPham
        };
    }

}
