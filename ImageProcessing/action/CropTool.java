package action;

import java.awt.event.*;
import java.awt.image.BufferedImage;

import main.Run;
import filesystem.FileSave;

public class CropTool implements MouseListener{

    public static int startX;
    public static int startY;
    public static int endX;
    public static int endY;

    int count = 0;

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {


        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

        endX = e.getX();
        endY = e.getY();

        if(Run.isCrop)
        {
            BufferedImage newCrop = Run.Currentimage.getSubimage(startX, startY, (endX - startX), (endY - startY));

            try {
                FileSave.Save(newCrop);
            } catch (Exception a) {
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}


    
}
