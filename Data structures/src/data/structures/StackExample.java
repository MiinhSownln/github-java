/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.structures;

import java.util.Stack;

/**
 *
 * @author 24dom
 */
public class StackExample {
    public static void main(String[] args) {
        // Tạo một đối tượng Stack
        Stack<String> stack = new Stack<>();

        // Thêm các phần tử vào Stack
        stack.push("Apple");
        stack.push("Banana");
        stack.push("Orange");

        // Lấy phần tử trên cùng của Stack
        String topElement = stack.peek();
        System.out.println("Top element: " + topElement);

        // Xóa phần tử trên cùng của Stack
        String removedElement = stack.pop();
        System.out.println("Removed element: " + removedElement);

        // Lặp qua tất cả các phần tử trong Stack
        for (String element : stack) {
            System.out.println("Element: " + element);
        }
    }
}
