package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Star {
	
	Group root;
	boolean used;
	
	Star(){
		used=false;
	}
	
	public void create(int y) throws FileNotFoundException {
		Image image = new Image(("star.png"));  
	      
	      ImageView imageView = new ImageView(image); 
	      imageView.setX(190); 
	      imageView.setY(290+y);
	      imageView.setFitHeight(20); 
	      imageView.setFitWidth(20); 
	      imageView.setRotate(10); 
	      imageView.setPreserveRatio(true);   
	      root = new Group(imageView);  
	      
	      //return root;
	}
	
	public boolean checkCollision(Ball player) {
		
		double checkcolmaxY=root.getBoundsInParent().getMaxY();
		double checkcolminY=root.getBoundsInParent().getMinY();
		double cur=player.getY();
		
		if (cur<=checkcolmaxY && cur>=checkcolminY && used==false) {
			used=true;
			System.out.println("collide");
		}
		
		return used;
	}
	
	public void moveUp()
	{
		root.setLayoutY(root.getLayoutY()-3);
	}
	
	public void moveDown()
	{
		root.setLayoutY(root.getLayoutY()+3);
	}
	
	public Group getRoot()
	{
		return root;
	}
	
	public boolean getUsed()
	{
		return used;
	}

}
