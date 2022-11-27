package br.edu.ifpr.trabalho.poo.implementacao;

import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.dao.AlunoDAO;
import br.edu.ifpr.trabalho.poo.dao.CampusDAO;
import br.edu.ifpr.trabalho.poo.dao.CursoDAO;
import br.edu.ifpr.trabalho.poo.dao.ProfessorDAO;
import br.edu.ifpr.trabalho.poo.dao.TurmaDAO;
import br.edu.ifpr.trabalho.poo.interfaces.IBuscaDeDados;
import br.edu.ifpr.trabalho.poo.modelo.Aluno;
import br.edu.ifpr.trabalho.poo.modelo.Campus;
import br.edu.ifpr.trabalho.poo.modelo.Curso;
import br.edu.ifpr.trabalho.poo.modelo.Disciplina;
import br.edu.ifpr.trabalho.poo.modelo.Matricula;
import br.edu.ifpr.trabalho.poo.modelo.Professor;
import br.edu.ifpr.trabalho.poo.modelo.Turma;

public class Busca implements IBuscaDeDados{

	public ArrayList<Matricula> buscarMatriculasAtivas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Matricula> buscarTodasMatriculas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Aluno> buscarAlunos() {
		ArrayList<Aluno> c = AlunoDAO.listar();
		return c;
	}

	public ArrayList<Turma> buscarTurmas() {
		ArrayList<Turma> c = TurmaDAO.listar();
		return c;
	}

	public ArrayList<Professor> buscarProfessores() {
		ArrayList<Professor> c = ProfessorDAO.listar();
		return c;
	}

	public ArrayList<Disciplina> buscarDisciplinas() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Curso> buscarCursos() {
		ArrayList<Curso> c = CursoDAO.listar();
		return c;
	}

	public ArrayList<Campus> buscarCampi() {
		ArrayList<Campus> c = CampusDAO.listar();
		return c;
	}

}
