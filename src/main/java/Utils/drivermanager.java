package Utils;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class drivermanager {
	
	private static WebDriver driver;
	
	
	public static WebDriver DriverInit() {
		
		if(driver == null) {
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--incognito");
			driver = new ChromeDriver(options);
				driver.manage().window().maximize();
		}
			return driver;
	}
	
	public static WebDriver getDriver() {
        return driver;
    }

	
	public static void QuitBrowser() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
