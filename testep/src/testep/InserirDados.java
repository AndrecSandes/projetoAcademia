package testep;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class InserirDados {
    public static void main(String[] args) {
        try {
            Connection conn = Conexao.createConnection();

            String sql = "INSERT INTO funcionario (nome, sobrenome, idade, salario) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "Andre");
            ps.setString(2, "Sandes");
            ps.setInt(3, 18);
            ps.setDouble(4, 1500.0);

            ps.execute();

            System.out.println("Funcionário inserido com sucesso!");

            ps.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Erro: " + e);
        }
    }
}