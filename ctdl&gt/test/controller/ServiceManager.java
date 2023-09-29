/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.DuAn;

/**
 *
 * @author macbookpro
 */
public class ServiceManager implements IService {

    private ArrayList<DuAn> list = new ArrayList<>();

    @Override
    public void insert(DuAn da) {
        this.list.add(da);
    }

    @Override
    public void update(int position, DuAn da) {
        this.list.set(position, da);

    }

    @Override
    public void delete(int position) {
        this.list.remove(position);
    }

    @Override
    public ArrayList<DuAn> select() {
        return this.list;
    }

    @Override
    public void setList(ArrayList<DuAn> list) {
        this.list = list;
    }

    @Override
    public void writeFile(String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(list);

            fos.close();
            oos.close();
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    @Override
    public void readFile(String path) {
        try {
            FileInputStream fos = new FileInputStream(path);
            ObjectInputStream oos = new ObjectInputStream(fos);

            list = (ArrayList<DuAn>) oos.readObject();

            fos.close();
            oos.close();
            
        } catch (Exception e) {
            System.out.println("" + e.getMessage());
        }
    }

    @Override
    public void sortByName() {
        Comparator<DuAn> com = new Comparator<DuAn>() {
            @Override
            public int compare(DuAn o1, DuAn o2) {
                return o1.getTenDeThi().compareTo(o2.getTenDeThi());
            }
        };
        Collections.sort(list, com);
    }

}
