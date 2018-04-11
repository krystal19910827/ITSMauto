package itsm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
public class test {

	    public static void main (String[] args){
	        File file=new File("D:\\redmine\\target\\redmine.txt");
	        String line = null;
	        StringBuffer smz=new StringBuffer();
	        StringBuffer content =new StringBuffer();
	        try{
	            InputStreamReader read = new InputStreamReader(new FileInputStream(file), "gbk");
	            BufferedReader input=new BufferedReader(read);
	            // String content=txt
	            // 2String(file);
	            while ((line = input.readLine()) != null ) {
	                smz.append(line).append("\r\n");
	            }
	            System.out.println(smz.toString());
	            if(smz.toString()!=null){
	                content.append(smz);
	                System.out.println(smz.toString());
	            }
	            input.close();
	            read.close();
	        }catch (Exception e) {
	            System.out.println(e);}
	        System.out.println(content.toString());
	}

}
