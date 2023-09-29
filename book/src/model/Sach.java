/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 24dom
 */
public class Sach {

    private int id;
    private String maSach, tenSach, theLoai;
    private double donGia;

    public Sach() {
    }

    public Sach(int id, String maSach, String tenSach, String theLoai, double donGia) {
        this.id = id;
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.donGia = donGia;
    }

    public Sach(String maSach, String tenSach, String theLoai, double donGia) {
        this.maSach = maSach;
        this.tenSach = tenSach;
        this.theLoai = theLoai;
        this.donGia = donGia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSach() {
        return maSach;
    }

    public void setMaSach(String maSach) {
        this.maSach = maSach;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.id, this.maSach, this.tenSach, this.theLoai, this.donGia
        };
    }
}
