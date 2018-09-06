package u2xScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import u2xVariable.U2xVariable;


public class EbxClient extends U2xVariable {
	public static WebElement element = null;
	public static String planname;
	
	public static WebElement EbxClientEnrollment(WebDriver driver) throws InterruptedException, IOException 
	{	
		//Class: FamilyPage		
        try
        {
		FamilyPage.familyPageFunctionalities(driver);   
        logger.info("Family Page launched successfully");
        }
        
		catch (Exception ex)
		{
			Utility.captureScreenshot(driver, "Family Page");
		}

//Class: Beneficiary
        //Using try catch in case of Beneficiary page is not there (as per set up trigger):
        try
        {
        BeneficiaryPage.beneficiaryPageFunctionalities(driver);
        logger.info("Beneficiary page launched successfully");
        }
        
        catch (Exception ex)
        {
        }
        

      //Class:Plans
        do
        {
        //Wait to load plan1 page:
        Plans.waitToLoadPlanPage1(driver);

        //Get the plan name:
        element = Plans.checkThePlanType(driver);
         planname = element.getText();
         if (planname.equals("Complete Enrollment"))
         {
        	 planname="Review and Submit";
         }
        logger.info(planname+ " plan page Launched sucessfully");
        if (planname.equals("Review and Submit"))
        {
        	//planname = "Survey";
            break;
        }
        //Check the plan1 name and navigate on that plan page:
        Plans.navigateOnPlan(driver, planname);

        }
        while (!(planname.equals("Survey")));
        //while (1>0);

        if (planname.equals("Review and Submit"))
        {
        //Complete enrollment flow by clicking on Complete Enrollment button.
        //Review and submit screen:

        //Click on 'Complete Enrollment' button on 'Review and Submit' screen:
        	try
        	{
        		driver.findElement(By.id("txtResponse")).click();
        		driver.findElement(By.id("txtResponse")).clear();
        		driver.findElement(By.id("txtResponse")).sendKeys("Test");
        	}
        	catch (Exception ex)
        	{
        		
        	}
        WebElement completeEnrollmentButton = driver.findElement(By.xpath(xPath_CompleteEnrollmentButton));
        completeEnrollmentButton.click();
        logger.info("Enrollment has been completed");
        }   	
            	
        else
        {
        //Wait to load Review and Submit page:
        	Utility.waitForElement_ToBeClickable_Xpath(driver, 30, xPath_ReviewSubmit);
              
               //Check the Review and Submit plan:
                element = Plans.reviewSubmitPlan(driver, xPath_reviewSubmitPlan);
            	planname = element.getText();
            	
            	//Check the Review and Submit plan and navigate on that plan page:
            	Plans.navigateOnPlan(driver, planname);
                    }
        return element;
	}
}
