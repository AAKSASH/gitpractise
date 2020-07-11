package maven.metra;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import landingpage.landingpagemetra;
@Test(groups={"ticket"})
public class main extends driverselection
{
	public WebDriver driver;
public static Logger Log=LogManager.getLogger(main.class.getName());



	@BeforeClass
	public void openbrowser(ITestContext context) throws IOException {
        

		driver = driverselect();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		
		context.setAttribute("WebDriver", driver);
		
		Log.info("Entered In Main class");

	}

	@Test
	public void mainmethod() throws IOException, InterruptedException

	{
        
		landingpagemetra lp = new landingpagemetra(driver);
		Select trainline = new Select(lp.trainline());
		trainline.selectByIndex(2);
		
		lp.choosestops().click();
		
		Select from = new Select(lp.from());
		from.selectByIndex(3);
		Assert.assertEquals(lp.from().getAttribute("value"), "RACINE");
		
		Select to = new Select(lp.to());
		to.selectByIndex(4);
		Assert.assertEquals(lp.to().getAttribute("value"), "MCCORMICK");
		
		lp.gobutton().click();
		
		Thread.sleep(5000);
       
        Assert.assertEquals(lp.onewayfare().getText(),"$5.50");
        
        Assert.assertEquals(lp.tenridefare().getText(),"$52.25");
        
        Assert.assertEquals(lp.monthlyfare().getText(),"$159.50");
        Log.info("Executed Test case of main class ");
		
		
	}

	@AfterClass
	public void driverclose()
	{		Log.info("Exiting Main class");

	
		driver.quit();

	}

}
