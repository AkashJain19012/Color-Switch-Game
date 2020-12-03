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
	private ArrayList<Star> stars;
	private ArrayList<colorSwitcher> colorSwitchers;
	
	private ArrayList<Group> roots;
	int flag;
	int value=80;
	
	int outside_square=1,upper_square=0;
	int outside_Circle=1,upper_Circle=0;
	int outside_X=1,upper_X=0;
	
	Game(Stage stage, Scene tempScene)
	{
		mainStage=stage;
		prevScene= tempScene;
		mainPane=new AnchorPane();
		mainScene= new Scene(mainPane, WIDTH, HEIGHT);
		obstacles=new ArrayList<Obstacle>();
		colorSwitchers = new ArrayList<colorSwitcher>();
		stars = new ArrayList<Star>();
		roots=new ArrayList<>();
	}
	
    public void run() throws FileNotFoundException
    {  
    	player=new Ball(200, 510, 7, Color.RED);
    	
    	assignObstacles();
    	assignColorSwitchers();
    	assignStars();
    	BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		mainPane.setBackground(background);
    	
    	AnimationTimer timer=new AnimationTimer() {
    		public void handle(long now) {
    			
    			checkCollide();
    			
    			player.setY(3);
    			
    			//System.out.println(player.getY());
    			
    			if(player.getY()<obstacles.get(obstacles.size()-2).getRoot().getBoundsInParent().getCenterY())
    	    	{
    				System.out.println("nacho");
    	    		assignObstacles();
    	    		try {
						assignColorSwitchers();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	    		try {
						assignStars();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	    	}
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
    						moveStars();
    						moveColorSwitchers();
    					}
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
    	if(obstacles.size()>=3)
    	{
    		Obstacle o=obstacles.get(obstacles.size()-1);
    		obstacles.add(new squareObstacle("square"));
    		
        	obstacles.get(obstacles.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-700);
        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
        	obstacles.add(new xObstacle("circle"));
        	obstacles.get(obstacles.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-1100);
        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
        	obstacles.add(new circleObstacle("cross"));
        	obstacles.get(obstacles.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-1500);
        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
    	}
    	else
    	{
    		obstacles.add(new squareObstacle("square"));
        	obstacles.get(0).create(0);
        	//System.out.println((int)obstacles.get(0).getRoot().getBoundsInParent().getCenterY());
        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
        	obstacles.add(new xObstacle("circle"));
        	obstacles.get(1).create(-400);
        	//System.out.println((int)obstacles.get(1).getRoot().getBoundsInParent().getCenterY());
        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
        	obstacles.add(new circleObstacle("cross"));
        	obstacles.get(2).create(-800);
        	//System.out.println((int)obstacles.get(2).getRoot().getBoundsInParent().getCenterY());
        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
    	}
    	
    	    	        
        for(Obstacle o:obstacles)
    	{
    		o.rotate();
    	}
        
    }
    
    void assignStars() throws FileNotFoundException
    {
    	if(stars.size()>=3)
    	{
    		Star o=stars.get(stars.size()-1);
    		stars.add(new Star());
    		
        	stars.get(stars.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-700);
        	mainPane.getChildren().add(stars.get(stars.size()-1).getRoot());
        	stars.add(new Star());
        	stars.get(stars.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-1100);
        	mainPane.getChildren().add(stars.get(stars.size()-1).getRoot());
        	stars.add(new Star());
        	stars.get(stars.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-1500);
        	mainPane.getChildren().add(stars.get(stars.size()-1).getRoot());
    	}
    	else
    	{
    		stars.add(new Star());
        	stars.get(0).create(0);
        	stars.add(new Star());
        	stars.get(1).create(-400);
        	stars.add(new Star());
        	stars.get(2).create(-800);
        	    	
            mainPane.getChildren().add(stars.get(0).getRoot());
            mainPane.getChildren().add(stars.get(1).getRoot());
            mainPane.getChildren().add(stars.get(2).getRoot());
    	}
        
    }
    
    void assignColorSwitchers() throws FileNotFoundException
    {
    	if(stars.size()>=3)
    	{
    		colorSwitcher o=colorSwitchers.get(colorSwitchers.size()-1);
    		colorSwitchers.add(new colorSwitcher());
    		
        	colorSwitchers.get(colorSwitchers.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-550);
        	mainPane.getChildren().add(colorSwitchers.get(colorSwitchers.size()-1).getRoot());
        	colorSwitchers.add(new colorSwitcher());
        	colorSwitchers.get(colorSwitchers.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-950);
        	mainPane.getChildren().add(colorSwitchers.get(colorSwitchers.size()-1).getRoot());
        	colorSwitchers.add(new colorSwitcher());
        	colorSwitchers.get(colorSwitchers.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-1350);
        	mainPane.getChildren().add(colorSwitchers.get(colorSwitchers.size()-1).getRoot());
    	}
    	else
    	{
    		colorSwitchers.add(new colorSwitcher());
        	colorSwitchers.get(0).create(-50);
        	//System.out.println((int)colorSwitchers.get(0).getRoot().getBoundsInParent().getCenterY());
        	colorSwitchers.add(new colorSwitcher());
        	colorSwitchers.get(1).create(-450);
        	//System.out.println((int)colorSwitchers.get(1).getRoot().getBoundsInParent().getCenterY());
        	colorSwitchers.add(new colorSwitcher());
        	colorSwitchers.get(2).create(-850);
        	//System.out.println((int)colorSwitchers.get(2).getRoot().getBoundsInParent().getCenterY());
        	    	
            mainPane.getChildren().add(colorSwitchers.get(0).getRoot());
            mainPane.getChildren().add(colorSwitchers.get(1).getRoot());
            mainPane.getChildren().add(colorSwitchers.get(2).getRoot());
    	}
    	
        
    }
    
    public void checkCollide() {
    	
    	int helperArr1[]=obstacles.get(obstacles.size()-3).checkCollision(player,outside_square,upper_square);
		outside_square=helperArr1[0];
		upper_square=helperArr1[1];
//		if (obstacles.size()<=3) {
//			helperArr=obstacles.get(obstacles.size()-1).checkCollision(player,outside_Circle,upper_Circle);
//		}
//		else {
//			helperArr=obstacles.get(obstacles.size()-4).checkCollision(player,outside_Circle,upper_Circle);
//		}
//		outside_Circle=helperArr[0];
//		upper_Circle=helperArr[1];
//		int helperArr3[]=new int[2];
//		if (obstacles.size()<=3) {
//			helperArr3=obstacles.get(obstacles.size()-2).checkCollision(player,outside_X,upper_X);
//		}
//		else {
//			helperArr3=obstacles.get(obstacles.size()-5).checkCollision(player,outside_X,upper_X);
//		}
//		outside_X=helperArr3[0];
//		upper_X=helperArr3[1];

    }
    
    public void moveObstacles()
    {
    	for(Obstacle o:obstacles)
    	{
    		o.moveDown();
    	}
    }
    
    public void moveStars()
    {
    	for(Star s:stars)
    	{
    		s.moveDown();
    	}
    }
    
    public void moveColorSwitchers()
    {
    	for(colorSwitcher c: colorSwitchers)
    	{
    		c.moveDown();
    	}
    }
    
    
} 
