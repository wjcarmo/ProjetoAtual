package test.funcional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ClsConfiguracoesDoSelenium {
	
	
	// declarando os campos da classes
	private WebDriver driverFireFox; 
	private WebDriver driverChrome; 
	private WebDriver driverIE; 
	private WebDriver driver;
	private String siteApp;
	
	
	//Cria��o do metodos de configura��o para utiliza��o do selenium
	
	public ClsConfiguracoesDoSelenium(WebDriver driver) {
		this.driver = driver;
		
	}
	public ClsConfiguracoesDoSelenium()
	{
		this.driver = new FirefoxDriver();
	}
	public String getSiteApp() {
		return siteApp = "http://www.englishtown.com.br";
	}
	
	public void setSiteApp(String siteApp) {
		this.siteApp = siteApp;
	}
	
	protected WebDriver getDriverFireFox() {
		return driverFireFox = new FirefoxDriver();
	}
	
	public void setDriverFireFox(WebDriver driver) {
		this.driverFireFox = driver;
	}
	
	public void setDriverChrome(WebDriver driver)
	{
		//BROWSER DO CHOMER
	    System.setProperty("webdriver.chrome.driver", "E:\\Programa�ao\\Automacao de Testes\\chromedriver.exe"); 
	    this.driverChrome = driver;		
	}
	
	public WebDriver getDriverChrome()
	{
		return driverChrome = new ChromeDriver();
	}
	
	public void setDriverIE(WebDriver driver)
	{
		//BROWSER DO IE
	    System.setProperty("webdriver.ie.driver", "E:\\Programa�ao\\Automacao de Testes\\IEDriverServer.exe"); 
		WebDriver driverIE = driver; 		
	}
	
	public WebDriver getDriverIE()
	{
		return driverChrome = new InternetExplorerDriver();
	}
	
	
	
	
	
}
