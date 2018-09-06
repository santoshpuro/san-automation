	package u2xScripts;
	
	
	import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import u2xVariable.U2xVariable;
	
	public class Plans extends U2xVariable  {
		public static int alert1 = 1;
		public static int alert3 = 1;
		public static WebElement element = null;
		String Plannam = "Medical";
		public static String Survey = "Survey";
		public static String Review = "Review & Submit";
		public static int plan = 1;
		public static int y = 1;
		public static int i = 1;
		public static int j = 1;
		public static int k = 1;
		public static int t = 1;
		public static int u = 1;
		public static int rs = 1;
		public static int flow = 1;
		public static int completeEnrollment = 1;	
		public static boolean check;
		
	
		//Wait to load plan page1(wait for the 'Continue' button on the first plan screen/or Enrollment complete on the last page(review and submit).)
	    public static WebElement waitToLoadPlanPage1(WebDriver driver) throws IOException
	    {
	    	if (event.equals("AdminCoverageMaintenance"))
	        { 
	    		try{
	    			element = Utility.waitForElement_ToBeClickable_Id(driver, 30, "btnBacktoReviewSubmit");
	    			element = Utility.waitForElementAvailability_Xpath(driver, 30, "//div[@id='divPlanSection'][@style='display: block;']");	    			
	    		}
	    		catch (Exception ex)
	    		{
	    			
	    		}
	        }
	    	else 
	    	{
	    	try
	          {
	       // element = Utility.waitForElementAvailability_Id(driver, 10, id_ContinueButtonOnAllPlans);
	        element = Utility.waitForElement_ToBeClickable_Id(driver, 10, id_ContinueButtonOnAllPlans);
	          }
	          catch (Exception ex)
	          {
	                //review and submit screen
	                try // using try catch in case of plan loading is taking more time than specified time:
	                {
	                element = Utility.waitForElement_ToBeClickable_Id(driver, 10, id_btn_Save);
	                //element = driver.findElement(By.id(id_btn_Save));
	                }
	                catch (Exception e)
	                {
	                      try
	                      {
	                    	  element = Utility.waitForElement_ToBeClickable_Id(driver, 10, id_ContinueButtonOnAllPlans); 
	                      }
	                      
	                      catch (Exception ex1)
	                      {
	                    	  try
	                    	  {
	                    	  element = Utility.waitForElement_ToBeClickable_Id(driver, 10, id_btn_Save);
	                    	  }
	                    	  catch (Exception ex2)
	                    	  {
	                    		  try
	                    		  {
	                    		  element = Utility.waitForElement_ToBeClickable_Id(driver, 10, id_ContinueButtonOnAllPlans); 
	                    		  }
	                    		  
	                    		  catch (Exception ex3)
	                    		  {
	                    			  try
	                    			  {element = Utility.waitForElement_ToBeClickable_Id(driver, 10, id_btn_Save);
	                    			  }
	                    			  catch (Exception ex4)
	                    			  {
	                    				  logger.info("page is taking more time than specified time.");
	            	                      Utility.captureScreenshot(driver, "PlanPage");
	                    			  }
	                    		  }
	                    	  }
	                      }
	                      
	                }
	          }
	    	}
	          return element;
	          }
	
		//Get the plan name:
		public static WebElement checkThePlanType(WebDriver driver)
		{
			try
			{
				element = driver.findElement(By.xpath("//div[2]/div[1]/div/div/div[1]/div/ul/li["+i+"]")); 
			}
			catch (Exception ex)
			{
				element = driver.findElement(By.id(id_btn_Save));
			}
		i++;
		return element;
		}
			
		//Navigate on the Plan Pages on the base of plan name:	
		public static WebElement planPages(WebDriver driver, String plannam) throws InterruptedException, IOException{
			//Thread.sleep(7000);
	
			int i = 1;
			int j = 1;
			int k = 1;
			//int u = 1;
			alert1 = 1;
		//	Boolean check = true;
			int y = 1;
			
			//Fetch Medical plan type 1st coverage:
			try
			{
				driver.findElement(By.xpath("//form/div/h4/span[1]"));
			}
			catch (Exception ex)
			{
			i++;  // for all other plans it will be 2
			}
			
			//Fetch CI Enrollee's first coverage radio button:
			try
			{
				driver.findElement(By.id("btnEmpOptions"));
			}
			catch (Exception ex)
			{
			j++ ; // for all other plans it will be 2
			}
			
			//Fetch HCFSA text box:
			try
			{
			driver.findElement(By.id(id_HcfsaTextBox));
			}
			catch (Exception ex)
			{
			k++ ; // for all other plans it will be 2
			}
			//System.out.println("values of i, j k " +i+j+k);
			//Fetch Supp Life dropdown box:
			try
			{
				//wait for left box section to be appeared:
				WebDriverWait wait=new WebDriverWait(driver, 10);
				try
				{
			    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath_SuppAdDBox)));
				}
				catch (Exception ex)
				{
					
				}
			driver.findElement(By.xpath(xPath_SuppLifeDropdownbox)).click();
			Thread.sleep(5000);
			//in case not clicked on dropdownbox:
			try
			{
				driver.findElement(By.xpath("//ul[@aria-hidden='false']")).click();
			}
			
			catch (Exception ex1)
			{
				driver.findElement(By.xpath(xPath_SuppLifeDropdownbox)).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//ul[@aria-hidden='false']")).click();
				
			}

			//element.click();
			
			i++;// so that it will avoid i = 1 loop.*/
			}
			catch (Exception ex)
			{
			}
	
			if (i==1&&j==2)
			{
			try
			{
				 Utility.waitForElement_ToBeClickable_Xpath(driver, 5, xPath_MedicalTypeFirstPlan);
			//Select first coverage for 'Medical' type plan:
		        element =driver.findElement(By.xpath(xPath_MedicalTypeFirstPlan));	        
		        JavascriptExecutor executor = (JavascriptExecutor) driver;
		        executor.executeScript("arguments[0].click();", element);
		        
			} catch (Exception ex) {   	
	        }
	        
	        //medical pop up after selecting any coverage:
			try
			{
				driver.findElement(By.xpath(xPath_MedicalPopUp)).click();
			}
			catch (Exception e)
			{	
			}
	
	  //KO question pop up:
		        try
		        {
		        	//wait for the Cancel link to be clickable on KO pop up[:
		        	 
		    	    element = Utility.waitForElement_ToBeClickable_Xpath(driver, 10, xPath_KoPopupCancelLink);
		        	 //collect all dropdowns on the KO pop up screen:
		            List<WebElement> dropdown = driver.findElements(By.tagName("select"));
		            //Enter values in all KO dropdowns:
		            int dpsize = dropdown.size();
		            //if(clientType.equals("EBX"))
		            //{
		            	//dpsize--;
		           // }
		            
		            for (int p=0; p<dpsize; p++)       	 
		    		{
		            	  Select a = new Select (driver.findElement(By.xpath("//tbody/tr["+y+"]/td[2]/select")));
			    			a.selectByIndex(1);
			    			y=y+2;
		    		}
		            //Collect all text boxes:
		           List<WebElement> responseText = driver.findElements(By.xpath(xPath_responseText));
		           //System.out.println("responseText size "+ responseText.size());
		           for(int z = 0; z<responseText.size(); z++) {
		        	   if(responseText.get(z).isDisplayed())
		        	   {
		        	   responseText.get(z).sendKeys(responseTextValue);   
		        	   }
		            }
		            //Collect all response type:
		            List<WebElement> responseType = driver.findElements(By.xpath(xPath_responseType));
		            for(WebElement e : responseType) {
	                    try
	                    {
	                        e.sendKeys(responseTypeValue);
	                    }catch (Exception ex){
	                    }
	            	}
	
		            //Click on KO pop up Continue button:
		            driver.findElement(By.id(id_KoPopupContinueButton)).click();
		    			//click on agree button in case of correct answers.:
		    			try
		    			{
		    				//wait for the Agree button:	
	    			    element = Utility.waitForElement_ToBeClickable_Xpath(driver, 7, xPath_KoPopupAgreeButton);
	    			  //click on Agree button in case of correct answers.:
		    				driver.findElement(By.xpath(xPath_KoPopupAgreeButton)).click();
		    			}
		    			catch (Exception e)
		    			{
		    			}
		    			//click on close button if "incorrect" answer:
		    			
		    			try
		    			{
		    				//wait for the close button:
		    				
		    			    element = Utility.waitForElement_ToBeClickable_Xpath(driver, 7, id_KoPopupCloseButton);
		    			  //click on close button if "incorrect" answer:
		    				driver.findElement(By.id(id_KoPopupCloseButton)).click();
		    			}
		    			catch (Exception e)
		    			{
		    			}	    				    		
		    	    //click on Cancel link on KO pop up:
		        }
		        catch (Exception ex)
		        {
		        	
		        }
			}
		
		///////////////////////////CI type//////////////////////////////////////////
				//Answer tobacco question:
		 if(j==1)
		 {		 
		      try{
					 Utility.waitForElementAvailability_Xpath(driver, 30, xPath_CIEnrolleeFirstCoverage);
					//wait for Tobacco dropdown to be present:
					 Utility.waitForElementAvailability_Xpath(driver, 30, xPath_CITobaccoDropdown);
				//Select Tobacco answers from dropdown:
				Select tobdropque = new Select (driver.findElement(By.xpath(xPath_CITobaccoDropdown)));
				tobdropque.selectByVisibleText(tobaccoAnswersInPlanPages);
				////driver.findElement(By.xpath(xPath_CITobaccoDropdown)).click();
	            
				
				//select No from Tobacco dropdown:
				//tobaccodropdown.selectByVisibleText(CITobaccoDropdownResponse);
	
	
				}
				
				catch (Exception e)
				{
				}
						
				//in case of first alert , then switch to alert:
				
				try
				{
				Alert alert = driver.switchTo().alert();
				alert.accept();
				}
				catch (Exception e)
				{
					
				}
				
				//Wait until first coverage for employee is clickable:
				try
				{
			    element = Utility.waitForElement_ToBeClickable_Xpath(driver, 30, xPath_CIEnrolleeFirstCoverage);
				}
				catch (Exception e)
				{
					
				}
				
				
				//select first coverage for empolyee:			
				try
				{
				element = driver.findElement(By.xpath(xPath_CIEnrolleeFirstCoverage));
				element.click();
				}
				
				catch (Exception e)
				{
				
				}
				
				//in case of first alert, then switch to alert:
				
				try
				{
				Alert alert = driver.switchTo().alert();
				alert.accept();
				}
				catch (Exception e)
				{
					
				}
				
				try
				{
					//wait for the Cancel link to be clickable on KO pop up:
					Utility.waitForElement_ToBeClickable_Xpath(driver, 30, xPath_CIKoPopupCancelButton);  
					
				//Click Cancel button on KO pop up: 
				
				driver.findElement(By.xpath(xPath_CIKoPopupCancelButton)).click();
				}
				
				catch(Exception ex)
				{
					
				}
		        
		 }
		 
			/////////////////////////HCFSA type/////////////////////
		if (k==1)
		{
			        try
					{
			        element =driver.findElement(By.id("id_HcfsaTextBox"));
			        //element.click();
			        //element.clear();
			        //element.sendKeys("1000");
					}
					catch (Exception ex)
					{
						
					}
		
		} 
		////////////////////// To add Beneficiary////////////////
		
		
			//Fetch beneficiaray check box:
			try
			{
			//Click on Beneficiary link:
				Utility.waitForElementAvailability_Xpath(driver, 5, xPath_BeniArrowOnPlan);
			WebElement checkbox1 = driver.findElement(By.xpath(xPath_BeniArrowOnPlan));
			checkbox1.click();
			/////////////////
			// Beneficiary Checkbox:
			WebElement selectBeniCheckbox = driver.findElement(By.xpath(xPath_BeneficiaryCheckbox));
			Boolean select = selectBeniCheckbox.isSelected();
		
			if (!select)
			{
				selectBeniCheckbox.click();
			}	    	
		
			//select  beneficiarray type as primaray radio button:
			driver.findElement(By.xpath(xPath_BeniradioButton)).click();
		
		}
		catch (Exception ex)
		{	
		}
		
		/////////////////////reminder pop up for STD and LTD plans like for 2536 in UAT///////////////////////
		//wait for 2 sec:
		
		try
		{
			Utility.waitForElementAvailability_Id(driver, 5, id_StdReminderPopupButton);
		driver.findElement(By.id(id_StdReminderPopupButton)).click();
		}
		catch (Exception ex)
		{
			//logger.info("Popup close button not identified");
		}
		/////////////////Spousal Surcharge - test(radio button)///////////
		
		try
		{
		WebElement element = driver.findElement(By.xpath("//*[@name='OptionID'][@type='radio']"));
		element.click();

		}
		catch (Exception ex)
		{
			
		}
		
		/////////////////////////Rate your knowledge ////////////////////
		
		if(j!=1&&i!=1)
		{
		try
		{
		List<WebElement> radios = driver.findElements(By.xpath("//*[@type='radio']"));
		 //System.out.println("number of radio buttons"+radios.size());
		 radios.get(0).click();//click on first element (None)
		 radios.get(7).click(); //click on last element (Favorable)
		}
		catch (Exception ex)
		{
			
		}
		}

		///////////////////////click on Continue button///////////////////////////////////////////////
		if (event.equals("lifeEvent") || event.equals("AE"))
		{
			        // wait for the continue button to be clickable:
				    element = Utility.waitForElement_ToBeClickable_Id(driver, 30, id_ContinueButtonOnAllPlans);
				  //wait for 1 sec:
				    Utility.waitForElementAvailability_Id(driver, 3, id_ContinueButtonOnAllPlans);
			        
			        //Click on Continue button on plan page:
		
			        WebElement continuegroupHospitalIndemnity = driver.findElement(By.id(id_ContinueButtonOnAllPlans));
			        
			        try
			        {
			        continuegroupHospitalIndemnity.click();
			        
			        }
			        
			        catch (Exception ex)
			        {
			        	//in case of continue button is not clickable:
			        	
			 	        Utility.captureScreenshot(driver, plannam);
			       //driver.close();
			        }	
			        
			        //for pet insurance plan page, when we are not adding any pet and just continue the flow:
			        
			        try
			        {
			        	driver.findElement(By.id("okBtn"));
			        	driver.findElement(By.id("okBtn")).click();
			        	
			        }
			        catch (Exception ex)
			        {
			        	
			        }
			        
			        
			        //in case of Continue button is clickable but still it is not processing further due to some reasons
			        //(e.g. coverage are not defined/not selected).
			        try
			        {
			        	Utility.waitForElementAvailability_Id(driver, 5, id_btn_Close);
			        	driver.findElement(By.id(id_btn_Close));
			        	Utility.captureScreenshot(driver, plannam);
			        	
			        }
			        catch (Exception ex)
			        {
			        	
			        }
				}
				if(event.equals("AdminCoverageMaintenance"))
				{
					try
					{
						// wait for the  backtoReviewAndSubmit button to be clickable:
				    element = Utility.waitForElement_ToBeClickable_Id(driver, 7, id_backtoReviewAndSubmit);
				    element.click();
					}
					catch (Exception ex)
					{

					}		
					
					try
					{
						// wait for the continue button to be clickable:
					    element = Utility.waitForElement_ToBeClickable_Id(driver, 30, "btnNext");	
					    element.click();
					}
					
					catch (Exception ex)
					{
						try
						{
							driver.findElement(By.id("closeBtn"));
							Utility.captureScreenshot(driver, plannam);
						}
                        catch (Exception ex1)
                        {
                        }
					}	
				
				    try
				    {
				    	element = driver.findElement(By.id("btnEligibilityUpdateDialog"));
				    	element.click();
				    }
				    
				    catch (Exception ex)
				    {
				    	try
						{
							driver.findElement(By.id("closeBtn"));
							Utility.captureScreenshot(driver, plannam);
						}
                        catch (Exception ex1)
                        {
                        }
				    }
				    
				///////////////////////////////////////////////////////////////////////
				    try
				    {
					// wait for the continue button to be clickable on pop up:
				    element = Utility.waitForElement_ToBeClickable_Id(driver, 7, id_backtoReviewAndSubmitpopup);
				    
				  //Click on Continue button on pop up:
				
				    WebElement backtoReviewAndSubmitButtonpopup = driver.findElement(By.id(id_backtoReviewAndSubmitpopup));
				    backtoReviewAndSubmitButtonpopup.click();
				    }
				    catch (Exception ex)
				    {
				    	
				    }
				    
				///////////////////////////////////////////////////////////////////////
					
					        
				}	        
			       //in case of pop up after clicking continue button:
			        try { 
			        	//wait for 3 sec:
			        	Utility.waitForElementAvailability_Xpath(driver, 3, xPath_PopupAfterClickingContinueButton);
			        	element = driver.findElement(By.xpath(xPath_PopupAfterClickingContinueButton));
			        	element.click();
			        }
			        
			        catch(Exception ex) {
			        }
			        
			        //in case of pop up message to wave out medical plan:
			        //enter text on pop up message to wave out medical plan:
			        try
			        {
			        	Utility.waitForElementAvailability_Xpath(driver, 3, xPath_MedicalPopupWaveOut);
			        WebElement medicalPopupWaveOut = driver.findElement(By.xpath(xPath_MedicalPopupWaveOut));
			        medicalPopupWaveOut.clear();
			        medicalPopupWaveOut.sendKeys(medicalPopupWaveOutText);
			        // Click Continue button on pop up:
			        WebElement medicalPopupWaveOutContinueButton = driver.findElement(By.xpath(xPath_MedicalPopupWaveOutContinueButton));   
			        medicalPopupWaveOutContinueButton.click();
			        }
			        
			        catch (Exception ex) {
			        }
			        
			        return element;
		
				}
		
			// Survey screen:	
			public static WebElement survey(WebDriver driver) throws InterruptedException
			{
		        //Answer survey questions:
				List<WebElement> surveyQuestion = driver.findElements(By.tagName("select"));
				for(int survey = 1; survey<= surveyQuestion.size(); survey++ )
				{
					Select surveyanswers = new Select(driver.findElement(By.xpath("//form/div/div/div/div[2]/div/div["+survey+"]/div[2]/select")));
					surveyanswers.selectByIndex(1);
				}
				
		        //click on Continue button on 'Survey' screen:
		        WebElement continuesuppLife = driver.findElement(By.xpath(xPath_ContinueButtonOnAllPlansAndSurveySCreen));
		        continuesuppLife.click();
		        return element;
		        
			}
			
			//Check the Review and Submit Plan :
			public static WebElement reviewSubmitPlan(WebDriver driver, String xPath_reviewSubmitPlan )
			{
			element = driver.findElement(By.xpath(xPath_reviewSubmitPlan)); 
			return element;
			}
				
			// reviewAndSubmit Plan:	
			public static WebElement reviewAndSubmit(WebDriver driver) throws InterruptedException
			{
				
				//Enter respose question:
				element = driver.findElement(By.id(id_ResposeQuestionTextbox));
				element.clear();
				element.sendKeys(resposeQuestionText);
				
		        //Click on 'Complete Enrollment' button on 'Review and Submit' screen:
		        WebElement completeEnrollmentButton = driver.findElement(By.xpath(xPath_CompleteEnrollmentButton));
		        completeEnrollmentButton.click();
		        //System.out.println("Review and Submit: Passed");
		        return element;
		        
			}		
			//plan checking:
		        
		        public static WebElement navigateOnPlan(WebDriver driver, String plannam )throws InterruptedException, IOException
		        {
		        	if (!(plannam.equals(Survey) || plannam.equals(Review)))
		        	{
		        		planPages(driver, plannam);
		        		logger.info("passed "+plannam);
		        	} else if (plannam.equals("Survey")) 	{
		        		survey(driver);
		        		logger.info("passed-Survey");
		        	} else if (plannam.equals("Review & Submit"))
		        	{
		        		reviewAndSubmit(driver);
		        		logger.info("passed-Review & Submit");
		        		logger.info("Enrollment has been completed.");
		        	}
		        	
		   return element;
		        }
		}
		
