/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap6;

/**
 *
 * @author 24dom
 */
public class Dog extends Animals {

    @Override
    void move() {
        System.out.println("dim bnag 4 chan");
    }

    @Override
    void speed() {
        System.out.println("100km/h");
    }

    public static void main(String[] args) {
        Animals dog = new Dog();
        dog.move();
        dog.speed();

    }
}
