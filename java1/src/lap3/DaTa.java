/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap3;

/**
 *
 * @author 24dom
 */
public class DaTa {

    public Boolean isEmail(String Str) {
        String pattern = "\\w+@\\w+(\\.\\w+){1,2}";
        return Str.matches(Str);
    }

    public Boolean Phone(String str) {
        String pattern = "0\\d{9}";
        return str.matches(str);

    }
}
