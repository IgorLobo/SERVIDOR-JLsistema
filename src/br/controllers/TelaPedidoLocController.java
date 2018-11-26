package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.model.Produto;
import br.util.Janela;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaPedidoLocController implements Initializable{

//************************ ATRIBUTOS ********************************
		private Janela janelaUtil = new Janela();
		
//*********************** COMPONENTES *******************************	
	 @FXML
	    private Button btn_cancelar;

	    @FXML
	    private Button btn_finalizar;

	    @FXML
	    private Button btn_removerItem;

	    @FXML
	    private Button btn_adicionarItem;

	    @FXML
	    private TextField txf_nome;

	    @FXML
	    private TextField txf_cpf;

	    @FXML
	    private TextField txf_data;

	    @FXML
	    private TableView<Produto> tv_produtos;

	    @FXML
	    private TableColumn<Produto, String> tc_nome;

	    @FXML
	    private TableColumn<Produto, String> tc_tipo;

	    @FXML
	    private TableColumn<Produto, String> tc_compatibilidade;

	    @FXML
	    private TableColumn<Produto, Float> tc_precoUnid;

	    @FXML
	    private TableColumn<Integer, Integer> tc_qnt;

	    @FXML
	    private TableColumn<Float, Float> tc_precoTotal;
	    
	    @FXML
	    private TableColumn<Integer, Integer> tc_dias;

	    @FXML
	    private Label lb_precoTotalPedido;


//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararTableView();
	}

	@FXML
    void OnClick_btn_adicionarItem(ActionEvent event) {
		janelaUtil.novaJanelaComOwner("/br/view/TelaPedidoEscolherProdutoLoc.fxml", false);
    }

    @FXML
    void OnClick_btn_cancelar(ActionEvent event) {

    }

    @FXML
    void OnClick_btn_finalizar(ActionEvent event) {

    }

    @FXML
    void OnClick_btn_removerItem(ActionEvent event) {

    }

//************************** METODOS AUXILIARES *********************
    private void prepararTableView() {
    	tc_nome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	tc_compatibilidade.setCellValueFactory(new PropertyValueFactory<>("compatibilidade"));
    	tc_precoUnid.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioVenda"));
    	tc_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    	
    }
}
