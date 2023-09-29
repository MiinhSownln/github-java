/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.structures;

/**
 *
 * @author 24dom
 */
public class Interpolation_Search {
    //tìm kiếm nội suy
      public static int interpolationSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right && target >= arr[left] && target <= arr[right]) {
            int pos = left + ((target - arr[left]) * (right - left)) / (arr[right] - arr[left]);
            
            if (arr[pos] == target) {
                return pos; // Trả về chỉ số của phần tử nếu tìm thấy
            }
            
            if (arr[pos] < target) {
                left = pos + 1; // Tiếp tục tìm kiếm phần tử bên phải của pos
            } else {
                right = pos - 1; // Tiếp tục tìm kiếm phần tử bên trái của pos
            }
        }
        
        return -1; // Trả về -1 nếu không tìm thấy
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 5, 6, 7, 10};
        int target = 7;
        int result = interpolationSearch(arr, target);
        if (result == -1) {
            System.out.println("Không tìm thấy phần tử " + target + " trong mảng.");
        } else {
            System.out.println("Phần tử " + target + " được tìm thấy tại chỉ số " + result + " trong mảng.");
        }
    }
}
