package itsm;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
 

public class Firebox {

	    public static  WebDriver FirefoxDriver() {
	        // TODO Auto-generated method stub
	    	String url="http://42.99.16.142:7001/LoginFormWarning.jsp";
	    	String path=readidtxt.readidTXT();
	    	System.out.println(path);
	    	System.setProperty("webdriver.firefox.bin",path); 
	    	WebDriver driver = new FirefoxDriver();
	       // Navigation navigation =driver.navigate();
	      //  navigation.to(url);
	       //前进 navigation.forward();
	        //后退navigation.back();
	        //刷新navigation.refresh();
	        
	        driver.get(url); 
	        Scanner scanner=new Scanner(System.in); 
	 			System.out.println("请输入验证码：");
	 			String code=scanner.nextLine();
	 			scanner.close();
	 			String username=readidtxt.readBillTXT()[0];
				String password =readidtxt.readBillTXT()[1];
	        //定位搜索框
				driver.findElement(By.id("j_username")).sendKeys(username);   
				 driver.findElement(By.id("j_password")).sendKeys(password);  //搜索框输入关键字
	        try{
	       // String verifyCode =code.main(driver).replace(" ", "").replace("-", "").replace("|", "").replace("/", "").replace("\\", "").replace(".", "").substring(0,4);
	        String verifyCode=code;
	        Thread.sleep(1000);
			System.out.println(verifyCode);
	        driver.findElement(By.cssSelector(".verifyCode")).sendKeys(verifyCode);
	        driver.findElement(By.xpath("//div[contains(@style,'text-align')]/input[contains(@src,'/resource/image/itsmImages/Login-submit.gif')]")).click();
	        System.out.println("ITSM系统登陆成功....");}
	        catch (Exception e) {
	            System.out.println("ITSM系统登陆失败....");	        }
	        //断言搜索结果页面
	        return driver;
	    }
	    public static void main(WebDriver driver,String dbnbr,String content){
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
				   Thread.sleep(1000); 
			   WebElement editor=driver.findElement(By.xpath("//span[contains(@id,'SUBMIT_BUTTON')]"));
			   JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		       jsExecutor.executeScript("arguments[0].click();",editor);
		       driver.switchTo().alert().accept();
			    driver.switchTo().defaultContent();
			}     catch (Exception e) {
	       e.printStackTrace();        }}
   public static void jsExecut(WebDriver driver,String content) {
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'PRO_DETAIL_DESC')]")));
	    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'eWebEditor')]")));
	   JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
	   WebElement editor=driver.findElement(By.xpath("//body"));
	   String js="document.body.innerHTML="+"\""+content.substring(0, content.length())+"\";";
 	jsExecutor.executeScript(js,editor);
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
