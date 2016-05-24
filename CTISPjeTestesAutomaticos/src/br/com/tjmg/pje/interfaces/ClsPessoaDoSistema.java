package br.com.tjmg.pje.interfaces;

public class ClsPessoaDoSistema
{
	private String varNome;
	private String varSeha;
	private String varTipo;
	
	
	public ClsPessoaDoSistema(String varNome, String varSeha, String varTipo) {
		super();
		this.varNome = varNome;
		this.varSeha = varSeha;
		this.varTipo = varTipo;
	}
	
	public ClsPessoaDoSistema() {
		super();
		this.varNome = varNome;
		this.varSeha = varSeha;
		this.varTipo = varTipo;
	}
	
	public String getVarNome() 
	{
		return varNome;
	}
	public void setVarNome(String varNome) 
	{
		this.varNome = varNome;
	}
	public String getVarSeha() 
	{
		return varSeha;
	}
	public void setVarSeha(String varSeha) 
	{
		this.varSeha = varSeha;
	}
	public String getVarTipo() 
	{
		return varTipo;
	}
	public void setVarTipo(String varTipo)
	{
		this.varTipo = varTipo;
	}
	

}