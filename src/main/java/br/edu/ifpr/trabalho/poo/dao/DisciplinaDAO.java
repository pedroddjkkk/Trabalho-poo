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
		String SQL = "INSERT INTO tb_disciplina (nome, fk_turma, fk_professor) VALUES (?, ?, ?)";

		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setString(1, Disciplina.getNome());
			preparacaoDaInstrucao.setInt(2, Disciplina.getTurma().getIdTurma());
            preparacaoDaInstrucao.setInt(3, Disciplina.getProfessor().getIdProfessor());
			preparacaoDaInstrucao.executeUpdate();
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
