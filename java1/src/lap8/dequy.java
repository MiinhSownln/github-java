/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap8;

/**
 *
 * @author 24dom
 */
public class dequy {

    static int sum(int a) {
        if (a == 1) {
            return a;
        } else {
            return a * sum(a - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Tong la: " + sum(8));
    }
}
