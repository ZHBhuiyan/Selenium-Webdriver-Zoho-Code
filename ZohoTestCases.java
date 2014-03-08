package zohoexerciseinterview;

import java.net.MalformedURLException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class ZohoTestCases extends DriverInitialization{
	@AfterTest
  	public void quitTest(){
	  	driver.quit();
	}
	//The method below will automate login and logout operations in https://www.zoho.com/crm/ website
	@Test(priority=1)
  	public void zohoLogin() throws MalformedURLException {
		WebDriverWait myWait=new WebDriverWait(driver, 10);
	  	driver.manage().window().maximize();
		driver.get("https://www.zoho.com/crm/");
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign In")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
		driver.findElement(By.linkText("Sign In")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zohoiam")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.id("zohoiam")));
		driver.switchTo().frame("zohoiam");
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lid")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.id("lid")));
		driver.findElement(By.id("lid")).sendKeys("joeklienwatir@gmail.com ");
		driver.findElement(By.id("pwd")).sendKeys("watir001");
		driver.findElement(By.id("submit_but")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topuserphoto_170457000000033001")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.id("topuserphoto_170457000000033001")));
		driver.findElement(By.id("topuserphoto_170457000000033001")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value=\"Sign Out\"]")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"Sign Out\"]")));
		driver.findElement(By.cssSelector("input[value=\"Sign Out\"]")).click();
  }
	@Test(priority=2)
  	public void zohoLoginAndCreateAccount() throws MalformedURLException {
		WebDriverWait myWait=new WebDriverWait(driver, 10);
	  	driver.manage().window().maximize();
		driver.get("https://www.zoho.com/crm/");
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign In")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
		driver.findElement(By.linkText("Sign In")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zohoiam")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.id("zohoiam")));
		driver.switchTo().frame("zohoiam");
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lid")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.id("lid")));
		driver.findElement(By.id("lid")).sendKeys("joeklienwatir@gmail.com ");
		driver.findElement(By.id("pwd")).sendKeys("watir001");
		driver.findElement(By.id("submit_but")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab_Accounts")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.id("tab_Accounts")));
		driver.findElement(By.id("tab_Accounts")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value=\"New Account\"]")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"New Account\"]")));
		driver.findElement(By.cssSelector("input[value=\"New Account\"]")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("property(Account Number)")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.id("property(Account Number)")));
		String accNo=RandomStringUtils.randomNumeric(2);
		driver.findElement(By.id("property(Account Name)")).sendKeys("Test Account #"+accNo);
		driver.findElement(By.id("property(Phone)")).sendKeys("4049363568");
		String mainWindowHandle=driver.getWindowHandle();
		System.out.println(mainWindowHandle);
		driver.findElement(By.cssSelector("img[title=\"Account Name Lookup\"]")).click();
		Set s1 = driver.getWindowHandles();
		Iterator ite1 = s1.iterator();
		while(ite1.hasNext())
        {
             String popupHandle=ite1.next().toString();
             if(!popupHandle.contains(mainWindowHandle))
             {
                   driver.switchTo().window(popupHandle);
                   System.out.println(popupHandle);
             }
        }
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Acct 20130806135541")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Acct 20130806135541")));
		driver.findElement(By.linkText("Acct 20130806135541")).click();
		driver.switchTo().window(mainWindowHandle);
		Select accountType=new Select(driver.findElement(By.name("property(Account Type)")));
		accountType.selectByValue("Analyst");
		Select industry=new Select(driver.findElement(By.name("property(Industry)")));
		industry.selectByValue("ASP");
		driver.findElement(By.id("property(Billing Street)")).sendKeys("101 Main Street");
		driver.findElement(By.id("property(Billing City)")).sendKeys("San Francisco");
		driver.findElement(By.id("property(Billing State)")).sendKeys("CA");
		driver.findElement(By.id("property(Billing Code)")).sendKeys("94102");
		driver.findElement(By.id("property(Billing Country)")).sendKeys("USA");
		driver.findElement(By.id("copyAddress")).click();
		driver.findElement(By.className("dropDownItem")).click();
		driver.findElement(By.id("property(Description)")).sendKeys("This is a test description");
		driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("topuserphoto_170457000000033001")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.id("topuserphoto_170457000000033001")));
		driver.findElement(By.id("topuserphoto_170457000000033001")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value=\"Sign Out\"]")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"Sign Out\"]")));
		driver.findElement(By.cssSelector("input[value=\"Sign Out\"]")).click();
	}
  	@Test(priority=3)
  	public void zohoLoginAndClickingOnSaveWithoutInput() throws MalformedURLException {
  		WebDriverWait myWait=new WebDriverWait(driver, 20);
	  	driver.manage().window().maximize();
		driver.get("https://www.zoho.com/crm/");
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sign In")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.linkText("Sign In")));
		driver.findElement(By.linkText("Sign In")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("zohoiam")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.id("zohoiam")));
		driver.switchTo().frame("zohoiam");
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lid")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.id("lid")));
		driver.findElement(By.id("lid")).sendKeys("joeklienwatir@gmail.com ");
		driver.findElement(By.id("pwd")).sendKeys("watir001");
		driver.findElement(By.id("submit_but")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("tab_Accounts")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.id("tab_Accounts")));
		driver.findElement(By.id("tab_Accounts")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[value=\"New Account\"]")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[value=\"New Account\"]")));
		driver.findElement(By.cssSelector("input[value=\"New Account\"]")).click();
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("property(Account Number)")));
		myWait.until(ExpectedConditions.elementToBeClickable(By.id("property(Account Number)")));
		
		
		//driver.findElement(By.id("property(Description)")).sendKeys("This is a test description");
		driver.findElement(By.cssSelector("input[value=\"Save\"]")).click();
		String msgText = driver.switchTo().alert().getText();
		Assert.assertEquals(msgText, "Account Name cannot be empty");
		driver.switchTo().alert().accept();
		
  	}
}
