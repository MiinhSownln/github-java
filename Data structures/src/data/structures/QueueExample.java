/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.structures;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author 24dom
 */
public class QueueExample {
    public static void main(String[] args) {
               Queue<String> queue = new LinkedList<>();

        // Thêm các phần tử vào Queue
        queue.add("Apple");
        queue.add("Banana");
        queue.add("Orange");

        // Lấy phần tử đầu tiên trong Queue
        String firstElement = queue.peek();
        System.out.println("First element: " + firstElement);

        // Xóa phần tử đầu tiên khỏi Queue
        String removedElement = queue.poll();
        System.out.println("Removed element: " + removedElement);

        // Lặp qua tất cả các phần tử trong Queue
        for (String element : queue) {
            System.out.println("Element: " + element);
        }
    }
}
