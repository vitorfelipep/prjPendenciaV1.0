package br.com.model;

public class Pasta {
	
	private int idPasta;
	private String descPasta;
	private String infPasta;
	private String statusPasta;
	
	public Pasta() {
		// TODO Auto-generated constructor stub
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
	public String getInfPasta() {
		return infPasta;
	}
	public void setInfPasta(String infPasta) {
		this.infPasta = infPasta;
	}
	public String getStatusPasta() {
		return statusPasta;
	}
	public void setStatusPasta(String statusPasta) {
		this.statusPasta = statusPasta;
	}
	@Override
	public String toString() {
		return "Pasta [idPasta=" + idPasta + ", descPasta=" + descPasta
				+ ", infPasta=" + infPasta + ", statusPasta=" + statusPasta
				+ "]";
	}
	
	
}
