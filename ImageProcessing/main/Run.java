package main;

import filesystem.FileOpen;
import gui.Frame;
import image_processing.ImagePanel;
import javax.swing.*;


public class Run
{
    JFrame mainFrame;
    JPanel canvas;
    FileOpen openfile;

    public Run()
    {
        mainFrame = new Frame();
        openfile = new FileOpen();
        canvas = new ImagePanel();

        



    }





}