package opencv;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;

import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;

import java.util.ArrayList;

  
public class OpenCV {

   public static ArrayList<int[]> list = new ArrayList<int[]>(); 

   public static void Face_Detect () {
      // Loading the OpenCV core library
      System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

      // Reading the Image from the file and storing it in to a Matrix object
      String file ="opencv\\imageSaved\\image.jpg";
      Mat src = Imgcodecs.imread(file);

      // Instantiating the CascadeClassifier
      String xmlFile = "opencv\\lbpcascades\\lbpcascade_frontalface.xml";
      CascadeClassifier classifier = new CascadeClassifier(xmlFile);

      // Detecting the face in the snap
      MatOfRect faceDetections = new MatOfRect();
      classifier.detectMultiScale(src, faceDetections);
      System.out.println(String.format("Detected %s faces", 
      faceDetections.toArray().length));
      int count = 0;
      for (Rect rect : faceDetections.toArray())
      {
         int[] address = {rect.x, rect.y, rect.width, rect.height};
         list.add(count, address);
         count++;
      }
   }
}