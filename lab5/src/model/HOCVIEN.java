/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 24dom
 */
public class HOCVIEN {

    private String id, ma, ten;
    private int tuoi, kyhoc;
    private double diemTb;
    private boolean gioitinh;
    private String nganhHoc;

    public HOCVIEN() {
    }

    public HOCVIEN(String id, String ma, String ten, int tuoi, int kyhoc, String nganhHoc, double diemTb, boolean gioitinh) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tuoi = tuoi;
        this.kyhoc = kyhoc;
        this.diemTb = diemTb;
        this.gioitinh = gioitinh;
        this.nganhHoc = nganhHoc;
    }

    public HOCVIEN(String ma, String ten, int tuoi, int kyhoc, String nganhHoc, double diemTb, boolean gioitinh) {

        this.ma = ma;
        this.ten = ten;
        this.tuoi = tuoi;
        this.kyhoc = kyhoc;
        this.diemTb = diemTb;
        this.gioitinh = gioitinh;
        this.nganhHoc = nganhHoc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public int getKyhoc() {
        return kyhoc;
    }

    public void setKyhoc(int kyhoc) {
        this.kyhoc = kyhoc;
    }

    public double getDiemTb() {
        return diemTb;
    }

    public void setDiemTb(double diemTb) {
        this.diemTb = diemTb;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public String getNganhHoc() {
        return nganhHoc;
    }

    public void setNganhHoc(String nganhHoc) {
        this.nganhHoc = nganhHoc;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.id, this.ma, this.ten, this.tuoi, this.kyhoc, this.nganhHoc, this.diemTb, this.gioitinh
        };
    }

}
