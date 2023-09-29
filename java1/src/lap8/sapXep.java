/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap8;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author 24dom
 */
public class sapXep {

    static void bubbleSort(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i]=a[j];
                    a[j]=temp;
                    
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }

    static void demo() {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhap n: ");
        n = Integer.parseInt(sc.nextLine());
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap phan tu");
            a[i] = sc.nextInt();

        }
        bubbleSort(a, n);

    }

    public static void main(String[] args) {
        demo();
    }
}
