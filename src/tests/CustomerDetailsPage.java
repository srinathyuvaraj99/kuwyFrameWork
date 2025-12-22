package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PageObjectModel.CustomerDetails;
import PageObjectModel.MainPage;
import base.BaseClass;
import base.DriverManager;
import utils.ExcelData;
import utils.PojoClass;
import utils.RetryAnalyser; 

public class CustomerDetailsPage extends BaseClass {
	// WebDriver driver;
	@Test(dataProvider = "userData", dataProviderClass = ExcelData.class, retryAnalyzer = RetryAnalyser.class)
	public void userLogin(PojoClass details) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = DriverManager.getDriver();
		// context.setAttribute("driver", driver);
		CustomerDetails cd = new CustomerDetails(driver);
		MainPage mp = new MainPage(driver);
		cd.otherOptionsSelection();
		mp.personalDetails(details.dealerNameTxtBox, details.userNameTxtBox, details.phoneNoTxtBox,
				details.panNumberTxtBox, details.addressTxtBox, details.pincodeTxtBox);
		mp.bankDetails(details.accounNoTxtBox, details.ifscTxtBox, details.accountHolderName);
		mp.fileUpload(details.enrollmentFormUpload, details.panCardUpload, details.kycUpload,
				details.chequeUpload, details.photoUpload,
				details.businessProofUpload, details.engagementLetterUpload);

	}

}
