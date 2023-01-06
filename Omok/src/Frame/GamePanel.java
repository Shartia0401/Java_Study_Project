package Frame;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel
{
    private Image img;

    public GamePanel()
    {
        this.img = new ImageIcon("오목.jpg").getImage(); 
    }

    public void paintComponent(Graphics g)
    {
        g.drawImage(img, 0, 0, null);
    }
}