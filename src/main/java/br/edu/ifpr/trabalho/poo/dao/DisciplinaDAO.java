package br.edu.ifpr.trabalho.poo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.conexao.Conexao;
import br.edu.ifpr.trabalho.poo.modelo.Disciplina;
import br.edu.ifpr.trabalho.poo.modelo.Professor;
import br.edu.ifpr.trabalho.poo.modelo.Turma;

public class DisciplinaDAO {
    public static ArrayList<Disciplina> listar(){
		ArrayList<Disciplina> listaDeDisciplina = new ArrayList<Disciplina>();
		String SQL = "SELECT * FROM tb_disciplina";
		
		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();
			
			while(resultado.next()) {
				Disciplina Disciplina = transformarResultSetEmObjeto(resultado);
				listaDeDisciplina.add(Disciplina);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
		return listaDeDisciplina;
	}
	
	public static void salvar(Disciplina Disciplina) {
		String SQLDisciplina = "INSERT INTO tb_disciplina (nome, fk_turma, fk_professor) VALUES (?, ?, ?)";
		String SQLProfessor = "INSERT INTO tb_professor (nome, cpf, telefone, endereco, data_nascimento, siape) VALUES (?, ?, ?, ?, ?, ?)";
		String SQlTurma = "INSERT INTO tb_turma (nome, numero_minimo, ano_ingresso, fk_curso) VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement preparacaoProfessor = Conexao.getConexao().prepareStatement(SQLProfessor);
			PreparedStatement preparacaoTurma = Conexao.getConexao().prepareStatement(SQlTurma);
			preparacaoProfessor.setString(1, Disciplina.getProfessor().getNome());
			preparacaoProfessor.setString(2, Disciplina.getProfessor().getCpf());
			preparacaoProfessor.setString(3, Disciplina.getProfessor().getTelefone());
			preparacaoProfessor.setString(4, Disciplina.getProfessor().getEndereco());
			preparacaoProfessor.setString(5, Disciplina.getProfessor().getDataNascimento());
			preparacaoProfessor.setString(6, Disciplina.getProfessor().getSiape());
			preparacaoProfessor.executeUpdate();
			preparacaoTurma.setString(1, Disciplina.getTurma().getNome());
			preparacaoTurma.setInt(2, Disciplina.getTurma().getNumeroMinimo());
			preparacaoTurma.setInt(3, Disciplina.getTurma().getAnoIngresso());
			preparacaoTurma.setInt(4, Disciplina.getTurma().getCurso().getIdCurso());
			preparacaoTurma.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String SQL2 = "SELECT MAX(id_turma) FROM tb_turma";
		String SQL3 = "SELECT MAX(id_pessoa) FROM tb_professor";
		try {
			PreparedStatement preparacaoDisciplina = Conexao.getConexao().prepareStatement(SQLDisciplina);
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL2);
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();
			resultado.next();
			Disciplina.getTurma().setIdTurma(resultado.getInt(1));
			preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL3);
			resultado = preparacaoDaInstrucao.executeQuery();
			resultado.next();
			Disciplina.getProfessor().setIdProfessor(resultado.getInt(1));
			preparacaoDisciplina.setString(1, Disciplina.getNome());
			preparacaoDisciplina.setInt(2, Disciplina.getTurma().getIdTurma());
			preparacaoDisciplina.setInt(3, Disciplina.getProfessor().getIdProfessor());
			preparacaoDisciplina.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Disciplina transformarResultSetEmObjeto(ResultSet resultSet) throws SQLException {
		Disciplina Disciplina = new Disciplina();
		Turma turma = new Turma();
        Professor professor = new Professor();
		try {
			Disciplina.setNome(resultSet.getString("nome"));
			turma = TurmaDAO.listar(resultSet.getInt("fk_turma"));
            professor = ProfessorDAO.listar(resultSet.getInt("fk_professor"));
			Disciplina.setTurma(turma);
            Disciplina.setProfessor(professor);
			return Disciplina;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar!");
		}
	}
}
