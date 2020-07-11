package maven.metra;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import UnionPNorth.UPresources;

@Test(groups = { "UPnorth" })
public class UPNorth extends driverselection {
	public WebDriver driver;

	private static Logger log = LogManager.getLogger(Mapsschedule.class.getName());

	@BeforeClass
	public void openbrowser(ITestContext context) throws IOException {

		driver = driverselect();
		driver.get(prop.getProperty("urlup"));
		driver.manage().window().maximize();
		context.setAttribute("WebDriver", driver);
		log.info("Entered in UPNorth class ");
	}

	@Test
	public void unionpacific() throws InterruptedException {

		UPresources up = new UPresources(driver);
		Select trackline = new Select(up.trackline());
		trackline.selectByIndex(9);
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.	visibilityOfElementLocated(By.xpath("//select[@id='from-station']//option[contains(text(),'Kenosha')]")));
		Select source = new Select(up.source());
		source.selectByIndex(2);

		Select dest = new Select(up.destination());
		dest.selectByIndex(3);
		log.info("Executed Test case of UPNorth class ");
	}

	@AfterClass
	public void driverclose() {
		log.info("Exit in UPNorth class ");

	
		driver.quit();

	}
}
