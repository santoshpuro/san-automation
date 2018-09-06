package u2xScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import u2xVariable.U2xVariable;
public class WeezerQaPage extends U2xVariable{
	
public static WebElement element = null;
public static WebElement waitForElement;
public static Select select = null;

//Enter System Date:
public static WebElement WeezerQaPageFunctionalites(WebDriver driver)
{
element = driver.findElement(By.id(xId_systemDate));
element.clear();
element.sendKeys(systemDate);
logger.info("Enter System Data");

//Application Type select as 'U2X Admin' from dropdown for Counsler/SelfService Login:
select = new Select(driver.findElement(By.id(xId_ddlApplication)));	
select.selectByVisibleText(applicationname);
logger.info("Select Application Name from dropdown");

//Click on Login button:
element = driver.findElement(By.id(xId_btnAdminLogin)); 
element.click();
logger.info("Click on the Login button to open Home Page"); 
return element;
}
}