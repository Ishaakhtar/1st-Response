package Website;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StaffTranscriptions extends ParentSetup{

	@Test
	public void AcceptJob() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Opportunities')]")).click();
		WebElement table = driver.findElement(By.id("jobsOpportunitiesList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
			driver.findElement(By.xpath("//a[contains(@id,'btn-accept-jobs')]")).click();
			Thread.sleep(1000);
			WebElement successMessage=driver.findElement(By.xpath("//div[@class='alert-message']"));
			Assert.assertEquals(successMessage.getText(),"Job is now marked as accepted");

		}
		else
		{
			System.out.println("No job pending to be accepted");
		}
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
	}

	@Test
	public void DeclineJob() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[text()='In Progress']//preceding::div[1]")).click();
		//jobs.click();
		WebElement table = driver.findElement(By.id("jobsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
			driver.findElement(By.xpath("//button[contains(@id,'dropdownMenuButton')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(@id,'btn-cancel-jobs')]")).click();
			Thread.sleep(1000);
			WebElement successMessage=driver.findElement(By.xpath("//div[@class='alert-message']"));
			Assert.assertEquals(successMessage.getText(),"Job is now marked as declined");
		}
		else
		{
			System.out.println("No job in progress");
		}
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();


	}

	@Test
	public void CompleteJob() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[text()='In Progress']//preceding::div[1]")).click();
		//jobs.click();
		WebElement table = driver.findElement(By.id("jobsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
			driver.findElement(By.xpath("//button[contains(@id,'dropdownMenuButton')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(@id,'btn-complete-jobs')]")).click();
			Thread.sleep(1000);
			WebElement successMessage=driver.findElement(By.xpath("//div[@class='alert-message']"));
			Assert.assertEquals(successMessage.getText(),"Job is now marked as complete");
		}
		else
		{
			System.out.println("No job in progress");
		}
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();

	}



}
