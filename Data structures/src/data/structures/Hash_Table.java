/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data.structures;

import java.util.Hashtable;

/**
 *
 * @author 24dom
 */
public class Hash_Table {
     public static void main(String[] args) {
        // Khởi tạo một Hash Table
        Hashtable<String, Integer> hashtable = new Hashtable<>();

        // Thêm các cặp key-value vào Hash Table
        hashtable.put("apple", 10);
        hashtable.put("banana", 20);
        hashtable.put("orange", 30);

        // Truy cập giá trị của một key
        int appleQuantity = hashtable.get("apple");
        System.out.println("Số lượng táo: " + appleQuantity);

        // Xóa một cặp key-value khỏi Hash Table
        hashtable.remove("banana");

        // Kiểm tra xem một key có tồn tại trong Hash Table hay không
        boolean containsOrange = hashtable.containsKey("orange");
        System.out.println("Có cam trong Hash Table: " + containsOrange);

        // Lấy kích thước của Hash Table
        int size = hashtable.size();
        System.out.println("Kích thước của Hash Table: " + size);

        // In tất cả các key trong Hash Table
        System.out.println("Các key trong Hash Table: " + hashtable.keySet());

        // In tất cả các value trong Hash Table
        System.out.println("Các value trong Hash Table: " + hashtable.values());
    }
}
