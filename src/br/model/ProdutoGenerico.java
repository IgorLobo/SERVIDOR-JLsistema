package br.model;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ProdutoGenerico {
	private SimpleIntegerProperty codProduto;
	private SimpleStringProperty tipo;
	private SimpleStringProperty nomeProduto;
	private SimpleStringProperty descricao ;
	private SimpleStringProperty fabricante;
	private SimpleFloatProperty valorUnitarioVenda;
	private SimpleFloatProperty valorUnitarioLocacao;
	private SimpleStringProperty compatibilidade;
	private SimpleIntegerProperty quantidade ;
	
	public ProdutoGenerico(Produto produto) {
		this.codProduto = new SimpleIntegerProperty(produto.getCodProduto());
		this.tipo = new SimpleStringProperty(produto.getTipo());
		this.nomeProduto = new SimpleStringProperty(produto.getNomeProduto());
		this.descricao = new SimpleStringProperty(produto.getDescricao());
		this.fabricante = new SimpleStringProperty(produto.getFabricante());
		this.valorUnitarioVenda = new SimpleFloatProperty(produto.getValorUnitarioVenda());
		this.valorUnitarioLocacao = new SimpleFloatProperty(produto.getValorUnitarioLocacao());
		this.compatibilidade = new SimpleStringProperty(produto.getCompatibilidade());
		this.quantidade = new SimpleIntegerProperty(produto.getQuantidade());
	}

	public SimpleIntegerProperty getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(SimpleIntegerProperty codProduto) {
		this.codProduto = codProduto;
	}

	public SimpleStringProperty getTipo() {
		return tipo;
	}

	public void setTipo(SimpleStringProperty tipo) {
		this.tipo = tipo;
	}

	public SimpleStringProperty getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(SimpleStringProperty nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public SimpleStringProperty getDescricao() {
		return descricao;
	}

	public void setDescricao(SimpleStringProperty descricao) {
		this.descricao = descricao;
	}

	public SimpleStringProperty getFabricante() {
		return fabricante;
	}

	public void setFabricante(SimpleStringProperty fabricante) {
		this.fabricante = fabricante;
	}

	public SimpleFloatProperty getValorUnitarioVenda() {
		return valorUnitarioVenda;
	}

	public void setValorUnitarioVenda(SimpleFloatProperty valorUnitarioVenda) {
		this.valorUnitarioVenda = valorUnitarioVenda;
	}

	public SimpleFloatProperty getValorUnitarioLocacao() {
		return valorUnitarioLocacao;
	}

	public void setValorUnitarioLocacao(SimpleFloatProperty valorUnitarioLocacao) {
		this.valorUnitarioLocacao = valorUnitarioLocacao;
	}

	public SimpleStringProperty getCompatibilidade() {
		return compatibilidade;
	}

	public void setCompatibilidade(SimpleStringProperty compatibilidade) {
		this.compatibilidade = compatibilidade;
	}

	public SimpleIntegerProperty getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(SimpleIntegerProperty quantidade) {
		this.quantidade = quantidade;
	}
	
	

	
}
