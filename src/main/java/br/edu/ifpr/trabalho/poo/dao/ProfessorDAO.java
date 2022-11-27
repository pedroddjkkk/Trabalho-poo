package br.edu.ifpr.trabalho.poo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.conexao.Conexao;
import br.edu.ifpr.trabalho.poo.modelo.Professor;

public class ProfessorDAO {
	public static ArrayList<Professor> listar(){
		ArrayList<Professor> listaDeProfessor = new ArrayList<Professor>();
		String SQL = "SELECT * FROM matricula.tb_professor";
		
		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();
			
			while(resultado.next()) {
				Professor Professor = transformarResultSetEmObjeto(resultado);
				listaDeProfessor.add(Professor);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
		return listaDeProfessor;
	}
	
	public static void salvar(Professor Professor) {
		String SQL = "INSERT INTO tb_professor (nome, cpf, telefone, endereco, data_nascimento, siape) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			preparacaoDaInstrucao.setString(1, Professor.getNome());
			preparacaoDaInstrucao.setString(2, Professor.getCpf());
			preparacaoDaInstrucao.setString(3, Professor.getTelefone());
			preparacaoDaInstrucao.setString(4, Professor.getEndereco());
			preparacaoDaInstrucao.setString(5, Professor.getDataNascimento());
			preparacaoDaInstrucao.setString(6, Professor.getSiape());

			preparacaoDaInstrucao.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Professor> buscar() {
		ArrayList<Professor> listaDeProfessor = new ArrayList<Professor>();
		String SQL = "SELECT * FROM tb_professor";
		try {
			PreparedStatement SQLPreparada = Conexao.getConexao().prepareStatement(SQL);
			ResultSet resultado = SQLPreparada.executeQuery();
			while (resultado.next()) {
				Professor Professor = new Professor();
				Professor.setNome(resultado.getString("nome"));
				Professor.setCpf(resultado.getString("cpf"));
				Professor.setTelefone(resultado.getString("telefone"));
				Professor.setEndereco(resultado.getString("endereco"));
				Professor.setDataNascimento(resultado.getString("data_nascimento"));
				Professor.setSiape(resultado.getString("siape"));
				listaDeProfessor.add(Professor);
			}
		} catch (Exception excecao) {
			excecao.printStackTrace();
		}
		return listaDeProfessor;
	}
	
	public static Professor transformarResultSetEmObjeto(ResultSet resultado) throws SQLException {
		Professor Professor = new Professor();
		try {
			Professor.setNome(resultado.getString("nome"));
			Professor.setCpf(resultado.getString("cpf"));
			Professor.setTelefone(resultado.getString("telefone"));
			Professor.setEndereco(resultado.getString("endereco"));
			Professor.setDataNascimento(resultado.getString("data_nascimento"));
			Professor.setSiape(resultado.getString("siape"));
			return Professor;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar!");
		}
	}
}
