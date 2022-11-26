package br.edu.ifpr.trabalho.poo.modelo;

public final class Professor extends Pessoa{
	private String siape;
	
	public Professor() {
		super();
	}

	public Professor(String nome, String cpf, String telefone, String endereco, String dataNascimento, String siape) {
		super(nome, cpf, telefone, endereco, dataNascimento);
		this.siape = siape;
	}

	@Override
	public void imprimirDados() {
		
	}

}
