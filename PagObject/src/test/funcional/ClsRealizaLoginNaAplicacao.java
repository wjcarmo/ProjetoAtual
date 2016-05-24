package test.funcional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ClsRealizaLoginNaAplicacao extends ClsConfiguracoesDoSelenium
{

		
	public ClsRealizaLoginNaAplicacao(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public ClsPaginaInicialDoSistema logar(String email, String senha)
	{
		realizaLogin(email,senha);
		return new ClsPaginaInicialDoSistema(getDriverFireFox());
		
	}
	private void realizaLogin(String email, String senha)
	{
		getSiteApp();
		getDriverFireFox().findElement(By.linkText("Faça o login")).click();

		
	}

}
