package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.Group;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo; 
import javafx.scene.shape.MoveTo; 
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate; 

public class Game{ 
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 400;
	
	private Stage mainStage;
	private AnchorPane mainPane;
	private Scene mainScene,prevScene;
	
	private Button pause_button;
	
	public static Ball player;
	int flag;
	
	Game(Stage stage, Scene tempScene)
	{
		mainStage=stage;
		prevScene= tempScene;
		mainPane=new AnchorPane();
		mainScene= new Scene(mainPane, WIDTH, HEIGHT);
	}
	
    public void run() throws FileNotFoundException
    {  
    	player=new Ball(200, 10, 7, Color.RED);
    	
    	
    	BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		mainPane.setBackground(background);
    	
    	AnimationTimer timer=new AnimationTimer() {
    		public void handle(long now) {
    			player.moveDown();
    		}
    	};
    	
    	timer.start();
    	
    	mainScene.setOnKeyPressed(e -> {
    		if(e.getCode() == KeyCode.A){
    			
    			flag=0;
    			AnimationTimer timer2=new AnimationTimer() {
    				public void handle(long now) {
    					player.moveUp();
    					flag++;
    					if (flag>30) {
    						stop();
    					}
    				}
    			};
    			timer2.start();;
    		}
        });
    	
    	mainStage.setScene(mainScene);
        mainStage.show();
        addButtons();
        
        
        StackPane sp = new StackPane();
        
        mainPane.getChildren().add(sp);
        mainPane.getChildren().add(player);
        
        squareObstacle o1=new squareObstacle("square");
        circleObstacle o2=new circleObstacle("circle");
        xObstacle o3=new xObstacle("x");
        Group root=o1.create();
        mainPane.getChildren().add(root);
        
        Star star=new Star();
        Group root2=star.create();
        mainPane.getChildren().add(root2);
        
        colorSwitcher s1=new colorSwitcher();
        Group root1=s1.create();
        mainPane.getChildren().add(root1);
       
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setRate(0.1);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.INDEFINITE); 
        rotate.setNode(root);
        rotate.play();
        
        pause_button.setOnAction(e -> {
        	pause();
        });

    }
    
	public void addButtons()
	{
		pause_button=new Button("||");
		pause_button.setLayoutX(340);
		pause_button.setLayoutY(0);
		pause_button.setPrefSize(60, 40);
		pause_button.setStyle("-fx-background-color: BlueViolet");
		pause_button.setTextFill(Color.WHITE);
		pause_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		
        mainPane.getChildren().add(pause_button);
        
	}
    
    public void pause()
    {
    	System.exit(0);
    }

} 