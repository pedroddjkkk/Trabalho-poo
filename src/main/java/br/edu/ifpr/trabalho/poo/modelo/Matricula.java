package br.edu.ifpr.trabalho.poo.modelo;

public class Matricula {
	private String ra;
	private String data;
	private boolean situacao;
	
	public Matricula() {
		super();
	}
	public Matricula(String ra, String data, boolean situacao) {
		super();
		this.ra = ra;
		this.data = data;
		this.situacao = situacao;
	}
	
	public String getRa() {
		return ra;
	}
	public void setRa(String ra) {
		this.ra = ra;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public boolean isSituacao() {
		return situacao;
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
}
