package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.model.Pedido;
import br.persistencia.PedidoAluguelProdutoDAO;
import br.persistencia.PedidoVendaDAO;
import br.util.Janela;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaPedidoInicial implements Initializable {
//************************ ATRIBUTOS ********************************
	private Janela janelaUtil = new Janela();
	ObservableList<Pedido> obsLoc;
	ObservableList<Pedido> obsVenda;
	static Pedido pedidoSelecionado;
//*********************** COMPONENTES *******************************	
//venda	 	
	@FXML
	private TitledPane paneVenda;

	@FXML
	private TableView<Pedido> tvVenda;

	@FXML
	private TableColumn<Pedido, Integer> tvVenda_ID;

	@FXML
	private TableColumn<Pedido, String> tvVenda_data;

	@FXML
	private TableColumn<Pedido, String> tvVenda_cliente;

	@FXML
	private TableColumn<Pedido, Float> tvVenda_valorTotal;

	@FXML
	private TableColumn<Pedido, Float> tvVenda_pagamento;

	@FXML
	private TableColumn<Pedido, Boolean> tvVenda_finalizado;
//LOCAÇAO
	@FXML
	private TitledPane paneLoc;

	@FXML
	private TableView<Pedido> tvLoc;

	@FXML
	private TableColumn<Pedido, Integer> tvLoc_ID;

	@FXML
	private TableColumn<Pedido, String> tvLoc_dataInicio;
	
	@FXML
	private TableColumn<Pedido, String> tvLoc_dataFinal;

	@FXML
	private TableColumn<Pedido, String> tvLoc_cliente;

	@FXML
	private TableColumn<Pedido, Float> tvLoc_valorTotal;

	@FXML
	private TableColumn<Pedido, String> tvLoc_pagamento;

	@FXML
	private TableColumn<Pedido, Boolean> tvLoc_finalizado;

	@FXML
	private Button btn_datalhe;

	@FXML
	private Button btn_alterar;

	@FXML
	private Button btn_incluir;

	@FXML
	private Button btn_excluir;

//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			prepararComponentes();
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@FXML
	void OnClick_btn_alterar(ActionEvent event) {
		
	}

	@FXML
	void OnClick_btn_detalhe(ActionEvent event) {
		janelaUtil.novaJanelaComOwnerWait("/br/view/TelaPedidoDetalhes.fxml", false, "Detalhes do pedido");
	}

	@FXML
	void OnClick_btn_excluir(ActionEvent event) {
		try {
			if (paneVenda.isExpanded() && !tvVenda.getSelectionModel().isEmpty()) {
				new PedidoVendaDAO(TelaPrincipalController.nomeArquivoPedidoVenda)
						.excluirPedido(tvVenda.getSelectionModel().getSelectedItem().getCodPedido());
				tvVenda.setItems(FXCollections.observableArrayList(
						new PedidoVendaDAO(TelaPrincipalController.nomeArquivoPedidoVenda).listarPedidos()));
			}
			if (paneLoc.isExpanded() && !tvLoc.getSelectionModel().isEmpty()) {
				new PedidoAluguelProdutoDAO(TelaPrincipalController.nomeArquivoPedidoLocProdutos)
						.excluirPedido(tvLoc.getSelectionModel().getSelectedItem().getCodPedido());
				tvLoc.setItems(FXCollections.observableArrayList(
						new PedidoAluguelProdutoDAO(TelaPrincipalController.nomeArquivoPedidoLocProdutos)
								.listarPedidos()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	void OnClick_btn_incluir(ActionEvent event) {
		janelaUtil.novaJanelaComOwner("/br/view/TelaPedidoEscolherCliente.fxml", false, "Escolha um cliente");
		br.util.Janela.fecharJanela(btn_incluir);
	}

//************************** METODOS AUXILIARES *********************
	private void prepararComponentes() {
		try {
		tvLoc_cliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
		tvLoc_dataInicio.setCellValueFactory(new PropertyValueFactory<>("dataInicio"));
		tvLoc_dataFinal.setCellValueFactory(new PropertyValueFactory<>("dataFim"));
		tvLoc_ID.setCellValueFactory(new PropertyValueFactory<>("codPedido"));
		tvLoc_valorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
		tvLoc_pagamento.setCellValueFactory(new PropertyValueFactory<>("formaPagamento"));
		tvLoc_finalizado.setCellValueFactory(new PropertyValueFactory<>("pedidoConfirmado"));

		tvVenda_cliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
		tvVenda_data.setCellValueFactory(new PropertyValueFactory<>("dataInicio"));
		tvVenda_ID.setCellValueFactory(new PropertyValueFactory<>("codPedido"));
		tvVenda_valorTotal.setCellValueFactory(new PropertyValueFactory<>("valorTotal"));
		tvVenda_pagamento.setCellValueFactory(new PropertyValueFactory<>("formaPagamento"));
		tvVenda_finalizado.setCellValueFactory(new PropertyValueFactory<>("pedidoConfirmado"));

		obsVenda = FXCollections.observableArrayList(
				new PedidoVendaDAO(TelaPrincipalController.nomeArquivoPedidoVenda).listarPedidos());
		obsLoc = FXCollections.observableArrayList(
				new PedidoAluguelProdutoDAO(TelaPrincipalController.nomeArquivoPedidoLocProdutos).listarPedidos());
		
		tvLoc.setItems(obsLoc);
		tvVenda.setItems(obsVenda);
		
		tvLoc.getSelectionModel().selectedItemProperty()
		.addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				pedidoSelecionado = newSelection;
			}
		});
		
		tvVenda.getSelectionModel().selectedItemProperty()
		.addListener((obs, oldSelection, newSelection) -> {
			if (newSelection != null) {
				pedidoSelecionado = newSelection;
			}
		});
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
