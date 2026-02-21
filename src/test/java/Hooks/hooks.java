package Hooks;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

import Utils.drivermanager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks {



	@Before
	public void DriverSetUp() {
		drivermanager.DriverInit();

	}

	@After
	public void tearDown(Scenario scenario) {

		try {
			if (scenario.isFailed()) {
				File screenshot = ((TakesScreenshot) drivermanager.getDriver()).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(screenshot, new File("target/screenshots/" + scenario.getName() + ".png"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			drivermanager.QuitBrowser();
		}
		
		drivermanager.QuitBrowser();

	}

}
