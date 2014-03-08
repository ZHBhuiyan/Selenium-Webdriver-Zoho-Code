package zohoexerciseinterview;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DriverInitialization {
	WebDriver driver;
	String nodeURL;
	@BeforeTest
	@Parameters({"browser"})
	public void setUpNode(String browser) throws MalformedURLException{
		
		
		switch(browser){

	    case "chrome":
	    	System.setProperty("webdriver.chrome.driver", "C:\\Sel Server\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

	        break;

	    case "remoteNodeFirefoxWinVista":
	    	nodeURL="http://192.168.1.30:5566/wd/hub";
			DesiredCapabilities capability1=DesiredCapabilities.firefox();
			capability1.setBrowserName("firefox");
			capability1.setPlatform(Platform.VISTA);
			driver=new RemoteWebDriver(new URL(nodeURL),capability1);
	        break;

	    	default:
	        break;
	}
	}
}
