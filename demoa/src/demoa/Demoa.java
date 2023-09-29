/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demoa;

import java.util.Scanner;

/**
 *
 * @author 24dom
 */
public class Demoa {

    static void soHoanHao(int n) {
        int tong = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                tong += i;
            }
        }
        if (tong == n) {
            System.out.println("So hoan hao");
        } else {
            System.out.println("o phai so hoan hao");
        }
    }

    static void so() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap n: ");
        int n = sc.nextInt();
        soHoanHao(n);
    }

     static public void main(String[] args) {
        so();
    }
}
