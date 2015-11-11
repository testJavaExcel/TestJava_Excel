package com.kaishengit.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CodeServlet extends HttpServlet {

private static final long serialVersionUID = 1L;  
	          
	        @Override  
	        protected void service(HttpServletRequest requset, HttpServletResponse response)  
	                        throws ServletException, IOException {  
	                String content = "ÐìÐÂÔº";  
	                EncoderHandler encoder = new EncoderHandler();  
	                encoder.encoderQRCoder(content, response);  
	                
	        }  
	  
	}  


