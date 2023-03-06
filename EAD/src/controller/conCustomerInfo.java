/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.dbIO;

/**
 *
 * @author buddi
 */
public class conCustomerInfo {
    public void setReloadCustomerTable(JTable whichTable){
        new dbIO().reloadCustomerTable(whichTable);
    }
    public void setPopulateCustomerTable(JTable whatTable, String whatField, JTextField IField){
        new dbIO().populateCustomerTable(whatTable, whatField, IField);
    }
    public void setCustomerDELETE(JTable whichTable){
        new dbIO().customerDELETE(whichTable);
    }
    public void setCustomerIN(JTextField NIC, String roomNo, JTextField name, String address, JTextField phoneNo, JComboBox roomType, JComboBox guestNo, JDateChooser checkIn, JDateChooser checkOut, JTable table){
        new dbIO().customerIN(NIC, roomNo, name, address, phoneNo, roomType, guestNo, checkIn, checkOut, table);
    }
    public void setCustomerUPDATE(JTable whichTable){
        new dbIO().customerUPDATE(whichTable);
    }
    
}
