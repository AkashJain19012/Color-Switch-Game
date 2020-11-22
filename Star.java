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
	
	Group create() throws FileNotFoundException {
		Image image = new Image(new FileInputStream("C:\\Users\\91782\\Desktop\\Images\\star.png"));  
	      
	      ImageView imageView = new ImageView(image); 
	      
	      //Setting the position of the image 
	      imageView.setX(190); 
	      imageView.setY(200); 
	      
	      //setting the fit height and width of the image view 
	      imageView.setFitHeight(20); 
	      imageView.setFitWidth(20); 
	      
	      imageView.setRotate(10);
	      
	      //Setting the preserve ratio of the image view 
	      imageView.setPreserveRatio(true);  
	      
	      //Creating a Group object  
	      Group root = new Group(imageView);  
	      
	      return root;
	}

}
