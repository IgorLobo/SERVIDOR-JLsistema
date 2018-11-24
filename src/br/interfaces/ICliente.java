package br.interfaces;

import java.util.ArrayList;

import br.model.Cliente;

public interface ICliente {
	void incluir(Cliente cliente) throws Exception;
    public ArrayList<Cliente> listar() throws Exception;
    public void excluir(String nomeCliente) throws Exception;
}
