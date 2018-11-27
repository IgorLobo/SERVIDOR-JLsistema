package br.interfaces;

import java.util.ArrayList;

import br.model.Cliente;

public interface ICliente {
	void incluir(Cliente cliente) throws Exception;
    public ArrayList<Cliente> listar() throws Exception;
    public void excluir(int codCliente) throws Exception;
    public void alterar(int codCliente, Cliente cliente) throws Exception;
}
