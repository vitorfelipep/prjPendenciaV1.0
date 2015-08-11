package br.com.model;


import java.sql.Date;
import java.text.SimpleDateFormat;



public class FormatarDatas {//Classe responsavel por formatar data
	public Date formatarData(java.util.Date data){
		try{
			SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
			java.sql.Date dataSql = new java.sql.Date(data.getTime());
			 dt.format(dataSql);	 
			System.out.println(dataSql);
			
			return dataSql;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
