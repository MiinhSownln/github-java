/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 24dom
 */
public class SinhVien {

    private int id;
    private String name;

    public SinhVien(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public SinhVien() {
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

    public Object[] toDataRow() {
        return new Object[]{
            this.id,this.name
        
        };
    }

}
