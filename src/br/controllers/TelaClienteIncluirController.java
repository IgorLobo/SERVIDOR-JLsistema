package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import br.model.Cliente;
import br.persistencia.ClienteDAO;
import br.util.MaskTextfield;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TelaClienteIncluirController implements Initializable {

//************************ ATRIBUTOS ********************************
	String nomeArquivo = TelaPrincipalController.caminhoTxtBancoDados + "Clientes.csv";

//*********************** COMPONENTES *******************************	
	@FXML
	private TextField txf_nome;

	@FXML
	private TextField txf_CPF;

	@FXML
	private TextField txf_CEP;

	@FXML
	private ComboBox<String> cb_estados;

	@FXML
	private TextField txf_cidade;

	@FXML
	private TextField txf_bairro;

	@FXML
	private TextField txf_edereco;

	@FXML
	private TextField txf_complemento;

	@FXML
	private TextField txf_telefone;

	@FXML
	private TextField txf_telefoneSecundario;

	@FXML
	private TextField txf_email;

	@FXML
	private TextField txf_emailSecundario;

	@FXML
	private Button btn_cancelar;

	@FXML
	private Button btn_salvar;

//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (TelaClienteController.operacao.equals("alterar")) {
			carregarDados();
		}
		prepararComponentes();
	}

	@FXML
	void OnClick_btn_cancelar(ActionEvent event) {
		limpar();
	}

	@FXML
	void OnClick_btn_salvar(ActionEvent event) {
		try {
			String nome = txf_nome.getText();
			String cpf = txf_CPF.getText();
			String cep = txf_CEP.getText();
			String estado = cb_estados.getValue();
			String cidade = txf_cidade.getText();
			String setor = txf_bairro.getText();
			String endereco = txf_edereco.getText();
			String complemento = txf_complemento.getText();
			String telefone1 = txf_telefone.getText();
			String telefone2 = txf_telefoneSecundario.getText();
			String email1 = txf_email.getText();
			String email2 = txf_emailSecundario.getText();
			Cliente cliente = new Cliente(nome, cpf, cep, estado, cidade, setor, endereco, complemento, telefone1,
					telefone2, email1, email2);
			ClienteDAO arquivo = new ClienteDAO(nomeArquivo);
			if (TelaClienteController.operacao.equals("alterar")) {
				arquivo.alterar(TelaClienteController.clienteSelecionado.getCodCliente(), cliente);
				limpar();
			} else {
				arquivo.incluir(cliente);
				limpar();
			}
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, erro.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
//************************** METODOS AUXILIARES *********************

	private void limpar() {
		txf_nome.setText("");
		txf_CPF.setText("");
		txf_CEP.setText("");
		cb_estados.setValue(null);
		txf_cidade.setText("");
		txf_bairro.setText("");
		txf_edereco.setText("");
		txf_complemento.setText("");
		txf_telefone.setText("");
		txf_telefoneSecundario.setText("");
		txf_email.setText("");
		txf_emailSecundario.setText("");
	}

	private void prepararComponentes() {
		cb_estados.setItems(FXCollections.observableArrayList("AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO",
				"MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR", "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO"));
		cb_estados.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

			}
		});
		MaskTextfield.tamanhoMaximo(txf_nome, 50);
		MaskTextfield.cpfField(txf_CPF);
		MaskTextfield.cepField(txf_CEP);
		MaskTextfield.foneField(txf_telefone);
		MaskTextfield.foneField(txf_telefoneSecundario);
	}

	private void carregarDados() {
		txf_nome.setText(TelaClienteController.clienteSelecionado.getNomeCliente());
		txf_CEP.setText(TelaClienteController.clienteSelecionado.getCepCliente());
		txf_cidade.setText(TelaClienteController.clienteSelecionado.getCidadeCliente());
		txf_complemento.setText(TelaClienteController.clienteSelecionado.getComplementoCliente());
		txf_CPF.setText(TelaClienteController.clienteSelecionado.getCpfCliente());
		txf_edereco.setText(TelaClienteController.clienteSelecionado.getEnderecoCliente());
		txf_email.setText(TelaClienteController.clienteSelecionado.getEmail1Cliente());
		txf_emailSecundario.setText(TelaClienteController.clienteSelecionado.getEmail2Cliente());
		txf_bairro.setText(TelaClienteController.clienteSelecionado.getBairroCliente());
		txf_telefone.setText(TelaClienteController.clienteSelecionado.getTelefone1Cliente());
		txf_telefoneSecundario.setText(TelaClienteController.clienteSelecionado.getTelefone2Cliente());
		cb_estados.getSelectionModel().select(TelaClienteController.clienteSelecionado.getEstadoCliente());
		txf_CPF.setDisable(true);
	}
}
