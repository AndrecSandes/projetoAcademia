package testep;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
		
    public static Connection createConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/testep";
        String user = "root";
        String password = "swag";

        return DriverManager.getConnection(url, user, password);
	
 }
}