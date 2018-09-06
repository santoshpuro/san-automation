package u2xScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import u2xVariable.U2xVariable;

public class ContactPage extends U2xVariable {
	public static WebElement element;
	
	public static WebElement contactPageFunctions (WebDriver driver) throws IOException
	{
	//Wait to present 'Other' email address:
	
	try
	{
	Utility.waitForElement_ToBeClickable_Id(driver, 30, id_OtherEmailAddressText);
	
	 logger.info("Contact page launched successfully");
	}
    catch (Exception ex)
    {
    	//logger.info("Contact tab not identified");
    	//Utility.captureScreenshot(driver, "ContactPage");
    }
	
	

        //Clear 'Personal' email address text box:
        element = driver.findElement(By.id("txtPersonalEMail"));
        element.clear();
    	//Clear and enter'Other' email address text box:
		element = driver.findElement(By.id(id_OtherEmailAddressText));
		element.clear();
		element.sendKeys(emailaddress);
	
	//'Other' email address radio button:
	
		element = driver.findElement(By.id(id_OtherEmailAddressRb));
		element.click();
	
   //'Other' Phone number text box:

		element = driver.findElement(By.id(id_OtherPhoneNumberText));
		element.clear();
		element.sendKeys(phoneNumber);
		
	//Radio button for 'Other' Phone number:
	
    element = driver.findElement(By.id(id_OtherPhoneNumberRb));
    element.click();
	
	
    //'No' radio button for disclaimer:
	
    element = driver.findElement(By.id(id_disclaimerRb));
    element.click();


    //Continue button on Contact page:
	
    element = driver.findElement(By.id(id_ContinueButtonOnContactpage));  
    element.click();
    return element;
	
	}
}
