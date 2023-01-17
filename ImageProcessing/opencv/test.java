package opencv;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
  
public class test {
   public static void main (String[] args) {
      // Loading the OpenCV core library
      System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

      // Reading the Image from the file and storing it in to a Matrix object
      String file ="image\\member_7.jpg";
      Mat src = Imgcodecs.imread(file);

      // Instantiating the CascadeClassifier
      String xmlFile = "opencv\\lbpcascades\\lbpcascade_frontalface.xml";
      CascadeClassifier classifier = new CascadeClassifier(xmlFile);

      // Detecting the face in the snap
      MatOfRect faceDetections = new MatOfRect();
      classifier.detectMultiScale(src, faceDetections);
      System.out.println(String.format("Detected %s faces", 
         faceDetections.toArray().length));

      // Drawing boxes
      for (Rect rect : faceDetections.toArray()) {
         Imgproc.rectangle(
            src,                                               // where to draw the box
            new Point(rect.x, rect.y),                            // bottom left
            new Point(rect.x + rect.width, rect.y + rect.height), // top right
            new Scalar(0, 0, 255),
            3                                                     // RGB colour
         );
      }

      
      for (Rect rect : faceDetections.toArray())
      {
         System.out.println("밑 좌표 : "+rect.x + " " + rect.y);
         System.out.println("위 좌표 : "+rect.x + rect.width + " " +  rect.y + rect.height);
      }


      // Writing the image
      Imgcodecs.imwrite("opencv\\detect\\facedetect_output1.jpg", src);

      System.out.println("Image Processed");
   }

   private void imagedraw()throws IOException
   {
      File file = new File("image\\member_7.jpg");

      BufferedImage img = ImageIO.read(file);
      JFrame frame = new JFrame("시이발자고싶다");
      JLabel imglabel = new JLabel(new ImageIcon(img));
      frame.setSize(1200, 1000);
      frame.add(imglabel);
      


   }
}