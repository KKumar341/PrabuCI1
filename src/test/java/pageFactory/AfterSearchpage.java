package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AfterSearchpage {

	
	
	
public WebDriver driver;
	
	public AfterSearchpage(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		
	}
	@FindBy (xpath=".//*[@id='ctl00_ContentPlaceHolder1_lblTopListn']/strong[2]")
	WebElement searchtxt;	
	public String gettext() {
		String text = searchtxt.getText();
		return text;
		
	}
}
