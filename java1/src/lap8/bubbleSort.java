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
public class bubbleSort {

    static void bubble(int arr[], int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Nhap n: ");
        n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhap phan tu");
            a[i] = sc.nextInt();

        }
        bubble(a, n);
    }
}
