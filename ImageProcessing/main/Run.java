package main;

import gui.*;
import java.awt.image.BufferedImage;

public class Run
{
    public static Frame mainFrame; 
    public static int[] hsv = new int[3];
    public static boolean isCrop = false;
    public static BufferedImage Currentimage;
    

    public Run()
    {   
        hsv[0] = 0;
        hsv[1] = 0;
        hsv[2] = 0;
        mainFrame = new Frame();
    }


}