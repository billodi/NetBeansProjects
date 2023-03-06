/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import model.dbIO;

/**
 *
 * @author buddi
 */
public class conControlPanal {
    public void setCustomerINCPL(JTextField NIC, String roomNo, JTextField name, String address, JTextField phoneNo, JComboBox roomType, JComboBox guestNo, JDateChooser checkIn, JDateChooser checkOut){
        new dbIO().customerINCPL(NIC, roomNo, name, address, phoneNo, roomType, guestNo, checkIn, checkOut);
    }
}
