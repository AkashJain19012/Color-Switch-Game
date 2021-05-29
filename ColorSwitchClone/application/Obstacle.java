package application;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public abstract class Obstacle {
	
	protected String type;
	protected Group root;
	protected double yCoordinate;
	
	
	Obstacle(String type){
		this.type=type;
	}	
	
	public void moveUp(int starsUsed)
	{
		root.setLayoutY(root.getLayoutY()-3-starsUsed*0.1);
	}
	
	public void moveDown(int starsUsed)
	{
		root.setLayoutY(root.getLayoutY()+3+starsUsed*0.1);
	}
	
	public void moveDown2()
	{
		root.setLayoutY(root.getLayoutY()+1);
	}
	
	public void rotate(double angle) 
	{
		RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setRate(0.1);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.INDEFINITE); 
        rotate.setFromAngle(angle);
        rotate.setNode(root);
        
        rotate.play();
	}
	
	public abstract boolean checkCollision(Ball player);
	
	public abstract void create(int y);
	
	public abstract Group getRoot();
	
	public ObstacleCopy getClone() {
		// TODO Auto-generated method stub
		//System.out.println(yCoordinate);
		ObstacleCopy ob=new ObstacleCopy(type,this.getRoot().getBoundsInParent().getCenterY()-300,root.getRotate()%360);
		//System.out.println(this.getRoot().getBoundsInParent().getCenterY());
		//System.out.println(ob.getYCoordinate());
		return ob;
	}
	
	
}
