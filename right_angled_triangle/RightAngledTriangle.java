package com.company.right_angled_triangle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//ЗАДАЧА
//Да се създаде аплет, който изчислявя периметъра и лицена правоъгълен
// триъгълник по дадени a,b,c(хипотенуза) и изчертава триъгълника и два
//долепени квадрата със страни двата катета.

public class RightAngledTriangle extends JApplet {
    private double a;
    private double b;
    private double c;
    Graphics aGraphics;
    private TextField NumberAField = new TextField();
    private TextField NumberBField = new TextField();
    private TextField NumberCField = new TextField();
    private Button mCalcButton = new Button();
    private TextField mPField = new TextField();
    private TextField mSField = new TextField();
    private Color mLastBackgroundColor;
    private JMenuBar mb;
    private JMenu font, color;
    private JCheckBoxMenuItem mItalic, mBold;
    private JRadioButtonMenuItem mRed, mBlack, mBlue;
    private JMenuItem mReset;
    private JLabel text;
    private JCheckBox italic, bold;
    private JButton reset;
    private JRadioButton red, black, blue;

    private void setAll() {
        Color clr;
        String txt = " текст на сив фон";
        int style = Font.PLAIN;
        if (italic.isSelected()) {
            style |= Font.ITALIC;
        }
        if (bold.isSelected()) {
            style |= Font.BOLD;
        }
        if (red.isSelected()) {
            txt = "Червен" + txt;
            clr = Color.RED;
        } else {
            if (black.isSelected()) {
                txt = "Черен" + txt;
                clr = Color.BLACK;
            } else {
                txt = "Син" + txt;
                clr = Color.BLUE;
            }
        }
        text.setText(txt);
        text.setFont(new Font("Arial", style, 20));
        text.setForeground(clr);
    }

    public void init() {
        int w, h;
        w = getWidth();
        h = getHeight();
        setLayout(null);
        JPanel pnl = new JPanel();
        pnl.setBounds(555, 5, w - 10, h - 25);
        pnl.setBorder(BorderFactory.createEtchedBorder());
        pnl.setLayout(null);
        text = new JLabel();
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setBounds(5, 5, pnl.getWidth() - 10, pnl.getHeight() / 3);
        text.setBorder(BorderFactory.createEtchedBorder());
        pnl.add(text);
        italic = new JCheckBox("Курсивен шрифт");
        bold = new JCheckBox("Удебелен шрифт");
        reset = new JButton("Изчисти");
        italic.setBounds(text.getX(), text.getY() + text.getHeight() + 5, text.getWidth() / 2 - 5, 30);
        bold.setBounds(italic.getX(), italic.getY() + italic.getHeight() + 5, italic.getWidth(), italic.getHeight());
        reset.setBounds(bold.getX(), bold.getY() + bold.getHeight() + 5, bold.getWidth(), bold.getHeight());
        pnl.add(italic);
        pnl.add(bold);
        pnl.add(reset);
        ButtonGroup bg = new ButtonGroup();
        red = new JRadioButton("Червен", true);
        black = new JRadioButton("Черен", false);
        blue = new JRadioButton("Син", false);
        bg.add(red);
        bg.add(black);
        bg.add(blue);
        red.setBounds(italic.getX() + italic.getWidth() + 5, italic.getY(), italic.getWidth(), italic.getHeight());
        black.setBounds(red.getX(), bold.getY(), red.getWidth(), red.getHeight());
        blue.setBounds(black.getX(), reset.getY(), black.getWidth(), black.getHeight());
        pnl.add(red);
        pnl.add(black);
        pnl.add(blue);
        mb = new JMenuBar();
        font = new JMenu("Шрифт");
        mItalic = new JCheckBoxMenuItem("Курсив", false);
        mBold = new JCheckBoxMenuItem("Удебелен", false);
        mReset = new JMenuItem("Изчисти");
        font.add(mItalic);
        font.add(mBold);
        font.addSeparator();
        font.add(mReset);
        color = new JMenu("Цвят");
        ButtonGroup mBG = new ButtonGroup();
        mRed = new JRadioButtonMenuItem("Червен", true);
        mBlack = new JRadioButtonMenuItem("Черен", false);
        mBlue = new JRadioButtonMenuItem("Син", false);
        mBG.add(mRed);
        mBG.add(mBlack);
        mBG.add(mBlue);
        color.add(mRed);
        color.add(mBlack);
        color.add(mBlue);
        mb.add(font);
        mb.add(color);
        setJMenuBar(mb);
        setAll();
        add(pnl);
        mItalic.addActionListener(e -> italic.setSelected(mItalic.isSelected()));
        mBold.addActionListener(e -> bold.setSelected(mBold.isSelected()));
        italic.addActionListener(e -> mItalic.setSelected(italic.isSelected()));
        bold.addActionListener(e -> mBold.setSelected(bold.isSelected()));
        mRed.addActionListener(e -> red.setSelected(mRed.isSelected()));
        mBlack.addActionListener(e -> black.setSelected(mBlack.isSelected()));
        mBlue.addActionListener(e -> blue.setSelected(mBlue.isSelected()));
        red.addActionListener(e -> mRed.setSelected(red.isSelected()));
        black.addActionListener(e -> mBlack.setSelected(black.isSelected()));
        blue.addActionListener(e -> mBlue.setSelected(blue.isSelected()));
        italic.addItemListener(e -> setAll());
        bold.addItemListener(italic.getItemListeners()[0]);
        red.addItemListener(italic.getItemListeners()[0]);
        black.addItemListener(italic.getItemListeners()[0]);
        blue.addItemListener(italic.getItemListeners()[0]);
        reset.addActionListener(e -> {
            italic.setSelected(true);
            italic.doClick();
            bold.setSelected(true);
            bold.doClick();
            red.doClick();
        });
        mReset.addActionListener(e -> reset.doClick());
        this.setBackground(Color.black);

        this.setLayout(null);
        NumberAField.setBounds(new Rectangle(40, 50, 80, 20));
        NumberAField.setBackground(Color.white);
        this.add(NumberAField, null);
        NumberAField.setText("10");

        NumberBField.setBounds(new Rectangle(40, 75, 80, 20));
        NumberBField.setBackground(Color.white);
        this.add(NumberBField, null);
        NumberBField.setText("3");

        NumberCField.setBounds(new Rectangle(40, 100, 80, 20));
        NumberCField.setBackground(Color.white);
        this.add(NumberCField, null);
        NumberCField.setText("10");


        mCalcButton.setBounds(new Rectangle(70, 15, 90, 25));
        mCalcButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        hypotenuseValidator();
                        calcSum();
                        repaint();
                    }
                });
        mCalcButton.setLabel("ПРЕСМЕТНИ");
        this.add(mCalcButton, null);

        mPField.setEditable(false);
        mPField.setBackground(Color.gray);
        mPField.setForeground(Color.white);
        mPField.setBounds(new Rectangle(180, 55, 240, 25));
        this.add(mPField, null);

        mSField.setEditable(false);
        mSField.setBackground(Color.gray);
        mSField.setForeground(Color.white);
        mSField.setBounds(new Rectangle(180, 85, 240, 25));
        this.add(mSField, null);

        this.a = Double.parseDouble(NumberAField.
                getText());
        this.b = Double.parseDouble(NumberBField.
                getText());

        hypotenuseValidator();

    }

    private void hypotenuseValidator() {
        double hypotenuse = Double.parseDouble(String.valueOf(Math.round(Math.sqrt((this.a * this.a) + (this.b * this.b)) * 100.0) / 100.0));
        if (Double.parseDouble(NumberCField.getText()) == hypotenuse) {
            this.c = Double.parseDouble(NumberCField.getText());
        } else {
            this.c = hypotenuse;
            NumberCField.setText(String.valueOf(hypotenuse));
        }
    }


    public boolean mouseDown(Event aEvent, int aX, int aY) {
        mLastBackgroundColor = this.getBackground();
        this.setBackground(Color.red);
        return true;
    }

    public boolean mouseUp(Event aEvent, int aX, int aY) {
        this.setBackground(mLastBackgroundColor);
        return true;
    }

    public void paint(Graphics aGraphics) {
        super.paint(aGraphics);
        Font font = new Font("Dialog", Font.BOLD, 23);
        aGraphics.setFont(font);

        aGraphics.setColor(Color.black);
        this.a = Double.parseDouble(this.NumberAField.getText());
        this.b = Double.parseDouble(this.NumberBField.getText());
        hypotenuseValidator();

        double a = this.a * 10;
        double b = this.b * 10;
        int aCatheter = 200 + Integer.parseInt(String.valueOf(Math.round(a)));
        int bCatheter = 300 - Integer.parseInt(String.valueOf(Math.round(b)));
        //a
        aGraphics.drawLine(200, 300, aCatheter, 300);
        //b
        aGraphics.drawLine(200, 300, 200, bCatheter);
        //c
        aGraphics.drawLine(aCatheter, 300, 200, bCatheter);

        //A - square
        aGraphics.drawRect(200, 300, Integer.parseInt(String.valueOf(Math.round(a))), Integer.parseInt(String.valueOf(Math.round(a))));

        //B - square
        aGraphics.drawRect(200 - Integer.parseInt(String.valueOf(Math.round(b))), bCatheter , Integer.parseInt(String.valueOf(Math.round(b))), Integer.parseInt(String.valueOf(Math.round(b))));

    }

    private void calcSum() {
        try {
            double a = Double.parseDouble(NumberAField.
                    getText());
            double b = Double.parseDouble(NumberBField.
                    getText());
            double c = Double.parseDouble(NumberCField.
                    getText());


            double s = (a * b) / 2;
            double p = a + b + c;
            mSField.setText(" S = " + s);
            mPField.setText(" P = " + p);
        } catch (Exception ex) {
            mSField.setText("Error!");
            mPField.setText("Error!");
        }
        repaint();
    }


}

