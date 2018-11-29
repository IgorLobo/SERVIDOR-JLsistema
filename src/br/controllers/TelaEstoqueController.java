package br.controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.model.Produto;
import br.persistencia.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaEstoqueController implements Initializable{

//************************ ATRIBUTOS ********************************
	
	String nomeArquivoConsoles = TelaPrincipalController.caminhoTxtBancoDados + "Consoles.csv";
	String nomeArquivoJogos = TelaPrincipalController.caminhoTxtBancoDados + "Jogos.csv";
	String nomeArquivoAcessorios = TelaPrincipalController.caminhoTxtBancoDados + "Acessorios.csv";
	
//*********************** COMPONENTES *******************************	
	  	
		@FXML
		private TextField txf_qnt;

		@FXML
	    private Button btn_adicionar;

	    @FXML
	    private Button btn_cancelar;

//TABELA DE VENDAS
	    @FXML
	    private TitledPane paneVenda;

	    @FXML
	    private TitledPane paneVendaJogos;
	    
	    @FXML
	    private TitledPane paneVendaAcessorios;
	    
	    @FXML
	    private TitledPane paneVendaConsoles;
	    
	    @FXML
	    private TableView<Produto> venda_tvJogos;

	    @FXML
	    private TableColumn<Produto, String> venda_tvJogos_tcNome;

	    @FXML
	    private TableColumn<Produto, String> venda_tvJogos_tcCompatibilidade;

	    @FXML
	    private TableColumn<Produto, Integer> venda_tvJogos_quantidade;

	    @FXML
	    private TableView<Produto> venda_tvAcessorios;

	    @FXML
	    private TableColumn<Produto, String> venda_tvAcessorios_tcNome;

	    @FXML
	    private TableColumn<Produto, String> venda_tvAcessorios_tcCompatibilidade;

	    @FXML
	    private TableColumn<Produto, String> venda_tvAcessorios_fabricante;

	    @FXML
	    private TableColumn<Produto, Integer> venda_tvAcessorios_quantidade;

	    @FXML
	    private TableView<Produto> venda_tvConsoles;

	    @FXML
	    private TableColumn<Produto, String> venda_tvConsoles_tcNome;

	    @FXML
	    private TableColumn<Produto, String> venda_tvConsoles_fabricante;

	    @FXML
	    private TableColumn<Produto, Integer> venda_tvConsoles_quantidade;
	   
//TABELAS DE LOCAÇÃO
	    
	    @FXML
	    private TitledPane paneLoc;

	    @FXML
	    private TitledPane paneLocJogos;
	    
	    @FXML
	    private TitledPane paneLocAcessorios;
	    
	    @FXML
	    private TitledPane paneLocConsoles;
	    
	    @FXML
	    private TableView<Produto> loc_tvJogos;

	    @FXML
	    private TableColumn<Produto, String> loc_tvJogos_tcNome;

	    @FXML
	    private TableColumn<Produto, String> loc_tvJogos_tcCompatibilidade;

	    @FXML
	    private TableColumn<Produto, Integer> loc_tvJogos_quantidade;

	    @FXML
	    private TableView<Produto> loc_tvAcessorios;

	    @FXML
	    private TableColumn<Produto, String> loc_tvAcessorios_tcNome;

	    @FXML
	    private TableColumn<Produto, String> loc_tvAcessorios_tcCompatibilidade;

	    @FXML
	    private TableColumn<Produto, String> loc_tvAcessorios_fabricante;

	    @FXML
	    private TableColumn<Produto, Integer> loc_tvAcessorios_quantidade;

	    @FXML
	    private TableView<Produto> loc_tvConsoles;

	    @FXML
	    private TableColumn<Produto, String> loc_tvConsoles_tcNome;

	    @FXML
	    private TableColumn<Produto, String> loc_tvConsoles_fabricante;

	    @FXML
	    private TableColumn<Produto, Integer> loc_tvConsoles_quantidade;

//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararTableViews();
		listar();
		br.util.MaskTextfield.campoNumerico(txf_qnt);
	}
	

    @FXML
    void OnClick_btn_adicionar(ActionEvent event) {
    	try {
    	if(getProdutoSelecionado() == null || txf_qnt.getText().isEmpty()) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atenção");
			alert.setHeaderText(null);
			 if(txf_qnt.getText().isEmpty())alert.setContentText("Digite uma quantidade");
			 if(getProdutoSelecionado() == null)alert.setContentText("Escolha um produto!");
			alert.show();
    	}else{
    		Produto novoProduto = new Produto(getProdutoSelecionado(),Integer.parseInt(txf_qnt.getText()));
    	if(getProdutoSelecionado().getTipo().equals("Jogo"))new ProdutoDAO(nomeArquivoJogos).alterarProduto(getProdutoSelecionado().getCodProduto(), novoProduto);
    	if(getProdutoSelecionado().getTipo().equals("Acessorio"))new ProdutoDAO(nomeArquivoAcessorios).alterarProduto(getProdutoSelecionado().getCodProduto(), novoProduto);
    	if(getProdutoSelecionado().getTipo().equals("Console"))new ProdutoDAO(nomeArquivoConsoles).alterarProduto(getProdutoSelecionado().getCodProduto(), novoProduto);
    	listar();
    	txf_qnt.clear();
    	}
    }catch(Exception e) {
    	e.printStackTrace();
    }
    }

    @FXML
    void OnClick_btn_cancelar(ActionEvent event) {
    	br.util.Janela.fecharJanela(btn_cancelar);
    }

//************************** METODOS AUXILIARES *********************
    private void prepararTableViews() {
    	venda_tvJogos_tcNome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	venda_tvJogos_tcCompatibilidade.setCellValueFactory(new PropertyValueFactory<>("compatibilidade"));
    	venda_tvJogos_quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    	
    	venda_tvAcessorios_tcNome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	venda_tvAcessorios_fabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
    	venda_tvAcessorios_tcCompatibilidade.setCellValueFactory(new PropertyValueFactory<>("compatibilidade"));
    	venda_tvAcessorios_quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    	
    	venda_tvConsoles_tcNome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	venda_tvConsoles_fabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
    	venda_tvConsoles_quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    	
    	
    }
    
    private void listar() {
    	try {
        	venda_tvJogos.setItems(FXCollections.observableArrayList(new ProdutoDAO(nomeArquivoJogos).listarProdutos()));
        	venda_tvConsoles.setItems(FXCollections.observableArrayList(new ProdutoDAO(nomeArquivoConsoles).listarProdutos()));
        	venda_tvAcessorios.setItems(FXCollections.observableArrayList(new ProdutoDAO(nomeArquivoAcessorios).listarProdutos()));
        	
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
    }
    private Produto getProdutoSelecionado() {
    	if(paneJogos.isExpanded() && !venda_tvJogos.getSelectionModel().isEmpty()) {
    		return venda_tvJogos.getSelectionModel().getSelectedItem();
		 }else if(paneAcessorios.isExpanded() && !venda_tvAcessorios.getSelectionModel().isEmpty()) {
			 return venda_tvAcessorios.getSelectionModel().getSelectedItem();
		 }else if(paneConsoles.isExpanded() && !venda_tvConsoles.getSelectionModel().isEmpty()) {
			 return venda_tvConsoles.getSelectionModel().getSelectedItem();
		 }
    	return null;
    }

}
