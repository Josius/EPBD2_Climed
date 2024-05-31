package conexao;

import java.sql.*;

public class ConexaoBD {
	public Connection getConnection(){

		try {
			
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/climed",
            "postgres", "postgres");
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
	}
}
