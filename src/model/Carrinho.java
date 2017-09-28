package model;

import java.util.ArrayList;
import java.util.List;

import persistence.ProdutoDao;

public class Carrinho {

	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	ProdutoDao pDao = new ProdutoDao();

	public Carrinho() {

	}

	public void inserir(Produto p) {
		produtos.add(p);
	}

	public int buscar(int codigo) {

		for (int i = 1; i < produtos.size(); i++) {
			if (produtos.get(i).getCodigo() == 0) {
				return i;
			}

		}

		return 0;
	}

	public void remover(int codigo) {
		if (codigo != 0) {
			produtos.remove(buscar(codigo));

		}
	}

	public List<Produto> listar() {
		return produtos;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

}
