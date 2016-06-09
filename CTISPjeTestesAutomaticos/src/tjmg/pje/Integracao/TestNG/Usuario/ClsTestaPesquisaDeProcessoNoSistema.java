package tjmg.pje.Integracao.TestNG.Usuario;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import tjmg.pje.Interface.Usuario.WebDriver.ClsPaginaInclusaoDeUmProcesso;
import tjmg.pje.Interface.Usuario.WebDriver.ClsPaginaPesquisaProcessos;
import tjmg.pje.Interface.Usuario.WebDriver.ClsPaginaValidaLoginPJE;

import com.br.tecwend.BancoDeDados.ClsLerArquivoDeDados;

import br.com.tjmg.pje.DAO.ClsDaoFluxoDoProcessos;
import br.com.tjmg.pje.Evidencias.ClsPrintScreenBase;
import br.com.tjmg.pje.interfaces.ClsPessoasDoSistemaPJe;
import br.com.tjmg.pje.interfaces.ClsProcessoNoSistema;

public class ClsTestaPesquisaDeProcessoNoSistema extends ClsPrintScreenBase
{
	protected String  recebeCPFCNPJMagistrado = "54335562047"; 
	protected String recebeCPFCNPJSecretaria = "25555553072"; 
	protected String recebeCPFCNPJAdvogado   = "62163250350"; 
	protected String recebeCPFCNPJAssessor   = "54335562047"; 
	protected String recebeCPFCNPJPublico    = "22222222222"; 	
	protected String recebeCPFCNPJProcuradorGestor = "45832820606"; 
	protected String recebeCPFCNPJOficialJudiciário = "00601534662"; 
	protected String recebeCPFCNPJAdvogadoAbdala = "81540248615"; 
	protected String recebeCPFCNPJMagistradoDelvan = "38030861672"; 
	protected String recebeCPFCNPJAssessorWellington = "98728016653"; 	
	protected String recebeSenha="tjmg";	
	
		ClsDaoFluxoDoProcessos FluxoDoprocesso ;
		ClsPaginaInclusaoDeUmProcesso incluiProcesso;
		ClsPaginaValidaLoginPJE paginaDeLogin;
		ClsPessoasDoSistemaPJe pessoas;
		ClsPaginaPesquisaProcessos pesquisa;
	

		private List<String> ProcessoObtido; 
		
		private String varProcessos;
		
		static final int LIMITE= 100;
		
		@BeforeMethod
		public void inicializa() throws InterruptedException
		{
			//Requisito que será validado, classe de Login
			driver = new  FirefoxDriver(); 
			paginaDeLogin  = new ClsPaginaValidaLoginPJE(driver); 
			FluxoDoprocesso = new  ClsDaoFluxoDoProcessos();				
			
			ProcessoObtido = new ClsLerArquivoDeDados().ObterlistaDeProcessos();
			
			for (String Processo : ProcessoObtido )
			{
				this.varProcessos = Processo;
			}
			}
		
		
		/**
		 * Este caso de teste tem o objetivo de realizar a validação da funcionalidade da pesquisa de processsos na aplicação, tempo aceitavel de 5 Segundos
		 * Como pre-condição o processo já deve ser um item cadastrado no sistema, ver Requisito R001-Cadastro de Processo no Sistema PJe.
		 * @throws InterruptedException 
		 */
		
		@Test()
		public void mTestaPesquisaDeProcessoNoSistemaComDadosValidos() throws InterruptedException
		{	
			
			//Entrada de dados para teste		
			// Requisito para testes Pagina de Login do Sistema PJe	
		 
			paginaDeLogin.setSiteParamentro("http://pjetreina.tjmg.jus.br/pje/login.seam?loginComCertificado=true");
			paginaDeLogin.preencherCPFCNPJ(recebeCPFCNPJAdvogado);
			paginaDeLogin.preencherSenha(recebeSenha);
			paginaDeLogin.clickBotaoEntrar();			
			Thread.sleep(3000);
		
			//pesquisa.clicarProcesso();
			
			Thread.sleep(10000);
			
			
			
			//Entrada de dados no sistema
			//processo =  FluxoDoprocesso.BuscarPorUmProcesso(varProcessos);			
			//Validação do Resultado esperado, o sistema realizou o login com os dados informados.
			//AssertJUnit.assertEquals(processo.getVarNumeroDoProcesso(), varProcessos);
				
			
		}
		
		@AfterMethod
		public void fecharDriver() throws IOException 
		{	
			if (null != driver) 
			     { 
					driver.quit(); 
				  }
			}
		
		
}
