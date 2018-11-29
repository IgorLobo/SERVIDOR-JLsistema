package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.model.Infraestrutura;
import br.model.Produto;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TitledPane;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaPedidoEscolherProdutoLocController implements Initializable{

//************************ ATRIBUTOS ********************************
	private ObservableList<Produto> listJogos;
	private ObservableList<Produto> listAcessorios;
	private ObservableList<Produto> listConsoles;
	
//*********************** COMPONENTES *******************************	
		@FXML
	    private TitledPane paneAcessorios;
	
		@FXML
	    private TitledPane paneJogos;
	
		@FXML
	    private TitledPane paneConsoles;
		
		@FXML
	    private TitledPane paneInfra;

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
	   
	    @FXML
	    private DatePicker date_inicio;

	    @FXML
	    private DatePicker date_final;
	    
	    @FXML
	    private Button btn_adicionar;

	    @FXML
	    private Button btn_cancelar;



//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararTableViews();
	}

	 @FXML
	 void OnClick_btn_adicionar(ActionEvent event) {
		 if(paneJogos.isExpanded() && !tv_jogos.getSelectionModel().isEmpty()) {
			 TelaPedidoLocController.novoProduto = tv_jogos.getSelectionModel().getSelectedItem();
			 br.util.Janela.fecharJanela(btn_adicionar);
		 }else if(paneAcessorios.isExpanded() && !tv_acessorios.getSelectionModel().isEmpty()) {
			 TelaPedidoLocController.novoProduto = tv_acessorios.getSelectionModel().getSelectedItem();
			 br.util.Janela.fecharJanela(btn_adicionar);
		 }else if(paneConsoles.isExpanded() && !tv_consoles.getSelectionModel().isEmpty()) {
			 TelaPedidoLocController.novoProduto = tv_consoles.getSelectionModel().getSelectedItem();
			 br.util.Janela.fecharJanela(btn_adicionar);
		 }else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atenção");
			alert.setHeaderText(null);
			alert.setContentText("Escolha um produto!");
			alert.show();
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

}
