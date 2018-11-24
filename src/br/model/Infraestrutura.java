package br.model;

import br.interfaces.TratamentoDeDados;

public class Infraestrutura implements TratamentoDeDados{
	
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
	
	public Infraestrutura() {
		// TODO Auto-generated constructor stub
	}
	
	//-----------------METODOS--------------------
	
	@Override
	public void materializar(String dados) throws Exception {
		String vetorString[] = dados.split(";");
        if(vetorString.length != 5) 
            throw new Exception("Faltam dados na String");
        this.codInfraestrutura = Integer.parseInt(vetorString[0]);
        this.nomeInfraestrutura = vetorString[1];		
		this.descricaoInfraestrutura = vetorString[2];
		this.valorHora = Float.parseFloat(vetorString[3]);
		this.observacao = vetorString[4];
	}


	@Override
	public String desmaterializar() {
		String saida = "";
		saida += this.codInfraestrutura + ";";
				 this.codInfraestrutura++;
		saida += this.nomeInfraestrutura + ";";
		saida += this.descricaoInfraestrutura + ";";
		saida += this.valorHora + ";";
		saida += this.observacao + ";";
        return saida;
	}
	
	//-----------------GETS AND SETERS--------------------
	public int getCodInfraestrutura() {
		return codInfraestrutura;
	}

	public String getNomeInfraestrutura() {
		return nomeInfraestrutura;
	}

	public String getDescricaoInfraestrutura() {
		return descricaoInfraestrutura;
	}

	public float getValorHora() {
		return valorHora;
	}

	public String getObservacao() {
		return observacao;
	}	
	
}
