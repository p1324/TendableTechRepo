package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class WhyTendablePage extends BaseClass {
public WhyTendablePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[normalize-space()='Why Tendable?']") private WebElement whyTendableButton;
	@FindBy(xpath="//a[normalize-space()='Request A Demo']") private WebElement requestDemoButton;
	public boolean verifyRequsetDemoButtonIsEnabled()
	{
		return requestDemoButton.isEnabled();
	}
	public void navigateWhyTendablePage()  {
		
		whyTendableButton.click();
	}

	public String verifyCurrentURL() {
		return driver.getCurrentUrl();

	}
}
