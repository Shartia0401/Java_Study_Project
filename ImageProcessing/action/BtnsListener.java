package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import image_processing.*;
import main.Run;
import opencv.OpenCV;
import filesystem.FileSave;
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
                ImagePanel.setImg(Image_Processing.GrayScale());
                break;
            case "HSV":
                Run.mainFrame.setHSV();
                break;
            case "RGB":
                Run.mainFrame.setRGB();
                break;
            case "Edge":
                img = ImagePanel.getImg();
                Run.Currentimage = img;
                ImagePanel.setImg(Image_Processing.Edge_Detect(img));
                break;
            case "Default":
                ImagePanel.setDefault();
                break;
            case "선택도구":
                scope();
                break;
            case "자르기":
                CropTool.save();
                break;
            case "Face_detect":
                if(Run.isdetect)
                {
                    OpenCV.list.clear();
                    Run.isdetect = false;
                    ImagePanel.setImg(Run.Currentimage);
                    Toolbar.btns[6].setEnabled(false);
                    CropTool.adlist.clear();

                    Run.isCrop = false;
                    Toolbar.btns[5].setBackground(Color.LIGHT_GRAY);
                    Toolbar.btns[1].setEnabled(true);
                }
                else
                {
                    FileSave.OpencvImg();
                    OpenCV.Face_Detect();
                    Run.mainFrame.canvas.boxCreate();
                    Run.isdetect = true;
                    for(int[] ad : OpenCV.list)
                    {
                        int xy[] = {ad[0], ad[1], ad[0] + ad[2], ad[1] + ad[3]};
                        CropTool.adlist.add(xy);
                    }

                    Toolbar.btns[5].setBackground(new Color(150,150,150));
                    Run.isCrop = true;
                    Toolbar.btns[6].setEnabled(true);
                    Toolbar.btns[1].setEnabled(false);

                }
                break;
            default :
                break;
        }
    }

    public void scope()
    {
        if(Run.isCrop)
        {
            CropTool.adlist.clear();    
            Run.isCrop = false;
            Toolbar.btns[5].setBackground(Color.LIGHT_GRAY);
            ImagePanel.setImg(Run.Currentimage);
            Toolbar.btns[6].setEnabled(false);
            Toolbar.btns[1].setEnabled(true);
        }
        else
        {
            Toolbar.btns[5].setBackground(new Color(150,150,150));
            Run.isCrop = true;
            Toolbar.btns[6].setEnabled(true);
            Toolbar.btns[1].setEnabled(false);
        }
    }

    public Image getImg(Image image)
    {
        return image;
    }
}