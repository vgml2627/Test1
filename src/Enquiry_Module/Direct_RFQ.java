package Enquiry_Module;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Direct_RFQ {
	WebDriver driver;
	@BeforeTest
	public void open() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","F:\\eclipse\\driver\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://panel-sandbox.buyofuel.com/auth/login");
		Thread.sleep(2000);
		driver.findElement(By.id("login-form_email")).sendKeys("tech@buyofuel.com");
	    Thread.sleep(2000);
	    driver.findElement(By.id("login-form_password")).sendKeys("demo123$");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div/div/div/button")).click();
	    Thread.sleep(7000);
	
	}
	@Test(description = "To check whether any recent record is added")
	public void Express_Order() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='top-nav-wrapper']//ul//li[2]")).click();
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath("//div//div//ul[contains(@id,'Enquiries-popup')]//li[4]")).click();
	    Thread.sleep(5000);
	    
	    WebElement Direct_RFQ=driver.findElement(By.xpath("//div[@class='ant-table-content']//table//tbody"));
	    //printing all table values
	    List<WebElement>all_rows=Direct_RFQ.findElements(By.xpath("//div[@class='ant-table-content']//table//tbody//tr"));
	     for(WebElement e:all_rows) {
	    	System.out.println( e.getText());
	    	System.out.println("====================================");
	    }
	    
	    //printing specified column data
	    List<WebElement>column=Direct_RFQ.findElements(By.xpath("//div[@class='ant-table-content']//table//tbody//tr//td[10]"));
	    	    for(WebElement e1:column) {
	    	    	String value= e1.getText();
	    	    	System.out.println(value);
	    	    	if(value.contains("RFQ")) {
	    	    		System.out.println("Created Quote for Direct RFQ");	
	    	    	}
	    	    	if(value.contains("Quote")) {
	    	    		System.out.println("Quote received for Direct RFQ");
	    	    	}
	    	    	if(value.contains("Offer")) {
	    	    		System.out.println("Counter offer sended for Direct RFQ");
	    	    	}
	    	    	if(value.contains("Order")) {
	    	    		System.out.println("Direct RFQ order placed successfully");
	    	    	}
	    	    	}
	     System.out.println("====================================");
	     
	    	    
	    	   
	}
	@AfterTest
	public void close() {
		driver.quit();
	}
}

//comment
