package br.edu.ifpr.trabalho.poo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifpr.trabalho.poo.conexao.Conexao;
import br.edu.ifpr.trabalho.poo.modelo.Matricula;

public class MatriculaDAO {
    public static ArrayList<Matricula> listar(){
		ArrayList<Matricula> listaDeMatricula = new ArrayList<Matricula>();
		String SQL = "SELECT * FROM tb_matricula";
		
		try {
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL);
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();
			
			while(resultado.next()) {
				Matricula matricula = transformarResultSetEmObjeto(resultado);
				listaDeMatricula.add(matricula);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
		return listaDeMatricula;
	}
	
	public static void salvar(Matricula matricula) {
		String SQLMatricula = "INSERT INTO tb_matricula (ra, data, situacao, fk_turma, fk_aluno) VALUES (?, ?, ?, ?, ?)";
		String SQLTurma = "INSERT INTO tb_turma (nome, numero_minimo, ano_ingresso, fk_curso) VALUES (?, ?, ?, ?)";
		String SQLAluno = "INSERT INTO tb_aluno (nome, cpf, telefone, endereco, data_nascimento, ano_ingresso) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement preparacaoAluno = Conexao.getConexao().prepareStatement(SQLAluno);
			PreparedStatement preparacaoTurma = Conexao.getConexao().prepareStatement(SQLTurma);
			preparacaoTurma.setString(1, matricula.getTurma().getNome());
			preparacaoTurma.setInt(2, matricula.getTurma().getNumeroMinimo());
			preparacaoTurma.setInt(3, matricula.getTurma().getAnoIngresso());
            preparacaoTurma.setInt(4, matricula.getTurma().getCurso().getIdCurso());
			preparacaoTurma.execute();
			preparacaoAluno.setString(1, matricula.getAluno().getNome());
            preparacaoAluno.setString(2, matricula.getAluno().getCpf());
            preparacaoAluno.setString(3, matricula.getAluno().getTelefone());
            preparacaoAluno.setString(4, matricula.getAluno().getEndereco());
            preparacaoAluno.setString(5, matricula.getAluno().getDataNascimento());
            preparacaoAluno.setInt(6, matricula.getAluno().getAnoIngresso());
			preparacaoAluno.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String SQL2 = "SELECT MAX(id_turma) FROM tb_turma";
		String SQL3 = "SELECT MAX(id_pessoa) FROM tb_aluno";
		try {
			PreparedStatement preparacaoMatricula = Conexao.getConexao().prepareStatement(SQLMatricula);
			PreparedStatement preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL2);
			ResultSet resultado = preparacaoDaInstrucao.executeQuery();
			resultado.next();
            matricula.getTurma().setIdTurma(resultado.getInt(1));
			preparacaoDaInstrucao = Conexao.getConexao().prepareStatement(SQL3);
			resultado = preparacaoDaInstrucao.executeQuery();
			resultado.next();
			matricula.getAluno().setIdAluno(resultado.getInt(1));
			preparacaoMatricula.setString(1, matricula.getRa());
			preparacaoMatricula.setString(2, matricula.getData());
            if(matricula.isSituacao()) {
                preparacaoMatricula.setInt(3, 1);
            } else {
                preparacaoMatricula.setInt(3, 0);
            }
            preparacaoMatricula.setInt(4, matricula.getTurma().getIdTurma());
            preparacaoMatricula.setInt(5, matricula.getAluno().getIdAluno());
			preparacaoMatricula.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	public static Matricula transformarResultSetEmObjeto(ResultSet resultSet) throws SQLException {
		Matricula matricula = new Matricula();
		try {
            matricula.setRa(resultSet.getString("ra"));
            matricula.setData(resultSet.getString("data"));
            matricula.setSituacao(resultSet.getBoolean("situacao"));
            matricula.setAluno(AlunoDAO.listar(resultSet.getInt("fk_aluno")));
            matricula.setTurma(TurmaDAO.listar(resultSet.getInt("fk_turma")));
			return matricula;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new SQLException("Erro ao transformar!");
		}
	}
}
