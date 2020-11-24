package com.factorial.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	public TestBase()  {
		
		try {
			
			FileInputStream fs=new FileInputStream("C:\\Disha-QA-Application-2020\\Factorial_POMFramework\\src\\main\\java\\com\\factorial\\qa\\testdata\\config.properties");
			prop =new Properties();
			prop.load(fs);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
			}

		}
	
	public static void initialization() {
		String browser=prop.getProperty("browser");
		
		if(browser.equals("FF")) {
			System.setProperty("webdriver.gecko.driver","C:\\Seleniumjars\\geckodriver.exe");
			driver =new FirefoxDriver();
		}else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Seleniumjars\\chromedriver.exe");
			driver =new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}
	public static void closeBrowser() {
		driver.quit();
	}
	
	
}
