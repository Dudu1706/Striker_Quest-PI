package com.mycompany.teste_bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Classe DAO (Data Acess Object)
public class DAO {
    // Verificação de Existência de Cadastro Jogador Professor
    public boolean existeCadastroJogador(Jogador jogador)
            throws Exception {
        String sql = "SELECT * FROM Jogador WHERE nome_jogador = ? AND id_turma = ?";

        try (Connection conn = ConnectionFactory.obterConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, jogador.getNome_jogador());
            ps.setInt(2, jogador.getId_turma());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    // Verificação de Existência do Jogador Para autenticação
    public boolean existeJogador(Jogador jogador, Turma turma)
            throws Exception {
        String sql = "SELECT nome_jogador, nome_turma FROM Jogador j JOIN Turma t ON j.id_turma = t.id_turma where nome_jogador = ? AND nome_turma = ?";

        try (Connection conn = ConnectionFactory.obterConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, jogador.getNome_jogador());
            ps.setString(2, turma.getNome_turma());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public boolean professorExiste(Professor professor) throws Exception {
        String sql = "SELECT * FROM Professor WHERE email = ? AND senha = ?";

        try (Connection conn = ConnectionFactory.obterConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, professor.getEmail_professor());
            ps.setString(2, professor.getSenha_professor());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public boolean turmaExiste(Turma turma) throws Exception {
        String sql = "SELECT nome_turma, id_turma FROM Turma WHERE nome_turma = ? AND id_turma = ?";
        try (Connection conn = ConnectionFactory.obterConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, turma.getNome_turma());
            ps.setInt(2, turma.getId_professor());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    public boolean exibirPontuacao(boolean varExibirPontuacao)
            throws Exception {
        String sql = "SELECT nome_jogador, maior_pontuacao, id_turma FROM Jogador WHERE nome_jogador = ? AND id_turma = ?";
        try (Connection conn = ConnectionFactory.obterConexao();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
}
