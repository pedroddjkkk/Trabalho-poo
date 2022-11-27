package br.edu.ifpr.trabalho.poo.modelo;

public final class Aluno extends Pessoa{
	private int anoIngresso;

	public Aluno() {
		super();
	}

	public Aluno(String nome, String cpf, String telefone, String endereco, String dataNascimento, int anoIngresso) {
		super(dataNascimento, dataNascimento, dataNascimento, dataNascimento, dataNascimento);
		this.anoIngresso = anoIngresso;
	}

	@Override
	public void imprimirDados() {
		
	}

	public int getAnoIngresso() {
		return anoIngresso;
	}

	public void setAnoIngresso(int anoIngresso) {
		this.anoIngresso = anoIngresso;
	}
		
}
