package tjmg.pje.Interface.Usuario.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class ClsPaginaValidaLoginPJE
{
	
	private String retornaMensagem;
	private String recebeCPFCNPJ;
	private String recebeSenha;
	private WebDriver driver;
	protected String siteParamentro;
	
	@FindBy(how = How.CLASS_NAME, using = "usuario-logado") 
	private WebElement usuarioLogado;	
	
	@FindBy(how = How.ID, using = "username") 
	private WebElement username;	
	
	@FindBy(how = How.ID, using = "password") 
	private WebElement password;	
	
	@FindBy(how = How.ID, using = "btnEntrar") 
	private WebElement btnEntrar;
	
	
	public void selecionarUsuarioLogado(WebElement usuario) 
	{
		this.usuarioLogado = usuario;
	}

	public String getSelectUsuarioLogado()
	{
		return usuarioLogado.getText();
	}

	public String getRetornaMensagem()
	{
		return retornaMensagem;
	}

	public void setRetornaMensagem(String retornaMensagem)
	{
		this.retornaMensagem = retornaMensagem;
	}

	public String getRecebeCPFCNPJ() 
	{
		return recebeCPFCNPJ;
	}

	public void setRecebeCPFCNPJ(String recebeCPFCNPJ) 
	{
		this.recebeCPFCNPJ = recebeCPFCNPJ;
	}

	public String getRecebeSenha() 
	{
		return recebeSenha;
	}

	public void setRecebeSenha(String recebeSenha)
	{
		this.recebeSenha = recebeSenha;
	}

	public WebDriver getDriver() 
	{
		return driver;
	}

	public void setDriver(WebDriver driver) 
	{
		this.driver = driver;
	}
		
	public ClsPaginaValidaLoginPJE(WebDriver driver) throws InterruptedException {
		super();
		this.driver = driver; 		
	
		
	}
	public ClsPaginaValidaLoginPJE() 
	{
	
	}
	
	public void setSiteParamentro(String siteParamentro) throws InterruptedException 
	{

		this.driver.manage().window().maximize();		
		this.driver.get(siteParamentro);		
		PageFactory.initElements(this.driver, this); 
		this.siteParamentro = siteParamentro;
		Thread.sleep(5000);
	
	}
	public void preencherCPFCNPJ(String CPFCNPJValor) 
	{	
		username.sendKeys(CPFCNPJValor); 
	}
	public void preencherSenha(String senhaParamentro) 
	{
		password.sendKeys(senhaParamentro); 
	}
	public void clickBotaoEntrar() 
	{
		btnEntrar.click();		
	}
	
}
