package br.com.tjmg.pje.DAO;

import com.br.tecwend.BancoDeDados.ClsLerArquivoDeDados;

import br.com.tjmg.pje.interfaces.ClsProcessoNoSistema;
import br.com.tjmg.pje.interfaces.ClsUsuarioDoSistema;

public class ClsDaoFluxoDoProcessos 
{
	public ClsProcessoNoSistema BuscarPorUmProcesso(String numeroDoProcesso) 
	{
		
		ClsProcessoNoSistema processo = new ClsProcessoNoSistema();
				
		processo.setVarNumeroDoProcesso("50490547620168130024");
				
		return processo;
	}

}
