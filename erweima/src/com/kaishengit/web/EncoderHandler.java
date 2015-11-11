package com.kaishengit.web;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import com.swetake.util.Qrcode;

public class EncoderHandler {

	
	 public void encoderQRCoder(String content, HttpServletResponse response) {  
         try {  
                 Qrcode handler = new Qrcode();  
                 handler.setQrcodeErrorCorrect('M');  
                 handler.setQrcodeEncodeMode('B');  
                 handler.setQrcodeVersion(7);  
                   
                 System.out.println(content);  
                 byte[] contentBytes = content.getBytes("UTF-8");  
                   
                 BufferedImage bufImg = new BufferedImage(80, 80, BufferedImage.TYPE_INT_RGB);  
                   
                 Graphics2D gs = bufImg.createGraphics();  
                   
                 gs.setBackground(Color.WHITE);  
                 gs.clearRect(0, 0, 140, 140);  
                   
                 //�趨ͼ����ɫ��BLACK  
                 gs.setColor(Color.BLACK);  
                   
                 //����ƫ����  �����ÿ��ܵ��½�������  
                 int pixoff = 2;  
                 //������ݣ���ά��  
                 if(contentBytes.length > 0 && contentBytes.length < 124) {  
                         boolean[][] codeOut = handler.calQrcode(contentBytes);  
                         for(int i = 0; i < codeOut.length; i++) {  
                                 for(int j = 0; j < codeOut.length; j++) {  
                                         if(codeOut[j][i]) {  
                                                 gs.fillRect(j * 3 + pixoff, i * 3 + pixoff,3, 3);  
                                         }  
                                 }  
                         }  
                 } else {  
                         System.err.println("QRCode content bytes length = " + contentBytes.length + " not in [ 0,120 ]. ");  
                 }  
                   
                 gs.dispose();  
                 bufImg.flush();  
                   
                   
                   
                 //���ɶ�ά��QRCodeͼƬ  
                 ImageIO.write(bufImg, "jpg", response.getOutputStream());  
                   
                   
         } catch (Exception e) {  
                 e.printStackTrace();  
         }  
 }  
}
