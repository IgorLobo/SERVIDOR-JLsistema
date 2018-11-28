package br.interfaces;

import java.util.ArrayList;

import br.model.Produto;
import br.model.ProdutoGenerico;


public interface IProduto {
	void incluir(Produto produto) throws Exception;
    public ArrayList<Produto> listar() throws Exception;
    public void excluir(int codProduto) throws Exception;
    public void alterar(int codProduto, Produto produto) throws Exception;
    public Produto getProduto(int codProduto) throws Exception;
}
