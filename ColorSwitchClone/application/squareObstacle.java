package application;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;

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

	public void create(int y) {
		yCoordinate=y;
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

		root = new Group(path1,path2,path3,path4);
		//return root;
	}

	public boolean checkCollision(Ball player) 
	{
		
		Path hitPath=new Path();
		hitPath.setFill(player.getFill());
		
		// TODO Auto-generated method stub
		if(((Path)Shape.intersect(player, path1)).getElements().size()>0)
		{
			System.out.println("red");
			hitPath=path1;
		}
		else if(((Path)Shape.intersect(player, path2)).getElements().size()>0)
		{
			hitPath=path2;
		}
		else if(((Path)Shape.intersect(player, path3)).getElements().size()>0)
		{
			hitPath=path3;
		}
		else if(((Path)Shape.intersect(player, path4)).getElements().size()>0)
		{
			hitPath=path4;
		}
		if(hitPath.getFill()==player.getFill())
		{
			return false;
		}
		else
		{
			System.out.println("collide");
			return true;
		}
	}
	
	public Group getRoot()
	{
		return root;
	}

	

}
