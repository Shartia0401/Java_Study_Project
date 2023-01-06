package image_processing;

import javax.swing.*;
import java.awt.*;


public class ImagePanel extends JPanel{
    
    Image img;

    public void paint(Graphics g)
    {
        g.drawImage(img,0,0,null);
    }


}
