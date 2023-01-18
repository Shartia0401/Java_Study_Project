package action;

import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import filesystem.*;
import main.Run;
import opencv.*;


public class CropTool implements MouseListener, MouseMotionListener{

    public static int startX;
    public static int startY;
    public static int endX;
    public static int endY;
    

    boolean isrect = false;
    static int count = 0;
    public static ArrayList<int[]> adlist = new ArrayList<int[]>();


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
            int [] adr = {startX, startY, endX, endY};
            adlist.add(adr);
            System.out.println(adr[0]+" "+adr[1]+" "+adr[2]+" "+adr[3]);

            Run.mainFrame.canvas.setRect();
            Run.mainFrame.canvas.draw();
        }
    }


    public static void save()
    {
        for(int[] ad : adlist)
        {
            BufferedImage newCrop = Run.Currentimage.getSubimage(ad[0], ad[1], (ad[2] - ad[0]), (ad[3] - ad[1]));
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
    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseMoved(MouseEvent e) {} 
}
