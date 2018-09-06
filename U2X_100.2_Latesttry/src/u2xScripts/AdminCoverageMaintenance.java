package u2xScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import u2xVariable.U2xVariable;

public class AdminCoverageMaintenance extends U2xVariable {
	public static WebElement element = null;
	public static String planname;
	
	
	public static WebElement AdminCoverageMaintenanceFunctions(WebDriver driver) throws InterruptedException, IOException
	{	
	//Click on Admin Coverage Maintenance link:	
		try
		{
		element = driver.findElement(By.xpath(xPath_AdminCoverageMaintenanceLinkOnHomePage));
		element.click();
		logger.info("Admin Coverage Maintenance event has been started.");
		}
		catch (Exception ex)
		{
			logger.info("Admin Coverage Maintenance link is not enabled/available on Homepage.");
			Utility.captureScreenshot(driver, "AdminCoverageMaintenanceLinkOnHomePage");
		}
	
	//WaitFor waitForContinueButtonOnAdminCoverageMaintenencepage :
	

	    element = Utility.waitForElementAvailability_Id(driver, 30, id_ContinueButtonOnAnnualEnrollmentWelcomePage);

	
	//Enter Event Date:
	
	    element = driver.findElement(By.id(id_EventDate));
	    element.click();
	    element.clear();
	    element.sendKeys(systemDate);

	
	
    //Click on Continue button on Admin Coverage Maintenence page:	
	
    element = driver.findElement(By.id(id_ContinueButtonOnAnnualEnrollmentWelcomePage));
    element.click();

	// Wait for PopUp ContinueButton:
    try
    {
	    element = Utility.waitForElementAvailability_Xpath(driver, 30, xPath_LifeEventPopUpContinueButton );
	    //element = driver.findElement(By.xpath(xPath_LifeEventPopUpContinueButton));
    }
    catch (Exception ex)
    {
    	Utility.captureScreenshot(driver, "AdminCoverageMaintenanceWelcomePage");
    }

		

	// Click on lifeEvent PopUp ContinueButton:

	    element = driver.findElement(By.xpath(xPath_LifeEventPopUpContinueButton));
	    element.click();
	    
	    try{
    		//Class: ContactPage
    		ContactPage.contactPageFunctions(driver);
    	}
    	catch (Exception ex)
    	{	
    	}  
	    
	  //Class: Health screen      
        // if no health questions available:
    	
        try
        {
        	HealthPage.healthFunctions(driver);
        }

        catch (Exception ex)
        {
        }
             
      //Wait to load Review and Submit page:
        Utility.waitForElement_ToBeClickable_Xpath(driver, 30, xPath_ReviewSubmit);
        logger.info("Review and Submitted launched successfully");
        
        //Click on First Plan plan link On Review and Submit screen and navigate back to plan page:
        driver.findElement(By.xpath(xPath_FirstPlanOnReviewandSubmit)).click();
        logger.info("first plan link is clicked");
        
        //Check plan name link:
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
  		logger.info(planname+ " page Launched sucessfully");
  		if (planname.equals("Review and Submit"))
  		{
  			//planname = "Survey";
  		    break;
  		}
  		//Check the plan1 name and navigate on that plan page:
  		Plans.navigateOnPlan(driver, planname);
  		
  		}
  		//while (!(planname.equals("Survey")));
  		while (1>0);
  		
  		if (planname.equals("Complete Enrollment"))
  		{
  		//Complete enrollment flow by clicking on Complete Enrollment button.
  		//Review and submit screen:
  		//Enter response question:
  		element = driver.findElement(By.id(id_ResposeQuestionTextbox));
  		element.clear();
  		element.sendKeys(resposeQuestionText);
  		
  		//Click on 'Complete Enrollment' button on 'Review and Submit' screen:
  		WebElement completeEnrollmentButton = driver.findElement(By.xpath(xPath_CompleteEnrollmentButton));
  		completeEnrollmentButton.click();
  		logger.info("Enrollment has been completed");
  		}
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



