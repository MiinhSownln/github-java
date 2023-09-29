/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap8;

import java.util.Scanner;

/**
 *
 * @author 24dom
 */
public class timMax {
    static void fillmax(int arr[],int n){
        int max=arr[0];
        for(int i=1;i<n-1;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        System.out.println(max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhap n: ");
        n = Integer.parseInt(sc.nextLine());
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap phan tu");
            a[i] = sc.nextInt();

        }
        fillmax(a, n);
    }
}
