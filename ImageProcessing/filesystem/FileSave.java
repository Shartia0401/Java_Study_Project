package filesystem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import main.Run;

public class FileSave {

    private static int count;
    public static void Save(BufferedImage bf)
    {
        boolean isFile = true;

        count = 0;
        while(isFile)
        {
            try {

                File imageFile = new File("CropImage\\image" + count + ".jpg");
                ImageIO.read(imageFile);
                count++;

            } catch (IOException e) {

                isFile = false;
            }   
        }

        try {
            File file = new File("CropImage\\image" + count + ".jpg");
            ImageIO.write(bf, "jpg", file);

        } catch (Exception e) {

        }
    }

    public static void OpencvImg()
    {
        try {
            File file = new File("opencv\\imageSaved\\image.jpg");
            ImageIO.write(Run.Currentimage, "jpg", file);

        } catch (Exception e) {

        }
    }
    
}
