/*--module-path "C:\Users\AKASH\Downloads\openjfx-15.0.1_windows-x64_bin-sdk\javafx-sdk-15.0.1\lib" --add-modules javafx.controls,javafx.fxml*/

package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Homescreen h=new Homescreen();
			primaryStage= h.getMainStage();
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
