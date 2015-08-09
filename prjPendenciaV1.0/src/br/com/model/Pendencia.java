package br.com.model;

public class Pendencia {
	
	private int idped;
	private String descPed;
	private String statusPed;
	private String nomependencia;
	private String datEmiPend;
	private int idPasta;
	private String descPasta;
	
	
	
	
	

	public Pendencia() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getIdped() {
		return idped;
	}
	public void setIdped(int idped) {
		this.idped = idped;
	}
	public String getDescPed() {
		return descPed;
	}
	public void setDescPed(String descPed) {
		this.descPed = descPed;
	}
	public String getStatusPed() {
		return statusPed;
	}
	public void setStatusPed(String statusPed) {
		this.statusPed = statusPed;
	}
	public String getNomependencia() {
		return nomependencia;
	}
	public void setNomependencia(String nomependencia) {
		this.nomependencia = nomependencia;
	}
	public String getDatEmiPend() {
		return datEmiPend;
	}
	public void setDatEmiPend(String datEmiPend) {
		this.datEmiPend = datEmiPend;
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


	@Override
	public String toString() {
		return "Pendencia [idped=" + idped + ", descPed=" + descPed
				+ ", statusPed=" + statusPed + ", nomependencia="
				+ nomependencia + ", datEmiPend=" + datEmiPend + ", idPasta="
				+ idPasta + ", descPasta=" + descPasta + "]";
	}
	
}
