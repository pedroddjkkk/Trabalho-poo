package br.edu.ifpr.trabalho.poo.teste;

import java.util.ArrayList;
import java.util.Iterator;

import br.edu.ifpr.trabalho.poo.dao.CampusDAO;
import br.edu.ifpr.trabalho.poo.implementacao.Busca;
import br.edu.ifpr.trabalho.poo.implementacao.Insercao;
import br.edu.ifpr.trabalho.poo.implementacao.Leitura;
import br.edu.ifpr.trabalho.poo.interfaces.IBuscaDeDados;
import br.edu.ifpr.trabalho.poo.interfaces.IInserirDados;
import br.edu.ifpr.trabalho.poo.interfaces.ILeituraDeDados;
import br.edu.ifpr.trabalho.poo.modelo.Campus;
import br.edu.ifpr.trabalho.poo.modelo.Curso;
import br.edu.ifpr.trabalho.poo.modelo.Turma;

public class teste {
	public static void main(String[] args) {
		ILeituraDeDados leitura = new Leitura();
		IInserirDados insercao = new Insercao();
		IBuscaDeDados busca = new Busca();

		ArrayList<Turma> turmas = busca.buscarTurmas();
		for(Iterator iterator = turmas.iterator(); iterator.hasNext();) {
			Turma turma = (Turma) iterator.next();
			System.out.println(turma.getCurso().getCampus().getCidade());
		}
	}
}
