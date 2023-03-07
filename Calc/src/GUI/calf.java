package GUI;

import java.awt.event.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class calf extends Frame {

    static String steps = ("0");
    static String psdm = ("f");
    static String history = ("");
    static String sqrt = ("f");

    public static void main(String[] args) {
        Frame calWin = new Frame();

        Button calNo_1 = new Button();
        Button calNo_2 = new Button();
        Button calNo_3 = new Button();
        Button calNo_4 = new Button();
        Button calNo_5 = new Button();
        Button calNo_6 = new Button();
        Button calNo_7 = new Button();
        Button calNo_8 = new Button();
        Button calNo_9 = new Button();
        Button calNo_0 = new Button();
        Button calNo_c = new Button();
        Button calNo_b = new Button();
        Button calNo_sub = new Button();
        Button calNo_plus = new Button();
        Button calNo_div = new Button();
        Button calNo_mul = new Button();
        Button calNo_sqrt = new Button();
        Button calNo_sum = new Button();
        Button cal_close = new Button("X");

        calWin.setResizable(false);
        calWin.setUndecorated(false);
        calWin.setBounds(3, 3, 3, 3);
        calWin.setSize(250, 482);
        calWin.setLayout(null);
        calWin.setBackground(Color.MAGENTA);

        TextField input = new TextField();

        Label output = new Label();

        Button history = new Button();

        TextArea historyl = new TextArea();

        Label op = new Label();

        history.setSize(50, 50);
        history.setLocation(190, 100);
        history.setLabel("H");

        historyl.setSize(175, 440);
        historyl.setLocation(267, 30);
        //historyl.setLineWrap(true);
        historyl.setEditable(false);
        historyl.setText("Your Calculation History");

        calNo_sqrt.setSize(50, 50);
        calNo_sqrt.setLocation(70, 180);
        calNo_sqrt.setLabel("sqrt");
        calNo_sqrt.setBackground(Color.GRAY);

        op.setSize(30, 70);
        op.setLocation(10, 80);

        output.setSize(120, 70);
        output.setLocation(40, 80);
        output.setText("Answer");

        input.setSize(230, 40);
        input.setLocation(10, 30);
        input.setText("0");

        calNo_0.setSize(170, 50);
        calNo_0.setLocation(10, 420);
        calNo_0.setLabel("0");
        calNo_0.setBackground(Color.GRAY);

        calNo_1.setSize(50, 50);
        calNo_1.setLocation(10, 360);
        calNo_1.setLabel("1");
        calNo_1.setBackground(Color.GRAY);

        calNo_2.setSize(50, 50);
        calNo_2.setLocation(70, 360);
        calNo_2.setLabel("2");
        calNo_2.setBackground(Color.GRAY);

        calNo_3.setSize(50, 50);
        calNo_3.setLocation(130, 360);
        calNo_3.setLabel("3");
        calNo_3.setBackground(Color.GRAY);

        calNo_4.setSize(50, 50);
        calNo_4.setLocation(10, 300);
        calNo_4.setLabel("4");
        calNo_4.setBackground(Color.GRAY);

        calNo_5.setSize(50, 50);
        calNo_5.setLocation(70, 300);
        calNo_5.setLabel("5");
        calNo_5.setBackground(Color.GRAY);

        calNo_6.setSize(50, 50);
        calNo_6.setLocation(130, 300);
        calNo_6.setLabel("6");
        calNo_6.setBackground(Color.GRAY);

        calNo_7.setSize(50, 50);
        calNo_7.setLocation(10, 240);
        calNo_7.setLabel("7");
        calNo_7.setBackground(Color.GRAY);

        calNo_8.setSize(50, 50);
        calNo_8.setLocation(70, 240);
        calNo_8.setLabel("8");
        calNo_8.setBackground(Color.GRAY);

        calNo_9.setSize(50, 50);
        calNo_9.setLocation(130, 240);
        calNo_9.setLabel("9");
        calNo_9.setBackground(Color.GRAY);

        calNo_c.setSize(50, 50);
        calNo_c.setLocation(10, 180);
        calNo_c.setLabel("C");
        calNo_c.setBackground(Color.GRAY);

        calNo_b.setSize(50, 50);
        calNo_b.setLocation(70, 180);
        calNo_b.setLabel("<");
        calNo_b.setBackground(Color.GRAY);

        calNo_sub.setSize(50, 50);
        calNo_sub.setLocation(130, 180);
        calNo_sub.setLabel("-");
        calNo_sub.setBackground(Color.GRAY);

        calNo_plus.setSize(50, 50);
        calNo_plus.setLocation(190, 180);
        calNo_plus.setLabel("+");
        calNo_plus.setBackground(Color.GRAY);

        calNo_div.setSize(50, 50);
        calNo_div.setLocation(190, 240);
        calNo_div.setLabel("/");
        calNo_div.setBackground(Color.GRAY);

        calNo_mul.setSize(50, 50);
        calNo_mul.setLocation(190, 300);
        calNo_mul.setLabel("X");
        calNo_mul.setBackground(Color.GRAY);

        calNo_sum.setSize(50, 110);
        calNo_sum.setLocation(190, 360);
        calNo_sum.setLabel("=");
        calNo_sum.setBackground(Color.GRAY);

        cal_close.setSize(20, 20);
        cal_close.setLocation(220, 5);

        calWin.add(calNo_0);
        calWin.add(calNo_1);
        calWin.add(calNo_2);
        calWin.add(calNo_3);
        calWin.add(calNo_4);
        calWin.add(calNo_5);
        calWin.add(calNo_6);
        calWin.add(calNo_7);
        calWin.add(calNo_8);
        calWin.add(calNo_9);
        calWin.add(calNo_c);

        calWin.add(calNo_sub);
        calWin.add(calNo_plus);
        calWin.add(calNo_div);
        calWin.add(calNo_mul);
        calWin.add(calNo_sum);
        calWin.add(input);
        calWin.add(output);
        calWin.add(op);
        calWin.add(history);
        calWin.add(historyl);
        calWin.add(calNo_sqrt);

        calWin.add(cal_close);

        input.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent ke) {
                String k = String.valueOf(ke.getKeyChar());

                if (input.getText().isEmpty() & k.equals("0") | !Character.isDigit(ke.getKeyChar())) {
                    ke.consume();
                }

                if (input.getText().isEmpty()) {
                    input.setText("0");
                }
                if (k.equals("x")) {
                    if (steps.equals("0")) {
                        output.setText("0");
                    }
                    calf.history = (calf.history + "\n" + steps + "   √" + input.getText());
                    input.setText(String.valueOf(Math.sqrt(Double.parseDouble(input.getText()))));
                    calf.history = (calf.history + " = " + input.getText());
                    steps = String.valueOf(Integer.parseInt(steps) + 1);

                }
                if (k.equals("\n")) {

                    if (psdm.equals("p")) {
                        calf.history = (calf.history + "\n" + steps + "   " + output.getText() + " + " + input.getText());
                        output.setText(String.valueOf(Double.parseDouble(output.getText()) + Double.parseDouble(input.getText())));
                        calf.history = (calf.history + " = " + output.getText());
                        historyl.setText(calf.history);
                    }
                    if (psdm.equals("s")) {
                        calf.history = (calf.history + "\n" + steps + "   " + output.getText() + " - " + input.getText());
                        output.setText(String.valueOf(Double.parseDouble(output.getText()) - Double.parseDouble(input.getText())));
                        calf.history = (calf.history + " = " + output.getText());
                        historyl.setText(calf.history);
                    }
                    if (psdm.equals("d")) {
                        calf.history = (calf.history + "\n" + steps + "   " + output.getText() + " / " + input.getText());
                        output.setText(String.valueOf(Double.parseDouble(output.getText()) / Double.parseDouble(input.getText())));
                        calf.history = (calf.history + " = " + output.getText());
                        historyl.setText(calf.history);
                    }
                    if (psdm.equals("m")) {
                        calf.history = (calf.history + "\n" + steps + "   " + output.getText() + " * " + input.getText());
                        output.setText(String.valueOf(Double.parseDouble(output.getText()) * Double.parseDouble(input.getText())));
                        calf.history = (calf.history + " = " + output.getText());
                        historyl.setText(calf.history);
                    }
                    psdm = ("f");
                    op.setText(" = ");
                    input.setText("0");
                    input.requestFocus();

                }
                if (k.equals("+")) {
                    if (!input.getText().equals("0")) {
                        allcalc(input, output);
                        psdm = ("p");
                        op.setText(" + ");
                        historyl.setText(calf.history);
                        input.requestFocus();
                    } else if (!calf.steps.equals("0")) {
                        psdm = ("p");
                        op.setText(" + ");
                    } else {
                        JOptionPane.showMessageDialog(calWin, "Input a Number", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (k.equals("-")) {
                    if (!input.getText().equals("0")) {
                        allcalc(input, output);
                        psdm = ("s");
                        op.setText(" - ");
                        historyl.setText(calf.history);
                        input.requestFocus();
                    } else if (!calf.steps.equals("0")) {
                        psdm = ("s");
                        op.setText(" - ");
                    } else {
                        JOptionPane.showMessageDialog(calWin, "Input a Number", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (k.equals("*")) {
                    if (!input.getText().equals("0")) {
                        allcalc(input, output);
                        psdm = ("m");
                        op.setText(" * ");
                        historyl.setText(calf.history);
                        input.requestFocus();
                    } else if (!calf.steps.equals("0")) {
                        psdm = ("m");
                        op.setText(" * ");
                    } else {
                        JOptionPane.showMessageDialog(calWin, "Input a Number", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                if (k.equals("/")) {
                    if (!input.getText().equals("0")) {
                        allcalc(input, output);
                        psdm = ("d");
                        op.setText(" / ");
                        historyl.setText(calf.history);
                        input.requestFocus();
                    } else if (!calf.steps.equals("0")) {
                        psdm = ("d");
                        op.setText(" / ");
                    } else {
                        JOptionPane.showMessageDialog(calWin, "Input a Number", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                }

                if (k.equals("0")) {
                    if (input.getText().equals("0")) {
                        input.setText("");
                    }
                }
                if (k.equals("1")) {
                    if (input.getText().equals("0")) {
                        input.setText("");
                    }
                }
                if (k.equals("2")) {
                    if (input.getText().equals("0")) {
                        input.setText("");
                    }
                }
                if (k.equals("3")) {
                    if (input.getText().equals("0")) {
                        input.setText("");
                    }
                }
                if (k.equals("4")) {
                    if (input.getText().equals("0")) {
                        input.setText("");
                    }
                }
                if (k.equals("5")) {
                    if (input.getText().equals("0")) {
                        input.setText("");
                    }
                }
                if (k.equals("6")) {
                    if (input.getText().equals("0")) {
                        input.setText("");
                    }
                }
                if (k.equals("7")) {
                    if (input.getText().equals("0")) {
                        input.setText("");
                    }
                }
                if (k.equals("8")) {
                    if (input.getText().equals("0")) {
                        input.setText("");
                    }
                }
                if (k.equals("9")) {
                    if (input.getText().equals("0")) {
                        input.setText("");
                    }
                }

            }

            @Override
            public void keyPressed(KeyEvent ke) {

            }

            @Override
            public void keyReleased(KeyEvent ke) {
                String k = String.valueOf(ke.getKeyChar());
                if (k.equals("0")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_0.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_0.setBackground(Color.GRAY);

                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
                if (k.equals("1")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_1.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_1.setBackground(Color.GRAY);
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
                if (k.equals("2")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_2.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_2.setBackground(Color.GRAY);
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
                if (k.equals("3")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_3.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_3.setBackground(Color.GRAY);
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
                if (k.equals("4")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_4.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_4.setBackground(Color.GRAY);
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
                if (k.equals("5")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_5.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_5.setBackground(Color.GRAY);
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
                if (k.equals("6")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_6.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_6.setBackground(Color.GRAY);
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
                if (k.equals("7")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_7.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_7.setBackground(Color.GRAY);
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
                if (k.equals("8")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_8.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_8.setBackground(Color.GRAY);
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
                if (k.equals("9")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_9.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_9.setBackground(Color.GRAY);
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
                if (k.equals("+")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_plus.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_plus.setBackground(Color.GRAY);
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
                if (k.equals("-")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_sub.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_sub.setBackground(Color.GRAY);
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
                if (k.equals("*")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_mul.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_mul.setBackground(Color.GRAY);
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
                if (k.equals("/")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_div.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_div.setBackground(Color.GRAY);
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
                if (k.equals("\n")) {
                    Thread t = new Thread() {
                        public void run() {
                            try {
                                calNo_sum.setBackground(Color.PINK);
                                Thread.sleep(150);
                                calNo_sum.setBackground(Color.GRAY);
                            } catch (InterruptedException e) {
                            }
                        }
                    };
                    t.start();
                }
            }
        });

        /*historyl.addKeyListener(new KeyListener() {
         @Override
         public void keyTyped(KeyEvent ke) {
         ke.consume();
         }

         @Override
         public void keyPressed(KeyEvent ke) {
         if(ke.getKeyCode()==8){
         ke.consume();
         }
               
         }

         @Override
         public void keyReleased(KeyEvent ke) {
                
         }
         });*/
        history.addActionListener((ae) -> {
            Thread t1 = new Thread() {
                public void run() {
                    while (calWin.getSize().getWidth() < 458) {
                        calWin.setSize((int) calWin.getSize().getWidth() + 15, (int) calWin.getSize().getHeight());
                        try {
                            Thread.sleep(1);
                        } catch (Exception e) {
                        }
                    }
                }
            };
            Thread t2 = new Thread() {
                public void run() {
                    while (calWin.getSize().getWidth() > 250) {
                        calWin.setSize((int) calWin.getSize().getWidth() - 15, (int) calWin.getSize().getHeight());
                        try {
                            Thread.sleep(1);
                        } catch (Exception e) {
                        }
                    }
                }
            };
            if (history.getLabel().equals("H")) {

                if (!t2.isAlive()) {
                    t1.start();
                }
                history.setLabel("<");
            } else if (history.getLabel().equals("<")) {
                if (!t1.isAlive()) {
                    t2.start();
                }
                history.setLabel("H");
            }
            input.requestFocus();
        });

        calNo_0.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_0.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_0.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (!input.getText().equals("") & !input.getText().equals("0")) {
                input.setText(input.getText() + "0");
            } else {

            }
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        calNo_1.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_1.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_1.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (input.getText().equals("0")) {
                input.setText("");
            }
            input.setText(input.getText() + "1");
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        calNo_2.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_2.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_2.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (input.getText().equals("0")) {
                input.setText("");
            }
            input.setText(input.getText() + "2");
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        calNo_3.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_3.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_3.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (input.getText().equals("0")) {
                input.setText("");
            }
            input.setText(input.getText() + "3");
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        calNo_4.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_4.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_4.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (input.getText().equals("0")) {
                input.setText("");
            }
            input.setText(input.getText() + "4");
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        calNo_5.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_5.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_5.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (input.getText().equals("0")) {
                input.setText("");
            }
            input.setText(input.getText() + "5");
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        calNo_6.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_6.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_6.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (input.getText().equals("0")) {
                input.setText("");
            }
            input.setText(input.getText() + "6");
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        calNo_7.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_7.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_7.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (input.getText().equals("0")) {
                input.setText("");
            }
            input.setText(input.getText() + "7");
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        calNo_8.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_8.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_8.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (input.getText().equals("0")) {
                input.setText("");
            }
            input.setText(input.getText() + "8");
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        calNo_9.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_9.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_9.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (input.getText().equals("0")) {
                input.setText("");
            }
            input.setText(input.getText() + "9");
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        calNo_c.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_c.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_c.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();

            input.setText("0");
            output.setText("Answer");
            psdm = ("f");
            steps = ("0");
            historyl.setText("Your Calculation History");
            calf.history = ("");
            op.setText("");
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        calNo_plus.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_plus.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_plus.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (!input.getText().equals("0")) {
                allcalc(input, output);
                psdm = ("p");
                op.setText(" + ");
                historyl.setText(calf.history);

            } else if (!calf.steps.equals("0")) {
                psdm = ("p");
                op.setText(" + ");
            } else {
                JOptionPane.showMessageDialog(calWin, "Input a Number", "Error", JOptionPane.ERROR_MESSAGE);
            }
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        calNo_sub.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_sub.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_sub.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (!input.getText().equals("0")) {
                allcalc(input, output);
                psdm = ("s");
                op.setText(" - ");
                historyl.setText(calf.history);

            } else if (!calf.steps.equals("0")) {
                psdm = ("s");
                op.setText(" - ");
            } else {
                JOptionPane.showMessageDialog(calWin, "Input a Number", "Error", JOptionPane.ERROR_MESSAGE);
            }
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        calNo_mul.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_mul.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_mul.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (!input.getText().equals("0")) {
                allcalc(input, output);
                psdm = ("m");
                op.setText(" * ");
                historyl.setText(calf.history);

            } else if (!calf.steps.equals("0")) {
                psdm = ("m");
                op.setText(" * ");
            } else {
                JOptionPane.showMessageDialog(calWin, "Input a Number", "Error", JOptionPane.ERROR_MESSAGE);
            }
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        calNo_div.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_div.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_div.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (!input.getText().equals("0")) {
                allcalc(input, output);
                psdm = ("d");
                op.setText(" / ");
                historyl.setText(calf.history);

            } else if (!calf.steps.equals("0")) {
                psdm = ("d");
                op.setText(" / ");
            } else {
                JOptionPane.showMessageDialog(calWin, "Input a Number", "Error", JOptionPane.ERROR_MESSAGE);
            }
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });
        calNo_sqrt.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_sqrt.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_sqrt.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();
            if (steps.equals("0")) {
                output.setText("0");
            }
            calf.history = (calf.history + "\n" + steps + "   √" + input.getText());
            input.setText(String.valueOf(Math.sqrt(Double.parseDouble(input.getText()))));
            calf.history = (calf.history + " = " + input.getText());
            steps = String.valueOf(Integer.parseInt(steps) + 1);
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });
        calNo_sum.addActionListener((ae) -> {
            Thread t = new Thread() {
                public void run() {
                    try {
                        calNo_sum.setBackground(Color.PINK);
                        Thread.sleep(150);
                        calNo_sum.setBackground(Color.GRAY);
                    } catch (InterruptedException e) {
                    }
                }
            };
            t.start();

            if (psdm.equals("p")) {
                calf.history = (calf.history + "\n" + steps + "   " + output.getText() + " + " + input.getText());
                output.setText(String.valueOf(Double.parseDouble(output.getText()) + Double.parseDouble(input.getText())));
                calf.history = (calf.history + " = " + output.getText());
                historyl.setText(calf.history);
            }
            if (psdm.equals("s")) {
                calf.history = (calf.history + "\n" + steps + "   " + output.getText() + " - " + input.getText());
                output.setText(String.valueOf(Double.parseDouble(output.getText()) - Double.parseDouble(input.getText())));
                calf.history = (calf.history + " = " + output.getText());
                historyl.setText(calf.history);
            }
            if (psdm.equals("d")) {
                calf.history = (calf.history + "\n" + steps + "   " + output.getText() + " / " + input.getText());
                output.setText(String.valueOf(Double.parseDouble(output.getText()) / Double.parseDouble(input.getText())));
                calf.history = (calf.history + " = " + output.getText());
                historyl.setText(calf.history);
            }
            if (psdm.equals("m")) {
                calf.history = (calf.history + "\n" + steps + "   " + output.getText() + " * " + input.getText());
                output.setText(String.valueOf(Double.parseDouble(output.getText()) * Double.parseDouble(input.getText())));
                calf.history = (calf.history + " = " + output.getText());
                historyl.setText(calf.history);
            }
            psdm = ("f");
            op.setText(" = ");
            input.setText("0");
            input.requestFocus();
            input.setCaretPosition(input.getText().length());
        });

        cal_close.addActionListener((ae) -> {
            calWin.dispose();
        });

        calWin.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        calWin.setTitle("Simple Calc");
        calWin.setVisible(true);
        calWin.setLocationRelativeTo(null);

        input.requestFocus();

    }

    public static String allcalc(TextField in, Label out) {
        String allfsum = ("");
        if ((psdm + steps).equals("f0")) {

            out.setText(String.valueOf(Double.parseDouble(in.getText())));
            in.setText("0");
            steps = String.valueOf(Integer.parseInt(steps) + 1);
        }
        if ((psdm.equals("p")) & (Integer.parseInt(steps) > 0)) {
            history = (history + "\n" + steps + "   " + out.getText() + " + " + in.getText());
            allfsum = String.valueOf(Double.parseDouble(out.getText()) + Double.parseDouble(in.getText()));
            out.setText(allfsum);
            calf.history = (calf.history + " = " + out.getText());
            in.setText("0");
            steps = String.valueOf(Integer.parseInt(steps) + 1);
        }
        if ((psdm.equals("s")) & (Integer.parseInt(steps) > 0)) {
            history = (history + "\n" + steps + "   " + out.getText() + " - " + in.getText());
            allfsum = String.valueOf(Double.parseDouble(out.getText()) - Double.parseDouble(in.getText()));
            out.setText(allfsum);
            calf.history = (calf.history + " = " + out.getText());
            in.setText("0");
            steps = String.valueOf(Integer.parseInt(steps) + 1);
        }
        if ((psdm.equals("d")) & (Integer.parseInt(steps) > 0)) {
            history = (history + "\n" + steps + "   " + out.getText() + " / " + in.getText());
            allfsum = String.valueOf(Double.parseDouble(out.getText()) / Double.parseDouble(in.getText()));
            out.setText(allfsum);
            calf.history = (calf.history + " = " + out.getText());
            in.setText("0");
            steps = String.valueOf(Integer.parseInt(steps) + 1);
        }
        if ((psdm.equals("m")) & (Integer.parseInt(steps) > 0)) {
            history = (history + "\n" + steps + "   " + out.getText() + " * " + in.getText());
            allfsum = String.valueOf(Double.parseDouble(out.getText()) * Double.parseDouble(in.getText()));
            out.setText(allfsum);
            calf.history = (calf.history + " = " + out.getText());
            in.setText("0");
            steps = String.valueOf(Integer.parseInt(steps) + 1);
        }
        return allfsum;
    }
}
