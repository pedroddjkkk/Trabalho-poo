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
		String SQL = "SELECT * FROM tb_curso INNER JOIN (SELECT nome AS campus_nome, endereco AS campus_endereco, cidade AS campus_cidade, id_campus FROM tb_campus ) tb_campus ON tb_curso.fk_campus = tb_campus.id_campus";
		
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

	public static Curso transformarResultSetEmObjeto(ResultSet resultSet) throws SQLException {
		Curso curso = new Curso();
		Campus campus = new Campus();
		try {
			curso.setNome(resultSet.getString("nome"));
			curso.setDuracao(resultSet.getString("duracao"));
			curso.setModalidade(resultSet.getString("modalidade"));
			campus.setIdCampus(resultSet.getInt("fk_campus"));
			campus.setNome(resultSet.getString("campus_nome"));
			campus.setEndereco(resultSet.getString("campus_endereco"));
			campus.setCidade(resultSet.getString("campus_cidade"));
			curso.setCampus(campus);
			return curso;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar!");
		}
	}
}
