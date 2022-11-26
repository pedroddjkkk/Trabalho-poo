package br.edu.ifpr.trabalho.poo.teste;

import br.edu.ifpr.trabalho.poo.implementacao.TrabalhoTeste;
import br.edu.ifpr.trabalho.poo.interfaces.IInserirDados;
import br.edu.ifpr.trabalho.poo.interfaces.ILeituraDeDados;
import br.edu.ifpr.trabalho.poo.modelo.Campus;

public class teste {
	public static void main(String[] args) {
		ILeituraDeDados leitura = new TrabalhoTeste();
		IInserirDados insercao = new TrabalhoTeste();

		Campus c = leitura.lerDadosCampus();
		insercao.salvarCampus(c);
	}
}
