package br.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import br.model.Produto;
import br.persistencia.ProdutoDAO;
import br.util.MaskTextfield;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;

public class TelaProdutoIncluirController implements Initializable {

//************************ ATRIBUTOS ********************************

	String compatibilidade;

//*********************** COMPONENTES *******************************	
	@FXML
	private ComboBox<String> cb_tipo;


	@FXML
	private ComboBox<Produto> cb_compatibilidade;

	@FXML
	private TextField txf_nome;

	@FXML
	private VBox vboxCompatibilidade;

	@FXML
	private TextField txf_fabricante;

	@FXML
	private TextField txf_precoVenda;

	@FXML
	private TextField txf_precoLocacao;

	@FXML
	private Label lb_nrSerie;

	@FXML
	private TextArea txa_descricao;

	@FXML
	private Button btn_cancelar;

	@FXML
	private Button btn_salvar;

//*********************** ON-ACTION *********************************
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		prepararComponentes();
		if (TelaProdutoController.operacao.equals("alterar"))
			carregarDados();
	}

	@FXML
	void OnClick_btn_cancelar(ActionEvent event) {
		br.util.Janela.fecharJanela(btn_cancelar);
	}
	
	@FXML
	void OnClick_btn_salvar(ActionEvent event) {
		if (txa_descricao.getText().isEmpty() || txf_fabricante.getText().isEmpty() || txf_nome.getText().isEmpty()
				|| txf_precoLocacao.getText().isEmpty() || txf_precoVenda.getText().isEmpty()
				|| cb_tipo.getSelectionModel().isEmpty()
				|| (!cb_tipo.getSelectionModel().getSelectedItem().equals("Console")
						&& cb_compatibilidade.getSelectionModel().isEmpty())) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Atenção");
			alert.setHeaderText(null);
			alert.setContentText("Preencha todos os campos!");
			alert.show();

		} else {
			try {
				String nome = txf_nome.getText();
				Float precoVenda = br.util.MaskTextfield.monetaryValueFromField(txf_precoVenda).floatValue();
				Float precoLoc = br.util.MaskTextfield.monetaryValueFromField(txf_precoLocacao).floatValue();
				String descricao = txa_descricao.getText();
				String fabricante = txf_fabricante.getText();
				if (!cb_tipo.getSelectionModel().getSelectedItem().equals("Console")) {
					compatibilidade = cb_compatibilidade.getSelectionModel().getSelectedItem().toString();
				} else {
					compatibilidade = " ";
				}
				if (TelaProdutoController.operacao.equals("alterar")) {
					cb_tipo.setDisable(true);
					switch (TelaProdutoController.produtoSelecionado.getTipo()) {
					case "Jogo":
						new ProdutoDAO(TelaPrincipalController.nomeArquivoJogos).alterarProduto(
								TelaProdutoController.produtoSelecionado.getCodProduto(),
								new Produto(TelaProdutoController.produtoSelecionado.getCodProduto(), "Jogo", nome,
										descricao, fabricante, precoVenda, precoLoc, compatibilidade));
						new ProdutoDAO(TelaPrincipalController.nomeArquivoJogosLoc).alterarProduto(
								TelaProdutoController.produtoSelecionado.getCodProduto(),
								new Produto(TelaProdutoController.produtoSelecionado.getCodProduto(), "Jogo", nome,
										descricao, fabricante, precoVenda, precoLoc, compatibilidade));
						break;
					case "Acessorio":
						new ProdutoDAO(TelaPrincipalController.nomeArquivoAcessorios)
								.alterarProduto(TelaProdutoController.produtoSelecionado.getCodProduto(),
										new Produto(TelaProdutoController.produtoSelecionado.getCodProduto(),
												"Acessorio", nome, descricao, fabricante, precoVenda, precoLoc,
												compatibilidade));
						new ProdutoDAO(TelaPrincipalController.nomeArquivoAcessoriosLoc)
						.alterarProduto(TelaProdutoController.produtoSelecionado.getCodProduto(),
								new Produto(TelaProdutoController.produtoSelecionado.getCodProduto(),
										"Acessorio", nome, descricao, fabricante, precoVenda, precoLoc,
										compatibilidade));
						break;
					case "Console":
						new ProdutoDAO(TelaPrincipalController.nomeArquivoConsoles).alterarProduto(
								TelaProdutoController.produtoSelecionado.getCodProduto(),
								new Produto(TelaProdutoController.produtoSelecionado.getCodProduto(), "Console", nome,
										descricao, fabricante, precoVenda, precoLoc, compatibilidade));
						new ProdutoDAO(TelaPrincipalController.nomeArquivoConsolesLoc).alterarProduto(
								TelaProdutoController.produtoSelecionado.getCodProduto(),
								new Produto(TelaProdutoController.produtoSelecionado.getCodProduto(), "Console", nome,
										descricao, fabricante, precoVenda, precoLoc, compatibilidade));
						break;

					}
					br.util.Janela.fecharJanela(btn_salvar);
				} else {
					switch (cb_tipo.getSelectionModel().getSelectedItem()) {

					case "Jogo":
						new ProdutoDAO(TelaPrincipalController.nomeArquivoJogos).incluirProduto(new Produto("Jogo", nome,
								descricao, fabricante, compatibilidade, precoVenda, precoLoc));
						new ProdutoDAO(TelaPrincipalController.nomeArquivoJogosLoc).incluirProduto(new Produto("Jogo", nome,
								descricao, fabricante, compatibilidade, precoVenda, precoLoc));
						break;
					case "Acessorio":
						new ProdutoDAO(TelaPrincipalController.nomeArquivoAcessorios).incluirProduto(new Produto("Acessorio",
								nome, descricao, fabricante, compatibilidade, precoVenda, precoLoc));
						new ProdutoDAO(TelaPrincipalController.nomeArquivoAcessoriosLoc).incluirProduto(new Produto("Acessorio",
								nome, descricao, fabricante, compatibilidade, precoVenda, precoLoc));
						break;
					case "Console":
						new ProdutoDAO(TelaPrincipalController.nomeArquivoConsoles).incluirProduto(new Produto("Console", nome,
								descricao, fabricante, compatibilidade, precoVenda, precoLoc));
						new ProdutoDAO(TelaPrincipalController.nomeArquivoConsolesLoc).incluirProduto(new Produto("Console", nome,
								descricao, fabricante, compatibilidade, precoVenda, precoLoc));
						break;
					}

				}
				TelaProdutoController.operacao = "ok";
				br.util.Janela.fecharJanela(btn_salvar);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

//************************** METODOS AUXILIARES *********************

	private void prepararComponentes() {
		try {
			cb_tipo.setItems(FXCollections.observableArrayList("Jogo", "Acessorio", "Console"));

			cb_tipo.valueProperty().addListener(new ChangeListener<String>() {
				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					if (newValue.equals("Console")) {
						vboxCompatibilidade.setVisible(false);
						vboxCompatibilidade.setDisable(true);
						compatibilidade = "";
					} else {
						vboxCompatibilidade.setVisible(true);
						vboxCompatibilidade.setDisable(false);
					}
				}
			});
			cb_compatibilidade.setItems(FXCollections
					.observableArrayList(new ProdutoDAO(TelaPrincipalController.nomeArquivoConsoles).listarProdutos()));
			MaskTextfield.monetaryField(txf_precoLocacao);
			MaskTextfield.monetaryField(txf_precoVenda);
		} catch (Exception erro) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Atenção");
			alert.setHeaderText(null);
			alert.setContentText(erro.getMessage());
			alert.show();
		}
	}

	private void carregarDados() {
		cb_tipo.getSelectionModel().select(TelaProdutoController.produtoSelecionado.getTipo());
		cb_tipo.setDisable(true);
		txa_descricao.setText(TelaProdutoController.produtoSelecionado.getDescricao());
		txf_fabricante.setText(TelaProdutoController.produtoSelecionado.getFabricante());
		txf_nome.setText(TelaProdutoController.produtoSelecionado.getNomeProduto());
		txf_precoLocacao.setText(Float.toString(TelaProdutoController.produtoSelecionado.getValorUnitarioLocacao()));
		txf_precoVenda.setText(Float.toString(TelaProdutoController.produtoSelecionado.getValorUnitarioVenda()));
	}

}
