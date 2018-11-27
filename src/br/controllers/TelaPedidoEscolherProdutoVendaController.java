package br.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.model.Produto;
import br.persistencia.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaPedidoEscolherProdutoVendaController implements Initializable{

//************************ ATRIBUTOS ********************************
	private ArrayList<Produto> listJogos;
	private ArrayList<Produto> listAcessorios;
	private ArrayList<Produto> listConsoles;
//*********************** COMPONENTES *******************************
		@FXML
	    private TitledPane paneAcessorios;
		
		 @FXML
		    private TextField txf_qnt;

		@FXML
	    private TitledPane paneJogos;

		@FXML
	    private TitledPane paneConsoles;

	    @FXML
	    private TableView<Produto> tv_jogos;
	    
	    @FXML
	    private TableColumn<Produto, Integer> tv_jogos_tcID;

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
	    private TableColumn<Produto, Integer> tv_acessorios_tcID;

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
	    private TableColumn<Produto, Integer> tv_consoles_tcID;
	    
	    @FXML
	    private TableColumn<Produto, String> tv_consoles_tcNome;

	    @FXML
	    private TableColumn<Produto, String> tv_consoles_fabricante;

	    @FXML
	    private TableColumn<Produto, Double> tv_consoles_tcValVenda;

	    @FXML
	    private TableColumn<Produto, Double> tv_consoles_tcValLoc;
	    
	    @FXML
	    private Button btn_adicionar;

	    @FXML
	    private Button btn_cancelar;



//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararTableViews();
		listar();
	}

	 @FXML
	 void OnClick_btn_adicionar(ActionEvent event) {
		 try {
		 String nome;
		 if(paneJogos.isExpanded() && !tv_jogos.getSelectionModel().isEmpty()) {
			 nome = tv_jogos.getSelectionModel().getSelectedItem().getNomeProduto();
			 TelaPedidoVendaController.listProdutos.add(getObjetoDaLista(listJogos, nome));
			 br.util.Janela.fecharJanela(btn_adicionar);
		 }else if(paneAcessorios.isExpanded() && !tv_acessorios.getSelectionModel().isEmpty()) {
			 nome = tv_acessorios.getSelectionModel().getSelectedItem().getNomeProduto();
			 TelaPedidoVendaController.listProdutos.add(getObjetoDaLista(listAcessorios, nome));
			 br.util.Janela.fecharJanela(btn_adicionar);
		 }else if(paneConsoles.isExpanded() && !tv_consoles.getSelectionModel().isEmpty()) {
			 nome = tv_consoles.getSelectionModel().getSelectedItem().getNomeProduto();
			 TelaPedidoVendaController.listProdutos.add(getObjetoDaLista(listConsoles, nome));
			 br.util.Janela.fecharJanela(btn_adicionar);
		 }else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atenção");
			alert.setHeaderText(null);
			alert.setContentText("Escolha um produto!");
			alert.show();
		 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 
	 }

	 @FXML
    void OnClick_btn_cancelar(ActionEvent event) {
		// br.util.Janela.fecharJanela(btn_cancelar);
   }

//************************** METODOS AUXILIARES *********************
    private void prepararTableViews() {
    	tv_jogos_tcID.setCellValueFactory(new PropertyValueFactory<>("codProduto"));
    	tv_jogos_tcNome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	tv_jogos_tcCompatibilidade.setCellValueFactory(new PropertyValueFactory<>("compatibilidade"));
    	tv_jogos_tcValVenda.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioVenda"));
    	tv_jogos_tcValLoc.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioLocacao"));
    	
    	tv_acessorios_tcID.setCellValueFactory(new PropertyValueFactory<>("codProduto"));
    	tv_acessorios_tcNome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	tv_acessorios_fabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
    	tv_acessorios_tcCompatibilidade.setCellValueFactory(new PropertyValueFactory<>("compatibilidade"));
    	tv_acessorios_tcValLoc.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioLocacao"));
    	tv_acessorios_tcValVenda.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioVenda"));
    	
    	tv_consoles_tcID.setCellValueFactory(new PropertyValueFactory<>("codProduto"));
    	tv_consoles_tcNome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	tv_consoles_fabricante.setCellValueFactory(new PropertyValueFactory<>("fabricante"));
    	tv_consoles_tcValLoc.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioLocacao"));
    	tv_consoles_tcValVenda.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioVenda"));
    }
    
    private void listar() {
    	try {
    		listJogos = new ProdutoDAO(TelaPrincipalController.nomeArquivoJogos).listar();
    		listAcessorios = new ProdutoDAO(TelaPrincipalController.nomeArquivoAcessorios).listar();
    		listConsoles = new ProdutoDAO(TelaPrincipalController.nomeArquivoConsoles).listar();
    		tv_jogos.setItems(FXCollections.observableArrayList(listJogos));
    		tv_acessorios.setItems(FXCollections.observableArrayList(listAcessorios));
    		tv_consoles.setItems(FXCollections.observableArrayList(listConsoles));
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private Produto getObjetoDaLista(ArrayList<Produto> lista ,String nome) {
    	for (Produto produto : lista) {
			if(produto.getNomeProduto().equals(nome))return produto;
		}
    	return null;
    }
}
