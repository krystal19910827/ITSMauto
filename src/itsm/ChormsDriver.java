package itsm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChormsDriver {
	public static WebDriver ChormsDriver0(){  
		 String url="http://42.99.16.142:7001/LoginFormWarning.jsp";
		 System.setProperty("webdriver.chrome.driver","src\\lib\\chromedriver.exe");
	     WebDriver driver = new ChromeDriver();
loop:   try{ driver.navigate().to(url); 
		 driver.findElement(By.cssSelector(".username")).clear();
		 driver.findElement(By.cssSelector(".username")).sendKeys("liujj1");  
		 driver.findElement(By.cssSelector(".password")).clear();
        driver.findElement(By.cssSelector(".password")).sendKeys("liujj1123");
		 //String verifyCode =code.main(driver).replace(" ", "").replace("|", "").replace("/", "").replace("\\", "").replace(".", "").replace("(", "").substring(0,4);
		 Thread.sleep(1000);
		// System.out.println(verifyCode);
        //driver.findElement(By.cssSelector(".verifyCode")).sendKeys(verifyCode);
        driver.findElement(By.xpath("//div[contains(@style,'text-align')]/input[contains(@src,'/resource/image/itsmImages/Login-submit.gif')]")).click();
       System.out.println("ITSM系统登陆成功....");
       } catch (Exception e) {
        System.out.println("ITSM系统登陆失败....");
         break loop;  }  
        return driver;
}


	public static void main(){
		try{
       WebDriver driver =ChormsDriver.ChormsDriver0();
       Thread.sleep(1000);
		String url="http://42.99.16.142:7001/workshop/form/jtitsmFormFile/warningInfoEnter.jsp";
		driver.navigate().to(url);
		//driver.findElement(By.name("STAFF_NAME")).sendKeys("刘京京");
		//driver.findElement(By.name("TEL")).sendKeys("13380031991");
		//driver.findElement(By.name("MAIL")).sendKeys("liujj1@chinatelecom.cn");
		//driver.findElement(By.name("ELEC_SERIAL")).sendKeys("000");
		//Select sel1 = new Select(driver.findElement(By.id("PROBLEM_PROVINCE")));
		//sel1.selectByVisibleText("河南");
		//Select sel2 = new Select(driver.findElement(By.id("EVENT_TYPE")));
		//sel2.selectByVisibleText("报障");
		//Select sel3 = new Select(driver.findElement(By.id("HAPPEN_SYSTEM_ID")));
		//sel3.selectByVisibleText("CRM-4G");
		//Select sel4 = new Select(driver.findElement(By.id("PRIORITY")));
		//sel4.selectByVisibleText("中");
		driver.findElement(By.name("EVENT_TITLE")).sendKeys("河南：请报竣");
		//driver.findElement(By.name("PROVINCE")).sendKeys("电信总部");
		driver.findElement(By.name("CRM_NO")).sendKeys("000");
		driver.findElement(By.name("BUSI_NUMBER")).sendKeys("000");
		driver.findElement(By.id("PRO_DETAIL_DESC")).sendKeys("hello");
	}     catch (Exception e) {
       e.printStackTrace();        }}
}
