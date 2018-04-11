package itsm;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;

public class IEdriver {
	public static WebDriver IEDriver(){  
		String url="http://42.99.16.142:7001/LoginFormWarning.jsp";
		 System.setProperty("webdriver.ie.driver","src\\lib\\IEDriverServer(32).exe");
		DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
	     ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	       WebDriver driver=new InternetExplorerDriver(ieCapabilities);	
 try{
		   driver.navigate().to(url); 
			Scanner scanner=new Scanner(System.in); 
			System.out.println("请输入验证码：");
			String code=scanner.nextLine();
			scanner.close();
			String username=readidtxt.readBillTXT()[0];
			String password =readidtxt.readBillTXT()[1];
		 driver.findElement(By.id("j_username")).sendKeys(username);   
		 driver.findElement(By.id("j_password")).sendKeys(password);  
        //String verifyCode =code.main(driver).replace(" ", "").replace("|", "").replace("/", "").replace(".", "").substring(0,4);
		//System.out.println(verifyCode);
        driver.findElement(By.cssSelector(".verifyCode")).sendKeys(code);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[contains(@style,'TEXT-ALIGN')]/input[contains(@src,'/resource/image/itsmImages/Login-submit.gif')]")).click();
        WebElement editor=driver.findElement(By.xpath("//div[contains(@style,'TEXT-ALIGN')]/input[contains(@src,'/resource/image/itsmImages/Login-submit.gif')]"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();",editor);
        System.out.println("ITSM系统登陆成功....");  } 
    catch (Exception e) {
        System.out.println("ITSM系统登陆失败....");
        e.printStackTrace();        }
        return driver;}
	//填写订单
	public static void open(WebDriver driver,String content,String dbnbr){
		try{
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'centerFrame')]")));
		Thread.sleep(1000);
		String pronvince=dbnbr;
		driver.findElement(By.name("ELEC_SERIAL")).sendKeys("000");
		String SERIAL=driver.findElement(By.id("WARNING_SERIAL")).getAttribute("value");
		System.out.println(SERIAL);
		Select sel1 = new Select(driver.findElement(By.id("PROBLEM_PROVINCE")));
		sel1.selectByVisibleText(pronvince);
		driver.findElement(By.name("CRM_NO")).sendKeys("000");
		driver.findElement(By.name("BUSI_NUMBER")).sendKeys("000");
		driver.findElement(By.name("EVENT_TITLE")).sendKeys(pronvince.concat(":请报竣"));
	    IEdriver.jsExecut(driver, content);
	   driver.switchTo().defaultContent();
	   driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'centerFrame')]")));	   
	   Thread.sleep(2000); 
	   //driver.findElement(By.xpath("//span[contains(@id,'SUBMIT_BUTTON')]")).click();
	   WebElement editor=driver.findElement(By.xpath("//span[contains(@id,'SUBMIT_BUTTON')]"));
	   JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
       jsExecutor.executeScript("arguments[0].click();",editor);
	   //driver.switchTo().defaultContent();
	   Thread.sleep(2000); 
	   driver.switchTo().alert().accept();
	    driver.switchTo().defaultContent();
		}     catch (Exception e) {
        e.printStackTrace();    }
	}
	
	   public static void jsExecut(WebDriver driver,String content) {
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'PRO_DETAIL_DESC')]")));
		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'eWebEditor')]")));
		   JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		   WebElement editor=driver.findElement(By.xpath("//body"));
		   String js="document.body.innerHTML="+"\""+content.substring(0, content.length())+"\";";
	 	jsExecutor.executeScript(js,editor);
	 	driver.switchTo().defaultContent();
	 	driver.switchTo().defaultContent();
		try {
		Thread.sleep(1000);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	   }
}
