package br.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.interfaces.ICliente;
import br.interfaces.IInfraestrutura;
import br.interfaces.IProduto;
import br.interfaces.TratamentoDeDados;

public class Pedido {
	private int codPedido = 0;
	private int quantidadeProdutos = 0;
	private int quantidadeInfraestrutura = 0;
	private String tipoPedido = "Venda";
	private String dataInicio = "";
	private String dataFim = "";
	private boolean pedidoConfirmado = false;
	private float valorTotal = 0;

	private String formaPagamento = "";
	private Cliente cliente = new Cliente();
	private ArrayList<Infraestrutura> infraestrutura = new ArrayList<>();
	private ArrayList<Produto> produtos = new ArrayList<>();

	// tipo especifico para venda de produto
	public Pedido(Cliente cliente, ArrayList<Produto> produtos, String formaPagamento, Float valorTotal, String date) {
		this.cliente = cliente;
		this.produtos = produtos;
		this.formaPagamento = formaPagamento;
		this.valorTotal = valorTotal;
		this.pedidoConfirmado = true;
		this.dataInicio = date;
	}

	// tipo especifico para aluguel produto
	public Pedido(Cliente cliente, ArrayList<Produto> produtos, String formaPagamento, Float valorTotal,
			String tipoPedido, String dateInicio, String dateFim) {
		this.cliente = cliente;
		this.produtos = produtos;
		this.formaPagamento = formaPagamento;
		this.tipoPedido = tipoPedido;
		this.valorTotal = valorTotal;
		this.dataInicio = dateInicio;
		this.dataFim = dateFim;
	}

	// tipo especifico para aluguel infra
	public Pedido(Cliente cliente, ArrayList<Infraestrutura> infraestrutura, String formaPagamento, String tipoPedido,
			String dataAluguel) {
		this.cliente = cliente;
		this.infraestrutura = infraestrutura;
		this.formaPagamento = formaPagamento;
		this.tipoPedido = tipoPedido;
		this.dataFim = dataAluguel;
	}

	public Pedido() {

	}

	// -----------------GETS AND SETERS--------------------
	public int getCodPedido() {
		return codPedido;
	}

	public int getQuantidadeProdutos() {
		return quantidadeProdutos;
	}

	public int getQuantidadeInfraestrutura() {
		return quantidadeInfraestrutura;
	}

	public String getTipoPedido() {
		return tipoPedido;
	}

	public String getDataLocal() {
		return dataInicio;
	}

	public boolean isPedidoConfirmado() {
		return pedidoConfirmado;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public ArrayList<Infraestrutura> getInfraestrutura() {
		return infraestrutura;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
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

	// TRATAMENTO_DE_DADOS------

	/********** VENDA *******************************************/
	public void materializarPedidoVenda(String dados) throws Exception {
		Produto produto = null;
		String vetorString[] = dados.split(";");

		this.codPedido = Integer.parseInt(vetorString[0]);
		this.cliente = new Cliente(vetorString[1], vetorString[2]);
		this.quantidadeProdutos = Integer.parseInt(vetorString[3]);
		for (int i = 0; i < this.quantidadeProdutos; i++) {
			produto = new Produto(vetorString[4 + (i * 5)], vetorString[5 + (i * 5)], vetorString[6 + (i * 5)],
					Float.parseFloat(vetorString[7 + (i * 5)]), Integer.parseInt(vetorString[8 + (i * 5)]));
			produtos.add(produto);
		}
		this.dataInicio = vetorString[vetorString.length - 4];
		this.valorTotal = Float.parseFloat(vetorString[vetorString.length - 3]);
		this.formaPagamento = vetorString[vetorString.length - 2];
		this.pedidoConfirmado = Boolean.parseBoolean(vetorString[vetorString.length - 1]);
	}

	public String desmaterializarVenda(int id) throws Exception {
		id++;
		this.codPedido = id;
		String saida = "";
		saida += this.codPedido + ";";
		saida += this.cliente.getNomeCliente() + ";";
		saida += this.cliente.getCpfCliente() + ";";
		this.quantidadeProdutos = getTamanhoArray(produtos);
		saida += this.quantidadeProdutos + ";";
		for (int posicao = 0; posicao < produtos.size(); posicao++) {
			saida += getProdutoArrayList(posicao).getNomeProduto() + ";";
			saida += getProdutoArrayList(posicao).getTipo() + ";";
			saida += getProdutoArrayList(posicao).getCompatibilidade() + ";";
			saida += getProdutoArrayList(posicao).getValorUnitarioLocacao() + ";";
			saida += getProdutoArrayList(posicao).getQuantidade() + ";";
		}
		saida += this.dataInicio + ";";
		saida += this.valorTotal + ";";
		saida += this.formaPagamento + ";";
		saida += this.pedidoConfirmado + ";";
		return saida;
	}

	public String desmaterializarVenda() throws Exception {
		String saida = "";
		saida += this.codPedido + ";";
		saida += this.cliente.getNomeCliente() + ";";
		saida += this.cliente.getCpfCliente() + ";";
		this.quantidadeProdutos = getTamanhoArray(produtos);
		saida += this.quantidadeProdutos + ";";
		for (int posicao = 0; posicao < produtos.size(); posicao++) {
			saida += getProdutoArrayList(posicao).getNomeProduto() + ";";
			saida += getProdutoArrayList(posicao).getTipo() + ";";
			saida += getProdutoArrayList(posicao).getCompatibilidade() + ";";
			saida += getProdutoArrayList(posicao).getValorUnitarioLocacao() + ";";
			saida += getProdutoArrayList(posicao).getQuantidade() + ";";
		}
		saida += this.dataInicio + ";";
		saida += this.valorTotal + ";";
		saida += this.formaPagamento + ";";
		saida += this.pedidoConfirmado + ";";
		return saida;
	}

	/********** ALUGUEL_PROD *******************************************/
	public void materializarPedidoAluguelProduto(String dados) throws Exception {
		Produto produto = null;
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		String vetorString[] = dados.split(";");

		this.codPedido = Integer.parseInt(vetorString[0]);
		this.cliente = new Cliente(vetorString[1], vetorString[2]);
		this.quantidadeProdutos = Integer.parseInt(vetorString[3]);
		for (int i = 0; i < this.quantidadeProdutos; i++) {
			produto = new Produto(vetorString[4 + (i * 5)], vetorString[5 + (i * 5)], vetorString[6 + (i * 5)],
					Float.parseFloat(vetorString[7 + (i * 5)]), Integer.parseInt(vetorString[8 + (i * 5)]));
			produtos.add(produto);
		}
		this.dataInicio = vetorString[vetorString.length - 4];
		this.valorTotal = Float.parseFloat(vetorString[vetorString.length - 3]);
		this.formaPagamento = vetorString[vetorString.length - 2];
		this.pedidoConfirmado = Boolean.parseBoolean(vetorString[vetorString.length - 1]);
	}

	public String desmaterializarAluguelProduto(int id) throws Exception {
		id++;
		this.codPedido = id;
		String saida = "";
		saida += this.codPedido + ";";
		saida += this.cliente.getNomeCliente() + ";";
		saida += this.cliente.getCpfCliente() + ";";
		this.quantidadeProdutos = getTamanhoArray(produtos);
		saida += this.quantidadeProdutos + ";";
		for (int posicao = 0; posicao < produtos.size(); posicao++) {
			saida += getProdutoArrayList(posicao).getNomeProduto() + ";";
			saida += getProdutoArrayList(posicao).getTipo() + ";";
			saida += getProdutoArrayList(posicao).getCompatibilidade() + ";";
			saida += getProdutoArrayList(posicao).getValorUnitarioLocacao() + ";";
			saida += getProdutoArrayList(posicao).getQuantidade() + ";";
		}
		saida += this.dataInicio + ";";
		saida += this.valorTotal + ";";
		saida += this.formaPagamento + ";";
		saida += this.pedidoConfirmado + ";";
		return saida;
	}

	public String desmaterializarAluguelProduto() throws Exception {
		String saida = "";
		saida += this.codPedido + ";";
		saida += this.cliente.getNomeCliente() + ";";
		saida += this.cliente.getCpfCliente() + ";";
		this.quantidadeProdutos = getTamanhoArray(produtos);
		saida += this.quantidadeProdutos + ";";
		for (int posicao = 0; posicao < produtos.size(); posicao++) {
			saida += getProdutoArrayList(posicao).getNomeProduto() + ";";
			saida += getProdutoArrayList(posicao).getTipo() + ";";
			saida += getProdutoArrayList(posicao).getCompatibilidade() + ";";
			saida += getProdutoArrayList(posicao).getValorUnitarioLocacao() + ";";
			saida += getProdutoArrayList(posicao).getQuantidade() + ";";
		}
		saida += this.dataInicio + ";";
		saida += this.valorTotal + ";";
		saida += this.formaPagamento + ";";
		saida += this.pedidoConfirmado + ";";
		return saida;
	}

	/********** ALUGUEL_INFRA *******************************************/
	public void materializarPedidoAluguelInfra(String dados) throws Exception {
		Infraestrutura infra = null;
		SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
		String vetorString[] = dados.split(";");

		this.codPedido = Integer.parseInt(vetorString[0]);
		this.quantidadeInfraestrutura = Integer.parseInt(vetorString[1]);
		for (int i = 0; i < this.quantidadeInfraestrutura; i++) {
			// infra = new Infraestrutura(vetorString[2 + (i * 4)],
			// Float.parseFloat(vetorString[3 + (i * 4)]),
			// formatoData.parse(vetorString[4 + (i * 4)]), formatoData.parse(vetorString[5
			// + (i * 4)]));
			infraestrutura.add(infra);
		}
		this.valorTotal = Float.parseFloat(vetorString[vetorString.length - 3]);
		this.formaPagamento = vetorString[vetorString.length - 2];
		this.pedidoConfirmado = Boolean.parseBoolean(vetorString[vetorString.length - 1]);
	}

	public String desmaterializarAluguelInfra(int id) throws Exception {
		id++;
		this.codPedido = id;
		String saida = "";
		saida += this.codPedido + ";";
		this.quantidadeInfraestrutura = getTamanhoArray(infraestrutura);
		saida += this.quantidadeInfraestrutura + ";";
		for (int posicao = 0; posicao < infraestrutura.size(); posicao++) {
			saida += getInfraArrayList(posicao).getNomeInfraestrutura() + ";";
			saida += getInfraArrayList(posicao).getPrecoDiaInfraestrutura() + ";";
//			saida += getInfraArrayList(posicao).getDataInicio() + ";";
			// saida += getInfraArrayList(posicao).getDataFim() + ";";
		}
		saida += this.valorTotal + ";";
		saida += this.formaPagamento + ";";
		saida += this.pedidoConfirmado + ";";
		return saida;
	}

	public String desmaterializarAluguelInfra() throws Exception {
		String saida = "";
		saida += this.codPedido + ";";
		this.quantidadeInfraestrutura = getTamanhoArray(infraestrutura);
		saida += this.quantidadeInfraestrutura + ";";
		for (int posicao = 0; posicao < infraestrutura.size(); posicao++) {
			saida += getInfraArrayList(posicao).getNomeInfraestrutura() + ";";
			saida += getInfraArrayList(posicao).getPrecoDiaInfraestrutura() + ";";
			// saida += getInfraArrayList(posicao).getDataInicio() + ";";
			// saida += getInfraArrayList(posicao).getDataFim() + ";";
		}
		saida += this.valorTotal + ";";
		saida += this.formaPagamento + ";";
		saida += this.pedidoConfirmado + ";";
		return saida;
	}

}