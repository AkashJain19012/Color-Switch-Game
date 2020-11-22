package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class squareObstacle extends Obstacle {
	
	squareObstacle(String type){
		super(type);
	}
	
	Group create() {
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
        
        Group root = new Group(path1,path2,path3,path4);
        return root;
	}

}
