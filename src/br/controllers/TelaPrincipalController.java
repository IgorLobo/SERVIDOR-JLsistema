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

public class TelaPrincipalController implements Initializable {
//************************ ATRIBUTOS ********************************
	private Janela utilJanela = new Janela();
	private Thread servidorON = null;
	public static Servidor servidor = null;
	public static String caminhoTxtBancoDados = "C:\\Projetos\\Faculdade\\SERVIDOR-JLsistema\\src\\br\\arquivos\\";

//*********************** COMPONENTES *******************************	
	// Toolbar--
	@FXML
	private Button tbBtn_clientes;

	@FXML
	private Button tbBtn_produtos;

	@FXML
    private Button tbBtn_pedidos;

	@FXML
    private Button tbBtn_infra;

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

    @FXML
    void OnClick_tbBtn_pedidos(ActionEvent event) {
    	utilJanela.novaJanelaComOwner("/br/view/TelaPedidoEscolherCliente.fxml", true);
    }
    
    @FXML
    void OnClick_tbBtn_Infra(ActionEvent event) {
    	
    	utilJanela.novaJanelaComOwner("/br/view/TelaInfra.fxml", true);
    }

	@FXML
	void OnClick_tbBtn_produtos(ActionEvent event) {
		utilJanela.novaJanelaComOwner("/br/view/TelaProduto.fxml", true);
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
