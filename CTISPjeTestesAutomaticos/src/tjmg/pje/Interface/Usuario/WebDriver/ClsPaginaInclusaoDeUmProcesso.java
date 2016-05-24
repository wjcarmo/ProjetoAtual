package tjmg.pje.Interface.Usuario.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ClsPaginaInclusaoDeUmProcesso 
{
	@FindBy(how = How.LINK_TEXT, using = "Processo") private WebElement mProcesso;
	@FindBy(how = How.LINK_TEXT, using = "Novo processo") private WebElement mNovoProcesso;
	@FindBy(how = How.ID, using = "processoTrfForm:classeJudicial:classeJudicialjurisdicaoComboDecoration:classeJudicialjurisdicaoCombo") private WebElement selectSecao;
	@FindBy(how = How.ID, using = "processoTrfForm:classeJudicial:classeJudicialComboClasseJudicialDecoration:classeJudicialComboClasseJudicial") private WebElement selectClasseJudical;
	@FindBy(how = How.ID, using = "processoTrfForm:save") private WebElement btnIncluir;
	@FindBy(how = How.ID, using = "r_processoAssuntoListList:0:j_id421") private WebElement listaDeAssuntos;
	@FindBy(how = How.ID, using = "tabPartes_lbl") private WebElement btnAdicionarPartes;
	@FindBy(how = How.ID, using = "novoAnexo_lbl") private WebElement btnAdicionarPeticoes;
	@FindBy(how = How.ID, using = "docPrincipalEditorTextArea_ifr") private WebElement editarPeticao;
	@FindBy(how = How.ID, using = "j_id652") private WebElement btnSalvarPeticao;
	@FindBy(how = How.ID, using = "signButton-certificacao-") private WebElement btnAssinarPeticao;
	@FindBy(how = How.ID, using = "informativo_lbl") private WebElement btnProcesso;
	@FindBy(how = How.ID, using = "Assinador") private WebElement btnOk;
		
		
		
	

	
	private WebDriver driver; 
	protected String digitaCPFCNPJAdvogado ="62163250350"; ; 
	protected String digitaSenhaDoUsuario="tjmg";
	protected String recebeSite = "";
	protected String retornaMensagem = "";
	protected String classeJudical = "DESPEJO (92)";
	protected String sessao = "Belo Horizonte";
	protected String peticao = "Inclusão da petição inicial automática";

	
	public void clicarProcesso( ) 
	{
		PageFactory.initElements(this.driver, this); 
		 mProcesso.click();
	}
	
	public void clicarNovoProcesso( ) 
	{
		//PageFactory.initElements(this.driver, this); 
		 mNovoProcesso.click();
	}
	
	public WebElement getListaDeAssuntos() {
		return listaDeAssuntos;
	}

	public void setListaDeAssuntos(WebElement listaDeAssuntos) {
		this.listaDeAssuntos = listaDeAssuntos;
	}
	

	public WebDriver getDriver() {
		return driver;
	}
	
	public void SelectSecao() 
	{
		Select selOpcaoSecao = new Select(selectSecao); 
		selOpcaoSecao.selectByVisibleText(sessao); 
	}
	
	public void SelectClasseJudicial() 
	{
		
		Select selOpcaoClasseJudicial = new Select(selectClasseJudical); 
		selOpcaoClasseJudicial.selectByVisibleText(classeJudical); 
	}
	
	public void BotaoIncluirProcesso() 
	{
		btnIncluir.click(); 
	}
	public void BotaoAdicionarPartes() 
	{
		
		btnAdicionarPartes.click();
		
	}
	
	public void BotaoListaAssunto() 
	{
		
		listaDeAssuntos.click();
		
	}

	public void BotaoAdicionarPeticoes() 
	{
		
		btnAdicionarPeticoes.click();
		
	}
	
	public void editarPeticoes() 
	{
		
		editarPeticao.sendKeys(peticao);
		
	}
	
	public void BotaoSalvarPeticoes() 
	{
		btnSalvarPeticao.click();
	}
	
	public void BotaoAssinarPeticoes() 
	{
		btnAssinarPeticao.click();
	}
	
	public void BotaoAssinarOk() 
	{
		btnOk.submit();
	}
	
	
	
	public ClsPaginaInclusaoDeUmProcesso(WebDriver driver)
	{
		super();
		this.driver = driver; 		
	}
	

}
