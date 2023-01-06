package gui;

import javax.swing.*;

public class Frame extends JFrame{
    
    public Frame()
    {

    }

    public void setFrame()
    {
        setTitle("포토샵 데모");
        setSize(1200, 720);
        setLocationRelativeTo(null);                   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
