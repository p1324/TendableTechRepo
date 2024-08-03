package testcases;

	import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

	public class TendableContactFormTest {

	    private WebDriver driver;
	    private WebDriverWait wait;

	    @BeforeMethod
	    public void setUp() {
	    
	     
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	    }

	    @Test
	    public void testContactFormSubmission() {
	        // Step 1: Open URL
	        driver.get("https://www.tendable.com/");

	        // Step 2: Go to "Contact Us"
	        WebElement contactUsLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Contact Us")));
	        contactUsLink.click();

	        // Step 3: Go to "Marketing" > "Contact"
	        WebElement marketingMenu = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Marketing")));
	        marketingMenu.click();

	        WebElement contactOption = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Contact")));
	        contactOption.click();

	        // Step 4: Fill the form without the message field
	        WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("contact-form")));

	        // Fill in other fields (example fields; update according to actual form fields)
	        WebElement nameField = form.findElement(By.name("name"));
	        nameField.sendKeys("Test User");

	        WebElement emailField = form.findElement(By.name("email"));
	        emailField.sendKeys("testuser@example.com");

	        WebElement phoneField = form.findElement(By.name("phone"));
	        phoneField.sendKeys("1234567890");

	        // Check "I agree" checkbox
	        WebElement agreeCheckbox = form.findElement(By.name("agree"));
	        if (!agreeCheckbox.isSelected()) {
	            agreeCheckbox.click();
	        }

	        // Click on "Submit"
	        WebElement submitButton = form.findElement(By.cssSelector("button[type='submit']"));
	        submitButton.click();

	        // Add assertions or checks here if needed
	    }

	    @AfterMethod
	    public void tearDown() {
	        // Close the browser
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}


