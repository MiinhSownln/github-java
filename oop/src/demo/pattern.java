/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demo;

import java.util.Scanner;

/**
 *
 * @author 24dom
 */
public class pattern {
    public static void main(String[] args) {
        String pattern="0\\d{9}";
        String phone;
        System.out.println("Nhap: ");
        Scanner sc=new Scanner(System.in);
        phone=sc.nextLine();
        if(phone.matches(pattern)){
            System.out.println("Success");
        }else{
            System.out.println("sss");
        }
    }
}
