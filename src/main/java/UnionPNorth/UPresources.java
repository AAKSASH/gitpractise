package UnionPNorth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UPresources {
public WebDriver driver;

public UPresources(WebDriver driver) {
	this.driver=driver;	// TODO Auto-generated constructor stub
PageFactory.initElements(driver, this);	
}

@FindBy(id="route-select")
public WebElement trackline;

@FindBy(id="from-station")
public WebElement from;

@FindBy(id="to-station")
public WebElement dest;

public WebElement trackline()
{
	
return trackline;
}
public WebElement source()
{
	
return from;
}
public WebElement destination()
{
	
return dest;
}


}
