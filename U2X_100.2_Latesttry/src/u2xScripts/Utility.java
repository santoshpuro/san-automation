package u2xScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import u2xVariable.U2xVariable;


public class Utility extends U2xVariable{
	
	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	public static void captureScreenshot(WebDriver driver,String screenshotName) throws IOException {
		  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	try 
	{
		logger.trace("");
		logger.warn("Use following data to reproduce it");
        logger.error("User Name : "+userName);
		logger.error("User ID : "+uId);
		logger.error("Organiztion Id : "+organiztionId);
		logger.error("System Date : "+systemDate);
		logger.error("Application Name : "+applicationname);
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+"_"+sdf.format(timestamp)+".png"));
		logger.info("Screenshot taken");
		logger.error("Not able to launch next screen. Please refer screenshot for more details.");
		System.exit(1);
		driver.quit();		
		} 
	catch (Exception e){
		logger.info("Exception while taking screenshot "+e.getMessage());
		} 
	}
	
	public static void GetExcelData(WebDriver driver) throws IOException {

		FileInputStream fis;
		try {

			current = new java.io.File( "." ).getCanonicalPath();
		   
						
			int sep = current.replace("\\", "/").lastIndexOf("/");
			excelData = current.replace("\\", "/").substring(0, sep)+"\\Data.xlsx";
			
//			excelData = current+"\\Data.xlsx";
			
			logger.info("Excel Data Path : "+excelData);
			

			fis = new FileInputStream(excelData);//
			
			XSSFWorkbook work = new XSSFWorkbook(fis); 
			XSSFSheet sheet=work.getSheet("SetUP");
			//System.out.println("sheet.getLastRowNum() "+ sheet.getLastRowNum());

			for (int i =1; i <=1; i++) { 
				XSSFRow row = sheet.getRow(i); 
				
				if(row.getCell(0).getStringCellValue().toUpperCase().trim().equalsIgnoreCase("YES")){
				System.out.println("Execute : "+row.getCell(0).getStringCellValue().toUpperCase().trim());
				userName = row.getCell(1).getStringCellValue();
				organiztionId =  row.getCell(2).getRawValue();
				clientType =  row.getCell(3).getStringCellValue();
				applicationname =  row.getCell(4).getStringCellValue();
				reasonCode =  row.getCell(5).getStringCellValue();
				uId =  row.getCell(6).getRawValue();
				systemDate =  row.getCell(7).getStringCellValue();
				SS_UserName =  row.getCell(8).getStringCellValue();
				SS_Password =  row.getCell(9).getStringCellValue();
				event =  row.getCell(10).getStringCellValue();
				url = row.getCell(11).getStringCellValue();
				
				logger.info("UID  : "+uId);
				logger.info("OrganiztionId : "+organiztionId);
				logger.info("clientType : "+clientType);
				logger.info("applicationname : "+applicationname);
				logger.info("event : "+event);	
				logger.info("systemDate : "+systemDate);	
				logger.info("url : "+url);	
				}
				else
				{
					logger.info("Please select 'TO_EXECUTE' column value as 'Yes' in Data sheet");
					System.exit(1);
					driver.quit();
				}
			}
		} catch (FileNotFoundException e1) {
			
			logger.error("Excel Path Not Identified");
		}; 
	}
	
	 public static WebElement waitForElementAvailability_Id(WebDriver driver, int time, String path)
     {
         WebDriverWait wait=new WebDriverWait(driver, time);
         WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(path)));
         return element;
     }
	 public static WebElement waitForElementAvailability_Xpath(WebDriver driver, int time, String path)
     {
         WebDriverWait wait=new WebDriverWait(driver, time);
         WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(path)));
         return element;
     }
	 
	 public static WebElement waitForElement_ToBeClickable_Xpath(WebDriver driver, int time, String path)
     {
         WebDriverWait wait=new WebDriverWait(driver, time);
         WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(path)));
         return element;
     }
	 
	 public static WebElement waitForElement_ToBeClickable_Id(WebDriver driver, int time, String path)
     {
         WebDriverWait wait=new WebDriverWait(driver, time);
         WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id(path)));
         return element;
     }
	 

}
