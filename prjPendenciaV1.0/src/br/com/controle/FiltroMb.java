package br.com.controle;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.model.FiltroCadPendencia;
import br.com.model.Pasta;
import br.com.model.Pendencia;
import br.com.persistence.dao.CosultarPendencias;
import br.com.persistence.dao.FecharPendenciaDao;
import br.com.persistence.dao.PastaDao;
import br.com.persistence.dao.PendenciaDao;


@ManagedBean(name="filtroMb")
@ViewScoped
public class FiltroMb implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
    private boolean value2;
    private boolean mostrar;
    private String filtroBusca;
    private FiltroCadPendencia filtro;
    private List<Pasta> listaPasta;
    private Pendencia pendencia;
    private Pasta pasta;
    private List<Pendencia> listaPendencia;
    
   //Metodo construtor
	public FiltroMb() {
			
		filtro = new FiltroCadPendencia();
		pendencia = new Pendencia();
		listaPasta =  new ArrayList<Pasta>();
		listaPendencia = new ArrayList<Pendencia>();
		
		
	}
		
	
	//Método de cadastro
	public void cadastrar(){
		try{
			
			
			if(filtro.getNomPendencia().isEmpty()){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Atenção!","Campo nome da pendência é obrigatório!"));
			}else if(filtro.getDescPendencia().isEmpty()){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Atenção!","Campo descrição da pendência é obrigatório!"));
			}else if(!(filtro.getPasta() > 0)){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Atenção!","Campo Pasta é obrigatório!"));
			}
			
			System.out.println(filtro);
			new PendenciaDao().cadastrarPendencia(filtro);//Efetua o cadastro... 
			
			this.filtro = new FiltroCadPendencia();
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//metodo de fechar pendencias
	public void fecharPendencia(){
		
		if(!pendencia.getStatusPed().equalsIgnoreCase("Em aberto")){
			System.out.println(pendencia);
			new FecharPendenciaDao().fecharPendencias(pendencia);
		}else{
			System.out.println("Pendencia já está em aberto, para fechar selecione fechar!");
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Atenção!","Pendencia já está em aberto, para fechar selecione fechar!"));
		}
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
    
	@PostConstruct
	public void inicializarList(){//Este método constrói a lista de pendencia aberta
		listaPasta = new PastaDao().getPasta();
	}
	
    
    public List<Pasta> getListaPasta() {
		return listaPasta;
	}

   
	public void setListaPasta(List<Pasta> listaPasta) {
		
		this.listaPasta = listaPasta;
		
	}
	
	
	 public Pasta getPasta() {
		return pasta;
	}


	public void setPasta(Pasta pasta) {
		this.pasta = pasta;
	}


	public FiltroCadPendencia getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroCadPendencia filtro) {
		this.filtro = filtro;
	}

 
   
    
    
     
    public boolean isValue2() {
    	System.out.println(value2);
    	return value2;
		
	}


	public void setValue2(boolean value2) {
		System.out.println(value2);
		this.value2 = value2;
		
	}


	public boolean getMostrar() {
		return mostrar;
	}


	public void setMostrar(boolean mostrar) {
		this.mostrar = mostrar;
	}


	public List<Pendencia> getListaPendencia() {
		return listaPendencia;
	}


	public void setListaPendencia(List<Pendencia> listaPendencia) {
		this.listaPendencia = listaPendencia;
	}

	
	
	public void addMessage() {
        String summary = value2 ? "Com extensão" : "Sem extensão!"; 
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));

        	if(!value2 == false){  
        	   mostrar = true;
        	    System.out.println(mostrar);
        	} else {  
        	   mostrar = false;
        	   System.out.println(mostrar);
        	}  
        	 
    }

	
	public String getFiltroBusca() {
		return filtroBusca;
	}


	public void setFiltroBusca(String filtroBusca) {
		this.filtroBusca = filtroBusca;
	}


	public Pendencia getPendencia() {
		return pendencia;
	}


	public void setPendencia(Pendencia pendencia) {
		this.pendencia = pendencia;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
