package br.edu.ifpr.trabalho.poo.implementacao;

import java.util.Scanner;

import br.edu.ifpr.trabalho.poo.interfaces.ILeituraDeDados;
import br.edu.ifpr.trabalho.poo.modelo.Aluno;
import br.edu.ifpr.trabalho.poo.modelo.Campus;
import br.edu.ifpr.trabalho.poo.modelo.Curso;
import br.edu.ifpr.trabalho.poo.modelo.Disciplina;
import br.edu.ifpr.trabalho.poo.modelo.Matricula;
import br.edu.ifpr.trabalho.poo.modelo.Professor;
import br.edu.ifpr.trabalho.poo.modelo.Turma;

public class Leitura implements ILeituraDeDados{

	public Aluno lerDadosAluno() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome do aluno:");
		String nome = teclado.nextLine();
		System.out.println("Informe o cpf do aluno:");
		String cpf = teclado.nextLine();
		System.out.println("Informe o telefone do aluno:");
		String telefone = teclado.nextLine();
		System.out.println("Informe o endere�o do aluno:");
		String endereco = teclado.nextLine();
		System.out.println("Informe a data de nascimento do aluno:");
		String dataNascimento = teclado.nextLine();
		System.out.println("Informe o ano de ingresso do aluno:");
		int anoIngresso = teclado.nextInt();
		Aluno aluno = new Aluno(nome, cpf, telefone, endereco, dataNascimento, anoIngresso);
		return aluno;
	}

	public Professor lerDadosProfessor() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome do professor:");
		String nome = teclado.nextLine();
		System.out.println("Informe o cpf do professor:");
		String cpf = teclado.nextLine();
		System.out.println("Informe o telefone do professor:");
		String telefone = teclado.nextLine();
		System.out.println("Informe o endere�o do professor:");
		String endereco = teclado.nextLine();
		System.out.println("Informe a data de nascimento do professor:");
		String dataNascimento = teclado.nextLine();
		System.out.println("Informe o siape do professor:");
		String siape = teclado.nextLine();
		Professor professor = new Professor(nome, cpf, telefone, endereco, dataNascimento, siape);
		return professor;
	}

	public Curso lerDadosCurso() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome do curso:");
		String nome = teclado.nextLine();
		System.out.println("Informe a duração do curso:");
		String duracao = teclado.nextLine();
		System.out.println("Informe a modalidade do curso:");
		String modalidade = teclado.nextLine();
		
		System.out.println("Informe o ID do campus:");
		int campusId = teclado.nextInt();
		
		Campus campus = new Campus();
		campus.setIdCampus(campusId);
		
		Curso curso = new Curso(nome, duracao, modalidade, campus);
		
		return curso;
	}

	public Turma lerDadosTurma() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome da turma:");
		String nome = teclado.nextLine();
		System.out.println("Informe o numero minimo da turma:");
		int nummin = teclado.nextInt();
		System.out.println("Informe o ano de ingresso da turma:");
		int ano = teclado.nextInt();
		
		System.out.println("Informe o ID do curso:");
		int cursoId = teclado.nextInt();
		
		Curso curso = new Curso();
		curso.setIdCurso(cursoId);
		
		return new Turma(nome, nummin, ano, curso);
	}

	public Turma lerDadosTurma(Curso curso) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome da turma:");
		String nome = teclado.nextLine();
		System.out.println("Informe o numero minimo da turma:");
		int nummin = teclado.nextInt();
		System.out.println("Informe o ano de ingresso da turma:");
		int ano = teclado.nextInt();
		return new Turma(nome, nummin, ano, curso);
	}

	public Disciplina lerDadosDisciplina(Professor professor, Turma turma) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome da disciplina:");
		String nome = teclado.nextLine();
		System.out.println("Informe a carga horaria da disciplina:");
		int cargaHoraria = teclado.nextInt();
		return new Disciplina(nome, cargaHoraria, turma, professor);
	}

	public Matricula lerDadosMatricula() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o ra da matricula:");
		String ra = teclado.nextLine();
		System.out.println("Informe a data da matricula:");
		String data = teclado.nextLine();
		System.out.println("Informe a situação da matricula:");
		boolean situacao = teclado.nextBoolean();
		Turma turma = lerDadosTurma();
		Aluno aluno = lerDadosAluno();
		return new Matricula(ra, data, situacao, turma, aluno);
	}

	public Matricula lerDadosMatricula(Aluno aluno, Turma turma) {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o ra da matricula:");
		String ra = teclado.nextLine();
		System.out.println("Informe a data da matricula:");
		String data = teclado.nextLine();
		System.out.println("Informe a situação da matricula:");
		boolean situacao = teclado.nextBoolean();
		return new Matricula(ra, data, situacao, turma, aluno);
	}

	public Campus lerDadosCampus() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome do campus:");
		String nome = teclado.nextLine();
		System.out.println("Informe o endere�o do campus:");
		String endereco = teclado.nextLine();
		System.out.println("Informe a cidade do campus:");
		String cidade = teclado.nextLine();
		Campus campus = new Campus(nome, endereco, cidade);
		return campus;
	}

}
