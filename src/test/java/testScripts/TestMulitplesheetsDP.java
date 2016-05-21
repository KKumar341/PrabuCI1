package testScripts;

import genericLib.Baseclass;

import java.util.HashMap;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageFactory.AfterSearchpage;
import pageFactory.SearchPage;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.CBIndiaDP;
import dataProvider.MultipleDP;

public class TestMulitplesheetsDP extends Baseclass{

	SearchPage search;
	AfterSearchpage Asearch;
	SoftAssert sAssert= new SoftAssert();
	ExtentReports exp;
	ExtentTest logger;
	
	
	@Test(dataProvider="CBIndia_mulitpleEndtoEnd1",dataProviderClass=MultipleDP.class,priority=0)
	public void booksearch_EndtoEnd1(HashMap<String, String> hmap1){	

		System.out.println("HomePage values are " + hmap1.get("Bookname"));
		System.out.println("HomePage values are " + hmap1.get("ISBN_NUM"));
		System.out.println("HomePage values are " + hmap1.get("noofBooks"));
		
		System.out.println("Sheet2 values are " + hmap1.get("A"));
		System.out.println("Sheet2 values are " + hmap1.get("B"));
		
		System.out.println("Sheet3 values are " + hmap1.get("AA"));
		System.out.println("Sheet3 values are " + hmap1.get("BB"));
		System.out.println("Sheet3 values are " + hmap1.get("CC"));
	}
	
//	@Test(dataProvider="CBIndia_mulitpleEndtoEnd2",dataProviderClass=MultipleDP.class,priority=1)
//	public void booksearch_EndtoEnd2(HashMap<String, String> hmap1){	
//
//		System.out.println("HomePage values are " + hmap1.get("Bookname"));
//		System.out.println("HomePage values are " + hmap1.get("ISBN_NUM"));
//		System.out.println("HomePage values are " + hmap1.get("noofBooks"));
//		
//		System.out.println("Sheet2 values are " + hmap1.get("A"));
//		System.out.println("Sheet2 values are " + hmap1.get("B"));
//		System.out.println("Sheet2 values are " + hmap1.get("C"));
//		
//		System.out.println("Sheet3 values are " + hmap1.get("AA"));
//		System.out.println("Sheet3 values are " + hmap1.get("BB"));
//		System.out.println("Sheet3 values are " + hmap1.get("CC"));
//	}
}
