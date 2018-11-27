package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.management.monitor.MonitorSettingException;
import javax.swing.JOptionPane;

import br.model.Infraestrutura;
import br.persistencia.InfraestruturaDAO;
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
		if (TelaInfraController.operacao.equals("alterar")) {
			carregarDados();
		}
		prepararComponentes();
	}

    @FXML
    void OnClick_btn_cadastrar(ActionEvent event) {
    	try {
    		String nome = txf_nome.getText();
			float valor = MaskTextfield.monetaryValueFromField(txf_valor).floatValue();         //Float.parseFloat(txf_valor.getText());
			String descricao = txa_descricao.getText();
			
			Infraestrutura infra = new Infraestrutura(nome, descricao, valor);
			InfraestruturaDAO arquivo = new InfraestruturaDAO(nomeArquivo); 
			
			if(TelaInfraController.operacao.equals("alterar")) {
				arquivo.alterar(TelaInfraController.InfraSelecionada.getCodInfraestrutura(), infra);
				limpar();
			}else {
				arquivo.incluir(infra);
				limpar();
			}
    	}catch(Exception erro) {
    		JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
    	}
    }

    @FXML
    void OnClick_btn_cancelar(ActionEvent event) {

    }

//************************** METODOS AUXILIARES *********************
    private void prepararComponentes() {
    	MaskTextfield.monetaryField(txf_valor);
    }
    private void carregarDados() {
		txf_nome.setText(TelaInfraController.InfraSelecionada.getNomeInfraestrutura());
		txf_valor.setText(String.valueOf(TelaInfraController.InfraSelecionada.getPrecoDiaInfraestrutura()));
		txa_descricao.setText(TelaInfraController.InfraSelecionada.getDescricaoInfraestrutura());
	}
    private void limpar() {
    	txf_nome.setText("");
		txf_valor.setText("");
		txa_descricao.setText("");
    }
}