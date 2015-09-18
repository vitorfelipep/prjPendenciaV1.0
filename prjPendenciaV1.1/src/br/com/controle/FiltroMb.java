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
		
	//Metodo para verificar valida��o de acesso.
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
	
	//M�todo de cadastro
	public void cadastrar(){
		try{
			
			
			if(filtro.getNomPendencia().isEmpty()){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Aten��o!","Campo nome da pend�ncia � obrigat�rio!"));
			}else if(filtro.getDescPendencia().isEmpty()){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Aten��o!","Campo descri��o da pend�ncia � orbigat�rio!"));
			}else if(!(filtro.getPasta() > 0)){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Aten��o!","Campo Pasta � obrigat�rio!"));
			}else
				if(filtro.getNomeExtensao() == null || filtro.getExtensao() == null){
			
					System.out.println("Entrou aqui");
					filtro.setNomeExtensao("--Sem Extens�o--");
					filtro.setExtensao("--Sem Extens�o--");;
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
	public void inicializarList(){//Este m�todo constr�i a lista de pendencia aberta
		listaPasta = new PastaDao().getPasta();
	}
	
	//M�todo saida(logout)
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
        String summary = value2 ? "Com extens�o" : "Sem extens�o!"; 
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
