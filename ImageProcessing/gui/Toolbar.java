package gui;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JButton;
import action.*;
import java.awt.FlowLayout;

public class Toolbar extends JPanel{

    JButton[] btns;

    String[] btns_name = {"Gray", "Edge", "HSV", "RGB", "Default"};

    public Toolbar()
    {
        setBounds(0,0,1600,40);
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout(FlowLayout.LEFT));      
        setBtns();
    }

    private void setBtns()
    {

        btns = new JButton[btns_name.length];

        for(int i = 0; i < btns_name.length; i++)
        {
            btns[i] = new JButton();
            btns[i].setText(btns_name[i]);
            btns[i].addActionListener(new BtnsListener());
            add(btns[i]);
        }

    }   


}
