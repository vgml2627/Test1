package demo;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class test {
public static void main(String[] args) throws InterruptedException  {
        	
        
	    System.setProperty("webdriver.chrome.driver","F:\\eclipse\\driver\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	    driver.get("https://panel-sandbox.buyofuel.com/auth/login");
		Thread.sleep(2000);
		driver.findElement(By.id("login-form_email")).sendKeys("tech@buyofuel.com");
	    Thread.sleep(2000);
	    driver.findElement(By.id("login-form_password")).sendKeys("demo123$");
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div/div/div/button")).click();
	    Thread.sleep(7000);
	     
	    driver.findElement(By.xpath("//div[@class='top-nav-wrapper']//ul//li[2]")).click();
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath("//div//div//ul[contains(@id,'Enquiries-popup')]//li[1]")).click();
	    Thread.sleep(6000);
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/section/div/main/div[1]/button")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//div//div//div//div//div//div//div//div[@class='ant-select-selector']//span[@class='ant-select-selection-search']//input[@id='admin_buyer']")).click();
	    Thread.sleep(5000);
	    
	    List<WebElement> a1=driver.findElements(By.xpath("/html/body/div[4]/div/div/div/div[2]/div[1]/div/div/div[1]"));
	    Thread.sleep(5000);
	    }
}

