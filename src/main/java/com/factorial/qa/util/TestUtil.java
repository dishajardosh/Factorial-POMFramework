package com.factorial.qa.util;

public class TestUtil {
	Xls_Reader reader=new Xls_Reader("C:\\Disha-QA-Application-2020\\Factorial_POMFramework\\src\\main\\java\\com\\factorial\\qa\\testdata\\Factorial_Data.xlsx");
	
	public String number=reader.getCellData("Sheet1", "Number", 2);
	public String title=reader.getCellData("Sheet1", "Title", 2);
	public String error=reader.getCellData("Sheet1", "Error", 2);
	public String text1=reader.getCellData("Sheet1", "Text", 2);
	public String text2=reader.getCellData("Sheet1", "Text", 3);
	public String output=reader.getCellData("Sheet1", "Output", 2);
	public String conditiondLinkUrl=reader.getCellData("Sheet1", "URL", 2);
	public String privacyLinkUrl=reader.getCellData("Sheet1", "URL", 3);

}
