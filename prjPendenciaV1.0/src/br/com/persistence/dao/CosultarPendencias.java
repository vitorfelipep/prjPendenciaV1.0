package br.com.persistence.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.model.Pendencia;

public class CosultarPendencias extends DaoMySql{
	public List<Pendencia> getListaPendencia(Pendencia pendencia){
		
		try{
			open();
				
				stmt = con.prepareStatement("SELECT p.idPed, "+
													 "  p.descPend, "+ 
												     "  p.statusPend, "+ 
												     "  p.nomependencia, "+
												     "  date_format(p.datEmiPend, '%d/%m/%Y') dataCadPend,"+
												     "  p.tab_pasta_idPasta, "+
												     "  pt.descPasta "+
									      " FROM adv_pendencia.tab_pedencia p "+
									      " INNER JOIN adv_pendencia.tab_pasta pt "+
									      " ON pt.idPasta = p.tab_pasta_idPasta "+
										    "  WHERE nomependencia like ? "+
											"  AND statusPend = 'Em aberto' "+
											"  ORDER BY nomependencia");
				
				stmt.setString(1, '%' + pendencia.getNomependencia() + '%');
				rs = stmt.executeQuery();
				
				List<Pendencia> listaPendencia = new ArrayList<Pendencia>();
				while(rs.next()){
					Pendencia p = new Pendencia();
					
					p.setIdped(rs.getInt("idPed"));
					p.setDescPed(rs.getString("descPend"));
					p.setStatusPed(rs.getString("statusPend"));
					p.setNomependencia(rs.getString("nomependencia"));
					p.setDatEmiPend(rs.getString("dataCadPend"));
					p.setIdPasta(rs.getInt("tab_pasta_idPasta"));
					p.setDescPasta(rs.getString("descPasta"));
					
					listaPendencia.add(p);
				}
					
			close();
			System.out.println(listaPendencia);
			return listaPendencia;
		}catch(Exception e){
			e.getMessage();
			e.printStackTrace();
			return null;
		}
		
	}
}
