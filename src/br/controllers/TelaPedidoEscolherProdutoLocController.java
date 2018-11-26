package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.model.Cliente;
import br.model.Infraestrutura;
import br.model.Produto;
import br.util.Janela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaPedidoEscolherProdutoLocController implements Initializable{

//************************ ATRIBUTOS ********************************
	
	
//*********************** COMPONENTES *******************************	
	 
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
	    private TableView<Infraestrutura> tableView_infra;

	    @FXML
	    private TableColumn<Infraestrutura, Integer> tc_ID;

	    @FXML
	    private TableColumn<Infraestrutura, String> tc_nome;

	    @FXML
	    private TableColumn<Infraestrutura, String> tc_descricao;

	    @FXML
	    private TableColumn<Infraestrutura, Float> tc_precoDia;
	    
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

	 }

	 @FXML
    void OnClick_btn_cancelar(ActionEvent event) {

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
