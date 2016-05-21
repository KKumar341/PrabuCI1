package pageFactory;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPage {
	public WebDriver driver;
	
	public SearchPage(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (xpath=".//*[@id='ctl00_txtSearch']")
	WebElement searchtxtbox;	
	@FindBy (xpath=".//*[@id='ctl00_ImageButton1']")
	WebElement searchbtn;
	
	public void entertext(String text) {
		searchtxtbox.sendKeys(text);
	}
	public void  searchbooks() {		
		searchbtn.click();
	}
	
	public String handlealert( WebDriver driver) {	
		Alert alert = driver.switchTo().alert();
		String text = alert.getText();
		alert.accept();
		return text;
	}

}
