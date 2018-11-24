package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.util.Janela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class TelaPrincipalController implements Initializable {
//************************ ATRIBUTOS ********************************
	private Janela utilJanela = new Janela();
	
//*********************** COMPONENTES *******************************	
	//Toolbar--
    @FXML
    private Button tbBtn_clientes;

    @FXML
    private ImageView tbBtn_produtos;
    //--
//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
	}
	
	 @FXML
	 void OnClick_tbBtn_clientes(ActionEvent event) {
		  utilJanela.novaJanelaComOwner("/br/view/TelaCliente.fxml", true);
		
	 }
	
//************************** METODOS AUXILIARES *********************

}
