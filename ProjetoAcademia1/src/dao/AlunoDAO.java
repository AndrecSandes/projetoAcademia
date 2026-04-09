package dao;

import model.Aluno;
import util.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {

    // CREATE
    public void cadastrar(Aluno aluno) {

        String sql = "INSERT INTO aluno (nome, cpf, email, telefone, data_nascimento) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, aluno.getDataNascimento());

            stmt.executeUpdate();

            System.out.println("Aluno cadastrado com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // READ
    public List<Aluno> listar() {

        List<Aluno> lista = new ArrayList<>();
        String sql = "SELECT * FROM aluno";

        try (Connection conn = Conexao.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Aluno a = new Aluno();
                a.setId(rs.getInt("id"));
                a.setNome(rs.getString("nome"));
                a.setCpf(rs.getString("cpf"));
                a.setEmail(rs.getString("email"));
                a.setTelefone(rs.getString("telefone"));
                a.setDataNascimento(rs.getString("data_nascimento"));

                lista.add(a);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    // UPDATE
    public void atualizar(Aluno aluno) {

        String sql = "UPDATE aluno SET nome=?, cpf=?, email=?, telefone=?, data_nascimento=? WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getCpf());
            stmt.setString(3, aluno.getEmail());
            stmt.setString(4, aluno.getTelefone());
            stmt.setString(5, aluno.getDataNascimento());
            stmt.setInt(6, aluno.getId());

            stmt.executeUpdate();

            System.out.println("Aluno atualizado!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public void excluir(int id) {

        String sql = "DELETE FROM aluno WHERE id=?";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Aluno excluído!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}