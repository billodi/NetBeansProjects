/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JList;
import model.dbIO;

/**
 *
 * @author buddi
 */
public class conRooms {
    public void setRooms(JList rooms, String roomid){
        new dbIO().rooms(rooms, roomid);
    }
}
