package br.model;

public class Infraestrutura {
	
	private int codInfraestrutura = 0;
	private String nomeInfraestrutura = "";
	private String descricaoInfraestrutura = "";
	private float valorHora = 0;
	private String observacao = "";
	
	public Infraestrutura(int codInfraestrutura, String nomeInfraestrutura, String descricaoInfraestrutura,
			float valorHora, String observacao) {
		this.codInfraestrutura = codInfraestrutura;
		this.nomeInfraestrutura = nomeInfraestrutura;
		this.descricaoInfraestrutura = descricaoInfraestrutura;
		this.valorHora = valorHora;
		this.observacao = observacao;
	}
	
	//-----------------METODOS--------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		//-----------------GETS AND SETERS--------------------

	public int getCodInfraestrutura() {
		return codInfraestrutura;
	}

	public void setCodInfraestrutura(int codInfraestrutura) {
		this.codInfraestrutura = codInfraestrutura;
	}

	public String getNomeInfraestrutura() {
		return nomeInfraestrutura;
	}

	public void setNomeInfraestrutura(String nomeInfraestrutura) {
		this.nomeInfraestrutura = nomeInfraestrutura;
	}

	public String getDescricaoInfraestrutura() {
		return descricaoInfraestrutura;
	}

	public void setDescricaoInfraestrutura(String descricaoInfraestrutura) {
		this.descricaoInfraestrutura = descricaoInfraestrutura;
	}

	public float getValorHora() {
		return valorHora;
	}

	public void setValorHora(float valorHora) {
		this.valorHora = valorHora;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
