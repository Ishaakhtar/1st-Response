package Website;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StaffDashboard extends ParentSetup{
	@Test (priority=1, enabled=true)
	public void VerifyAllJobsCount()
	{
		WebElement jobs=driver.findElement(By.xpath("//div[@class='col-8 p-3 rounded-right item-1-bg-content']//div[@class='h2 mt-0']"));
		int dbJobsCount=Integer.parseInt(jobs.getText());
		jobs.click();
		WebElement table = driver.findElement(By.id("jobsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
			
			switchToChildWindow();
			List <WebElement> rows=driver.findElements(By.cssSelector("td[class='center']"));
			int jobsPageCount=rows.size();
			Assert.assertEquals(jobsPageCount,dbJobsCount);
			//driver.navigate().back();
		}

		else
		{
			System.out.println("No Job exist");
		}

	}

	@Test (priority=2)
	public void VerifyCompleteJobsCount()
	{
		WebElement jobs=driver.findElement(By.xpath("//div[text()='Complete']//preceding::div[1]"));
		int dbJobsCount=Integer.parseInt(jobs.getText());
		jobs.click();
		WebElement table = driver.findElement(By.id("jobsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
			
			switchToChildWindow();
			List <WebElement> rows=driver.findElements(By.cssSelector("td[class='center']"));
			int jobsPageCount=rows.size();
			Assert.assertEquals(jobsPageCount,dbJobsCount);
			//driver.navigate().back();
		}

		else
		{
			System.out.println("No Job is Completed");
		}

	}

	@Test (priority=3)
	public void VerifyInProgressJobsCount()
	{
		WebElement jobs=driver.findElement(By.xpath("//div[text()='In Progress']//preceding::div[1]"));
		int dbJobsCount=Integer.parseInt(jobs.getText());
		jobs.click();
		WebElement table = driver.findElement(By.id("jobsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
			
			switchToChildWindow();
			List <WebElement> rows=driver.findElements(By.cssSelector("td[class='center']"));
			int jobsPageCount=rows.size();
			Assert.assertEquals(jobsPageCount,dbJobsCount);
			//driver.navigate().back();
		}

		else
		{
			System.out.println("No Job in Progress");
		}

	}
	
	@Test (enabled=true,priority=4)
	public void VerifyJobsWaitingCount()
	{
		WebElement jobs=driver.findElement(By.xpath("//div[text()='Jobs Waiting']//preceding::div[1]"));
		int dbJobsCount=Integer.parseInt(jobs.getText());
		jobs.click();
		WebElement table = driver.findElement(By.id("jobsOpportunitiesList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{

			List <WebElement> rows=driver.findElements(By.xpath("//td[contains(@class,'center')]"));
			int jobsPageCount=rows.size();
			Assert.assertEquals(jobsPageCount,dbJobsCount);
			//driver.navigate().back();
		}

		else
		{
			System.out.println("No Document exists");
		}

	}
	
	@Test (priority=5)
	public void VerifyCompletedJobsStatus()
	{
		WebElement jobs=driver.findElement(By.xpath("//div[text()='Complete']//preceding::div[1]"));
		jobs.click();
		WebElement table = driver.findElement(By.id("jobsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
			switchToChildWindow();
			List <WebElement> status=driver.findElements(By.cssSelector("td:nth-child(4)"));
			System.out.println("Total Jobs found: "+status.size());
			for (WebElement rowStatus:status)
			{
				Assert.assertEquals("Complete", rowStatus.getText());
				
			}
			//driver.navigate().back();
		}
		else 
		{
			System.out.println("No Job is completed");
		}
	}
	
	@Test (priority=6)
	public void VerifyInProgressJobsStatus()
	{
		WebElement jobs=driver.findElement(By.xpath("//div[text()='In Progress']//preceding::div[1]"));
		jobs.click();
		WebElement table = driver.findElement(By.id("jobsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{	
			switchToChildWindow();
			List <WebElement> status=driver.findElements(By.cssSelector("td:nth-child(4)"));
			System.out.println("Total Jobs found: "+status.size());
			for (WebElement rowStatus:status)
			{
				Assert.assertEquals("In Progress", rowStatus.getText());
				
			}
			//driver.navigate().back();
		}
		else 
		{
			System.out.println("No Job in Progress");
		}
	}
	
	

}
