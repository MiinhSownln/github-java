/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 24dom
 */
public class Grade {

    private int id;
    private SinhVien maSV;
    private double tiengAnh, tinHoc, gdtc;

   

    public Grade(SinhVien maSV) {
        this.maSV = maSV;
    }

    public Grade() {
    }

    public Grade(int id, SinhVien maSV, double tiengAnh, double tinHoc, double gdtc) {
        this.id = id;
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.gdtc = gdtc;
    }

    public Grade(SinhVien maSV, double tiengAnh, double tinHoc, double gdtc) {
        this.maSV = maSV;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.gdtc = gdtc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SinhVien getMaSV() {
        return maSV;
    }

    public void setMaSV(SinhVien maSV) {
        this.maSV = maSV;
    }

    public double getTiengAnh() {
        return tiengAnh;
    }

    public void setTiengAnh(double tiengAnh) {
        this.tiengAnh = tiengAnh;
    }

    public double getTinHoc() {
        return tinHoc;
    }

    public void setTinHoc(double tinHoc) {
        this.tinHoc = tinHoc;
    }

    public double getGdtc() {
        return gdtc;
    }

    public void setGdtc(double gdtc) {
        this.gdtc = gdtc;
    }

    public double getdiemTb() {
        return (getGdtc() + getTiengAnh() + getTinHoc()) / 3;
    }

    public Object[] toData() {
        return new Object[]{
            this.id, this.getMaSV().getMaSV(), this.getMaSV().getHoTen(), this.tiengAnh, this.tinHoc, this.gdtc, this.getdiemTb()
        };
    }
}
