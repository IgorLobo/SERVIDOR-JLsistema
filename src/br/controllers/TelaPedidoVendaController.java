package br.controllers;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import br.model.Cliente;
import br.model.Produto;
import br.util.Janela;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaPedidoVendaController implements Initializable{

//************************ ATRIBUTOS ********************************
		private Janela janelaUtil = new Janela();
		private Cliente cliente;
		static ObservableList<Produto> obsProdutos = FXCollections.observableArrayList();
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
	    private Label lb_precoTotalPedido;


//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararTableView();
		
		cliente = TelaPedidoEscolherClienteController.clienteSelecionado;
		txf_nome.setText(cliente.getNomeCliente());
		txf_cpf.setText(cliente.getCpfCliente());
		txf_data.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		
	}

	@FXML
    void OnClick_btn_adicionarItem(ActionEvent event) {
		janelaUtil.novaJanelaComOwnerWait("/br/view/TelaPedidoEscolherProdutoVenda.fxml", false, "Adicionar item ao pedido");
    }

    @FXML
    void OnClick_btn_cancelar(ActionEvent event) {
    	br.util.Janela.fecharJanela(btn_cancelar);
    }

    @FXML
    void OnClick_btn_finalizar(ActionEvent event) {
    	br.util.Janela.fecharJanela(btn_finalizar);
    }

    @FXML
    void OnClick_btn_removerItem(ActionEvent event) {
    	if(tv_produtos.getSelectionModel().isEmpty()) {
    		Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Aten��o");
			alert.setHeaderText(null);
			alert.setContentText("Selecione um produto para remover");
			alert.show();
    	}else {
    	obsProdutos.remove(tv_produtos.getSelectionModel().getSelectedItem());
    	}
    }

//************************** METODOS AUXILIARES *********************
    private void prepararTableView() {
    	tc_nome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
    	tc_compatibilidade.setCellValueFactory(new PropertyValueFactory<>("compatibilidade"));
    	tc_precoUnid.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioVenda"));
    	tc_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
    	tv_produtos.setItems(obsProdutos);
    }
    
    
}
