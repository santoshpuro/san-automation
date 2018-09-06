package u2xScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import u2xVariable.U2xVariable;

public class LifeEvents extends U2xVariable {
    public static WebElement element = null;
    public static String planname;
    
    public static WebElement lifeEventFunctions(WebDriver driver) throws InterruptedException, IOException
    {
          
//Click on Life Event link:
          try
          {
        	  Utility.waitForElementAvailability_Xpath(driver, 30, xPath_LifeEvent_tab);
              logger.info("Click on Life Event Link on Home Button");	
                driver.findElement(By.id(id_LifeEventLinkOnHomePage)).click();
                logger.info("Life event has been started.");
               // element.click();
          }
          catch (Exception ex)
          {
        	   logger.info("Life event link is not present on Home page.");
                Utility.captureScreenshot(driver, "LifeEventLinkOnHomePage");
          }
          
//WaitFor Life Event Text on LifeEvent Page:   
        //  WebDriverWait wait=new WebDriverWait(driver, 30);
       //   HomePageFunctions.waitForElementAvailability(driver, 30, xPath_LifeEventTextonLifeEventPage);
          Utility.waitForElementAvailability_Xpath(driver, 30, xPath_LifeEventTextonLifeEventPage);//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath_LifeEventTextonLifeEventPage )));


    //Click on life Event Go Link:
          
try
{
        driver.findElement(By.xpath(xPath_LifeEventGoLink)).click();
}
catch (Exception ex)
{
	logger.info("No Life events are present for this organization.");
    Utility.captureScreenshot(driver, "LifeEventPage");
}
        
    //Enter Event Date:
//        WebDriverWait wait=new WebDriverWait(driver, 30);
//        element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id_EventDate)));
        element = Utility.waitForElementAvailability_Xpath(driver, 30, xPath_EventDate);
        element = driver.findElement(By.id(id_EventDate));
        element.click();
        element.clear();
        //element.sendKeys("05/03/2018");
        element.sendKeys(systemDate);

    
  //Click on Continue button on life Event Page:    
        Utility.waitForElement_ToBeClickable_Id(driver, 30, id_ContinueButtonOnAnnualEnrollmentWelcomePage);
        driver.findElement(By.id(id_ContinueButtonOnAnnualEnrollmentWelcomePage)).click();
  

    // Wait for lifeEvent PopUp ContinueButton:
        
  //WebDriverWait wait1=new WebDriverWait(driver, 7);
  try
  {
//  element = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath_LifeEventPopUpContinueButton )));
	  element = Utility.waitForElementAvailability_Xpath(driver, 30, xPath_LifeEventPopUpContinueButton);
  }
  
  catch (Exception ex)
  {
  System.out.println("change Date of Event to process further");
    Utility.captureScreenshot(driver, "ContinueButtonOnAnnualEnrollmentWelcomePage");
  // element = driver.findElement(By.xpath(xPath_LifeEventPopUpContinueButton));
  }


//Click on lifeEvent PopUp ContinueButton:
  element = driver.findElement(By.xpath(xPath_LifeEventPopUpContinueButton));
  element.click();

      //Class: PersonalPage
      //Call 'PersonalPage' class:
      PersonalPage.contactPageFunctions(driver);
      logger.info("Personal Page launched successfully");
      
//Class: FamilyPage
    //Call 'FamilyPage' class:
      FamilyPage.familyPageFunctionalities(driver);   
      logger.info("Family Page launched successfully");


//Class: Beneficiary
    //Call 'eneficiaryPage' class:
      try {
                BeneficiaryPage.beneficiaryPageFunctionalities(driver);
                logger.info("Beneficiary page launched successfully");
          } catch (Exception e) {
              logger.info("Beneficiary page Not Identified");
          }
      
//Class: Contact
    //Call 'ContactPage' class:
    try {
          ContactPage.contactPageFunctions(driver);
    } catch (Exception e) {
        logger.info("ContactPage Not Identified");
    }

//Class: Health screen   
  //Call 'HealthPage' class:
    
      // if no health questions available:
          try
          {
                 HealthPage.healthFunctions(driver);
                 logger.info("Health page launched successfully"); 
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
