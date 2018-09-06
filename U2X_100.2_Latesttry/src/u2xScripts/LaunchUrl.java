package u2xScripts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class LaunchUrl {
	
	public static WebElement element = null;
	
		//Launch Chrome browser
		public static WebDriver launchBaseUrl(String baseUrl, String browserpath)
		{
		System.setProperty("webdriver.chrome.driver",browserpath);
		WebDriver driver = new ChromeDriver();
		// launch Weezer_QA screen
        driver.get(baseUrl);
       //maximize window:
        driver.manage().window().maximize();
        return driver;    
        
	}

}
