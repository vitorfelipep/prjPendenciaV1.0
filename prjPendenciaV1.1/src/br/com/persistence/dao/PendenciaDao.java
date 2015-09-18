package br.com.persistence.dao;


import java.sql.Date;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import br.com.model.FiltroCadPendencia;
import br.com.model.FormatarDatas;

public class PendenciaDao extends DaoMysql{
	//M�todo de cadastro de pendencia no banco.
	public void cadastrarPendencia(FiltroCadPendencia filtro){

		try{
			open();

				
				FormatarDatas dataF = new FormatarDatas();//Instancio o objeto para instanciar a data util
				Date data = dataF.formatarData(filtro.getDataPrevPendencia()); // me retorna a data reformulada para cadastro no banco.
				
				String sql = "INSERT INTO adv_pendencia.tab_pedencia VALUES(null, ?,'Em aberto', ?, null, ?,?)";
				stmt = con.prepareStatement(sql);
				
				//seto as persistencias
				stmt.setString(1, filtro.getDescPendencia());
				stmt.setString(2, filtro.getNomPendencia());
				stmt.setInt(3, filtro.getPasta());
				stmt.setDate(4, data);
				
				int retorno = stmt.executeUpdate();
				if(retorno > 0){
					
					System.out.println("dados inseridos com sucesso!");
					new PastaStatusAlterarDao().mudarStatusPasta(filtro);//instancio a classe e chamo o metodo para mudar o status da pasta.
				}
				

			close();
		}catch(SQLException sq){
			throw new RuntimeException(sq);
		}catch(Exception e){
			e.printStackTrace();
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage("Erro interno!","Por favor, contate o desenvolvedor! erro: "+ e.getMessage()));
		}	
	}
	
}
