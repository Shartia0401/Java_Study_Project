package gui;

import javax.swing.JMenuBar;

import javax.swing.*;

public class Menubar extends JMenuBar{  //TODO 메뉴바 나중에해야함
    public Menubar()
    {
        super();
        menuOption();

    }

    public void menuOption()
    {
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        
        add(fileMenu);
        add(editMenu);
    }

}
