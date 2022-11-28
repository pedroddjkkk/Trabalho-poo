package br.edu.ifpr.trabalho.poo.modelo;

public final class Aluno extends Pessoa{
	private int anoIngresso;
	private int idAluno;

	public Aluno() {
		super();
	}

	public Aluno(String nome, String cpf, String telefone, String endereco, String dataNascimento, int anoIngresso) {
		super(dataNascimento, dataNascimento, dataNascimento, dataNascimento, dataNascimento);
		this.anoIngresso = anoIngresso;
	}

	@Override
	public void imprimirDados() {
		System.out.println("Nome: " + this.nome);
		System.out.println("CPF: " + this.cpf);
		System.out.println("Telefone: " + this.telefone);
		System.out.println("Endereço: " + this.endereco);
		System.out.println("Data de Nascimento: " + this.dataNascimento);
		System.out.println("Ano de Ingresso: " + this.anoIngresso);
	}

	public int getAnoIngresso() {
		return anoIngresso;
	}
	public void setAnoIngresso(int anoIngresso) {
		this.anoIngresso = anoIngresso;
	}
	public int getIdAluno() {
		return idAluno;
	}
	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}
}
