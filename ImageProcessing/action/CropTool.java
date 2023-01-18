package action;

import java.awt.event.*;
import java.awt.image.BufferedImage;

import filesystem.*;
import main.Run;
import opencv.*;


public class CropTool implements MouseListener, MouseMotionListener{

    public static int startX;
    public static int startY;
    public static int endX;
    public static int endY;


    boolean isrect = false;
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

        drew();
    }

    public static void drew()
    {
        if(Run.isCrop)
        {
            Run.mainFrame.canvas.setRect();
            Run.mainFrame.canvas.draw();
        }
    }

    public static void Crop()
    {
        if(!Run.isdetect)
        {
            save();
        }
        else
        {
            for(int[] address : OpenCV.list )
            {
                startX = address[0];
                startY = address[1];
                endX = address[0] + address[2];
                endY = address[1] + address[3];
                System.out.println(startX);
                System.out.println(startY);
                System.out.println(endX);
                System.out.println(endY);
                save();
            }

        }
    }

    private static void save()
    {
        BufferedImage newCrop = Run.Currentimage.getSubimage(startX, startY, (endX - startX), (endY - startY));
        try {
            FileSave.Save(newCrop);
        } catch (Exception a) {
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {} 
}
