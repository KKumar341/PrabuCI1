package dataProvider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.testng.annotations.DataProvider;

import excelReadwrite.ExcelReadWrite;

public class CBIndiaDP {

//	static Logger log= Logger.getLogger(CBIndiaDP.class);
	
	@DataProvider(name="CBIndia_invalid")
	public static Iterator<Object[]> getcommonValidDP() throws IOException {
			Iterator<Object[]> invaliddp = getDP("Invalid");
			return invaliddp;						 	
	}
	
	@DataProvider(name="CBIndia_valid")
	public static Iterator<Object[]> getcommoninvalidDP() throws IOException {
			Iterator<Object[]> validdp = getDP("Valid");
			return validdp;						 	
	}
	
//	@DataProvider(name="CBIndia")
	public static ListIterator<Object[]> getDP(String scriptname) throws IOException {
//		Creating the instance of ArrayList		
		ArrayList<Object[]> listOb = new ArrayList<Object[]>();		
		ExcelReadWrite excel= new ExcelReadWrite("F:\\SeleniumProjects\\Cb-IndiaProject\\src\\test\\resources\\Book_Search.xls");
//		set the sheet
		HSSFSheet setSheet = excel.setSheet("HomePage");
		int getrownum = excel.getrownum(setSheet);
		int getcolumnnum = excel.getcolnum(setSheet);		
		System.out.println("Row numbers are "+getrownum);
		System.out.println("Column numbers are "+getcolumnnum);
		
//		2 dimensional dataprovier
//		Object[][] obj= new Object[getrownum][getcolumnnum];
//		return a Map
		
		for (int i=1; i<=getrownum; i++) {	
			Map<String,String> hashmap= new HashMap<String, String>();
			Object[] mapObj= new Object[1];
			String exeflag = excel.readvalue(i, 3, setSheet);
			String xlscriptname = excel.readvalue(i, 2, setSheet);
			System.out.println("exefalg is " +exeflag);
			if (exeflag.equals("y") & xlscriptname.equals(scriptname)) {			
//			if (exeflag.equals("y") ) {	
				for (int j=0; j<=getcolumnnum-1; j++) {
				String colName = excel.readvalue(0, j, setSheet);
				String readvalue = excel.readvalue(i, j, setSheet);
				System.out.println("Column name " +colName+"Column Values are " +readvalue);
				hashmap.put(colName, readvalue);				
				}
	mapObj[0]=hashmap;	
	listOb.add(mapObj);
		
	}
}
return listOb.listIterator();
		
	}
}
