
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 24dom
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            System.out.println("Thread 2: " + i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        System.out.println("Success");
    }
    
            

}
