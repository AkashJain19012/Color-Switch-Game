package application;
/*ObstacleShapes*/

import java.awt.Insets;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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
import javafx.scene.transform.Rotate; 

public class ObstacleShapes extends Application { 
	
	public static Ball player;
	AnchorPane pane;
	int flag;
	
    public void start(Stage stage) throws FileNotFoundException
    {  
    	player=new Ball(200, 10, 7, Color.RED);
    	
    	pane=new AnchorPane();
    	Scene sc = new Scene(pane, 400, 600);
    	AnimationTimer timer=new AnimationTimer() {
    		public void handle(long now) {
    			player.moveDown();
    		}
    	};
    	
    	timer.start();
    	
    	sc.setOnKeyPressed(e -> {
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
    	
    	stage.setScene(sc); 
        stage.setTitle("Bounce");
        stage.show();
        
        
        StackPane sp = new StackPane();
        Image img = new Image("blackbg.jpg");
        ImageView imgView = new ImageView(img);
        imgView.setX(50); 
        imgView.setY(25); 
         
        imgView.setFitHeight(600); 
        imgView.setFitWidth(400);
        sp.getChildren().add(imgView);
        
        pane.getChildren().add(sp);
        pane.getChildren().add(player);
        
        squareObstacle o1=new squareObstacle("square");
        circleObstacle o2=new circleObstacle("circle");
        xObstacle o3=new xObstacle("x");
        Group root=o3.create();
        pane.getChildren().add(root);
        
        Star star=new Star();
        Group root2=star.create();
        pane.getChildren().add(root2);
        
        colorSwitcher s1=new colorSwitcher();
        Group root1=s1.create();
        pane.getChildren().add(root1);
       
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setRate(0.1);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.INDEFINITE); 
        rotate.setNode(root);
        rotate.play();

    } 
    
    public static void main(String args[]) 
    { 
        // launch the application 
        launch(args); 
    } 
} 