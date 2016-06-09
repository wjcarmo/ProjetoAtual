package br.com.tjmg.pje.interfaces;

public class ClsProcessoNoSistema 
{
	private String varNumeroDoProcesso;
	private String varMensagem;
	
	
	public String getVarNumeroDoProcesso() 
	{
		return varNumeroDoProcesso;
	}
	public void setVarNumeroDoProcesso(String varNumeroDoProcesso) 
	{
		this.varNumeroDoProcesso = varNumeroDoProcesso;
	}
	public String getVarMensagem()
	{
		return varMensagem;
	}
	public void setVarMensagem(String varMensagem) 
	{
		this.varMensagem = varMensagem;
	}
	public ClsProcessoNoSistema(String varNumeroDoProcesso, String varMensagem) 
	{
		super();
		this.varNumeroDoProcesso = varNumeroDoProcesso;
		this.varMensagem = varMensagem;
	}
	public ClsProcessoNoSistema() 
	{
	} 
	
	

}
