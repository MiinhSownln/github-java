/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author 24dom
 */
public class SinhViens {

    private int id;
    private String name;

    public SinhViens() {
        //id=0 có khởi tạo
        //name=null;
    }

    public SinhViens(int id, String name) {
        this.id = id;// thuộc tính--- giá trị dc truyênf vào
        this.name = name;
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
    public Object[] toDataRow(){// lay duw lieu vao doing
        return new Object[]{
            this.id,this.name };
    }
}
