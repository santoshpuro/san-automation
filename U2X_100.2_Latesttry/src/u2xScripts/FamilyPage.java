package u2xScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import u2xVariable.U2xVariable;

public class FamilyPage extends U2xVariable {

	public static WebElement element;
	
    
    
	public static WebElement familyPageFunctionalities(WebDriver driver) throws InterruptedException, IOException 
	{
			//Wait for dependents record count to be appeared on Family page:	
		
			try
			{
				Utility.waitForElement_ToBeClickable_Xpath(driver, 30, xPath_dependentsRecordCount); 
			}
		    catch (Exception ex)
		    {
		    	Utility.captureScreenshot(driver, "FamilyPage");
		    }
	
	
	//Check if there is at least one dependent available else add 1 spouse as dependent:
	//Check dependent:
		int g = 1;
	try 
	{
		//Check if there is already atleast one dependent available on the Family screen:
		element = driver.findElement(By.xpath(xPath_DependentCheck));
		g++;// g = 2,  if there is already atleast one dependent else g=1.
	}
	
	
	catch(Exception ex)
	{
		//click on add person
		driver.findElement(By.id(id_AddPersonButton)).click();
		
		//wait to load relationship section:
	    element = Utility.waitForElementAvailability_Id(driver, 30, Id_RelationshipType);
		//Enter Relationship Begin Date:
	    try
	    {
		element = driver.findElement(By.id(Id_RelationshipBeginDate));
		element.click();
		element.sendKeys(relationshipBeginDate);
	    }
	    catch(Exception ex1)
	    {
	    	
	    }
		//Enter first name:
		element = driver.findElement(By.id(id_DependentFirstName));
		element.click();
		element.sendKeys(dependentFirstName );
		//Enter last name:
		element = driver.findElement(By.id(id_DependentLastName));
		element.click();
		element.sendKeys(dependentLastName);
		//Enter Date of Birth:
		element = driver.findElement(By.id(id_DependentDOB));
		element.click();
		element.sendKeys(dependentDOB);
		//Select Gender:
		element = driver.findElement(By.id(id_Gender));
		element.click();
		//select relationship:
		Select select = new Select(driver.findElement(By.id(id_Relationship)));
		select.selectByVisibleText("Spouse");
		//Click on Save button:
		driver.findElement(By.xpath(xPath_SaveButton)).click();
	}
	
	if (g==1) // if no dependent was there:
	{
		try
		{
				//wait for dropdown value on pop up:
			    Utility.waitForElementAvailability_Xpath(driver, 7, xPath_DependentAttestationQuestionnaireDropdown);		
			  //Select dropdown value on pop up:
				Select select = new Select(driver.findElement(By.xpath(xPath_DependentAttestationQuestionnaireDropdown)));
				select.selectByVisibleText(DependentAttestationQuestionnaireDropdownValue);
				//Click on Continue button:
				element = driver.findElement(By.id(iD_DependentAttestationQuestionnaireContinueButton));
				element.click();
		}
		catch (Exception ex)
		{
		}
		
		try
		{
			// Wait for confirmation pop up OK button:
		    element = Utility.waitForElementAvailability_Id(driver, 300, iD_PopupOkButton);	
		}
		catch (Exception ex)
		{
		}  		
				//click on confirmation pop up OK button
				element = driver.findElement(By.id(iD_PopupOkButton));		
				element.click();
				
			}
		
			
		  //  click on Continue button on Family page:
				element = driver.findElement(By.id(id_ContinueButtonOnFamilyPage));
				element.click();
				
				//in case if pop up message gender specification:
		
				try
				{
					driver.findElement(By.id("closeBtn"));
					logger.info("Gender is not specified for the dependent");
		    		  Utility.captureScreenshot(driver, "FamilyPage");
				}
				
				catch (Exception ex)
				{
					
				}
				
		return element;
	}
}