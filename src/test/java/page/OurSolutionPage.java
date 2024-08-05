package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class OurSolutionPage extends BaseClass {
public OurSolutionPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[normalize-space()='Our Solution']") private WebElement ourSolutionButton;
	@FindBy(xpath="//a[normalize-space()='Request A Demo']") private WebElement requestDemoButton;
	@FindBy(xpath="//a[normalize-space()='Mobile App']") private WebElement mobileAppButton;
	public boolean verifyRequsetDemoButtonIsEnabled()
	{
		return requestDemoButton.isEnabled();
	}
	public String navigateOurSolutionPage()  {
		Actions action = new Actions(driver);
		action.moveToElement(ourSolutionButton).build().perform();
		String productText = driver.findElement(By.xpath("//a[normalize-space()='Products']")).getText();
		return productText;
	}

	public void navigateToMobileAppPage()
	{
		mobileAppButton.click();
	}
	
	public String verifyCurrentURL() {
		return driver.getCurrentUrl();

	}
}
