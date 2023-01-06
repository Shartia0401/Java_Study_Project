package Frame;

import java.awt.event.*;


public class mouseMotion extends MouseAdapter{
    public void mouseMoved(MouseEvent e)
    {
        System.out.println(e.getX() +" "+ e.getY());
    }

    public void mousePressed(MouseEvent e)
    {
        System.out.print("asd");
    }
}
