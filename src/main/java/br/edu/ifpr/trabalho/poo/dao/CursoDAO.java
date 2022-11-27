package br.edu.ifpr.trabalho.poo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.conexao.Conexao;
import br.edu.ifpr.trabalho.poo.modelo.Campus;
import br.edu.ifpr.trabalho.poo.modelo.Curso;

public class CursoDAO {
	public static ArrayList<Curso> listar(){
		ArrayList<Curso> listaDeCurso = new ArrayList<Curso>();
		String SQL = "SELECT * FROM tb_curso";
		
		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();
			
			while(resultado.next()) {
				Curso curso = transformarResultSetEmObjeto(resultado);
				listaDeCurso.add(curso);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
		return listaDeCurso;
	}
	
	public static void salvar(Curso curso) {
		String SQL = "INSERT INTO tb_curso (nome, duracao, modalidade, fk_campus) VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setString(1, curso.getNome());
			preparacaoDaInstrucao.setString(2, curso.getDuracao());
			preparacaoDaInstrucao.setString(3, curso.getModalidade());
			preparacaoDaInstrucao.setInt(4, curso.getCampus().getIdCampus());

			preparacaoDaInstrucao.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Curso listar(int fk){
		String SQL = "SELECT DISTINCT * FROM matricula.tb_curso WHERE id_curso = ?";
		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setInt(1, fk);
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();
			resultado.next();
			Curso c = transformarResultSetEmObjeto(resultado);
			return c;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static Curso transformarResultSetEmObjeto(ResultSet resultSet) throws SQLException {
		Curso curso = new Curso();
		Campus campus = new Campus();
		try {
			curso.setNome(resultSet.getString("nome"));
			curso.setDuracao(resultSet.getString("duracao"));
			curso.setModalidade(resultSet.getString("modalidade"));
			curso.setIdCurso(resultSet.getInt("id_curso"));
			campus = CampusDAO.listar(resultSet.getInt("fk_campus"));
			curso.setCampus(campus);
			return curso;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar!");
		}
	}
}
