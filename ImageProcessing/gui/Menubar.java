package gui;

import javax.swing.*;
import action.MenubarAct;

public class Menubar extends JMenuBar{
    public Menubar()
    {
        super();
        menuOption();

    }

    public void menuOption()
    {
        JMenuItem[] mi;
        String[] Item_name = {"Open", "Close", "Save"};

        mi = new JMenuItem[Item_name.length];

        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");

        for(int i = 0; i < Item_name.length; i++)
        {
            mi[i] = new JMenuItem(Item_name[i]);
            mi[i].addActionListener(new MenubarAct());
            fileMenu.add(mi[i]);
        }

        add(fileMenu);
        add(editMenu);


    }

}
