package Website;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParentSetup {
	public static WebDriver driver; 
	public static String parentWindowHandle;
	private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	@BeforeTest (alwaysRun=true)
	public static void OpenBrowser()
	{
		FirefoxOptions options = new FirefoxOptions();

		// Create a Firefox profile and set preferences for media permissions
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("media.navigator.permission.disabled", true);
		profile.setPreference("media.navigator.streams.fake", true);
		options.setProfile(profile);

		WebDriverManager.firefoxdriver().setup();

		driver = new FirefoxDriver(options);
		driver.get("https://service.1stresponse.org.uk");
		driver.manage().window().maximize();
		long time = 3000;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		parentWindowHandle = driver.getWindowHandle();
	}
	protected void switchToChildWindow()
	{
		Set<String> windowHandles = driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			if (!windowHandle.equals(parentWindowHandle)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	public static String generateRandomFilename(int length) {
		StringBuilder filename = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(CHARACTERS.length());
			char randomChar = CHARACTERS.charAt(randomIndex);
			filename.append(randomChar);
		}

		return filename.toString();
	}

	

	@AfterTest (alwaysRun=true)
	public void tearDown() {
		//Quit the WebDriver here (close the browser)
		//driver.quit();

	}

	@AfterMethod
	public void BacktoDashboard() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
	}
}
