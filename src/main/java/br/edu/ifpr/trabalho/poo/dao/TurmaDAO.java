package br.edu.ifpr.trabalho.poo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.conexao.Conexao;
import br.edu.ifpr.trabalho.poo.modelo.Curso;
import br.edu.ifpr.trabalho.poo.modelo.Turma;

public class TurmaDAO {
	public static ArrayList<Turma> listar(){
		ArrayList<Turma> listaDeTurma = new ArrayList<Turma>();
		String SQL = "SELECT * FROM tb_turma";
		
		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();
			
			while(resultado.next()) {
				Turma turma = transformarResultSetEmObjeto(resultado);
				listaDeTurma.add(turma);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
		return listaDeTurma;
	}

	public static Turma listar(int fk){
		String SQL = "SELECT DISTINCT * FROM matricula.tb_turma WHERE id_turma = ?";
		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setInt(1, fk);
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();
			resultado.next();
			Turma c = transformarResultSetEmObjeto(resultado);
			return c;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void salvar(Turma turma) {
		String SQL = "INSERT INTO tb_turma (nome, numero_minimo, ano_ingresso, fk_curso) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setString(1, turma.getNome());
			preparacaoDaInstrucao.setInt(2, turma.getNumeroMinimo());
			preparacaoDaInstrucao.setInt(3, turma.getAnoIngresso());
			preparacaoDaInstrucao.setInt(4, turma.getCurso().getIdCurso());

			preparacaoDaInstrucao.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Turma transformarResultSetEmObjeto(ResultSet resultSet) throws SQLException {
		Turma turma = new Turma();
		Curso curso = new Curso();
		try {
			turma.setNome(resultSet.getString("nome"));
			turma.setNumeroMinimo(resultSet.getInt("numero_minimo"));
			turma.setAnoIngresso(resultSet.getInt("ano_ingresso"));
			turma.setIdTurma(resultSet.getInt("id_turma"));
			curso = CursoDAO.listar(resultSet.getInt("fk_curso"));
			turma.setCurso(curso);
			return turma;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar!");
		}
	}
}
