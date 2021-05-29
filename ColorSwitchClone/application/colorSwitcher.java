package application;

import java.util.Random;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class colorSwitcher {
	
	Group root;
	boolean used;
	double yCoordinate;
	
	colorSwitcher()
	{
		used=false;
	}
	
//	public void setUsed()
//	{
//		used=true;
//	}
//	
//	public boolean getUsed()
//	{
//		return used;
//	}
	
	void create(int y) {
		
		yCoordinate=y;
		
		Path path1 = new Path();

        MoveTo moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(180-30+y);
        
        LineTo lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(170-30+y);
        
        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(170-30+y);
        
        ArcTo arcTo = new ArcTo();
        arcTo.setX(210);
        arcTo.setY(180-30+y);
        arcTo.setRadiusX(10);
        arcTo.setRadiusY(10);
        arcTo.setSweepFlag(true);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(210); 
        moveTo.setY(180-30+y);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(180-30+y);
        
//        path1.getElements().add(moveTo); 
        path1.getElements().add(lineTo);
        
        path1.setFill(Color.RED);
        path1.setStroke(Color.RED);
        
        
        //SecondPart
        
        Path path2 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(180-30+y);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(190-30+y);
        
        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(190-30+y);
        
        arcTo = new ArcTo();
        arcTo.setX(210);
        arcTo.setY(180-30+y);
        arcTo.setRadiusX(10);
        arcTo.setRadiusY(10);
        arcTo.setSweepFlag(false);
        
//        path1.getElements().add(moveTo); 
        path2.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(210); 
        moveTo.setY(180-30+y);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(180-30+y);
        
//        path2.getElements().add(moveTo); 
        path2.getElements().add(lineTo);

        path2.setFill(Color.BLUE);
        path2.setStroke(Color.BLUE);
        
        //ThirdPart
        
        Path path3 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(190-30+y);
        
        arcTo = new ArcTo();
        arcTo.setX(190);
        arcTo.setY(180-30+y);
        arcTo.setRadiusX(10);
        arcTo.setRadiusY(10);
        arcTo.setSweepFlag(true);
        
        path3.getElements().add(moveTo); 
        path3.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(190); 
        moveTo.setY(180-30+y);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(180-30+y);
        
//        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(180-30+y);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(190-30+y);
        
//        path3.getElements().add(moveTo); 
        path3.getElements().add(lineTo);
        
        path3.setFill(Color.YELLOW);
        path3.setStroke(Color.YELLOW);
        //FourthPart
        
        Path path4 = new Path();
        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(170-30+y);
        
        arcTo = new ArcTo();
        arcTo.setX(190);
        arcTo.setY(180-30+y);
        arcTo.setRadiusX(10);
        arcTo.setRadiusY(10);
        arcTo.setSweepFlag(false);
        
        path4.getElements().add(moveTo); 
        path4.getElements().add(arcTo);
        
        moveTo = new MoveTo(); 
        moveTo.setX(190); 
        moveTo.setY(180-30+y);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(180-30+y);
        
//        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);

        moveTo = new MoveTo(); 
        moveTo.setX(200); 
        moveTo.setY(180-30+y);
        
        lineTo = new LineTo();
        lineTo.setX(200); 
        lineTo.setY(170-30+y);
        
//        path4.getElements().add(moveTo); 
        path4.getElements().add(lineTo);
        
        path4.setFill(Color.PURPLE);
        path4.setStroke(Color.PURPLE);

        
        root = new Group(path1,path2,path3,path4);
        //return root;
	}
	
	public Ball checkCollision(Ball player)
	{
		
		double checkcolmaxY=root.getBoundsInParent().getMaxY();
		double checkcolminY=root.getBoundsInParent().getMinY();
		double cur=player.getY();
		Color initialcolor=(Color) player.getFill();
		
		if (cur<=checkcolmaxY && cur>=checkcolminY && used==false) {
			Color colors[]=new Color[4];
			colors[0]=Color.RED;
			colors[1]=Color.BLUE;
			colors[2]=Color.PURPLE;
			colors[3]=Color.YELLOW;
			Random r=new Random();
			int idx=r.nextInt(3);
			
			if (initialcolor==colors[idx]) {
				idx=(idx+1)%4;
			}
			
			player.setColor(colors[idx]);
			used=true;
		}
		
		return player;
	}
	
	public PointCopy getClone()
	{
		PointCopy p =new PointCopy(this.getRoot().getBoundsInParent().getCenterY()-150,used);
		System.out.println(this.getRoot().getBoundsInParent().getCenterY()-100);
		return p;
	}
	
	public void moveUp(int starsUsed)
	{
		root.setLayoutY(root.getLayoutY()-3-starsUsed*0.1);
	}
	
	public void moveDown(int starsUsed)
	{
		root.setLayoutY(root.getLayoutY()+3+starsUsed*0.1);
	}
	
	public Group getRoot()
	{
		return root;
	}
	
	public boolean getUsed()
	{
		return used;
	}
	
	public void setUsed(boolean x)
	{
		used=x;
	}

}
