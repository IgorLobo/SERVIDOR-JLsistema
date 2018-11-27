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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class TelaProdutoIncluirController implements Initializable{
	
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
		if(TelaProdutoController.operacao.equals("alterar"))carregarDados();
	}
	
	@FXML
    void OnClick_btn_cancelar(ActionEvent event) {
		br.util.Janela.fecharJanela(btn_cancelar);
    }

    @FXML
    void OnClick_btn_salvar(ActionEvent event) {
    	try {
    	String nome = txf_nome.getText();
    	Float precoVenda = br.util.MaskTextfield.monetaryValueFromField(txf_precoVenda).floatValue();
    	Float precoLoc = br.util.MaskTextfield.monetaryValueFromField(txf_precoLocacao).floatValue();;
    	String descricao = txa_descricao.getText();
    	String fabricante = txf_fabricante.getText();
    	if(!cb_tipo.getSelectionModel().getSelectedItem().equals("Console")) {
    	compatibilidade = cb_compatibilidade.getSelectionModel().getSelectedItem().toString();
    	}else {compatibilidade = " ";}
    	
    	if(TelaProdutoController.operacao.equals("alterar")) {
    		cb_tipo.setDisable(true);
    		switch (cb_tipo.getSelectionModel().getSelectedItem()) {
			case "Jogo":
				new ProdutoDAO(TelaPrincipalController.nomeArquivoJogos).alterar(TelaProdutoController.produtoSelecionado.getCodProduto(),
						new Produto(1, nome, descricao, fabricante, precoVenda, precoLoc, compatibilidade));	
				break;
			case "Acessorio":
				new ProdutoDAO(TelaPrincipalController.nomeArquivoAcessorios).alterar(TelaProdutoController.produtoSelecionado.getCodProduto(),
						new Produto(1, nome, descricao, fabricante, precoVenda, precoLoc, compatibilidade));	
				break;
			case "Console":
				new ProdutoDAO(TelaPrincipalController.nomeArquivoConsoles).alterar(TelaProdutoController.produtoSelecionado.getCodProduto(),
						new Produto(1, nome, descricao, fabricante, precoVenda, precoLoc, compatibilidade));	
				break;

			}
    		br.util.Janela.fecharJanela(btn_salvar);
    	}else {
				switch (cb_tipo.getSelectionModel().getSelectedItem()) {

				case "Jogo":
					new ProdutoDAO(TelaPrincipalController.nomeArquivoJogos)
							.incluir( new Produto(1, nome,descricao, fabricante, precoVenda, precoLoc, compatibilidade));
					break;
				case "Acessorio":
					new ProdutoDAO(TelaPrincipalController.nomeArquivoAcessorios)
							.incluir( new Produto(1, nome,descricao, fabricante, precoVenda, precoLoc, compatibilidade));
					break;
				case "Console":
					new ProdutoDAO(TelaPrincipalController.nomeArquivoConsoles)
							.incluir( new Produto(1, nome,descricao, fabricante, precoVenda, precoLoc, compatibilidade));
					break;
    		}
			
    	}
    	TelaProdutoController.operacao = "ok";
    	br.util.Janela.fecharJanela(btn_salvar);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }

//************************** METODOS AUXILIARES *********************

	 private void prepararComponentes() {
		 try {
		 cb_tipo.setItems(FXCollections.observableArrayList("Jogo","Acessorio","Console"));
		 
		 /*cb_tipo.valueProperty().addListener(new ChangeListener<String>() {
			 @Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if(newValue.equals("Console")) {
					vboxCompatibilidade.setVisible(false);
					vboxCompatibilidade.setDisable(true);
					compatibilidade = "";
				}else {
					vboxCompatibilidade.setVisible(true);
					vboxCompatibilidade.setDisable(false);
				}
			}
		});*/
		 //cb_compatibilidade.setItems(FXCollections.observableArrayList(new ProdutoDAO(TelaPrincipalController.nomeArquivoConsoles).listar()));
		 MaskTextfield.monetaryField(txf_precoLocacao);
		 MaskTextfield.monetaryField(txf_precoVenda);
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
	 }


	private void carregarDados() {
		txa_descricao.setText(TelaProdutoController.produtoSelecionado.getDescricao());
		txf_fabricante.setText(TelaProdutoController.produtoSelecionado.getFabricante());
		txf_nome.setText(TelaProdutoController.produtoSelecionado.getNomeProduto());
		txf_precoLocacao.setText(Float.toString(TelaProdutoController.produtoSelecionado.getValorUnitarioLocacao()));
		txf_precoVenda.setText(Float.toString(TelaProdutoController.produtoSelecionado.getValorUnitarioVenda()));
	}

}
