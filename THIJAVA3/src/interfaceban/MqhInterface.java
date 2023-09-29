/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaceban;

import java.util.List;
import java.util.ArrayList;
import model.Ban;
import model.Ban;
import model.MoiQuanHe;

/**
 *
 * @author 24dom
 */
public interface MqhInterface {

    public int add(Ban ban);

    public int delete(String id);

    public int update(Ban ban, String id);

    public List<Ban> getAll();
    public List<Ban> getByMa(String ma);
}
