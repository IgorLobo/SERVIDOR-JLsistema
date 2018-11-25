package br.application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	public static Stage mainStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(this.getClass().getResource("/br/view/TelaPrincipal.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add("/br/view/application.css");
			mainStage = primaryStage;
			primaryStage.setScene(scene);
			//primaryStage.setMaximized(true);
			//primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
