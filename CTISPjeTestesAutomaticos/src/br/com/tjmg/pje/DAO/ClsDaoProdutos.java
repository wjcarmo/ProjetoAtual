package br.com.tjmg.pje.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.tjmg.pje.interfaces.ClsProdutosNoSistema;

import com.br.tecwend.BancoDeDados.ClsConexaoBancoDeDados;

public class ClsDaoProdutos {
	
	
	private Connection  conn = ClsConexaoBancoDeDados.getConnection();
	
	public void CadastroDeProdutos(ClsProdutosNoSistema prod)
	{
		String sql = "Insert into tecwendprodutos(Id,Descricao,Un,CodigoBarra) values (?,?,?,?) ";
		
		try {
			
			PreparedStatement insert =  (PreparedStatement) conn.prepareStatement(sql);
			
			insert.setString(1, prod.getVarCodigoDoproduto());
			insert.setString(2, prod.getVarNomeDoProduto());
			insert.setString(3, prod.getVarUnDoProduto());
			insert.setString(4, prod.getVarCodBarraDoProduto());
			
			insert.execute();
			insert.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

