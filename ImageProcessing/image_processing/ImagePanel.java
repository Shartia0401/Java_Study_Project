package image_processing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ImagePanel extends JPanel{
    

    BufferedImage file;
    public Image img;
    JLabel image;

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




    // public void paint(Graphics g)
    // {
    //     System.out.println("1234");
    //     g.drawImage(img,(640 - (img.getWidth(null))/2),(335 - img.getHeight(null)/2),null);
    // }


}
