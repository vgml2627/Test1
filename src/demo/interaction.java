package demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class interaction {

	public static void main(String[] args) throws InterruptedException {
		
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
	    //verified tab
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/section/div/main/div[2]/div/label[2]")).click();
	    Thread.sleep(3000);
	    
	    List<WebElement>tab_value=driver.findElements(By.xpath("//*[@class='ant-table-tbody']"));
	   
	    System.out.println(tab_value.size());
	    System.out.println("==================================");
	    boolean status=false;
	    
	    for(WebElement e:tab_value) {
	    	String val=e.getText();
	    	System.out.println(val);
	    	
	    	if(val.contains("cbe@gmail.com"));{
	    		status=true;
	    		break;
	    	}
	    }
	    Assert.assertTrue(status);

	  
	    
	    //De-registered
	    //driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/section/div/main/div[2]/div/label[3]")).click();
	    //Thread.sleep(3000);
	    
	    driver.quit();
	    System.out.println("==================================");
	    System.out.println("Successfully interacted with the bussiness menu verified tabs title and printed in the console");
	    
	    
	}

}
