package Frame;

import java.awt.event.*;


public class mouseClick implements MouseListener{

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("ASd");

        double result = 0;

        double x = e.getX();
        double y = e.getY();

        if(x < 31)
        {
            x = 10;
        }
        else
        {
            result = x/44;
            result = Math.round(result);
            x = 44 * (int)result + 10;
        }

        if(y < 31)
        {
            y = 10;
        }
        else{
            result = (y - 10)/43;
            System.out.println(result);
            result = Math.round(result);
            System.out.println(result);
            y = 44 * (int)result + 10;
        }
        System.out.println(e.getX() + "x, y좌표" + e.getY());
        System.out.println("좌표 " + x +" " + y);

    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
