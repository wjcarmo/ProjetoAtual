package tjmg.pje.Integracao.TestNG.Usuario;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.br.tecwend.BancoDeDados.ClsLerArquivoDeDados;

import br.com.tjmg.pje.DAO.ClsDaoFluxoDoProcessos;
import br.com.tjmg.pje.interfaces.ClsProcessoNoSistema;

public class ClsTestaPesquisaDeProcessoNoSistema
{
		
		private ClsDaoFluxoDoProcessos FluxoDoprocesso ;
		private ClsProcessoNoSistema processo;
		private String varProcesso; 
		
		static final int LIMITE= 100;
		
		@BeforeMethod
		public void inicializa()
		{
			//Requisito que ser� validado, classe de Login
			FluxoDoprocesso = new  ClsDaoFluxoDoProcessos();	
			ClsLerArquivoDeDados ler = new ClsLerArquivoDeDados();
			varProcesso = ler.lerPessoa();
			
		}
		
		
		/**
		 * Este caso de teste tem o objetivo de realizar a valida��o da funcionalidade da pesquisa de processsos na aplica��o, tempo aceitavel de 5 Segundos
		 * Como pre-condi��o o processo j� deve ser um item cadastrado no sistema, ver Requisito R001-Cadastro de Processo no Sistema PJe.
		 */
		
		@Test(timeOut=LIMITE)
		@Parameters("numeroDoProcesso")
		public void mTestaPesquisaDeProcessoNoSistemaComDadosValidos(String numeroDoProcesso)
		{	
			this.varProcesso = numeroDoProcesso;
			
			//Entrada de dados no sistema
			processo =  FluxoDoprocesso.BuscarPorUmProcesso(numeroDoProcesso);			
			//Valida��o do Resultado esperado, o sistema realizou o login com os dados informados.
			AssertJUnit.assertEquals(processo.getVarNumeroDoProcesso(), numeroDoProcesso);
				
			
		}
		
}
