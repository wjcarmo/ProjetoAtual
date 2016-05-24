package plan.principal.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import test.com.cadastros.TestCaseValidaCadastros;

public class TestCasePrincipal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestCaseValidaRetornoDaSoma();
				
	}
	
	
	public static void TestCaseValidaRetornoDaSoma()
	{
		TestCaseValidaCadastros valida = new TestCaseValidaCadastros();
		
		AssertJUnit.assertEquals(1,valida.testCaseCalculaNumeros(2, 5));
		
		
	}

}
