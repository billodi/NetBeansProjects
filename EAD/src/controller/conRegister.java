/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.dbIO;

/**
 *
 * @author buddi
 */
public class conRegister {
    public void setStaffIN(String Name, String Address, String gender, String Email, String Date, String Pnumber, String UN, String pwd){
        new dbIO().staffIN(Name, Address, gender, Email, Date, Pnumber, UN, pwd);
    }
}
