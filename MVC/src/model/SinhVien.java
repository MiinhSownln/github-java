/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 24dom
 */
public class SinhVien {

    private String maSDV, tenSV, email, soDienThoai, diaChi, images;
    private boolean gioiTinh;

    public SinhVien() {
    }

    public SinhVien(String maSDV, String tenSV) {
        this.maSDV = maSDV;
        this.tenSV = tenSV;
    }

    public SinhVien(String maSDV, String tenSV, String email, String soDienThoai, boolean gioiTinh, String diaChi, String images) {
        this.maSDV = maSDV;
        this.tenSV = tenSV;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.diaChi = diaChi;
        this.images = images;
        this.gioiTinh = gioiTinh;
    }

    public String getMaSDV() {
        return maSDV;
    }

    public void setMaSDV(String maSDV) {
        this.maSDV = maSDV;
    }

    public String getTenSV() {
        return tenSV;
    }

    public void setTenSV(String tenSV) {
        this.tenSV = tenSV;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.maSDV, this.tenSV, this.email, this.soDienThoai, this.gioiTinh, this.diaChi, this.images
        };
    }

}
