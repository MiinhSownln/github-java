/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lap4;

/**
 *
 * @author 24dom
 */
public class sum {
    public static double tong(double...nums){
        double tong=0;
        for(double item:nums){
            tong+=item;
        }
        return tong;
    }
    public static double  min(double...nums){
        double min=nums[0];
        for(double item:nums){
            min=Math.min(min, item);
        }
        return min;
    }
    public static void main(String[] args) {
        double tong=tong(5,6);
        System.out.println(""+tong);
    }
    
}
