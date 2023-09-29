/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package data.structures;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author 24dom
 */
public class CTDL_Set {

    
    public static void main(String[] args) {
        Set<String> set=new HashSet<>();
        set.add("hello");
        set.add("Minh");
        set.add("Son");
        set.add("Son");
        set.forEach(p->System.out.print(p));
        
    }
    
}
