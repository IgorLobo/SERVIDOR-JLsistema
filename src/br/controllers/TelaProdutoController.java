package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.model.Produto;
import br.persistencia.ProdutoDAO;
import br.util.Janela;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaProdutoController implements Initializable{

//************************ ATRIBUTOS ********************************
	private Janela utilJanela = new Janela();
	static String operacao;
	static Produto produtoSelecionado;
//*********************** COMPONENTES *******************************	
		@FXML
	    private TitledPane paneAcessorios;
	
		@FXML
	    private TitledPane paneJogos;
	
		@FXML
	    private TitledPane paneConsoles;
	
		@FXML
	    private Button btn_incluir;

	    @FXML
	    private Button btn_alterar;

	    @FXML
	    private Button btn_excluir;

	    @FXML
	    private Button btn_observacao;

	    @FXML
	    private TableView<Produto> tv_jogos;

	    @FXML
	    private TableColumn<Produto, String> tv_jogos_tcNome;

	    @FXML
	    private TableColumn<Produto, String> tv_jogos_tcCompatibilidade;

	    @FXML
	    private TableColumn<Produto, Double> tv_jogos_tcValVenda;

	    @FXML
	    private TableColumn<Produto, Double> tv_jogos_tcValLoc;

	    @FXML
	    private TableView<Produto> tv_acessorios;

	    @FXML
	    private TableColumn<Produto, String> tv_acessorios_tcNome;

	    @FXML
	    private TableColumn<Produto, String> tv_acessorios_tcCompatibilidade;

	    @FXML
	    private TableColumn<Produto, String> tv_acessorios_fabricante;

	    @FXML
	    private TableColumn<Produto, Double> tv_acessorios_tcValVenda;

	    @FXML
	    private TableColumn<Produto, Double> tv_acessorios_tcValLoc;

	    @FXML
	    private TableView<Produto> tv_consoles;

	    @FXML
	    private TableColumn<Produto, String> tv_consoles_tcNome;

	    @FXML
	    private TableColumn<Produto, String> tv_consoles_fabricante;

	    @FXML
	    private TableColumn<Produto, Double> tv_consoles_tcValVenda;

	    @FXML
	    private TableColumn<Produto, Double> tv_consoles_tcValLoc;

//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararTableViews();
		listar();
	}
	@FXML
    void OnClick_btn_alterar(ActionEvent event) {
		try {
			operacao = "alterar";
			if (paneJogos.isExpanded() && !tv_jogos.getSelectionModel().isEmpty()) {
				produtoSelecionado = tv_jogos.getSelectionModel().getSelectedItem();
				utilJanela.novaJanelaComOwnerWait("/br/view/TelaProdutoIncluir.fxml", false, "Alterar produto");
				listar();
			} else if (paneAcessorios.isExpanded() && !tv_acessorios.getSelectionModel().isEmpty()) {
				produtoSelecionado = tv_acessorios.getSelectionModel().getSelectedItem();
				utilJanela.novaJanelaComOwnerWait("/br/view/TelaProdutoIncluir.fxml", false, "Alterar produto");
				listar();
			} else if (paneConsoles.isExpanded() && !tv_consoles.getSelectionModel().isEmpty()) {
				produtoSelecionado = tv_consoles.getSelectionModel().getSelectedItem();
				utilJanela.novaJanelaComOwnerWait("/br/view/TelaProdutoIncluir.fxml", false, "Alterar produto");
				listar();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Atenção");
				alert.setHeaderText(null);
				alert.setContentText("Escolha um produto!");
				alert.show();
			} 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }

    @FXML
    void OnClick_btn_excluir(ActionEvent event) {
    	try {
			if (paneJogos.isExpanded() && !tv_jogos.getSelectionModel().isEmpty()) {
				new ProdutoDAO(TelaPrincipalController.nomeArquivoJogos).excluirProduto(tv_jogos.getSelectionModel().getSelectedItem().getCodProduto());
				new ProdutoDAO(TelaPrincipalController.nomeArquivoJogosLoc).excluirProduto(tv_jogos.getSelectionModel().getSelectedItem().getCodProduto());
				listar();
			} else if (paneAcessorios.isExpanded() && !tv_acessorios.getSelectionModel().isEmpty()) {
				new ProdutoDAO(TelaPrincipalController.nomeArquivoAcessorios).excluirProduto(tv_acessorios.getSelectionModel().getSelectedItem().getCodProduto());
				new ProdutoDAO(TelaPrincipalController.nomeArquivoAcessoriosLoc).excluirProduto(tv_acessorios.getSelectionModel().getSelectedItem().getCodProduto());
				listar();
			} else if (paneConsoles.isExpanded() && !tv_consoles.getSelectionModel().isEmpty()) {
				new ProdutoDAO(TelaPrincipalController.nomeArquivoConsoles).excluirProduto(tv_consoles.getSelectionModel().getSelectedItem().getCodProduto());
				new ProdutoDAO(TelaPrincipalController.nomeArquivoConsolesLoc).excluirProduto(tv_consoles.getSelectionModel().getSelectedItem().getCodProduto());
				listar();
			} else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Atenção");
				alert.setHeaderText(null);
				alert.setContentText("Escolha um produto!");
				alert.show();
			} 
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }

    @FXML
    void OnClick_btn_incluir(ActionEvent event) {
    	operacao = "incluir";
    	utilJanela.novaJanelaComOwnerWait("/br/view/TelaProdutoIncluir.fxml", false, "Cadastrar produto");
    	if(operacao.equals("ok"))listar();
    }

    @FXML
    void OnClick_btn_observacao(ActionEvent event) {

    }

//************************** METODOS AUXILIARES *********************
    private void prepararTableViews() {
    	tv_jogos_tcNome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	tv_jogos_tcCompatibilidade.setCellValueFactory(new PropertyValueFactory<>("compatibilidade"));
    	tv_jogos_tcValVenda.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioVenda"));
    	tv_jogos_tcValLoc.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioLocacao"));
    	
    	tv_acessorios_tcNome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	tv_acessorios_fabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
    	tv_acessorios_tcCompatibilidade.setCellValueFactory(new PropertyValueFactory<>("compatibilidade"));
    	tv_acessorios_tcValLoc.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioLocacao"));
    	tv_acessorios_tcValVenda.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioVenda"));
    	
    	tv_consoles_tcNome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	tv_consoles_fabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
    	tv_consoles_tcValLoc.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioLocacao"));
    	tv_consoles_tcValVenda.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioVenda"));
    	
    	
    }

    private void listar() {
    	try {
    	tv_jogos.setItems(FXCollections.observableArrayList(new ProdutoDAO(TelaPrincipalController.nomeArquivoJogos).listarProdutos()));
    	tv_acessorios.setItems(FXCollections.observableArrayList(new ProdutoDAO(TelaPrincipalController.nomeArquivoAcessorios).listarProdutos()));
    	tv_consoles.setItems(FXCollections.observableArrayList(new ProdutoDAO(TelaPrincipalController.nomeArquivoConsoles).listarProdutos()));
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
