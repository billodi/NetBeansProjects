/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JTable;
import model.dbIO;

/**
 *
 * @author buddi
 */
public class conPayment {
    public void setLoadPaymentTable(JTable whichTable, String who){
        new dbIO().loadPaymentTable(whichTable, who);
    }
    public void setLoadPaymentBill(JTable whichTable){
        new dbIO().loadPaymentBill(whichTable);
    }
}
