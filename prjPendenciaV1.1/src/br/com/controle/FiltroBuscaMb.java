package br.com.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import br.com.model.ConsultaPedModel;
import br.com.model.FiltroBusca;
import br.com.persistence.dao.ConsultaPedDao; 

@ManagedBean(name="filtroBuscaMb") 
@ViewScoped
public class FiltroBuscaMb implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private FiltroBusca filtroBusca;
	private ConsultaPedModel filtroAlteracao;
	private List<ConsultaPedModel> listaConsulta;
	
	public FiltroBuscaMb() {//construtor
		this.filtroBusca = new FiltroBusca();
		this.filtroAlteracao = new ConsultaPedModel();
		this.listaConsulta = new ArrayList<ConsultaPedModel>();
	}
	
	public List<ConsultaPedModel> buscarPendencias(){//Busca de pendencias
		try{
			System.out.println(filtroBusca);
			//if(!filtroBusca.getTipoBusca().isEmpty()){
				listaConsulta = new ConsultaPedDao().consultaPendencia(filtroBusca);
				return listaConsulta;
			//}else{
				//FacesContext context = FacesContext.getCurrentInstance();
				//context.addMessage(null, new FacesMessage("Aten��o!","Campo op��o � obrigat�rio, por favor escolha a op��o de busca!"));
			//}
		}catch(Exception e){
			e.printStackTrace();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Erro!","Erro ao fazer a consulta, por favor entre em contato com o desenvolvedor!" + e.getMessage()));
			
		}
		return null;
		
	}
	
	public void alterarPendencia(){
		try{
			
		}catch(Exception e){
			e.printStackTrace();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Erro!","Erro ao fazer a alteração, por favor entre em contato com o desenvolvedor!" + e.getMessage()));
			
		}
	}
	
	public void alterarPendenciaModal(){
		
	}
	
	
	public List<ConsultaPedModel> getListaConsulta() {
		return listaConsulta;
	}

	public void setListaConsulta(List<ConsultaPedModel> listaConsulta) {
		this.listaConsulta = listaConsulta;
	}

	public FiltroBusca getFiltroBusca() {
		return filtroBusca;
	}

	public void setFiltroBusca(FiltroBusca filtroBusca) {
		this.filtroBusca = filtroBusca;
	}
 
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public ConsultaPedModel getFiltroAlteracao() {
		return filtroAlteracao;
	}

	public void setFiltroAlteracao(ConsultaPedModel filtroAlteracao) {
		System.out.println(filtroAlteracao);
		this.filtroAlteracao = filtroAlteracao;
		
	}
	
	
}
