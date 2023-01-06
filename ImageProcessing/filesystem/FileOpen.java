package filesystem;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

public class FileOpen {
    
    JFileChooser FileSelect;
    File file;

    public FileOpen()
    {
        FileSelect = new JFileChooser();
    }

    public void setFrame()
    {
        FileNameExtensionFilter fileter = new FileNameExtensionFilter("JPG&PNG Images", "jpg", "png");
        FileSelect.setFileFilter(fileter);

        FileSelect.setDialogTitle("Image Open");
        FileSelect.setApproveButtonText("Open");
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
