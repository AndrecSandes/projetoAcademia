package testep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
		
    public static Connection createConnection() throws SQLException {
        String url = "endereco";
        String user = "usuario";
        String password = "senha";

        return DriverManager.getConnection(url, user, password);
	
 }
}