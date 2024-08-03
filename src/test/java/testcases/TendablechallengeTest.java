package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TendablechallengeTest {
	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.tendable.com/");
	}

	// @Test(priority=1)
	public void verifyToplevelMenu() {

		driver.findElement(By.xpath("//img[@alt='Tendable Logo']")).click();
		String homePageUrl = driver.getCurrentUrl();
		Assert.assertEquals(homePageUrl, "https://www.tendable.com/");

		driver.findElement(By.xpath("//a[normalize-space()='Our Story']")).click();
		String ourStoryUrl = driver.getCurrentUrl();
		Assert.assertEquals(ourStoryUrl, "https://www.tendable.com/our-story");

		WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Our Solution']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		String productText = driver.findElement(By.xpath("//a[normalize-space()='Products']")).getText();
		Assert.assertEquals(productText, "PRODUCTS");

		driver.findElement(By.xpath("//a[normalize-space()='Why Tendable?']")).click();
		String whyTeandableUrl = driver.getCurrentUrl();
		System.out.println(whyTeandableUrl);
		Assert.assertEquals(whyTeandableUrl, "https://www.tendable.com/why-tendable");

	}

	// @Test(priority=2)
	public void verifyRequestDemo() {
		driver.findElement(By.xpath("//img[@alt='Tendable Logo']")).click();
		boolean homePageResult = driver.findElement(By.xpath("//a[normalize-space()='Request A Demo']")).isEnabled();
		Assert.assertTrue(homePageResult);

		driver.findElement(By.xpath("//a[normalize-space()='Our Story']")).click();
		boolean ourStoryResult = driver.findElement(By.xpath("//a[normalize-space()='Request A Demo']")).isEnabled();
		Assert.assertTrue(ourStoryResult);

		WebElement element = driver.findElement(By.xpath("//a[normalize-space()='Our Solution']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.findElement(By.xpath("//a[normalize-space()='Mobile App']")).click();
		boolean ourSolutionResult = driver.findElement(By.xpath("//a[normalize-space()='Request A Demo']")).isEnabled();
		Assert.assertTrue(ourSolutionResult);

		driver.findElement(By.xpath("//a[normalize-space()='Why Tendable?']")).click();
		boolean whyTeandableResult = driver.findElement(By.xpath("//a[normalize-space()='Request A Demo']"))
				.isEnabled();
		Assert.assertTrue(whyTeandableResult);
	}

	@Test(priority = 3)
	public void verifyErrorMessage() throws InterruptedException {
		driver.findElement(By.linkText("Contact Us")).click();
		driver.findElement(By.xpath("(//button[@class='body-button bg-plain-600 toggle-control'])[1]")).click();

		driver.findElement(By.xpath("(//input[@id='form-input-fullName'])[1]")).sendKeys("Pradip Ramesh take");
		driver.findElement(
				By.xpath("//form[@id='contactMarketingPipedrive-163701']//input[@id='form-input-organisationName']"))
				.sendKeys("Infosys");
		driver.findElement(
				By.xpath("//form[@id='contactMarketingPipedrive-163701']//input[@id='form-input-cellPhone']"))
				.sendKeys("5765786876");
		driver.findElement(By.xpath("//form[@id='contactMarketingPipedrive-163701']//input[@id='form-input-email']"))
				.sendKeys("Pradip@gmail.com");
		
		Thread.sleep(5000);
		WebElement dropDown = driver.findElement(By.xpath("(//select[@id='form-input-jobRole'])[1]"));
		Select s = new Select(dropDown);
		s.selectByValue("CNO");
		
		Thread.sleep(5000);
		WebElement element = driver.findElement(
				By.xpath("//form[@id='contactMarketingPipedrive-163701']//label[contains(text(),'I Agree')]"));
		element.click();
		driver.findElement(By.xpath("//button[@data-loading-text='Loading...'][normalize-space()='Submit']")).click();
	
String errorMessage = driver.findElement(By.xpath("//li[normalize-space()='This field is required']")).getText();
	System.out.println(errorMessage);
Assert.assertEquals(errorMessage, "This field is required");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
