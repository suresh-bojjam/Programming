package com.test;

import java.io.StringReader;

import javax.xml.transform.stream.StreamSource;

public class StringReaderExample {
	 public static void main(String[] args) throws Exception {  
	        String srg = "Hello Java!!";  
	        StringReader reader = new StringReader(srg);  
	        StreamSource source = new StreamSource(reader);
	        
	        int k=0;
	            while((k=reader.read())!=-1){  
	                System.out.print((char)k);  
	            }  
	        } 
}
