package br.model;

import br.interfaces.TratamentoDeDados;

public class Produto implements TratamentoDeDados{
	private int codProduto = 0;
	private Object[] tipo = {"Jogo", "Acessório", "Console"};
	private String nomeProduto = "";
	private String descricao = "";
	private String fabricante = "";
	private float valorUnitarioVenda = 0;
	private float valorUnitarioLocacao = 0;
	private int numeroSerie = 0;
	private String compatibilidade = "";
	private String observacao = "";

	public Produto(int codProduto, String nomeProduto, String descricao, String fabricante, float valorUnitarioVenda,
			float valorUnitarioLocacao, int numeroSerie, String compatibilidade, String observacao) {
		this.codProduto = codProduto;
		this.nomeProduto = nomeProduto;
		this.descricao = descricao;
		this.fabricante = fabricante;
		this.valorUnitarioVenda = valorUnitarioVenda;
		this.valorUnitarioLocacao = valorUnitarioLocacao;
		this.numeroSerie = numeroSerie;
		this.compatibilidade = compatibilidade;
		this.observacao = observacao;
	}
	
	public Produto() {
		
	}
	
	//-----------------METODOS--------------------
	@Override
	public void materializar(String dados) throws Exception {
		String vetorString[] = dados.split(";");
        if(vetorString.length != 9) 
            throw new Exception("Faltam dados na String");
        this.codProduto = Integer.parseInt(vetorString[0]);
        this.nomeProduto = vetorString[1];		
		this.descricao = vetorString[2];
		this.fabricante = vetorString[3];
		this.valorUnitarioVenda = Float.parseFloat(vetorString[4]);
		this.valorUnitarioLocacao = Float.parseFloat(vetorString[5]);
		this.numeroSerie = Integer.parseInt(vetorString[6]);
		this.compatibilidade = vetorString[7];
		this.observacao = vetorString[8];		
	}


	@Override
	public String desmaterializar() {
		String saida = "";
		saida += this.codProduto + ";";
				 this.codProduto++;
		saida += this.nomeProduto + ";";
		saida += this.descricao + ";";
		saida += this.fabricante + ";";
		saida += this.valorUnitarioVenda + ";";
		saida += this.valorUnitarioLocacao + ";";
		saida += this.numeroSerie + ";";
		saida += this.compatibilidade + ";";
		saida += this.observacao + ";";
        return saida;
	}
	
		//-----------------GETS AND SETERS--------------------

	public int getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(int codProduto) {
		this.codProduto = codProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public float getValorUnitarioVenda() {
		return valorUnitarioVenda;
	}

	public void setValorUnitarioVenda(float valorUnitarioVenda) {
		this.valorUnitarioVenda = valorUnitarioVenda;
	}

	public float getValorUnitarioLocacao() {
		return valorUnitarioLocacao;
	}

	public void setValorUnitarioLocacao(float valorUnitarioLocacao) {
		this.valorUnitarioLocacao = valorUnitarioLocacao;
	}

	public int getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getCompatibilidade() {
		return compatibilidade;
	}

	public void setCompatibilidade(String compatibilidade) {
		this.compatibilidade = compatibilidade;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	

}
