package u2xScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import u2xVariable.U2xVariable;

public class PersonalPage extends U2xVariable {
	
	public static WebElement element;
	
    //Wait for 'Personal' title on Personal Page: 
	public static WebElement contactPageFunctions(WebDriver driver) throws IOException
	{
		WebDriverWait wait=new WebDriverWait(driver, 300);
	    @SuppressWarnings("unused")
		WebElement waitForContinueButton;
	    waitForContinueButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath_PersonalTitle)));

	
//Click on Continue button on Personal page:
	    try
	    {
		element = driver.findElement(By.xpath(xPath_ContinueButtonOnPersonalPage));
		element.click();
	    }
	    catch (Exception ex)
	    {
	    	 Utility.captureScreenshot(driver, "PersonalPage");
	    }
	    
		return element;
	}
}	
