package application;



import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;

public class xObstacle extends Obstacle{
	
	Path path1,path2,path3,path4;

	xObstacle(String type) {
		super(type);
	}
	
	public void create(int y) {
		
		yCoordinate=y;
		
		path1 = new Path();
        MoveTo moveTo = new MoveTo(); 
        moveTo.setX(140); 
        moveTo.setY(300+y);
        
        LineTo lineTo = new LineTo();
        lineTo.setX(135); 
        lineTo.setY(295+y);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(135); 
        moveTo.setY(295+y);
        
        lineTo = new LineTo();
        lineTo.setX(135); 
        lineTo.setY(220+y);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(135); 
        moveTo.setY(220+y);
        
        lineTo = new LineTo();
        lineTo.setX(145); 
        lineTo.setY(220+y);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo();
        moveTo.setX(145); 
        moveTo.setY(220+y);
        
        lineTo = new LineTo();
        lineTo.setX(145); 
        lineTo.setY(295+y);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(145); 
        moveTo.setY(295+y);
        
        lineTo = new LineTo();
        lineTo.setX(140); 
        lineTo.setY(300+y);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        path1.setFill(Color.RED);
        path1.setStroke(Color.RED);
        
        //SecondPart
        path2 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(140); 
        moveTo.setY(300+y);
        
        lineTo = new LineTo();
        lineTo.setX(145); 
        lineTo.setY(295+y);
        
        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(145); 
        moveTo.setY(295+y);
        
        lineTo = new LineTo();
        lineTo.setX(220); 
        lineTo.setY(295+y);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(220); 
        moveTo.setY(295+y);
        
        lineTo = new LineTo();
        lineTo.setX(220); 
        lineTo.setY(305+y);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(220); 
        moveTo.setY(305+y);
        
        lineTo = new LineTo();
        lineTo.setX(145); 
        lineTo.setY(305+y);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(145); 
        moveTo.setY(305+y);
        
        lineTo = new LineTo();
        lineTo.setX(140); 
        lineTo.setY(300+y);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        path2.setFill(Color.BLUE);
        path2.setStroke(Color.BLUE);
        
        //ThirdPart
        
        path3 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(140); 
        moveTo.setY(300+y);
        
        lineTo = new LineTo();
        lineTo.setX(145); 
        lineTo.setY(305+y);
        
        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(145); 
        moveTo.setY(305+y);
        
        lineTo = new LineTo();
        lineTo.setX(145); 
        lineTo.setY(380+y);
        
//        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(145); 
        moveTo.setY(380+y);
        
        lineTo = new LineTo();
        lineTo.setX(135); 
        lineTo.setY(380+y);
        
//        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(135); 
        moveTo.setY(380+y);
        
        lineTo = new LineTo();
        lineTo.setX(135); 
        lineTo.setY(305+y);
        
//        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(135); 
        moveTo.setY(305+y);
        
        lineTo = new LineTo();
        lineTo.setX(140); 
        lineTo.setY(300+y);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        path3.setFill(Color.YELLOW);
        path3.setStroke(Color.YELLOW);
        
        //FourthPart
        
        path4 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(140); 
        moveTo.setY(300+y);
        
        lineTo = new LineTo();
        lineTo.setX(135); 
        lineTo.setY(305+y);
        
        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(135); 
        moveTo.setY(305+y);
        
        lineTo = new LineTo();
        lineTo.setX(60); 
        lineTo.setY(305+y);
        
//        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(60); 
        moveTo.setY(305+y);
        
        lineTo = new LineTo();
        lineTo.setX(60); 
        lineTo.setY(295+y);
        
//        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(60); 
        moveTo.setY(295+y);
        
        lineTo = new LineTo();
        lineTo.setX(135); 
        lineTo.setY(295+y);
        
//        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(135); 
        moveTo.setY(295+y);
        
        lineTo = new LineTo();
        lineTo.setX(140); 
        lineTo.setY(300+y);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        path4.setFill(Color.PURPLE);
        path4.setStroke(Color.PURPLE);
        
        root = new Group(path1,path2,path3,path4);
        //return root;
		
	}

	@Override
	public boolean checkCollision(Ball player)
	{
		
		Path hitPath=new Path();
		hitPath.setFill(player.getFill());
		
		// TODO Auto-generated method stub
		if(((Path)Shape.intersect(player, path1)).getElements().size()>0)
		{
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
			return true;
	}

	@Override
	public Group getRoot() {
		// TODO Auto-generated method stub
		return root;
	}

}
