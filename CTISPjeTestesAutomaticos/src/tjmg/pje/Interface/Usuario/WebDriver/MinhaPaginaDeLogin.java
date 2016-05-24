package tjmg.pje.Interface.Usuario.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MinhaPaginaDeLogin 
{
	private WebDriver driver;
	protected String siteParamentro;
	
	@FindBy(how = How.NAME, using = "Email") private WebElement usuarioLogado;	
	@FindBy(how = How.NAME, using = "Passwd") private WebElement usuarioSenha;
	@FindBy(how = How.NAME, using = "btnEntrar") private WebElement btnEntrar;
		
		
public MinhaPaginaDeLogin(WebDriver driver) throws InterruptedException {
	super();
	this.driver = driver; 		

	
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
		usuarioLogado.sendKeys(CPFCNPJValor); 
	}
	public void preencherSenha(String senhaParamentro) 
	{
		usuarioSenha.sendKeys(senhaParamentro); 
	}
	public void clickBotaoEntrar() 
	{
		btnEntrar.click();		
	}
	
	

}
