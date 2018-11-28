package br.model;

import java.util.ArrayList;

import br.interfaces.ICliente;
import br.interfaces.IInfraestrutura;
import br.interfaces.IProduto;

public class Pedido implements ICliente, IInfraestrutura, IProduto{

	private ArrayList<Produto> produtos = null;
	
	public Pedido(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
	/*
	public Pedido() {
	
	}*/
	
	
	//PRODUTO---------------------------------------------------------------------------------------
	@Override
	public void incluirProduto(Produto produto) throws Exception {
			
	}

	@Override
	public ArrayList<Produto> listarProdutos() throws Exception {
		return null;
	}

	@Override
	public void excluirProduto(int codProduto) throws Exception {

	}

	@Override
	public void alterarProduto(int codProduto, Produto produto) throws Exception {

	}

	@Override
	public Produto getProduto(int codProduto) throws Exception {

		return null;
	}

	//INFRAESTRUTURA--------------------------------------------------------------------------------
	@Override
	public void incluirInfraestrutura(Infraestrutura infraestrutura) throws Exception {

	}

	@Override
	public ArrayList<Infraestrutura> listarInfraestruturas() throws Exception {
		return null;
	}

	@Override
	public void excluirInfraestrutura(int codInfraestrutura) throws Exception {

	}

	@Override
	public void alterarInfraestrutura(int codInfraestrutura, Infraestrutura infraestrutura) throws Exception {

	}

	//CLIENTE----------------------------------------------------------------------------------------
	@Override
	public void incluirCliente(Cliente cliente) throws Exception {

	}

	@Override
	public ArrayList<Cliente> listarClientes() throws Exception {
		return null;
	}

	@Override
	public void excluirCliente(int codCliente) throws Exception {

	}

	@Override
	public void alterarCliente(int codCliente, Cliente cliente) throws Exception {

	}

}
