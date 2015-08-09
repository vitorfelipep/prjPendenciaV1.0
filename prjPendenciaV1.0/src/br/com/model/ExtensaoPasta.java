package br.com.model;

public class ExtensaoPasta {
	
	private int idExtensao;
	private String descExtensao;
	private String obExtensao;
	private int idPastaFK;
	
	
	
	public ExtensaoPasta() {
		// TODO Auto-generated constructor stub
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
	public String getObExtensao() {
		return obExtensao;
	}
	public void setObExtensao(String obExtensao) {
		this.obExtensao = obExtensao;
	}
	public int getIdPastaFK() {
		return idPastaFK;
	}
	public void setIdPastaFK(int idPastaFK) {
		this.idPastaFK = idPastaFK;
	}
	@Override
	public String toString() {
		return "ExtensaoPasta [idExtensao=" + idExtensao + ", descExtensao="
				+ descExtensao + ", obExtensao=" + obExtensao + ", idPastaFK="
				+ idPastaFK + "]";
	}
	
	
}
