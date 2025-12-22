package PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.AbstractComponents;

public class MainPage {
	WebDriver driver;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Accept ']")
	WebElement acceptCookies;
	@FindBy(id = "dealership_name")
	WebElement dealerNameTxtBox;
	@FindBy(id = "name")
	WebElement userNameTxtBox;
	@FindBy(id = "mobile_no")
	WebElement phoneNoTxtBox;
	@FindBy(id = "pan_no")
	WebElement panNumberTxtBox;
	@FindBy(xpath = "//label[text()='Not Available']")
	WebElement gstNotAvailableButton;
	@FindBy(xpath = "//label[text()='Available']")
	WebElement gstAvailableButton;
	@FindBy(id = "gst_no")
	WebElement gstNumberTxtBox;
	@FindBy(id = "address")
	WebElement addressTxtBox;
	@FindBy(id = "pincode")
	WebElement pincodeTxtBox;
	@FindBy(id = "cus_area")
	WebElement custAreaDropDown;
	@FindBy(id = "dealer_acc_no")
	WebElement accounNoTxtBox;
	@FindBy(id = "dealer_ifscode")
	WebElement ifscTxtBox;
	@FindBy(id = "acc_holder_name")
	WebElement accountHolderName;
	@FindBy(xpath = "//input[@data-id='enrolment_form']")
	WebElement enrollmentFormUpload;
	@FindBy(xpath = "//label[text()='PAN Card ']/following-sibling::input[@type='file']")
	WebElement panCardUpload;
	@FindBy(xpath = "//label[text()='KYC Proof ']/following-sibling::input[@type='file']")
	WebElement kycUpload;
	@FindBy(xpath = "//label[text()='Cancelled Cheque ']/following-sibling::input[@type='file']")
	WebElement chequeUpload;
	@FindBy(xpath = "//label[contains(text(),'Photo')]/following-sibling::input[@type='file']")
	WebElement photoUpload;
	@FindBy(xpath = "//label[text()='Business Proof ']/following-sibling::input[@type='file']")
	WebElement businessProofUpload;
	@FindBy(xpath = "//label[text()='Engagement Letter ']/following-sibling::input[@type='file']")
	WebElement engagementLetterUpload;
	String districts = "//select[@id='cus_area']/option[@data-district]";
	String dealerBankName = "//select[@id='dealer_bank_name' and not(@readonly)]";
	String area = "Veppambattu";
	AbstractComponents ab = new AbstractComponents();


	public void personalDetails(String dealerNameData, String userNameData, String phoneNoData, String panNumberData,
			String addressData, String pincodeData) {
		acceptCookies.click();
		dealerNameTxtBox.sendKeys(dealerNameData);
		userNameTxtBox.sendKeys(userNameData);
		phoneNoTxtBox.sendKeys(phoneNoData);
		panNumberTxtBox.sendKeys(panNumberData);
		ab.scrollPage(driver);
		ab.waitToClickElement(driver, gstNotAvailableButton);
		gstNotAvailableButton.click();
		addressTxtBox.sendKeys(addressData);
		pincodeTxtBox.sendKeys(pincodeData);
		ab.presenceOfAllElements(driver, districts);
		ab.selectByVisibleText(custAreaDropDown, area);

	}

	public void bankDetails(String accounNoData, String ifscData, String accountHolderNameData) {
		accounNoTxtBox.sendKeys(accounNoData);
		ifscTxtBox.sendKeys(ifscData);
		ab.presenceOfSingleElement(driver, dealerBankName);
		accountHolderName.sendKeys(accountHolderNameData);
	}

	public void fileUpload(String enrollmentFormDocument, String panCardDocument, String kycDocument,
			String chequeDocument, String photoDocument, String businessProofDocument,
			String engagementLetterDocument) {

		enrollmentFormUpload.sendKeys(enrollmentFormDocument);
		panCardUpload.sendKeys(panCardDocument);
		kycUpload.sendKeys(kycDocument);
		chequeUpload.sendKeys(chequeDocument);
		photoUpload.sendKeys(photoDocument);
		businessProofUpload.sendKeys(businessProofDocument);
		engagementLetterUpload.sendKeys(engagementLetterDocument);
	}

}
