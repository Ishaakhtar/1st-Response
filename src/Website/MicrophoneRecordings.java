package Website;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MicrophoneRecordings extends ParentSetup{

	@Test
	public void RecordStopAndUpload() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Transcriptions')]")).click();
		driver.findElement(By.cssSelector("a[class='btn btn-small button-new btn-info']")).click();
		//By locator=By.cssSelector("button[class='btn btn-primary is-primary']");
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		//wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='record']")).click();
		//driver.findElement(By.cssSelector("a[id='record']")).click();
		Thread.sleep(9000);
		driver.findElement(By.cssSelector("button[class='btn btn-danger']")).click();
		String filename=generateRandomFilename(10);
		driver.findElement(By.cssSelector("input[id='jform_filename']")).sendKeys(filename);
		driver.findElement(By.xpath("//button[@id='upload-mic-recording']")).click();
		By locator=By.xpath("//span[contains(text(), 'File Uploaded')]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement successMessage=driver.findElement(By.xpath("//span[contains(text(), 'File Uploaded')]"));
		Assert.assertEquals(successMessage.getText(),"File Uploaded");
		driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
		
		
	}
	@Test
	public void RecordAndUploadWithoutName() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Transcriptions')]")).click();
		driver.findElement(By.cssSelector("a[class='btn btn-small button-new btn-info']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='record']")).click();
		//driver.findElement(By.cssSelector("a[id='record']")).click();
		Thread.sleep(9000);
		driver.findElement(By.cssSelector("button[class='btn btn-danger']")).click();
		//String filename=generateRandomFilename(10);
		//driver.findElement(By.cssSelector("input[id='jform_filename']")).sendKeys(filename);
		driver.findElement(By.xpath("//button[@id='upload-mic-recording']")).click();
		By locator=By.xpath("//span[contains(text(), 'Please')]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement successMessage=driver.findElement(By.xpath("//span[contains(text(), 'Please check form')]"));
		Assert.assertEquals(successMessage.getText(),"Please check form if filled in");
		driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
		
		
	}
	@Test
	public void RecordAndPause() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Transcriptions')]")).click();
		driver.findElement(By.cssSelector("a[class='btn btn-small button-new btn-info']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='record']")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("button[class='btn btn-secondary']")).click();
		WebElement PauseMessage=driver.findElement(By.id("rec-paused"));
		Assert.assertTrue(PauseMessage.getText().contains("PAUSED"));
		driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
	}
	
	@Test
	public void RecordPauseResumeStopAndUpload() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Transcriptions')]")).click();
		driver.findElement(By.cssSelector("a[class='btn btn-small button-new btn-info']")).click();
		Thread.sleep(3000);
		//Record
		driver.findElement(By.xpath("//button[@id='record']")).click();
		Thread.sleep(5000);
		//Pause
		driver.findElement(By.cssSelector("button[class='btn btn-secondary']")).click();
		Thread.sleep(3000);
		//Resume
		driver.findElement(By.xpath("//button[@id='resume']")).click();
		Thread.sleep(3000);
		//Stop
		driver.findElement(By.cssSelector("button[class='btn btn-danger']")).click();
		String filename=generateRandomFilename(10);
		driver.findElement(By.cssSelector("input[id='jform_filename']")).sendKeys(filename);
		//Upload
		driver.findElement(By.xpath("//button[@id='upload-mic-recording']")).click();
		By locator=By.xpath("//span[contains(text(), 'File Uploaded')]");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		WebElement successMessage=driver.findElement(By.xpath("//span[contains(text(), 'File Uploaded')]"));
		Assert.assertEquals(successMessage.getText(),"File Uploaded");
		driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
	}
}
