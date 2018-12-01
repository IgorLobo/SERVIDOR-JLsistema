package br.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.model.Cliente;
import br.model.Infraestrutura;
import br.persistencia.ClienteDAO;
import br.persistencia.InfraestruturaDAO;
import br.util.Janela;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaPedidoInfraController implements Initializable {
//************************ ATRIBUTOS ********************************
	private Janela utilJanela = new Janela();
	static Infraestrutura InfraSelecionada;

//*********************** COMPONENTES *******************************	
	@FXML
    private TableView<Infraestrutura> tableView_infra;

    @FXML
    private TableColumn<Infraestrutura, Integer> tc_ID;

    @FXML
    private TableColumn<Infraestrutura, String> tc_nome;

    @FXML
    private TableColumn<Infraestrutura, String> tc_descricao;

    @FXML
    private TableColumn<Infraestrutura, Integer> tc_precoDia;

    @FXML
    private Button btn_cancelar;

    @FXML
    private Button btn_alugar;

   
//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararTableView();
		listar();
	}
	 	

    @FXML
    void OnClick_btn_alugar(ActionEvent event) {
    	utilJanela.novaJanelaComOwnerWait("", false, "Alugel de infraestrutura");
    }

    @FXML
    void OnClick_btn_cancelar(ActionEvent event) {
    	br.util.Janela.fecharJanela(btn_cancelar);
    }


//************************** METODOS AUXILIARES *********************

    private void listar() {
		try {
			tableView_infra.setItems(FXCollections.observableArrayList(new InfraestruturaDAO(TelaPrincipalController.nomeArquivoInfra).listarInfraestruturas()));
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void prepararTableView() {
		tc_ID.setCellValueFactory(new PropertyValueFactory<>("codInfraestrutura"));
		tc_nome.setCellValueFactory(new PropertyValueFactory<>("nomeInfraestrutura"));
		tc_descricao.setCellValueFactory(new PropertyValueFactory<>("descricaoInfraestrutura"));
		tc_precoDia.setCellValueFactory(new PropertyValueFactory<>("precoDiaInfraestrutura"));
	}
    
}
