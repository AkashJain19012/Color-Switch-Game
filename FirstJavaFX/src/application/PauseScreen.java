package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PauseScreen {
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 400;
	
	private Stage mainStage;
	private AnchorPane mainPane;
	private Scene mainScene,prevScene;
	
	private Button resume_button,save_button,home_button;
	private Label pause_label;
	
	
	PauseScreen(Stage stage,Scene tempScene){
		
		this.mainStage=stage;
		prevScene=tempScene;
		mainPane = new AnchorPane(); 
		mainScene = new Scene(mainPane, WIDTH, HEIGHT );
	}
	
	
	public void run() throws FileNotFoundException {
		
		BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		mainPane.setBackground(background);
		
		mainStage.setScene(mainScene);  
        mainStage.show(); 
        addButtons();
        
        resume_button.setOnAction(e -> back());
	}
	
	public void addButtons() throws FileNotFoundException {
		
		pause_label = new Label("PAUSE");
		pause_label.setLayoutX(150);
		pause_label.setLayoutY(200);
		pause_label.setTextFill(Color.WHITE);
		pause_label.setFont(Font.font ("Verdana",FontWeight.BOLD, 25));
		
		/*
		Image img1 = new Image(new FileInputStream("D:\\Eclipse (Java Projects) 1\\APProject\\src\\Images\\play2.png"));  
	    ImageView view1 = new ImageView(img1);
	    view1.setFitHeight(80);
	    view1.setPreserveRatio(true);
	    resume_button = new Button();
	    resume_button.setTranslateX(150);
	    resume_button.setTranslateY(250);
	    resume_button.setPrefSize(80, 80);
	    resume_button.setGraphic(view1);
	    */
		
		resume_button=new Button("RESUME");
		resume_button.setLayoutX(150);
		resume_button.setLayoutY(200);
		resume_button.setMinSize(120,70);
		resume_button.setMaxSize(120, 70);
		resume_button.setStyle("-fx-background-color: BlueViolet");
		resume_button.setTextFill(Color.WHITE);
		resume_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
	    
	    save_button=new Button("SAVE");
		save_button.setLayoutX(150);
		save_button.setLayoutY(300);
		save_button.setMinSize(120,70);
		save_button.setMaxSize(120, 70);
		save_button.setStyle("-fx-background-color: BlueViolet");
		save_button.setTextFill(Color.WHITE);
		save_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		
		Image img1 = new Image(new FileInputStream("D:\\Eclipse (Java Projects) 1\\APProject\\src\\Images\\home.png"));  
	    ImageView view1 = new ImageView(img1);
	    view1.setFitHeight(50);
	    view1.setPreserveRatio(true);
	    home_button = new Button();
	    home_button.setTranslateX(0);
	    home_button.setTranslateY(0);
	    home_button.setPrefSize(50, 50);
	    home_button.setGraphic(view1);
	    home_button.setStyle("-fx-background-color: transparent;");
		
		mainPane.getChildren().add(pause_label);
		mainPane.getChildren().add(resume_button);
		mainPane.getChildren().add(save_button);
		mainPane.getChildren().add(home_button);
	}
	
	public void back()
	{        
        mainStage.setScene(prevScene);
	}
	

}
