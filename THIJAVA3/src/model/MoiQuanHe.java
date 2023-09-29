/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 24dom
 */
public class MoiQuanHe {

    String id, ma, ten;

    public MoiQuanHe() {
    }

    public MoiQuanHe(String id) {
        this.id = id;
    }
    
    public MoiQuanHe(String id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }
 public MoiQuanHe(String id, String ma) {
        this.id = id;
        this.ma = ma;
        
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
    
}
