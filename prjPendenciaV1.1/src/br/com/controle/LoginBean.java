package br.com.controle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.model.UsuarioModel;
import br.com.persistence.dao.UsuarioDao;

@ManagedBean
@ViewScoped
public class LoginBean {
	private UsuarioModel usuario;
	
	public LoginBean() {
		this.usuario = new UsuarioModel();
		
	}

	
	public String entrar(){
		System.out.println(usuario);
		try{
//			HttpSession ses = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);  
//		    HttpServletResponse rp = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();  
//		    
			usuario = new UsuarioDao().getUsuario(usuario);
			if(usuario == null){
				usuario = new UsuarioModel(); 
				FacesContext.getCurrentInstance().addMessage( 
								null, new FacesMessage(
										FacesMessage.SEVERITY_ERROR, "Usuário não encontrado!", "Usuário inválido!")); 
				
//				ses.setAttribute("usuario", null);  
//	            ses.removeAttribute("usuario");  
//	            
				return null;
				
			}else{
//				ses.setAttribute("usuario", usuario);
//				rp.sendRedirect("home.jsf?faces-redirect=true");
				return "home.jsf?faces-redirect=true";
			}
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public UsuarioModel getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioModel usuario) {
		this.usuario = usuario;
	}
	
	
	
}
