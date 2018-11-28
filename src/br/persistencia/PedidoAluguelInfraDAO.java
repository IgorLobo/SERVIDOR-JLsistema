package br.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import br.interfaces.IPedidos;
import br.model.Pedido;

public class PedidoAluguelInfraDAO implements IPedidos {
	private String nomeDoArquivo = "";

	public PedidoAluguelInfraDAO(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

	@Override
	public void incluirPedido(Pedido pedido) throws Exception {
		try {
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo, true);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			int id = identity();
			// Escreve no arquivo
			bufferedWriter.write(pedido.desmaterializarAluguelInfra(id) + "\r\n");
			// fecha o arquivo
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}

	@Override
	public ArrayList<Pedido> listarPedidos() throws Exception {
		try {
			ArrayList<Pedido> listaDePedidosAluguelInfra = new ArrayList<Pedido>();
			FileReader fileReader = new FileReader(nomeDoArquivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";
			while ((linha = bufferedReader.readLine()) != null) {
				Pedido pedidoAluguelInfra = new Pedido();
				pedidoAluguelInfra.materializarPedidoAluguelInfra(linha);
				;
				listaDePedidosAluguelInfra.add(pedidoAluguelInfra);
			}
			bufferedReader.close();
			return listaDePedidosAluguelInfra;
		} catch (Exception erro) {
			throw erro;
		}
	}

	@Override
	public void excluirPedido(int codPedidoAluguelInfra) throws Exception {
		try {
			ArrayList<Pedido> listaDePedidosAluguelInfra = this.listarPedidos();
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int posicao = 0; posicao < listaDePedidosAluguelInfra.size(); posicao++) {
				Pedido pedidoAluguelInfra = listaDePedidosAluguelInfra.get(posicao);
				if (!(pedidoAluguelInfra.getCodPedido() == (codPedidoAluguelInfra))) {
					bufferedWriter.write(pedidoAluguelInfra.desmaterializar() + "\r\n");
				}
			}
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}

	@Override
	public void alterarPedido(int codPedidoAluguelInfra, Pedido pedidoAluguelInfra) throws Exception {
		try {
			ArrayList<Pedido> listaDePedidosAluguelProduto = this.listarPedidos();
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int posicao = 0; posicao < listaDePedidosAluguelProduto.size(); posicao++) {
				Pedido pedidoAluguelInfraestrutura = listaDePedidosAluguelProduto.get(posicao);
				if (!(pedidoAluguelInfraestrutura.getCodPedido() == (codPedidoAluguelInfra))) {
					bufferedWriter.write(pedidoAluguelInfraestrutura.desmaterializar() + "\r\n");
				} else {
					int id = codPedidoAluguelInfra;
					id--;
					bufferedWriter.write(pedidoAluguelInfra.desmaterializarAluguelInfra(id) + "\r\n");
				}
			}
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
				Pedido pedido = new Pedido();
				pedido.materializarPedidoAluguelInfra(linha);
				id = pedido.getCodPedido();
			}
			bufferedReader.close();
			return id;

		} catch (Exception erro) {
			throw erro;
		}
	}
}
