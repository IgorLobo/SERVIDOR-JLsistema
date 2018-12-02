package br.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Locale;

import br.controllers.TelaPrincipalController;
import br.interfaces.IPedidos;
import br.model.Identificador;
import br.model.Pedido;

public class PedidoAluguelInfraDAO implements IPedidos {
	private String nomeDoArquivo = "";

	public PedidoAluguelInfraDAO(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
		Locale.setDefault(Locale.US);
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
					bufferedWriter.write(pedidoAluguelInfra.desmaterializarAluguelInfra() + "\r\n");
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
					bufferedWriter.write(pedidoAluguelInfraestrutura.desmaterializarAluguelInfra() + "\r\n");
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
			String linhaDoId = "";

 			ArrayList<Identificador> listaDeIdentificadores = new ArrayList<Identificador>();
			FileReader fileReader = new FileReader(TelaPrincipalController.ids);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";
			while ((linha = bufferedReader.readLine()) != null) {
				Identificador identificador = new Identificador();
				identificador.materializar(linha);
				listaDeIdentificadores.add(identificador);
			}
			bufferedReader.close();

			FileWriter fileWriter = new FileWriter(TelaPrincipalController.ids);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int posicao = 0; posicao < listaDeIdentificadores.size(); posicao++) {
				Identificador identificador = listaDeIdentificadores.get(posicao);
				if (!(identificador.getTipo().equals("PedidoAluguelInfra"))) {
					bufferedWriter.write(identificador.desmaterializar() + "\r\n");
				}else {
					id = identificador.getId();
				}
			}
			bufferedWriter.close();

			FileReader fileReader1 = new FileReader(TelaPrincipalController.ids);
			BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
			ArrayList<Identificador> listaDeIdentificadores1 = new ArrayList<Identificador>();
			while ((linha = bufferedReader1.readLine()) != null) {
				Identificador identificador = new Identificador();
				identificador.materializar(linha);
				listaDeIdentificadores1.add(identificador);
			}
			bufferedReader1.close();

			FileWriter fileWriter1 = new FileWriter(TelaPrincipalController.ids);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter1 = new BufferedWriter(fileWriter1);
			for (int posicao = 0; posicao < listaDeIdentificadores1.size(); posicao++) {
				Identificador identificador1 = listaDeIdentificadores1.get(posicao);
				if (!(identificador1.getTipo().equals("PedidoAluguelInfra"))) {
					bufferedWriter1.write(identificador1.desmaterializar() + "\r\n");
				} 
			}
			id++;
			Identificador i = new Identificador(id,"PedidoAluguelInfra");
			bufferedWriter1.write(i.desmaterializar(id) + "\r\n");
			
			bufferedWriter1.close();			
			return id;

		} catch (Exception erro) {
			throw erro;
		}
	}
	
	public void incluirDataAluguelInfra(int codPedidoAluguelInfra, Pedido pedidoAluguelInfra) throws Exception {
		try {
			ArrayList<Pedido> listaDePedidosAluguelProduto = this.listarPedidos();
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int posicao = 0; posicao < listaDePedidosAluguelProduto.size(); posicao++) {
				Pedido pedidoAluguelInfraestrutura = listaDePedidosAluguelProduto.get(posicao);
				if (!(pedidoAluguelInfraestrutura.getCodPedido() == (codPedidoAluguelInfra))) {
					bufferedWriter.write(pedidoAluguelInfraestrutura.desmaterializarAluguelInfra() + "\r\n");
				} else {
					int id = codPedidoAluguelInfra;
					id--;
					bufferedWriter.write(pedidoAluguelInfra.desmaterializarAluguelInfraData(id) + "\r\n");
				}
			}
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}
}
