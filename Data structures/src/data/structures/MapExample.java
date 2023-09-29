/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.structures;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 24dom
 */
public class MapExample {

    public static void main(String[] args) {
        // Tạo một đối tượng Map
        Map<String, Integer> studentScores = new HashMap<>();

        // Thêm các cặp key-value vào Map
        studentScores.put("John", 90);
        studentScores.put("Jane", 85);
        studentScores.put("Mike", 95);

        // Truy cập giá trị của một key
        int johnScore = studentScores.get("John");
        System.out.println("John's score: " + johnScore);

        // Kiểm tra xem một key có tồn tại trong Map hay không
        boolean isJanePresent = studentScores.containsKey("Jane");
        System.out.println("Is Jane present? " + isJanePresent);

        // Xóa một cặp key-value từ Map
        studentScores.remove("Mike");

        // Lặp qua tất cả các cặp key-value trong Map
//        for (Map.Entry<String, Integer> entry : studentScores.entrySet()) {
//            String name = entry.getKey();
//            int score = entry.getValue();
//            System.out.println(name + "'s score: " + score);
//        }
        studentScores.forEach((n, u) -> {
            System.out.println(n + " " + u);
        });
    }
}
