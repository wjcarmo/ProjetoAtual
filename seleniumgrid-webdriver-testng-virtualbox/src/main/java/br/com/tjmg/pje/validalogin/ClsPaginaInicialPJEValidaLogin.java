package br.com.tjmg.pje.validalogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ClsPaginaInicialPJEValidaLogin 
{

	
	@FindBy(how = How.NAME, using = "username") 
	private WebElement username;
	
	@FindBy(how = How.NAME, using = "password") 
	private WebElement password;
	
	@FindBy(how = How.NAME, using = "btnEntrar") 
	private WebElement btnEntrar;
	
	@FindBy(how = How.CLASS_NAME, using = "aviso")
	private WebElement txtAviso;
	
	protected WebDriver driver;
	protected WebElement varMsn; 
	protected String CPFCNPJ;
	protected String senhaParamentro;
	protected String siteParamentro;
	protected String retornaMsn;
	
	
	
	public ClsPaginaInicialPJEValidaLogin(WebDriver driver) throws InterruptedException
	{
		this.driver = driver; 		
		//PageFactory.initElements(this.driver, this); 		
		this.driver.manage().window().maximize();		
		this.driver.get(siteParamentro);
	
	}
	public ClsPaginaInicialPJEValidaLogin()
	{
		
	}
	
	public void setSiteParamentro(String siteParamentro) {
		this.siteParamentro = siteParamentro;
	}
	
	public String getSiteParamentro() {
		return siteParamentro;
	}
	public String getRetornaMsn() {
		return retornaMsn;
	}
	
	public void setRetornaMsn(String retornaMsn) {
		this.retornaMsn = retornaMsn;
	}
	
	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public String getCPFCNPJParametro() {
		return CPFCNPJ;
	}

	public void setCPFCNPJParametro(String CPFCNPJ) {
		this.CPFCNPJ = CPFCNPJ;
	}

	public String getsenhaParamentroParamentro() {
		return senhaParamentro;
	}

	public void setsenhaParamentro(String senhaParamentro) {
		this.senhaParamentro = senhaParamentro;
	}

	public String getSenhaParamentro() {
		return senhaParamentro;
	}

	public void setsiteParamentro(String siteParamentro) {
		this.siteParamentro = siteParamentro;
	}
	
	public void preencherCPFCNPJ(String CPFCNPJValor) 
	{
		username.sendKeys(CPFCNPJValor); 
	}
	
	public void preencherSenha(String senhaParamentro) 
	{
		password.sendKeys(senhaParamentro); 
	}
	
	public String  getretornaMsn()
	{
		return  txtAviso.getText();
	}
	
	public void clickBotaoEntrar() 
	{
		driver.findElement(By.id("btnEntrar")).click();
		
	}	
	
	public void clickBotaoFazerLogin() 
	{
		driver.findElement(By.id("signIn")).click();;
		
	}
		
	

	

}
