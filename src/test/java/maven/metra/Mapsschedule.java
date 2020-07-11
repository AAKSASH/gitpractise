package maven.metra;

import java.io.IOException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import mapsschedule.Mapselection;

@Test(groups = { "Maps" })
public class Mapsschedule extends driverselection

{
	public WebDriver driver;
	private static Logger log = LogManager.getLogger(Mapsschedule.class.getName());

	@BeforeClass
	public void openbrowser(ITestContext context) throws IOException {

		driver = driverselect();
		driver.get(prop.getProperty("urlmain"));
		driver.manage().window().maximize();
		context.setAttribute("WebDriver", driver);
		log.info("Entered in Mapsschedule class");
	}

	@Test
	public void maps() throws InterruptedException

	{

		String[] stationname = { "Manhattan", "Joliet", "New Lenox Laraway Road", "New Lenox", "Lockport", "Aurora",
				"Romeoville", "Mokena", "Elburn", "Orland Park 179th Street" };
		Actions mouse = new Actions(driver);

		Mapselection mapslct = new Mapselection(driver);
		mouse.moveToElement(mapslct.mapsandschedule()).build().perform();
		mouse.moveToElement(mapslct.systemmap()).click().build().perform();
		mapslct.search().click();
		mapslct.Location().sendKeys("jacksonville");
		mapslct.btn_search().click();
		int station_Count = mapslct.station_name().size();
		for (int i = 0; i < station_Count; i++) {
			Assert.assertEquals(mapslct.station_name().get(i).getText(), stationname[i]);

		}

		log.info("Executed Test case of Mapsschedule class ");
	}

	@AfterClass
	public void driverclose() {

		log.info("Exit Mapsschedule class");
		driver.quit();
		//driver.quit();

	}

}