package image_processing;

import action.CropTool;
import filesystem.FileOpen;
import main.Run;
import gui.Toolbar;
import opencv.OpenCV;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import javax.swing.*;


public class ImagePanel extends JPanel{
    
    public static BufferedImage file;
    public static Image img;
    public static JLabel image;
    public static BufferedImage HSV_img;

    public static float[][][] Image_array;
    public static int width;
    public static int height; 
    public static Rectangle box;

    Graphics g;

    public ImagePanel()
    {
        super();
        setBackground(Color.GRAY);
    }
    public void setImageFile(File imgFile)
    {
        try {
            file = ImageIO.read(imgFile);
            FileOpen.setClear();
        } catch (IOException e) {
            file = null;
        }

        Toolbar.btns[0].setEnabled(true);
        Toolbar.btns[1].setEnabled(true);
        Toolbar.btns[2].setEnabled(true);
        Toolbar.btns[3].setEnabled(true);
        Toolbar.btns[4].setEnabled(true);
        Toolbar.btns[5].setEnabled(true);
        Toolbar.btns[6].setEnabled(false);
        Toolbar.btns[7].setEnabled(true);

        if(file.getWidth() > 1100 || file.getHeight() > 900)
        {
            try {
                file = resize();  // 이미지 리사이즈 실행
            } catch (IOException e) {
                e.printStackTrace();
                e.getMessage();
            }
        }
        
        img = file;
        
        Run.Currentimage = file;


        image = new JLabel(new ImageIcon(img));
        image.addMouseListener(new CropTool());
        // image.addMouseListener(new RectangleMove());
        // image.addMouseMotionListener(new RectangleMove());
        add(image);
        image.setBounds(
            800 - img.getWidth(image)/2, 450- img.getHeight(image)/2 - 50 , img.getWidth(image), img.getHeight(image));
    }
	
    public static BufferedImage resize() throws IOException 
    {

        BufferedImage outputImage = new BufferedImage(1024, 768, file.getType());
        // 입력받은 리사이즈 길이와 높이 

        Graphics2D graphics2D = outputImage.createGraphics(); 
        graphics2D.drawImage(file, 0, 0, 1024, 768, null);
        graphics2D.dispose();

        return outputImage;
    }

    public static void setImg(Image icon)
    {   
        img = icon;
        image.setIcon(new ImageIcon(icon));
    }

    public static BufferedImage getImg()
    {
        return file;
    }

    public static void setDefault()
    {
        Run.Currentimage = file;
        image.setIcon(new ImageIcon(file));
        CropTool.adlist.clear();
        OpenCV.list.clear();

        Run.isCrop = false;
        Toolbar.btns[5].setBackground(Color.LIGHT_GRAY);
        Toolbar.btns[6].setEnabled(false);
        Toolbar.btns[1].setEnabled(true);


    }

    public void draw()
    {
        g = image.getGraphics();
        g.setColor(Color.red);
        g.drawRect(box.x,box.y,box.width,box.height); 

    }

    public void redraw()
    {
        repaint();
    }   

    public void setRect()
    {
        box = new Rectangle(CropTool.startX, CropTool.startY, CropTool.endX - CropTool.startX, CropTool.endY - CropTool.startY); 
    }
    
    public void setRect(int[] address)
    {
        CropTool.startX = address[0];
        CropTool.startY = address[1] + address[3];
        CropTool.endX = address[0] + address[2];
        CropTool.endY = address[1];

        box = new Rectangle(CropTool.startX, CropTool.startY, CropTool.endX - CropTool.startX, CropTool.endY - CropTool.startY); 
    }

    public void boxCreate()
    {   
        for(int[] address : OpenCV.list )
        {
            setRect(address);

            g = image.getGraphics();
            g.setColor(Color.red);
            g.drawRect(address[0],address[1],address[2],address[3]); 

        }
    } 
}




