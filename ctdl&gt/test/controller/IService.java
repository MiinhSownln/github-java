/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.DuAn;

/**
 *
 * @author macbookpro
 */
public interface IService {
    public void insert(DuAn da);
    public void update(int position,DuAn da);
    public void delete(int position);
    public ArrayList<DuAn> select();
    public void setList(ArrayList<DuAn> list);
    public void writeFile(String path);
    public void readFile(String path);
    public void sortByName();
    
}
