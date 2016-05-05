package br.com.seleniumgridewebdriverpaginaweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ClsPaginaGmailValidaLogin 
{
	

	private WebDriver driver;
	
	@FindBy(how = How.NAME, using = "Email") 
	private WebElement varNome;
	
	@FindBy(how = How.NAME, using = "Email") 
	private WebElement varEmail;
	
	@FindBy(how = How.ID, using = "Passwd") 
	private WebElement varSenha;
	
	
	private WebElement varMsn; 
	protected String nomeParametro =  "Wenderson Jose do Carmo";
	protected String emailParamentro = "wjcarmo@gmail.com";
	protected String senhaParamentro = "toddy@2013";
	protected String siteParamentro = "http://localhost:8080/PaginaDeTestesWeb/FormLogin.html";
	
	
	public void setNomeParametro(String nomeParametro) {
		this.nomeParametro = nomeParametro;
	}
	
	public String getNomeParametro() {
		return nomeParametro;
	}

	public void setEmailParamentro(String emailParamentro) {
		this.emailParamentro = emailParamentro;
	}
	
	public String getEmailParamentro() {
		return emailParamentro;
	}

	public void setSenhaParamentro(String senhaParamentro) {
		this.senhaParamentro = senhaParamentro;
	}

	
	public String getSenhaParamentro() {
		return senhaParamentro;
	}

		
	public void preencherEmail(String emailValor) 
	{
		varEmail.sendKeys(emailValor); 
	}
	
	public void preencherSenha(String senhaValor) 
	{
		varSenha.sendKeys(senhaValor); 
	}
	
	public void clickBotaoNext() 
	{
		driver.findElement(By.id("next")).click();
		
	}
	
	
	public void clickBotaoFazerLogin() 
	{
		driver.findElement(By.id("signIn")).click();;
		
	}
	
	

	public ClsPaginaGmailValidaLogin(WebDriver driver) throws InterruptedException
	{
		this.driver = driver; 		
		//PageFactory.initElements(this.driver, this); 		
		this.driver.manage().window().maximize();		
		this.driver.get(siteParamentro);
	
	}
	
	//BROWSER DO FIREFOX.
	//WebDriver driver = new FirefoxDriver();
	
	//BROWSER DO CHOMER
    //System.setProperty("webdriver.chrome.driver", "E:\\Programaçao\\Automacao de Testes\\chromedriver.exe"); 
	//WebDriver driver = new ChromeDriver();
	
	//BROWSER DO IE
    //System.setProperty("webdriver.ie.driver", "E:\\Programaçao\\Automacao de Testes\\IEDriverServer.exe"); 
	//WebDriver driver = new InternetExplorerDriver();
	
	
	/*
	driver.findElement(By.id("what")).sendKeys("Analista de Testes");
	Thread.sleep(2000);
	driver.findElement(By.id("where")).clear();
	driver.findElement(By.id("where")).sendKeys("NOVA LIMA-MG");
	Thread.sleep(2000);
	driver.findElement(By.id("fj")).click();
	
	System.out.println(driver.getTitle());
	System.out.println(driver.findElement(By.id("searchCount")).getText());
	
	Thread.sleep(2000);	
	
	AssertJUnit.assertEquals("GMAIL", driver.getTitle());
			
	System.out.println(driver.getTitle());	
	*/
	

}
