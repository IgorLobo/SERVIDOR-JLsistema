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

public class TelaInfraController implements Initializable {
//************************ ATRIBUTOS ********************************
	private Janela utilJanela = new Janela();
	String nomeArquivo = TelaPrincipalController.caminhoTxtBancoDados + "Infraestruturas.csv";
	private InfraestruturaDAO persistencia = new InfraestruturaDAO(nomeArquivo);
	static String operacao;
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
    private Button btn_observacao;

    @FXML
    private Button btn_excluir;

    @FXML
    private Button btn_alterar;

    @FXML
    private Button btn_incluir;

   
//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararTableView();
		listar();
	}
	 	
	@FXML
    void OnClick_btn_alterar(ActionEvent event) {
		try {
			if(tableView_infra.getSelectionModel().isEmpty()) {
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Atenção");
				alert.setHeaderText(null);
				alert.setContentText("Selecione uma Infraestrutura para Alteração!");
				alert.show();	
			}else {
			operacao = "alterar";
			InfraSelecionada = tableView_infra.getSelectionModel().getSelectedItem();
			utilJanela.novaJanelaComOwnerWait("/br/view/TelaInfraIncluir.fxml", false, "Alterar dados da infraestrutura");
			listar();
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
    }

    @FXML
    void OnClick_btn_excluir(ActionEvent event) {
    	try {
			if (tableView_infra.getSelectionModel().isEmpty()) {

				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Atenção");
				alert.setHeaderText(null);
				alert.setContentText("Selecione uma Infraestrutura para Exclusão!");
				alert.show();	
				listar();
			} else {
				persistencia.excluir(tableView_infra.getSelectionModel().getSelectedItem().getCodInfraestrutura());
				listar();
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
    }

    @FXML
    void OnClick_btn_incluir(ActionEvent event) {
    	operacao = "incluir";
    	utilJanela.novaJanelaComOwnerWait("/br/view/TelaInfraIncluir.fxml", false, "Cadastrar nova infraestrutura");
    	listar();
    }

    @FXML
    void OnClick_btn_observacao(ActionEvent event) {
    	listar();
    }


//************************** METODOS AUXILIARES *********************

    private void listar() {
		try {
			ArrayList<Infraestrutura> listaDeInfra;
			listaDeInfra = persistencia.listar();
			tableView_infra.setItems(FXCollections.observableArrayList(listaDeInfra));
			
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
