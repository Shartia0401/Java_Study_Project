package Frame;

import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;


public class Frame extends JFrame{

    public static final int X = 19;
    public static final int Y = 19;

    JPanel b;

    public static JButton[][] btns = new JButton[X][Y];

    public Frame()
    {
        setIcon();
        setLayout(null);
        GamePanel a = new GamePanel();
        a.setLayout(null);
        a.setBounds(0,0, 800,800);
        // Drawimage();


        getContentPane().setBackground(Color.white);

        buttons(); // 버튼
        // a.addMouseMotionListener(new mouseMotion());

        add(a);
        add(b);


        setFrame();

    }

    private void Drawimage()
    {
        BufferedImage img;
        File file = new File("오목.jpg");
        try
        {
            img = ImageIO.read(file);
        }
        catch(IOException e)
        {
            System.out.println("엄");
            img = null;
        }

        JPanel ImagePanel = new JPanel();
        JLabel ImageIcon = new JLabel(new ImageIcon(img));
        ImagePanel.add(ImageIcon);
        ImageIcon.setBounds(0,0, 800,800);
        add(ImagePanel);
        ImagePanel.addMouseMotionListener(new mouseMotion());
        ImagePanel.addMouseListener(new mouseClick());

        ImagePanel.setBounds(0,0,800,820);


    }

    private void buttons()
    {
        b = new JPanel();

        b.setLayout(new GridLayout(19,19));
        for(int i = 0; i < X; i++)
        {
            for(int j = 0; j < Y; j++)
            {
                btns[i][j] = new JButton("");
                btns[i][j].setText(Integer.toString(i) + " " + Integer.toString(j));
                btns[i][j].addActionListener(new Action());
                btns[i][j].setBorderPainted(false);
                btns[i][j].setContentAreaFilled(false);
                btns[i][j].setFocusPainted(false);
                btns[i][j].setOpaque(false);
                btns[i][j].setBackground(new Color(255,0,0,0));
                b.add(btns[i][j]);
            }
        }
        b.setOpaque(false);
        b.setBounds(-20,-25, 847, 847);


        // b.setBounds(-40,-10, 847, 847);
        

        
    } 

    private void setFrame()
    {
        setTitle("오목");
        // setSize(new Dimension(816,835));
        setSize(new Dimension(816,840));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    private void setIcon()
    {
        ImageIcon icon = new ImageIcon("icon.jpg");
        Image image = icon.getImage();

        setIconImage(image);
    }
    
    
}
