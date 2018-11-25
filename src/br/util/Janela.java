package br.util;

import java.io.IOException;


import br.application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Janela {

	public void novaJanelaComOwner(String caminhoFXML,boolean resizable) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource(caminhoFXML));
		    Scene scene = new Scene(root);
		    Stage stage = new Stage();
		    stage.setScene(scene);
		    stage.setResizable(resizable);
		    stage.initOwner(Main.mainStage);
		    stage.initModality(Modality.APPLICATION_MODAL);
		    stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void novaJanela(String caminhoFXML,boolean resizable) {
		try {
			Parent root;
			root = FXMLLoader.load(getClass().getResource(caminhoFXML));
		    Scene scene = new Scene(root);
		    Stage stage = new Stage();
		    stage.setScene(scene);
		    stage.setResizable(resizable);
		    stage.show();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
