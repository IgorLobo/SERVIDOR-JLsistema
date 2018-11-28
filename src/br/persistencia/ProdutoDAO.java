package br.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import br.interfaces.IProduto;
import br.model.Produto;

public class ProdutoDAO implements IProduto {
	private String nomeDoArquivo = "";

	public ProdutoDAO(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

	@Override
	public void incluirProduto(Produto produto) throws Exception {
		try {
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo, true);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			int id = identity();
			// Escreve no arquivo
			bufferedWriter.write(produto.desmaterializar(id) + "\r\n");
			// fecha o arquivo
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}

	@Override
	public int identity() throws Exception {
		try {
			int id = 0;
			FileReader fileReader = new FileReader(nomeDoArquivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";
			while ((linha = bufferedReader.readLine()) != null) {
				Produto produto = new Produto();
				produto.materializar(linha);
				id = produto.getCodProduto();
			}
			bufferedReader.close();
			return id;

		} catch (Exception erro) {
			throw erro;
		}
	}

	@Override
	public ArrayList<Produto> listarProdutos() throws Exception {
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
	public void excluirProduto(int codProduto) throws Exception {
		try {
			ArrayList<Produto> listaDeProdutos = this.listarProdutos();
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int posicao = 0; posicao < listaDeProdutos.size(); posicao++) {
				Produto produto = listaDeProdutos.get(posicao);
				if (!(produto.getCodProduto() == (codProduto))) {
					bufferedWriter.write(produto.desmaterializar() + "\r\n");
				}
			}
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}

	@Override
	public void alterarProduto(int codProduto, Produto produto) throws Exception {
		try {
			ArrayList<Produto> listaDeClientes = this.listarProdutos();
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int posicao = 0; posicao < listaDeClientes.size(); posicao++) {
				Produto produt = listaDeClientes.get(posicao);
				if (!(produt.getCodProduto() == (codProduto))) {
					bufferedWriter.write(produt.desmaterializar() + "\r\n");
				} else {
					int id = codProduto;
					id--;
					bufferedWriter.write(produto.desmaterializar(id) + "\r\n");
				}
			}
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}

	@Override
	public Produto getProduto(int codProduto) throws Exception {
		try {
			FileReader fileReader = new FileReader(nomeDoArquivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";
			while ((linha = bufferedReader.readLine()) != null) {
				Produto produto = new Produto();
				produto.materializar(linha);
				if(produto.getCodProduto() == codProduto) return produto;
			}
			bufferedReader.close();
		} catch (Exception erro) {
			throw erro;
		}
		
		
		return null;
	}
	
	public Produto getProduto(int codProduto, int novoQnt) throws Exception {
		try {
			FileReader fileReader = new FileReader(nomeDoArquivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";
			while ((linha = bufferedReader.readLine()) != null) {
				Produto produto = new Produto();
				produto.materializar(linha);
				if(produto.getCodProduto() == codProduto) {
					produto.definirQuantidade(novoQnt);
					produto.setSubtotal(produto.getValorUnitarioVenda() * produto.getQuantidade());
					return produto;
				}
			}
			bufferedReader.close();
		} catch (Exception erro) {
			throw erro;
		}
		
		
		return null;
	}

	
}
