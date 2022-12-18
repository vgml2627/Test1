package Enquiry_Module;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Open_Listing {
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
	@Test(priority = 1,description = "Positive Flow check ,Test_case to enter all field values")
	public void Open_Listing() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='top-nav-wrapper']//ul//li[2]")).click();
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath("//div//div//ul[contains(@id,'Enquiries-popup')]//li[2]")).click();
	    Thread.sleep(5000);
	    
	    //create listing 
	     driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/section/section/div/main/div[1]/button")).click();
	    Thread.sleep(6000);
	    
	    //Listing add page
	    
	    WebElement seller= driver.findElement(By.xpath("//div//div//div//div//div//div//div//div[@class='ant-select-selector']//span[@class='ant-select-selection-search']//input[@id='admin_seller']"));
	    seller.click();
	    Thread.sleep(3000);
	    seller.sendKeys("VG Bio Traders",Keys.ENTER);//drop down scroll is pending
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//div//div/div//div//div//div//div[@class='ant-select-selector']//span//input[@id='admin_product']")).click();
	    Thread.sleep(5000);

	    driver.findElement(By.xpath("//div//div//div//div//div//div//div//div[@class='rc-virtual-list-holder-inner']//div[@title='Woodchips']")).click();
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//input[@id='admin_price']")).sendKeys(String.valueOf(45));Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='admin_tradingPrice']")).sendKeys(String.valueOf(35));Thread.sleep(3000);
	    driver.findElement(By.xpath("//input[@id='admin_quantity']")).sendKeys(String.valueOf(1000));Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//input[@id='admin_gst']")).click();Thread.sleep(3000);
	    driver.findElement(By.xpath("//div//div//div//div//div//div//div//div[@class='rc-virtual-list-holder-inner']//div[@title='5% Extra']")).click();
	    Thread.sleep(3000);
	    
	    
	    driver.findElement(By.xpath("//input[@id='admin_transport']")).click();Thread.sleep(5000);
	    driver.findElement(By.xpath("//div//div//div//div//div//div//div//div[@class='rc-virtual-list-holder-inner']//div[@title='Extra']")).click();
	    Thread.sleep(3000);
	    WebElement transport_chrg=driver.findElement(By.xpath("//input[@id='admin_transportCharges']"));
	    transport_chrg.sendKeys(String.valueOf(5000));
	    Thread.sleep(3000);
	    
	    driver.findElement(By.xpath("//div[@class='ant-select-selector']//span//input[@id='admin_frequency']")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//div//div//div//div//div//div//div//div[@class='rc-virtual-list-holder-inner']//div[@title='Once']")).click();
	    Thread.sleep(3000);
	    
	    //delivery-by
	    driver.findElement(By.xpath("//input[@id='admin_preferredDeliveryBy'] ")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//div[@class='ant-picker-footer']//a")).click();
	    Thread.sleep(7000);
	    
	    driver.findElement(By.xpath("//input[@id='admin_productImage']")).sendKeys("C:\\Users\\offic\\Downloads\\bio.jpg");
	    Thread.sleep(4000);
	    WebElement Upload=driver.findElement(By.xpath("//span[@class='ant-upload-list-item-name']"));
	    System.out.println("The upload file name is..."+Upload.getText());
	    
	    driver.findElement(By.xpath("//*[@id=\"admin\"]/div[1]/div[4]/div/div[2]/div[2]/div[2]/div/div/div/div")).click();
	    //driver.findElement(By.xpath("//div//div//div//div//div[@class='ant-select-selector']//span//input[@id='admin_paymentTerms']")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//div[@class='rc-virtual-list-holder-inner']//div[@title='100% before dispatch of materials against proforma invoice']")).click();
	    Thread.sleep(5000);
	    
	    WebElement check_box= driver.findElement(By.xpath("//input[@id='admin_negotiable']"));
	    check_box.click();
	    System.out.println(check_box.isSelected());
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath("//div//textarea[@id='admin_remark']")).sendKeys("Automation Testing for Lisiting menu");
	    Thread.sleep(5000);
	    
	    driver.findElement(By.xpath("//div//button[@type='submit']")).click();
	    Thread.sleep(3000); 
	    
	}
	@Test(description ="Test case to print the last recent record added in the Open RFQ",priority =2)
	public void row_record_access() throws InterruptedException {
		//getting total rows
		WebElement table=driver.findElement(By.xpath("//div[@class='ant-table-content']//table//thead//tr"));
		List<WebElement>all_rows=table.findElements(By.xpath("//div[@class='ant-table-content']//table//tbody//tr"));
	    int size=all_rows.size();
	    //size=size-1;
	    System.out.println("the total size is:..."+size);
	    System.out.println("====================================");
	    //getting last recent record added in the list table
	    size=size-1;
	    List<WebElement>table_value1=table.findElements(By.xpath("//div[@class='ant-table-content']//table//tbody"));
	    for(WebElement e:table_value1) {
	    List<WebElement>row=e.findElements(By.tagName("tr"));
	    WebElement row_value=row.get(size);
	    System.out.println("Printing specified last row in the table.."+row_value.getText());
	    Thread.sleep(6000);
	    System.out.println("====================================");
	    }
	    Thread.sleep(3000);
	}
	@Test(description ="Test case to navigate the action page for the last record added",priority =3)
	public void action() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scroll(0,390)");
	    Thread.sleep(5000);
	    System.out.println("Successfully scrolled top-bottom");
		//scroll left to right(horizontal)
	    //JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector(\"#root > div > section > section > section > div > main > div.ant-card.ant-card-bordered.mt-3 > div > div > div > div > div > div > div\").scrollLeft=2000");
        Thread.sleep(5000);
        System.out.println("Successfully scrolled left to right");
	    Thread.sleep(5000);
	    System.out.println("====================================");

	    //Action button click
	    //Printing last quote value
	    WebElement quote=driver.findElement(By.xpath("//table[1]/tbody/tr[last()]//td[11]"));
	    String value=quote.getText();
	    System.out.println("The actual quote value for current product is.."+value);
	    System.out.println("====================================");
	    //used last() method in the xpath so that directly we can get the last row value in the table.
	    WebElement action=driver.findElement(By.xpath("//table[1]/tbody/tr[last()]//td[12]//div//div//button"));
	    action.click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//div[@id='rc-tabs-0-tab-2']")).click();
	    System.out.println("Successfully moved to quote page");
	    Thread.sleep(5000);
	    }
	

@AfterTest
public void close() {
	driver.quit();
}
} 