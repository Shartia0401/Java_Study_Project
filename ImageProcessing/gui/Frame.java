package gui;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame{
    
    public Frame()
    {

    }

    public void setFrame()
    {
        setTitle("포토샵 데모");
        setSize(1600, 900);
        setLocationRelativeTo(null);                   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setVisible(true);
    }

}
