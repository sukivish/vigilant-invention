package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatementLib {
public void impicitWaitForSeconds(WebDriver driver,int time){
	driver.manage()	.timeouts().implicitlyWait(time, TimeUnit.SECONDS);
}
public void implicitWaitForMinutes(WebDriver driver,int time){
	driver.manage().timeouts().implicitlyWait(time,TimeUnit.MINUTES);
}
public void explicitWait(WebDriver driver,int time,WebElement element){
	WebDriverWait wait=new WebDriverWait(driver, time);
	wait.until(ExpectedConditions.visibilityOf(element));
}
}
