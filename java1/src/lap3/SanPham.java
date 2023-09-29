/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap3;

import java.util.Scanner;

/**
 *
 * @author 24dom
 */
public class SanPham {
    private String maSp,tenSp;
    private double gia;

    public SanPham() {
    }

    public SanPham(String maSp, String tenSp, double gia) {
        this.maSp = maSp;
        this.tenSp = tenSp;
        this.gia = gia;
    }

    public String getMaSp() {
        return maSp;
    }

    public void setMaSp(String maSp) {
        this.maSp = maSp;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
    public double thue(){
        return gia*0.1;
    }
    
    public void nhap(){
        Scanner sc=new Scanner(System.in);
        System.out.println("Nhap ma san pham: ");
        maSp=sc.nextLine();
        System.out.println("Nhap ten san pham: ");
        tenSp=sc.nextLine();
        System.out.println("Nhap gia san pham: ");
        gia=Double.parseDouble(sc.nextLine());       
    }
    public void xuat(){
        System.out.println("Ma san pham la: "+maSp);
        System.out.println("Ten san pham la: "+tenSp);
        System.out.println("Gia cua san pham la: "+gia);
        System.out.println("Thue: "+thue());
    }
}
