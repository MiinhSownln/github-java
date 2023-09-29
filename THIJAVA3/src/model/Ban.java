/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author 24dom
 */
public class Ban {
    private String id,ma,ten;
    private Date ngaySinh;
    private String soThich;
    private int gioiTinh;
    private MoiQuanHe  idmqh;
    

    public Ban() {
    }

    public Ban(String id, String ma, String ten, Date ngaySinh, String soThich, int gioiTinh, MoiQuanHe idmqh) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.soThich = soThich;
        this.gioiTinh = gioiTinh;
        this.idmqh = idmqh;
        
    }

    public Ban(String ma, String ten, Date ngaySinh, String soThich, int gioiTinh, MoiQuanHe idmqh) {
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.soThich = soThich;
        this.gioiTinh = gioiTinh;
        this.idmqh = idmqh;
        
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

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoThich() {
        return soThich;
    }

    public void setSoThich(String soThich) {
        this.soThich = soThich;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public MoiQuanHe getIdmqh() {
        return idmqh;
    }

    public void setIdmqh(MoiQuanHe idmqh) {
        this.idmqh = idmqh;
    }

  

    public Ban(String ma, String ten, Date ngaySinh, String soThich) {
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.soThich = soThich;
    }

   
    public Object[] toDataRow(){
        return new Object[]{
            this.id,this.ma,this.ten,this.ngaySinh,this.soThich
        };
    }
    
}
