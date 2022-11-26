package br.edu.ifpr.trabalho.poo.implementacao;

import java.util.ArrayList;
import java.util.Scanner;

import br.edu.ifpr.trabalho.poo.dao.CampusDAO;
import br.edu.ifpr.trabalho.poo.interfaces.IBuscaDeDados;
import br.edu.ifpr.trabalho.poo.interfaces.IInserirDados;
import br.edu.ifpr.trabalho.poo.interfaces.ILeituraDeDados;
import br.edu.ifpr.trabalho.poo.modelo.Aluno;
import br.edu.ifpr.trabalho.poo.modelo.Campus;
import br.edu.ifpr.trabalho.poo.modelo.Curso;
import br.edu.ifpr.trabalho.poo.modelo.Disciplina;
import br.edu.ifpr.trabalho.poo.modelo.Matricula;
import br.edu.ifpr.trabalho.poo.modelo.Professor;
import br.edu.ifpr.trabalho.poo.modelo.Turma;

public class TrabalhoTeste implements IBuscaDeDados, ILeituraDeDados, IInserirDados{

	public ArrayList<Matricula> buscarMatriculasAtivas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Matricula> buscarTodasMatriculas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Aluno> buscarAlunos() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Turma> buscarTurmas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Professor> buscarProfessores() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Disciplina> buscarDisciplinas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Curso> buscarCursos() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Campus> buscarCampi() {
		CampusDAO c = new CampusDAO();
		return c.buscar();
	}

	public Aluno lerDadosAluno() {
		// TODO Auto-generated method stub
		return null;
	}

	public Professor lerDadosProfessor() {
		// TODO Auto-generated method stub
		return null;
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
		
		//ainda tem que adcionar o ID campus e etc...
		
		Campus campus = new Campus();
		
		Curso curso = new Curso(nome, modalidade, duracao);
		return curso;
	}

	public Turma lerDadosTurma() {
		// TODO Auto-generated method stub
		return null;
	}

	public Turma lerDadosTurma(Curso curso) {
		// TODO Auto-generated method stub
		return null;
	}

	public Disciplina lerDadosDisciplina(Professor professor, Turma turma) {
		// TODO Auto-generated method stub
		return null;
	}

	public Matricula lerDadosMatricula() {
		// TODO Auto-generated method stub
		return null;
	}

	public Matricula lerDadosMatricula(Aluno aluno, Turma turma) {
		// TODO Auto-generated method stub
		return null;
	}

	public Campus lerDadosCampus() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o nome do campus:");
		String nome = teclado.nextLine();
		System.out.println("Informe o endereço do campus:");
		String endereco = teclado.nextLine();
		System.out.println("Informe a cidade do campus:");
		String cidade = teclado.nextLine();
		Campus campus = new Campus(nome, endereco, cidade);
		return campus;

	}

	public void salvarAluno(Aluno aluno) {
		// TODO Auto-generated method stub
		
	}

	public void salvarProfessor(Professor professor) {
		// TODO Auto-generated method stub
		
	}

	public void salvarCurso(Curso curso) {
		// TODO Auto-generated method stub
		
	}

	public void salvarTurma(Turma turma) {
		// TODO Auto-generated method stub
		
	}

	public void salvarDisciplina(Disciplina disciplina) {
		// TODO Auto-generated method stub
		
	}

	public void salvarMatricula(Matricula matricula) {
		// TODO Auto-generated method stub
		
	}

	public void salvarCampus(Campus campus) {
		CampusDAO c = new CampusDAO();
		c.salvar(campus);
	}
	
}
