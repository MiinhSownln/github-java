/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Inf;

import java.util.List;
import model.XeMay;

/**
 *
 * @author 24dom
 */
public interface NewInterface {
    public List<XeMay> getAll();
    public int add(XeMay xm);
    public int delete(String ma);
    public int update(XeMay xm,String ma);
    public XeMay getXeMay(String ma);
}
