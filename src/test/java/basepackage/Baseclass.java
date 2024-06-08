package basepackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Baseclass {
	public static WebDriver driver;
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		//driver.get("https://www.saucedemo.com/v1/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}
	@Test
	public void test()
	{
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		  driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		  driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		  
	}
	
	@AfterTest
	public void postcondition()
	{
		driver.close();
	}
	
	

}
