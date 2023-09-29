/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap2;

import java.util.Scanner;

/**
 *
 * @author 24dom
 */
public class ptb1 {

    public static void giaipt1(float a, float b) {
        if (a == 0) {
            if (b == 0) {
                System.out.println("pt vo so n");
            } else {
                System.out.println("pt vo n");
            }
        } else {
            float x = -b / a;
            System.out.println("pt co nghiem la: " + x);
        }
    }

    public static void pt1() {
        float a, b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap a: ");
        a = sc.nextFloat();
        System.out.println("Nhap b: ");
        b = sc.nextFloat();
        giaipt1(a, b);

    }

    public static void main(String[] args) {
        pt1();
    }
}
