package pagepackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	

		WebDriver driver;
		
		@FindBy(id="user-name")
		WebElement sid;
		
		@FindBy(id="password")
		WebElement spass;
		
		@FindBy(id="login-button")
		WebElement slogin;
		
		@FindBy(xpath="//*[@id=\"inventory_container\"]")
		WebElement items;
		
		@FindBy(xpath="//*[@id=\"shopping_cart_container\"]/a/svg")
		WebElement cart;
		
		@FindBy(id="checkout")
		WebElement check;
		
		@FindBy(id="first-name")
		WebElement fname;
		
		@FindBy(id="last-name")
		WebElement lname;
		
		@FindBy(id="postal-code")
		WebElement zip;
		
		@FindBy(id="continue")
		WebElement conti;
		
		@FindBy(xpath="//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]")
		WebElement checkout;
		
		@FindBy(xpath="//*[@id=\"logout_sidebar_link\"]")
		WebElement logout;
		
		
		public Loginpage(WebDriver driver) 
		{
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
		
		
		public void setvalues(String un,String pswd)
		{
			sid.clear();
			sid.sendKeys(un);
			spass.clear();
			spass.sendKeys(pswd);
		}
		
		public void loginclick()
		{
			slogin.click();
		}
		
		public void cart()
		{
			
			List<WebElement> li=items.findElements(By.tagName("button"));
			for(WebElement ct:li)
			{
				ct.click();
			}
		}
		
		public void addcart()
		{
			cart.click();
			check.click();
		}
		
		public void details(String firstname,String lastname,String zipcode)
		{
			fname.sendKeys(firstname);
			lname.sendKeys(lastname);
			zip.sendKeys(zipcode);
		}
		
		public void contimthd()
		{
			conti.click();
		}
		
		public void logout() throws Exception
		{
			checkout.click();
			Thread.sleep(1000);
			logout.click();
		}
	}
