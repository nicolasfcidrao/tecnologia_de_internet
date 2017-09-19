package model;

import java.sql.Date;

public class Venda {
	private int notaFiscal;
	private Date dataVenda;
	private String cpfCliente;

	public Venda(int notaFiscal, Date dataVenda, String cpfCliente) {
		super();
		this.notaFiscal = notaFiscal;
		this.dataVenda = dataVenda;
		this.cpfCliente = cpfCliente;
	}

	public int getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(int notaFiscal) {
		this.notaFiscal = notaFiscal;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

}
