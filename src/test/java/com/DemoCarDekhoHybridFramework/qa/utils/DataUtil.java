package com.DemoCarDekhoHybridFramework.qa.utils;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;
import com.DemoCarDekhoHybridFramework.qa.baseTest.BaseTest;

/* taUtil class contains generic method that provides data provider to test cases for parameterization.
 */
public class DataUtil extends BaseTest {

	
	@DataProvider(name = "dp")
	public Object[][] getData(Method m) {
		
	
		String sheetName = m.getName();
		
		int rowNum = excel.getRowCount(sheetName);
		int colNum = excel.getColumnCount(sheetName);
		Object[][] data = new Object[rowNum-1][colNum];
	
		
		for(int rows=2; rows<=rowNum; rows++) {
			
			for(int cols=0; cols<colNum; cols++) {
				
				data[rows-2][cols] = excel.getCellData(sheetName, cols, rows);				
			}			
		}			
		return data;		
	}	
}
