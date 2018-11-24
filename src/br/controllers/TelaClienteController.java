package br.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.model.Cliente;
import br.persistencia.ClienteDAO;
import br.util.Janela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

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
	private GridPane gridPane_clientes;

//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void OnClick_btn_alterar(ActionEvent event) {

	}

	@FXML
	void OnClick_btn_excluir(ActionEvent event) {
		listar();
	}

	@FXML
	void OnClick_btn_incluir(ActionEvent event) {
		utilJanela.novaJanelaComOwner("/br/view/TelaClienteIncluir.fxml", false);
	}

//************************** METODOS AUXILIARES *********************
	private void listar() {
		try {
		

			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
