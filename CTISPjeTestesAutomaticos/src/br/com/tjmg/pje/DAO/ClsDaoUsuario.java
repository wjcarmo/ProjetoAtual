package br.com.tjmg.pje.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.tjmg.pje.interfaces.ClsUsuarioDoSistema;

import com.br.tecwend.BancoDeDados.ClsConexaoBancoDeDados;

public class ClsDaoUsuario
{
	
	private Connection conn = ClsConexaoBancoDeDados.getConnection();

	public void CadastroUsuario(ClsUsuarioDoSistema usu) {
		
		String sql = "Insert into Tecwendusuarios ( Id,Nome,Senha,Tipo) values (?, ?, ?, ?) ";
		
		try {
			PreparedStatement insert =  (PreparedStatement) conn.prepareStatement(sql);
			
			insert.setLong(1, usu.getVarCodigoUsuario());
			insert.setString(2, usu.getVarNomeUsuario());
			insert.setString(3, usu.getVarSenhaUsuario());
			insert.setString(4, usu.getVarTipoUsuario());
			
			insert.execute();
			insert.close();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void AlterarUsuario(ClsUsuarioDoSistema usu) 
	{
String sql = "Update Tecwendusuarios  set Nome=?,Senha=?,Tipo=? where id=? ";
		
		try {
			PreparedStatement insert =  (PreparedStatement) conn.prepareStatement(sql);
			
			
			insert.setString(1, usu.getVarNomeUsuario());
			insert.setString(2, usu.getVarSenhaUsuario());
			insert.setString(3, usu.getVarTipoUsuario());
			insert.setLong(4, usu.getVarCodigoUsuario());
			
			insert.execute();
			insert.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void ExcluirUsuario(ClsUsuarioDoSistema usu) 
	{
String sql = "delete from  Tecwendusuarios  where id=? ";
		
		try {
			PreparedStatement insert =  (PreparedStatement) conn.prepareStatement(sql);
			
			insert.setLong(1, usu.getVarCodigoUsuario());
			
			insert.execute();
			insert.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void SalvarUsuario(ClsUsuarioDoSistema usu) 
	{
		if(usu.getVarCodigoUsuario()!= 0)
		{
			AlterarUsuario(usu);
		}
		else
		{
			CadastroUsuario(usu);
		}
		
	}
	
	/**
	 * O metodo BuscarUmUsuarios conecta no banco de dados e busca o usuario conforme o ID informado.
	 * @param Id O parametro é o código do usuario no banco de dados, utilizado nos sistema
	 * @return O Retorno é dados do usuario informado.
	 */
	
	public ClsUsuarioDoSistema BuscarUmUsuario(int Id) 
	{
			String sql = "Select * from  Tecwendusuarios  where id=? ";
		
		try
		
		{
			PreparedStatement busca =  (PreparedStatement) conn.prepareStatement(sql);
			
			busca.setLong(1, Id);
			
			ResultSet umUsu = busca.executeQuery();
			
			if(umUsu.next())
			{
				ClsUsuarioDoSistema usu = new ClsUsuarioDoSistema();
				
				usu.setVarCodigoUsuario(umUsu.getInt("id"));
				usu.setVarNomeUsuario(umUsu.getString("Nome"));
				usu.setVarSenhaUsuario(umUsu.getString("Senha"));
				usu.setVarTipoUsuario(umUsu.getString("Tipo"));
				
				return usu;
			}
				
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	   	}
	
	/**
	 * Realiza a busca de todos os usarios dos sistemas
	 * @return O retorno é em uma lista quando tem ou vazia quando não tem dados
	 */
	public List<ClsUsuarioDoSistema> BuscarTodosUsuario() 
	{
			String sql = "Select * from  Tecwendusuarios ";
			List<ClsUsuarioDoSistema> lista =  new ArrayList<ClsUsuarioDoSistema>();
			
		
		try
				
		{
			PreparedStatement busca =  (PreparedStatement) conn.prepareStatement(sql);
			ResultSet umUsu = busca.executeQuery();
			
			while(umUsu.next())
			{
				ClsUsuarioDoSistema usu = new ClsUsuarioDoSistema();
				
				usu.setVarCodigoUsuario(umUsu.getInt("id"));
				usu.setVarNomeUsuario(umUsu.getString("Nome"));
				usu.setVarSenhaUsuario(umUsu.getString("Senha"));
				usu.setVarTipoUsuario(umUsu.getString("Tipo"));
				
				lista.add(usu);
			}
				
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	   	}
}
