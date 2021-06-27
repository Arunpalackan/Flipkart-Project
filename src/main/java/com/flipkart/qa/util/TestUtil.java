package com.flipkart.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.flipkart.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public TestUtil() throws Exception {
		super();
	}

	public void navigateToNextTab()
	{
		String MainWindow=driver.getWindowHandle();					
        Set<String> s1=driver.getWindowHandles();
        Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())			
        {		
            String ChildWindow=i1.next();		
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))			
            {    		
                 
                    driver.switchTo().window(ChildWindow);	
            }
            
        }
	}
	
	public   HashMap<String, String> setMapData() throws Exception 
	{
		XSSFWorkbook wb;
		XSSFSheet sheet1;
		File excel=new File("C:\\\\Users\\\\Arun Palackan\\\\Desktop\\\\sel\\\\sampleXclFile.xlsx");
		FileInputStream fis=new FileInputStream(excel);
		wb= new XSSFWorkbook(fis);
		sheet1=wb.getSheetAt(0);		
		HashMap<String,String> data=new HashMap<String,String>();
		int lastRow = sheet1.getLastRowNum();	
	    for(int i=1; i<=lastRow; i++)
	    {
	    	 Row row = sheet1.getRow(i);
	    	 Cell keyCell = row.getCell(0);
	    	 Cell valueCell = row.getCell(1);
			 String value = valueCell.getStringCellValue().trim();
			 String key = keyCell.getStringCellValue().trim();
			 data.put(key, value);

	    }

		return data;
		
	}

}
