package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class TelaPrincipalController implements Initializable {
//************************ ATRIBUTOS ********************************
	
	
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
		 
	 }
	
//************************** METODOS AUXILIARES *********************

}
