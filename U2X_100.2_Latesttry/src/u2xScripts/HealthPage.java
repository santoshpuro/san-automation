package u2xScripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import u2xVariable.U2xVariable;

public class HealthPage extends U2xVariable {
	public static WebElement element;
	public static Select sel;
	
	
	//Wait to present 'Health' question dropdown:

	public static WebElement healthFunctions(WebDriver driver) throws IOException
	{
		try
		{
			//Find Health title at top:
			//driver.findElement(By.xpath("//div[1]/div[1]/ul/li[5]/span[1]"));
			driver.findElement(By.id(id_health));
		    element = Utility.waitForElementAvailability_Xpath(driver, 120, xPath_healthQuestionDropdown);
		}
	    catch (Exception ex)
	    {
	    	//Utility.captureScreenshot(driver, "HealthPage");
	    	//logger.info("Health Tab Not identify");
	    }
    @SuppressWarnings("unused")
	int healthdropdown = 1;

//Select value for Health question dropdown:

		 //collect all dropdowns on the Health screen:
        List<WebElement> dropdown = driver.findElements(By.tagName("select"));
        if (dropdown.size()==1)
        {
        	dropdown.get(0).sendKeys(healthQuestionResponse);
        	
        }
        
       for (int i = 0; i<(dropdown.size()); i++)
        	 
		{
            try{
			dropdown.get(i).sendKeys(healthQuestionResponse);
            }
        
            catch (Exception ex){
		}
		}
     //Click on the Continue button on Health screen:  
       driver.findElement(By.id(id_ContinueButtonOnHealthscreen)).click();
	
    return element;
	}

}
