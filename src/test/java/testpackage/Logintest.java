package testpackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pagepackage.Loginpage;
import utilities.Excelutils;


public class Logintest 
{
	WebDriver driver;
String baseurl="https://www.saucedemo.com/";

@BeforeTest
public void setup()
{
	driver=new ChromeDriver();
	driver.get(baseurl);
}
@Test
public void test() throws Exception
{
	Loginpage ob= new Loginpage(driver);
	String p1="C:\\Users\\HP\\Desktop\\Book2.xlsx";
	String sheet="Sheet1";
	int rowcount=Excelutils.getrowcount(p1, sheet);
	for(int i=1;i<=rowcount;i++)
	{
		String username=Excelutils.getcellvalues(p1, sheet, i, 0);
		System.out.println("Username="+username);
		String password=Excelutils.getcellvalues(p1, sheet, i, 1);
		System.out.println("Password="+password);
		ob.setvalues(username, password);
		ob.loginclick();
	}
	ob.addcart();
	ob.addcart();
	ob.details("sneha", "Anu", "639768");
	ob.contimthd();
	ob.logout();
}

}

