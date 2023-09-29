/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package oop;

import java.io.Serializable;
import java.util.Random;
import javax.swing.ButtonModel;

/**
 *
 * @author minhs
 */
public class DienThoai implements Serializable{

    private String ma;
    private String hang;
    private String mauSac;
    private String boNho;
    private int gia;

    public DienThoai() {
    }

    public DienThoai(String ma, String hang, String mauSac, String boNho, int gia) {
        this.ma = ma;
        this.hang = hang;
        this.mauSac = mauSac;
        this.boNho = boNho;
        this.gia = gia;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getHang() {
        return hang;
    }

    public void setHang(String hang) {
        this.hang = hang;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getBoNho() {
        return boNho;
    }

    public void setBoNho(String boNho) {
        this.boNho = boNho;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }
   public Object[] toDaTa(){
       return new Object[]{
       this.genMa(),this.ma,this.hang,this.mauSac,this.boNho,this.gia,this.getStatus()
   };
   }
  
    
    public  String genMa() {
        Random random = new Random();
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        StringBuilder sb = new StringBuilder(7);
        for (int i = 0; i < 3; i++) {
            sb.append(str.charAt(random.nextInt(str.length())));
        }
        for (int i = 0; i < 2; i++) {
            sb.append(Character.toLowerCase(str.charAt(random.nextInt(str.length()))));
        }
        sb.append(str.charAt(random.nextInt(str.length())));
        sb.append(random.nextInt(10));
        return sb.toString();
    }
   
    public String getStatus(){
        if(gia>1000){
            return "Tốt";
        }
        return "bt";
    }
   
   

}
