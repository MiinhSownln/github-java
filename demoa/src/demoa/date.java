/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demoa;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author 24dom
 */
public class date {
    public static void main(String[] args) {
        String dateString = "31/12/2022";
        String dateFormat = "dd/MM/yyyy";
        
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false); // Tắt chế độ linh hoạt
        
        try {
            sdf.parse(dateString);
            System.out.println("Ngày tháng hợp lệ");
        } catch (ParseException e) {
            System.out.println("Ngày tháng không hợp lệ");
            e.printStackTrace();
        }
    }
}
