/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JLabel;


/**
 *
 * @author Buddika Alwis
 */
public class Charactor {

    String name;
    int[] loc = {20, 0};
    int health = 100;
    JLabel Clable = new JLabel();
    

    public void CharactorIni(String Cname) {
        name = Cname;
        Clable.setSize(20, 20);
        Clable.setLocation(20, 0);
    }

    public void CsetLoc(int x, int y) {
        loc[0] = x;
        loc[1] = y;
        Clable.setLocation(x, y);
    }

    public int[] CgetLoc() {
        return loc;

    }

}
