package model;

import java.sql.Date;

public class Produto {
	private int codigo;
	private String nome;
	private String tipo;
	private double valor;
	private String imagem;
	private String vendedor;
	private Date dataCadastro;

	public Produto(int codigo, String nome, String tipo, double valor, String imagem, String vendedor,
			Date dataCadastro) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.tipo = tipo;
		this.valor = valor;
		this.imagem = imagem;
		this.vendedor = vendedor;
		this.dataCadastro = dataCadastro;
	}

	public Produto(String nome2, String tipo2, double parseDouble, String imagem2, String vendedor2, String format) {
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
