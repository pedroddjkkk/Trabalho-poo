package br.edu.ifpr.trabalho.poo.modelo;

public class Matricula {
	private String ra;
	private String data;
	private boolean situacao;
	private Turma turma;
	private Aluno aluno;
	
	public Matricula() {
		super();
	}
	public Matricula(String ra, String data, boolean situacao, Turma turma, Aluno aluno) {
		super();
		this.ra = ra;
		this.data = data;
		this.situacao = situacao;
		this.turma = turma;
		this.aluno = aluno;
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
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}
