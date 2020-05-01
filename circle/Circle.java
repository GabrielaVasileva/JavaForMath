package com.company.circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Circle extends JPanel {
    private double r;
    private double d;
    Graphics aGraphics;
    private TextField NumberRField = new TextField();
    private TextField NumberDField = new TextField();
    private Button mCalcButton = new Button();
    private TextField mPField = new TextField();
    private TextField mSField = new TextField();
    private Color mLastBackgroundColor;
    private JLabel rLabel = new JLabel();
    private JLabel dLabel = new JLabel();

    public Circle() {
        init();
    }

    public void init() {
        this.setLayout(null);
        NumberRField.setBounds(new Rectangle(40, 55, 80, 20));
        NumberRField.setBackground(Color.white);
        this.add(NumberRField, this);
        NumberRField.setText("5");

        this.setLayout(null);
        NumberDField.setBounds(new Rectangle(40, 85, 80, 20));
        NumberDField.setBackground(Color.white);
        this.add(NumberDField, this);
        NumberDField.setText("10");


        mCalcButton.setBounds(new Rectangle(70, 15, 90, 25));
        mCalcButton.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        parametersValidator();
                        calcSum();
                        repaint();
                    }
                });
        mCalcButton.setLabel("ПРЕСМЕТНИ");
        this.add(mCalcButton, this);

        mPField.setEditable(false);
        mPField.setBackground(Color.gray);
        mPField.setForeground(Color.white);
        mPField.setBounds(new Rectangle(180, 55, 240, 25));
        this.add(mPField, this);

        mSField.setEditable(false);
        mSField.setBackground(Color.gray);
        mSField.setForeground(Color.white);
        mSField.setBounds(new Rectangle(180, 85, 240, 25));
        this.add(mSField, this);


    }

    private void parametersValidator() {
        if ((this.NumberDField.getText() == null
                && Math.round(Double.parseDouble(this.NumberDField.getText())) == 0)
                &&
                (this.NumberDField.getText() == null
                        && Math.round(Double.parseDouble(this.NumberRField.getText())) == 0)) {
            this.NumberDField.setText(String.valueOf(0.0));
            this.NumberRField.setText(String.valueOf(0.0));

            mSField.setText("Error!");
            mPField.setText("Error!");
            throw new NullPointerException();
        }

        try {
            radiusValidator();
            diameterValidator();
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    private void diameterValidator() {
        double d;

        try {
            d = Double.parseDouble(this.NumberDField.getText());

            if ((d / 2) != this.r) {
                throw new ArithmeticException();
            }

        } catch (NumberFormatException |
                NullPointerException |
                ArithmeticException e) {
            radiusValidator();
            d = 2 * this.r;
        }
        this.d = d;
        this.NumberDField.setText(String.valueOf(this.d));
    }

    private void radiusValidator() {
        double r;

        try {
            r = Double.parseDouble(this.NumberRField.getText());
            if (this.NumberRField.getText() == null
                    || Math.round(Double.parseDouble(this.NumberRField.getText())) == 0) {
                throw new NullPointerException();
            }
        } catch (NumberFormatException |
                NullPointerException |
                ArithmeticException e) {
            diameterValidator();
            r = this.d / 2;
        }
        this.r = r;
        this.NumberRField.setText(String.valueOf(this.r));
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
        int d = Integer.parseInt(String.valueOf(Math.round(this.d)));
        aGraphics.drawOval(200,
                250,
                10*d,
                10*d);
    }


    private void calcSum() {
        try {
            double s = Math.PI * (r * r);
            double p = 2 * Math.PI * r;
            mSField.setText(" S = " + s);
            mPField.setText(" P = " + p);
        } catch (Exception ex) {
            mSField.setText("Error!");
            mPField.setText("Error!");
        }
        repaint();
    }


}

