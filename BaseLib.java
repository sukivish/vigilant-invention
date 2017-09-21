package com.actitime.generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseLib {
public WebDriver driver;
public WaitStatementLib wLib;
@BeforeMethod
@Parameters(value="browser")
public void preCondition(String browser)
{
	if(browser.equals("Firefox"))
	{
		//driver=new FirefoxDriver();
		driver=new RemoteWebDriver(DesiredCapabilities.firefox());
		Reporter.log("Firefox launched", true);
	}
	else if(browser.equals("ie")){
		System.setProperty("webdriver.ie.driver", ".\\exe\\IEDriverServer.exe");
		driver=new InternetExplorerDriver();
		Reporter.log("IE launched", true);
	}
	else if(browser.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", ".\\exe\\chromedriver.exe");
		driver=new ChromeDriver();
		Reporter.log("chrome launched",true);
	}
	else{
		driver=new FirefoxDriver();
		Reporter.log("Firefox launched", true);
	}
	driver.manage().window().maximize();
	driver.get("http://sukriti-pc/login.do");
	Reporter.log("navigating to url", true);
	wLib=new WaitStatementLib();
	wLib.impicitWaitForSeconds(driver, 20);
}

@AfterMethod
public void postCondition(ITestResult result){
	if(result.isSuccess()){
	}
	else{
		String fileName=result.getMethod().getMethodName();
		ScreenshotLib sLib=new ScreenshotLib();
		sLib.getScreenshot(driver, fileName);
		Reporter.log("browser closed");
	}
	driver.close();
	Reporter.log("browser closed");
}
}


