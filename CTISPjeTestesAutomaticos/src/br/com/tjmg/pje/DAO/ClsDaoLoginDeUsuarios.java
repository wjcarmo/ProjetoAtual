package br.com.tjmg.pje.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.br.tecwend.BancoDeDados.ClsConexaoBancoDeDados;

import br.com.tjmg.pje.interfaces.ClsUsuarioDoSistema;

public class ClsDaoLoginDeUsuarios
{
	/**
	 * O metodo BuscarUmUsuarios conecta no banco de dados e busca o usuario conforme o Nome e senha informado.
	 * @param nome  do usuario cadastrado no sisntema utilizado para logar no sistema
	 * @param senha do usuario cadastrado no sistema utilizado para logar no sistema.
	 * @return Retora os dados do usuario
	 */
	
	public ClsUsuarioDoSistema BuscarUmUsuario(String nome, String senha) 
	{
		
		ClsUsuarioDoSistema usu = new ClsUsuarioDoSistema();
		
		
		usu.setVarNomeUsuario(nome);
		usu.setVarSenhaUsuario(senha);
				
		return usu;
		
		/*
		Connection conn = ClsConexaoBancoDeDados.getConnection();
		String sql = "Select * from  Tecwendusuarios  where nome=? and seha=? ";
		
		try
		
		{
			PreparedStatement busca =  conn.prepareStatement(sql);
			
			busca.setString(1, nome);
			busca.setString(2, senha);
			
			ResultSet umUsu = busca.executeQuery();
			
			
				ClsUsuarioDoSistema usu = new ClsUsuarioDoSistema();
				
				usu.setVarCodigoUsuario(umUsu.getInt("id"));
				usu.setVarNomeUsuario(umUsu.getString("Nome"));
				usu.setVarSenhaUsuario(umUsu.getString("Senha"));
				usu.setVarTipoUsuario(umUsu.getString("Tipo"));
				
				return usu;
			
				
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	   	}
	   	*/
		
		
		
	}

}
