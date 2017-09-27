package model;

public class ItemVenda {
	private int produtoCodigo;
	private int vendaNotaFiscal;
	private int qtde;

	public ItemVenda(int produtoCodigo, int vendaNotaFiscal, int qtde) {
		super();
		this.produtoCodigo = produtoCodigo;
		this.vendaNotaFiscal = vendaNotaFiscal;
		this.qtde = qtde;
	}

	public int getProdutoCodigo() {
		return produtoCodigo;
	}

	public void setProdutoCodigo(int produtoCodigo) {
		this.produtoCodigo = produtoCodigo;
	}

	public int getVendaNotaFiscal() {
		return vendaNotaFiscal;
	}

	public void setVendaNotaFiscal(int vendaNotaFiscal) {
		this.vendaNotaFiscal = vendaNotaFiscal;
	}

	public int getQtde() {
		return qtde;
	}

	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

}
