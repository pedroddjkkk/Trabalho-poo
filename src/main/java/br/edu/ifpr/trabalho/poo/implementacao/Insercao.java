package br.edu.ifpr.trabalho.poo.implementacao;

import br.edu.ifpr.trabalho.poo.dao.AlunoDAO;
import br.edu.ifpr.trabalho.poo.dao.CampusDAO;
import br.edu.ifpr.trabalho.poo.dao.CursoDAO;
import br.edu.ifpr.trabalho.poo.dao.ProfessorDAO;
import br.edu.ifpr.trabalho.poo.dao.TurmaDAO;
import br.edu.ifpr.trabalho.poo.interfaces.IInserirDados;
import br.edu.ifpr.trabalho.poo.modelo.Aluno;
import br.edu.ifpr.trabalho.poo.modelo.Campus;
import br.edu.ifpr.trabalho.poo.modelo.Curso;
import br.edu.ifpr.trabalho.poo.modelo.Disciplina;
import br.edu.ifpr.trabalho.poo.modelo.Matricula;
import br.edu.ifpr.trabalho.poo.modelo.Professor;
import br.edu.ifpr.trabalho.poo.modelo.Turma;

public class Insercao implements IInserirDados{

	public void salvarAluno(Aluno aluno) {
		AlunoDAO.salvar(aluno);
	}

	public void salvarProfessor(Professor professor) {
		ProfessorDAO.salvar(professor);
		
	}

	public void salvarCurso(Curso curso) {
		CursoDAO.salvar(curso);
	}

	public void salvarTurma(Turma turma) {
		TurmaDAO.salvar(turma);
	}

	public void salvarDisciplina(Disciplina disciplina) {
		// TODO Auto-generated method stub
		
	}

	public void salvarMatricula(Matricula matricula) {
		// TODO Auto-generated method stub
		
	}

	public void salvarCampus(Campus campus) {
		CampusDAO.salvar(campus);
	}

}
