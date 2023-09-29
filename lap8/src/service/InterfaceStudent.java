/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.ArrayList;
import java.util.List;
import model.Student;

/**
 *
 * @author 24dom
 */
public interface InterfaceStudent {

    public int insert(Student st);

    public int update(Student st, int index);

    public int delete(int index);

    public ArrayList<Student> select();

    public int setList(ArrayList<Student> list);
}
