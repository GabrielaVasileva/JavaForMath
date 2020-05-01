package com.company.circle;

import javax.swing.*;
import java.util.Scanner;

/**
 * Created by infuntis on 15/01/17.
 */
public class Main extends JFrame {

    public Main(){
        setTitle("Sumator");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 500);
        add(new Circle());
        setVisible(true);
    }

    public static void main(String[] args) {
        Main mw = new Main();
    }
}
