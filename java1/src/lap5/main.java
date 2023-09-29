/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap5;

/**
 *
 * @author 24dom
 */
public class main {

    public static void main(String[] args) {
        HinhChuNhat hcn = new HinhChuNhat(6, 8);
        double p = hcn.chuVi();
        double dt = hcn.dienTich();
        System.out.println(p + " " + dt);
        HinhChuNhat hv = new HinhVuong(7);
        System.out.println(hv.chuVi() + " " + hv.dienTich());
    }
}
