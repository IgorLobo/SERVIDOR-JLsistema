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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaInfraController implements Initializable {
//************************ ATRIBUTOS ********************************
	Janela utilJanela = new Janela();
	String nomeArquivo = TelaPrincipalController.caminhoTxtBancoDados + "Infraestruturas.csv";
	private InfraestruturaDAO persistencia = new InfraestruturaDAO(nomeArquivo);
	static String operacao;
	static Infraestrutura clienteSelecionado;

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
				
			}else {
			operacao = "alterar";
			clienteSelecionado = tableView_infra.getSelectionModel().getSelectedItem();
			utilJanela.novaJanelaComOwner("/br/view/TelaInfraIncluir.fxml", false, "Alterar dados do cliente");
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
    }

    @FXML
    void OnClick_btn_excluir(ActionEvent event) {
    	try {
			if (tableView_infra.getSelectionModel().isEmpty()) {

			} else {
				persistencia.excluir(tableView_infra.getSelectionModel().getSelectedItem().getCodInfraestrutura());
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
    }

    @FXML
    void OnClick_btn_incluir(ActionEvent event) {
    	utilJanela.novaJanelaComOwner("/br/view/TelaInfraIncluir.fxml", false);
    }

    @FXML
    void OnClick_btn_observacao(ActionEvent event) {
    	listar();
    }


//************************** METODOS AUXILIARES *********************

    private void listar() {
		try {
			ArrayList<Infraestrutura> listaDeInfra;
			InfraestruturaDAO infraestruturaDAO = new InfraestruturaDAO(nomeArquivo);
			listaDeInfra = infraestruturaDAO.listar();
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
