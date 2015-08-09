package br.com.persistence.dao;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.model.FiltroCadPendencia;

public class PendenciaDao extends DaoMySql{
	
	public void cadastrarPendencia(FiltroCadPendencia filtro){
		try{
			open();
				String sql = "INSERT INTO adv_pendencia.tab_pedencia VALUES(null, ?,'Em aberto', ?, null, ?)";
				stmt = con.prepareStatement(sql);
				
				stmt.setString(1, filtro.getDescPendencia());
				stmt.setString(2, filtro.getNomPendencia());
				stmt.setInt(3, filtro.getPasta());
				
				int retorno = stmt.executeUpdate();
				if(retorno > 0){
					
					System.out.println("dados inseridos com sucesso!");
					new PastaStatusAlterarDao().mudarStatusPasta(filtro);
				}
				

			close();
		}catch(SQLException sq){
			throw new RuntimeException(sq);
		}catch(Exception e){
			e.printStackTrace();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Erro interno!","Por favor, contate o desenvolvedor! erro: "+ e.getMessage()));
		}	
	}
	
}
