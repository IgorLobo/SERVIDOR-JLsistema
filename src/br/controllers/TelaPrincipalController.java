package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.connection.Servidor;
import br.util.Janela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;

public class TelaPrincipalController implements Initializable {
//************************ ATRIBUTOS ********************************
	private Janela utilJanela = new Janela();
	private Thread servidorStart = null;
	public static boolean servidorON = false;
	public static Servidor servidor = null;

	public static String caminhoTxtBancoDados = "C:\\Projetos\\SERVIDOR-JLsistema\\src\\br\\arquivos\\";
	public static String nomeArquivoCliente = caminhoTxtBancoDados + "Clientes.csv";
	public static String nomeArquivoJogos = caminhoTxtBancoDados + "Jogos.csv";
	public static String nomeArquivoAcessorios = caminhoTxtBancoDados + "Acessorios.csv";
	public static String nomeArquivoConsoles = caminhoTxtBancoDados + "Consoles.csv";
	public static String nomeArquivoJogosLoc = caminhoTxtBancoDados + "JogosLoc.csv";
	public static String nomeArquivoAcessoriosLoc = caminhoTxtBancoDados + "AcessoriosLoc.csv";
	public static String nomeArquivoConsolesLoc = caminhoTxtBancoDados + "ConsolesLoc.csv";
	public static String nomeArquivoPedidoVenda = caminhoTxtBancoDados + "PedidosVenda.csv";
	public static String nomeArquivoPedidoLocProdutos = caminhoTxtBancoDados + "PedidosLocProduto.csv";
	public static String nomeArquivoInfra = caminhoTxtBancoDados + "Infraestruturas.csv";
	public static String nomeArquivoPedidoLocInfra = caminhoTxtBancoDados + "PedidosLocInfraestruturas.csv";
	public static String nomeArquivoDataLocInfraestrutura = caminhoTxtBancoDados + "DataLocInfraestrutura.csv";
	public static String ids = caminhoTxtBancoDados + "Ids.csv";

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

	@FXML
	private Button btn_estoque;

	@FXML
	private Button btn_configuracoes;

	// --
//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

	@FXML
	void OnClick_btn_configuracoes(ActionEvent event) {
		if (servidorON) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atenção");
			alert.setHeaderText(null);
			alert.setContentText("Servidor configurado e online");
			alert.show();
		} else {
			utilJanela.novaJanelaComOwnerWait("/br/view/TelaConfiguracao.fxml", false, "Configurações");
			if (servidorON) {
				iniciarServidor();
			}
		}
	}

	@FXML
	void OnClick_tbBtn_clientes(ActionEvent event) {
		utilJanela.novaJanelaComOwner("/br/view/TelaCliente.fxml", true, "Gerenciar clientes");
	}

	@FXML
	void OnClick_tbBtn_pedidos(ActionEvent event) {
		utilJanela.novaJanelaComOwner("/br/view/TelaPedidoInicial.fxml", true, "Fazer pedido");
	}

	@FXML
	void OnClick_tbBtn_Infra(ActionEvent event) {
		utilJanela.novaJanelaComOwner("/br/view/TelaInfra.fxml", true, "Gerenciar infraestrutura");
	}

	@FXML
	void OnClick_tbBtn_produtos(ActionEvent event) {
		utilJanela.novaJanelaComOwner("/br/view/TelaProduto.fxml", true, "Gerenciar produtos");
	}

	@FXML
	void OnClick_btn_estoque(ActionEvent event) {
		utilJanela.novaJanelaComOwner("/br/view/TelaEstoque.fxml", false, "Estoque da loja");
	}

//************************** METODOS AUXILIARES *********************
	private void iniciarServidor() {
		servidor = new Servidor(TelaConfiguracaoController.porta);
		servidorStart = new Thread() {
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
		servidorStart.start();
	}

}
