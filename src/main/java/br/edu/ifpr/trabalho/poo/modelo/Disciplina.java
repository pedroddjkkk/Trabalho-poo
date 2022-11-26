package br.edu.ifpr.trabalho.poo.modelo;

public class Disciplina {
	private String nome;
	private int cargaHoraria;
	
	public Disciplina() {
		super();
	}
	public Disciplina(String nome, int cargaHoraria) {
		super();
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
}
