package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import image_processing.*;
import main.Run;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

import gui.Toolbar;

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
                Run.Currentimage = img;
                ImagePanel.setImg(Image_Processing.GrayScale(img));
                break;
            case "HSV":
                Run.mainFrame.setHSV();
                break;
            case "RGB조정":

                break;
            case "Edge":
                img = ImagePanel.getImg();
                Run.Currentimage = img;
                ImagePanel.setImg(Image_Processing.Edge_Detect(img));
                break;
            case "Default":
                ImagePanel.setDefault();
                break;
            case "Crop":
                if(Run.isCrop)
                {
                    Run.isCrop = false;
                    Toolbar.btns[5].setBackground(Color.LIGHT_GRAY);
                }
                else
                {
                    Toolbar.btns[5].setBackground(Color.DARK_GRAY);
                    Run.isCrop = true;
                }
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