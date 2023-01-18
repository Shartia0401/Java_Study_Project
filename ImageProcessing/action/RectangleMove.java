package action;

import main.Run;
import image_processing.*;
import java.awt.*;
import java.awt.event.*; 

public class RectangleMove implements MouseListener, MouseMotionListener { 


    boolean isDragged; 
    int offX, offY; 
    public RectangleMove()
    {
        isDragged = false; 
    } 


    public void mousePressed(MouseEvent me)
    { 
        System.out.println("X" + me.getX() + "Y" + me.getY());
        if(Run.isCrop && ImagePanel.box.contains(new Point(me.getX(),me.getY())))
        {
            offX = me.getX() - ImagePanel.box.x; offY = me.getY() - ImagePanel.box.y;
            isDragged = true;
        } 
    }
    public void mouseReleased(MouseEvent me)
    {

        isDragged = false; 
    } 

    public void mouseDragged(MouseEvent me)
    {
        if(Run.isCrop && isDragged)
        { 
            ImagePanel.box.x = me.getX() - offX; 
            ImagePanel.box.y = me.getY() - offY; 
        }
        Run.mainFrame.canvas.redraw();
    } 

    public void mouseMoved(MouseEvent me){} 
    public void mouseClicked(MouseEvent me){} 
    public void mouseEntered(MouseEvent me){} 
    public void mouseExited(MouseEvent me){} 

}