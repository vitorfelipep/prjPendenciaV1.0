package br.com.controle;

import br.com.persistence.dao.Dao;
import br.com.persistence.dao.DaoMySql;

public class Teste {
	public static void main(String[] args) throws Exception {
		
//		Dao con = new Dao();
//		con.getConexaoMySQL();
//		
//		System.out.println(con.statusConection());
		
		DaoMySql sql = new DaoMySql();
		
		sql.open();
		
	}
}
