package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<Cliente> listar() {
		Connection con = null;
		PreparedStatement stmt = null;
		ArrayList<Cliente> clientes = new ArrayList<>();

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("select * from cliente");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String cpf = rs.getString("cpf");
				String nome = rs.getString("nome");

				Cliente c = new Cliente(cpf, nome);
				clientes.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clientes;
	}
}
