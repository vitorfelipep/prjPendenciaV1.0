package br.com.persistence.dao;

import br.com.model.ConsultaPedModel;

public class AlterarPendenciaConsulta extends DaoMysql{
	public void alterarConsultaDao(ConsultaPedModel cpm){
		try{
			open();
				
			
			
			close();
		}catch(Exception e){
			
		}
	}
}
