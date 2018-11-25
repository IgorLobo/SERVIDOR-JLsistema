package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.model.Cliente;
import br.util.Janela;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TelaPedidoEscolherClienteController implements Initializable {
//************************ ATRIBUTOS ********************************
	private Janela janelaUtil = new Janela();
//*********************** COMPONENTES *******************************	
			
	 @FXML
	    private TableView<Cliente> tableView_cliente;

	    @FXML
	    private TableColumn<Cliente, Integer> tc_ID;

	    @FXML
	    private TableColumn<Cliente, String> tc_nome;

	    @FXML
	    private TableColumn<Cliente, String> tc_email;

	    @FXML
	    private TableColumn<Cliente, String> tc_telefone;

	    @FXML
	    private ComboBox<String> cb_tipo;
	    @FXML
	    private ComboBox<String> cb_pagamento;

	    @FXML
	    private Button btn_abrirPedido;

	    @FXML
	    private Button btn_cancelar;
//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararTableView();
		cb_tipo.setItems(FXCollections.observableArrayList("Venda","Locação"));
		cb_pagamento.setItems(FXCollections.observableArrayList("Dinheiro","Cartão"));
	}
	
	@FXML
    void OnClick_btn_abrirPedido(ActionEvent event) {
		if(!cb_tipo.getSelectionModel().isEmpty() && !cb_pagamento.getSelectionModel().isEmpty()){
			if(cb_tipo.getSelectionModel().getSelectedItem().toString().equals("Venda")) janelaUtil.novaJanelaComOwner("/br/view/TelaPedidoVenda.fxml", false);
			if(cb_tipo.getSelectionModel().getSelectedItem().toString().equals("Locação")) janelaUtil.novaJanelaComOwner("/br/view/TelaPedidoLoc.fxml", false);
			Stage stage = (Stage)btn_abrirPedido.getScene().getWindow();
			stage.close();
		}else {
			
		}
	}

    @FXML
    void OnClick_btn_cancelar(ActionEvent event) {

    }


//************************** METODOS AUXILIARES *********************
    private void prepararTableView() {
		tc_ID.setCellValueFactory(new PropertyValueFactory<>("codCliente"));
		tc_nome.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
		tc_email.setCellValueFactory(new PropertyValueFactory<>("email1Cliente"));
		tc_telefone.setCellValueFactory(new PropertyValueFactory<>("telefone1Cliente"));
	}
}
