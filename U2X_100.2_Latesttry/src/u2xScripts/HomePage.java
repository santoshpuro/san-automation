package u2xScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import u2xVariable.U2xVariable;

public class HomePage extends U2xVariable {
	public static WebElement element = null;
	public static int m = 1;
	public static int n = 1;
	public static int p = 1;
	
	
	//Wait for 'Back to Look Up' link to be clickable:
	public static void waitForBackToLookUpLink(WebDriver driver, int time, String id_BacktoLookUpLinkString)
	{
		WebDriverWait wait=new WebDriverWait(driver, time);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id_BacktoLookUpLink)));
	    return;
		}
	
	//Admin Panel links:
	public static WebElement clickOnAnnualEnrollmentLink(WebDriver driver, String xPath_AdminPanelAELink, String xPath_PromoAeLink, String xPath_DotLink)
	{
		int m = 1;
		int n = 1;
		int p = 1;

		//Fetch Admin Panel AE link:
		try 
		{

		element = driver.findElement(By.xpath(xPath_AdminPanelAELink));
		n++; //2
		p++; //2
		}

		catch (Exception ex)
		{
		m++; // 2
		}


		//Fatch Promo AE link:
		try 
		{

		element = driver.findElement(By.xpath(xPath_PromoAeLink));
		}

		catch (Exception ex) 
		{
		n++; // 2
		}

		//Fatch dot link:
		try 
		{

		element = driver.findElement(By.xpath(xPath_DotLink));
		}

		catch (Exception ex) 
		{
		p++; // 2
		}


		// Admin Panel AE link
		if (m==1) {
			element =driver.findElement(By.xpath(xPath_AdminPanelAELink));
		}

		//Promo AE link:
		if (n==1)

		{
		try {
				element =driver.findElement(By.xpath(xPath_PromoAeLink));
				//element.click();
		}
		catch (Exception ex)  {
		}

		}

		//Dot link:
		if (p==1)

		{
		try
		{
			element =driver.findElement(By.xpath(xPath_DotLink));
		}
		catch (Exception ex) 
		{
		}
		//Click on dot link
		element.click();
		//Click on AE Promo link:
		element = driver.findElement(By.xpath(xPath_PromoAeLink));
    
	}
		//For EBX 'Continue' button on HOmepage in place of Annual Enrollment link:
		try
		{
			element = driver.findElement(By.xpath("//button[@id = 'btnVBXContinue'][@data-callee-name='homepage']"));

		}
		
		catch (Exception ex)
		{
		}
		
		//For NEWEBX 'Continue' button on HOmepage in place of Annual Enrollment link:
		try
		{
			element = driver.findElement(By.id("btnNewVBXContinue"));

		}
		
		catch (Exception ex)
		{
		}
		
    	//For Self Service (U2X, click on the Annual Enrollment link:
		try
		{
			element = driver.findElement(By.xpath("//*[@id='ulSlider']/li[2]/div[2]/a"));
		}
		catch(Exception ex) 
		{

		}
		
		return element;
		
		
	}	
//Click on Life Event link:
	public static WebElement clickOnLifeEvent(WebDriver driver)
	{
		element = driver.findElement(By.id(id_LifeEventLinkOnHomePage));
		element.click();
		return element;
	}


}
