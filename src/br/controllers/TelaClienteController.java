package br.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.model.Cliente;
import br.persistencia.ClienteDAO;
import br.util.Janela;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaClienteController implements Initializable {
//************************ ATRIBUTOS ********************************
	private Janela utilJanela = new Janela();
	String nomeArquivo = "C:\\Projetos\\SERVIDOR-JLsistema\\src\\br\\arquivos\\Cliente.csv";

//*********************** COMPONENTES *******************************	

	@FXML
	private Button btn_incluir;

	@FXML
	private Button btn_alterar;

	@FXML
	private Button btn_excluir;

	@FXML
	private Button btn_observacao;

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

//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararTableView();
		listar();
	}

	@FXML
	void OnClick_btn_alterar(ActionEvent event) {
		try {
			ArrayList<Cliente> listaDeClientes;
			ClienteDAO clienteDAO = new ClienteDAO(nomeArquivo);
			Cliente cliente = tableView_cliente.getSelectionModel().getSelectedItem();
			//utilJanela.novaJanelaComOwner("/br/view/TelaClienteIncluir.fxml", cliente, false);
			listar();
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	@FXML
	void OnClick_btn_excluir(ActionEvent event) {
		try {
			ArrayList<Cliente> listaDeClientes;
			ClienteDAO clienteDAO = new ClienteDAO(nomeArquivo);
			Cliente cliente = tableView_cliente.getSelectionModel().getSelectedItem();
			clienteDAO.excluir(cliente.getCodCliente());
			listar();
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	@FXML
	void OnClick_btn_incluir(ActionEvent event) {
		utilJanela.novaJanelaComOwner("/br/view/TelaClienteIncluir.fxml", false);
	}

	@FXML
	void OnClick_btn_observacao(ActionEvent event) {
		listar();
	}

//************************** METODOS AUXILIARES *********************
	private void listar() {
		try {
			ArrayList<Cliente> listaDeClientes;
			ClienteDAO clienteDAO = new ClienteDAO(nomeArquivo);
			listaDeClientes = clienteDAO.listar();
			tableView_cliente.setItems(FXCollections.observableArrayList(listaDeClientes));
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void prepararTableView() {
		tc_ID.setCellValueFactory(new PropertyValueFactory<>("codCliente"));
		tc_nome.setCellValueFactory(new PropertyValueFactory<>("nomeCliente"));
		tc_email.setCellValueFactory(new PropertyValueFactory<>("email1Cliente"));
		tc_telefone.setCellValueFactory(new PropertyValueFactory<>("telefone1Cliente"));
	}
}
