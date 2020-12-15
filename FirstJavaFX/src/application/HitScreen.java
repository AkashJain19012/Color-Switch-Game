package application;

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

public class HitScreen {
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 400;
	
	private Button useStars_button,exit_button,home_button;
	
	private Stage mainStage;
	private AnchorPane mainPane;
	private Scene mainScene,prevScene,homeScene;
	private Label hit_label;
	
	private boolean useStar;
	
	HitScreen(Stage stage,Scene tempScene,Scene homeScene)
	{
		useStar=false;
		this.mainStage=stage;
		prevScene=tempScene;
		mainPane = new AnchorPane(); 
		mainScene = new Scene(mainPane, WIDTH, HEIGHT );
		this.homeScene=homeScene;
	}
	
	public void run() 
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
        
        exit_button.setOnAction(e -> {
        	exit();
        });
        
        useStars_button.setOnAction(e -> {
        	//System.out.println("save button");
        	useStars();
        });
	}
	
	
	private void backToHome() {
		// TODO Auto-generated method stub
		mainStage.setScene(homeScene);
		
	}

	private void useStars() {
		// TODO Auto-generated method stub
		useStar=true;
		mainStage.setScene(prevScene);
		
		
	}

	private void exit() {
		// TODO Auto-generated method stub
		System.exit(0);
	}
	
	public boolean getUseStar()
	{
		return useStar;
	}

	public void setUseStar()
	{
		useStar=false;
	}
	public void addButtons() {
		
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
	    
	    useStars_button=new Button("useStars");
		useStars_button.setLayoutX(150);
		useStars_button.setLayoutY(200);
		useStars_button.setMinSize(120,70);
		useStars_button.setMaxSize(120, 70);
		useStars_button.setStyle("-fx-background-color: BlueViolet");
		useStars_button.setTextFill(Color.WHITE);
		useStars_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
	    
	    exit_button=new Button("EXIT");
	    exit_button.setLayoutX(150);
		exit_button.setLayoutY(300);
		exit_button.setMinSize(120,70);
		exit_button.setMaxSize(120, 70);
		exit_button.setStyle("-fx-background-color: BlueViolet");
		exit_button.setTextFill(Color.WHITE);
		exit_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		
		hit_label=new Label("HIT!");
		hit_label.setLayoutX(180);
		hit_label.setLayoutY(150);
		hit_label.setTextFill(Color.WHITE);
		hit_label.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		hit_label.setStyle("-fx-background-color: transparent;");
	    
	    mainPane.getChildren().add(home_button);
	    mainPane.getChildren().add(useStars_button);
	    mainPane.getChildren().add(exit_button);
	    mainPane.getChildren().add(hit_label);
	    
		
	}


}
