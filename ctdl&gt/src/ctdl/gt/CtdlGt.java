/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ctdl.gt;

import java.util.Stack;

public class CtdlGt {
    
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push("hi");
        st.push("hello");
        st.push("loo");
        st.peek();
        st.empty();
        
        System.out.println(st);
//        System.out.println(st.pop());
        // st.forEach(p->System.out.println(p));
        System.out.println(st.peek());
        System.out.println(st.size());
        System.out.println(st.search("loo"));
    }
}
