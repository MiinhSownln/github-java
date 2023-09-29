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

    private String maSV, hoTen, email, soDT;
    private boolean gioiTinh;
    private String diaChi, hinh;

    public SinhVien() {
    }

    public SinhVien(String hoTen) {
        this.hoTen = hoTen;
    }

    public SinhVien(String maSV, String hoTen) {
        this.maSV = maSV;
        this.hoTen = hoTen;
    }

    public SinhVien(String maSV, String hoTen, String email, String soDT, boolean gioiTinh, String diaChi, String hinh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.email = email;
        this.soDT = soDT;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.hinh = hinh;
    }

    public String getMaSV() {
        return maSV;
    }

    public void setMaSV(String maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public Object[] toDaTaRow() {
        return new Object[]{
            this.maSV, this.hoTen, this.email, this.soDT, this.gioiTinh, this.soDT, this.hinh
        };
    }

}
