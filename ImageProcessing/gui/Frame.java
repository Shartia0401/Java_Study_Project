package gui;

import javax.swing.*;
import java.awt.*;
import filesystem.*;
import image_processing.*;


public class Frame extends JFrame{
    
    Menubar menubar;
    Toolbar toolbar;
    ImagePanel canvas;
    FileOpen openfile;

    public Frame()
    {
        openfile = new FileOpen();
        canvas = new ImagePanel();
        toolbar = new Toolbar();
        menubar = new Menubar();

        
        getContentPane().setBackground(Color.GRAY);
        add(canvas);
        add(toolbar);
        add(menubar);

        setJMenuBar(menubar);
        setFrame();
        openfile.show();
        
        canvas.setImageFile(openfile.getFile());
        
        canvas.setBounds(0,40,1600,960);
    }

    public void setFrame()
    {
        setTitle("Adobe Phtoshap 2023");
        setSize(1600, 1000);
        setLocationRelativeTo(null);                   
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        setIcon();
        setVisible(true);
    }
    
    public void setIcon()
    {
        ImageIcon icon = new ImageIcon("image\\icon.png");
        Image image = icon.getImage();
        
        setIconImage(image);
    }

}
