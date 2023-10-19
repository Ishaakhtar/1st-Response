package Website;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClientTranscriptions extends ParentSetup{

	@Test 
	public void UploadAudioAndSave() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Transcriptions')]")).click();
		driver.findElement(By.cssSelector("a[class='btn btn-small button-new btn-success']")).click();
		driver.findElement(By.cssSelector("input[id='jform_document_prefix']")).sendKeys("My Recording");
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		element.sendKeys("C:\\Users\\Multi laptop 88 G\\Downloads\\066.mp3");
		driver.findElement(By.cssSelector("button[class='button-apply btn btn-success']")).click();

		By locator=By.cssSelector("div[class='alert-message']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(2000);
		WebElement Alert=driver.findElement(By.cssSelector("div[class='alert-message']"));
		Assert.assertEquals(Alert.getText(),"Transcription uploaded");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
		//BacktoDashboard();

	}

	@Test 
	public void UploadLargeAudioAndSave() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Transcriptions')]")).click();
		driver.findElement(By.cssSelector("a[class='btn btn-small button-new btn-success']")).click();
		driver.findElement(By.cssSelector("input[id='jform_document_prefix']")).sendKeys("My Recording");
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		element.sendKeys("C:\\Users\\Multi laptop 88 G\\Downloads\\002.mp3");
		driver.findElement(By.cssSelector("button[class='button-apply btn btn-success']")).click();
		WebElement Alert=driver.findElement(By.xpath("//span[contains(text(), 'File size is too big')]"));
		Assert.assertEquals(Alert.getText(),"File size is too big");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
		//BacktoDashboard();

	}

	@Test 
	public void UploadLargeAudioSaveAndClose() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Transcriptions')]")).click();
		driver.findElement(By.cssSelector("a[class='btn btn-small button-new btn-success']")).click();
		driver.findElement(By.cssSelector("input[id='jform_document_prefix']")).sendKeys("My Recording");
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		element.sendKeys("C:\\Users\\Multi laptop 88 G\\Downloads\\002.mp3");
		driver.findElement(By.cssSelector("button[class='button-save btn btn-success']")).click();
		WebElement Alert=driver.findElement(By.xpath("//span[contains(text(), 'File size is too big')]"));
		Assert.assertEquals(Alert.getText(),"File size is too big");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
		//BacktoDashboard();

	}
	@Test 
	public void UploadAudioSaveAndClose() throws InterruptedException, IOException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Transcriptions')]")).click();
		driver.findElement(By.cssSelector("a[class='btn btn-small button-new btn-success']")).click();
		driver.findElement(By.cssSelector("input[id='jform_document_prefix']")).sendKeys("My Recording");
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		element.sendKeys("C:\\Users\\Multi laptop 88 G\\Downloads\\file_example_MP3_5MG.mp3");
		driver.findElement(By.cssSelector("button[class='button-save btn btn-success']")).click();
		switchToChildWindow();
		By locator=By.cssSelector("div[class='alert-message']");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		Thread.sleep(2000);
		WebElement Alert=driver.findElement(By.cssSelector("div[class='alert-message']"));
		Assert.assertEquals(Alert.getText(),"Transcription uploaded");
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
		//BacktoDashboard();

	}

	@Test
	public void CloseButtonInTransacriptions() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Transcriptions')]")).click();
		driver.findElement(By.cssSelector("a[class='btn btn-small button-new btn-success']")).click();
		driver.findElement(By.cssSelector("button[class='button-cancel btn btn-danger']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[class='btn btn-small button-new btn-success']"));
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
	}


	@Test
	public void SaveWithoutSelectingAudio()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Transcriptions')]")).click();
		driver.findElement(By.cssSelector("a[class='btn btn-small button-new btn-success']")).click();
		driver.findElement(By.cssSelector("button[class='button-apply btn btn-success']")).click();
		WebElement Alert=driver.findElement(By.xpath("//div[@class='alert-message']"));
		System.out.print(Alert.getText());
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
	}

	@Test
	public void SaveAndCloseWithoutSelectingAudio()
	{
		driver.findElement(By.xpath("//a[contains(text(),'Transcriptions')]")).click();
		driver.findElement(By.cssSelector("a[class='btn btn-small button-new btn-success']")).click();
		driver.findElement(By.cssSelector("button[class='button-save btn btn-success']")).click();
		WebElement Alert=driver.findElement(By.xpath("//div[@class='alert-message']"));
		System.out.print(Alert.getText());
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
	}

	@Test 
	public void AddDocumentFromTranscriptions() throws InterruptedException
	{
		WebElement jobs=driver.findElement(By.xpath("//div[text()='Complete']//preceding::div[1]"));
		jobs.click();
		WebElement table = driver.findElement(By.id("transcriptionsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
		driver.findElement(By.xpath("//button[@class='btn btn-info btn-sm']")).click();
		driver.findElement(By.xpath("//a[contains(@id,'btn-upload-docs')]")).click();
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
		}
		else
		{
			System.out.println("No job exists");
		}
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();

	}

	@Test 
	public void ViewDocumentFromTranscriptions() throws InterruptedException
	{
		WebElement jobs=driver.findElement(By.xpath("//div[text()='Complete']//preceding::div[1]"));
		jobs.click();
		WebElement table = driver.findElement(By.id("transcriptionsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
		driver.findElement(By.xpath("//button[@class='btn btn-info btn-sm']")).click();
		driver.findElement(By.xpath("//a[contains(@id,'btn-view-docs')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[class='btn btn-small btn-danger']"));
		}
		else
		{
			System.out.println("No job exists");
		}
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();
	}

	@Test 
	public void FilterInProgressTranscriptions() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='col-8 p-3 rounded-right item-1-bg-content']//div[@class='h2 mt-0']")).click();

		driver.findElement(By.cssSelector("button[class='btn btn-primary f4st-btn-filter']")).click();
		Thread.sleep(2000);
		WebElement statusDropdown=driver.findElement(By.cssSelector("select[id='filter_id_job_status']"));
		statusDropdown.click();
		Select select = new Select(statusDropdown);
		select.selectByVisibleText("In Progress");
		WebElement table = driver.findElement(By.id("transcriptionsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
			List <WebElement> jobslist=driver.findElements(By.cssSelector("td:nth-child(4)"));

			for (WebElement rowStatus:jobslist)
			{
				Assert.assertEquals("In Progress", rowStatus.getText());

			}
		}

		else 
		{
			System.out.println("No job in Progress");
		}

		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();

	}

	@Test 
	public void FilterCompletedTranscriptions() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='col-8 p-3 rounded-right item-1-bg-content']//div[@class='h2 mt-0']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[class='btn btn-primary f4st-btn-filter']")).click();
		Thread.sleep(2000);
		WebElement statusDropdown=driver.findElement(By.cssSelector("select[id='filter_id_job_status']"));
		statusDropdown.click();
		Select select = new Select(statusDropdown);
		select.selectByVisibleText("Complete");
		WebElement table = driver.findElement(By.id("transcriptionsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
			List <WebElement> jobslist=driver.findElements(By.cssSelector("td:nth-child(4)"));

			for (WebElement rowStatus:jobslist)
			{
				Assert.assertEquals("Complete", rowStatus.getText());

			}
		}

		else 
		{
			System.out.println("No job is Completed");
		}

		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();

	}
	@Test 
	public void FilterQueuedTranscriptions() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='col-8 p-3 rounded-right item-1-bg-content']//div[@class='h2 mt-0']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[class='btn btn-primary f4st-btn-filter']")).click();
		Thread.sleep(2000);
		WebElement statusDropdown=driver.findElement(By.cssSelector("select[id='filter_id_job_status']"));
		statusDropdown.click();
		Select select = new Select(statusDropdown);
		select.selectByVisibleText("Queued");
		WebElement table = driver.findElement(By.id("transcriptionsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
			List <WebElement> jobslist=driver.findElements(By.cssSelector("td:nth-child(4)"));

			for (WebElement rowStatus:jobslist)
			{
				Assert.assertEquals("Queued", rowStatus.getText());

			}
		}

		else 
		{
			System.out.println("No job exists in Queue");
		}

		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();

	}

	@Test 
	public void FilterCancelledTranscriptions() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='col-8 p-3 rounded-right item-1-bg-content']//div[@class='h2 mt-0']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[class='btn btn-primary f4st-btn-filter']")).click();
		Thread.sleep(2000);
		WebElement statusDropdown=driver.findElement(By.cssSelector("select[id='filter_id_job_status']"));
		statusDropdown.click();
		Select select = new Select(statusDropdown);
		select.selectByVisibleText("Cancelled");
		WebElement table = driver.findElement(By.id("transcriptionsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
			List <WebElement> jobslist=driver.findElements(By.cssSelector("td:nth-child(4)"));

			for (WebElement rowStatus:jobslist)
			{
				Assert.assertEquals("Cancelled", rowStatus.getText());

			}
		}
		else 
		{
			System.out.println("No job exists in cancel status");
		}
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();

	}

	@Test 
	public void FilterFailedTranscriptions() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='col-8 p-3 rounded-right item-1-bg-content']//div[@class='h2 mt-0']")).click();
		//Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[class='btn btn-primary f4st-btn-filter']")).click();
		Thread.sleep(2000);
		WebElement statusDropdown=driver.findElement(By.cssSelector("select[id='filter_id_job_status']"));
		statusDropdown.click();
		Select select = new Select(statusDropdown);
		select.selectByVisibleText("Failed");
		WebElement table = driver.findElement(By.id("transcriptionsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
			List <WebElement> jobslist=driver.findElements(By.cssSelector("td:nth-child(4)"));

			for (WebElement rowStatus:jobslist)
			{
				Assert.assertEquals("Failed", rowStatus.getText());

			}
		}
		else 
		{
			System.out.println("No job exists in cancel status");
		}
		//driver.findElement(By.xpath("//a[contains(text(),'Dashboard')]")).click();

	}

	@Test (enabled=false)
	public void PlayTransacription() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[contains(text(),'Transcriptions')]")).click();
		WebElement table = driver.findElement(By.id("transcriptionsList"));
		if (table.findElements(By.tagName("tr")).size() > 1)
		{
			WebElement transcriptions=driver.findElement(By.cssSelector("tbody tr:nth-child(1) td:nth-child(3)"));
			transcriptions.click();
			 WebElement playButton = driver.findElement(By.cssSelector("audio"));
		       playButton.click();
			//((JavascriptExecutor) driver).executeScript("document.getElementsByTagName('audio')[0].play();");
			Thread.sleep(3000);
			// Check if the audio is playing
	        boolean isPlaying = (boolean) ((JavascriptExecutor) driver).executeScript("return !arguments[0].paused;",  playButton);

	        if (isPlaying) {
	            System.out.println("Audio is playing successfully.");
	        } else {
	            System.out.println("Audio playback failed.");
	        }

			//System.out.println(transcriptions);
			// Generate a random index
			/*Random random = new Random();
			int randomIndex = random.nextInt(transcriptions.size());

			// Select the element at the random index
			WebElement randomElement = transcriptions.get(randomIndex);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", randomElement);*/
			
			//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			//wait.until(ExpectedConditions.elementToBeClickable(randomElement)).click();
			// Scroll into view to the selected element
			//Actions actions = new Actions(driver);
			//actions.moveToElement(randomElement).click().perform();
			// Perform actions on the selected element (click, getText, etc.)
			//randomElement.click();
		}


		else 
		{
			System.out.println("No job exists");
		}
		
	}



}
