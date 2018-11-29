package br.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import br.model.Produto;
import br.persistencia.ProdutoDAO;
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
import javafx.scene.control.TextField;
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
	    private Button btn_adicionar;

	    @FXML
	    private Button btn_cancelar;
	    
	    @FXML
	    private DatePicker date_fim;

	    @FXML
	    private TextField txf_qnt;


//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararTableViews();
		date_inicio.setValue(LocalDate.now());
	}

	 @FXML
	 void OnClick_btn_adicionar(ActionEvent event) {
		 try {
			 Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atenção");
			alert.setHeaderText(null);
			
		 if(paneJogos.isExpanded() && !tv_jogos.getSelectionModel().isEmpty()&& validaCamposObrigatorios()) {
			 if(validaQnt(Integer.parseInt(txf_qnt.getText()), tv_jogos.getSelectionModel().getSelectedItem().getQuantidade()) && validaProduto(tv_jogos.getSelectionModel().getSelectedItem())) {
			 TelaPedidoLocController.obsProdutos.add(new ProdutoDAO(TelaPrincipalController.nomeArquivoJogosLoc)
					 .getProduto(tv_jogos.getSelectionModel().getSelectedItem().getCodProduto(),Integer.parseInt(txf_qnt.getText())));
			 br.util.Janela.fecharJanela(btn_adicionar);
			 }
		 }else if(paneAcessorios.isExpanded() && !tv_acessorios.getSelectionModel().isEmpty() && validaCamposObrigatorios()) {
			 if(validaQnt(Integer.parseInt(txf_qnt.getText()), tv_acessorios.getSelectionModel().getSelectedItem().getQuantidade())&& validaProduto(tv_acessorios.getSelectionModel().getSelectedItem())) {
			 TelaPedidoLocController.obsProdutos.add(new ProdutoDAO(TelaPrincipalController.nomeArquivoAcessoriosLoc)
					 .getProduto(tv_acessorios.getSelectionModel().getSelectedItem().getCodProduto(),Integer.parseInt(txf_qnt.getText())));
			 br.util.Janela.fecharJanela(btn_adicionar);
			 }
		 }else if(paneConsoles.isExpanded() && !tv_consoles.getSelectionModel().isEmpty() && validaCamposObrigatorios()) {
			 if(validaQnt(Integer.parseInt(txf_qnt.getText()), tv_consoles.getSelectionModel().getSelectedItem().getQuantidade())&& validaProduto(tv_consoles.getSelectionModel().getSelectedItem())) {
			 TelaPedidoLocController.obsProdutos.add(new ProdutoDAO(TelaPrincipalController.nomeArquivoConsolesLoc)
					 .getProduto(tv_consoles.getSelectionModel().getSelectedItem().getCodProduto(),Integer.parseInt(txf_qnt.getText())));
			 br.util.Janela.fecharJanela(btn_adicionar);
			 }
		 }else {
			alert.setContentText("Escolha um produto!");
			if(!txf_qnt.getText().isEmpty())alert.setContentText("Defina a quantidade desejada!");
			alert.show();
		 }
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }

	 @FXML
    void OnClick_btn_cancelar(ActionEvent event) {
		System.out.println(pegarData(date_inicio));
		 //br.util.Janela.fecharJanela(btn_cancelar);
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
    
    private boolean validaQnt(int qntDesejada,int qntEstoque) {
    	if(qntDesejada <= (qntEstoque-1)) {
    		return true;
    	}
    	
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Atenção");
		alert.setHeaderText(null);
		alert.setContentText("A quantidade desejada não pode ser maior que o estoque!");
		if(qntEstoque == 1)alert.setContentText("A quantidade do produto não pode ser menor que 1!");
		alert.show();
    	return false;
    }
    
    private boolean validaProduto(Produto p) {
    	for (Produto produto : TelaPedidoVendaController.obsProdutos) {
			if(produto.getNomeProduto().equals(p.getNomeProduto())) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Atenção");
				alert.setHeaderText(null);
				alert.setContentText("O produto já está na lista de pedidos!");
				alert.show();
				return false;
			}
		}
    	return true;
    }
    
    private boolean validaCamposObrigatorios() {
    	
    	Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Atenção");
		alert.setHeaderText(null);
		if(date_inicio.getValue().isBefore(LocalDate.now()) || date_fim.getValue() == null|| date_inicio.getValue() == null || date_inicio.getValue().isAfter(date_fim.getValue())) {
		if(date_fim.getValue() == null)alert.setContentText("Defina uma data fim");
		if(date_inicio.getValue() == null)alert.setContentText("Defina uma data inicio");
		if(date_inicio.getValue().isAfter(date_fim.getValue()))alert.setContentText("A data inicio não pode ser posterior á data fim");
		if(date_inicio.getValue().isBefore(LocalDate.now()))alert.setContentText("A data inicio não pode ser anterior á data atual");;
		alert.show();
		return false;
		}
    	return  true;
    }
    
    private Date pegarData(DatePicker date) {
    	Calendar c = Calendar.getInstance();
    	c.set(date.getValue().getYear(), date.getValue().getMonthValue(), date.getValue().getDayOfMonth());
    	return c.getTime();
    }

}
