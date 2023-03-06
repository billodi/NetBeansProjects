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
public class conAdminAccess {
    public void setAdminAccss(String admin,String password){
        new dbIO().adminAccess(admin, password);
    }
}
