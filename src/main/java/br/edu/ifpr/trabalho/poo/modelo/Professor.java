package br.edu.ifpr.trabalho.poo.modelo;

public final class Professor extends Pessoa{
	private String siape;
	private int idProfessor;
	
	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}
	public int getIdProfessor() {
		return idProfessor;
	}
	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public Professor() {
		super();
	}

	public Professor(String nome, String cpf, String telefone, String endereco, String dataNascimento, String siape) {
		super(nome, cpf, telefone, endereco, dataNascimento);
		this.siape = siape;
	}

	@Override
	public void imprimirDados() {
		System.out.println("Nome: " + this.nome);
		System.out.println("CPF: " + this.cpf);
		System.out.println("Telefone: " + this.telefone);
		System.out.println("Endereço: " + this.endereco);
		System.out.println("Data de Nascimento: " + this.dataNascimento);
		System.out.println("Siape: " + this.siape);
	}

}
