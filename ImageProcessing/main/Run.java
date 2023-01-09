package main;

import filesystem.FileOpen;
import gui.*;
import image_processing.ImagePanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.*;


public class Run
{
    Frame mainFrame; 
    Toolbar toolbar;
    ImagePanel canvas;
    FileOpen openfile;


    public Run()
    {
        mainFrame = new Frame();
        openfile = new FileOpen();
        canvas = new ImagePanel();
        toolbar = new Toolbar();
        
        mainFrame.getContentPane().setBackground(Color.GRAY);
        mainFrame.add(canvas);
        mainFrame.add(toolbar);
        mainFrame.setFrame();
        openfile.show();
        
        canvas.setImageFile(openfile.getFile());
        canvas.setBounds(0,40,1600,840);


    }
}