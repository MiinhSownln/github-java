/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package b2;

import java.util.ArrayList;
import java.util.List;
import oop.DienThoai;

/**
 *
 * @author 24dom
 */
public class DienThoaiService implements PhoneInterface {

    List<DienThoai> list = new ArrayList<>();

    @Override
    public int add(DienThoai dt) {
        list.add(dt);
        return 0;
    }

    public String delete(String index) {
        list.remove(index);
        return null;
    }

    @Override
    public int update(DienThoai dt, int index) {
        list.set(index, dt);
        return 0;
    }

    @Override
    public String delete(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
