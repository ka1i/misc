package com.mardan.test_four;

import java.applet.Applet;

public class test_05 extends Applet {
    public void init() {
        setLayout(new FlowLayout());
        Button b1=new Button("set red");
        Button b2=new Button("set green");
        Button b3=new Button("set blue");
        add(b1);
        add(b2);
        add(b3);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b1.setForeground(Color.RED);
                b2.setForeground(Color.RED);
                b3.setForeground(Color.RED);
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b1.setForeground(Color.GREEN);
                b2.setForeground(Color.GREEN);
                b3.setForeground(Color.GREEN);
            }
        });
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b1.setForeground(Color.BLUE);
                b2.setForeground(Color.BLUE);
                b3.setForeground(Color.BLUE);
            }
        });
    }
}