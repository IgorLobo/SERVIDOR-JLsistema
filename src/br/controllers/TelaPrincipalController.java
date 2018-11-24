package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.connection.Servidor;
import br.util.Janela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class TelaPrincipalController implements Initializable {
//************************ ATRIBUTOS ********************************
	private Janela utilJanela = new Janela();
	private Thread servidorON = null;
	public static Servidor servidor = null;

//*********************** COMPONENTES *******************************	
	// Toolbar--
	@FXML
	private Button tbBtn_clientes;

	@FXML
	private ImageView tbBtn_produtos;

	// --
//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		iniciarServidor();
	}

	@FXML
	void OnClick_tbBtn_clientes(ActionEvent event) {
		utilJanela.novaJanelaComOwner("/br/view/TelaCliente.fxml", true);
		//System.out.println(servidor.getClientUsers());
	}

//************************** METODOS AUXILIARES *********************
	private void iniciarServidor() {
		servidor = new Servidor(5555);
		servidorON = new Thread(){
			@Override
			public void run() {
				try { 
					servidor.startServer();					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
					e.getMessage();
				}
			}
		};
		servidorON.start();
	}

}
