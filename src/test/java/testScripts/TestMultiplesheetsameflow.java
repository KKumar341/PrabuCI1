package testScripts;

import java.util.HashMap;
import org.testng.annotations.Test;
import dataProvider.MultipleDPsameflow;
public class TestMultiplesheetsameflow {

	
	@Test(dataProvider="CBIndia_mulitplesameflowEndtoEnd1",dataProviderClass=MultipleDPsameflow.class,priority=0)
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
}
