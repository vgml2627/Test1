package demo;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class navigation {
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
	    //driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/section/div/main/div[1]/button")).click();
	    //Thread.sleep(6000);
	    WebElement table=driver.findElement(By.xpath("//div[@class='ant-table-content']//table//thead//tr"));
	    //Getting all value in header
	    List<WebElement>header=table.findElements(By.tagName("th"));
	    for(WebElement e:header) {
	    	//System.out.println(e.);
	    	String text=e.getText();
	    	System.out.println("printing the header values.."+text);
	    	 }
	     System.out.println("====================================");
	    //getting all values in rows
	     List<WebElement>all_rows=table.findElements(By.xpath("//div[@class='ant-table-content']//table//tbody//tr"));
	     int size=all_rows.size();
	     System.out.println("the total size is:..."+size);
	     System.out.println("====================================");
	    
	    //printing  column values
	    for(WebElement e:all_rows) {
	    List<WebElement>col=e.findElements(By.tagName("td"));
	    WebElement first_column=col.get(0);
	    System.out.println("Printing specified column value.."+first_column.getText());
	    }
	    System.out.println("====================================");

	    //printing row specified row
	    List<WebElement>table_value=table.findElements(By.xpath("//div[@class='ant-table-content']//table//tbody"));
	    for(WebElement e:table_value) {
	    List<WebElement>row=e.findElements(By.tagName("tr"));
	    WebElement row_value=row.get(4);
	    System.out.println("Printing specified row.."+row_value.getText());
	    }
	    System.out.println("====================================");

	    //printing last row
	    size=size-1;
	    List<WebElement>table_value1=table.findElements(By.xpath("//div[@class='ant-table-content']//table//tbody"));
	    for(WebElement e:table_value1) {
	    List<WebElement>row=e.findElements(By.tagName("tr"));
	    WebElement row_value=row.get(size);
	    System.out.println("Printing specified last row in the table.."+row_value.getText());
	    Thread.sleep(6000);
	    System.out.println("====================================");

	    //scroll left to right(horizontal)
	    JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"#root > div > section > section > section > div > main > div.ant-card.ant-card-bordered.mt-3 > div > div > div > div > div > div > div\").scrollLeft=2000");
        Thread.sleep(5000);
        System.out.println("Successfully scrolled left to right");
	    Thread.sleep(5000);
	    System.out.println("====================================");

	    //Action button click
	    //Printing last quote value
	    WebElement quote=driver.findElement(By.xpath("//table[1]/tbody/tr[last()]//td[8]"));
	    String value=quote.getText();
	    System.out.println("The actual quote value for current product is.."+value);
	    System.out.println("====================================");
	    //used last() method in the xpath so that directly we can get the last row value in the table.
	    WebElement action=driver.findElement(By.xpath("//table[1]/tbody/tr[last()]//td[9]//div//div//button"));
	    action.click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//div[@id='rc-tabs-0-tab-2']")).click();
	    System.out.println("Successfully moved to quote page");
	    Thread.sleep(4000);
        driver.quit();
	    }
	}
}

	    
	    
	    
	    //scroll top- bottom (veritial)
	    /*JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scroll(0,280)");
	    Thread.sleep(5000);
	    System.out.println("Successfully scrolled top-bottom");
	    
	    //scroll bottom-top(veritial)
        /*JavascriptExecutor js1 = (JavascriptExecutor) driver;
	    js1.executeScript("window.scrollBy(0,-350)", "");
	    Thread.sleep(3000);
        System.out.println("Successfully scrolled top-bottom and bottom-top approach");
	    
	    //scroll left to right(horizontal)
        js.executeScript("document.querySelector(\"#root > div > section > section > section > div > main > div.ant-card.ant-card-bordered.mt-3 > div > div > div > div > div > div > div\").scrollLeft=2000");
        Thread.sleep(5000);
        System.out.println("Successfully scrolled left to right");
	    driver.quit();*/
	   
	    
	   



	