package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ItemVenda;

public class ItemVendaDao {

	public void comprar(ItemVenda iV) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("insert into item_venda ?, ?, ?");

			stmt.setInt(1, iV.getProdutoCodigo());
			stmt.setInt(2, iV.getVendaNotaFiscal());
			stmt.setInt(3, iV.getQtde());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<ItemVenda> listar() {
		Connection con = null;
		PreparedStatement stmt = null;
		ArrayList<ItemVenda> itemVenda = new ArrayList<>();

		try {
			con = Conexao.getConnection();
			stmt = con.prepareStatement("select * from item_venda");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				int produtoCodigo = rs.getInt("produto_codigo");
				int vendaNotaFiscal = rs.getInt("venda_nota_fiscal");
				int qtde = rs.getInt("qtde");

				ItemVenda iV = new ItemVenda(produtoCodigo, vendaNotaFiscal, qtde);

				itemVenda.add(iV);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return itemVenda;
	}
}
