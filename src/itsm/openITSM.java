package itsm;


import java.io.File;

import org.openqa.selenium.WebDriver;



public class openITSM {
	public static void main(String[] args) throws InterruptedException{
		
		//WebDriver driver=IEdriver.IEDriver();	
		WebDriver driver =Firebox.FirefoxDriver();
          Thread.sleep(3000);
		
		loop:for(int i=1;i<32;i++){
			try{
			String dbnbr=provinceCode.Pronvincode(i).split("\\|")[1];
			File file=readtxt.getfilename(dbnbr);
			if (file!=null){	
			String content=readtxt.gettxt(file);
			if (content!=null){
				 Firebox.main(driver, dbnbr, content);
				
				//IEdriver.open(driver, content, dbnbr);
				//ChormsDriver.main();
				}	
			readtxt.clearInfoForFile(file);
			}
			System.out.println(i);
		} catch (Exception e) {System.out.println("网络连接超时....");break loop;       }
	}   
		driver.close();
}
}
