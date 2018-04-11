package itsm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;


public class readidtxt {
	public static String[] readBillTXT() {
		String line = null;
		StringBuffer smz=new StringBuffer();
		String[] list=null;
		File file = new File("ITSM系统账号密码.txt");
	    try {
	    InputStreamReader read = new InputStreamReader(new FileInputStream(file), "gbk");
		BufferedReader input=new BufferedReader(read); 
	          while ((line = input.readLine()) != null ) {	 
	        	  line=line.trim();
                smz=smz.append(line).append(" "); 
	            }  
		  	  list=smz.toString().split(" "); 
	            input.close();
	            read.close(); 	         
	        }catch (Exception e) {
	    		System.out.println(e);}
	    return list;
	}
	public static String readidTXT() {
		String line = null;
		File file = new File("conf.txt");
	    try {
	    InputStreamReader read = new InputStreamReader(new FileInputStream(file), "gbk");
		BufferedReader input=new BufferedReader(read); 
		line = input.readLine();
	            input.close();
	            read.close(); 	         
	        }catch (Exception e) {
	    		System.out.println(e);}
	    return line;
	}
}
