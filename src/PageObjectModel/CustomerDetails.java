package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerDetails {

	WebDriver driver ;
	public CustomerDetails(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[text()='Others']")
	WebElement other;
	@FindBy(linkText ="Become a Partner")
	WebElement partnerLogin;
	
	public void otherOptionsSelection() {
		other.click();
		partnerLogin.click();
	}
}
