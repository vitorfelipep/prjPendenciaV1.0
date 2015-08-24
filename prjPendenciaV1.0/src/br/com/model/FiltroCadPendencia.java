package br.com.model;

import java.util.Date;

public class FiltroCadPendencia {
	
	private String nomPendencia;
	private String descPendencia;
	private Date dataPrevPendencia;
	private int pasta;
	private int opcapExtensao;
	private String nomeExtensao;
	private String extensao;
	
	
	public FiltroCadPendencia() {
		
		
	}
	
	public String getNomPendencia() {
		return nomPendencia;
	}
	public void setNomPendencia(String nomPendencia) {
		this.nomPendencia = nomPendencia;
	}
	public String getDescPendencia() {
		return descPendencia;
	}
	public void setDescPendencia(String descPendencia) {
		this.descPendencia = descPendencia;
	}
	
	public int getPasta() {
		return pasta;
	}

	public void setPasta(int pasta) {
		this.pasta = pasta;
	}

	public int getOpcapExtensao() {
		return opcapExtensao;
	}
	public void setOpcapExtensao(int opcapExtensao) {
		this.opcapExtensao = opcapExtensao;
	}
	public String getExtensao() {
		return extensao;
	}
	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}
	
	public Date getDataPrevPendencia() {
		return dataPrevPendencia;
	}

	public void setDataPrevPendencia(Date dataPrevPendencia) {
		this.dataPrevPendencia = dataPrevPendencia;
	}

	public String getNomeExtensao() {
		return nomeExtensao;
	}

	public void setNomeExtensao(String nomeExtensao) {
		this.nomeExtensao = nomeExtensao;
	}

	@Override
	public String toString() {
		return "FiltroCadPendencia [nomPendencia=" + nomPendencia
				+ ", descPendencia=" + descPendencia + ", dataPrevPendencia="
				+ dataPrevPendencia + ", pasta=" + pasta + ", opcapExtensao="
				+ opcapExtensao + ", nomeExtensao=" + nomeExtensao
				+ ", extensao=" + extensao + "]";
	}

}
