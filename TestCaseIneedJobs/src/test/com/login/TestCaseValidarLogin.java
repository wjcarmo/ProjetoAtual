package test.com.login;

import org.testng.AssertJUnit;
import static org.testng.AssertJUnit.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameterized;


public class TestCaseValidarLogin {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stu
		
		//create Test Case for validation the home page ineed
				
	
		
		//BROWSER DO FIREFOX.
		WebDriver driver = new FirefoxDriver();
		
		//BROWSER DO CHOMER
	    //System.setProperty("webdriver.chrome.driver", "E:\\Programaçao\\Automacao de Testes\\chromedriver.exe"); 
		//WebDriver driver = new ChromeDriver();
		
		//BROWSER DO IE
	    //System.setProperty("webdriver.ie.driver", "E:\\Programaçao\\Automacao de Testes\\IEDriverServer.exe"); 
		//WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://mail.google.com");
		
		Thread.sleep(2000);
		/*
		driver.findElement(By.id("what")).sendKeys("Analista de Testes");
		Thread.sleep(2000);
		driver.findElement(By.id("where")).clear();
		driver.findElement(By.id("where")).sendKeys("NOVA LIMA-MG");
		Thread.sleep(2000);
		driver.findElement(By.id("fj")).click();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.id("searchCount")).getText());
		
		*/
		
		Thread.sleep(2000);
		driver.findElement(By.id("Email")).sendKeys("wjcarmo@gmail.com");
		driver.findElement(By.id("next")).click();	
		Thread.sleep(2000);
		
		driver.findElement(By.id("Passwd")).sendKeys("toddy@2013");		


		
		Thread.sleep(2000);	
		
		AssertJUnit.assertEquals("GMAIL", driver.getTitle());
				
		System.out.println(driver.getTitle());	
		
		
		
		
		
	}

}
