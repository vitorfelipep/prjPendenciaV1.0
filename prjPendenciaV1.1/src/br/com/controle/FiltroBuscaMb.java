package br.com.controle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.model.ConsultaBuscaModelo;
import br.com.model.FiltroBusca;
import br.com.model.Pasta;
import br.com.persistence.dao.AlterarPendenciaConsulta;
import br.com.persistence.dao.ConsultaPedDao; 
import br.com.persistence.dao.ExcluirPendencia;
import br.com.persistence.dao.PastaDao;

@ManagedBean(name="filtroBuscaMb") 
@ViewScoped
public class FiltroBuscaMb implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private FiltroBusca filtroBusca;
	private ConsultaBuscaModelo filtroAlteracao;
	private List<ConsultaBuscaModelo> listaConsulta;
	private List<Pasta> listaPasta;
	
	public FiltroBuscaMb() {//construtor
		this.filtroBusca = new FiltroBusca();
		this.filtroAlteracao = new ConsultaBuscaModelo();
		this.listaConsulta = new ArrayList<ConsultaBuscaModelo>();
		listaPasta =  new ArrayList<Pasta>();
		verificarPermissaoUsuario();
	}
	
	//*************************************************************************/
	public void verificarPermissaoUsuario(){
//		try{
//			if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") == null){
//				FacesContext.getCurrentInstance().getExternalContext().redirect("index.jsf");
//			}
//		}catch(Exception e){
//			e.printStackTrace();
//		}
	}
	
	
	//*************************************************************************/
	//Busca de pendencias
	public List<ConsultaBuscaModelo> buscarPendencias(){
		try{
			
			if(filtroBusca.getDataIni() == null || filtroBusca.getDataFim() == null){
				 FacesContext context = FacesContext.getCurrentInstance();
                 context.addMessage(null, new FacesMessage("Atenção!",  "Campos data inicial e final são obrigatórios!")); 			
			}else
				if(!filtroBusca.getDataFim().after(filtroBusca.getDataIni()) && !filtroBusca.getDataFim().equals(filtroBusca.getDataIni())){
					FacesContext context = FacesContext.getCurrentInstance();
	                 context.addMessage(null, new FacesMessage("Atenção!",  "Campos data inicial não pode ser maior que data final, por favor tente novamente!"));	 
				}else{
					listaConsulta = new ConsultaPedDao().consultaPendencia(filtroBusca);
					return listaConsulta;
				}
			
		}catch(Exception e){
			e.printStackTrace();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Erro!","Erro ao fazer a consulta, por favor entre em contato com o desenvolvedor!" + e.getMessage()));
			
		}
		
		return null;
	}
	
//	@PostConstruct
//	public void inicializarList(){//Este método constrói a lista de pendencia aberta
//		listaPasta = new PastaDao().getPasta();
//	}
	
	//*************************************************************************/
	//Alterar Pendencia
	public void alterarPendenciaModal(){
		try{
			if("".equals(filtroAlteracao.getNomePendencia())  || "".equals(filtroAlteracao.getDataFechamento())){
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(null, new FacesMessage("Atenção!","É necessário buscar valores para alterar pendências!"));
				
			}else{
				new AlterarPendenciaConsulta().alterarTabPendencia(filtroAlteracao);
				filtroAlteracao =  new ConsultaBuscaModelo();
			}
		}catch(Exception e){
			e.printStackTrace();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Erro!","Erro ao fazer a alteração, por favor entre em contato com o desenvolvedor!" + e.getMessage()));
			
		}
	}
	
	//*************************************************************************/
	//Excluir Pendencias 
	public void excluirPendencia(){
		try{
			new ExcluirPendencia().alterarPastaPendenciaParaExcluir(filtroAlteracao);
			filtroAlteracao =  new ConsultaBuscaModelo();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//*************************************************************************/
	public List<ConsultaBuscaModelo> getListaConsulta() {
		return listaConsulta;
	}

	public void setListaConsulta(List<ConsultaBuscaModelo> listaConsulta) {
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

	public ConsultaBuscaModelo getFiltroAlteracao() {
		return filtroAlteracao;
	}

	public void setFiltroAlteracao(ConsultaBuscaModelo filtroAlteracao) {
		System.out.println(filtroAlteracao);
		this.filtroAlteracao = filtroAlteracao;
		
	}

	public List<Pasta> getListaPasta() {
		return listaPasta;
	}

	public void setListaPasta(List<Pasta> listaPasta) {
		this.listaPasta = listaPasta;
	}
	
	
}
