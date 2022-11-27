package br.edu.ifpr.trabalho.poo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.conexao.Conexao;
import br.edu.ifpr.trabalho.poo.modelo.Aluno;

public class AlunoDAO {
	public static ArrayList<Aluno> listar(){
		ArrayList<Aluno> listaDeAluno = new ArrayList<Aluno>();
		String SQL = "SELECT * FROM matricula.tb_aluno";
		
		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();
			
			while(resultado.next()) {
				Aluno Aluno = transformarResultSetEmObjeto(resultado);
				listaDeAluno.add(Aluno);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
		return listaDeAluno;
	}
	
	public static void salvar(Aluno Aluno) {
		String SQL = "INSERT INTO tb_aluno (nome, cpf, telefone, endereco, data_nascimento, ano_ingresso) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setString(1, Aluno.getNome());
			preparacaoDaInstrucao.setString(2, Aluno.getCpf());
			preparacaoDaInstrucao.setString(3, Aluno.getTelefone());
			preparacaoDaInstrucao.setString(4, Aluno.getEndereco());
			preparacaoDaInstrucao.setString(5, Aluno.getDataNascimento());
			preparacaoDaInstrucao.setInt(6, Aluno.getAnoIngresso());

			preparacaoDaInstrucao.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Aluno> buscar() {
		ArrayList<Aluno> listaDeAluno = new ArrayList<Aluno>();
		String SQL = "SELECT * FROM tb_aluno";
		try {
			PreparedStatement SQLPreparada = Conexao.getConexao().prepareStatement(SQL);
			ResultSet resultado = SQLPreparada.executeQuery();
			while (resultado.next()) {
				Aluno Aluno = new Aluno();
				Aluno.setNome(resultado.getString("nome"));
				Aluno.setCpf(resultado.getString("cpf"));
				Aluno.setTelefone(resultado.getString("telefone"));
				Aluno.setEndereco(resultado.getString("endereco"));
				Aluno.setDataNascimento(resultado.getString("data_nascimento"));
				Aluno.setAnoIngresso(resultado.getInt("ano_ingresso"));
				listaDeAluno.add(Aluno);
			}
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		return listaDeAluno;
	}
	
	public static Aluno transformarResultSetEmObjeto(ResultSet resultado) throws SQLException {
		Aluno Aluno = new Aluno();
		try {
			Aluno.setNome(resultado.getString("nome"));
			Aluno.setCpf(resultado.getString("cpf"));
			Aluno.setTelefone(resultado.getString("telefone"));
			Aluno.setEndereco(resultado.getString("endereco"));
			Aluno.setDataNascimento(resultado.getString("data_nascimento"));
			Aluno.setAnoIngresso(resultado.getInt("ano_ingresso"));
			return Aluno;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar!");
		}
	}
}
