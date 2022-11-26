package br.edu.ifpr.trabalho.poo.modelo;

public class Turma {
	private String nome;
	private int numeroMinimo;
	private int anoIngresso;
	
	public Turma() {
		super();
	}
	public Turma(String nome, int numeroMinimo, int anoIngresso) {
		super();
		this.nome = nome;
		this.numeroMinimo = numeroMinimo;
		this.anoIngresso = anoIngresso;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getNumeroMinimo() {
		return numeroMinimo;
	}
	public void setNumeroMinimo(int numeroMinimo) {
		this.numeroMinimo = numeroMinimo;
	}
	public int getAnoIngresso() {
		return anoIngresso;
	}
	public void setAnoIngresso(int anoIngresso) {
		this.anoIngresso = anoIngresso;
	}
}
