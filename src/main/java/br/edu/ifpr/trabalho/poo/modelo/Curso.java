package br.edu.ifpr.trabalho.poo.modelo;

public class Curso {
	private String nome;
	private String duracao;
	private String modalidade;
	
	public Curso() {
		super();
	}
	public Curso(String nome, String duracao, String modalidade) {
		super();
		this.nome = nome;
		this.duracao = duracao;
		this.modalidade = modalidade;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDuracao() {
		return duracao;
	}
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	public String getModalidade() {
		return modalidade;
	}
	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}
}
