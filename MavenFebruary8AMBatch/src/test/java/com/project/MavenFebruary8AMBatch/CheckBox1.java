package com.project.MavenFebruary8AMBatch;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class CheckBox1 extends BaseTest
{
  
	@BeforeMethod
	  public void beforeMethod() throws Exception 
	  {
		  System.out.println("iam beforemethod...");
		  init();
		  test = report.startTest("LinksTesting1");
		  test.log(LogStatus.INFO, "Loding Property files & configuration files .......");
		  
		  openBrowser("chromebrowser");
		  test.log(LogStatus.PASS, "Opened the browser : " + p.getProperty("chromebrowser"));
					
		  navigateUrl("checkboxurl");
		  test.log(LogStatus.FAIL, "Navigated to url : " + childProp.getProperty("checkboxurl"));
	  }
	  
	  
	@Test
	public void checkboxTest()
	{
		List<WebElement> check=driver.findElements(By.xpath("//td[@class='table5']/input[@type='checkbox']"));
		for(int i=0;i<check.size();i++)
		{
			System.out.println(check.get(i).getAttribute("value")+"--"+check.get(i).getAttribute("checked"));
			//System.out.println(check.get(i).isSelected());
		}
	}
 

  @AfterMethod
  public void afterMethod() 
  {
	    report.endTest(test);
		report.flush();
		closeBrowser();
  }

}
