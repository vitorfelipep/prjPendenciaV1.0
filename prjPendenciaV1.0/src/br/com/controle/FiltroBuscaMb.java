package br.com.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.model.ConsultaPedModel;
import br.com.model.FiltroBusca;

@ManagedBean(name="filtroBuscaMb")
@SessionScoped
public class FiltroBuscaMb implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private FiltroBusca filtroBusca;
	private List<ConsultaPedModel> listaConsulta;
	
	public FiltroBuscaMb() {
		this.filtroBusca = new FiltroBusca();
		this.listaConsulta = new ArrayList<ConsultaPedModel>();
	}
	
	public List<FiltroBusca> buscarPendencias(){
		try{
			System.out.println(filtroBusca);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
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
	
	
	
}
