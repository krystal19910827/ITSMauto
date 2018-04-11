package itsm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class readtxt {
	//获得文件名字
	 public static File getfilename(String filename){
		    File file = new File("详单缓存");
		    File fileread=null;
	        try{  		
	    		File[] tempFile = file.listFiles();
	    		
	    		for(int i = 0; i < tempFile.length; i++){
	    			File files=tempFile[i];
	    			if((tempFile[i].getName().indexOf(filename)!=-1)&&(files.length()!=0)){
	    				fileread=new File("详单缓存\\"+filename+".txt");
	    			}
	    		}
	        }catch(Exception e){
	            e.printStackTrace(); }
	        return fileread;
	    }
	  //读取文本为字符串 
		public static String gettxt(File file){
	    	String line = null;
	    	StringBuffer smz=new StringBuffer();
	    	String content ="<font size='2px' color='black' >CUST_ORDER_ID  CUST_SO_NUMBER       TRANSACTION_ID(下省流水)<br>";
	        try{
	        InputStreamReader read = new InputStreamReader(new FileInputStream(file), "gbk");
			BufferedReader input=new BufferedReader(read); 
	       // String content=txt2String(file);
			while ((line = input.readLine()) != null ) {	 
				smz.append(line).append("<br>");	
			}
			if(smz.toString()!=null){
			content =content.concat(smz.toString().replaceAll("\\|", "  ").concat("</br>如省内已报竣，请反馈报竣流水，以便集团核实归档。</font>"));
			}
            input.close();
            read.close(); 
	        }catch (Exception e) {
	    		System.out.println(e);}
	        return content;
	        
	    }

 public static void clearInfoForFile(File file){
     try {
         if(!file.exists()) {
             file.createNewFile();
         }
         FileWriter fileWriter =new FileWriter(file);
         fileWriter.write("");
         fileWriter.flush();
         fileWriter.close();
     } catch (IOException e) {
         e.printStackTrace();
     }
 }

		     
}
