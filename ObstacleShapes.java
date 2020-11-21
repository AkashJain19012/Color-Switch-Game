package application;
/*ObstacleShapes*/

import java.awt.Insets;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
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
        
        
        //FirstPart
        Path path1 = new Path();
        MoveTo moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(220);
        
        LineTo lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(210);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(210);
        
        lineTo = new LineTo();
        lineTo.setX(290); 
        lineTo.setY(300);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(290); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(280); 
        lineTo.setY(300);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(280); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(220);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        path1.setFill(Color.RED);
        path1.setStroke(Color.RED);
        
        //SecondPart
        
        Path path2 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(280); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(290); 
        lineTo.setY(300);
        
        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(290); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(390);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(390);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(380);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(380);
        
        lineTo = new LineTo();
        lineTo.setX(280); 
        lineTo.setY(300);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        path2.setFill(Color.BLUE);
        path2.setStroke(Color.BLUE);
        
        //ThirdPart
        
        Path path3 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(120); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(380);
        
        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(380);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(390);
        
//        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(390);
        
        lineTo = new LineTo();
        lineTo.setX(110); 
        lineTo.setY(300);
        
//        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(110); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(120); 
        lineTo.setY(300);
        
//        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        path3.setFill(Color.YELLOW);
        path3.setStroke(Color.YELLOW);
        
        //FourthPart
        
        Path path4 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(120); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(220);
        
        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(220);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(210);
        
//        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(210);
        
        lineTo = new LineTo();
        lineTo.setX(110); 
        lineTo.setY(300);
        
//        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(110); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(120); 
        lineTo.setY(300);
        
//        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        path4.setFill(Color.PURPLE);
        path4.setStroke(Color.PURPLE);
        
        /*
      //FirstPart
        
        Path path1 = new Path();

        MoveTo moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(220);
        
        LineTo lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(210);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(210);
        
        ArcTo arcTo = new ArcTo();
        arcTo.setX(290);
        arcTo.setY(300);
        arcTo.setRadiusX(80);
        arcTo.setRadiusY(80);
        arcTo.setSweepFlag(true);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(290); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(280); 
        lineTo.setY(300);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(280); 
        moveTo.setY(300);
        
        arcTo = new ArcTo();
        arcTo.setX(200);
        arcTo.setY(220);
        arcTo.setRadiusX(70);
        arcTo.setRadiusY(70);
        arcTo.setSweepFlag(false);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(arcTo);
        path1.setFill(Color.RED);
        path1.setStroke(Color.RED);
        
        //SecondPart
        
        Path path2 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(280); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(290); 
        lineTo.setY(300);
        
        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(290); 
        moveTo.setY(300);
        
        arcTo = new ArcTo();
        arcTo.setX(200);
        arcTo.setY(390);
        arcTo.setRadiusX(80);
        arcTo.setRadiusY(80);
        arcTo.setSweepFlag(true);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(390);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(380);
        
        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(380);
        
        arcTo = new ArcTo();
        arcTo.setX(280);
        arcTo.setY(300);
        arcTo.setRadiusX(70);
        arcTo.setRadiusY(70);
        arcTo.setSweepFlag(false);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(arcTo);
        
        //ThirdPart
        
        Path path3 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(120); 
        moveTo.setY(300);
        
        arcTo = new ArcTo();
        arcTo.setX(200);
        arcTo.setY(380);
        arcTo.setRadiusX(70);
        arcTo.setRadiusY(70);
        arcTo.setSweepFlag(false);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(380);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(390);
        
        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(390);
        
        arcTo = new ArcTo();
        arcTo.setX(110);
        arcTo.setY(300);
        arcTo.setRadiusX(80);
        arcTo.setRadiusY(80);
        arcTo.setSweepFlag(true);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(110); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(120); 
        lineTo.setY(300);
        
        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        //FourthPart
        
        Path path4 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(120); 
        moveTo.setY(300);
        
        arcTo = new ArcTo();
        arcTo.setX(200);
        arcTo.setY(220);
        arcTo.setRadiusX(70);
        arcTo.setRadiusY(70);
        arcTo.setSweepFlag(true);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(220);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(210);
        
        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(210);
        
        arcTo = new ArcTo();
        arcTo.setX(110);
        arcTo.setY(300);
        arcTo.setRadiusX(80);
        arcTo.setRadiusY(80);
        arcTo.setSweepFlag(false);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(110); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(120); 
        lineTo.setY(300);
        
        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        */
        /*
      //FirstPart
        Path path1 = new Path();
        MoveTo moveTo = new MoveTo(); 
        moveTo.setX(140); 
        moveTo.setY(300);
        
        LineTo lineTo = new LineTo();
        lineTo.setX(135); 
        lineTo.setY(295);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(135); 
        moveTo.setY(295);
        
        lineTo = new LineTo();
        lineTo.setX(135); 
        lineTo.setY(220);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(135); 
        moveTo.setY(220);
        
        lineTo = new LineTo();
        lineTo.setX(145); 
        lineTo.setY(220);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo();
        moveTo.setX(145); 
        moveTo.setY(220);
        
        lineTo = new LineTo();
        lineTo.setX(145); 
        lineTo.setY(295);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(145); 
        moveTo.setY(295);
        
        lineTo = new LineTo();
        lineTo.setX(140); 
        lineTo.setY(300);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        path1.setFill(Color.RED);
        path1.setStroke(Color.RED);
        
        //SecondPart
        Path path2 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(140); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(145); 
        lineTo.setY(295);
        
        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(145); 
        moveTo.setY(295);
        
        lineTo = new LineTo();
        lineTo.setX(220); 
        lineTo.setY(295);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(220); 
        moveTo.setY(295);
        
        lineTo = new LineTo();
        lineTo.setX(220); 
        lineTo.setY(305);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(220); 
        moveTo.setY(305);
        
        lineTo = new LineTo();
        lineTo.setX(145); 
        lineTo.setY(305);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(145); 
        moveTo.setY(305);
        
        lineTo = new LineTo();
        lineTo.setX(140); 
        lineTo.setY(300);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        path2.setFill(Color.BLUE);
        path2.setStroke(Color.BLUE);
        
        //ThirdPart
        
        Path path3 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(140); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(145); 
        lineTo.setY(305);
        
        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(145); 
        moveTo.setY(305);
        
        lineTo = new LineTo();
        lineTo.setX(145); 
        lineTo.setY(380);
        
//        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(145); 
        moveTo.setY(380);
        
        lineTo = new LineTo();
        lineTo.setX(135); 
        lineTo.setY(380);
        
//        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(135); 
        moveTo.setY(380);
        
        lineTo = new LineTo();
        lineTo.setX(135); 
        lineTo.setY(305);
        
//        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(135); 
        moveTo.setY(305);
        
        lineTo = new LineTo();
        lineTo.setX(140); 
        lineTo.setY(300);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        path3.setFill(Color.YELLOW);
        path3.setStroke(Color.YELLOW);
        
        //FourthPart
        
        Path path4 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(140); 
        moveTo.setY(300);
        
        lineTo = new LineTo();
        lineTo.setX(135); 
        lineTo.setY(305);
        
        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(135); 
        moveTo.setY(305);
        
        lineTo = new LineTo();
        lineTo.setX(60); 
        lineTo.setY(305);
        
//        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(60); 
        moveTo.setY(305);
        
        lineTo = new LineTo();
        lineTo.setX(60); 
        lineTo.setY(295);
        
//        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(60); 
        moveTo.setY(295);
        
        lineTo = new LineTo();
        lineTo.setX(135); 
        lineTo.setY(295);
        
//        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(135); 
        moveTo.setY(295);
        
        lineTo = new LineTo();
        lineTo.setX(140); 
        lineTo.setY(300);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        path4.setFill(Color.PURPLE);
        path4.setStroke(Color.PURPLE);
        */
        Group root = new Group(path1,path2,path3,path4);
        
        
        //Group root = new Group(path1);
        pane.getChildren().add(root);
        
        
        
        
        RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setRate(0.1);
        rotate.setCycleCount(20);
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