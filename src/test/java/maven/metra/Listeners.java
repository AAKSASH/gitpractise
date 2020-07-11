package maven.metra;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Listeners extends main  implements ITestListener  {
	
	WebDriver driver=null;
	
	Extentreport ext=new Extentreport();
	ExtentReports extent = ext.extent();
	private ExtentTest test;

ThreadLocal<ExtentTest> thread = new ThreadLocal<ExtentTest>();

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
		extent.flush();
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		
		
thread.get().fatal(result.getThrowable());
		
		/*System.out.println("***** Error "+result.getName()+" test has failed *****");*/
    	String methodName=result.getName().toString().trim();
        ITestContext context = result.getTestContext();
        driver = (WebDriver) context.getAttribute("WebDriver");
   
       String filepath = System.getProperty("user.dir")+"\\Reports\\screenshot";
    	try {
			takeScreenShot(filepath,methodName,result, driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
    }
	public void takeScreenShot(String filepath,String methodName, ITestResult result,WebDriver driver) throws IOException {
	
		
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    //The below method will save the screen shot in d drive with test method name 
	       try {
				FileUtils.copyFile(scrFile, new File(filepath +methodName+".png"));
				thread.get().addScreenCaptureFromPath(filepath +methodName+".png",result.getMethod().getMethodName());
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	       
	       
	}
	
	
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		

	test = extent.createTest(result.getMethod().getMethodName());
	thread.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
	thread.get().log(Status.PASS,"Test passed "+ result.getMethod().getMethodName())	;
	}
	
	
}
