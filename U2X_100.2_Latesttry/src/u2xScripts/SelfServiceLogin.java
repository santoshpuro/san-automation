package u2xScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import u2xVariable.U2xVariable;

public class SelfServiceLogin extends U2xVariable {

public static WebElement element = null;
public static WebElement waitForElement;
public static Select select = null;

//wait for Login text box to be present:
public static WebElement SelfServiceLoginFunctionalities(WebDriver driver)
{
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(id_SSUserName)));

//Enter User name:
	element = driver.findElement(By.id(id_SSUserName));
	element.sendKeys(SS_UserName);
    logger.info("Enter UserName");

//Enter Password:
	element = driver.findElement(By.id(id_SSPassword));
	element.sendKeys(SS_Password);
    logger.info("Enter Password");

//Login Button:
	element = driver.findElement(By.id(id_SSLoginButton));
	element.click();
    logger.info("Click on Login Button");
	return element;
}
}