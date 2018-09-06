package u2xScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import u2xVariable.U2xVariable;

public class LoginPage extends U2xVariable 
{	
public static WebElement element = null;

//Do all LoiginPage functionalities:
public static WebElement LoginPageFunctiontalities (WebDriver driver)
{
	element = driver.findElement(By.id(iD_userName));
	//element.sendKeys(guID);
	element.sendKeys(userName);
    logger.info("Enter User Name");

//Employee Organization Id element:
	element = driver.findElement(By.id(iD_orgId));
	element.sendKeys(organiztionId);
    logger.info("Enter Organization ID");

//Login button:
	element = driver.findElement(By.id(iD_logbtn)); 
	element.click();	
	logger.info("Click on the Login button");

return element;
}
}