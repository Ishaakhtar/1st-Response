package Website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Login extends ParentSetup{

	
	@Test (alwaysRun=true, priority=0)
	public void ClientLogin()
	{
		driver.findElement(By.cssSelector("a[href='/login']")).click();
		switchToChildWindow();
		//driver.findElement(By.id("username")).sendKeys("1st_ClientA");
		//driver.findElement(By.id("password")).sendKeys("FgFWB#na2c$X95&s");
		driver.findElement(By.id("username")).sendKeys("1st_ClientB");
		driver.findElement(By.id("password")).sendKeys("abcd12345678");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
	}
	
	@Test (priority=0)
	public void StaffLogin()
	{
		driver.findElement(By.cssSelector("a[href='/login']")).click();
		switchToChildWindow();
		//driver.findElement(By.id("username")).sendKeys("1st_ClientA");
		//driver.findElement(By.id("password")).sendKeys("FgFWB#na2c$X95&s");
		driver.findElement(By.id("username")).sendKeys("1st_Staff2");
		driver.findElement(By.id("password")).sendKeys("abcd12345678");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		
	}
	
	@AfterTest
	public void Logout() throws InterruptedException
	{

		driver.findElement(By.xpath("//span[@class='hidden-xs']")).click();
		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[3]")).click();
		Thread.sleep(5000);
		WebElement logoutAlert=driver.findElement(By.xpath("(//div[@class='alert-message'])[1]"));
		Assert.assertEquals(logoutAlert.getText(),"You have been logged out.");
	}
}
