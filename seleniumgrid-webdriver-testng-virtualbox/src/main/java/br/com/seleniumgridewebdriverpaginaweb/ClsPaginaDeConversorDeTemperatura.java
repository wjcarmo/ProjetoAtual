package br.com.seleniumgridewebdriverpaginaweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


/**
 * Classe de mapeamento dos elementos da pagina de convesão de temperatura
 * @author Wenderson
 *
 */
public class ClsPaginaDeConversorDeTemperatura 
{	
	// Mapeamento entre o objeto WebElement com o elemento html que tem o 
	// id="valuefromtemperature1" e 
	// id="selectfromtemperature1"  na página web
	
	@FindBy(how = How.ID, using = "valuefromtemperature1") 
	
	private WebElement valorEntrada; 	
	
	@FindBy(how = How.ID, using = "selectfromtemperature1") 
	
	private WebElement webSelectDe; 
		
	@FindBy(how = How.ID, using = "selecttotemperature1")
	
	private WebElement webSelectPara; 
			
	@FindBy(how = How.ID, using = "valuetotemperature1") 
	
	private WebElement resultado; 
	private WebDriver driver;
		
	/**
	 * Atribuição do parametro que tem instância do WebDriver, para o objeto WebDriver que tem o escopo desta classe this.driver = driver; 
	 * Permite que os atributos mapeados nesta classe com @FindBy sejam carregados com os elementos html correspondente
	 * Carrega e inicia o navegador com o endereço web 
	 *  
	 * @param driver
	 */
	public ClsPaginaDeConversorDeTemperatura(WebDriver driver) 
	{ 
		PageFactory.initElements(this.driver, this); 
		
		this.driver.get("http://artigo.pe.hu/?pg=conv_temperatura.php");
		
	} 
	
	/**
	 *  Comando que envia valores para o elemento html 
	 * @param i
	 */
	
	public void preencherValorDeEntrada(String i) 
	{
		valorEntrada.sendKeys(i); 		
	}
	
	/**
	 *  retorna objeto WebElement 
	 * @return
	 */
	public WebElement obterValorDeEntrada() 
	{ 
	   return valorEntrada; 
	} 
	
	/**
	 *  Retorna um objeto Select que faz referência ao elemento html Select // na página web
	 * @return
	 */
	public Select obterSelectDeTemperatura() 
	{
	    return new Select(webSelectDe); 
	} 
	
	/**
	 * Retorna um objeto Select que faz referência ao elemento html Select // na página web
	 * @return
	 */
	public Select obterSelectParaTemperatura() 
	{
		return new Select(webSelectPara); 
		
	} 
	
	/**
	 * retorna objeto WebElement
	 * @return
	 */
	public WebElement obterResultadoTemperatura() 
	{
		 return resultado; 
	} 
}
