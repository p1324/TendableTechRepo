package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BaseClass;

public class ContactUsPage extends BaseClass {

	public ContactUsPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Contact Us")
	private WebElement ContactUsPageButton;
	@FindBy(xpath = "//a[normalize-space()='Request A Demo']")
	private WebElement requestDemoButton;
	@FindBy(xpath = "(//button[@class='body-button bg-plain-600 toggle-control'])[1]")
	private WebElement marketingButton;

	@FindBy(xpath = "(//input[@id='form-input-fullName'])[1]")
	private WebElement fullNameTxtBox;
	@FindBy(xpath = "//form[@id='contactMarketingPipedrive-163701']//input[@id='form-input-organisationName']")
	private WebElement organisationNameTxtBox;
	@FindBy(xpath = "//form[@id='contactMarketingPipedrive-163701']//input[@id='form-input-cellPhone']")
	private WebElement phoneNumberTxtBox;
	@FindBy(xpath = "//form[@id='contactMarketingPipedrive-163701']//input[@id='form-input-email']")
	private WebElement emailTxtBox;

	@FindBy(xpath = "(//select[@id='form-input-jobRole'])[1]")
	private WebElement jobRoleDropDown;
	@FindBy(xpath = "//form[@id='contactMarketingPipedrive-163701']//label[contains(text(),'I Agree')]")
	private WebElement iAgreeRadioButton;
	@FindBy(xpath = "//button[@data-loading-text='Loading...'][normalize-space()='Submit']")
	private WebElement submitButton;
	@FindBy(xpath = "//li[normalize-space()='This field is required']")
	private WebElement errorMessage;

	public boolean verifyRequsetDemoButtonIsEnabled() {
		return requestDemoButton.isEnabled();
	}

	public void navigateToContactUsPage() {

		ContactUsPageButton.click();
	}

	public String fillMarketingform() throws InterruptedException {

		marketingButton.click();
		fullNameTxtBox.sendKeys("Chetan Shinde");
		organisationNameTxtBox.sendKeys("Infosys");
		phoneNumberTxtBox.sendKeys("9878675645");
		emailTxtBox.sendKeys("chetan1232@gmail.com");
		Thread.sleep(10000);

		Select select = new Select(jobRoleDropDown);
		select.selectByValue("CNO");
		

		iAgreeRadioButton.click();
		submitButton.click();
		return errorMessage.getText();
	}

}
