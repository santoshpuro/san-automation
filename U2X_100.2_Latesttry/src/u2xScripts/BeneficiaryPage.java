package u2xScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import u2xVariable.U2xVariable;

public class BeneficiaryPage extends U2xVariable {
    
    public static WebElement element;
    public static int beniFilter = 1;
    
    public static WebElement beneficiaryPageFunctionalities(WebDriver driver)
    {
        // WebElement waitForContinueButton;
        try
        {
        Utility.waitForElement_ToBeClickable_Xpath(driver, 30, xPath_AddpersonButton);
        beniFilter++; // 2
        }
        catch (Exception ex)
        {
        }
        if (beniFilter == 2) //in case of beneficiary tab is there, it will process further:
        {
    // Beneficiary Checkbox:
        WebElement selectBeniCheckbox = driver.findElement(By.xpath(xPath_AddpersonButton));
        Boolean select = selectBeniCheckbox.isSelected();
        
        if (!select)
        {
          selectBeniCheckbox.click();
        }       

//select  beneficiarray type as primaray radio button:
        element = driver.findElement(By.xpath(primarayRadioButton));
        element.click();
   
//Click On 'Save Allocation' button:
        element = driver.findElement(By.id(id_CompleteEnrollmentButton));
        element.click();
        
//Wait for OK button on pop up:
        Utility.waitForElement_ToBeClickable_Id(driver, 30, id_StdReminderPopupButton);
     
        
//Click on OK button on pop up:
        element = driver.findElement(By.id(id_StdReminderPopupButton));
        element.click();
//Click on Continue button on Beneficiary page:

          element = driver.findElement(By.id(id_ContinueButtonOnFamilyPage));
          element.click();
        }
          return element;
    }     

}
