package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
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

public class BallBouncePress2 extends Application { 
	
	public static Ball player;
	AnchorPane pane;
	int flag;
	
    public void start(Stage stage) throws FileNotFoundException
    {  
    	player=new Ball(375, 10, 15, Color.RED);
    	
    	pane=new AnchorPane();
    	Scene sc = new Scene(pane, 800, 600);
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
    					if (flag>40) {
    						stop();
    					}
    				}
    			};
    			//System.out.println("HEY");
    			timer2.start();
    			//timer2.stop();
    			
    			//player.moveUp();
    		}
        });
    	
    	stage.setScene(sc); 
        stage.setTitle("Bounce");
        stage.show();
        
        pane.getChildren().add(player);
        /*
        Image image1 = new Image(new FileInputStream("C:\\Users\\91782\\Desktop\\Images\\red.png"));
        Image image2 = new Image(new FileInputStream("C:\\Users\\91782\\Desktop\\Images\\yellow.png"));
        Image image3 = new Image(new FileInputStream("C:\\Users\\91782\\Desktop\\Images\\green.png"));
        Image image4 = new Image(new FileInputStream("C:\\Users\\91782\\Desktop\\Images\\blue.png"));
        ImageView imageView1 = new ImageView(image1);
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);
        
        imageView1.setX(0); 
        imageView1.setY(0); 
        imageView2.setX(100); 
        imageView2.setY(25); 
        imageView3.setX(50); 
        imageView3.setY(75); 
        imageView4.setX(50); 
        imageView4.setY(85); 
        
        Group root=new Group(imageView1,imageView2,imageView3,imageView4, player);
        
        pane.getChildren().add(root);
  		*/
    } 
    
    public static void main(String args[]) 
    { 
        // launch the application 
        launch(args); 
    } 
} 