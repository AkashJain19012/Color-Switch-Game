package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;


public class Classic{
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 400;
	
	private Stage mainStage;
	private AnchorPane mainPane;
	private Scene mainScene,prevScene;
	
	private Button play_button,resume_button,back_button;
	
	public Classic(Stage stage, Scene tempScene) throws FileNotFoundException
	{
		mainPane = new AnchorPane(); 
		mainScene = new Scene(mainPane, WIDTH, HEIGHT );
		mainStage = stage;
		prevScene=tempScene;
		run();
		
	}
	
	public void run() throws FileNotFoundException
	{
		BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		mainPane.setBackground(background);
		
        mainStage.setScene(mainScene);  
        mainStage.show();  
		addButtons();
		
		
		play_button.setOnAction(e->{
			try {
				play();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		resume_button.setOnAction( e-> {
			resume();
		});
		
		back_button.setOnAction(e -> {
			back();
		});
	}
	
	public void addButtons()
	{
		play_button=new Button("PLAY");
		play_button.setLayoutX(130);
		play_button.setLayoutY(150);
		play_button.setMinSize(120,70);
		play_button.setMaxSize(120, 70);
		play_button.setStyle("-fx-background-color: BlueViolet");
		play_button.setTextFill(Color.WHITE);
		play_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		
		resume_button=new Button("RESUME");
		resume_button.setLayoutX(130);
		resume_button.setLayoutY(250);
		resume_button.setMinSize(120,70);
		resume_button.setMaxSize(120, 70);
		resume_button.setStyle("-fx-background-color: BlueViolet");
		resume_button.setTextFill(Color.WHITE);
		resume_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		
		back_button=new Button("BACK");
		back_button.setLayoutX(130);
        back_button.setLayoutY(350);
        back_button.setMinSize(120, 70);
        back_button.setMaxSize(120, 70);
        back_button.setStyle("-fx-background-color: BlueViolet");
		back_button.setTextFill(Color.WHITE);
		back_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
        
        mainPane.getChildren().add(play_button);
        mainPane.getChildren().add(resume_button);
        mainPane.getChildren().add(back_button);
        
        
	}
	
	public void play() throws FileNotFoundException
	{
		Game g=new Game(mainStage,mainScene);
		g.run();
		
	}
	
	public void resume()
	{
		
	}
	
	public void back()
	{        
        mainStage.setScene(prevScene);
	}
	
	public Stage getMainStage()
	{
		return mainStage;
	}

}
