package com.factorial.qa.tests;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.factorial.qa.base.TestBase;
import com.factorial.qa.pages.FactorialPage;
import com.factorial.qa.util.TestUtil;

public class FactorialTest extends TestBase {

	FactorialPage fp;
	TestUtil tu;

	public FactorialTest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod (alwaysRun=true)
	  public void beforeMethod() throws Exception {
		initialization();
		fp=new FactorialPage();
		tu=new TestUtil();	

	  }
	
	@AfterMethod (alwaysRun=true)
	  public void afterMethod() {
		 closeBrowser();
	  }
	
	// This test verifies Title of the page
	@Test (priority=1, groups= {"SanityTest"})
	 public void verifyTitle() throws InterruptedException 
	  {		 
		String title = 	fp.validatePageTitle();
		Assert.assertEquals(title,tu.title);			
	  }
	
	// This test verify the text present in the number text box
	@Test (priority=2)
	 public void verifyText() throws InterruptedException 
	  {
		 
		Assert.assertTrue(fp.verifyWebElement(fp.number));
		Assert.assertEquals(fp.number.getAttribute("placeholder"), tu.text1);
	  }
	
	//This test verify web element  Calculate button present on the page or not
	@Test (priority=3)
	 public void verifyButton() throws InterruptedException 
	  {
		 
		Assert.assertTrue(fp.verifyWebElement(fp.btnCalculate));
		Assert.assertEquals(fp.btnCalculate.getText(), tu.text2);
		
	  }
	 
	// This test verifies error message when user clicks on calculate button w/o entering integer in text box
	@Test (priority=4)
	 public void verifyError() throws InterruptedException 
	  {
		 fp.btnCalculate.click();
		Assert.assertEquals(fp.validateErrorMsg(),tu.error);
	  }
	
	// this test verifies result of the factorial calculator
	@Test (priority=5)
	 public void verifyOutput1() throws InterruptedException 
	  {
		
		fp.number.sendKeys("5"); 
		fp.btnCalculate.click();
		String resultTest = fp.calculateFactorialofPositiveInt();
		Assert.assertEquals(resultTest,tu.output);
	  }
	
	// This test verifies 'Terms&conditions' link works 
	@Test (priority=6,groups= {"SanityTest"})
	 public void verifyConditionsLinkTest() throws InterruptedException 
	  {
		fp.conditionsLink.click();
		String errMsg = fp.clickOnPrivacyLink();
		System.out.println(errMsg);
		Assert.assertEquals(errMsg,tu.conditiondLinkUrl);
	  }
	
	// This test verifies 'Privacy' link works 
	@Test (priority=7,groups= {"SanityTest"})
	 public void verifyPrivacyLinkTest() throws InterruptedException 
	  {
		fp.privacyLink.click();
		String errMsg = fp.clickOnPrivacyLink();
		System.out.println(errMsg);
		Assert.assertEquals(errMsg,tu.privacyLinkUrl);
	  }
}
