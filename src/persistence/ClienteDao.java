package persistence;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Cliente;


public class ClienteDao {
	
	public void inserir(Cliente c) {
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("insert into cliente values (?, ?)");
			
			stmt.setString(1, c.getCpf());
			stmt.setString(2, c.getNome());
			
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
