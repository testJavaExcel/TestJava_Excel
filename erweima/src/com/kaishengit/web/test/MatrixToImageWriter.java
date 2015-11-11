package com.kaishengit.web.test;
 import javax.imageio.ImageIO;

import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

 import java.io.File;
 import java.io.OutputStream;
 import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.awt.image.BufferedImage;
 
 
 public final class MatrixToImageWriter {
 
   private static final int BLACK = 0xFF000000;
   private static final int WHITE = 0xFFFFFFFF;
 
   private MatrixToImageWriter() {}
 
   
   public static BufferedImage toBufferedImage(BitMatrix matrix) {
     int width = matrix.getWidth();
     int height = matrix.getHeight();
     BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
     for (int x = 0; x < width; x++) {
       for (int y = 0; y < height; y++) {
         image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
       }
     }
     return image;
   }
 
   
   public static void writeToFile(BitMatrix matrix, String format, File file)
       throws IOException {
     BufferedImage image = toBufferedImage(matrix);
     if (!ImageIO.write(image, format, file)) {
       throw new IOException("Could not write an image of format " + format + " to " + file);
     }
   }
 
   
   public static void writeToStream(BitMatrix matrix, String format, OutputStream stream)
       throws IOException {
     BufferedImage image = toBufferedImage(matrix);
     if (!ImageIO.write(image, format, stream)) {
       throw new IOException("Could not write an image of format " + format);
     }
   }
 
   
   
   
   public static void main(String[] args) {
	
	   try {
		   
MultiFormatReader formatReader = new MultiFormatReader();
String filePath = "D:/ÎÒµÄTool/Loves.jpg";
File file = new File(filePath);
BufferedImage image = ImageIO.read(file);;
LuminanceSource source = new BufferedImageLuminanceSource(image);
Binarizer  binarizer = new HybridBinarizer(source);
BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
Map hints = new HashMap();
hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
Result result = formatReader.decode(binaryBitmap,hints);

System.out.println("result = "+ result.toString());
System.out.println("resultFormat = "+ result.getBarcodeFormat());
System.out.println("resultText = "+ result.getText());
 

} catch (Exception e) {
e.printStackTrace();
}
	   
	   
}
   
   
  
 }