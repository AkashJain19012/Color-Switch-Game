package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class squareObstacle extends Obstacle {
	
	private Path path1,path2,path3,path4;
	
	squareObstacle(String type){
		super(type);
		path1=new Path();
		path2=new Path();
		path3=new Path();
		path4=new Path();
	}
	
	void getlowestPath() {
		/*
		System.out.println(path1.getBoundsInLocal().getCenterY());
		System.out.println(path2.getLayoutBounds().getCenterY());
		System.out.println(path3.getLayoutBounds().getCenterY());
		System.out.println(path4.getLayoutBounds().getCenterY());
		*/
		System.out.println(path1.getLayoutBounds());
	}
	
	Group create(int y) {
		//FirstPart
        //Path path1 = new Path();
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
        
        lineTo = new LineTo();
        lineTo.setX(290); 
        lineTo.setY(300+y);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
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
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(220+y);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        path1.setFill(Color.RED);
        path1.setStroke(Color.RED);
        
        //SecondPart
        
        //Path path2 = new Path();
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
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(390+y);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
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
        
        lineTo = new LineTo();
        lineTo.setX(280); 
        lineTo.setY(300+y);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        path2.setFill(Color.BLUE);
        path2.setStroke(Color.BLUE);
        
        //ThirdPart
        
        //Path path3 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(120); 
        moveTo.setY(300+y);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(380+y);
        
        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
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
        
        lineTo = new LineTo();
        lineTo.setX(110); 
        lineTo.setY(300+y);
        
//        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
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
        
        //Path path4 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(120); 
        moveTo.setY(300+y);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(220+y);
        
        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
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
        
        lineTo = new LineTo();
        lineTo.setX(110); 
        lineTo.setY(300+y);
        
//        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
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
        
        Group root = new Group(path1,path2,path3,path4);
        return root;
	}
	
	public void checkCollision(Group root,Ball player,int outside,int upper,int inside,int lower) {
		double checkcolmaxY=root.getBoundsInParent().getMaxY();
		double checkcolminY=root.getBoundsInParent().getMinY();
		double cur=player.getY();
		
		double angle1=-1,angle2=-1;
		
		if (outside==1) {
			if (upper==0) {
				if (checkcolminY<=cur) {
					angle1=root.getRotate();
					upper=1;
					outside=0;
					inside=1;
				}
			}
			else {
				if (checkcolmaxY>=cur) {
					angle2=root.getRotate();
					lower=1;
					outside=0;
					inside=1;
				}
			}
		}
		else {
			if (cur<=checkcolminY) {
				angle1=root.getRotate();
				outside=1;
				upper=0;
			}
			else if (cur>=checkcolmaxY) {
				angle2=root.getRotate();
				outside=1;
			}
		}
		
		if (angle1>=0 && angle1<=90) {
			System.out.println("purple");
		}
		else if (angle1>=90 && angle1<=180) {
			System.out.println("yellow");
		}
		else if (angle1>=180 && angle1<=270) {
			System.out.println("blue");
		}
		else if (angle1>=270 && angle1<=360) {
			System.out.println("red");
		}
		
		if (angle2>=0 && angle2<=90) {
			System.out.println("blue");
		}
		else if (angle2>=90 && angle2<=180) {
			System.out.println("red");
		}
		else if (angle2>=180 && angle2<=270) {
			System.out.println("purple");
		}
		else if (angle2>=270 && angle2<=360) {
			System.out.println("yellow");
		}
		
	}

}
