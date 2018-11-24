package br.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import br.interfaces.IProduto;
import br.model.Produto;

public class ProdutoDAO implements IProduto{
	private String nomeDoArquivo = "";

	public ProdutoDAO(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

	@Override
	public void incluir(Produto produto) throws Exception {
		try {
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo, true);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			// Escreve no arquivo
			bufferedWriter.write(produto.desmaterializar() + "\n");
			// fecha o arquivo
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}

	@Override
	public ArrayList<Produto> listar() throws Exception {
		try {
			ArrayList<Produto> listaDeProdutos = new ArrayList<Produto>();
			FileReader fileReader = new FileReader(nomeDoArquivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";
			while ((linha = bufferedReader.readLine()) != null) {
				Produto produto = new Produto();
				produto.materializar(linha);
				listaDeProdutos.add(produto);
			}
			bufferedReader.close();
			return listaDeProdutos;
		} catch (Exception erro) {
			throw erro;
		}
	}

	@Override
	public void excluir(int codProduto) throws Exception {
		try {
			ArrayList<Produto> listaDeProdutos = this.listar();
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int posicao = 0; posicao < listaDeProdutos.size(); posicao++) {
				Produto produto = listaDeProdutos.get(posicao);
				if (!(produto.getCodProduto() == (codProduto))) {
					bufferedWriter.write(produto.desmaterializar() + "\n");
				}
			}
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}
}
