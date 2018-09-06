package u2xScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import u2xVariable.U2xVariable;

public class EmployeeLookUp extends U2xVariable{
	
	public static WebElement element = null;
	public static Select select = null;
	
	//U ID:
	public static WebElement employeeLookUpFunctionalities(WebDriver driver, String xId_uId, String xid_reasonCode, String xId_Lookupbtn, String id_EnrolleeNameHyperlink)
	{
	element = driver.findElement(By.id(xId_uId));
	element.sendKeys(uId);
    logger.info("Enter U ID");

	//Reason code:
		select = new Select(driver.findElement(By.id(xid_reasonCode )));
		select.selectByVisibleText(reasonCode);
        logger.info("Select Reason Code");

		
	//Look up button:
			element = driver.findElement(By.id(xId_Lookupbtn));
			element.click();
	        logger.info("Click on LookUp button");

	      //Wait for the enrollee name hyperlink:     
	        Utility.waitForElementAvailability_Xpath(driver, 20, id_EnrolleeNameHyperlink);
	
	//Click on Enrollee Name Hyperlink:
		element = driver.findElement(By.xpath(id_EnrolleeNameHyperlink));
	    JavascriptExecutor executor = (JavascriptExecutor) driver;	
	    executor.executeScript("arguments[0].click();", element);
        logger.info("Click on Employee Name");
		return element;
	}
	}

