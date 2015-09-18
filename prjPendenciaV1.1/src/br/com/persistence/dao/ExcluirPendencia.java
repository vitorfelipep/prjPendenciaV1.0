package br.com.persistence.dao;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.model.ConsultaBuscaModelo;

public class ExcluirPendencia extends DaoMysql{
	
	public void alterarPastaPendenciaParaExcluir(ConsultaBuscaModelo cpm){
		try{
			open();
				stmt = con.prepareStatement("UPDATE adv_pendencia.tab_pasta set statusPasta = 'livre' where idPasta = ?");
				stmt.setInt(1, cpm.getIdPasta());
				
				int fechamento = stmt.executeUpdate();
				if(fechamento > 0){
					System.out.println("Pasta alterada com sucesso para livre");
					excluirExtensaoSelecionada(cpm);
				}else{
					System.out.println("Erro ao fazer o update!");
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Erro!","Erro ao excluir a pendencia a pasta não pode ser alterada!"));
				}
				
			close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void excluirExtensaoSelecionada(ConsultaBuscaModelo cpm){
		try{
			open();
				stmt = con.prepareStatement("DELETE FROM adv_pendencia.tab_extensao WHERE tab_pasta_idPasta = ? AND fk_idPendencia = ?");
				stmt.setInt(1, cpm.getIdPasta());
				stmt.setInt(2, cpm.getIdPed());
				
				int fechamento = stmt.executeUpdate();
				if(fechamento > 0){
					System.out.println("Extensão excluida com sucesso");
					excluirPendenciaSelecionada(cpm);
				}else{
					System.out.println("Erro ao fazer Exclusão!");
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Erro!","Erro ao excluir a pendencia a extensão não pode ser alterada!"));
				}
			close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void excluirPendenciaSelecionada(ConsultaBuscaModelo cpm){
		try{
			open();
				stmt = con.prepareStatement("DELETE FROM adv_pendencia.tab_pedencia WHERE idPed = ?");
				stmt.setInt(1, cpm.getIdPed());
				
				int fechamento = stmt.executeUpdate();
				if(fechamento > 0){
					System.out.println("pendencia excluida com sucesso");
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Feito!","Pendencia Excluida com sucesso!"));
				}else{
					System.out.println("Erro ao fazer Exclusão!");
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Erro!","Erro ao excluir a pendencia!"));
				}
			close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
