package br.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import br.model.Pedido;

public class PedidoAluguelProdutoDAO {

	private String nomeDoArquivo = "";

	public PedidoAluguelProdutoDAO(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

	public void incluirPedidoAluguelProduto(Pedido pedido) throws Exception {
		try {
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo, true);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			int id = identity();
			// Escreve no arquivo
			bufferedWriter.write(pedido.desmaterializarAluguelProduto(id) + "\r\n");
			// fecha o arquivo
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}

	private int identity() throws Exception {
		try {
			int id = 0;
			FileReader fileReader = new FileReader(nomeDoArquivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";
			while ((linha = bufferedReader.readLine()) != null) {
				Pedido pedido = new Pedido();
				pedido.materializarPedidoAluguelProduto(linha);
				id = pedido.getCodPedido();
			}
			bufferedReader.close();
			return id;

		} catch (Exception erro) {
			throw erro;
		}
	}

	public ArrayList<Pedido> listarPedidosAluguelProdutos() throws Exception {
		try {
			ArrayList<Pedido> listaDePedidosAluguelProdutos = new ArrayList<Pedido>();
			FileReader fileReader = new FileReader(nomeDoArquivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";
			while ((linha = bufferedReader.readLine()) != null) {
				Pedido pedidoAluguelProduto = new Pedido();
				pedidoAluguelProduto.materializarPedidoAluguelProduto(linha);
				;
				listaDePedidosAluguelProdutos.add(pedidoAluguelProduto);
			}
			bufferedReader.close();
			return listaDePedidosAluguelProdutos;
		} catch (Exception erro) {
			throw erro;
		}
	}

	public void excluirPedidoAluguelProduto(int codPedidoAluguelProd) throws Exception {
		try {
			ArrayList<Pedido> listaDePedidosAluguelProdutos = this.listarPedidosAluguelProdutos();
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int posicao = 0; posicao < listaDePedidosAluguelProdutos.size(); posicao++) {
				Pedido pedidoAluguelProduto = listaDePedidosAluguelProdutos.get(posicao);
				if (!(pedidoAluguelProduto.getCodPedido() == (codPedidoAluguelProd))) {
					bufferedWriter.write(pedidoAluguelProduto.desmaterializar() + "\r\n");
				}
			}
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}

	public void alterarPedidoAluguelProduto(int codPedidoAluguelProd, Pedido pedidoAluguelProd) throws Exception {
		try {
			ArrayList<Pedido> listaDePedidosAluguelProduto = this.listarPedidosAluguelProdutos();
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int posicao = 0; posicao < listaDePedidosAluguelProduto.size(); posicao++) {
				Pedido pedidoAluguelProduto = listaDePedidosAluguelProduto.get(posicao);
				if (!(pedidoAluguelProduto.getCodPedido() == (codPedidoAluguelProd))) {
					bufferedWriter.write(pedidoAluguelProduto.desmaterializar() + "\r\n");
				} else {
					int id = codPedidoAluguelProd;
					id--;
					bufferedWriter.write(pedidoAluguelProd.desmaterializarAluguelProduto(id) + "\r\n");
				}
			}
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}
}
