/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import javax.swing.JLabel;

/**
 *
 * @author Buddika Alwis
 */
public class Obstacle {
    String name;
    int[] loc = {0,0};
    JLabel Olable = new JLabel("//");
    
    public void ObstacleColor(Color color){
        Olable.setBackground(color);
    }
    
    public void ObstacleIni(String Oname) {
        name = Oname;
        Olable.setSize(20, 20);
        Olable.setLocation(0, 0);
    }

    public void OsetLoc(int x, int y) {
        loc[0] = x;
        loc[1] = y;
        Olable.setLocation(x, y);
    }

    public int[] OgetLoc() {
        return loc;

    }
    
}
