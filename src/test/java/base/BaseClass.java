package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import utilities.ReadConfig;

public class BaseClass {
	ReadConfig readConfig = new ReadConfig();

	String url = readConfig.getBaseURL();
	String browser = readConfig.getBrowser();

	public static WebDriver driver;
	

	@BeforeClass
	public void setUp() {
		if (browser.equals("chrome")) {
			
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(05));
		driver.get(url);		
	}

	@AfterClass
	public void tearDown() {
		//driver.close();
		driver.quit();
	}
}
