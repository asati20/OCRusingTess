/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocrusingtess;
 import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import net.sourceforge.tess4j.*;


import javax.imageio.ImageIO;
import static ocrusingtess.date.date;
import static ocrusingtess.patientName.patientName;
import static ocrusingtess.resizeImage.resizeImage;

/**
 *
 * @author nasat
 */
public class OCRusingTess {
   public static void main(String args[]) throws Exception {
      // Loading the OpenCV core library
      System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
      
      // resizing image to 960*1280
      resizeImage("C:\\Users\\nasat\\Desktop\\passport.jpeg","C:\\Users\\nasat\\Desktop\\OCR\\Images\\Sample_report#1(2).png");
     
      // Reading the Image from the file and storing it in to a Matrix object
      String file ="C:\\Users\\nasat\\Desktop\\OCR\\Images\\Sample_report#1(2).png";
       
      // Reading the image
      Mat src = Imgcodecs.imread(file,0);
      //Mat srct = cv.fastNlMeansDenoising(); 

      // Creating an empty matrix to store the result
      Mat dst = new Mat();

      Imgproc.adaptiveThreshold(src, dst, 500, Imgproc.ADAPTIVE_THRESH_MEAN_C,
         Imgproc.THRESH_BINARY, 127, 30);

      // Writing the image
      Imgcodecs.imwrite("C:\\Users\\nasat\\Desktop\\OCR\\Images\\Sample_lab#3AdaptiveThresh.png", dst);
      
      // do ocr 
      File imageFile= new File("C:\\Users\\nasat\\Desktop\\OCR\\Images\\Sample_lab#3AdaptiveThresh.png");
      ITesseract instance= new Tesseract();
      instance.setTessVariable("user_defined_dpi", "300");
      String ocrString=instance.doOCR(imageFile);
      

      //System.out.println("Image Processed");
     System.out.println(ocrString);
    System.out.println(patientName(ocrString));
    System.out.println(date(ocrString));
   } 
}
    
