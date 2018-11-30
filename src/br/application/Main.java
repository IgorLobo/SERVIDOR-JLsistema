package br.application;
	
import java.util.Locale;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {
	public static Stage mainStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Locale.setDefault(Locale.US);
			Parent root = FXMLLoader.load(this.getClass().getResource("/br/view/TelaPrincipal.fxml"));
			Scene scene = new Scene(root);
			mainStage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight());
			primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
