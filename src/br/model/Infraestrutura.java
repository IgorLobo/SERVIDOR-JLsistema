package br.model;

import br.interfaces.TratamentoDeDados;

public class Infraestrutura implements TratamentoDeDados {

	private int codInfraestrutura = 0;
	private String nomeInfraestrutura = "";
	private String descricaoInfraestrutura = "";
	private float precoDiaInfraestrutura = 0;
	private String observacao = "";
	
	public Infraestrutura(String nomeInfraestrutura, String descricaoInfraestrutura, Float precoDiaInfraestrutura) {
		this.nomeInfraestrutura = nomeInfraestrutura;
		this.descricaoInfraestrutura = descricaoInfraestrutura;
		this.precoDiaInfraestrutura = precoDiaInfraestrutura;
	}

	public Infraestrutura() {
		
	}

	// -----------------METODOS--------------------

	@Override
	public void materializar(String dados) throws Exception {
		String vetorString[] = dados.split(";");
		if (vetorString.length != 4)
			throw new Exception("Faltam dados na String");
		this.codInfraestrutura = Integer.parseInt(vetorString[0]);
		this.nomeInfraestrutura = vetorString[1];
		this.descricaoInfraestrutura = vetorString[2];
		this.precoDiaInfraestrutura = Float.parseFloat(vetorString[3]);
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

}
