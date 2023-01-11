package image_processing;

import javax.imageio.ImageIO;
import javax.swing.*;

import action.CropTool;
import filesystem.FileOpen;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImagePanel extends JPanel{
    

    public static BufferedImage file;
    public static Image img;
    public static JLabel image;
    public static BufferedImage HSV_img;

    public static float[][][] Image_array;

    public static int width;
    public static int height; 

    public ImagePanel()
    {
        super();
        setBackground(Color.GRAY);
    }

    public void setImageFile(File imgFile)
    {
        try {
            file = ImageIO.read(imgFile);
            FileOpen.setClear();
        } catch (IOException e) {
            file = null;
        }
        img = file;

        

        image = new JLabel(new ImageIcon(img));
        image.addMouseListener(new CropTool());

        add(image);
        image.setBounds(
            800 - img.getWidth(image)/2, 450- img.getHeight(image)/2 - 50 , img.getWidth(image), img.getHeight(image));
    }

    public static void setImg(Image icon)
    {   
        img = icon;
        image.setIcon(new ImageIcon(icon));
    }

    public static BufferedImage getImg()
    {
        return file;
    }

    public static void setDefault()
    {
        image.setIcon(new ImageIcon(file));
    }

    

}
