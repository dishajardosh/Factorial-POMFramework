package com.factorial.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.factorial.qa.base.TestBase;

public class FactorialPage extends TestBase {
	
	@FindBy(name="number")
	public WebElement number;
	
	@FindBy(id="getFactorial")
	public WebElement btnCalculate;
	
	@FindBy(id="resultDiv")
	public WebElement result;
	
	@FindBy(xpath = "//a[contains(text(),'Terms')]")
	public WebElement conditionsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Privacy')]")
	public WebElement privacyLink;

	public FactorialPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validatePageTitle()
	{		
		return driver.getTitle();	
	}
	
	public boolean verifyWebElement(WebElement we)
	{		
		return we.isDisplayed();		
	}
	
	public String validateErrorMsg()
	{		
		return result.getText();		
	}
	
	public String calculateFactorialofPositiveInt() 
	{
		return result.getText();
	}
	
	public String clickOnConditionsLink(){
		
		return driver.getCurrentUrl();
	}
	
	public String clickOnPrivacyLink(){
		
		return driver.getCurrentUrl();
	}
	
}
