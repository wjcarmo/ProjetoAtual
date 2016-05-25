package tjmg.pje.Interface.Usuario.WebDriver;

import org.openqa.selenium.Alert;
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
	@FindBy(how = How.NAME, using = "r_processoAssuntoListList:2:j_id424:j_id425:j_id426") private WebElement listaDeAssuntos;
	@FindBy(how = How.ID, using = "tabPartes_lbl") private WebElement btnAdicionarPartes;
	

	@FindBy(how = How.ID_OR_NAME, using = "formVincularPoloAtivo:oplAddParteA") private WebElement btnAdicionarPartesAtivo;
	@FindBy(how = How.ID_OR_NAME, using = "formVincularPoloPassivo:addParteP") private WebElement btnAdicionarPartesPassivo;
	
	
	@FindBy(how = How.XPATH, using = ".//*[@id='preCadastroPessoaFisicaForm:preCadastroPessoaFisica_nrCPFDecoration:preCadastroPessoaFisica_nrCPF']") private WebElement DigitarCPFCNPJPartesAtivo;
	
	@FindBy(how = How.ID, using = "preCadastroPessoaFisicaForm:pesquisarDocumentoPrincipal") private WebElement btnConfirmarCPFCNPJ;
	
	
	@FindBy(how = How.ID_OR_NAME, using = "preCadastroPessoaFisicaForm:isPessoaNaoIndividualizadaDecoration:isPessoaNaoIndividualizada") private WebElement DigitarCPFCNPJPartesPassivo;
	
	//@FindBy(how = How.ID, using = "preCadastroPessoaFisicaForm:pesquisarDocumentoPrincipal") private WebElement btnPesquisarCPFCNPJ;
	
	@FindBy(how = How.ID, using = "preCadastroPessoaFisicaForm:btnConfirmarCadastro") private WebElement btnInserirAtivo;
	
	@FindBy(how = How.ID, using = "formInserirParteProcesso:btnInserirParteProcesso") private WebElement btnInserirCPFCNPJAtivo;
	
							
	@FindBy(how = How.ID, using = "preCadastroPessoaFisicaForm:hasDocumentoAlternativoDecoration:hasDocumentoAlternativo") private WebElement selectDocumento;
	@FindBy(how = How.ID, using = "preCadastroPessoaFisicaForm:dsNomeAlcunhaDecoration:dsNomeAlcunha") private WebElement editarNomeAlcunha;
	@FindBy(how = How.ID_OR_NAME, using = "preCadastroPessoaFisicaForm:btnConfirmarCadastro") private WebElement btnConfirmarDocumentoPassivo;
	
		
	@FindBy(how = How.ID, using = "formInserirParteProcesso:enderecoUsuario_lbl") private WebElement btnEnderecos;
	
	@FindBy(how = How.ID, using = "formInserirParteProcesso:cadastroPartePessoaEnderecochbkxIsEnderecoDesconhecido") private WebElement btnEnderecoDesconhecido;
	
	
	@FindBy(how = How.ID, using = "formInserirParteProcesso:btnInserirParteProcesso") private WebElement btnInserirReu;	
	
	
	@FindBy(how = How.ID, using = "novoAnexo_lbl") private WebElement btnAdicionarPeticoes;
	@FindBy(how = How.ID, using = "docPrincipalEditorTextArea_ifr") private WebElement editarPeticao;
	@FindBy(how = How.ID, using = "j_id652") private WebElement btnSalvarPeticao;
	@FindBy(how = How.ID, using = "signButton-certificacao-") private WebElement btnAssinarPeticao;
	@FindBy(how = How.ID, using = "informativo_lbl") private WebElement btnProcesso;
	@FindBy(how = How.ID, using = "Assinador") private WebElement btnOk;
	@FindBy(how = How.ID, using = "formBotoesAcao:btnProtocolar") private WebElement btnProtocolar;	
	
	
	
	
	
	private WebDriver driver; 
	protected String digitaCPFCNPJAdvogado ="62163250350"; ; 
	protected String digitaSenhaDoUsuario="tjmg";
	protected String recebeSite = "";
	protected String retornaMensagem = "";
	protected String classeJudical = "DESPEJO (92)";
	protected String sessao = "Belo Horizonte";
	protected String digitaCPFCNPJParteAtivo = "22222222222";
	
	protected String digitaCPFCNPJPartePassivo = "11111111111";
	protected String documento = "Não";
	protected String peticao = "Inclusão da petição inicial automática";
	protected Alert alt;
	protected String NomeAlcunha = "Nome Automatico"; 
	 
		
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
	
	
	public void btnAdicionarPartesAtivo() 
	{
		
		btnAdicionarPartesAtivo.click();
		
	}
	
	public void btnAdicionarPartesPassivo() 
	{
		
		btnAdicionarPartesPassivo.click();
		
	}
	
	
	public void DigitarCPFCNPJPartesAtivo() 
	{
		
		DigitarCPFCNPJPartesAtivo.sendKeys("xpath=.//*[@id='preCadastroPessoaFisicaForm:preCadastroPessoaFisica_nrCPFDecoration:preCadastroPessoaFisica_nrCPF']=33333333333");		
	}
	
	
	public void DigitarCPFCNPJPartesPassivo() 
	{
		
		DigitarCPFCNPJPartesPassivo.click();		
	}
	
	
	public void btnConfirmarCPFCNPJ() 
	{
		
		btnConfirmarCPFCNPJ.click();		
	}
	
	public void btnInserirCPFCNPJAtivo() 
	{
		
		btnInserirCPFCNPJAtivo.click();		
	}
	
	
	public void btnEnderecoDesconhecido() 
	{
		
		btnEnderecoDesconhecido.click();		
	}
	
	public void btnEnderecos() 
	{
		
		btnEnderecos.click();
		
	}
	
	
	public void editarNomeAlcunha() 
	{
		
		editarNomeAlcunha.sendKeys("NomeAlcunha");	
	}
	

	public void btnConfirmarDocumentoPassivo() 
	{
		
		btnConfirmarDocumentoPassivo.click();
		
	}
	public void btnInserirReu() 
	{
		
		btnInserirReu.click();
		
	}
	
	public void btnPesquisarCPFCNPJ() 
	{
		
		//btnPesquisarCPFCNPJ.click();
		
	}
	
	public void btnInserirAtivo() 
	{
		
		btnInserirAtivo.click();
		
	}
	
	
	
	
	
	public void SelectDocumento() 
	{
		Select seldocumento = new Select(selectDocumento); 
		seldocumento.selectByVisibleText(documento); 
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
	     alt = driver.switchTo().alert();
		 alt.accept();
		
	}
	
	public void BotaoProcesso() 
	{
		btnProcesso.click();
	}
	
	public void BotaoProtocolar() 
	{
		btnProtocolar.click();
	}
	
	
	public ClsPaginaInclusaoDeUmProcesso(WebDriver driver)
	{
		super();
		this.driver = driver; 		
	}
	

}
