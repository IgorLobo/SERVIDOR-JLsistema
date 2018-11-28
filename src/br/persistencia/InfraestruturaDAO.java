package br.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

import br.interfaces.IInfraestrutura;
import br.model.Cliente;
import br.model.Infraestrutura;

public class InfraestruturaDAO implements IInfraestrutura {
	private String nomeDoArquivo = "";

	public InfraestruturaDAO(String nomeDoArquivo) {
		this.nomeDoArquivo = nomeDoArquivo;
	}

	@Override
	public void incluirInfraestrutura(Infraestrutura infraestrutura) throws Exception {
		try {
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo, true);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			int id = identity();
			// Escreve no arquivo
			bufferedWriter.write(infraestrutura.desmaterializar(id) + "\r\n");
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
				Infraestrutura infraestrutura = new Infraestrutura();
				infraestrutura.materializar(linha);
				id = infraestrutura.getCodInfraestrutura();
			}
			bufferedReader.close();
			return id;

		} catch (Exception erro) {
			throw erro;
		}
	}

	@Override
	public ArrayList<Infraestrutura> listarInfraestruturas() throws Exception {
		try {
			ArrayList<Infraestrutura> listaDeInfraestruturas = new ArrayList<Infraestrutura>();
			FileReader fileReader = new FileReader(nomeDoArquivo);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = "";
			while ((linha = bufferedReader.readLine()) != null) {
				Infraestrutura infraestrutura = new Infraestrutura();
				infraestrutura.materializar(linha);
				listaDeInfraestruturas.add(infraestrutura);
			}
			bufferedReader.close();
			return listaDeInfraestruturas;
		} catch (Exception erro) {
			throw erro;
		}
	}

	@Override
	public void excluirInfraestrutura(int codInfraestrutura) throws Exception {
		try {
			ArrayList<Infraestrutura> listaDeInfraestruturas = this.listarInfraestruturas();
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int posicao = 0; posicao < listaDeInfraestruturas.size(); posicao++) {
				Infraestrutura infraestrutura = listaDeInfraestruturas.get(posicao);
				if (!(infraestrutura.getCodInfraestrutura() == (codInfraestrutura))) {
					bufferedWriter.write(infraestrutura.desmaterializar() + "\r\n");
				}
			}
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}

	@Override
	public void alterarInfraestrutura(int codInfraestrutura, Infraestrutura infraestrutura) throws Exception {
		try {
			ArrayList<Infraestrutura> listaDeInfraestruturas = this.listarInfraestruturas();
			// cria o arquivo
			FileWriter fileWriter = new FileWriter(nomeDoArquivo);
			// Criar o buffer do arquivo
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int posicao = 0; posicao < listaDeInfraestruturas.size(); posicao++) {
				Infraestrutura infra = listaDeInfraestruturas.get(posicao);
				if (!(infra.getCodInfraestrutura() == (codInfraestrutura))) {
					bufferedWriter.write(infra.desmaterializar() + "\r\n");
				} else {
					int id = codInfraestrutura;
					id--;
					bufferedWriter.write(infraestrutura.desmaterializar(id) + "\r\n");
				}
			}
			bufferedWriter.close();
		} catch (Exception erro) {
			throw erro;
		}
	}
}
