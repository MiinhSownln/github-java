/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 24dom
 */
public class Student {
    private int id;
    private String name,pass;
    private double mark;

    public Student() {
    }

    public Student(int id, String name, String pass, double mark) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.mark = mark;
    }

    public Student(String name, String pass, double mark) {
        this.name = name;
        this.pass = pass;
        this.mark = mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }
    
    public Object[] toData(){
        return new Object[]{
            this.id,this.name,this.pass,this.mark
        };
    }
}
