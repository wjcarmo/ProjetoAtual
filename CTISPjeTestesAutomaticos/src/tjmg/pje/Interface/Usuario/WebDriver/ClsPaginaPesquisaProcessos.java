package tjmg.pje.Interface.Usuario.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ClsPaginaPesquisaProcessos 
{
	@FindBy(how = How.LINK_TEXT, using = "Processo") private WebElement mProcesso;
	
	public void clicarProcesso( ) 
	{
		 mProcesso.click();
	}
	
	

}
