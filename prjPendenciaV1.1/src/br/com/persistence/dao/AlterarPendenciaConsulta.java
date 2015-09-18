package br.com.persistence.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.model.ConsultaBuscaModelo;


public class AlterarPendenciaConsulta extends DaoMysql{
	public void alterarTabPendencia(ConsultaBuscaModelo cpm){
		try{
			open();
			//Formtando as datas em string para tipo date.io
			SimpleDateFormat parser = new SimpleDateFormat("dd/MM/yyyy");
			Date dataEmissao = parser.parse(cpm.getDataEmisao());
			Date dataPrevisaoFechamento = parser.parse(cpm.getDataFechamento());
			
			//Formta data tipo date.io para data.sql
			java.sql.Date dataSqlEmissao = new java.sql.Date(dataEmissao.getTime());
			java.sql.Date dataSqlFechamento = new java.sql.Date(dataPrevisaoFechamento.getTime());
			System.out.println(dataSqlEmissao);
			System.out.println(dataSqlFechamento);
			
			stmt = con.prepareStatement("UPDATE adv_pendencia.tab_pedencia set nomependencia = ?, descPend = ?, statusPend = ?, datEmiPend = ?, datPrevFechamento =? where idPed = ?");
			
			stmt.setString(1, cpm.getNomePendencia());
			stmt.setString(2, cpm.getDescPendencia());
			stmt.setString(3, cpm.getStatusPendencia());
			stmt.setDate(4, dataSqlEmissao);
			stmt.setDate(5, dataSqlFechamento);
			stmt.setInt(6, cpm.getIdPed());
			
			int fechamento = stmt.executeUpdate();
			if(fechamento > 0){
				System.out.println("Alterado com sucesso!");
				new AlterarPendenciaConsulta().alterarPasta(cpm);
			}else{
				System.out.println("Erro ao fazer o update!");
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Erro!","Erro ao alterar informações da pendência, tente novamente!"));
			}
			
			
			close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	/*------------------------------------------Alterar a pasta ---------------------------------------------*/
	
	public void alterarPasta(ConsultaBuscaModelo cpm){
		try{
			open();
			if("Em aberto".equals(cpm.getStatusPendencia())){
				
				stmt = con.prepareStatement("update adv_pendencia.tab_pasta set statusPasta = 'ocupado' where idPasta = ?");
				stmt.setInt(1, cpm.getIdPasta());
				
				int fechamento = stmt.executeUpdate();
				if(fechamento > 0){
					System.out.println("Pasta alterada com sucesso para ocupado");
					new AlterarPendenciaConsulta().alterarExtensao(cpm);
				}else{
					System.out.println("Erro ao fazer o update!");
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Erro!","Erro ao alterar informações da pasta, tente novamente!"));
				}
				
			}else{
				stmt = con.prepareStatement("update adv_pendencia.tab_pasta set statusPasta = 'livre' where idPasta = ?");
				stmt.setInt(1, cpm.getIdPasta());
				
				int fechamento = stmt.executeUpdate();
				if(fechamento > 0){
					System.out.println("Pasta alterada com sucesso para livre");
					new AlterarPendenciaConsulta().alterarExtensao(cpm);
				}else{
					System.out.println("Erro ao fazer o update!");
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Erro!","Erro ao alterar informações da pasta, tente novamente!"));
				}
			}
			close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	/*---------------------------------------------------- Alterar Extensão ---------------------------------------------------------------------*/
	
	public void alterarExtensao(ConsultaBuscaModelo cpm){
		try{
			open();
				stmt = con.prepareStatement("update adv_pendencia.tab_extensao set descExtensao = ?, obExtensao = ? where tab_pasta_idPasta = ? and fk_idPendencia = ?");
				
				stmt.setString(1, cpm.getDescExtensao());
				stmt.setString(2, cpm.getObsExtensao());
				stmt.setInt(3, cpm.getIdPasta());
				stmt.setInt(4, cpm.getIdPed());
				
				int fechamento = stmt.executeUpdate();
				if(fechamento > 0){
					System.out.println("Extensão alterada com sucesso!");
					
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Sucesso!","Dados alterados com sucesso!"));
					
					
				}else{
					System.out.println("Erro ao fazer o update!");
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Erro!","Erro ao alterar extensão, tente novamente!"));
				}
				
			close();
//			Thread.sleep(5000);
//			FacesContext.getCurrentInstance().getExternalContext().redirect("consultaPendencia.jsf");  
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
}
