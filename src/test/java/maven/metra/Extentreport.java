package maven.metra;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extentreport {

	 ExtentReports extent;
	
	public ExtentReports extent()
	
	{
		
		String path =System.getProperty("user.dir")+"\\reports\\extent.html";
		
		ExtentSparkReporter rep=new ExtentSparkReporter(path);
		rep.config().setDocumentTitle("Extent report metra");
		rep.config().setReportName("metra");
		extent = new ExtentReports();
		extent.attachReporter(rep);
		extent.setSystemInfo("tester","aakash sharma");
		return extent;
	}
}
