package br.com.persistence.dao;

import java.util.List;

import br.com.model.ConsultaPedModel;

public class ConsultaPedDao extends DaoMySql{
	public List<ConsultaPedModel> consultaPendencia(){
		try{
			open();
				stmt = con.prepareStatement("SELECT tbped.idPed, "+
										     " tbped.nomependencia, "+ 
										    "  tbped.statusPend, "+
										    "  tbpat.descPasta, "+
										    "  date_Format(tbped.datEmiPend, '%m/%d/%Y' ) as 'Data emissão', "+
											"  date_Format(tbped.datPrevFechamento,  '%m/%d/%Y' ) as 'dataFechamento', "+
										    "  tabExt.descExtensao "+
										" FROM adv_pendencia.tab_pedencia tbped "+
										" INNER JOIN adv_pendencia.tab_pasta tbpat "+
										" ON tbpat.idPasta = tbped.tab_pasta_idPasta "+
										" INNER JOIN adv_pendencia.tab_extensao tabExt "+
										" ON tabExt.tab_pasta_idPasta = tbpat.idPasta "+
										" WHERE tbped.statusPend like '%Em aberto%' "+
										"     and tbped.datPrevFechamento between ? and ? "+
										" GROUP by "+
												" tbped.idPed, "+ 
												" tbped.nomependencia, "+ 
												" tbped.statusPend, "+
												" tbpat.descPasta, "+
												" tbped.datEmiPend, "+
												" tbped.datPrevFechamento, "+
												" tabExt.descExtensao "+
										" ORDER BY tbped.nomependencia asc");
			
			close();
		}catch(Exception e){
			e.printStackTrace();
            e.getMessage();	
		}
		return null;
	}
}
