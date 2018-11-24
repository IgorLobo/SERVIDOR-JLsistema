package br.interfaces;

import java.util.ArrayList;

import br.model.Produto;


public interface IProduto {
	void incluir(Produto produto) throws Exception;
    public ArrayList<Produto> listar() throws Exception;
    public void excluir(int codProduto) throws Exception;
}
