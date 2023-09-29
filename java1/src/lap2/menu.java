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
public class menu {

    static void menu() {
        Scanner sc = new Scanner(System.in);
        int choose;
        do {
            System.out.println("1.Bai1");
            System.out.println("2.Bai2");
            System.out.println("3.Bai3");
            System.out.println("4.Bai4");
            
            System.out.println("Moi ban chon: ");

            choose = sc.nextInt();

            switch (choose) {
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Nhap sai");
            }
        } while (choose != 0);
    }

    public static void main(String[] args) {
        menu();
    }
}
