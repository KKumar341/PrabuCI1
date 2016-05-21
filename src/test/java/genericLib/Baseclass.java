package genericLib;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Baseclass {
	
public WebDriver driver;
Logger log= Logger.getLogger(Baseclass.class);

//@Parameters ({"browser"})
//@BeforeMethod
//public void launchApp(String browname) throws InterruptedException {	
//	System.out.println("Before method" +browname);
//	Thread.sleep(3000);
//	if (browname.equals("Firefox")) {
//		driver= new FirefoxDriver();
////		http://cb-india.com/Search.aspx
//		driver.get("http://www.cb-india.com/");
//		driver.manage().window().maximize();
//		log.info("Launched the Firefox Browser ");
//	} else if (browname.equals("Chrome")) {
//		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_Softwares\\chromedriver_win32\\chromedriver.exe");
//		driver= new ChromeDriver();
//		driver.get("https://www.google.com");		
//		log.info("Launched the  Chrome Browser");
//	} else {
//		System.setProperty("webdriver.ie.driver", "F:\\Selenium_Softwares\\IEDriver64bit\\IEDriverServer.exe");
//		driver= new InternetExplorerDriver();
//		driver.get("https://www.google.co.in/");
//		log.info("Launched the IE Browser");
//	}
//}

@BeforeMethod
public void launchApp() throws InterruptedException {
	driver= new FirefoxDriver();
	driver.get("http://www.cb-india.com/");
	driver.manage().window().maximize();
	Thread.sleep(3000);
	log.info("Lunched the Firefox browser ");
}

@AfterMethod
public void closeApp() {
	driver.close();
	System.out.println("Closed the browser");
}

public void objectwait(WebElement wait) {
	WebDriverWait expwait = new WebDriverWait(driver, 10);
	WebElement objuntil = expwait.until(ExpectedConditions.visibilityOf(wait));
	if (objuntil.isDisplayed()) {		
		System.out.println("Object appeared in 10 secs");		
	} else {
		System.out.println("Object not Found in 10 secs");
  }
	
 }

public void navigateurl(String Url) {
	driver.navigate().to(Url);;
	
}
}
