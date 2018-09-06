package u2xScripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import u2xVariable.U2xVariable;


public class HomePageFunctions extends U2xVariable {
	
	
//
//	static List<WebElement> li_All;
//	// Using Wait property Action can wait until Element availability
//	

	// Click on Home Tab
	public void HomeLink(WebDriver driver) throws InterruptedException{
		try
		{
			// check the condition "Home" tab is enable
			WebElement er = driver.findElement(By.linkText(lnkTxt_home));
			if(er.isEnabled())
			  {			
		    	logger.info("Home is Enabled");
		    	Utility.waitForElementAvailability_Xpath(driver, 30, xPath_home);
				driver.findElement(By.xpath(xPath_home)).click();
				logger.info("Click on Home tab");
			  }
		      else
		      	{
		    	  //Home tab is Disable
		    	  logger.info("Home is disable");
		      	}
		  }catch (Exception e)	{
				// Home Tab is not identify
			  	logger.info("Home tab is not Identify");
	    		
	   	  	}					
	}
	
	// Click on Home Tab
	public void HomeImg(WebDriver driver) throws InterruptedException{
		try
		{
		
			Utility.waitForElementAvailability_Id(driver, 30, xId_imgHomeIcon);
			driver.findElement(By.id(xId_imgHomeIcon)).click();
			logger.info("Click on Organization logo");
		  }	catch (Exception e)	{
				// Home Tab is not identify
				logger.info("Organization logo is not Identify");
	   	  	}					
	}
	
	// Click on Profile Tab
	public void ProfileLink(WebDriver driver) throws InterruptedException{
		try{
			Utility.waitForElementAvailability_Xpath(driver, 30, xPath_profile);
			// check the condition "Profile" tab is enable
			WebElement er = driver.findElement(By.linkText(lnkTxt_profile));
			if(er.isEnabled()){
				logger.info("Profile is Enabled");
				// Click on Profile tab 
				driver.findElement(By.linkText(lnkTxt_profile)).click();
	          	logger.info("Click on Profile");
				// Open Profile page
				profileTabs(driver);
			}else{
				// Profile tab should be disable
				logger.info("Profile is disable");
			}
		}catch  (Exception e)
		{
			// Profile Tab is not identify
			logger.info("Profile tab is not Identify");
		}
	}
	
	// Click on Profile tabs and check all the conditions
	private void profileTabs(WebDriver driver) {
		try
		{	
			// Check personal page is Enabled
			WebElement er = driver.findElement(By.linkText(lntTxt_personal));
			if(er.isEnabled())
			  {	
				logger.info("personal is Enabled");
		    	  	// wait for Submit button is visible
				Utility.waitForElementAvailability_Xpath(driver, 30, xPath_btn_Submit);
		    		// clear Middle name feild 
		    		driver.findElement(By.name(xName_mid_Name)).clear();
		    		//Enter middle name to the feild
		    		driver.findElement(By.name(xName_mid_Name)).sendKeys(mid_name);
		    		logger.info("Enter Middle Name");
		    		//Click on Submit button
		    		driver.findElement(By.xpath(xPath_btn_Submit)).click();
		    		logger.info("Click on Submit button");
		    		//wait for pop up close button 
		    		Utility.waitForElementAvailability_Xpath(driver, 30, xPath_btn_Close);
		    		// click on close button 
		    		driver.findElement(By.xpath(xPath_btn_Close)).click();
		    		logger.info("Close popup window");
		    		logger.info("Change Middle Name");
			  }
		      else
		      	{
		    	// personal tab is disable
		    	  logger.info("personal is disable");
		      	}
		  }
		catch (Exception e)
	     	{
				// personal page is not Identify
				logger.info("personal page is not Identify");
	   	  	}
			
		try
		{
			// Check Family tab is Enabled
			WebElement er = driver.findElement(By.linkText(lnkTxt_family));
			if(er.isEnabled())
			  {	
					logger.info("Family is Enabled");

					Utility.waitForElementAvailability_Id(driver, 30, id_family);
		    	  	//Click on Family tab
		    		driver.findElement(By.id(id_family)).click();

		    		logger.info("Click on Family");
		    		//wait for DependentDetails button
		    		Utility.waitForElementAvailability_Xpath(driver, 30, xPath_btn_DependentDetails);
		    		//Click on DependentDetails button
		            driver.findElement(By.xpath(xPath_btn_DependentDetails)).click();
		            logger.info("Click on Dependent Details ");
		            
		            Actions action = new Actions(driver);
		     	   	action.sendKeys(Keys.ESCAPE).perform();
		                    
//		           //wait for DependentDetails pop up window
//		            Utility.waitForElementAvailability_Xpath(driver, 50, xPath_btn_Close_DependentDetails_popup);
//			           //close for DependentDetails pop up window
//		            driver.findElement(By.xpath(xPath_btn_Close_DependentDetails_popup)).click();
			  }
		      else
		      	{
		    	  // Check Family page is Disable
		    	  logger.info("Family is disable");
		      	}
		  }
		catch (Exception e)
	     	{
	    	  // Family tab is not Identify
				logger.info("Family page is not identify");
	   	  	}
		
		try
		{
			// check Beneficiary tab is Enabled
			WebElement er = driver.findElement(By.linkText(lnkTxt_beneficiary));
			if(er.isEnabled())
			  {	
	    		// Beneficiary page is Enabled
					logger.info("Beneficiary is Enabled");
					Utility.waitForElementAvailability_Id(driver, 30, id_beneficiary);
		    	  
		    	  	//Click on Beneficiary tab
		    		driver.findElement(By.id(id_beneficiary)).click();
		    		
		    		logger.info("Click on Beneficiary");
		    		// wait for Beneficiary Details button
		    		Utility.waitForElementAvailability_Xpath(driver, 30, xPath_btn_BeneficiryDetails);
		    		//Click on Beneficiary details button
		            driver.findElement(By.xpath(xPath_btn_BeneficiryDetails)).click();
		            logger.info("Click on Beneficiry Details button");

		            Actions action = new Actions(driver);
		     	   	action.sendKeys(Keys.ESCAPE).perform();
		            
		            //wait for Beneficiary Details popup window close button
//		            Utility.waitForElementAvailability_Xpath(driver, 50,xPath_btn_Close_BeneficiryDetails_popup);
//
//		            //Click on Beneficiary Details popup window close button
//		            driver.findElement(By.xpath(xPath_btn_Close_BeneficiryDetails_popup)).click();
//		            logger.info("Close Beneficiry Details popup");
			  }
		      else
		      	{
		    	// Beneficiary tab is Disable
		    	  logger.info("Beneficiary page is disable");
		      	}
		  }	catch (Exception e)
	     	{
			// Beneficiary page is not Identify
				logger.info("Beneficiary page is not Identify");;
	   	  	}


		try
		{
			// check Employment tab is Enabled
			WebElement er = driver.findElement(By.linkText(lnkTxt_Employment));
			if(er.isEnabled())
			  {	
					// Employment tab is Enabled
					logger.info("Employment is Enabled");
		    	  	//Click on Employment tab
		    		driver.findElement(By.id(id_btn_Employment)).click();
		    		//Wait for Employment description
		    		Utility.waitForElementAvailability_Xpath(driver, 30, xPath_Emp_element);
		    		logger.info("Click on Employment");    			
			  }
		      else
		      	{
					// Employment tab is disable
		    	  	logger.info("Employment is disable");
		      	}
		  }
		catch (Exception e)
	     	{
				// Beneficiary page is not Identify
					logger.info("Employment page is not Identify");
	   	  	}

		try
		{
			//check Content tab is Enabled
			WebElement er = driver.findElement(By.linkText(lnkTxt_Contact));
			if(er.isEnabled())
			  {	
				// Contact tab is Enabled	
				logger.info("Contact is Enabled");
				//Click on Content tab
				driver.findElement(By.id(id_btn_Contact)).click();
				//wait for Content description 
				Utility.waitForElementAvailability_Xpath(driver, 30, xPath_Contact_element);
				logger.info("Click on Contact");
			  }
		      else
		      	{
					// Contact tab is Disable
		    	  logger.info("Contact is disable");
		      	}
		  }	catch (Exception e) 	{
				// Contact tab is not Identify
				logger.info("Contact tab is not Identify");
	   	  	}
		
		try	{
			//Check Benefits tab is enable
			WebElement er = driver.findElement(By.linkText(lnkTxt_Benefits));
			if(er.isEnabled())
			  {		
				logger.info("Benefits is Enabled");
				//Click on Benefits tab
				driver.findElement(By.id(id_btn_Benefits)).click();
				//wait for Benefits description 
				Utility.waitForElementAvailability_Xpath(driver, 30, xPath_Benefits_element);
				logger.info("Click on Benefits");
			  } else
		      	{
		    	  // Benifits tab is disabled
		    	  logger.info("Benefits is disable");
		      	}
		  }
		catch (Exception e)
	     	{
				// Benefits tab is not Identify
				 logger.info("Benefits tab is not Identify");
	   	  	}
		 	

		try {
			//Check Miscellaneous tab is Enabled
			WebElement er = driver.findElement(By.linkText(lnkTxt_Miscellaneous));
			if(er.isEnabled())
			  {		
		    	   //Miscellaneous tab is Enabled
				logger.info("Miscellaneous is Enabled");
				//click on Miscellaneous tab 
				driver.findElement(By.id(id_btn_Miscellaneous)).click();
				//wait for Miscellaneous description 
				Utility.waitForElementAvailability_Xpath(driver, 30, xPath_Miscellaneous_element);
				logger.info("Click on Miscellaneous");
			  } else {
		    	   //Miscellaneous tab is disabled
		    	  logger.info("Miscellaneous is disabled");
		      	}
		  }
		catch (Exception e)
	     	{
				// Miscellaneous tab is not Identify
					logger.info("Miscellaneous tab is not Identify");
	   	  	}	
	 	
		try	{
			//Check Health tab is Enabled 
			WebElement er = driver.findElement(By.linkText(lnkTxt_Health));
			if(er.isEnabled())
			  {	
				// Health tab is Enabled	
				logger.info("Health is Enabled");
				//Click on Health tab
				driver.findElement(By.id(id_btn_Health)).click();
				logger.info("Click on Health");
				//Check Health Questions are Displayed 
				Utility.waitForElementAvailability_Xpath(driver, 30, xPath_No_Health_Questions);

				if(driver.findElement(By.xpath(xPath_No_Health_Questions)).isEnabled())
				{    
					//There are no Health Questions
					logger.info("There are no Health Questions for you at this time.");    
				} else {
					//Wait for Health Questions discreption 
					Utility.waitForElementAvailability_Xpath(driver, 20, xPath_Health_element);
			
					//Click on Save button
					driver.findElement(By.id(id_btn_Save)).click();
					logger.info("Click on Save button");
				
					//Click on Close button
					driver.findElement(By.id(id_btn_Close)).click();
					logger.info("Click on Close button");
				} 
			}  else {
					// Health tab is disabled
		    	  	logger.info("Health is disabled");
		      	}
			
			
		  } catch (Exception e) {
				// Health tab is not Identify
				logger.info("Health tab is not Identify");
	   	  	}	
		logger.info("Profile Changes Over");
		try {
			HomeImg(driver);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Click on Learn Tab
	public void LearnLink(WebDriver driver) throws InterruptedException {
	 	try {
			//Check Learn Tab is Displayed
			 if(driver.findElement(By.xpath(xPath_tab_Health)).isDisplayed())                                                                                                         
			 {
				 // Click on Learn tab
				 	driver.findElement(By.linkText(lnkTxt_Learn)).click();
				 	logger.info("Click on Learn");
					
					//logger.info(""+driver.findElement(By.xpath("//div[@class='learn-more']/div")).getSize());
						
					//*** click on Home, to open Home Page
					  HomeLink(driver);
			 }else{
				 	//Learn Tab is Disabled
				 logger.info("Learn Tab is Disabled"); 
			 }
		} catch (Exception e) {
			logger.error("Learn Tab is not identifid");
		}

	}

	// Click on Life Event
	public void LifeEvent(WebDriver driver) throws InterruptedException {

	 	try {
			//Check Life Event Tab is Displayed
			  if(driver.findElement(By.linkText(lnkTxt_LifeEvent)).isDisplayed() )                                                                                                         
			  {
				 
				//Click on Life Event tab
				driver.findElement(By.linkText(lnkTxt_LifeEvent)).click();         
				logger.info("Click on Life Event");
				//Wait Life event tab description 
				Utility.waitForElementAvailability_Xpath(driver, 30, xPath_LifeEvent_element);
				
				HomeLink(driver);
			  }else {  
				//Check Life Event Tab is Disabled
				  logger.info("Life Event Tab is Disabled"); 
			  }
		} catch (Exception e) {
			logger.error("Life Event is not identified");
		}
	}

	//Clcik on Current Benefits
	public void CurrentBenefits(WebDriver driver) throws InterruptedException {
		
		logger.info("Click on Current Benefits");
		// Check Medical is Displayed
		try {
			if(driver.findElement(By.xpath(xPath_MedicalTab)).isDisplayed()){
				//Click on Medical
				driver.findElement(By.xpath(xPath_MedicalTab)).click();
				logger.info("Click on Medical Tab");
			}
		} catch (Exception e3) {
			logger.error("Medical Tab not identified");
		}
		try {
			// Check Dental is Displayed
			if(driver.findElement(By.xpath(xPath_DentalTab)).isDisplayed()){
				//Click on Dental
			driver.findElement(By.xpath(xPath_DentalTab)).click();
			logger.info("Click on Dental Tab");	
			}
		} catch (Exception e2) {
			logger.error("Dental Tab not identified");
		}

		try {
			// Check Vision is Displayed
			if(driver.findElement(By.xpath(xPath_VisionTab)).isDisplayed()){
			//Click on Vision
			driver.findElement(By.xpath(xPath_VisionTab)).click();
			logger.info("Click on Vision Tab");
			}
		} catch (Exception e1) {
			logger.info("Vision Tab not identified");
		}

		try {
			// Check Benefit is Displayed
			if(driver.findElement(By.xpath(xPath_Benefit)).isDisplayed()){
			//Click on Benefit	
			driver.findElement(By.xpath(xPath_Benefit)).click();
			logger.info("Click on current Benefit");
			//wait for Benefit description 
			Utility.waitForElementAvailability_Xpath(driver, 30, xPath_Benefits_element);
			
			//*** click on Home, to open Home Page
			  HomeLink(driver);
			}
		} catch (Exception e) {
			logger.info("Current Benefit Tab not identified");
		}
	}

	//check Activity Profiles in AdminPanel
	public void ActivityProfile(WebDriver driver) throws InterruptedException {
		
		try
	      {	  // Check personal Link is Enabled
		      WebElement er = driver.findElement(By.linkText(lntTxt_personal));
		      if(er.isEnabled())
		      {
		    	  	logger.info("Personal is enabled");
		         // wait for Personal Link is visible
		    	  	Utility.waitForElementAvailability_Xpath(driver, 30, xPath_personal);
		          	// Clcik on Personal Link
		    		driver.findElement(By.xpath(xPath_personal)).click();

		    		HomeImg(driver);
		      }
		      else
		      {
		    	  // Personal Link is Disabled
		    	  logger.info("Personal is disable under Activity Profile");
		      }
	      }
	      catch (Exception e)
	      {
	    	  //Personal link is not identified
	    	  logger.error("Personal link is not identified under Activity Profile");
	      }
	      
	      try

	      {  // Check Family Link is Enabled
		      WebElement er = driver.findElement(By.linkText(lnkTxt_family));
		      if(er.isEnabled())
		      {
			    	 logger.info("Family is Enabled under ActivityProfile");
			    	 //Wait for Family link
			    	 Utility.waitForElementAvailability_Xpath(driver, 30, xPath_family);
		    	  	//Click on Family link
		  			driver.findElement(By.xpath(xPath_family)).click();

		  			logger.info("Click on Family tab under ActivityProfile");
		  	
			      	//Click on Home tab
		  			HomeImg(driver);
		      }
	      else
	      	{
	    	  //Family link is disabled
	    	   logger.info("Family is disable under ActivityProfile");
	      	}
	      }
	      catch (Exception e)
	      {
	    	  //Family link is not identified
	    	  logger.error("Family link is not identified under ActivityProfile");
    	  }
	      				
		
				 
		try
			{	// Check Beneficiary Link is Enabled
			     WebElement er = driver.findElement(By.linkText(lnkTxt_beneficiary));
			     if(er.isEnabled())
			    {
			    	 logger.info("Beneficiary is Enabled under ActivityProfile");
			    //	 wait for Beneficiary Link
			    	 Utility.waitForElementAvailability_Xpath(driver, 30, xPath_beneficiary);
			    	 //Click on Beneficiary link
			    	 driver.findElement(By.xpath(xPath_beneficiary)).click();
			    	 logger.info("Click on Beneficiary under ActivityProfile");
			    //	 Click on Home tab
			    	 HomeImg(driver); 
			    	
			    }
			      else
			      	{	//Beneficiary link is disabled
			    	   logger.info("Beneficiary is disable under ActivityProfile");
			      	}
			  }
		catch (Exception e)
		     {
		    	  //Beneficiary link is not identified
		    	  logger.error("Beneficiary link is not identified under ActivityProfile");
		   	  }

		try
			{	// Check Employment Link is Enabled
				WebElement er = driver.findElement(By.linkText(lnkTxt_Employment));
				if(er.isEnabled())
				  {		// Employment link is Enabled
			    	logger.info("Employment is Enabled under ActivityProfile");
				//	Wait for Employment link
			    	Utility.waitForElementAvailability_Xpath(driver, 30, xPath_Employment);
			    	// Clcik on Employment link
					driver.findElement(By.xpath(xPath_Employment)).click();
					logger.info("Click on Employment under ActivityProfile");	
					
				//	Click on Home tab
					HomeImg(driver);
				  }
			      else
			      	{	// Employment link is disabled
			    	   logger.info("Employment is disable under ActivityProfile");
			      	}
			  }
		catch (Exception e)
		     {		//Employment link is not identified
		    	  logger.error("Employment link is not identified under ActivityProfile");
		   	  }	 
		
		
		try
		{	//Check Contact link is Enabled
			WebElement er = driver.findElement(By.linkText(lnkTxt_Contact));
			if(er.isEnabled())
			  {			
		    	logger.info("Contact is Enabled under ActivityProfile");
//		    	Waiting for Contact link 
		    	Utility.waitForElementAvailability_Xpath(driver, 30, xPath_Contact);
		    	// click on Contact link
		    	driver.findElement(By.xpath(xPath_Contact)).click();
		    	logger.info("Click on Contact under ActivityProfile");

//				click on Home Tab
		    	HomeImg(driver);
		    	
			  } else {
		    	  //Contact link is disabled
		    	   logger.info("Contact is disableD under ActivityProfile");
		      	}
		  }
		catch (Exception e)
	     	{	//Contact link is not identified
	    	  logger.error("Contact link is not identified under ActivityProfile");
	   	  	}	 
		

		try
		{	// Check Benefits Link is Enabled
			WebElement er = driver.findElement(By.linkText(lnkTxt_Benefits));
			if(er.isEnabled())
			  {			
		    	logger.info("Benefits is Enabled under ActivityProfile");
//				Waiting for Benefits link
		    	Utility.waitForElementAvailability_Xpath(driver, 30, xPath_Benefits);
		    	// click on Benefits link
				driver.findElement(By.xpath(xPath_Benefits)).click();
				logger.info("Click on Benefits under ActivityProfile");

//				Click on Home tab
				HomeImg(driver);
			  }
		      else
		      	{	// Benefits link is Disabled
		    	   logger.info("Benefits is disable under ActivityProfile");
		      	}
		  }
		catch (Exception e)
	     	{
			//Benefits list is not identified
	    	  logger.error("Benefits list is not identified under ActivityProfile");
	   	  	}
		

		try
		{	//check Miscellaneous link is Enabled
			WebElement er = driver.findElement(By.linkText(lnkTxt_Miscellaneous));
			if(er.isEnabled())
			  {	
		    	logger.info("Miscellaneous is Enabled under ActivityProfile");
//				waitng for Miscellaneous link enabled
		    	Utility.waitForElementAvailability_Xpath(driver, 30, xPath_Miscellaneous);
		    	// Click on Miscellaneous link
				driver.findElement(By.xpath(xPath_Miscellaneous)).click();
				logger.info("Click on Miscellaneous under ActivityProfile");

//				Click on Home tab
				HomeImg(driver);
			  }
		      else
		      	{	//Miscellaneous link is Disabled
		    	   logger.info("Miscellaneous is disable under ActivityProfile");
		      	}
		  }
		catch (Exception e)
	     	{	//Miscellaneous link is not identified
	    	  logger.error("Miscellaneous link is not identified under ActivityProfile");
	   	  	}
		

		try
		{	//Check Health link is Enabled
			WebElement er = driver.findElement(By.linkText(lnkTxt_Health));
			if(er.isEnabled())
			  {	
		    	  	logger.info("Health is Enabled under ActivityProfile");
//					waiting for Health link is enabled 
		    	  	Utility.waitForElementAvailability_Xpath(driver, 30, xPath_Health);
			    	// click on Health link 
					driver.findElement(By.xpath(xPath_Health)).click();
					logger.info("Click on Health under ActivityProfile");

//					Click on Home tab
					HomeImg(driver);
					
					//div[@id='tableEmployee']/div[5]/div/div/div[2]/select
			  }
		      else
		      	{	//Health link is disabled
		    	   logger.info("Health is disable under ActivityProfile");
		      	}
		  } catch (Exception e)	{
			  //Health link is not identified
	    	  logger.error("Health link is not identified under ActivityProfile");
	   	  	}
	}
	
	// Check Activity Admin Panel
	public void ActivityAdminpanel(WebDriver driver) throws InterruptedException {
		try

	      {	// Check Activity History link is Enabled
		      WebElement er = driver.findElement(By.linkText(lnkText_A_History));
		      if(er.isEnabled())
		      {
		          	logger.info("Activity History is enabled");
//		          	Waiting for Activity History link is Enabled
		          	Utility.waitForElementAvailability_Xpath(driver, 30, xPath_A_History);
		          	//Click on Activity History link 
		          	driver.findElement(By.xpath(xPath_A_History)).click();

		  			logger.info("Click on Activity History");
		  			//Click on back button
		  			driver.findElement(By.id(id_btn_back)).click();
		      }
		      else
		      {		//Activity History link is disabled
		    	   logger.info("Activity History is disable");
		      }
	      }

	      catch (Exception e) {
	    	  // Activity History link is not identified
	    	  logger.error(" Activity History link is not identified");	  
	      }
	      try  {
	    	  //Check Payroll Maintenace Link is Enabled
		      WebElement er = driver.findElement(By.linkText(lnkText_A_PayrollMaintenace));
		      if(er.isEnabled())
		      {
		    	logger.info("Payroll Maintenance is enabled");

		        // Waiting for Payroll Maintenace Link is Enabled
		    	Utility.waitForElementAvailability_Xpath(driver, 30, xPath_A_PayrollMaintenace);
		        // click on Payroll Maintenace Link
		  		driver.findElement(By.xpath(xPath_A_PayrollMaintenace)).click();
		  		logger.info("Click on Payroll Maintenance");
		  		Utility.waitForElementAvailability_Id(driver, 20, id_element_EmployeePayroll); 
		  		// Enter Employee Payroll
		  		new Select(driver.findElement(By.id(id_element_EmployeePayroll))).selectByIndex(input_EmployeePayroll); //.sendKeys(input_EmployeePayroll);
		  		Utility.waitForElementAvailability_Id(driver, 20, id_element_PayrollGroup); 
		  		// Enter Payrool group
		  		new Select(driver.findElement(By.id(id_element_PayrollGroup))).selectByIndex(input_PayrollGroup);
		  		Utility.waitForElementAvailability_Id(driver, 20, id_element_PayrollFrequency);
		  		// Enter Payroll Frequency
		  		new Select(driver.findElement(By.id(id_element_PayrollFrequency))).selectByIndex(input_PayrollFrequency);
		  		Utility.waitForElementAvailability_Id(driver, 20,id_btn_Search); 
		  		// click on Search Button
				driver.findElement(By.id(id_btn_Search)).click();

				Utility.waitForElementAvailability_Id(driver, 20, id_btn_back);
				// Click on Back button
				driver.findElement(By.id(id_btn_back)).click();
				// Check alert dialog box opend
				Alert alert = driver.switchTo().alert();
				// Click on Accept button
				alert.accept();
				
		      } else {
		    	  // Payroll Maintenace Link is Disabled
		    	   logger.info("Payroll Maintenance is disable");
		      }
	      }

	      catch (Exception e)

	      {		// Payroll Maintenace Link is not identied
	    	  logger.error("Payroll Maintenace Link is not identied");
	    	  
	      }
	      

	      try

	      {		//Check Plan Override Link is Enabled
		      WebElement er = driver.findElement(By.linkText(lnkText_A_PlanOverride));
		      if(er.isEnabled())
		      {
		    	  logger.info("Plan Override is enable");
//			      Waiting for Plan Override link is enabled
		    	  Utility.waitForElementAvailability_Xpath(driver, 30, xPath_A_PlanOverride);
			      //Click on Plan Override link
		    	  driver.findElement(By.xpath(xPath_A_PlanOverride)).click();
		    	  logger.info("Click on Plan Override");
		      }
		      else
		      {// Plan Override Link is Disabled
		    	   logger.info("Plan Override is disabled");
		      }
	      }

	      catch (Exception e)

	      {		// Plan Override Link is not identied
	    	  logger.error("Plan Override Link is not identied");
	      }
	      //Click on Home tab

	      try

	      {		//Check Password Reset Link is Enabled
		      WebElement er = driver.findElement(By.linkText(lnkText_A_PasswordReset));
		      if(er.isEnabled())
		      {
		    	logger.info("Password Reset is enable");
//			    Waiting for Password Reset Link is Enabled
		    	Utility.waitForElementAvailability_Xpath(driver, 30, xPath_A_PasswordReset);
			    // Click on Password Reset Link
		  		driver.findElement(By.xpath(xPath_A_PasswordReset)).click();
		    	logger.info("Click on Password Reset");
		  		// Close Password Reset Link popup window
		    	Utility.waitForElementAvailability_Xpath(driver, 30, xPath_btn_SubmitReset);
//		  		Click on Close button in Password Reset Link popup window
//		  		driver.findElement(By.xpath(xPath_btn_Close_PasswordReset_popup)).click();

	            Actions action = new Actions(driver);
	     	   	action.sendKeys(Keys.ESCAPE).perform();
		  	}
		      else
		      {// Password Reset Link is Disabled
		    	   logger.info("Password Reset is disabled");
		      }
	      }

	      catch (Exception e)

	      {		// Password Reset Link is not identied
	    	  logger.error("Password Reset Link is not identied");
	      }
	      
	      try

	      {		//Check Admin Coverage Maintenance Link is Enabled
		      WebElement er = driver.findElement(By.linkText(lnkText_A_Admincoveragemaintenance));
		      if(er.isEnabled())
		      {
		    	  logger.info("Admin coverage maintenance is enable");
		    	  // Waiting for Admin Coverage Maintenance Link is Enabled
		    	  Utility.waitForElementAvailability_Xpath(driver, 30, xPath_A_Admincoveragemaintenance);
		    	  // clcik on Admin Coverage Maintenance Link 
		    	  driver.findElement(By.xpath(xPath_A_Admincoveragemaintenance)).click();
		    	  logger.info("Click on Admin coverage maintenance");
		    	  // Waiting for back button is enabled
		    	  Utility.waitForElementAvailability_Xpath(driver, 30, xPath_btn_back);
		    	  // click on Back button
		    	  driver.findElement(By.xpath(xPath_btn_back)).click();	
		    	  logger.info("Click on back link"); 		
		  				  		
		      }
		      else
		      {// Admin coverage maintenance Link is Disabled
		    	   logger.info("Admin coverage maintenance is disabled");
		      }
	      }

	      catch (Exception e)

	      {		// Admin coverage maintenance Link is not identied
	    	  logger.error("Admin coverage maintenance Link is not identied");
	      }
	      
	      try {
	    	  //Check VB Admin Coverage Maintenance Link is Enabled
		      WebElement er = driver.findElement(By.linkText(lnkText_A_VBAdmincoveragemaintenance));
		      if(er.isEnabled())
		      {
		    	  logger.info("VB Admin Coverage Maintenance is enable");
		    	// Waiting for VB Admin Coverage Maintenance Link is Enabled
		    	  Utility.waitForElementAvailability_Xpath(driver, 30, xPath_A_VBAdmincoveragemaintenance);
		    	  // Click on  VB Admin Coverage Maintenance Link 
		    	  driver.findElement(By.xpath(xPath_A_VBAdmincoveragemaintenance)).click();
		    	  logger.info("Click on VB Admin Coverage Maintenance"); 
		    	// Waiting for back button is enabled
		    	  Utility.waitForElementAvailability_Xpath(driver, 30, xPath_btn_back);
		    	  // click on Back button
		    	  driver.findElement(By.xpath(xPath_btn_back)).click();	 	  	
		    	  logger.info("Click on back link"); 		
		      }
		      else
		      {// VB Admin coverage maintenance Link is Disabled
		    	  logger.info("VB Admin Coverage Maintenance is disabled");
		      }
	      }

	      catch (Exception e)

	      {		// VB Admin coverage maintenance Link is not identied
	    	  logger.error("VB Admin coverage maintenance Link is not identied");
	      }
	      		
	}
	
}
