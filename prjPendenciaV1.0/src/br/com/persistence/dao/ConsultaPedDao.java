package br.com.persistence.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import br.com.model.ConsultaPedModel;
import br.com.model.FiltroBusca;
import br.com.model.FormatarDatas;

public class ConsultaPedDao extends DaoMySql{
	public List<ConsultaPedModel> consultaPendencia(FiltroBusca fb){
		try{
			open();
				
			FormatarDatas dataF = new FormatarDatas();//Instancio o objeto para instanciar a data util
			Date dataFim = dataF.formatarData(fb.getDataFim()); // me retorna a data reformulada para cadastro no banco.
			Date dataInicio = dataF.formatarData(fb.getDataIni());
			
				stmt = con.prepareStatement("SELECT tbped.idPed, "+
										     " tbped.nomependencia, "+ 
										    "  tbped.statusPend, "+
										    "  tbpat.descPasta, "+
										    "  date_Format(tbped.datEmiPend, '%m/%d/%Y' ) as 'DataEmissao', "+
											"  date_Format(tbped.datPrevFechamento,  '%m/%d/%Y' ) as 'dataFechamento', "+
										    "  tabExt.descExtensao, "+
											"  tabExt.tab_pasta_idPasta as 'idPasta', "+
											"  tabExt.obExtensao "+
										" FROM adv_pendencia.tab_pedencia tbped "+
										" INNER JOIN adv_pendencia.tab_pasta tbpat "+
										" ON tbpat.idPasta = tbped.tab_pasta_idPasta "+
										" INNER JOIN adv_pendencia.tab_extensao tabExt "+
										" ON tabExt.tab_pasta_idPasta = tbpat.idPasta "+
										" and tbped.idPed = tabExt.fk_idPendencia "+
										" WHERE tbped.statusPend like ? "+
											" and tbped.datPrevFechamento between ? and ? "+
											"and tbped.nomependencia like ? "+
										" GROUP by "+
												" tbped.idPed, "+ 
												" tbped.nomependencia, "+ 
												" tbped.statusPend, "+
												" tbpat.descPasta, "+
												" tbped.datEmiPend, "+
												" tbped.datPrevFechamento, "+
												" tabExt.descExtensao "+
										" ORDER BY tbped.nomependencia asc");
				
					stmt.setString(1, "%" +fb.getTipoBusca()+ "%");
					stmt.setDate(2, dataInicio);
					stmt.setDate(3, dataFim);
					stmt.setString(4, "%" +fb.getNomPendencia()+ "%");
				
					rs = stmt.executeQuery();
					
					List<ConsultaPedModel> listaConsultaPed = new ArrayList<ConsultaPedModel>();
					while(rs.next()){
						ConsultaPedModel cp = new ConsultaPedModel();
						
						cp.setIdPed(rs.getInt("idPed"));
						cp.setNomePendencia(rs.getString("nomependencia"));
						cp.setStatusPendencia(rs.getString("statusPend"));
						cp.setDescPasta(rs.getString("descPasta"));
						cp.setDataEmisao(rs.getString("DataEmissao"));
						cp.setDataFechamento(rs.getString("dataFechamento"));
						cp.setDescExtensao(rs.getString("descExtensao"));
						cp.setIdPasta(rs.getInt("idPasta"));
						cp.setObsExtensao(rs.getString("obExtensao"));
						
						listaConsultaPed.add(cp);
						
					}
							
			close();
			System.out.println(listaConsultaPed);
			return listaConsultaPed;
		}catch(Exception e){
			e.printStackTrace();
            e.getMessage();	
            return null;
		}
	
	}
}
