package br.com.persistence.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoMySql {
	Connection con;  // Conexao ao Banco de Dados
	PreparedStatement stmt; // Acessa a Tabela ( insert, update, delete , select)
	@SuppressWarnings("unused")
	private Statement st; //
	ResultSet rs; // Consulta a Tabela( select )
	CallableStatement call; // Procedures e Function
	
	public void open() throws Exception{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/adv_pendencia", "root", "");	
			st = con.createStatement();
			System.out.println("Conexão efetuada com sucesso"); // Mensagem para o usuário
			
			
		}catch(SQLException ex){
			System.out.println("Falha na Conexão"+ex.getMessage());// Mensagem para o usuário
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void close() throws Exception{		
		con.close();
	}
}
