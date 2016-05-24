package tjmg.pje.Integracao.RegraDeNegocio.JUnit;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import br.com.tjmg.pje.DAO.ClsDaoLoginDeUsuarios;
import br.com.tjmg.pje.interfaces.ClsUsuarioDoSistema;

public class ClsTestaMinhaPaginaJUnit 
{
	private ClsUsuarioDoSistema pessoa ;
	private ClsDaoLoginDeUsuarios login;
	static final int LIMITE= 5;
	
	@Before
	public void inicializa()
	{
		//Requisito que ser� validado, classe de Login
		login = new ClsDaoLoginDeUsuarios();		
		
	}
	
	
	/**
	 * Este caso de teste tem o objetivo de realizar a valida��o da funcionalidade do login de usuarios na aplica��o
	 * Como pre-condi��o o usuario j� deve ser uma pessoa cadastrada no sistema, ver Requisito R001-Cadastro de Pessoa no Sistema Usu�rio.
	 */
	@Test(timeout=LIMITE)
	public void mTestaLoginDoUsuarioNoSistemaComDadosValidos()
	{		
		
		//Entrada de dados no sistema
		pessoa = login.BuscarUmUsuario("Wenderson", "123");
		
		//Valida��o do Resultado esperado, o sistema realizou o login com os dados informados.
		Assert.assertEquals(pessoa.getVarNomeUsuario(), "Wenderson");
		Assert.assertEquals(pessoa.getVarSenhaUsuario(), "123");		
		
	}
	
	@Test
	public void mTestaLoginDoUsuarioNoSistemaNaoValido()
	{
			
		//Entrada de dados no sistema
		pessoa = login.BuscarUmUsuario("Wend", "12");
		
		//Valida��o do Resultado esperado, o sistema realizou o login com os dados informados.
		Assert.assertNotEquals(pessoa.getVarNomeUsuario(), "Wenderson");
		Assert.assertNotEquals(pessoa.getVarSenhaUsuario(), "123");		
		
	}
	
	@Test
	public void mTestaLoginDoUsuarioNoSistemaSemPassarOsDados()
	{
		
		//Entrada de dados no sistema
		pessoa = login.BuscarUmUsuario("", "");
		
		//Valida��o do Resultado esperado, o sistema realizou o login com os dados informados.
		Assert.assertNotEquals(pessoa.getVarNomeUsuario(), "Wenderson");
		Assert.assertNotEquals(pessoa.getVarSenhaUsuario(), "123");		
		
	}
	
	@Test
	public void mTestaLoginDoUsuarioNoSistemaUsuarioValidoSenhaInvalida()
	{		
		//Entrada de dados no sistema
		pessoa = login.BuscarUmUsuario("Wenderson", "98");
		
		//Valida��o do Resultado esperado, o sistema realizou o login com os dados informados.
		Assert.assertEquals(pessoa.getVarNomeUsuario(), "Wenderson");
		Assert.assertNotEquals(pessoa.getVarSenhaUsuario(), "123");		
		
	}
	
	@Test
	public void mTestaLoginDoUsuarioNoSistemaUsuarioInvalidoSenhaValida()
	{
		
		//Entrada de dados no sistema
		pessoa = login.BuscarUmUsuario("Wend", "123");
		
		//Valida��o do Resultado esperado, o sistema realizou o login com os dados informados.
		Assert.assertNotEquals(pessoa.getVarNomeUsuario(), "Wenderson");
		Assert.assertEquals(pessoa.getVarSenhaUsuario(), "123");		
		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void mTestaExcecaoDeString()
	{
		String str = new String("Wenderson Jose do Carmo");
		str.substring(30);
	}
		

}
