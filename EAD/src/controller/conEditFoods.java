/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.dbIO;

/**
 *
 * @author buddi
 */
public class conEditFoods {
    public void setPopulateFoodTable(JTable whichTable, String whichtime){
        new dbIO().populateFoodTable(whichTable, whichtime);
    }
    public void setPopulateFoodTable(JTable whichTable, JComboBox whichtime, JTextField whatfood){
        new dbIO().populateFoodTable(whichTable, whichtime, whatfood);
    }
    public void setFoodIN(JTextField name, JTextField price, JComboBox whichtime, JTable table){
        new dbIO().foodIN(name, price, whichtime, table);
    }
    public void setFoodDELETE(JTable whichTable, JComboBox whichtime){
        new dbIO().foodDELETE(whichTable, whichtime);
    }
    public void setFoodUPDATE(JTable table, JComboBox whichtime){
        new dbIO().foodUPDATE(table, whichtime);
    }
}
