package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TelaClienteIncluirController implements Initializable{

//************************ ATRIBUTOS ********************************
	String nomeArquivo ="scr/br.arquivos/Cliente.csv";
	

//*********************** COMPONENTES *******************************	
	@FXML
    private TextField txf_nome;

    @FXML
    private TextField txf_CPF;

    @FXML
    private TextField txf_CEP;

    @FXML
    private ComboBox<String> cb_estados;

    @FXML
    private TextField txf_cidade;

    @FXML
    private TextField txf_setor;

    @FXML
    private TextField txf_edereco;

    @FXML
    private TextField txf_complemento;

    @FXML
    private TextField txf_telefone;

    @FXML
    private TextField txf_telefoneSecundario;

    @FXML
    private TextField txf_email;

    @FXML
    private TextField txf_emailSecundario;

    @FXML
    private Button btn_cancelar;

    @FXML
    private Button btn_salvar;


//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cb_estados.setItems(FXCollections.observableArrayList("AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO", "MA", "MG", "MS",
				"MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO"));
	}

    @FXML
    void OnClick_btn_cancelar(ActionEvent event) {

    }

    @FXML
    void OnClick_btn_salvar(ActionEvent event) {
    	
    }
//************************** METODOS AUXILIARES *********************

}
