package plan.com.ineedjobs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import test.com.cadastros.TestCaseValidaCadastros;

public class TestCaseIneedJobs {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
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
		
		driver.get("http://www.indeed.com.br");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("what")).sendKeys("Analista de Testes");
		Thread.sleep(2000);
		driver.findElement(By.id("where")).clear();
		driver.findElement(By.id("where")).sendKeys("NOVA LIMA-MG");
		Thread.sleep(2000);
		driver.findElement(By.id("fj")).click();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.findElement(By.id("searchCount")).getText());
		
		
		driver.quit();
		driver.close();
		driver.get("https://mail.google.com");
		
		
		
		
		
		
		
		
		
		

	}

}
