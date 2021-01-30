/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ocrusingtess;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author nasat
 */
public class resizeImage {
    public static BufferedImage resizeImage(String inputImagePath,
    String outputImagePath)
    throws IOException {
        // reads input image
        File inputFile = new File(inputImagePath);
        BufferedImage inputImage = ImageIO.read(inputFile);
 
        // creates output image
        BufferedImage outputImage = new BufferedImage(960,1280,inputImage.getType());
  Graphics2D graphics = outputImage.createGraphics();
  graphics.drawImage(inputImage, 0,0, 960, 1280, null);
  
  //System.out.println(graphics);
  graphics.dispose();
  // write changes on the image
  ImageIO.write(outputImage, "png" , new File(outputImagePath));
return outputImage;  
}
}
