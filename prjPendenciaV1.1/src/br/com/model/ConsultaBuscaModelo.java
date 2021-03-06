package br.com.model;



public class ConsultaBuscaModelo {
	private int idPed;
	private String nomePendencia;
	private String descPendencia;
	private String statusPendencia;
	private String descPasta;
	private String dataEmisao;
	private String dataFechamento;
	private String descExtensao;
	private int idPasta;
	private String obsExtensao;
	
	
	public ConsultaBuscaModelo() {
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
	public String getDescPasta() {
		return descPasta;
	}
	public void setDescPasta(String descPasta) {
		this.descPasta = descPasta;
	}
	public String getDataEmisao() {
		return dataEmisao;
	}
	public void setDataEmisao(String dataEmisao) {
		this.dataEmisao = dataEmisao;
	}
	public String getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(String dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public String getDescExtensao() {
		return descExtensao;
	}
	public void setDescExtensao(String descExtensao) {
		this.descExtensao = descExtensao;
	}
	public int getIdPasta() {
		return idPasta;
	}
	public void setIdPasta(int idPasta) {
		this.idPasta = idPasta;
	}
	public String getObsExtensao() {
		return obsExtensao;
	}
	public void setObsExtensao(String obsExtensao) {
		this.obsExtensao = obsExtensao;
	}

	public String getDescPendencia() {
		return descPendencia;
	}

	public void setDescPendencia(String descPendencia) {
		this.descPendencia = descPendencia;
	}

	@Override
	public String toString() {
		return "ConsultaBuscaModelo [idPed=" + idPed + ", nomePendencia="
				+ nomePendencia + ", descPendencia=" + descPendencia
				+ ", statusPendencia=" + statusPendencia + ", descPasta="
				+ descPasta + ", dataEmisao=" + dataEmisao
				+ ", dataFechamento=" + dataFechamento + ", descExtensao="
				+ descExtensao + ", idPasta=" + idPasta + ", obsExtensao="
				+ obsExtensao + "]";
	}
}
