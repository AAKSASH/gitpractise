package mapsschedule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Mapselection {

public WebDriver driver;	

By hovermouseonmaps=By.linkText("Maps and Schedules");

By systemmap=By.partialLinkText("Metra System Map");

@FindBy(css="div[class='pullout-button find']")
public WebElement btn_search;

@FindBy(id="location")
public WebElement location;

@FindBy(name="submit")
public WebElement btn_search_sys;

By station_name= By.xpath("//div[@class='result-row']/h4/a");


public Mapselection(WebDriver driver) {
		// TODO Auto-generated constructor stub
this.driver=driver;
PageFactory.initElements(driver,this);
}




public WebElement mapsandschedule()
{
return driver.findElement(hovermouseonmaps);	
}

public WebElement systemmap()
{
return driver.findElement(systemmap);
}

public WebElement search()
{
return 	btn_search;
}

public WebElement Location()
{
	
	return location;
	
	}

public WebElement btn_search()
{
	
	return btn_search_sys;
	
	}
public List<WebElement> station_name()
{
List<WebElement> station=  driver.findElements(station_name);	
return station;
}

//page factory
//groups
//link test vs partial link text
//actionm class
}
