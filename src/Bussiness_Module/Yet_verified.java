package Bussiness_Module;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Yet_verified {
	WebDriver driver;
	
	public void Verify_click() {
		WebElement verify=driver.findElement(By.xpath("//table//tbody//tr//td[13]//div//button"));
		verify.click();
	}

public class child extends Yet_verified{
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
    @Test
    public void Manage_yet() throws InterruptedException {
    //working on table and printing the table date
    WebElement table=driver.findElement(By.xpath("//table//tbody"));
    List<WebElement>table_data=table.findElements(By.xpath("//table//tbody//tr"));
    for(WebElement e:table_data) {
    	System.out.println(e.getText());
    }
    Thread.sleep(3000);	
    
    List<WebElement>GST=table.findElements(By.xpath("//table//tbody//tr//td[4]"));
    for(WebElement e1:GST) {
    	String value=e1.getText();
    	//int GST_lenght=value.length();
    	System.out.println(value);
    	//System.out.println(GST_lenght);
       if(value.contains("NA")) {
    	System.out.println("Could not verify the user ,GST value is not given or its empty");
    	driver.quit();
      }
       else {
    	   super.Verify_click();
    	   Thread.sleep(5000);
       }
    }
    
    }
    @AfterTest
    public void close() {
    	driver.quit();
    }
}
}

//comment
