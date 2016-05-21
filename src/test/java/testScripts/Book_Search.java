package testScripts;

import java.util.HashMap;

import genericLib.Baseclass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.CBIndiaDP;
import pageFactory.AfterSearchpage;
import pageFactory.SearchPage;

public class Book_Search extends Baseclass{	
	
//	public WebDriver driver;
	SearchPage search;
	AfterSearchpage Asearch;
	SoftAssert sAssert= new SoftAssert();
	ExtentReports exp;
	ExtentTest logger;
	
	
	@Test(dataProvider="CBIndia_invalid",dataProviderClass=CBIndiaDP.class,priority=0)
	public void booksearch_invalid(HashMap<String, String> hmap1){	
		exp= new ExtentReports("F:\\SeleniumProjects\\Cb-IndiaProject\\Reports\\testreports.html");
		logger=exp.startTest("booksearch_invalid");
		System.out.println("Script name is "+ hmap1.get("scriptname"));
		System.out.println("DP values are " +hmap1.get("Bookname"));
		search= new SearchPage(driver);
		search.entertext(hmap1.get("Bookname"));
		logger.log(LogStatus.PASS, "Entered the bookname");
		search.searchbooks();
		logger.log(LogStatus.PASS, "Clicked on search button");
		String handlealert = search.handlealert(driver);
		System.out.println(handlealert);
		logger.log(LogStatus.PASS, "Clicked on search button" +handlealert);
		exp.endTest(logger);
		exp.flush();

}
	
	@Test(dataProvider="CBIndia_valid",dataProviderClass=CBIndiaDP.class,priority=1)
	public void booksearch_valid(HashMap<String, String> hmap1) throws InterruptedException {
		System.out.println("Script name is "+ hmap1.get("scriptname"));
		System.out.println("DP values are " +hmap1.get("Bookname"));
		search= new SearchPage(driver);
		logger=exp.startTest("booksearch_valid");
		search.entertext(hmap1.get("Bookname"));		
		search.searchbooks();
		Thread.sleep(2000);
		logger.log(LogStatus.PASS, "Entered the bookname and clicked on search button");
		Asearch= new AfterSearchpage(driver);
		String gettext = Asearch.gettext();
		System.out.println("Number of books are " +gettext);
		sAssert.assertEquals(gettext, hmap1.get("noofBooks"));	
		logger.log(LogStatus.PASS, "Verified the text as "+gettext);
		exp.endTest(logger);
		exp.flush();
	}

}
