package simi.gestoria.base;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import simi.gestoria.resources.DataSheet;
import simi.gestoria.resources.Log;

public class Base {

	protected WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jse;
	protected Log log = new Log();
	protected DataSheet dataSheet = new DataSheet();
	
	public Base(WebDriver driver) {
	this.driver = driver;
	}
	
	public WebDriver chromeDriverConnection() {
	System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
	driver = new ChromeDriver();
	return driver;
	}
	
	
	public void visit(String url) {
	driver.get(url);
	}
	
	public void type(String inputText,By locator) {
	driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click(By locator) {
	driver.findElement(locator).click();
	}
	
	public String getText(By locator) {
	return driver.findElement(locator).getText();
	}
	
	public String getAttribute(By locator) {
	return driver.findElement(locator).getAttribute("value");
	}
	
	public String getAttributeClass(By locator) {
	return driver.findElement(locator).getAttribute("class");
	}
	
	public String getAttributeStyle(By locator) {
	return driver.findElement(locator).getAttribute("style");
	}
	
	public List<WebElement> findElements(By locator){
	return driver.findElements(locator);	
	}
	
	public int numberItems(By locator){
	return driver.findElements(locator).size();	
	}
	
	public void explicitWait(int time,By locator) {
	wait = new WebDriverWait(driver,time);
	wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void explicitWaitAttribute(int time,final By locator,final String texto) {
	wait = new WebDriverWait(driver,time);
	wait.until(new ExpectedCondition<Boolean>() {
		public Boolean apply(WebDriver driver) {
			if (getAttribute(locator).equals(texto)) {
				return true;
			
			} else {
				return false;
			}
		}
	});
	}
	
	public void implicitWait(int time) {
	driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public Boolean isDisplayed(By locator) {
	return driver.findElement(locator).isDisplayed();
	}
	
	public void selectDropdownList(By locator, String option) {
	WebElement dropdownList = driver.findElement(locator);
	List<WebElement> options = dropdownList.findElements(By.tagName("option"));
	for (int i = 0; i < options.size(); i++) {
		if (options.get(i).getText().equals(option)) {
			options.get(i).click();
		}
	}
	
	}
	
	public void scrollDown(String porcentaje) {
	jse =  (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0," + porcentaje + ")");
	}
	
}
