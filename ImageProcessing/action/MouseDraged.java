package action;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class MouseDraged implements MouseMotionListener{

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("드래그 "+e.getX() + " " + e.getY());

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
