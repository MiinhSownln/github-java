/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.structures;

/**
 *
 * @author 24dom
 */
public class LinearSearch_Example {
    // Tìm kiếm tuyến tính
      public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Trả về chỉ số của phần tử nếu tìm thấy
            }
        }
        return -1; // Trả về -1 nếu không tìm thấy
    }

    public static void main(String[] args) {
        int[] arr = {10, 5, 7, 3, 2, 6};
        int target = 7;
        int result = linearSearch(arr, target);
        if (result == -1) {
            System.out.println("Không tìm thấy phần tử " + target + " trong mảng.");
        } else {
            System.out.println("Phần tử " + target + " được tìm thấy tại chỉ số " + result + " trong mảng.");
        }
    }
}
