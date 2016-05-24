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
			//Requisito que será validado, classe de Login
			FluxoDoprocesso = new  ClsDaoFluxoDoProcessos();	
			ClsLerArquivoDeDados ler = new ClsLerArquivoDeDados();
			varProcesso = ler.lerPessoa();
			
		}
		
		
		/**
		 * Este caso de teste tem o objetivo de realizar a validação da funcionalidade da pesquisa de processsos na aplicação, tempo aceitavel de 5 Segundos
		 * Como pre-condição o processo já deve ser um item cadastrado no sistema, ver Requisito R001-Cadastro de Processo no Sistema PJe.
		 */
		
		@Test(timeOut=LIMITE)
		@Parameters("numeroDoProcesso")
		public void mTestaPesquisaDeProcessoNoSistemaComDadosValidos(String numeroDoProcesso)
		{	
			this.varProcesso = numeroDoProcesso;
			
			//Entrada de dados no sistema
			processo =  FluxoDoprocesso.BuscarPorUmProcesso(numeroDoProcesso);			
			//Validação do Resultado esperado, o sistema realizou o login com os dados informados.
			AssertJUnit.assertEquals(processo.getVarNumeroDoProcesso(), numeroDoProcesso);
				
			
		}
		
}
