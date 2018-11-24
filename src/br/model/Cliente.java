package br.model;

public class Cliente {
	private int codCliente = 0;
	private String nomeCliente = "";
	private String cpfCliente = "";
	private String cepCliente = "";
	private String estadoCliente = "";
	private String bairroCliente = "";
	private String enderecoCliente = "";
	private String complementoCliente = "";
	private Telefone telefoneCliente = null;
	private Email email = null;
	private String observacao = "";
	
	public Cliente(int codCliente, String nomeCliente, String cpfCliente, String cepCliente, String estadoCliente,
			String bairroCliente, String enderecoCliente, String complementoCliente, Telefone telefoneCliente,
			Email email, String observacao) {
		this.codCliente = codCliente;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.cepCliente = cepCliente;
		this.estadoCliente = estadoCliente;
		this.bairroCliente = bairroCliente;
		this.enderecoCliente = enderecoCliente;
		this.complementoCliente = complementoCliente;
		this.telefoneCliente = telefoneCliente;
		this.email = email;
		this.observacao = observacao;
	}

	
	//-----------------METODOS--------------------
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//-----------------GETS AND SETERS--------------------
	public int getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(int codCliente) {
		this.codCliente = codCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getCepCliente() {
		return cepCliente;
	}

	public void setCepCliente(String cepCliente) {
		this.cepCliente = cepCliente;
	}

	public String getEstadoCliente() {
		return estadoCliente;
	}

	public void setEstadoCliente(String estadoCliente) {
		this.estadoCliente = estadoCliente;
	}

	public String getBairroCliente() {
		return bairroCliente;
	}

	public void setBairroCliente(String bairroCliente) {
		this.bairroCliente = bairroCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getComplementoCliente() {
		return complementoCliente;
	}

	public void setComplementoCliente(String complementoCliente) {
		this.complementoCliente = complementoCliente;
	}

	public Telefone getTelefoneCliente() {
		return telefoneCliente;
	}

	public void setTelefoneCliente(Telefone telefoneCliente) {
		this.telefoneCliente = telefoneCliente;
	}

	public Email getEmail() {
		return email;
	}

	public void setEmail(Email email) {
		this.email = email;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	
}
