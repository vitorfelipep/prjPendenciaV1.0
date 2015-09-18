package br.com.controle;
 
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import br.com.model.FiltroCadPendencia;
import br.com.model.Pasta;
import br.com.persistence.dao.PastaDao;
import br.com.persistence.dao.PendenciaDao;


@ManagedBean(name="filtroMb") 
@RequestScoped
public class FiltroMb implements Serializable{
	
	private static final long serialVersionUID = 1L;
	 
    private boolean value2;
    private boolean mostrar;
    private FiltroCadPendencia filtro;
    private List<Pasta> listaPasta;
   
    
    
   //Metodo construtor
	public FiltroMb() {
			
		filtro = new FiltroCadPendencia();		
		listaPasta =  new ArrayList<Pasta>();
		verificarPermissaoUsuario();

	}
		
	//Metodo para verificar validação de acesso.
	public void verificarPermissaoUsuario(){
//		try{
//			if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario") == null){
//				System.out.println(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("Usuario"));
//				FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}
	
	//Método de cadastro
	public void cadastrar(){
		try{
			
			
			if(filtro.getNomPendencia().isEmpty()){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Atenção!","Campo nome da pendência é obrigatório!"));
			}else if(filtro.getDescPendencia().isEmpty()){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Atenção!","Campo descrição da pendência é orbigatório!"));
			}else if(!(filtro.getPasta() > 0)){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Atenção!","Campo Pasta é obrigatório!"));
			}else
				if(filtro.getNomeExtensao() == null || filtro.getExtensao() == null){
			
					System.out.println("Entrou aqui");
					filtro.setNomeExtensao("--Sem Extensão--");
					filtro.setExtensao("--Sem Extensão--");;
					new PendenciaDao().cadastrarPendencia(filtro);//Efetua o cadastro... 
					
					filtro = new FiltroCadPendencia();
					inicializarList();

				}else{
					
					System.out.println(filtro);
					new PendenciaDao().cadastrarPendencia(filtro);//Efetua o cadastro... 
					inicializarList();
				}
			
			
			this.filtro = new FiltroCadPendencia();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
    
	@PostConstruct
	public void inicializarList(){//Este método constrói a lista de pendencia aberta
		listaPasta = new PastaDao().getPasta();
	}
	
	//Método saida(logout)
	public String sair(){
		System.out.println("Entrou aqui");
		try{
			
//		   SessionContext sessao = new SessionContext();
//		   sessao.encerrarSessao();
			return "index.xhtml?faces-redirect=true";
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
    
    public List<Pasta> getListaPasta() {
		return listaPasta;
	}

   
	public void setListaPasta(List<Pasta> listaPasta) {
		
		this.listaPasta = listaPasta;
		
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
