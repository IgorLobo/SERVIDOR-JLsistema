package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.model.Cliente;
import br.model.Produto;
import br.util.Janela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaProdutoController implements Initializable{

//************************ ATRIBUTOS ********************************
	private Janela utilJanela = new Janela();
	String nomeArquivo = TelaPrincipalController.caminhoTxtBancoDados + "Produtos.csv";
	
//*********************** COMPONENTES *******************************	
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
	}
	@FXML
    void OnClick_btn_alterar(ActionEvent event) {

    }

    @FXML
    void OnClick_btn_excluir(ActionEvent event) {
    	
    }

    @FXML
    void OnClick_btn_incluir(ActionEvent event) {
    	utilJanela.novaJanelaComOwner("/br/view/TelaProdutoIncluir.fxml", false);
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

}
