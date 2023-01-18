package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import action.*;
import java.awt.FlowLayout;

public class Toolbar extends JPanel{

    public static JButton[] btns;

    String[] btns_name = {"Gray", "Edge", "HSV", "RGB", "Default","선택도구", "자르기", "Face_detect"};

    public Toolbar()
    {
        setBounds(0,0,1600,26);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout(FlowLayout.LEFT,0,0));      
        setBtns();
    } 

    private void setBtns()
    {

        btns = new JButton[btns_name.length];

        for(int i = 0; i < btns_name.length; i++)
        {
            btns[i] = new JButton();
            btns[i].setText(btns_name[i]);
            btns[i].setBackground(Color.LIGHT_GRAY);
            btns[i].addActionListener(new BtnsListener());
            add(btns[i]);
        }
        btns[6].setEnabled(false);

    }   


}
