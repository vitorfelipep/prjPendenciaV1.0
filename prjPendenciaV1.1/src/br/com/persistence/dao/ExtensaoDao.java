package br.com.persistence.dao;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import br.com.model.ExtensaoPasta;
import br.com.model.FiltroCadPendencia;

public class ExtensaoDao extends DaoMysql{
	public void buscarPendencia(FiltroCadPendencia filtro){
		try{
			open();
				
				stmt = con.prepareStatement("SELECT idPed FROM adv_pendencia.tab_pedencia where tab_pasta_idPasta = ?");
				stmt.setInt(1, filtro.getPasta());
				rs = stmt.executeQuery();
				ExtensaoPasta extensao = new ExtensaoPasta();
				while(rs.next()){
					
					extensao.setIdPastaFK(rs.getInt("idPed"));
				}
				System.out.println(extensao.getIdPastaFK());
				cadastrarExtensao(filtro, extensao);	
				
			close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void cadastrarExtensao(FiltroCadPendencia filtro, ExtensaoPasta extensao){
		try{
			open();
			System.out.println(filtro.getNomeExtensao());	
			
				if(filtro.getNomeExtensao() == "--"){
					
					System.out.println("N�o houve extens�o, cadastrado apenas a pendencia!");
					FacesContext context = FacesContext.getCurrentInstance();
					context.addMessage(null, new FacesMessage("Aten��oo","Dados cadastrados com sucesso, mais n�o houve extens�o vinculada a pendencia!"));
					
					
				}else{
					
					stmt = con.prepareStatement("insert into adv_pendencia.tab_extensao values(null,?, ?,?,?)");
					stmt.setString(1, filtro.getNomeExtensao());
					stmt.setString(2, filtro.getExtensao());
					stmt.setInt(3, filtro.getPasta());
					stmt.setInt(4, extensao.getIdPastaFK());  
					int cadastro = stmt.executeUpdate();
					if(cadastro > 0){
						FacesContext context = FacesContext.getCurrentInstance();
						context.addMessage(null, new FacesMessage("Sucesso!","Dados cadastrados com sucesso!"));
						System.out.println("-->Dados de Extens�o cadastrados com sucesso!");
					}else{
						FacesContext context = FacesContext.getCurrentInstance();
						context.addMessage(null, new FacesMessage("Erro!","N�o foi possivel cadastrar dados da pend�ncia"));
						
						System.out.println("-->Erro ao cadastrar os dados!");
					}
					
					
				}

			close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
