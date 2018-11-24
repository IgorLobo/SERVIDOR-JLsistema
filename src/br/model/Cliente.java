package br.model;

import br.interfaces.TratamentoDeDados;

public class Cliente implements TratamentoDeDados{
	private int codCliente = 1;
	private String nomeCliente = "";
	private String cpfCliente = "";
	private String cepCliente = "";
	private String estadoCliente = "";
	private String cidadeCliente = "";
	private String setorCliente = "";
	private String enderecoCliente = "";
	private String complementoCliente = "";
	private String telefone1Cliente = "";
	private String telefone2Cliente = "";
	private String email1Cliente = "";
	private String email2Cliente = "";
	private String observacao = " ";
	
		
	public Cliente(String nomeCliente, String cpfCliente, String cepCliente, String estadoCliente, String cidadeCliente,
			String setorCliente, String enderecoCliente, String complementoCliente, String telefone1Cliente,
			String telefone2Cliente, String email1Cliente, String email2Cliente) {
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.cepCliente = cepCliente;
		this.estadoCliente = estadoCliente;
		this.cidadeCliente = cidadeCliente;
		this.setorCliente = setorCliente;
		this.enderecoCliente = enderecoCliente;
		this.complementoCliente = complementoCliente;
		this.telefone1Cliente = telefone1Cliente;
		this.telefone2Cliente = telefone2Cliente;
		this.email1Cliente = email1Cliente;
		this.email2Cliente = email2Cliente;
	}


	public Cliente() {
		
	}

	
	//-----------------METODOS--------------------
	@Override
	public void materializar(String dados) throws Exception {
		String vetorString[] = dados.split(";");
		if(vetorString.length != 13) 
            throw new Exception("Faltam dados na String");
        this.codCliente = Integer.parseInt(vetorString[0]);
        this.nomeCliente = vetorString[1];		
		this.cpfCliente = vetorString[2];
		this.cepCliente = vetorString[3];
		this.estadoCliente = vetorString[4];
		this.setorCliente = vetorString[5];
		this.enderecoCliente = vetorString[6];
		this.complementoCliente = vetorString[7];
		this.telefone1Cliente = vetorString[8];
		this.telefone2Cliente = vetorString[9];
		this.email1Cliente = vetorString[10];
		this.email2Cliente = vetorString[11];
		this.observacao = vetorString[12];
	}


	@Override
	public String desmaterializar() {
		String saida = "";
		saida += this.codCliente + ";";
				 this.codCliente++;
		saida += this.nomeCliente + ";";
		saida += this.cpfCliente + ";";
		saida += this.cepCliente + ";";
		saida += this.estadoCliente + ";";
		saida += this.setorCliente + ";";
		saida += this.enderecoCliente + ";";
		saida += this.complementoCliente + ";";
		saida += this.telefone1Cliente + ";";
		saida += this.telefone2Cliente + ";";
		saida += this.email1Cliente + ";";
		saida += this.email2Cliente + ";";
		saida += this.observacao + ";";
        return saida;
	}

	//-----------------GETS AND SETERS--------------------
	public int getCodCliente() {
		return codCliente;
	}


	public String getNomeCliente() {
		return nomeCliente;
	}


	public String getCpfCliente() {
		return cpfCliente;
	}


	public String getCepCliente() {
		return cepCliente;
	}


	public String getEstadoCliente() {
		return estadoCliente;
	}


	public String getBairroCliente() {
		return setorCliente;
	}


	public String getEnderecoCliente() {
		return enderecoCliente;
	}


	public String getComplementoCliente() {
		return complementoCliente;
	}


	public String getTelefone1Cliente() {
		return telefone1Cliente;
	}


	public String getTelefone2Cliente() {
		return telefone2Cliente;
	}


	public String getEmail1Cliente() {
		return email1Cliente;
	}


	public String getEmail2Cliente() {
		return email2Cliente;
	}


	public String getObservacao() {
		return observacao;
	}
	//-----------------GETS AND SETERS--------------------
	
}
