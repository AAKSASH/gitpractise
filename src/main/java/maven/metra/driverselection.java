package maven.metra;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class driverselection 

{
	
	
public  WebDriver driver;
 Properties prop;
 

public WebDriver driverselect() throws IOException
  {
	
	  prop=new Properties();
	  FileInputStream fis = new FileInputStream("C:\\Users\\Aakash\\workspace\\metra\\src\\main\\java\\maven\\metra\\resource.properties");
	  
	prop.load(fis);

	if(prop.getProperty("browser").equalsIgnoreCase("chrome"))
	{
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Aakash\\chromedriver_win32\\chromedriver.exe");
	driver = new ChromeDriver();
	
	}
	 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	 return driver;
  }

}
