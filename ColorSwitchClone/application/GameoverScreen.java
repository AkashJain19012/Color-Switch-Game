package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameoverScreen {
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 400;
	
	private Stage mainStage;
	private AnchorPane mainPane;
	private Scene mainScene,prevScene,homeScene;
	
	private static boolean closed;
	
	
	private Button home_button;
	private Label name_field;
	
	GameoverScreen(Stage stage,Scene tempScene,Scene homeScene)
	{
		
		this.mainStage=stage;
		prevScene=tempScene;
		closed=false;
		mainPane = new AnchorPane(); 
		mainScene = new Scene(mainPane, WIDTH, HEIGHT );
		this.homeScene=homeScene;
	}
	
	public void run() throws FileNotFoundException 
	{
		
		
		BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		mainPane.setBackground(background);
		
		mainStage.setScene(mainScene);  
        mainStage.show(); 
        addButtons();
        
        home_button.setOnAction(e -> {
        	
			backToHome();
		});
        
	}
	
	private void backToHome() {
		// TODO Auto-generated method stub
		closed=true;
		mainStage.setScene(homeScene);
		
	}
	
	public void addButtons() throws FileNotFoundException 
	{
		

		
//		name_field = new Label ();
//		name_field.setText("GAME OVER");
//		name_field.setLayoutX(150);
//		name_field.setLayoutY(360);
//		name_field.setPrefSize(120, 70);
//		name_field.setStyle("-fx-background-color: White");
//		name_field.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
//		name_field.setAlignment(Pos.BASELINE_CENTER);
		
		Image image = new Image("gameover.png");    
	    ImageView imageView = new ImageView(image);
	    imageView.setX(70); 
	    imageView.setY(150);
	    imageView.setFitHeight(250); 
	    imageView.setFitWidth(250);
	    imageView.setPreserveRatio(true);
	     
	    mainPane.getChildren().add(imageView);
		
		Image img1 = new Image(("home.png"));  
	    ImageView view1 = new ImageView(img1);
	    view1.setFitHeight(50);
	    view1.setPreserveRatio(true);
	    home_button = new Button();
	    home_button.setTranslateX(0);
	    home_button.setTranslateY(0);
	    home_button.setPrefSize(50, 50);
	    home_button.setGraphic(view1);
	    home_button.setStyle("-fx-background-color: transparent;");
	    
	    
		
//		mainPane.getChildren().add(pause_label);
		mainPane.getChildren().add(home_button);
//		mainPane.getChildren().add(name_field);
	}
}