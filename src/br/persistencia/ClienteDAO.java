package br.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import br.interfaces.ICliente;
import br.model.Cliente;

public class ClienteDAO implements ICliente {

	private String nomeDoArquivo = "";

	public ClienteDAO(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

	@Override
	public void incluir(Cliente cliente) throws Exception {
		try {
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo, true);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			// Escreve no arquivo
			bufferedWriter.write(cliente.desmaterializar() + "\n");
			// fecha o arquivo
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}

	@Override
	public ArrayList<Cliente> listar() throws Exception {
		try {
			ArrayList<Cliente> listaDeClientes = new ArrayList<Cliente>();
			FileReader fileReader = new FileReader(nomeDoArquivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";
			while ((linha = bufferedReader.readLine()) != null) {
				Cliente cliente = new Cliente();
				cliente.materializar(linha);
				listaDeClientes.add(cliente);
			}
			bufferedReader.close();
			return listaDeClientes;
		} catch (Exception erro) {
			throw erro;
		}
	}

	@Override
	public void excluir(int codCliente) throws Exception {
		try {
			ArrayList<Cliente> listaDeClientes = this.listar();
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int posicao = 0; posicao < listaDeClientes.size(); posicao++) {
				Cliente cliente = listaDeClientes.get(posicao);
				if (!(cliente.getCodCliente() == (codCliente))) {
					bufferedWriter.write(cliente.desmaterializar() + "\n");
				}
			}
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}

}
