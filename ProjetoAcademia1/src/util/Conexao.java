package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

    public static Connection conectar() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/academia",
                "root",
                "swag"
            );
        } catch (Exception e) {
            throw new RuntimeException("Erro na conexão: " + e.getMessage());
        }
    }
}