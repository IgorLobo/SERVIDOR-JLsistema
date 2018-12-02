package br.model;

import java.util.Date;

import br.interfaces.TratamentoDeDados;

public class Infraestrutura implements TratamentoDeDados {

	private int codInfraestrutura = 0;
	private String nomeInfraestrutura = "";
	private String descricaoInfraestrutura = "";
	private float precoDiaInfraestrutura = 0;
	private String observacao = " ";
	private String dataLocacao = "";

	public Infraestrutura(int codInfraestrutura, String nomeInfraestrutura, String descricaoInfraestrutura,
			float precoDiaInfraestrutura, String observacao) {
		this.codInfraestrutura = codInfraestrutura;
		this.nomeInfraestrutura = nomeInfraestrutura;
		this.descricaoInfraestrutura = descricaoInfraestrutura;
		this.precoDiaInfraestrutura = precoDiaInfraestrutura;
		this.observacao = observacao;
	}

	// sem id
	public Infraestrutura(String nomeInfraestrutura, String descricaoInfraestrutura, Float precoDiaInfraestrutura) {
		this.nomeInfraestrutura = nomeInfraestrutura;
		this.descricaoInfraestrutura = descricaoInfraestrutura;
		this.precoDiaInfraestrutura = precoDiaInfraestrutura;
	}

	// locação
	public Infraestrutura(String nomeInfraestrutura, float precoDiaInfraestrutura, String dataLocacao) {
		this.nomeInfraestrutura = nomeInfraestrutura;
		this.precoDiaInfraestrutura = precoDiaInfraestrutura;
		this.dataLocacao = dataLocacao;
	}

	public Infraestrutura() {

	}

	// -----------------METODOS--------------------

	@Override
	public void materializar(String dados) throws Exception {
		String vetorString[] = dados.split(";");
		if (vetorString.length != 5)
			throw new Exception("Faltam dados na String");
		this.codInfraestrutura = Integer.parseInt(vetorString[0]);
		this.nomeInfraestrutura = vetorString[1];
		this.descricaoInfraestrutura = vetorString[2];
		this.precoDiaInfraestrutura = Float.parseFloat(vetorString[3]);
		this.observacao = vetorString[4];
	}

	@Override
	public String desmaterializar() {
		String saida = "";
		saida += this.codInfraestrutura + ";";
		saida += this.nomeInfraestrutura + ";";
		saida += this.descricaoInfraestrutura + ";";
		saida += this.precoDiaInfraestrutura + ";";
		saida += this.observacao + ";";
		return saida;
	}

	public String desmaterializar(int id) {
		id++;
		this.codInfraestrutura = id;
		String saida = "";
		saida += this.codInfraestrutura + ";";
		saida += this.nomeInfraestrutura + ";";
		saida += this.descricaoInfraestrutura + ";";
		saida += this.precoDiaInfraestrutura + ";";
		saida += this.observacao + ";";
		return saida;
	}

	public String desmaterializarData(int id) {
		id++;
		this.codInfraestrutura = id;
		String saida = "";
		saida += this.codInfraestrutura + ";";
		return saida;
	}

	// -----------------GETS AND SETERS--------------------
	public int getCodInfraestrutura() {
		return codInfraestrutura;
	}

	public String getNomeInfraestrutura() {
		return nomeInfraestrutura;
	}

	public String getDescricaoInfraestrutura() {
		return descricaoInfraestrutura;
	}

	public float getPrecoDiaInfraestrutura() {
		return precoDiaInfraestrutura;
	}

	public String getObservacao() {
		return observacao;
	}

	public String getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

}
