package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import action.rgb.Blue_ScaleAct;
import action.rgb.Green_ScaleAct;
import action.rgb.Red_ScaleAct;

public class RGB_Scale_Frame extends JFrame{
    
    private final int Red_max = 255;
    private final int Green_max = 255;
    private final int Blue_max = 255;



    JSlider Red;            //색상
    JSlider Green;     //채도
    JSlider Blue;          //명도

    JLabel Red_label;
    JLabel Green_label;
    JLabel Blue_label;

    JPanel hsvPanel;

    public RGB_Scale_Frame()
    {
        setPanel();
        setlabel();
        setJSlider();
        setFrame();
    }


    private void setlabel()
    {
        Red_label = new JLabel();
        Green_label = new JLabel();
        Blue_label = new JLabel();

        Red_label.setText("Red");
        Green_label.setText("Green");
        Blue_label.setText("Blue");

        Red_label.setBounds(130, 10, 100, 40);
        Green_label.setBounds(110, 160, 100, 40);
        Blue_label.setBounds(125, 320, 100, 40);

        hsvPanel.add(Red_label);
        hsvPanel.add(Green_label);
        hsvPanel.add(Blue_label);

    }

    private void setJSlider()
    {
        Red = new JSlider(-255,Red_max);
        Green = new JSlider(-255,Green_max);
        Blue = new JSlider(-255, Blue_max);

        Red.setPaintTicks(true);
        Red.setPaintLabels(true);
        Red.setMajorTickSpacing(102);
        Red.setMinorTickSpacing(51);

        Green.setPaintTicks(true);
        Green.setPaintLabels(true);
        Green.setMajorTickSpacing(102);
        Green.setMinorTickSpacing(51);

        Blue.setPaintTicks(true);
        Blue.setPaintLabels(true);
        Blue.setMajorTickSpacing(102);
        Blue.setMinorTickSpacing(51);

        Red.setBounds(40, 40, 200, 100);
        Green.setBounds(40,200,200,100);
        Blue.setBounds(40,360,200,100);

        Red.addChangeListener(new Red_ScaleAct());
        Green.addChangeListener(new Green_ScaleAct());
        Blue.addChangeListener(new Blue_ScaleAct());
    
        Red.setBackground(Color.LIGHT_GRAY);
        Green.setBackground(Color.LIGHT_GRAY);
        Blue.setBackground(Color.LIGHT_GRAY);

        hsvPanel.add(Red);
        hsvPanel.add(Green);
        hsvPanel.add(Blue);
    }

    private void setPanel()
    {
        hsvPanel = new JPanel();
        hsvPanel.setBounds(0,0,300,500);
        hsvPanel.setLayout(null);
        hsvPanel.setBackground(Color.LIGHT_GRAY);
        add(hsvPanel);
    }

    private void setFrame()
    {
        setTitle("HSV");
        setBounds(1500,200, 300,500);               
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
}