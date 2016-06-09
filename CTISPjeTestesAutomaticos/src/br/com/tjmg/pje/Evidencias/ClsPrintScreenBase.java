package br.com.tjmg.pje.Evidencias;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Listeners;

@Listeners(ClsEvidenciaDeExecucaoDosTestes.class)
public class ClsPrintScreenBase 
{

	protected static WebDriver driver;
	protected static WebDriverWait wait;
	
	@BeforeClass
	public static void setUp()
	{
		driver = new FirefoxDriver();
		wait = new WebDriverWait(driver, 10);
	}
	
	@AfterClass
	public static void tearDown()
	{
			driver.quit();
	}	
	
	public static WebDriver getDriver()
	{
		return driver;
	}

}
