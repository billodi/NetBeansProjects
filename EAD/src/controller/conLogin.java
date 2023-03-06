/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JFrame;
import model.dbIO;

/**
 *
 * @author buddi
 */
public class conLogin {
    public void setStaffLogin(String username, String password, JFrame loginframe){
        new dbIO().staffLogin(username, password, loginframe);
    }
}
