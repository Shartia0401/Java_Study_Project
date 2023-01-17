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
        System.out.println(e.getX() + " " + e.getY()); //TODO 디버그

        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("마우스 땜"); //TODO 디버그
        endX = e.getX();
        endY = e.getY();

        if(Run.isCrop)
        {
            BufferedImage newCrop = Run.Currentimage.getSubimage(startX, startY, (endX - startX), (endY - startY));

            try {

                // File file = new File("CropImage\\image" + count + ".jpg");
                // ImageIO.write(newCrop, "jpg", file);
                // count++;
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
