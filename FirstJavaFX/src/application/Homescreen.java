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


public class Homescreen{
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 400;
	
	private Stage mainStage;
	private AnchorPane mainPane;
	private Scene mainScene;
	
	private Button start_button,exit_button;
	
	private GameMode game;
	
	public Homescreen() throws FileNotFoundException
	{
		mainPane = new AnchorPane(); 
		mainScene = new Scene(mainPane, WIDTH, HEIGHT );
		mainStage = new Stage();
		game = new GameMode(mainStage,mainScene);
		run();
		
	}
	
	public void run() throws FileNotFoundException
	{
		BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		mainPane.setBackground(background);
		
		Image image = new Image(("colorswitch.png"));    
	    ImageView imageView = new ImageView(image);
	    imageView.setX(50); 
	    imageView.setY(50);
	    imageView.setFitHeight(300); 
	    imageView.setFitWidth(300);
	    imageView.setPreserveRatio(true);
	     
	    mainPane.getChildren().add(imageView);
		
        mainStage.setScene(mainScene);  
        mainStage.setTitle("COLOR SWITCH"); 
        mainStage.getIcons().add(new Image(("icon.png")));
        mainStage.show();  
        
		addButtons();
		
		start_button.setOnAction(e->{
			try {
				start();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		
		exit();
	}
	
	public void addButtons()
	{
		start_button=new Button("START");
		start_button.setLayoutX(130);
		start_button.setLayoutY(300);
		start_button.setPrefSize(120, 70);
		start_button.setStyle("-fx-background-color: BlueViolet");
		start_button.setTextFill(Color.WHITE);
		start_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		
		exit_button=new Button("EXIT");
		exit_button.setLayoutX(130);
        exit_button.setLayoutY(400);
        exit_button.setPrefSize(120, 70);
        exit_button.setStyle("-fx-background-color: BlueViolet");
		exit_button.setTextFill(Color.WHITE);
		exit_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
        
        mainPane.getChildren().add(start_button);
        mainPane.getChildren().add(exit_button);
        
//        Image img = new Image("start.png");
//	      ImageView view = new ImageView(img);
//	      view.setFitHeight(80);
//	      view.setPreserveRatio(true);
//	      view.setX(120);
//	      view.setY(280);
//	      view.setFitHeight(70);
//	      view.setFitWidth(120);
//	      mainPane.getChildren().add(view);
        
	}
	
	public void start() throws FileNotFoundException
	{
		game.run();
		
	}
	
	public void exit()
	{        
        exit_button.setOnAction(e -> System.exit(0));
	}
	
	public Stage getMainStage()
	{
		return mainStage;
	}

}
