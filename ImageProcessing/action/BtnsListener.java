package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import image_processing.*;
import main.Run;

import java.awt.Image;
import java.awt.image.BufferedImage;

public class BtnsListener implements ActionListener
{
    BufferedImage img;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String btns_name = e.getActionCommand();
        
        switch(btns_name)
        {
            case "Gray":
                img = ImagePanel.getImg();
                ImagePanel.setImg(Image_Processing.GrayScale(img));
                break;
            case "HSV":
                Run.mainFrame.setHSV();
                break;
            case "RGB조정":

                break;
            case "Edge":
                img = ImagePanel.getImg();
                ImagePanel.setImg(Image_Processing.Edge_Detect(img));
                break;
            case "Default":
                ImagePanel.setDefault();
                break;
            case "Crop":
                
                break;
            default :
                System.out.println("디폴트");
                break;
        }
    }

    public Image getImg(Image image)
    {
        return image;
    }
}