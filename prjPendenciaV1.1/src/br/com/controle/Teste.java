package br.com.controle;

import br.com.persistence.dao.*;


public class Teste {
	public static void main(String[] args) throws Exception {
		
//		Dao con = new Dao();
//		con.getConexaoMySQL();
//		
//		System.out.println(con.statusConection());
		
		DaoMysql sql = new DaoMysql();
		
		sql.open();
		
	}
}
