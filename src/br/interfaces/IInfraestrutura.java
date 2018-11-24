package br.interfaces;

import java.util.ArrayList;

import br.model.Infraestrutura;

public interface IInfraestrutura {
	void incluir(Infraestrutura infraestrutura) throws Exception;
    public ArrayList<Infraestrutura> listar() throws Exception;
    public void excluir(String nomeInfraestrutura) throws Exception;
}
