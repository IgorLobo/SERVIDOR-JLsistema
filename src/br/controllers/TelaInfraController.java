package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.model.Infraestrutura;
import br.util.Janela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TelaInfraController implements Initializable {
//************************ ATRIBUTOS ********************************
	Janela utilJanela = new Janela();

//*********************** COMPONENTES *******************************	
	@FXML
    private TableView<Infraestrutura> tableView_cliente;

    @FXML
    private TableColumn<Infraestrutura, Integer> tc_ID;

    @FXML
    private TableColumn<Infraestrutura, String> tc_nome;

    @FXML
    private TableColumn<Infraestrutura, String> tc_descricao;

    @FXML
    private TableColumn<Infraestrutura, Integer> tc_precoDia;

    @FXML
    private Button btn_observacao;

    @FXML
    private Button btn_excluir;

    @FXML
    private Button btn_alterar;

    @FXML
    private Button btn_incluir;

   
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
    	utilJanela.novaJanelaComOwner("/br/view/TelaInfraIncluir.fxml", false);
    }

    @FXML
    void OnClick_btn_observacao(ActionEvent event) {

    }


//************************** METODOS AUXILIARES *********************

}
