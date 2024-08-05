package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class OurStoryPage extends BaseClass {
	
	public OurStoryPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[normalize-space()='Our Story']") private WebElement OurStoryButton;
	@FindBy(xpath="//a[normalize-space()='Request A Demo']") private WebElement requestDemoButton;
	public boolean verifyRequsetDemoButtonIsEnabled()
	{
		return requestDemoButton.isEnabled();
	}
	public void navigateOurStroyPage()  {
		
		OurStoryButton.click();
	}

	public String verifyCurrentURL() {
		return driver.getCurrentUrl();

	}
}
