/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author 24dom
 */
public interface InfStudent {
    public int add(Student st);
    public int update(Student st,int index);
    public int delete(int index);
    public List<Student> getAll();
}
