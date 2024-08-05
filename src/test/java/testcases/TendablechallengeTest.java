package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import page.ContactUsPage;
import page.HomePage;
import page.OurSolutionPage;
import page.OurStoryPage;
import page.WhyTendablePage;


public class TendablechallengeTest extends BaseClass {

	HomePage homePage;
	OurStoryPage ourStoryPage;
	OurSolutionPage ourSolutionPage;
	WhyTendablePage whyTendablePage;
	ContactUsPage contactUsPage;

	@Test(priority = 1)
	public void verifyToplevelMenu() {

		homePage = new HomePage(driver);
		ourStoryPage = new OurStoryPage(driver);
		ourSolutionPage = new OurSolutionPage(driver);
		whyTendablePage = new WhyTendablePage(driver);
		 contactUsPage=new ContactUsPage(driver);

		homePage.navigateToHomePage();
		String homePageUrl = homePage.verifyCurrentURL();
		Assert.assertEquals(homePageUrl, "https://www.tendable.com/");

		ourStoryPage.navigateOurStroyPage();
		String ourStoryUrl = ourStoryPage.verifyCurrentURL();
		Assert.assertEquals(ourStoryUrl, "https://www.tendable.com/our-story");

		String productText = ourSolutionPage.navigateOurSolutionPage();
		Assert.assertEquals(productText, "PRODUCTS");

		whyTendablePage.navigateWhyTendablePage();
		String whyTeandableUrl = whyTendablePage.verifyCurrentURL();
		Assert.assertEquals(whyTeandableUrl, "https://www.tendable.com/why-tendable");

	}

	 @Test(priority=2)
	public void verifyRequestDemo() {
		
		homePage.navigateToHomePage();
		boolean homePageResult = homePage.verifyRequsetDemoButtonIsEnabled();
		Assert.assertTrue(homePageResult);
		
		ourStoryPage.navigateOurStroyPage();
		boolean ourStoryResult = ourStoryPage.verifyRequsetDemoButtonIsEnabled();
		Assert.assertTrue(ourStoryResult);

		ourSolutionPage.navigateOurSolutionPage();
		ourSolutionPage.navigateToMobileAppPage();
		boolean ourSolutionResult = ourSolutionPage.verifyRequsetDemoButtonIsEnabled();
		Assert.assertTrue(ourSolutionResult);

		whyTendablePage.navigateWhyTendablePage();
		boolean whyTeandableResult = whyTendablePage.verifyRequsetDemoButtonIsEnabled();
		Assert.assertTrue(whyTeandableResult);
	}

	 @Test(priority = 3)
	public void verifyErrorMessage() throws InterruptedException {
		
		contactUsPage.navigateToContactUsPage();
		String errorMessage =contactUsPage.fillMarketingform();
		Assert.assertEquals(errorMessage, "This field is required");
	}

}
