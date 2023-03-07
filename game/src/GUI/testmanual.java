/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Buddika Alwis
 */
public class testmanual extends JFrame {

    static boolean[][] map = new boolean[2000][2000];

    static String allcordinates = "";

    static int map_location_x = 0;
    static int map_location_y = 0;

    static int map_x = 0;
    static int map_y = 0;

    static boolean maploading = true;

    static double window_x = 0;
    static double window_y = 0;

    static boolean gravity = true;

    static boolean idleIsAlive = true;
    static boolean idleIsDead = false;
    static boolean running = false;
    static boolean jumping = false;
    static boolean attacking = false;

    //static int onru = 0;

    static boolean dead = false;

    static boolean rightd = true;
    static boolean turned = false;
    final static String left = "37";
    final static String right = "39";
    final static String up = "38";
    final static String down = "40";

    public static void main(String[] args) {

        JFrame game = new JFrame();
        game.setSize(500, 500);
        game.setLocationRelativeTo(null);
        game.setLayout(null);
        JLabel back = new JLabel(new ImageIcon("src/resources/bitmap.png"));
        back.setOpaque(true);
        game.setContentPane(back);

        Charactor buddika = new Charactor();
        buddika.CharactorIni("Buddika");
        buddika.Clable.setSize(110, 200);
        game.add(buddika.Clable);

        JLabel cordinates = new JLabel();
        cordinates.setLocation(buddika.CgetLoc()[0], buddika.CgetLoc()[1] + 200);
        cordinates.setSize(400, 50);
        game.add(cordinates);

        buddika.Clable.setFocusable(true);
        buddika.Clable.requestFocus();

        //new testmanual().running(true,buddika);
        new testmanual().idle(buddika);

        buddika.Clable.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {

            }

            @Override
            public void keyPressed(KeyEvent ke) {
                String key = String.valueOf(ke.getKeyCode());

                if (null != key) {
                    switch (key) {
                        case right:
                            if (!running) {

                                rightd = true;
                                running = true;
                                idleIsDead = true;
                                new testmanual().running(buddika, right, game);
                                System.out.println("pressed right");
                            }
                            break;
                        case left:
                            if (!running) {

                                rightd = false;
                                running = true;
                                idleIsDead = true;
                                new testmanual().running(buddika, left, game);
                                System.out.println("pressed left");
                            }
                            break;
                        /* else if (down.equals(key)) {
                if (!attacking) {
                attacking = true;
                idleIsDead = true;
                new testmanual().attack(buddika);
                System.out.println("pressed down");
                }
                }*/
                        case up:
                            if (!jumping) {

                                jumping = true;
                                idleIsDead = true;
                                new testmanual().jump(buddika);
                                System.out.println("pressed up");
                            }
                            break;
                        default:
                            break;
                    }/* else if (down.equals(key)) {
                    if (!attacking) {
                        attacking = true;
                        idleIsDead = true;
                        new testmanual().attack(buddika);
                        System.out.println("pressed down");
                    }

                }*/
                }

            }

            @Override
            public void keyReleased(KeyEvent ke) {
                String key = String.valueOf(ke.getKeyCode());
                if (null != key) {
                    switch (key) {
                        case right:
                            running = false;
                            idleIsDead = false;
                            if (!jumping & !idleIsAlive) {
                                new testmanual().idle(buddika);
                            }
                            System.out.println("released right");
                            turned = true;
                            break;
                        case left:
                            running = false;
                            idleIsDead = false;
                            if (!jumping & !idleIsAlive) {
                                new testmanual().idle(buddika);
                            }
                            System.out.println("released left");
                            turned = true;
                            break;
                        /* else if (down.equals(key)) {
                attacking = false;
                idleIsDead = false;
                System.out.println("released down");
                }*/
                        case up:
                            idleIsDead = false;
                            System.out.println("released up");
                            break;
                        default:
                            break;
                    }/* else if (down.equals(key)) {
                    attacking = false;
                    idleIsDead = false;

                    System.out.println("released down");

                }*/
                }

            }
        });

        game.getContentPane().setBackground(Color.BLACK);

        game.setExtendedState(MAXIMIZED_BOTH);
        game.setDefaultCloseOperation(EXIT_ON_CLOSE);
        game.setVisible(true);

        Thread t = new Thread() {
            @Override
            public void run() {
                int[] loca;
                while (true) {
                    if (maploading) {
                        for (int i = 0; i < map.length; i++) {
                            for (int j = 0; j < map[i].length; j++) {

                                map[i][j] = false;

                                if (i > 400 & 900 > i & j > 450) {
                                    map[i][j] = true;
                                } else if (j > 500) {
                                    map[i][j] = true;

                                }

                            }
                        }
                        System.out.println("Loading Complete");

                    }
                    maploading = false;
                    double h = game.getSize().getHeight();
                    double w = game.getSize().getWidth();
                    window_x = w;
                    window_y = h;
                    loca = buddika.CgetLoc();

                    map_location_x = (buddika.CgetLoc()[0]) + 40;
                    map_location_y = ((buddika.CgetLoc()[1])) + 130;

                    if (map_location_x < 0) {
                        map_location_x = 0;
                    }
                    if (map_location_y <= 0) {
                        map_location_y = 0;
                    }
                    allcordinates = ("X " + (loca[0] + 110) + "\n Y " + (loca[1] + 200) + " window x " + String.valueOf((int) w) + " window y " + String.valueOf((int) h) + " map x " + map_location_x + " map y " + map_location_y);
                    cordinates.setLocation(((int) w) - 400, 0);
                    cordinates.setText(allcordinates);

                }
            }
        };
        t.start();

    }

    public void running(Charactor charac, String direction, JFrame game) {

        Thread t = new Thread() {
            @Override
            public void run() {
                try {

                    int i = 0;
                    while (running) {
                        if (!jumping & !map[map_location_x][map_location_y]) {

                            gravity(charac);
                        }
                        double h = game.getSize().getHeight();
                        double w = game.getSize().getWidth();

                        if (direction.equals(right)) {

                            if (!jumping) {
                                charac.Clable.setIcon(scalingimg("Run", i, 110));
                            }
                            if ((charac.CgetLoc()[0]) > (int) w) {
                                charac.CgetLoc()[0] = -120;

                            }
                            if (!map[map_location_x + 10][map_location_y - 20]) {

                                charac.CsetLoc(charac.CgetLoc()[0] + 10, charac.CgetLoc()[1]);

                            }
                            /*if ((obs.OgetLoc()[0] - 120 < charac.CgetLoc()[0]) & (obs.OgetLoc()[0] > charac.CgetLoc()[0])) {
                                break;
                            }*/
                            //check for obsticles

                            /*if (map[0][map_location_x] & map[1][map_location_y]) {

                                break;

                            }*/
                        }
                        if (direction.equals(left)) {
                            if (!jumping) {
                                charac.Clable.setIcon(scalingimg("FRun", i, 110));
                            }
                            if ((charac.CgetLoc()[0]) < -120) {
                                charac.CgetLoc()[0] = (int) w;

                            }
                            /*if ((obs.OgetLoc()[0] < charac.CgetLoc()[0]) & (obs.OgetLoc()[0] + 100 > charac.CgetLoc()[0])) {
                                break;
                            }*/
                            ///check obsticles

                            if (!map[map_location_x - 10][map_location_y - 20]) {

                                charac.CsetLoc(charac.CgetLoc()[0] - 10, charac.CgetLoc()[1]);

                            }

                        }
                        Thread.sleep(30);
                        i++;

                        if (i > 9) {

                            i = 0;
                        }

                    }

                    turned = false;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    public void idle(Charactor charac) {

        Thread t = new Thread() {
            public void run() {
                try {

                    int i = 0;
                    while (true) {
                        idleIsAlive = true;
                        if (idleIsDead) {
                            break;
                        }
                        if (rightd) {
                            charac.Clable.setIcon(scalingimg("Idle", i, 80));
                        } else {
                            charac.Clable.setIcon(scalingimg("FIdle", i, 80));
                        }

                        Thread.sleep(50);
                        i++;

                        if (!map[map_location_x][map_location_y]) {
                            gravity(charac);
                        }

                        if (i > 9) {
                            i = 0;
                        }

                    }
                    idleIsAlive = false;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();

    }

    public void jump(Charactor charac) {
        Thread t = new Thread() {
            public void run() {
                try {
                    int[] location = {0, 0};
                    /*if (this.isAlive()) {
                        running = true;
                    }*/
                    int i = 0;
                    if (jumping) {
                        while (true) {

                            location = charac.CgetLoc();
                            //if (!attacking) {
                            if (rightd) {
                                charac.Clable.setIcon(scalingimg("Jump", i, 110));

                            }
                            if (!rightd) {
                                charac.Clable.setIcon(scalingimg("FJump", i, 110));

                            }
                            //}

                            if (i < 5) {
                                charac.CsetLoc(location[0], location[1] - 10);
                                i++;
                            } else {
                                if (!map[map_location_x][map_location_y]) {
                                    charac.CsetLoc(location[0], location[1] + 10);
                                }

                                i++;
                            }
                            Thread.sleep(50);

                            if (i > 9) {

                                if (!running) {
                                    new testmanual().idle(charac);
                                }

                                dead = false;
                                jumping = false;
                                break;
                            }

                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    public void attack(Charactor charac) {

        Thread t = new Thread() {
            public void run() {
                try {

                    /*if (this.isAlive()) {
                        running = true;
                    }*/
                    int i = 0;
                    if (attacking) {
                        while (true) {

                            if (rightd) {
                                charac.Clable.setIcon(scalingimg("Attack", i, 110));

                            }
                            if (!rightd) {
                                charac.Clable.setIcon(scalingimg("FAttack", i, 110));

                            }

                            Thread.sleep(80);
                            i++;
                            if (i > 9) {
                                if (!jumping) {
                                    new testmanual().idle(charac);
                                }
                                attacking = false;
                                break;
                            }

                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
    }

    public ImageIcon scalingimg(String action, int i, int wide) {
        ImageIcon icon = new ImageIcon("src/resources/" + action + "__00" + String.valueOf(i) + ".png");
        Image image = icon.getImage();
        Image newimg = image.getScaledInstance(wide, 160, Image.SCALE_SMOOTH);
        icon = new ImageIcon(newimg);
        return icon;
    }

    public static void gravity(Charactor charac) {

        charac.CsetLoc(charac.CgetLoc()[0], charac.CgetLoc()[1] + 10);

        if (charac.CgetLoc()[1] > window_y) {
            charac.CsetLoc(charac.CgetLoc()[0], -150);
        }

    }

}
