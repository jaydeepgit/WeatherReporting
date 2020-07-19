package ndtvUI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase {
	public  static WebDriver driver;

	public static void initialization() {
	
		    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/BrowserDrivers/chromedriver.exe");
		    driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get("https://www.ndtv.com/");	
		
	}
	}
     
           
