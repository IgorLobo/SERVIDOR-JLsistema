package br.controllers;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

import br.model.Infraestrutura;
import br.persistencia.InfraestruturaDAO;
import br.util.Janela;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TelaPedidoEscolherInfraController implements Initializable{

//************************ ATRIBUTOS ********************************
	Janela janelaUtil = new Janela();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
//*********************** COMPONENTES *******************************	

    @FXML
    private Button btn_adicionar;

    @FXML
    private Button btn_cancelar;
    
    @FXML
    private Button btn_detalhes;

    @FXML
    private DatePicker date_inicio;

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



//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararTableViews();
		date_inicio.setValue(LocalDate.now());
		date_inicio.setMouseTransparent(true);
		tableView_infra.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
		    if (newSelection != null) {
		    	//SÓ COLOCAR O CODIGO AQUI REFERENCIANDO O "newSelection" QUE É O OBJETO INFRA SELECIONADO, PRA USAR COMO QUISER, EXEMPLO:
		        System.out.println(newSelection.getNomeInfraestrutura());
		    }
		});
	}

	 @FXML
	 void OnClick_btn_adicionar(ActionEvent event) {
		 
	 }
	 
	 @FXML
    void OnClick_btn_detalhes(ActionEvent event) {
		 TelaInfraDetalhesController.infra = tableView_infra.getSelectionModel().getSelectedItem();
		 janelaUtil.novaJanelaComOwner("/br/view/TelaInfraDetalhes.fxml", false, "Detalhes da sala");
    }

	 @FXML
    void OnClick_btn_cancelar(ActionEvent event) {
		br.util.Janela.fecharJanela(btn_cancelar);
   }

//************************** METODOS AUXILIARES *********************
    private void prepararTableViews() {
    	try {
    	tc_ID.setCellValueFactory(new PropertyValueFactory<>("codInfraestrutura"));
    	tc_nome.setCellValueFactory(new PropertyValueFactory<>("nomeInfraestrutura"));
    	tc_precoDia.setCellValueFactory(new PropertyValueFactory<>("precoDiaInfraestrutura"));
    	tc_descricao.setCellValueFactory(new PropertyValueFactory<>("descricaoInfraestrutura"));
    	
    	tableView_infra.setItems(FXCollections.observableArrayList(new InfraestruturaDAO(TelaPrincipalController.nomeArquivoInfra).listarInfraestruturas()));
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
   
    /*
    private boolean validaProduto(Produto p) {
    	for (Infraestrutura infra : TelaPedidoInfraController.obsSalas) {
			if(infra.getNomeProduto().equals(p.getNomeProduto())) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Atenção");
				alert.setHeaderText(null);
				alert.setContentText("O produto já está na lista de pedidos!");
				alert.show();
				return false;
			}
		}
    	return true;
    }*/
    
  
}
