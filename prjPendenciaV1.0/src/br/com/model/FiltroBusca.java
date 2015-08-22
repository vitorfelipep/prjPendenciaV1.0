package br.com.model;

import java.util.Date;

public class FiltroBusca {
	private int tipoBusca;
	private String nomPendencia;
	private Date dataIni;
	private Date dataFim;
	
	
	public FiltroBusca() {
		// TODO Auto-generated constructor stub
	}
	
	public int getTipoBusca() {
		return tipoBusca;
	}
	public void setTipoBusca(int tipoBusca) {
		this.tipoBusca = tipoBusca;
	}
	public String getNomPendencia() {
		return nomPendencia;
	}
	public void setNomPendencia(String nomPendencia) {
		this.nomPendencia = nomPendencia;
	}
	public Date getDataIni() {
		return dataIni;
	}
	public void setDataIni(Date dataIni) {
		this.dataIni = dataIni;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	@Override
	public String toString() {
		return "FiltroBusca [tipoBusca=" + tipoBusca + ", nomPendencia="
				+ nomPendencia + ", dataIni=" + dataIni + ", dataFim="
				+ dataFim + "]";
	}
	
}
