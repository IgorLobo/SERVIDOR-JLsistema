package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.util.Janela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class TelaProdutoController implements Initializable{

//************************ ATRIBUTOS ********************************
	private Janela utilJanela = new Janela();
	
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
    private GridPane gridPane_produtos;

    

//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}
	@FXML
    void OnClick_btn_alterar(ActionEvent event) {

    }

    @FXML
    void OnClick_btn_excluir(ActionEvent event) {

    }

    @FXML
    void OnClick_btn_incluir(ActionEvent event) {
    	utilJanela.novaJanelaComOwner("/br/view/TelaProdutoIncluir.fxml", false);
    }

    @FXML
    void OnClick_btn_observacao(ActionEvent event) {

    }

//************************** METODOS AUXILIARES *********************


}
