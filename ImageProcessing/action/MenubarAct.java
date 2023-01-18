package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import filesystem.FileSave;

import main.Run;

public class MenubarAct implements ActionListener{


    @Override
    public void actionPerformed(ActionEvent e) {
        String menu = e.getActionCommand();
        System.out.println(menu);
        switch(menu)
        {
            case "Open":
                Run.mainFrame.setImage();
                break;
            case "Close":
                Run.mainFrame.setnull();
                break;
            case "Save":
                FileSave.Save(Run.Currentimage);
                break;
        }
    }   
}
