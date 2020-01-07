package com.start.utility;

import java.io.File;
import java.io.*;
import org.apache.log4j.Logger;

import jxl.Sheet;
import jxl.Workbook;

import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ReadXLS {

	Logger logger = Logger.getLogger("devpinoyLogger");

	public void writeData(String filePath, String userEmail, String userPassword) 
	{
		try 
		{
			int i = 1;
			Workbook workbook = Workbook.getWorkbook(new File(filePath));
			// create a new excel and copy from existing
			WritableWorkbook copy = Workbook.createWorkbook(new File(filePath), workbook);
			WritableSheet sheet = copy.getSheet(0);
			Label email = new Label(0, i, userEmail);
			sheet.addCell(email);
			Label password = new Label(1, i, userPassword);
			sheet.addCell(password);
			copy.write();
			copy.close();
			logger.debug("User details are added to UserData.xls file.");
		} 
		catch (Exception e) 
		{
			logger.debug("Exception Occurred: " + e.getMessage());
		}
	}

	public String readData(String filePath) 
	{
		String mergeResult, userEmail = null, userPassword = null;
		try 
		{
			Workbook wb = Workbook.getWorkbook(new File(filePath));
			Sheet s1 = wb.getSheet(0);
			int i = 1;
			userEmail = s1.getCell(0, i).getContents();
			userPassword = s1.getCell(1, i).getContents();
		} 
		catch (Exception e) 
		{
			logger.debug("Exception Occurred: " + e.getMessage());
		}
		mergeResult = userEmail + "#" + userPassword;
		return mergeResult;
	}
	
	
	
	public String readData_timetrend(String filePath, int year) 
	{
		System.out.println(year);
		String mergeResult, fav = null, neutral = null, unfav = null;
		try 
		{
			Workbook wb = Workbook.getWorkbook(new File(filePath));
			Sheet s1 = wb.getSheet(0);
			String test = s1.getCell(1, 3).getContents();
			System.out.println(test);
			if (year == 2014)
			{
			int i = 10;
			fav = s1.getCell(2, i++).getContents();
			neutral = s1.getCell(2, i++).getContents();
			unfav = s1.getCell(2, i).getContents();
			}
			
			if (year == 2015)
			{
			int i = 10;
			fav = s1.getCell(3, i++).getContents();
			neutral = s1.getCell(3, i++).getContents();
			unfav = s1.getCell(3, i).getContents();
			}			
		
			if (year == 2016)
			{
			int i = 10;
			fav = s1.getCell(4, i++).getContents();
			neutral = s1.getCell(4, i++).getContents();
			unfav = s1.getCell(4, i).getContents();
			}			
		
		} 
		catch (Exception e) 
		{
			logger.debug("Exception Occurred: " + e.getMessage());
		}
		mergeResult = fav + "#" + neutral + "#" + unfav;
		return mergeResult;
	}
	
    // Method to reverse words of a String
    public String ReverseWords(String str)
    {
 
        // Specifying the pattern to be searched
        // Pattern pattern = Pattern.compile("\\s");
 
        // splitting String str with a pattern
        // (i.e )splitting the string whenever their
        //  is whitespace and store in temp array.
        String[] temp = str.split("");
        String result = "";
 
        // Iterate over the temp array and store
        // the string in reverse order.
        for (int i = 0; i < temp.length; i++) {
            if (i == temp.length - 1)
                result = temp[i] + result;
            else
                result = " " + temp[i] + result;
        }
        return result;
}
	
	 // public boolean readRRdata(String filePath, int total,int complete,int incomplete,int perc)
	// {
		 // try
		
		 // {
		 // Workbook wb = Workbook.getWorkbook(new File(filePath));
         // Sheet s1 = wb.getSheet(0);
         // int i = 3;
		 // int j = 13;
		 // boolean status = false;
		
		 // if(s1.getCell(j,i++) == total && s1.getCell(j,i++) == complete && s1.getCell(j,i++) == incomplete && s1.getCell(j, i++) == perc) 
		 // {
		 // status = true; 		}        		
		 // }
		 // catch (Exception ex)
		 // {	logger.debug("Exception Occurred: " + e.getMessage());
		
		// return status; 
		 // }
		
		 // }
	
	
	 // public boolean filePresent(String filePath)
	 // {
        // try 
		 // {
			 // Workbook wb = Workbook.getWorkbook(new File(filePath)); 
			 // if(wb.exists() && !f.isDirectory())
           	// return true;
		// }
		// catch (Exception ex)
		 // {
		 // logger.debug("Exception Occurred: " + e.getMessage());
		 // return false;
	 // }


}
