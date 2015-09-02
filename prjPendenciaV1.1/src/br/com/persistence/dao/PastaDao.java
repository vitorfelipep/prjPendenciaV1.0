package br.com.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.model.Pasta;

public class PastaDao extends DaoMysql{
	public List<Pasta> getPasta(){
		try{
			open();
				
				stmt = con.prepareStatement("SELECT idPasta, descPasta FROM adv_pendencia.tab_pasta where statusPasta = 'livre'");
			    rs = stmt.executeQuery();
			    
			    List<Pasta> listaPasta = new ArrayList<Pasta>();
				
				while(rs.next()){
					
					Pasta p = new Pasta();
					p.setIdPasta(rs.getInt("idPasta"));	
					p.setDescPasta(rs.getString("descPasta"));
					
					listaPasta.add(p);
					//System.out.println(listaPasta);
				}
			
				
			close();
			
			return listaPasta;
			
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
