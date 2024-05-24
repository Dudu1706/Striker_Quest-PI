package com.mycompany.teste_bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Professor {
    private String emailProfessor;
    private String senhaProfessor;

    public Professor(String emailProfessor, String senhaProfessor) {
        this.emailProfessor = emailProfessor;
        this.senhaProfessor = senhaProfessor;
    }

    public String getEmail_professor() {
        return emailProfessor;
    }

    public void setEmail_professor(String emailProfessor) {
        this.emailProfessor = emailProfessor;
    }

    public String getSenha_professor() {
        return senhaProfessor;
    }

    public void setSenha_professor(String senhaProfessor) {
        this.senhaProfessor = senhaProfessor;
    }

    public void cadastrarAluno(Jogador jogador) throws Exception {
        String sql = "INSERT INTO Jogador(nome_jogador, rg, id_turma) VALUES (?, ?, ?);";
        try (Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, jogador.getNome_jogador());
            ps.setString(2, jogador.getRg());
            ps.setInt(3, jogador.getId_turma());
            ps.execute();
        }
    }

    public void cadastrarTurma(Turma turma) throws Exception {
        String sql = "INSERT INTO Turma(nome_turma, id_professor)" +
                " VALUES (?, ?);";
        try (Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, turma.getNome_turma());
            ps.setInt(2, turma.getId_professor());
            ps.execute();
        }
    }

    public void cadastrarPergunta(Pergunta perguntas) throws Exception {
        String sql = "INSERT INTO Pergunta(pergunta, id_professor)" +
                " VALUES (?, ?);";
        try (Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, perguntas.getPergunta());
            ps.setInt(2, perguntas.getId_Professor());
            ps.execute();
        }
    }

    public void cadastrarResposta(Resposta resposta) throws Exception {
        String sql = "INSERT INTO Resposta(resposta_correta, resposta_um, resposta_dois, resposta_tres, id_pergunta)" +
                " VALUES (?, ?, ?, ?, ?);";
        try (Connection conexao = ConnectionFactory.obterConexao();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, resposta.getRespostaCorreta());
            ps.setString(2, resposta.getRespostaUm());
            ps.setString(3, resposta.getRespostaDois());
            ps.setString(4, resposta.getRespostaTres());
            ps.setInt(5, resposta.getId_Pergunta());
            ps.execute();
        }
    }
}