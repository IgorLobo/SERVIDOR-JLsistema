package br.application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Screen;
import javafx.stage.Stage;


public class Main extends Application {
	public static Stage mainStage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(this.getClass().getResource("/br/view/TelaPrincipal.fxml"));
			Scene scene = new Scene(root);
			mainStage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.getIcons().add(new Image("/br/images/JLsistemaLOGO.png"));
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
