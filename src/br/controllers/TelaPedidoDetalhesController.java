package br.controllers;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import br.model.Produto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.converter.LocalDateStringConverter;

public class TelaPedidoDetalhesController implements Initializable{
//************************ ATRIBUTOS ********************************
	static ObservableList<Produto> obsProdutos = FXCollections.observableArrayList();
//*********************** COMPONENTES *******************************	
	    @FXML
	    private Button btn_ok;

	    @FXML
	    private TextField txf_nome;

	    @FXML
	    private TextField txf_cpf;

	    @FXML
	    private DatePicker date_inicio;

	    @FXML
	    private DatePicker date_fim;
	    
	    @FXML
	    private Label lb_precoTotalPedido;
	    
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

	    //*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		txf_cpf.setText(TelaPedidoInicial.pedidoSelecionado.getCliente().getCpfCliente());
		txf_nome.setText(TelaPedidoInicial.pedidoSelecionado.getCliente().getNomeCliente());
		LocalDate datainicio = LocalDate.parse(TelaPedidoInicial.pedidoSelecionado.getDataInicio(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate datafim = LocalDate.parse(TelaPedidoInicial.pedidoSelecionado.getDataFim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		date_inicio.setValue(datainicio);
		date_fim.setValue(datafim);
		
		
		tc_nome.setCellValueFactory(new PropertyValueFactory<>("nomeProduto"));
		tc_compatibilidade.setCellValueFactory(new PropertyValueFactory<>("compatibilidade"));
		tc_precoUnid.setCellValueFactory(new PropertyValueFactory<>("valorUnitarioLocacao"));
		tc_tipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
		tc_qnt.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		tc_precoTotal.setCellValueFactory(new PropertyValueFactory<>("subtotal"));
		tc_dias.setCellValueFactory(new PropertyValueFactory<>("dias"));
		tv_produtos.setItems(obsProdutos);
	}

	
	@FXML
    void OnClick_btn_ok(ActionEvent event) {
		br.util.Janela.fecharJanela(btn_ok);
    }

//************************** METODOS AUXILIARES *********************

}
