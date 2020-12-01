package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class Obstacle {
	
	String type;
	
	Obstacle(String type){
		this.type=type;
	}	
	
	public void moveUp(Group root)
	{
		root.setLayoutY(root.getLayoutY()-1);
	}
	
	public void moveDown(Group root)
	{
		root.setLayoutY(root.getLayoutY()+1);
	}
	
	
}
