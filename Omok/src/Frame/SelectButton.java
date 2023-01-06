package Frame;

import java.awt.event.*;
import java.awt.*;
import javax.swing.JButton;

public class SelectButton implements ActionListener{
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton)e.getSource();
        if(button.getText().equals("재시작"))
        {
            setbutton();
            Action.select.dispose();
        }
        else{
            System.exit(0);
        }
    }

    void setbutton()
    {
        for(int i = 0; i < Frame.X; i++)
        {
            for(int j = 0; j < Frame.Y; j++)
            {
                Frame.btns[i][j].setText(Integer.toString(i) + " " + Integer.toString(j));
                Frame.btns[i][j].setBorderPainted(false);
                Frame.btns[i][j].setContentAreaFilled(false);
                Frame.btns[i][j].setFocusPainted(false);
                Frame.btns[i][j].setOpaque(false);
                Frame.btns[i][j].setEnabled(true);
                Frame.btns[i][j].setBackground(new Color(255,0,0,0));
            }
        }
    }
}