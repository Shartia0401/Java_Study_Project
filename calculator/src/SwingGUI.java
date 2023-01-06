import javax.swing.*;
import java.awt.*;

public class SwingGUI extends JFrame {

    public static JLabel text;
    public static JLabel TextLabel;
    private JButton Btns[];
    public static int font_size = 50;

    SwingGUI()
    {
        super("계산기");
        setLayout(null);
        Text();
        label();
        Buttons();
        Display();
    }

    void Display()
    {
        setSize(300,450);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void Text()
    {
        text = new JLabel();

        // text.setBounds(0,0,285, 90); // 윈도우 전용
        text.setBounds(0,0, 300, 90);  //mac osx 전용
        text.setFont(new Font("Arial", Font.BOLD, font_size));
        text.setHorizontalAlignment(JTextField.RIGHT);
        add(text);
    }
    
    void label()
    {
        TextLabel = new JLabel();
        TextLabel.setBounds(90,75, 200, 60); //mac osx 
        // TextLabel.setBounds(80,75, 200, 60); //윈도우 전용
        TextLabel.setFont(new Font("Arial", Font.BOLD, 20));
        TextLabel.setHorizontalAlignment(JLabel.RIGHT);
        add(TextLabel);
    }


    
    void Buttons()
    {

        JPanel Panel = new JPanel();
        Panel.setLayout(new GridLayout(5,4));
        // Panel.setBounds(0, 120, 284, 290); //윈도우 전용
        Panel.setBounds(0, 120, 300, 300); // mac os 전용
        

        String ButtonName[] = {
            "%", "÷", "C", "←",
            "7", "8", "9", "×",
            "4", "5", "6", "-",
            "1", "2", "3", "+",
            "x²", "0", ".", "="};

            Btns = new JButton[ButtonName.length];

        for(int i = 0; i < ButtonName.length; i++)
        {
            Btns[i] = new JButton(ButtonName[i]);
            
            Btns[i].setFont(new Font("Arial", Font.BOLD, 15));
            Btns[i].addActionListener(new CalculatorAction());
            
            Panel.add(Btns[i]);
        }
        add(Panel);
    }
}
