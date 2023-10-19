package Website;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommonFunctionalities extends ParentSetup{

	@Test
	public void FacebookLink() throws InterruptedException
	{
		driver.findElement(By.cssSelector("a[class='pathway'] ")).click();
		driver.findElement(By.xpath("//i[@class='fab fa-facebook-f']")).click();
		switchToChildWindow();
		Thread.sleep(2000);
		String facebook=driver.getTitle();
		Assert.assertEquals(facebook,"Facebook – log in or sign up");
		driver.navigate().back();
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
		
		
	}
	
	@Test
	public void TwitterLink() throws InterruptedException
	{
		driver.findElement(By.cssSelector("a[class='pathway'] ")).click();
		driver.findElement(By.xpath("//i[@class='fab fa-twitter']")).click();
		switchToChildWindow();
		Thread.sleep(2000);
		String title=driver.getTitle();
		Assert.assertEquals(title,"X. It’s what’s happening / X");
		driver.navigate().back();
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
		
		
	}
	
	@Test
	public void ChangePasswordInvalid() throws InterruptedException
	{
		WebElement dropdown=driver.findElement(By.xpath("//span[@class='hidden-xs']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", dropdown);
		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='jform_password1']")).sendKeys("abcd");
		driver.findElement(By.xpath("//input[@id='jform_password2']")).sendKeys("abcd");
		WebElement saveBtn=driver.findElement(By.cssSelector("button[value='profile.save']"));
		executor.executeScript("arguments[0].click();", saveBtn);
		//driver.findElement(By.cssSelector("button[value='profile.save']")).click();
		Thread.sleep(1000);
		WebElement error=driver.findElement(By.xpath("(//div[@class='alert-message'])[1]"));
		Assert.assertEquals(error.getText(),"Password is too short. Passwords must have at least 12 characters.");
		//Password is too short. Passwords must have at least 12 characters.
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
	}
	
	@Test
	public void ChangePassword() throws InterruptedException
	{
		WebElement dropdown=driver.findElement(By.xpath("//span[@class='hidden-xs']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", dropdown);
		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='jform_password1']")).sendKeys("abcd12345678");
		driver.findElement(By.xpath("//input[@id='jform_password2']")).sendKeys("abcd12345678");
		WebElement saveBtn=driver.findElement(By.cssSelector("button[value='profile.save']"));
		executor.executeScript("arguments[0].click();", saveBtn);
		//driver.findElement(By.cssSelector("button[value='profile.save']")).click();
		Thread.sleep(1000);
		WebElement alert=driver.findElement(By.xpath("(//div[@class='alert-message'])[1]"));
		Assert.assertEquals(alert.getText(),"Profile saved.");
		//Password is too short. Passwords must have at least 12 characters.
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
	}
	
	@Test (enabled=false, priority=7)
	public void CheckTitleIsMandatoryForTicket() throws InterruptedException
	{
		/*WebElement dropdown=driver.findElement(By.xpath("//span[@class='hidden-xs']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", dropdown);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement support=driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]"));
		js.executeScript("arguments[0].click();", support);*/
		Thread.sleep(5000);
		WebElement dropdown=driver.findElement(By.xpath("//span[@class='hidden-xs']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", dropdown);
		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]")).click();
		//switchToChildWindow();
		WebElement message=driver.findElement(By.xpath("//textarea[@id='jform_csMessage']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", message);
		//message.click();
		message.sendKeys("Test Message");
		WebElement Submit=driver.findElement(By.id("btnSubmitContactSupport"));
		Submit.click();
		//js.executeScript("arguments[0].click();", Submit);
		WebElement error=driver.findElement(By.id("jform_csTitle-error"));
		Assert.assertEquals(error.getText(),"Please add a title");
		Thread.sleep(2000);
		driver.findElement(By.xpath(" //button[@data-bs-dismiss='modal'][text()='Close']")).click();
		
	}
	
	@Test(enabled=false, priority=7)
	public void CheckMessageIsMandatoryforTicket()throws InterruptedException
	{
		/*WebElement dropdown=driver.findElement(By.xpath("//span[@class='hidden-xs']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", dropdown);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement support=driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]"));
		js.executeScript("arguments[0].click();", support);
		switchToChildWindow();*/
		Thread.sleep(5000);
		WebElement dropdown=driver.findElement(By.xpath("//span[@class='hidden-xs']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", dropdown);
		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]")).click();
		driver.findElement(By.id("jform_csTitle")).sendKeys("Username");
		driver.findElement(By.id("btnSubmitContactSupport")).click();
		WebElement error=driver.findElement(By.id("jform_csMessage-error"));
		Assert.assertEquals(error.getText(),"Please add your message");
		Thread.sleep(1000);
		driver.findElement(By.xpath(" //button[@data-bs-dismiss='modal'][text()='Close']")).click();
		
	}
	
	
	@Test(enabled=true, priority=9)
	public void SubmitTicketWithoutTitleAndMessage()throws InterruptedException
	{
	
		Thread.sleep(5000);
		WebElement dropdown=driver.findElement(By.xpath("//span[@class='hidden-xs']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", dropdown);
		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]")).click();
		driver.findElement(By.id("btnSubmitContactSupport")).click();
		WebElement errorTitle=driver.findElement(By.id("jform_csTitle-error"));
		WebElement errorMessage=driver.findElement(By.id("jform_csMessage-error"));
		Assert.assertEquals(errorTitle.getText(),"Please add a title");
		Assert.assertEquals(errorMessage.getText(),"Please add your message");
		Thread.sleep(2000);
		driver.findElement(By.xpath(" //button[@data-bs-dismiss='modal'][text()='Close']")).click();
		Thread.sleep(2000);
	}
	
	@Test(enabled=true, priority=10)
	public void SubmitTicketSuccessfully()throws InterruptedException
	{
		/*WebElement dropdown=driver.findElement(By.xpath("//span[@class='hidden-xs']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", dropdown);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		WebElement support=driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]"));
		switchToChildWindow();
		js.executeScript("arguments[0].click();", support);*/
		Thread.sleep(3000);
		WebElement dropdown=driver.findElement(By.xpath("//span[@class='hidden-xs']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", dropdown);
		driver.findElement(By.xpath("(//a[@class='dropdown-item'])[2]")).click();
		driver.findElement(By.id("jform_csTitle")).sendKeys("Test User");
		driver.findElement(By.id("jform_csMessage")).sendKeys("Test Message");
		Thread.sleep(2000);
		driver.findElement(By.id("btnSubmitContactSupport")).click();
		String successMessage=driver.findElement(By.xpath("//div[@id='appspanel-alertWrapper']")).getText();
		Assert.assertEquals(successMessage,"You support request has been sent.");
		Thread.sleep(5000);
		//driver.findElement(By.xpath(" //button[@data-bs-dismiss='modal'][text()='Close']")).click();
	}
	
	
}
