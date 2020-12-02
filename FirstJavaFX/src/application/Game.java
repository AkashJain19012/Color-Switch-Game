package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.shape.Shape;

public class Game{ 
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 400;
	
	
	private Stage mainStage;
	private AnchorPane mainPane;
	private Scene mainScene,prevScene;
	
	private Button pause_button;
	
	private Group root_square,root_circle,root_x,root_colorswitcher;
	private colorSwitcher s1;
	
	public static Ball player;
	
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Group> roots;
	int flag;
	int value=80;
	
	int outside=1,upper=0;
//	squareObstacle o1=new squareObstacle("square");
//    circleObstacle o2=new circleObstacle("circle");
//    xObstacle o3=new xObstacle("x");
	
	Game(Stage stage, Scene tempScene)
	{
		mainStage=stage;
		prevScene= tempScene;
		mainPane=new AnchorPane();
		mainScene= new Scene(mainPane, WIDTH, HEIGHT);
		obstacles=new ArrayList<Obstacle>();
		roots=new ArrayList<>();
	}
	
    public void run() throws FileNotFoundException
    {  
    	player=new Ball(200, 510, 7, Color.RED);
    	
    	assignObstacles();
    	assigncolorSwitcher();
    	BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		mainPane.setBackground(background);
    	
    	AnimationTimer timer=new AnimationTimer() {
    		public void handle(long now) {
    			int helperArr[]=obstacles.get(0).checkCollision(player,outside,upper);
    			outside=helperArr[0];
    			upper=helperArr[1];
    			player=s1.checkCollision(player);
    			player.setY(3);
    		}
    	};
    	
    	timer.start();
    	
    	mainScene.setOnKeyPressed(e -> {
    		if(e.getCode() == KeyCode.A){
    			
    			flag=0;
    			AnimationTimer timer2=new AnimationTimer() {
    				public void handle(long now) {
    					if((player.getY()-20) > HEIGHT/2)
    					{
    						player.setY(-6);
    					}
    					else
    					{
    						player.setY(-6);
    						moveObstacles();
    					}
    					//root.setLayoutY(root.getLayoutY()+1);
    					player=s1.checkCollision(player);
    					flag++;
    					if (flag>30) {
    						stop();
    					}
    				}
    			};
    			timer2.start();
    		}
        });
    	
    	mainStage.setScene(mainScene);
        mainStage.show();
        addButtons();
        
        
        StackPane sp = new StackPane();
        
        mainPane.getChildren().add(sp);
        mainPane.getChildren().add(player);
                
        Star star=new Star();
        Group root2=star.create();
        mainPane.getChildren().add(root2);
        
//        s1=new colorSwitcher();
//        //Group root1=s1.create();
//        s1.create();
//        root_colorswitcher=s1.getRoot();
//        mainPane.getChildren().add(root_colorswitcher);
        
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
    
    void assignObstacles()
    {
    	obstacles.add(new squareObstacle("square"));
    	obstacles.get(0).create(0);
    	root_square=obstacles.get(0).getRoot();
    	obstacles.add(new xObstacle("circle"));
    	obstacles.get(1).create(-250);
    	root_circle=obstacles.get(1).getRoot();
    	obstacles.add(new circleObstacle("cross"));
    	obstacles.get(2).create(-500);
    	root_x=obstacles.get(2).getRoot();
    	    	
        mainPane.getChildren().add(root_square);
        mainPane.getChildren().add(root_x);
        mainPane.getChildren().add(root_circle);
    	
//        obstacles.get(0).rotate();
//        obstacles.get(1).rotate();
//        obstacles.get(2).rotate();
        
        for(Obstacle o:obstacles)
    	{
    		o.rotate();
    	}
        
    }
    
    void assigncolorSwitcher() {
    	
        s1=new colorSwitcher();
        //Group root1=s1.create();
        s1.create(0);
        root_colorswitcher=s1.getRoot();
        mainPane.getChildren().add(root_colorswitcher);
    }

    public void moveObstacles()
    {
    	for(Obstacle o:obstacles)
    	{
    		o.moveDown();
    	}
    }
} 
