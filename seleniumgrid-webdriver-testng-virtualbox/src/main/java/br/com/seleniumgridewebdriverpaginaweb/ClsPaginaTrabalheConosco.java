package br.com.seleniumgridewebdriverpaginaweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ClsPaginaTrabalheConosco 
{
	
	@FindBy(how = How.ID, using = "nome") 
	private WebElement nome; 
	
	@FindBy(how = How.ID, using = "email") 
	private WebElement email; 
	 
	@FindBy(how = How.ID, using = "opcaoMasculino") 
	private WebElement opcaoSexoMasculino; 
	 
	@FindBy(how = How.ID, using = "checkIngles") 
	private WebElement checkIdiomaIngles; 
	
	@FindBy(how = How.ID, using = "selectOpcaoVaga") 
	private WebElement selectOpcaoVaga;
	
	@FindBy(how = How.ID, using = "arquivoCurriculo") 
	private WebElement arquivoCurriculo; 
	
	@FindBy(how = How.ID, using = "botaoEnviar") 
	private WebElement botaoEnviar; 

	@FindBy(how = How.ID, using = "msgAposEnvio") 
	private WebElement msgAposEnvio; 
	
	private WebDriver driver;
		
	public ClsPaginaTrabalheConosco(WebDriver driver) 
	{
		this.driver = driver; 
		
		PageFactory.initElements(this.driver, this); 
		
		this.driver.get("http://artigo.pe.hu/?pg=trabalhe_conosco.php");
	}
	
	public void preencherNome(String nomeValor) 
	{
		nome.sendKeys(nomeValor); 
	}
	
	public void preencherEmail(String emailValor) 
	{
		email.sendKeys(emailValor); 
	}
	
	public void marcarRadioButtonSexoMasculino() 
	{
		 opcaoSexoMasculino.click(); 
	}
	
	public void marcarCkeckBoxIdiomaIngles()
	{
		checkIdiomaIngles.click(); 
	} 
	
	public void selecionarVaga(String vaga) 
	{
		Select selOpcaoVaga = new Select(selectOpcaoVaga); 
		selOpcaoVaga.selectByVisibleText(vaga); 
	}
	
	public void selecionarArquivoCurriculo(String urlAbsolutaDoArquivoPdf) 
	{
		arquivoCurriculo.sendKeys(urlAbsolutaDoArquivoPdf); 
	}
	
	public void enviarMensagemDeTrabalheConosco() 
	{
		botaoEnviar.click(); 
	}
	
	public String obterMensagemAposEnvio() 
	{
	  return msgAposEnvio.getText(); 
	}
}
