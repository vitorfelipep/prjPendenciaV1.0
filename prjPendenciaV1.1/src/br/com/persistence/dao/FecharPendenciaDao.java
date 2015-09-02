package br.com.persistence.dao;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.model.Pendencia;

public class FecharPendenciaDao extends DaoMysql{
	public void fecharPendencias(Pendencia pendencia){
		
		try{
			open();
				stmt = con.prepareStatement("UPDATE adv_pendencia.tab_pedencia set statusPend = ? where idPed = ? and tab_pasta_idPasta = ?");
				
				stmt.setString(1, pendencia.getStatusPed());
				stmt.setInt(2, pendencia.getIdped());
				stmt.setInt(3, pendencia.getIdPasta());
				
				int fechamento = stmt.executeUpdate();
				if(fechamento > 0){
					new PastaStatusAlterarDao().mudarStatusPastaAberto(pendencia);
				}else{
					System.out.println("Erro ao fazer o update!");
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Erro!","Erro ao fazer o fechamento desta pendencia, tente novamente!"));
				}
				
			close();
		}catch(Exception e){
			e.printStackTrace();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Erro critico!","Erro ao fazer o fechamento desta pendencia, exce��p:" + e.getMessage()));
			
		}
	}
}
