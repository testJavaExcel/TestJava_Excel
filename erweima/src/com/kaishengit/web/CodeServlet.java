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
	                String content = "徐新院";  
	                EncoderHandler encoder = new EncoderHandler();  
	                encoder.encoderQRCoder(content, response);  
	                //徐新院第一次測試二維碼的生成和解析
	        }  
	  
	}  


