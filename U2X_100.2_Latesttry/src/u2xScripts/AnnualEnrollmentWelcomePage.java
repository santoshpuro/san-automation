package u2xScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import u2xVariable.U2xVariable;

public class AnnualEnrollmentWelcomePage extends U2xVariable{
	public static WebElement element = null;
	public static String popUpTitle;
	public static int a = 1;
	public static int b = 1;
	public static int q = 1;
	public static int r = 1;
	
	// wait to present Continue button on AnnualEnrollmentWelcomePage:
	public static WebElement waitForContinueButtonOnAnnualEnrollmentWelcomePage(WebDriver driver) 
	{
		    element = Utility.waitForElementAvailability_Id(driver, 20, id_ContinueButtonOnAnnualEnrollmentWelcomePage);
		    return element;		
	}	
	
    //Continue button on welcomeToOpenEnrollmentPage	
	public static WebElement continueButtonOnWelcomeToOpenEnrollmentPage(WebDriver driver)
	{
    element = driver.findElement(By.id(id_ContinueButtonOnAnnualEnrollmentWelcomePage));
    return element;
	}
	
	//Wait for cross mark present on pop up:
	public static WebElement waitForCrossButton(WebDriver driver, int time)
	{
	//wait for cross mark on Enrollment pop up:
	//in case of incomplete enrollment:
	
	try
	{
		element = Utility.waitForElementAvailability_Xpath(driver, time, xPath_incompleteEnrollment);
	}
	catch (Exception ex)
	{
		
	}
	//in case of complete enrollment:
	try
	
	{
		element = Utility.waitForElementAvailability_Xpath(driver, time, xPath_incompleteEnrollment);
	}
	
	catch (Exception ex)
	{
		
	}
	
    return element;
	}
	
	//Get values back:
	public static int clickOnPreContinueButtonOnPopup(WebDriver driver, int s, int t)
	{
		//Fetch Continue button if enrollment is not completed:
		
		try
		{
			Utility.waitForElement_ToBeClickable_Xpath(driver, 2, xPath_newHireisNotCompleted);
			logger.info("Can't proceed further as 'New Hire' event is not yet completed for this enrollee.");
			Utility.captureScreenshot(driver, "EnrollmentWelcomePage");
		}
		
		catch(Exception ex)
		{
		
		}
		
		try
		{
			Utility.waitForElement_ToBeClickable_Xpath(driver, 2, xPath_ContinueButtonOfIncompletedEnrollment);
		}

		catch(Exception ex)
		{
		s++; //2
		}


		//Fetch Continue button if enrollment is completed:
		try
		{
			Utility.waitForElement_ToBeClickable_Xpath(driver, 2, xPath_ContinueButtonOfCompletedEnrollment);

			}

		catch(Exception ex)
		{
		t++; //2
		}
		//it will return 1 for incomplete and 2 for complete
		return s;
		
	}
	
	
	
	
	//Click on Continue button on pop up:
	public static WebElement clickOnContinueButtonOnPopup(WebDriver driver, int m) throws IOException
	{

		//Continue button if enrollment is not completed:
		if (m==1)

		{
		element = driver.findElement(By.xpath(xPath_ContinueButtonOfIncompletedEnrollment));
		
		}

		//Continue button if enrollment is completed:
		if (m==2)
		{
		element = driver.findElement(By.xpath(xPath_ContinueButtonOfCompletedEnrollment));
		}
		return element;
		}
	
	}
	

