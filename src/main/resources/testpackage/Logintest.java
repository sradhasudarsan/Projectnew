package testpackage;

import org.testng.annotations.Test;

import basepackage.Baseclass;
import pagepackage.Loginpage;
import utilities.Excelutils;

public class Logintest extends Baseclass {
	@Test
	public void verifyLoginWithValidCred() throws Exception
	{
		Loginpage p1=new Loginpage(driver);
		String xl ="C:\\Users\\HP\\Desktop\\Book2.xlsx";
		String Sheet ="Sheet1";
		int rowCount = Excelutils.getRowCount(xl,Sheet);
		for(int i=1;i<=rowCount;i++)
		{
			String UserName=Excelutils.getCellValue(xl, Sheet,i,0);
			System.out.println("username----"+UserName);
			String pwd=Excelutils.getCellValue(xl, Sheet, i, 1);
			System.out.println("password---"+pwd);
			p1.setvalues(UserName,pwd);
			p1.clickloginBtn();
			
		}
	}

}