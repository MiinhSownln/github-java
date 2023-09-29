/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 24dom
 */
public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread();
        
       
        MyRunnable thread2=new MyRunnable();
        Thread thr2=new Thread(thread2);
        thread1.start();
        thread1.join(3000);
        thr2.start();
    }
}
