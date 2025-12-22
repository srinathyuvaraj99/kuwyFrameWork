package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	public void selectByVisibleText(WebElement dropDown,String visibleText) {
	Select drop = new Select(dropDown);
	drop.selectByVisibleText(visibleText);
	}
	
	public void selectByValue(WebElement dropDown,String value) {
	Select drop = new Select(dropDown);
	drop.selectByVisibleText(value);
	}
	
	public void presenceOfAllElements(WebDriver driver,String locator) {
		WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		eWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
	}
	
	public void presenceOfSingleElement(WebDriver driver,String locator) {
		WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		eWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}
	
	public void waitToClickElement(WebDriver driver, WebElement element) {
		WebDriverWait eWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		eWait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void scrollPage(WebDriver driver  ) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)");
	}

}
