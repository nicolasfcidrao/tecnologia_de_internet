package persistence;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Venda;

public class VendaDao {
	public void inserir(Venda v) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("insert into venda values (null, ?, ?)");

			stmt.setTimestamp(1, new Timestamp(v.getDataVenda().getTime()));
			stmt.setString(2, v.getCpfCliente());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	public void excluir(int notaFiscal) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("delete from venda where nota_fiscal=?");

			stmt.setInt(1, notaFiscal);

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
