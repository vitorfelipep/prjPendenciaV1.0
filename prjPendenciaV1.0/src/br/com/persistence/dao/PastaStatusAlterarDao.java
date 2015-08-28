package br.com.persistence.dao;

import java.sql.SQLException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.model.FiltroCadPendencia;
import br.com.model.Pendencia;

public class PastaStatusAlterarDao extends DaoMySql{
	public void mudarStatusPasta(FiltroCadPendencia filtro) {
		try{
			open();
			
				stmt = con.prepareStatement("update adv_pendencia.tab_pasta set statusPasta = 'ocupado' where idPasta = ?");
			    stmt.setInt(1, filtro.getPasta());
			    int cadastro = stmt.executeUpdate();
			    if(cadastro > 0){
			    	System.out.println("--> Pasta alterada com sucesso!");
			    	new ExtensaoDao().buscarPendencia(filtro);

			    }else{
			    	System.out.println("--> Erro ao alterar a pasta");
			    }
			    
			
			close();
		}catch(SQLException sql){
			sql.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void mudarStatusPastaAberto(Pendencia pendencia){
		try{
			open();
				stmt = con.prepareStatement("update adv_pendencia.tab_pasta set statusPasta = 'livre' where idPasta = ?");
			    stmt.setInt(1, pendencia.getIdPasta());
			    int pastaLivre = stmt.executeUpdate();
			    if(pastaLivre > 0){
			    	System.out.println("Fechamento realizado com sucesso!");
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Sucesso!","Fechamento realizado com sucesso!"));
			    }else{
			    	System.out.println("--> Erro ao alterar a pasta");
			    }
		   close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
