package application;

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public abstract class Obstacle {
	
	String type;
	Group root;
	
	
	Obstacle(String type){
		this.type=type;
	}	
	
	public void moveUp()
	{
		root.setLayoutY(root.getLayoutY()-3);
	}
	
	public void moveDown()
	{
		root.setLayoutY(root.getLayoutY()+3);
	}
	
	public void rotate() 
	{
		RotateTransition rotate = new RotateTransition();
        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setRate(0.1);
        rotate.setCycleCount(Timeline.INDEFINITE);
        rotate.setDuration(Duration.INDEFINITE); 
        rotate.setNode(root);
        rotate.play();
	}
	
	public abstract int[] checkCollision(Ball player,int outside,int upper);
	
	public abstract Group create(int y);
	
	public abstract Group getRoot();
	
	
}
