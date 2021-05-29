package application;
	
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
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


public class GameMode{
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 400;
	
	private Stage mainStage;
	private AnchorPane mainPane;
	private Scene mainScene,prevScene;
	
	private Shoot s;
	
	private Button mode_classic_button,mode_shoot_button,back_button;
	
	private Classic c;
	
	GameMode(Stage stage,Scene tempScene) throws FileNotFoundException
	{
		this.mainStage=stage;
		prevScene=tempScene;
		mainPane = new AnchorPane(); 
		mainScene = new Scene(mainPane, WIDTH, HEIGHT );
		c=new Classic(mainStage,mainScene,prevScene);
		s=new Shoot(mainStage,mainScene,prevScene);
	}
	
	public void run() throws FileNotFoundException
	{
		BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		mainPane.setBackground(background);
		
		Image image = new Image(("gamemodes.png"));  
	    ImageView imageView = new ImageView(image); 
	    imageView.setX(50); 
	    imageView.setY(50); 
	    imageView.setFitHeight(300); 
	    imageView.setFitWidth(300); 
	    imageView.setPreserveRatio(true);
	     
	    mainPane.getChildren().add(imageView);
		
        mainStage.setScene(mainScene);  
        mainStage.show();  
		addButtons();
		mode_classic_button.setOnAction(e -> {
			try {
				mode_classic();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		mode_shoot_button.setOnAction(e -> {
			try {
				mode_shoot();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		back_button.setOnAction(e -> back());
		
		
	}
	
	public void addButtons()
	{
	    
		mode_classic_button=new Button("CLASSIC");
		mode_classic_button.setLayoutX(130);
		mode_classic_button.setLayoutY(180);
		mode_classic_button.setMinSize(120,70);
		mode_classic_button.setMaxSize(120, 70);
		mode_classic_button.setStyle("-fx-background-color: BlueViolet");
		mode_classic_button.setTextFill(Color.WHITE);
		mode_classic_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		
		mode_shoot_button=new Button("SHOOT");
		mode_shoot_button.setLayoutX(130);
		mode_shoot_button.setLayoutY(270);
		mode_shoot_button.setMinSize(120,70);
		mode_shoot_button.setMaxSize(120, 70);
		mode_shoot_button.setStyle("-fx-background-color: BlueViolet");
		mode_shoot_button.setTextFill(Color.WHITE);
		mode_shoot_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		
		back_button=new Button("BACK");
		back_button.setLayoutX(130);
        back_button.setLayoutY(400);
        back_button.setMinSize(120, 70);
        back_button.setMaxSize(120, 70);
        back_button.setStyle("-fx-background-color: BlueViolet");
		back_button.setTextFill(Color.WHITE);
		back_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
        
        mainPane.getChildren().add(mode_classic_button);
        mainPane.getChildren().add(back_button);
        mainPane.getChildren().add(mode_shoot_button);
        
        
	}
	
	public void mode_shoot() throws FileNotFoundException
	{        
        
        s.run();
	}
	
	public void mode_classic() throws FileNotFoundException
	{        
        
        c.run();
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
