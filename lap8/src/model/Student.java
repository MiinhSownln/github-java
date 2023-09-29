/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import service.InterfaceStudent;

/**
 *
 * @author 24dom
 */
public class Student implements InterfaceStudent {

    private String id;
    private boolean gender;
    private String address, phone, email;
    List<Student> list = new ArrayList<>();

    public Student() {
    }

    public Student(String id, boolean gender, String address, String phone, String email) {
        this.id = id;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object[] toDataRow() {
        return new Object[]{
            this.id, this.gender, this.address, this.phone, this.email
        };
    }

    @Override
    public int insert(Student st) {
        list.add(st);
        return 0;
    }

    @Override
    public int update(Student st, int index) {
        list.set(index, st);
        return 0;
    }

    @Override
    public int delete(int index) {
        list.remove(id);
        return 0;
    }

    @Override
    public ArrayList<Student> select() {
        return (ArrayList<Student>) this.list;
    }

    @Override
    public int setList(ArrayList<Student> list) {
        this.list = list;
        return 0;
    }

}
