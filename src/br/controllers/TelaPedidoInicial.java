package br.controllers;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import br.model.Pedido;
import br.util.Janela;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaPedidoInicial implements Initializable{
//************************ ATRIBUTOS ********************************
	private Janela janelaUtil = new Janela();
	ObservableList<Pedido> obsPedidos;
//*********************** COMPONENTES *******************************	
    @FXML
    private TableView<Pedido> tableView_pedidos;

    @FXML
    private TableColumn<Pedido, Integer> tc_ID;

    @FXML
    private TableColumn<Pedido, Date> tc_data;

    @FXML
    private TableColumn<Pedido, String> tc_cliente;

    @FXML
    private TableColumn<Pedido, String> tc_tipoDoPedido;

    @FXML
    private TableColumn<Pedido, Float> tc_valorTotal;

    @FXML
    private TableColumn<Pedido, String> tc_finalizado;

    @FXML
    private Button btn_datalhe;

    @FXML
    private Button btn_alterar;

    @FXML
    private Button btn_incluir;

    @FXML
    private ComboBox<String> cb_tipo;

    @FXML
    private ComboBox<String> cb_pagamento;

    @FXML
    private Button btn_excluir;


//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararComponentes();
		try {
			//obsPedidos =  FXCollections.observableArrayList(new PedidoVendaDAO(TelaPrincipalController.nomeArquivoPedidoVenda).listarPedidos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

    @FXML
    void OnClick_btn_alterar(ActionEvent event) {

    }

    @FXML
    void OnClick_btn_detalhe(ActionEvent event) {

    }

    @FXML
    void OnClick_btn_excluir(ActionEvent event) {

    }

    @FXML
    void OnClick_btn_incluir(ActionEvent event) {
    	janelaUtil.novaJanelaComOwner("/br/view/TelaPedidoEscolherCliente.fxml", false,"Escolha um cliente");
    	br.util.Janela.fecharJanela(btn_incluir);
    }

//************************** METODOS AUXILIARES *********************
    private void prepararComponentes() {
		tc_ID.setCellValueFactory(new PropertyValueFactory<>("codPedido"));
		tc_data.setCellValueFactory(new PropertyValueFactory<>("dataLocal"));
		tc_cliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
		tc_valorTotal.setCellValueFactory(new PropertyValueFactory<>("codCliente"));
		tc_tipoDoPedido.setCellValueFactory(new PropertyValueFactory<>("tipoPedido"));
		tc_finalizado.setCellValueFactory(new PropertyValueFactory<>("pedidoConfirmado"));
		
		tableView_pedidos.setItems(obsPedidos);
    }

}
