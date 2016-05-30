package tjmg.pje.Integracao.TestNG.Usuario;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.Assert;

import com.br.tecwend.BancoDeDados.ClsLerArquivoDeDados;

import br.com.tjmg.pje.DAO.ClsDaoLoginDeUsuarios;
import br.com.tjmg.pje.interfaces.ClsUsuarioDoSistema;

public class ClsTestaMinhaPaginaTestNG
{
	private ClsUsuarioDoSistema pessoa ;
	private ClsDaoLoginDeUsuarios login;
	
	
	
	static final int LIMITE= 200;
	private WebDriver driver;
	
	
	@BeforeMethod
	public void inicializa()
	{
		//Requisito que ser� validado, classe de Login
		login = new ClsDaoLoginDeUsuarios();	
		ClsLerArquivoDeDados ler = new ClsLerArquivoDeDados();
		ler.lerPessoa();
		
	}
	
	
	
	/**
	 * Este caso de teste tem o objetivo de realizar a valida��o da funcionalidade do login de usuarios na aplica��o, tempo aceitavel de 5 Segundos
	 * Como pre-condi��o o usuario j� deve ser uma pessoa cadastrada no sistema, ver Requisito R001-Cadastro de Pessoa no Sistema Usu�rio.
	 */
	
	@Test(timeOut=LIMITE)
	@Parameters("nomeDoUsuario")
	public void mTestaLoginDoUsuarioNoSistemaComDadosValidos(String nomeDoUsuario)
	{		
		
		//Entrada de dados no sistema
		pessoa = login.BuscarUmUsuario(nomeDoUsuario,"123");
		
		//Valida��o do Resultado esperado, o sistema realizou o login com os dados informados.
		AssertJUnit.assertEquals(pessoa.getVarNomeUsuario(), nomeDoUsuario);
		AssertJUnit.assertEquals(pessoa.getVarSenhaUsuario(), "123");		
		
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
		AssertJUnit.assertEquals(pessoa.getVarNomeUsuario(), "Wenderson");
		Assert.assertNotEquals(pessoa.getVarSenhaUsuario(), "123");		
		
	}
	
	@Test
	public void mTestaLoginDoUsuarioNoSistemaUsuarioInvalidoSenhaValida()
	{
		
		//Entrada de dados no sistema
		pessoa = login.BuscarUmUsuario("Wend", "123");
		
		//Valida��o do Resultado esperado, o sistema realizou o login com os dados informados.
		Assert.assertNotEquals(pessoa.getVarNomeUsuario(), "Wenderson");
		AssertJUnit.assertEquals(pessoa.getVarSenhaUsuario(), "123");		
		
	}
	
	@Test()
	public void mTestaExcecaoDeString()
	{
		String str = new String("Wenderson Jose do Carmo");
		
		Assert.assertNotEquals(str.substring(7), "Wenderson Jose do Carmo");
	}
	
	
}
