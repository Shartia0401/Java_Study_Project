package image_processing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImagePanel extends JPanel{
    

    public static BufferedImage file;
    public static Image img;
    public static JLabel image;
    public static BufferedImage HSV_img;

    public ImagePanel()
    {
        super();
        setBackground(Color.GRAY);
    }

    public void setImageFile(File imgFile)
    {
        try {
            file = ImageIO.read(imgFile);
        } catch (IOException e) {
            file = null;
        }
        img = file;

        image = new JLabel(new ImageIcon(img));
        add(image);
        image.setBounds(800 - img.getWidth(image)/2, 450- img.getHeight(image)/2 - 50 , img.getWidth(image), img.getHeight(image));
    }

    public static void setImg(Image icon)
    {
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

    
    public static void RGB_to_HSV()
    {
        int width = img.getWidth(image);
        int height = img.getHeight(image);

        for(int i  = 0; i < width; i++)
        {
            for(int j = 0; j < height; j++)
            {
                Color c = new Color(file.getRGB(j, i));
                double[] a = RGB_to_HSV.RGBtoHSV(c.getRed(), c.getGreen(), c.getBlue());
                Color newColor = new Color((int)a[0], (int)a[1], (int)a[2]);
                HSV_img.setRGB(j, i, newColor.getRGB());
            }
        }
    
    }

    // public void paint(Graphics g)
    // {
    //     System.out.println("1234");
    //     g.drawImage(img,(640 - (img.getWidth(null))/2),(335 - img.getHeight(null)/2),null);
    // }
}
