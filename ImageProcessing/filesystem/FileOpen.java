package filesystem;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import main.Run;

import java.io.File;

public class FileOpen {
    
    JFileChooser FileSelect;
    File file;

    public FileOpen()
    {
        FileSelect = new JFileChooser();
        setFrame();
    }

    private void setFrame()
    {
        FileNameExtensionFilter fileter = new FileNameExtensionFilter("JPG&PNG Images", "jpg", "png");
        FileSelect.setFileFilter(fileter);

        FileSelect.setDialogTitle("Image Open");
        FileSelect.setApproveButtonText("Open");
    }

    static public void setClear()
    {
        for(int i = 0; i < Run.hsv.length; i++)
        {
            Run.hsv[i] = 0;
        }
    }

    public void show()
    {
        FileSelect.showOpenDialog(FileSelect);
        file = FileSelect.getSelectedFile();
    }
    
    public File getFile()
    {
        return file;
    }
}
