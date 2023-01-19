package gui;

import javax.swing.*;

import action.CropTool;

import java.awt.*;
import filesystem.*;
import image_processing.*;
import main.Run;
import opencv.OpenCV;


public class Frame extends JFrame{
    
    Menubar menubar;
    Toolbar toolbar;
    public ImagePanel canvas;
    FileOpen openfile;
    HSV_Frame hsvFrame;
    RGB_Scale_Frame rgbFrame;

    static boolean ishsv = false;
    static boolean isrgb = false;

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
        
        try {
            canvas.setImageFile(openfile.getFile());
        } catch (IllegalArgumentException e) {
            Toolbar.btns[0].setEnabled(false);
            Toolbar.btns[1].setEnabled(false);
            Toolbar.btns[2].setEnabled(false);
            Toolbar.btns[3].setEnabled(false);
            Toolbar.btns[4].setEnabled(false);
            Toolbar.btns[5].setEnabled(false);
            Toolbar.btns[6].setEnabled(false);
            Toolbar.btns[7].setEnabled(false);
        }
        
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

    public void setHSV()
    {
        if(ishsv)
        {
            hsvFrame.dispose();
        }

        hsvFrame = new HSV_Frame();
        if(isrgb)
        {
            rgbFrame.dispose();
            isrgb = false;
        }


        ishsv = true;

    }

    public void setRGB()
    {
        if(isrgb)
        {
            rgbFrame.dispose();
        }
        
        rgbFrame = new RGB_Scale_Frame();
        if(ishsv)
        {
            hsvFrame.dispose();
            ishsv = false;
        }

        isrgb = true;
    }

    public void setnull()
    {
        Run.Currentimage = null;
        OpenCV.list.clear();
        CropTool.adlist.clear();    
        Run.isCrop = false;
        Toolbar.btns[5].setBackground(Color.LIGHT_GRAY);
        Toolbar.btns[6].setEnabled(false);
        Toolbar.btns[1].setEnabled(true);

        Toolbar.btns[0].setEnabled(false);
        Toolbar.btns[1].setEnabled(false);
        Toolbar.btns[2].setEnabled(false);
        Toolbar.btns[3].setEnabled(false);
        Toolbar.btns[4].setEnabled(false);
        Toolbar.btns[5].setEnabled(false);
        Toolbar.btns[6].setEnabled(false);
        Toolbar.btns[7].setEnabled(false);

        canvas.removeAll();
        remove(canvas);
        repaint();
    }
    
    public void setImage()
    {   

        openfile.show();

        if(Run.Currentimage != null)
        {
            setnull();
        }

        canvas.setImageFile(openfile.getFile());
        add(canvas);

        repaint();
    }

}
