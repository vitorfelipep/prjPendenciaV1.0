package br.com.model;

import java.util.Date;

public class ConsultaPedModel {
	private int idPed;
	private String nomePendencia;
	private String statusPendencia;
	private int idPasta;
	private String descPasta;
	private Date dataEmisao;
	private Date dataFechamento;
	private int idExtensao;
	private String descExtensao;
	
	public ConsultaPedModel() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPed() {
		return idPed;
	}

	public void setIdPed(int idPed) {
		this.idPed = idPed;
	}

	public String getNomePendencia() {
		return nomePendencia;
	}

	public void setNomePendencia(String nomePendencia) {
		this.nomePendencia = nomePendencia;
	}

	public String getStatusPendencia() {
		return statusPendencia;
	}

	public void setStatusPendencia(String statusPendencia) {
		this.statusPendencia = statusPendencia;
	}

	public int getIdPasta() {
		return idPasta;
	}

	public void setIdPasta(int idPasta) {
		this.idPasta = idPasta;
	}

	public String getDescPasta() {
		return descPasta;
	}

	public void setDescPasta(String descPasta) {
		this.descPasta = descPasta;
	}

	public Date getDataEmisao() {
		return dataEmisao;
	}

	public void setDataEmisao(Date dataEmisao) {
		this.dataEmisao = dataEmisao;
	}

	public Date getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public int getIdExtensao() {
		return idExtensao;
	}

	public void setIdExtensao(int idExtensao) {
		this.idExtensao = idExtensao;
	}

	public String getDescExtensao() {
		return descExtensao;
	}

	public void setDescExtensao(String descExtensao) {
		this.descExtensao = descExtensao;
	}

	@Override
	public String toString() {
		return "ConsultaPedModel [idPed=" + idPed + ", nomePendencia="
				+ nomePendencia + ", statusPendencia=" + statusPendencia
				+ ", idPasta=" + idPasta + ", descPasta=" + descPasta
				+ ", dataEmisao=" + dataEmisao + ", dataFechamento="
				+ dataFechamento + ", idExtensao=" + idExtensao
				+ ", descExtensao=" + descExtensao + "]";
	}
	
	
}
