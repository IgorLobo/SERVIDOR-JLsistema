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
	    private TitledPane paneAcessorios;
	
		@FXML
	    private TitledPane paneJogos;
	
		@FXML
	    private TitledPane paneConsoles;

		@FXML
	    private Button btn_adicionar;

	    @FXML
	    private Button btn_cancelar;

	    @FXML
	    private TableView<Produto> tv_jogos;

	    @FXML
	    private TableColumn<Produto, String> tv_jogos_tcNome;

	    @FXML
	    private TableColumn<Produto, String> tv_jogos_tcCompatibilidade;

	    @FXML
	    private TableColumn<Produto, Integer> tv_jogos_quantidade;

	    @FXML
	    private TableView<Produto> tv_acessorios;

	    @FXML
	    private TableColumn<Produto, String> tv_acessorios_tcNome;

	    @FXML
	    private TableColumn<Produto, String> tv_acessorios_tcCompatibilidade;

	    @FXML
	    private TableColumn<Produto, String> tv_acessorios_fabricante;

	    @FXML
	    private TableColumn<Produto, Integer> tv_acessorios_quantidade;

	    @FXML
	    private TableView<Produto> tv_consoles;

	    @FXML
	    private TableColumn<Produto, String> tv_consoles_tcNome;

	    @FXML
	    private TableColumn<Produto, String> tv_consoles_fabricante;

	    @FXML
	    private TableColumn<Produto, Integer> tv_consoles_quantidade;

//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararTableViews();
		listar();
	}
	

    @FXML
    void OnClick_btn_adicionar(ActionEvent event) {
    	try {
    	if(getProdutoSelecionado() == null) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atenção");
			alert.setHeaderText(null);
			alert.setContentText("Escolha um produto!");
			alert.show();
    	}else {
    	if(getProdutoSelecionado().getTipo().equals("Jogo"))new ProdutoDAO(nomeArquivoJogos).alterar(getProdutoSelecionado().getCodProduto(), getProdutoSelecionado());
    	if(getProdutoSelecionado().getTipo().equals("Acessorios"))new ProdutoDAO(nomeArquivoAcessorios).alterar(getProdutoSelecionado().getCodProduto(), getProdutoSelecionado());
    	if(getProdutoSelecionado().getTipo().equals("Consoles"))new ProdutoDAO(nomeArquivoConsoles).alterar(getProdutoSelecionado().getCodProduto(), getProdutoSelecionado());
    	listar();
    	
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
    	tv_jogos_tcNome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	tv_jogos_tcCompatibilidade.setCellValueFactory(new PropertyValueFactory<>("compatibilidade"));
    	tv_jogos_quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    	
    	tv_acessorios_tcNome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	tv_acessorios_fabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
    	tv_acessorios_tcCompatibilidade.setCellValueFactory(new PropertyValueFactory<>("compatibilidade"));
    	tv_acessorios_quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    	
    	tv_consoles_tcNome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	tv_consoles_fabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
    	tv_consoles_quantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
    	
    	
    }
    
    private void listar() {
    	try {
        	tv_jogos.setItems(FXCollections.observableArrayList(new ProdutoDAO(nomeArquivoJogos).listar()));
        	tv_consoles.setItems(FXCollections.observableArrayList(new ProdutoDAO(nomeArquivoConsoles).listar()));
        	tv_acessorios.setItems(FXCollections.observableArrayList(new ProdutoDAO(nomeArquivoAcessorios).listar()));
        	
        	}catch(Exception e) {
        		e.printStackTrace();
        	}
    }
    private Produto getProdutoSelecionado() {
    	if(paneJogos.isExpanded() && !tv_jogos.getSelectionModel().isEmpty()) {
    		return tv_jogos.getSelectionModel().getSelectedItem();
		 }else if(paneAcessorios.isExpanded() && !tv_acessorios.getSelectionModel().isEmpty()) {
			 return tv_acessorios.getSelectionModel().getSelectedItem();
		 }else if(paneConsoles.isExpanded() && !tv_consoles.getSelectionModel().isEmpty()) {
			 return tv_consoles.getSelectionModel().getSelectedItem();
		 }
    	return null;
    }

}
