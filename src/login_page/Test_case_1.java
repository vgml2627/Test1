package login_page;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class Test_case_1 {
  //comment  
	WebDriver driver;
        
    @BeforeTest
    public  void open() throws InterruptedException {
    		System.setProperty("webdriver.chrome.driver","F:\\eclipse\\driver\\chromedriver.exe");
		    driver=new ChromeDriver();
			driver.manage().window().maximize();
		    driver.get("https://panel-sandbox.buyofuel.com/auth/login");
			Thread.sleep(3000);
			}
    @Test(priority = 1,dataProvider ="testdata",description="Test_case to check the positive flow of Admin_Panel",enabled =true)
    public void valid_case(String uname,String pwd) throws InterruptedException, IOException
    {
    driver.findElement(By.id("login-form_email")).sendKeys(uname);
    Thread.sleep(3000);
    driver.findElement(By.id("login-form_password")).sendKeys(pwd);
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div/div/div/button")).click();
    Thread.sleep(3000);
    String act_title= "Buyofuel - Admin Panel";
	String Exp_title=driver.getTitle();
	assertEquals(act_title,Exp_title);
	System.out.println("Login success with the valid credential");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/section/header/div/div[2]/div[2]/ul/li[1]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/ul/li/span/span/span[2]")).click();
	Thread.sleep(3000);
	Reporter.log("Successfull login with the valid credential");
    }
	@DataProvider(name="testdata")
	public Object[][]Data_Provider() 
	{
		return new Object[][]
		{
			{"tech@buyofuel.com","demo123$"},
			{"veegee@gmail.com","demo123$"}
		};
		}
    
    @Test(priority =2,dataProvider ="testdata1",description = "Test_case to check the Negative flow of Admin_Panel both Data Invalid",enabled =true)
    public void invalid_case(String uname,String pwd) throws InterruptedException {
		driver.findElement(By.id("login-form_email")).sendKeys(uname);
	    Thread.sleep(3000);
	    driver.findElement(By.id("login-form_password")).sendKeys(pwd);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div/div/div/button")).click();
	    Thread.sleep(3000);
	    String Act_alert="Account with given Phone Number / Email Address does not exist.";
		String exp_alert= driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/div/div")).getText();
		//System.out.println(exp_alert);
		assertEquals(Act_alert, exp_alert);
		Thread.sleep(3000);
		driver.navigate().refresh();
		System.out.println("User enter invalid credential and also not registered user");
		Reporter.log("Un-Successful login failed with the Invalid credential");
}
    @DataProvider(name="testdata1")
	public Object[][]Data_Provider1() 
	{
		return new Object[][]
		{
			{"tech00@buyofuel.com","demo123$$"},
			{"veegee00@gmail.com","demo123$@"}
		};
		}
    @Test(priority =3,dataProvider ="testdata2",description = "Test_case to check the Negative flow of Admin_Panel both Data Invalid for Alternate Fields",enabled =true)
    public void Alertnate_Invalid_check(String uname,String pwd) throws InterruptedException {
		driver.findElement(By.id("login-form_email")).sendKeys(uname);
	    Thread.sleep(3000);
	    driver.findElement(By.id("login-form_password")).sendKeys(pwd);
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div/div/div/button")).click();
	    Thread.sleep(3000);
	    String  exp_alert=driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[3]/div/div")).getText();
	    //System.out.println(exp_alert);
	    String act_alert="Account with given Phone Number / Email Address does not exist.";
	    String act_alert1="Please provide a valid Password";
	    
	    //System.out.println(exp_alert1);
	    if(exp_alert.equals(act_alert))
	    {
	    	System.out.println("User might entered invalid mail-id");
	    }
	    if(exp_alert.equals(act_alert1))
	    {
	    	System.out.println("User might entered invalid password");
	    }
	    
	    Thread.sleep(5000);
	    driver.navigate().refresh();
		//System.out.println("User enter invalid credential and also not registered user");
		Reporter.log("Un-Successful login failed with the Invalid credential in Alternate Fields");
}
    @DataProvider(name="testdata2")
	public Object[][]Data_Provider2() 
	{
		return new Object[][]
		{
		{"tech00@buyofuel.com","demo123$"},
		{"veegee@gmail.com","demo11123$@"}
		};
		}

   @Test(priority =4,dataProvider ="testdata3",description ="Test_case to check the validation and the field lenght restriction",enabled =true)
    public void validation_check(String uname,String pwd) throws InterruptedException {
    	WebElement username=driver.findElement(By.id("login-form_email"));
    	username.sendKeys(uname);
    	String type_lenght=username.getAttribute("value");
    	int lenght=type_lenght.length();
    	Thread.sleep(3000);
	    WebElement p_word= driver.findElement(By.id("login-form_password"));
		p_word.sendKeys(pwd);
		String type_lenght1=p_word.getAttribute("value");
		int lenght1=type_lenght1.length();
		driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[4]/div/div/div/button")).click();
	    Thread.sleep(5000);
        driver.navigate().refresh();
        Thread.sleep(3000);
		if(lenght<=20){
    		System.out.println("The username field limit is upto the requirment..."+lenght);}
    	else{
    		System.out.println("The username field limit is not upto the requirment..."+lenght);}
		if(lenght1<=12){
			System.out.println("The password field limit is upto the requirment..."+lenght1);}
		else{
			System.out.println("The Password field limit is not upto the requirment..."+lenght1);}
	
        if(uname.isEmpty()) {
        	System.out.println("Email field should not be empty");	
        }
        if((pwd).isEmpty()) {
        	System.out.println("Passwod field should not be empty");	
        }
        Reporter.log("Successfully Tested the field lenght and valiation alert");
   }
		
    @DataProvider(name="testdata3")
	public Object[][]Data_Provider3() 
	{
		return new Object[][]
		{
		{"vishnukumaran125@gmail.com","12389geeethan123456"},
		{"veegee1@gmail.com","veegee26"},
        {"" ,"demo123$"},
		{"veegee22@gmail.com",""}
		};
		}


    @AfterTest
	public  void close() {
		driver.quit();
	}
		
}
 
