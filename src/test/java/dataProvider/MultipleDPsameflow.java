package dataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import excelReadwrite.ExcelReadWrite;

public class MultipleDPsameflow {

	@DataProvider(name="CBIndia_mulitplesameflowEndtoEnd1")
	public static ListIterator<Object[]> getcommonEndtoEnd1DP() throws IOException {
			ListIterator<Object[]> EndtoEnd1dp = getDP("EndtoEnd1");
			return EndtoEnd1dp;						 	
	}
	
	public static ListIterator<Object[]> getDP(String scriptname) throws IOException {
//		Creating the instance of ArrayList		
		ArrayList<Object[]> listOb = new ArrayList<Object[]>();		
		ExcelReadWrite excel= new ExcelReadWrite("F:\\SeleniumProjects\\Cb-IndiaProject\\src\\test\\resources\\Book_Search.xls");
//		set the sheet
		int noofsheets = excel.noofhsheets();
		System.out.println("Total no of sheets in the workbook is " +noofsheets);

		Map<String,String> hashmap= new HashMap<String, String>();
		Object[] mapObj= new Object[1];
		for (int k=0; k<noofsheets;k++) {
			String sheetname = excel.sheetname(k);
			System.out.println("Sheet names are "+sheetname);
			HSSFSheet setSheet = excel.setSheet(sheetname);
			int getrownum = excel.getrownum(setSheet);
			int getcolumnnum = excel.getcolnum(setSheet);	
			System.out.println("Sheet name is "+ sheetname +"and the row numbers are "+getrownum +"Column numbers are "+getcolumnnum);
					
		for (int i=1; i<=getrownum; i++) {				
			String TcName = excel.readvalue(i, 0, setSheet);
			String TcID = excel.readvalue(i, 1, setSheet);
			String xlscriptname = excel.readvalue(i, 2, setSheet);
			System.out.println("scriptname is " +xlscriptname);
			String ExeFlag = excel.readvalue(i, 3, setSheet);
//			System.out.println("exefalg is " +ExeFlag);
			System.out.println("Column number is " +getcolumnnum);
			if (ExeFlag.equals("y") & xlscriptname.equals(scriptname)) {
						for (int j=4; j<getcolumnnum; j++) {
						String colName = excel.readvalue(0, j, setSheet);
		  				String readvalue  = excel.readvalue(i, j, setSheet);
		//				System.out.println("Column name " +colName+"Column Values are " +readvalue);
						hashmap.put(colName, readvalue);				
					}
		}
	}
		
		
}
		System.out.println(hashmap);
		mapObj[0]=hashmap;	
		listOb.add(mapObj);
		
return listOb.listIterator();
		
	}
}
