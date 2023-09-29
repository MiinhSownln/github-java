/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.structures;

/**
 *
 * @author 24dom
 */
public class BinarySearch_Ex {
    //tìm kiếm nhị phân
     public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid; // Trả về chỉ số của phần tử nếu tìm thấy
            }
            
            if (arr[mid] < target) {
                left = mid + 1; // Tiếp tục tìm kiếm phần tử bên phải của mid
            } else {
                right = mid - 1; // Tiếp tục tìm kiếm phần tử bên trái của mid
            }
        }           
        
        return -1; // Trả về -1 nếu không tìm thấy
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 7, 10,11};
        int target = 10;
        int result = binarySearch(arr, target);
        if (result == -1) {
            System.out.println("Không tìm thấy phần tử " + target + " trong mảng.");
        } else {
            System.out.println("Phần tử " + target + " được tìm thấy tại chỉ số " + result + " trong mảng.");
        }
    }
}
