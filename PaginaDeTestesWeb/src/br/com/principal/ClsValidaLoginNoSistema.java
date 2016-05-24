package br.com.principal;

import java.io.IOException;
import java.io.PrintWriter;

import javafx.scene.control.Alert;

import com.sun.java.swing.plaf.windows.resources.windows;
import com.sun.prism.paint.Color;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class ClsValidaLoginNoSistema
 */
@WebServlet("/ClsValidaLoginNoSistema")
public class ClsValidaLoginNoSistema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClsValidaLoginNoSistema() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String recebeNome = request.getParameter("Email");
		String recebeSenha = request.getParameter("Passwd");
		
		System.out.println("Pagina em Contrução Sr: "+ recebeNome  );
		
		PrintWriter saida = response.getWriter();
		
		 if(recebeNome.isEmpty() ||recebeSenha.isEmpty() )
		 {			 
			 saida.write( "Usuário Inválido.." ); 
		 }
		 
		 if(recebeNome == "Wenderson" && recebeSenha == "123" )
		 {
			 saida.write("Login realizado com Sucesso...! "+recebeNome +" Passou " );
			 saida.println();
			 saida.println("----------------------------------------------------------");
					 
		 }
		 
		  else 
		 {
			  saida.write("Login Não Realizado...! "+recebeNome +" Falhou " );
			  saida.println();
			  saida.println("----------------------------------------------------------");
			
			  
		 }
		
		 
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
