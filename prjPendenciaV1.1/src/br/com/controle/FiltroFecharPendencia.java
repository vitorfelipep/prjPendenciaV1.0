package br.com.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.model.Pasta;
import br.com.model.Pendencia;
import br.com.persistence.dao.CosultarPendencias;
import br.com.persistence.dao.FecharPendenciaDao;

@ManagedBean
@ViewScoped
public class FiltroFecharPendencia implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private List<Pendencia> listaPendencia; 
	private Pendencia pendencia;
	private Pasta pasta;
	
	public FiltroFecharPendencia() {
		listaPendencia = new ArrayList<Pendencia>();
		pendencia = new Pendencia();
		pasta = new Pasta();
	}
	
	
	//Consulta de pendencias para fechamento de pendencias
		public List<Pendencia> consultarPendencia(){
			
			try{
				 listaPendencia = new ArrayList<Pendencia>();
				 System.out.println(pendencia.getNomependencia());
				 listaPendencia = new CosultarPendencias().getListaPendencia(pendencia);
				 System.out.println(listaPendencia);
				 return listaPendencia;
			
			}catch(Exception e){
				e.printStackTrace();
				e.getMessage();
				return null;
			}
		}
		
		
		//metodo de fechar pendencias
		public void fecharPendencia(){
			
			if(!pendencia.getStatusPed().equalsIgnoreCase("Em aberto")){
				System.out.println(pendencia);
				new FecharPendenciaDao().fecharPendencias(pendencia);
				pendencia = new Pendencia();
				listaPendencia = new ArrayList<Pendencia>();
			}else{
				System.out.println("Pendencia já esta em aberto, para fechar selecione fechar!");
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Atenção!","Pendencia já está em aberto, para fechar selecione fechar!"));
			}
		}


		public List<Pendencia> getListaPendencia() {
			return listaPendencia;
		}


		public void setListaPendencia(List<Pendencia> listaPendencia) {
			this.listaPendencia = listaPendencia;
		}


		public Pendencia getPendencia() {
			return pendencia;
		}


		public void setPendencia(Pendencia pendencia) {
			this.pendencia = pendencia;
		}


		public Pasta getPasta() {
			return pasta;
		}


		public void setPasta(Pasta pasta) {
			this.pasta = pasta;
		}
		
		
}
