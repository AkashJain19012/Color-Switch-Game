package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class circleObstacle extends Obstacle{
	
	

	circleObstacle(String type) {
		super(type);
	}
	
	public Group create(int y) {
		
		Path path1 = new Path();

        MoveTo moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(220+y);
        
        LineTo lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(210+y);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(210+y);
        
        ArcTo arcTo = new ArcTo();
        arcTo.setX(290);
        arcTo.setY(300+y);
        arcTo.setRadiusX(80);
        arcTo.setRadiusY(80);
        arcTo.setSweepFlag(true);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(290); 
        moveTo.setY(300+y);
        
        lineTo = new LineTo();
        lineTo.setX(280); 
        lineTo.setY(300+y);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(280); 
        moveTo.setY(300+y);
        
        arcTo = new ArcTo();
        arcTo.setX(200);
        arcTo.setY(220+y);
        arcTo.setRadiusX(70);
        arcTo.setRadiusY(70);
        arcTo.setSweepFlag(false);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(arcTo);
        
        path1.setFill(Color.RED);
        path1.setStroke(Color.RED);
        
        //SecondPart
        
        Path path2 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(280); 
        moveTo.setY(300+y);
        
        lineTo = new LineTo();
        lineTo.setX(290); 
        lineTo.setY(300+y);
        
        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(290); 
        moveTo.setY(300+y);
        
        arcTo = new ArcTo();
        arcTo.setX(200);
        arcTo.setY(390+y);
        arcTo.setRadiusX(80);
        arcTo.setRadiusY(80);
        arcTo.setSweepFlag(true);
        
//        path1.getElements().add(moveTo); 
        path2.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(390+y);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(380+y);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(380+y);
        
        arcTo = new ArcTo();
        arcTo.setX(280);
        arcTo.setY(300+y);
        arcTo.setRadiusX(70);
        arcTo.setRadiusY(70);
        arcTo.setSweepFlag(false);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(arcTo);
        
        path2.setFill(Color.BLUE);
        path2.setStroke(Color.BLUE);
        
        //ThirdPart
        
        Path path3 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(120); 
        moveTo.setY(300+y);
        
        arcTo = new ArcTo();
        arcTo.setX(200);
        arcTo.setY(380+y);
        arcTo.setRadiusX(70);
        arcTo.setRadiusY(70);
        arcTo.setSweepFlag(false);
        
        path3.getElements().add(moveTo); 
        path3.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(380+y);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(390+y);
        
//        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(390+y);
        
        arcTo = new ArcTo();
        arcTo.setX(110);
        arcTo.setY(300+y);
        arcTo.setRadiusX(80);
        arcTo.setRadiusY(80);
        arcTo.setSweepFlag(true);
        
//        path1.getElements().add(moveTo); 
        path3.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(110); 
        moveTo.setY(300+y);
        
        lineTo = new LineTo();
        lineTo.setX(120); 
        lineTo.setY(300+y);
        
//        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        path3.setFill(Color.YELLOW);
        path3.setStroke(Color.YELLOW);
        //FourthPart
        
        Path path4 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(120); 
        moveTo.setY(300+y);
        
        arcTo = new ArcTo();
        arcTo.setX(200);
        arcTo.setY(220+y);
        arcTo.setRadiusX(70);
        arcTo.setRadiusY(70);
        arcTo.setSweepFlag(true);
        
        path4.getElements().add(moveTo); 
        path4.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(220+y);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(210+y);
        
//        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(210+y);
        
        arcTo = new ArcTo();
        arcTo.setX(110);
        arcTo.setY(300+y);
        arcTo.setRadiusX(80);
        arcTo.setRadiusY(80);
        arcTo.setSweepFlag(false);
        
//        path1.getElements().add(moveTo); 
        path4.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(110); 
        moveTo.setY(300+y);
        
        lineTo = new LineTo();
        lineTo.setX(120); 
        lineTo.setY(300+y);
        
//        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        path4.setFill(Color.PURPLE);
        path4.setStroke(Color.PURPLE);
        
//        Paint p=Color.RED;
//        System.out.println(path1.getFill());
//        System.out.println(p);
//        if (p==path1.getFill()) {
//        	System.out.println("HELLO");
//        }
        
        root = new Group(path1,path2,path3,path4);
        return root;
		
	}

	@Override
	public int[] checkCollision(Ball player, int outside, int upper) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Group getRoot() {
		// TODO Auto-generated method stub
		return root;
	}
	
}
