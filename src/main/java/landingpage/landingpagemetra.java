package landingpage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.collect.Table;


public class landingpagemetra {
	

	public WebDriver driver;
	
	public WebElement price;
	
	By trainline=By.id("edit-route-selector");
	
	By choosestops=By.xpath("//a[@class='btn btn-primary']");
	
	By from=By.name("from_stop");
	
	By to=By.name("to_stop");

	By submit=By.xpath("//button[@value='GO']");

	
	public landingpagemetra(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement trainline()
	{
		return driver.findElement(trainline);
	}
	public WebElement choosestops()
	{
		return driver.findElement(choosestops);
	}
	public WebElement from()
	{
		return driver.findElement(from);
	}
	public WebElement to()
	{
		return driver.findElement(to);
	}
	
	public WebElement gobutton()
	{
		return driver.findElement(submit);
	}
public WebElement onewayfare()
{
	
WebElement price=driver.findElement(By.xpath("(//div[@class='col-md-6'])[1]/table"));
return price.findElement(By.xpath("//tr/td[2]"));

}

public WebElement tenridefare()
{
WebElement price=driver.findElement(By.xpath("(//div[@class='col-md-6'])[1]/table"));
return price.findElement(By.xpath("//tr[2]/td/following-sibling::td"));
}

public WebElement monthlyfare()
{
WebElement price=driver.findElement(By.xpath("(//div[@class='col-md-6'])[1]/table"));
return price.findElement(By.xpath("//tr[3]/td/following-sibling::td"));
}


}
