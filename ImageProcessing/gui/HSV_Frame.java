package gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

import action.hsv.Hue_SliderAction;
import action.hsv.Saturation_SliderAction;
import action.hsv.Value_SliderAction;

public class HSV_Frame extends JFrame{
    
    private final int hue_max = 359;
    private final int sa_max = 100;
    private final int value_max = 100;



    JSlider hue;            //색상
    JSlider saturation;     //채도
    JSlider value;          //명도

    JLabel hue_label;
    JLabel saturation_label;
    JLabel value_label;

    JPanel hsvPanel;

    public HSV_Frame()
    {
        setPanel();
        setlabel();
        setJSlider();
        setFrame();
    }


    private void setlabel()
    {
        hue_label = new JLabel();
        saturation_label = new JLabel();
        value_label = new JLabel();

        hue_label.setText("Hue");
        saturation_label.setText("Saturation");
        value_label.setText("Value");

        hue_label.setBounds(130, 10, 100, 40);
        saturation_label.setBounds(110, 160, 100, 40);
        value_label.setBounds(125, 320, 100, 40);

        hsvPanel.add(hue_label);
        hsvPanel.add(saturation_label);
        hsvPanel.add(value_label);

    }

    private void setJSlider()
    {
        hue = new JSlider(0,hue_max);
        saturation = new JSlider(0,sa_max);
        value = new JSlider(0, value_max);

        hue.setPaintTicks(true);
        hue.setPaintLabels(true);
        hue.setMajorTickSpacing(60);
        hue.setMinorTickSpacing(20);

        saturation.setPaintTicks(true);
        saturation.setPaintLabels(true);
        saturation.setMajorTickSpacing(20);
        saturation.setMinorTickSpacing(5);

        value.setPaintTicks(true);
        value.setPaintLabels(true);
        value.setMajorTickSpacing(20);
        value.setMinorTickSpacing(5);

        hue.setBounds(40, 40, 200, 100);
        saturation.setBounds(40,200,200,100);
        value.setBounds(40,360,200,100);

        hue.addChangeListener(new Hue_SliderAction());
        saturation.addChangeListener(new Saturation_SliderAction());
        value.addChangeListener(new Value_SliderAction());
    
        hue.setBackground(Color.LIGHT_GRAY);
        saturation.setBackground(Color.LIGHT_GRAY);
        value.setBackground(Color.LIGHT_GRAY);

        hsvPanel.add(hue);
        hsvPanel.add(saturation);
        hsvPanel.add(value);
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
