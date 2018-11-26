package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.util.MaskTextfield;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TelaProdutoIncluirController implements Initializable{
	
//************************ ATRIBUTOS ********************************
	
	
//*********************** COMPONENTES *******************************	
	@FXML
    private ComboBox<String> cb_tipo;

    @FXML
    private ComboBox<String> cb_compatibilidade;
	
	@FXML
    private TextField txf_nome;

    @FXML
    private TextField txf_fabricante;

    @FXML
    private TextField txf_precoVenda;

    @FXML
    private TextField txf_precoLocacao;

    @FXML
    private Label lb_nrSerie;

    @FXML
    private TextField txf_nrSerie;

    @FXML
    private TextArea txa_descricao;

    @FXML
    private Button btn_cancelar;

    @FXML
    private Button btn_salvar;

//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararComponentes();
	}
	
	@FXML
    void OnClick_btn_cancelar(ActionEvent event) {

    }

    @FXML
    void OnClick_btn_salvar(ActionEvent event) {

    }

//************************** METODOS AUXILIARES *********************

	 private void prepararComponentes() {
		 cb_tipo.setItems(FXCollections.observableArrayList("Jogo","Acessorio","Console"));
		 MaskTextfield.monetaryField(txf_precoLocacao);
		 MaskTextfield.monetaryField(txf_precoVenda);
		 MaskTextfield.campoNumerico(txf_nrSerie);
		 
	 }

	    
}
