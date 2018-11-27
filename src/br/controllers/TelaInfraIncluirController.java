package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.model.Cliente;
import br.model.Infraestrutura;
import br.persistencia.ClienteDAO;
import br.util.MaskTextfield;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TelaInfraIncluirController implements Initializable {
//************************ ATRIBUTOS ********************************
	String nomeArquivo = TelaPrincipalController.caminhoTxtBancoDados + "Infraestruturas.csv";

//*********************** COMPONENTES *******************************	
	@FXML
    private TextField txf_nome;

    @FXML
    private TextField txf_valor;

    @FXML
    private TextArea txa_descricao;

    @FXML
    private Button btn_cancelar;

    @FXML
    private Button btn_cadastrar;

//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararComponentes();
	}

    @FXML
    void OnClick_btn_cadastrar(ActionEvent event) {
    	try {
			if(TelaClienteController.operacao.equals("alterar")) {
				
			}else {
				String nome = txf_nome.getText();
				String valor = txf_valor.getText();
				String descricao = txa_descricao.getText();
				
				Infraestrutura infra = new Infraestrutura();
				ClienteDAO arquivo = new ClienteDAO(nomeArquivo); 
				arquivo.incluir(cliente);
				limpar();
			}
    	}catch(Exception e) {
    		
    	}
    }

    @FXML
    void OnClick_btn_cancelar(ActionEvent event) {

    }

//************************** METODOS AUXILIARES *********************
    private void prepararComponentes() {
    	MaskTextfield.monetaryField(txf_valor);
    }
    
}
