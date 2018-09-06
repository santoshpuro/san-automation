package u2xRunnablescripts;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import u2xScripts.AdminCoverageMaintenance;
import u2xScripts.AnnualEnrollmentWelcomePage;
import u2xScripts.BeneficiaryPage;
import u2xScripts.ContactPage;
import u2xScripts.EbxClient;
import u2xScripts.EmployeeLookUp;
import u2xScripts.FamilyPage;
import u2xScripts.HealthPage;
import u2xScripts.HomePage;
import u2xScripts.HomePageFunctions;
import u2xScripts.LaunchUrl;
import u2xScripts.LifeEvents;
import u2xScripts.LoginPage;
import u2xScripts.PersonalPage;
import u2xScripts.Plans;
import u2xScripts.SelfServiceLogin;
import u2xScripts.Utility;
import u2xScripts.WeezerQaPage;
import u2xVariable.U2xVariable;

public class Runnable extends U2xVariable  {
	
	public static WebDriver driver;
	public static String planname;
	public static WebElement element;
	public static boolean dotLink;
	public static boolean adminPanel;
	public static int adminPanelSection = 1;
	public static int dotlinksection  = 1;
	public static int common  = 1;
	public static int popup  = 1;
	public static int popupCont  = 1;
	public static int y = 1;
	public static int z = 1;
	public static int m = 1;
	static HomePageFunctions hp = new HomePageFunctions();
	


	public static void main(String[] args) throws InterruptedException, AWTException, IOException {
		
		// configure log4j properties file
				PropertyConfigurator.configure("log4j.properties");
            
				Utility.GetExcelData(driver);
				//Class : Launch Chrome browser with base url
				driver = LaunchUrl.launchBaseUrl(url, browserpath);
		        logger.info("Launch Chrome browser with base url");
        
//Class: LoginPage:             
        //Enter User GUID:
		LoginPage.LoginPageFunctiontalities(driver);
        
//Class: WeezerQaPage:
		try
		{
		WeezerQaPage.WeezerQaPageFunctionalites(driver);
		}
		catch (Exception ex)
		{
		logger.info("User/Organization/System Date details are not correct");
		Utility.captureScreenshot(driver, "LoginPage");
		}

        if (applicationname.equals("Regular Self Service"))
		{
        	Utility.waitForElementAvailability_Xpath(driver, 30, xPath_Register);
        	if (driver.findElement(By.xpath(xPath_Register)).getText().trim().equals("Register")){
        		
        		Thread.sleep(5000);
        		Utility.waitForElement_ToBeClickable_Xpath(driver, 30, xpath_Signin);
        		try
        		{
        		driver.findElement(By.xpath(xpath_Signin)).click();//*[@id="register-box"]/div[1]/a
    			logger.info("Click on Sign in button1");
        		}
        		catch (Exception ex)
        		{
        			driver.findElement(By.xpath(xpath_Signin)).click();//*[@id="register-box"]/div[1]/a
        			logger.info("Click on Sign in button2");	
        		}
    			//Thread.sleep(3000);
    		}else{
    		}
        	//SelfService Class:  
        	SelfServiceLogin.SelfServiceLoginFunctionalities(driver);	
        	
        	try{    
	            if (driver.findElement(By.xpath(xPath_Element)).isDisplayed()){
	    	        if(driver.findElement(By.xpath(xPath_Element)).getText().substring(2, 36).equals("There is already an active session")){
	    	        	logger.info(driver.findElement(By.xpath(xPath_Element)).getText().substring(2));
	    	        	Utility.captureScreenshot(driver, "There is already an active session");
	    		    	
	    	        }else if(driver.findElement(By.xpath(xPath_Element)).getText().substring(2,5).trim().equals("Sorry")){
	    		    	logger.info(driver.findElement(By.xpath(xPath_Element)).getText().substring(2));
	    		    	Utility.captureScreenshot(driver, "Login with Wrong credentials");
	    		    	
	    	        }else{
	    	        	logger.info(driver.findElement(By.xpath(xPath_Element)).getText().substring(2));
	    	        	Utility.captureScreenshot(driver, "Login-Failed");
	    	        }
	            }
	        }catch(Exception e){
	        }
		}
        
        if (applicationname.equals("U2X Admin"))
        		{
                
//Class: EmployeeLookup: for Counsler:
        //Enter U ID:
        	try
        	{
        EmployeeLookUp.employeeLookUpFunctionalities(driver, xId_uId, xid_reasonCode, xId_Lookupbtn, id_EnrolleeNameHyperlink);
        	}
    		catch (Exception ex)
    		{
    		logger.info("No such Enrolleeid is present for this organization");
    		Utility.captureScreenshot(driver, "LookupPage");
    		}
        	}
 
 //Class: HomePage:
        
      //wait until 'Back to Look Up' link is clickable on home page: 
        if (!applicationname.equals("Regular Self Service"))
        {
        try
        {
        HomePage.waitForBackToLookUpLink(driver,120, id_BacktoLookUpLink);    
        }
		catch (Exception ex)
		{
		logger.info("Homepage is taking more than 240 sec to load");
		Utility.captureScreenshot(driver, "LookupPage");
		}
        }
        else
        {
        	//Wait for Profile link to be clickable:
        	try{
        	Utility.waitForElement_ToBeClickable_Id(driver, 30, "ProfileHome");
        	}
        	catch (Exception ex)
        	{
        		
        	}
        	//in case of pop up for completed enrollment:
        	try
        	{
        	driver.findElement(By.xpath("//a[@id='closeDialog']")).click();
        	}
        	catch (Exception ex)
        	{
        		
        	}
        }
		
      logger.info("Login success");
      //wait for 2 sec as admin panel is taking some extra time to load than 
            

//////////Call HomePageFunctions:///////////

    //*** Profile page open and click one by one tab Profile, Family, Beneficiary, Employment, Contact, Benefits, Miscellaneous, Health

    //hp.ProfileLink(driver);

    //*** click on Life Event tab       
   // hp.LifeEvent(driver);

    //*** click on Learn tab     
//    hp.LearnLink(driver);

    //*** click on Current Benefits, to check the Benefits plans
 //   hp.CurrentBenefits(driver);

    //***Click on Activity Profile, to click one by one tab Profile, Family, Beneficiary, Employment, Contact, Benefits, Miscellaneous, Health
  //  hp.ActivityProfile(driver);

    //***Click on Activity Adminpanel, to click one by one tab Activity History, Payroll Maintenance, Plan Override,
    //   Password Reset, Admin coverage maintenance, VB Admin Coverage Maintenance
    //hp.ActivityAdminpanel(driver); 

      /////////////////////////Call HOmePageFunction://///
      if (event.equals("lifeEvent"))   	  
      {      
    	//Click on Life Event Link:
    	  LifeEvents.lifeEventFunctions(driver);
       }     
      if (event.equals("AdminCoverageMaintenance"))
      { 
    	  m = 3;
 
    	  //Click on Admin Coverage Maintenance Link:
    	  AdminCoverageMaintenance.AdminCoverageMaintenanceFunctions(driver);         
      }
      
      if (event.equals("AE"))
      {
	 

      //Click on Annual Enrollment link on Homepage:
      if (!(applicationname.equals("Regular Self Service")&&clientType.equals("EBX")))
      {
    	  try
    	  {
    		  HomePage.clickOnAnnualEnrollmentLink(driver, xPath_AdminPanelAELink, xPath_PromoAeLink, xPath_DotLink).click();
    	  
    	  logger.info("Annual Enrollment event has been started.");
    	  }
    	  catch (Exception ex)
    	  {
    		  logger.info("Annual Enrollment link is not visible/clickable on Homepage.");
    		  Utility.captureScreenshot(driver, "AnnualEnrollmentLink");
	 	  }
      }
      
      else
      {
    	  //Click on Continue button on HomePage to start enrollment.
    	  try
    	  {
    	  driver.findElement(By.id("btnVBXContinue")).click();
    	  }
    	  
    	  catch (Exception ex)
    	  {
    		  try
    		  {
    			  driver.findElement(By.id("btnNewVBXContinue")).click();
    		  }
    		  catch (Exception ex1)
    		  {
    			  logger.info("AE link is not available/clickable.");
    		  Utility.captureScreenshot(driver, "AnnualEnrollmentLink");
    		  }
    	  }
      }
        
        if(clientType.equals("EBX"))
        		{
        	EbxClient.EbxClientEnrollment(driver);
        		}
        if(clientType.equals("U2X"))
		{
//Class: AnnualEnrollmentWelcomePage
        	
        // wait to present Continue button on AnnualEnrollmentWelcomePage:
        AnnualEnrollmentWelcomePage.waitForContinueButtonOnAnnualEnrollmentWelcomePage(driver);

        logger.info("AnnualEnrollmentWelcomePage launched successfully");
	
        //Click on Continue button on Welcome To Open Enrollment Page:
        AnnualEnrollmentWelcomePage.continueButtonOnWelcomeToOpenEnrollmentPage(driver).click();        
        logger.info("Click on Continue Button On Welcome To Open Enrollment Page.");
        
        //Get values back:
        m = AnnualEnrollmentWelcomePage.clickOnPreContinueButtonOnPopup(driver, y, z);
        if (m==1)
        {
        	logger.info("Enrollmenet is incompleted for this enrollee.");
        }
        if (m==2)
        {
        	logger.info("Enrollment is already completed in past for this enrollee.");
        }
    
        //Click on Continue button on pop up:
        try {
			//Utility.waitForElementAvailability_Xpath(driver, 30, xPath_ContinueButtonOfIncompletedEnrollment);
			AnnualEnrollmentWelcomePage.clickOnContinueButtonOnPopup(driver, m).click();          
			logger.info("Click on Continue Button On Popup.");
		} catch (Exception e1) {
			logger.info("Click on Continue Button On Popup is not identified.");
			Utility.captureScreenshot(driver, "Popup");
		}

        //For Incompleted enrollment:
            if (m==1)
            {            	
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
			logger.info("Beneficiary page Not launched successfully");
		}
        
//Class: Contact
      //Call 'ContactPage' class:
      ContactPage.contactPageFunctions(driver);

//Class: Health screen   
    //Call 'HealthPage' class:
      
        // if no health questions available:
		try
		{
		        	HealthPage.healthFunctions(driver);
		}
		catch (Exception ex)
		{	
		}
		logger.info("Health page launched successfully");              
		
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
		}            
//For completed enrollment:
            else if(m==2)
            {
            	try{
            		//Class: ContactPage
            		ContactPage.contactPageFunctions(driver);
            		logger.info("Contact Page launched successfully");
            	}
            	catch (Exception ex){
            	}    
            	
            	//Class: Health screen               
                // if no health questions available:
               
              //Wait to present 'Health' question dropdown:
                try
               {
                    	HealthPage.healthFunctions(driver);
                    	logger.info("Health Page launched successfully");
               }catch (Exception ex)
                {
                } 
                    //Wait to load plan50 page which is Review and Submit:
               Utility.waitForElement_ToBeClickable_Xpath(driver, 30, xPath_ReviewSubmit);
                  
                   //Check the Plan19 Type:
                    element = Plans.reviewSubmitPlan(driver, xPath_reviewSubmitPlan);
                	planname = element.getText();
                	
                	//Check the plan19 name and navigate on that plan page:
                	Plans.navigateOnPlan(driver, planname);
            }
            }	
      	}
        
      }
	}
      
	


