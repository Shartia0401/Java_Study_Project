import java.awt.*;
import javax.swing.*;

public class SwingGUI extends JFrame
{
    String btn[] = 
    {
        "브러쉬",
        "지우개",
        "모두 지우기",
        "Undo",
        "Redo"
    };
    String Figure[] =
    {
        "사각형",
        "삼각형",
        "원",
        "직선"
    };

    JPanel ButtonPanel, FiguresPanel, DrawPanel, PalettePanel;
    JButton[] btns;
    JButton[] Figures;

    SwingGUI()
    {
        super("그림판");
        setSize(1280, 720);
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\Deepvisions\\Desktop\\MicroSoft-Paint.png");
        Image image = imageIcon.getImage();
        setIconImage(image);

        ButtonButtonPanel();
        FiguresPanel();
        PalettePanel();
        DrawPanel();

        JPanel testPanel = new JPanel();

        add(testPanel);
        
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void ButtonButtonPanel()
    {
        ButtonPanel = new JPanel();
        ButtonPanel.setLayout(new GridLayout(2,3, 10, 10));
        btns = new JButton[btn.length];
        
        for(int i = 0; i < btn.length; i++)
        {
            btns[i] = new JButton(btn[i]);
            btns[i].setFont(new Font("함초롱바탕", Font.BOLD, 20));
            btns[i].setBackground(Color.WHITE);
            ButtonPanel.add(btns[i]);
        }
        ButtonPanel.setBackground(Color.lightGray);
        ButtonPanel.setLocation(0,0);
        ButtonPanel.setBounds(0, 0, 400, 130);

        add(ButtonPanel);
    }

    private void FiguresPanel()
    {
        FiguresPanel = new JPanel();
        FiguresPanel.setLayout(new GridLayout(2,2, 10, 10));
        Figures = new JButton[Figure.length];
        
        for(int i = 0; i < Figure.length; i++)
        {
            Figures[i] = new JButton(Figure[i]);
            Figures[i].setFont(new Font("함초롱바탕", Font.BOLD, 20));
            Figures[i].setBackground(Color.WHITE);
            FiguresPanel.add(Figures[i]);
        }
        FiguresPanel.setBackground(Color.lightGray);
        FiguresPanel.setLocation(0,0);
        FiguresPanel.setBounds(410, 20, 400, 130);

        add(FiguresPanel);
    }

    private void PalettePanel()
    {

    }

    private void DrawPanel()
    {

    }
}

