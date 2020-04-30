package com.company.right_angled_triangle;

import java.awt.*;

public class Main {
    public static void main(String[] arg) {


        Frame frame = new Frame("Sumator");
        frame.setSize(600, 500);
        RightAngledTriangle applet = new RightAngledTriangle();
        applet.init();
        frame.add(applet);
        frame.setVisible(true);
        applet.start();
    }
}
