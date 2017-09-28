package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Produto;

public class ProdutoDao {

	public void inserir(Produto p) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("insert into produto values(null, ?, ?, ?, ?, ?, ?)");

			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getTipo());
			stmt.setDouble(3, p.getValor());
			stmt.setString(4, p.getImagem());
			stmt.setString(5, p.getVendedor());
			stmt.setTimestamp(6, new Timestamp(p.getDataCadastro().getTime()));

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				con.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public void remover(int codigo) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("delete from produto where codigo=?");

			stmt.setInt(1, codigo);

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

	public void alterar(Produto p) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement(
					"update produto set nome=?, tipo=?, valor=?, imagem=?, vendedor=?, data_cadastro=?");

			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getTipo());
			stmt.setDouble(3, p.getValor());
			stmt.setString(4, p.getImagem());
			stmt.setString(5, p.getVendedor());
			stmt.setTimestamp(6, new Timestamp(p.getDataCadastro().getTime()));

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

	public List<Produto> listar() {
		Connection con = null;
		PreparedStatement stmt = null;
		ArrayList<Produto> produtos = new ArrayList<>();

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("select * from produto");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				int codigo = rs.getInt("codigo");
				String nome = rs.getString("nome");
				String tipo = rs.getString("tipo");
				double valor = rs.getDouble("valor");
				String imagem = rs.getString("imagem");
				String vendedor = rs.getString("vendedor");
				Date dataCadastro = rs.getDate("data_cadastro");

				Produto p = new Produto(codigo, nome, tipo, valor, imagem, vendedor, dataCadastro);
				produtos.add(p);
			}

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
		return produtos;

	}

	public List<Produto> buscar(String nome) {

		Connection con = null;
		PreparedStatement stmt = null;
		ArrayList<Produto> produtos = new ArrayList<>();

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("select * from produto where nome like ?");

			stmt.setString(1, "%" + nome + "%");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {

				int codigo = rs.getInt("codigo");
				String nomeP = rs.getString("nome");
				String tipo = rs.getString("tipo");
				double valor = rs.getDouble("valor");
				String imagem = rs.getString("imagem");
				String vendedor = rs.getString("vendedor");
				Date dataCadastro = rs.getDate("data_cadastro");

				Produto p = new Produto(codigo, nomeP, tipo, valor, imagem, vendedor, dataCadastro);
				produtos.add(p);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return produtos;
	}

	public Produto buscarPorCodigo(int codigo) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("select * from produto where codigo = ?");

			stmt.setInt(1, codigo);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				codigo = rs.getInt("codigo");
				String nomeP = rs.getString("nome");
				String tipo = rs.getString("tipo");
				double valor = rs.getDouble("valor");
				String imagem = rs.getString("imagem");
				String vendedor = rs.getString("vendedor");
				Date dataCadastro = rs.getDate("data_cadastro");

				Produto p = new Produto(codigo, nomeP, tipo, valor, imagem, vendedor, dataCadastro);

				return p;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
}
