package Website;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Templates extends ParentSetup{

	@Test
	public void UploadDocument() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Templates')]")).click();
		driver.findElement(By.cssSelector("button[class='button-new btn btn-success']")).click();
		String filename=generateRandomFilename(10);
		driver.findElement(By.cssSelector("input[id='jform_filename']")).sendKeys(filename);
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		element.sendKeys("C:\\Users\\Multi laptop 88 G\\Desktop\\GTFN.docx");
		driver.findElement(By.cssSelector("button[class='button-save btn btn-success']")).click();
		//driver.navigate().back();
		By locator=By.cssSelector("div[class='alert-message']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(2000);
		WebElement Alert=driver.findElement(By.cssSelector("div[class='alert-message']"));
		Assert.assertEquals(Alert.getText(),"File Uploaded");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
		
	}
	
	@Test
	public void UploadDocumentWithoutName() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Templates')]")).click();
		driver.findElement(By.cssSelector("button[class='button-new btn btn-success']")).click();
		//driver.findElement(By.cssSelector("input[id='jform_filename']")).sendKeys("My Document");
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		element.sendKeys("C:\\Users\\Multi laptop 88 G\\Desktop\\GTFN.docx");
		driver.findElement(By.cssSelector("button[class='button-save btn btn-success']")).click();
		//driver.navigate().back();
		WebElement Alert=driver.findElement(By.cssSelector("div[class='alert-message']"));
		System.out.println(Alert.getText());
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
		
	}
}
