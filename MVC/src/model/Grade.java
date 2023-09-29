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

    private double tiengAnh;
    private double tinHoc;
    private double theChat;
    private SinhVien maSV;

    public Grade() {
    }

    public Grade(SinhVien maSV, double tiengAnh, double tinHoc, double theChat) {
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.theChat = theChat;
        this.maSV = maSV;
    }

    public Grade(int id, SinhVien maSV) {
        this.id = id;
        this.maSV = maSV;
    }

    public Grade(int id, SinhVien maSV, double tiengAnh, double tinHoc, double theChat) {
        this.id = id;
        this.tiengAnh = tiengAnh;
        this.tinHoc = tinHoc;
        this.theChat = theChat;
        this.maSV = maSV;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getTheChat() {
        return theChat;
    }

    public void setTheChat(double theChat) {
        this.theChat = theChat;
    }

    public SinhVien getMaSV() {
        return maSV;
    }

    public void setMaSV(SinhVien maSV) {
        this.maSV = maSV;
    }

    public double getdiemTb() {
        return (getTheChat() + getTiengAnh() + getTinHoc()) / 3;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.id, this.getMaSV().getMaSDV(), this.getMaSV().getTenSV(), this.tiengAnh, this.tinHoc, this.theChat, this.getdiemTb()
        };
    }
}
