package br.model;

import java.util.ArrayList;

import br.interfaces.ICliente;
import br.interfaces.IInfraestrutura;
import br.interfaces.IProduto;
import br.interfaces.TratamentoDeDados;

public class Pedido {
	private int codPedido = 0;
	private int quantidadeProdutos = 0;
	private int quantidadeInfraestrutura = 0;
	private String tipoPedido = "Venda";
	private boolean pedidoConfirmado = false;

	private String formaPagamento = "";
	private Cliente cliente = new Cliente();
	private ArrayList<Infraestrutura> infraestrutura = null;
	private ArrayList<Produto> produtos = null;

	// sem tipo especifico vamos usar para venda
	public Pedido(Cliente cliente, ArrayList<Produto> produtos, String formaPagamento) {
		this.cliente = cliente;
		this.produtos = produtos;
		this.formaPagamento = formaPagamento;
	}

	public Pedido(Cliente cliente, ArrayList<Produto> produtos, String formaPagamento, String tipoPedido) {
		this.cliente = cliente;
		this.produtos = produtos;
		this.formaPagamento = formaPagamento;
		this.tipoPedido = tipoPedido;
	}

	public Pedido() {

	}

	// -----------------METODOS--------------------
	private Produto getProdutoArrayList(int posicao) throws Exception {
		Produto produtoSelecionado = produtos.get(posicao);
		return produtoSelecionado;
	}

	private int getTamanhoArray(ArrayList arrayList) {
		int tamanho = arrayList.size();
		return tamanho;
	}

	private Infraestrutura getInfraArrayList(int posicao) throws Exception {
		Infraestrutura infraSelecionada = infraestrutura.get(posicao);
		return infraSelecionada;
	}

	// TRATAMENTO DE DADOS--------------------------------------------------------------------

	public void materializarPedidoVenda(String dados) throws Exception {
		Produto produto = null;
		String vetorString[] = dados.split(";");

		this.codPedido = Integer.parseInt(vetorString[0]);
		this.quantidadeProdutos = Integer.parseInt(vetorString[1]);
		for (int i = 0; i < this.quantidadeProdutos; i++) {
			produto = new Produto(Integer.parseInt(vetorString[2 + (i * 9)]), vetorString[3 + (i * 9)],
					vetorString[4 + (i * 9)], vetorString[5 + (i * 9)], vetorString[6 + (i * 9)],
					Float.parseFloat(vetorString[7 + (i * 9)]), Float.parseFloat(vetorString[8 + (i * 9)]),
					vetorString[9 + (i * 9)], Integer.parseInt(vetorString[10 + (i * 9)]));
			produtos.add(produto);
		}
		this.formaPagamento = vetorString[vetorString.length - 2];
		this.pedidoConfirmado = Boolean.parseBoolean(vetorString[vetorString.length - 1]);
	}
	

	public void materializarPedidoAluguelProduto(String dados) throws Exception {
		Produto produto = null;
		String vetorString[] = dados.split(";");

		this.codPedido = Integer.parseInt(vetorString[0]);
		this.quantidadeProdutos = Integer.parseInt(vetorString[1]);
		for (int i = 0; i < this.quantidadeProdutos; i++) {
			produto = new Produto(Integer.parseInt(vetorString[2 + (i * 9)]), vetorString[3 + (i * 9)],
					vetorString[4 + (i * 9)], vetorString[5 + (i * 9)], vetorString[6 + (i * 9)],
					Float.parseFloat(vetorString[7 + (i * 9)]), Float.parseFloat(vetorString[8 + (i * 9)]),
					vetorString[9 + (i * 9)], Integer.parseInt(vetorString[10 + (i * 9)]));
			produtos.add(produto);
		}
		this.formaPagamento = vetorString[vetorString.length - 2];
		this.pedidoConfirmado = Boolean.parseBoolean(vetorString[vetorString.length - 1]);
	}

	
	public void materializarPedidoAluguelInfra(String dados) throws Exception {
		Infraestrutura infra = null;
		String vetorString[] = dados.split(";");

		this.codPedido = Integer.parseInt(vetorString[0]);
		this.quantidadeInfraestrutura = Integer.parseInt(vetorString[1]);
		for (int i = 0; i < this.quantidadeInfraestrutura; i++) {
			infra = new Infraestrutura(Integer.parseInt(vetorString[2 + (i * 5)]), vetorString[3 + (i * 5)],
					vetorString[4 + (i * 5)], Float.parseFloat(vetorString[5 + (i * 5)]), vetorString[6 + (i * 5)]);
			infraestrutura.add(infra);
		}
		this.formaPagamento = vetorString[vetorString.length - 2];
		this.pedidoConfirmado = Boolean.parseBoolean(vetorString[vetorString.length - 1]);
	}

	
	public String desmaterializar() throws Exception {
		String saida = "";
		saida += cliente.desmaterializar();
		for (int posicao = 0; posicao < produtos.size(); posicao++) {
			saida += getProdutoArrayList(posicao).desmaterializar();
		}
		saida += this.formaPagamento + ";";
		saida += this.pedidoConfirmado + ";";
		return saida;
	}

	
	public String desmaterializarVenda(int id) throws Exception {
		id++;
		this.codPedido = id;
		String saida = "";
		saida += this.codPedido + ";";
		this.quantidadeProdutos = getTamanhoArray(produtos);
		saida += this.quantidadeProdutos + ";";
		saida += cliente.desmaterializar();
		for (int posicao = 0; posicao < produtos.size(); posicao++) {
			saida += getProdutoArrayList(posicao).desmaterializar();
		}
		saida += this.formaPagamento + ";";
		saida += this.pedidoConfirmado + ";";
		return saida;
	}

	
	public String desmaterializarAluguelProduto(int id) throws Exception {
		id++;
		this.codPedido = id;
		String saida = "";
		saida += this.codPedido + ";";
		saida += cliente.desmaterializar();
		for (int posicao = 0; posicao < produtos.size(); posicao++) {
			saida += getProdutoArrayList(posicao).desmaterializar();
		}
		saida += this.formaPagamento + ";";
		saida += this.pedidoConfirmado + ";";
		return saida;
	}

	
	public String desmaterializarAluguelInfra(int id) throws Exception {
		id++;
		this.codPedido = id;
		String saida = "";
		saida += this.codPedido + ";";
		saida += cliente.desmaterializar();
		for (int posicao = 0; posicao < produtos.size(); posicao++) {
			saida += getProdutoArrayList(posicao).desmaterializar();
		}
		saida += this.formaPagamento + ";";
		saida += this.pedidoConfirmado + ";";
		return saida;
	}

}
