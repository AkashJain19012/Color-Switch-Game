package application;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Rotator {
	
	private Group root1,root2;
	private boolean used;
	
	private Path path1,path2,path3,path4;
	private Color color;
	
	Rotator()
	{
		used=false;
		path1=new Path();
		path2=new Path();
		path3=new Path();
		path4=new Path();
	}
	
	void create(int x,int y,Color color) {
		y+=10;
		this.color=color;
		
		MoveTo moveTo = new MoveTo(); 
        moveTo.setX(200+x); 
        moveTo.setY(160+y);
        
        ArcTo arcTo = new ArcTo();
        arcTo.setX(200+x);
        arcTo.setY(120+y);
        arcTo.setRadiusX(20);
        arcTo.setRadiusY(20);
        arcTo.setSweepFlag(false);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(arcTo);
        //path1.setFill(color);
        //path1.setStroke(color);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200+x); 
        moveTo.setY(120+y);
        
        LineTo lineTo = new LineTo();
        lineTo.setX(200+x); 
        lineTo.setY(160+y);
        
        path1.getElements().add(lineTo);
        path1.setStroke(color);
        path1.setFill(color);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200+x); 
        moveTo.setY(120+y);
        
        arcTo = new ArcTo();
        arcTo.setX(200+x);
        arcTo.setY(160+y);
        arcTo.setRadiusX(20);
        arcTo.setRadiusY(20);
        arcTo.setSweepFlag(false);
        
        path2.getElements().add(moveTo); 
        path2.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200+x); 
        moveTo.setY(120+y);
        
        lineTo = new LineTo();
        lineTo.setX(200+x); 
        lineTo.setY(160+y);
        
        path2.getElements().add(lineTo);
        
        path2.setStroke(color);
        path2.setFill(color);
        
        root1=new Group(path1,path2);
        
        //Third Part
//        moveTo=new MoveTo();
//        moveTo.setX(200);
//        moveTo.setY(120+y);
//        
//        lineTo = new LineTo();
//        lineTo.setX(200); 
//        lineTo.setY(100+y);
//        
//        path3.getElements().add(moveTo);
//        path3.getElements().add(lineTo);
//        
//        moveTo=new MoveTo();
//        moveTo.setX(200);
//        moveTo.setY(100+y);
//        
//        lineTo = new LineTo();
//        lineTo.setX(195); 
//        lineTo.setY(105+y);
//        
//        path3.getElements().add(lineTo);
//        
//        moveTo=new MoveTo();
//        moveTo.setX(200);
//        moveTo.setY(100+y);
//        
//        lineTo = new LineTo();
//        lineTo.setX(205); 
//        lineTo.setY(105+y);
        
        moveTo = new MoveTo(); 
        moveTo.setX(190+x); 
        moveTo.setY(140+y);
        
        lineTo = new LineTo();
        lineTo.setX(210+x); 
        lineTo.setY(140+y);
        
        path3.getElements().add(moveTo);
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(210+x); 
        moveTo.setY(140+y);
        
        lineTo = new LineTo();
        lineTo.setX(200+x); 
        lineTo.setY(180+y);
        
        path3.getElements().add(lineTo);
        moveTo = new MoveTo(); 
        moveTo.setX(200+x); 
        moveTo.setY(180+y);
        
        lineTo = new LineTo();
        lineTo.setX(190+x); 
        lineTo.setY(140+y);
        
        path3.getElements().add(lineTo);
        path3.setStroke(color);
        path3.setFill(color);
        
        //Path4
        
        moveTo = new MoveTo(); 
        moveTo.setX(190+x); 
        moveTo.setY(140+y);
        
        lineTo = new LineTo();
        lineTo.setX(200+x); 
        lineTo.setY(100+y);
        
        path4.getElements().add(moveTo);
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200+x); 
        moveTo.setY(100+y);
        
        lineTo = new LineTo();
        lineTo.setX(210+x); 
        lineTo.setY(140+y);
        
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(210+x); 
        moveTo.setY(140+y);
        
        lineTo = new LineTo();
        lineTo.setX(190+x); 
        lineTo.setY(140+y);
        
        path4.getElements().add(lineTo);
        path4.setFill(Color.TRANSPARENT);
        path4.setStroke(Color.TRANSPARENT);
        
        root2=new Group(path3,path4);   
	}
	
	public void rotate() 
	{
		RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        //rotate.setByAngle(360);
        rotate.setFromAngle(90);
        rotate.setToAngle(270);
        rotate.setRate(0.35);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.INDEFINITE);
        rotate.setAutoReverse(true);
        rotate.setNode(root2);
        rotate.play();
	}
	
	public boolean checkCollision(Ball player) {
		
		double checkmaxY=root1.getBoundsInParent().getMaxY();
		double checkminY=root1.getBoundsInParent().getMinY();
		double checkminX=root1.getBoundsInParent().getMinX();
		double checkmaxX=root1.getBoundsInParent().getMaxX();
		double curY=player.getBoundsInParent().getCenterY();
		double curX=player.getBoundsInParent().getCenterX();
		//System.out.println(cur);
		
		if (curY<=checkmaxY && curY>=checkminY && curX<=checkmaxX && curX>=checkminX && used==false) {
			used=true;
			System.out.println("collide");
		}
		
		return used;
	}
	
	public void moveUp()
	{
		root1.setLayoutY(root1.getLayoutY()-3);
		root2.setLayoutY(root2.getLayoutY()-3);
	}
	
	public void moveDown()
	{
		root1.setLayoutY(root1.getLayoutY()+1);
		root2.setLayoutY(root2.getLayoutY()+1);
	}
	
	public Group getRoot1()
	{
		return root1;
	}
	
	public Group getRoot2() {
		return root2;
	}
	
	public boolean getUsed()
	{
		return used;
	}
	
	public Color getColor() {
		return color;
	}
	
}
