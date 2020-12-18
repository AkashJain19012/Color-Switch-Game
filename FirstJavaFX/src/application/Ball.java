package application;

import javafx.scene.shape.Circle;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

public class Ball extends Circle {
	
	
	Ball(double radius, Color color)
	{
		super(radius, color);
	}
	
	Ball(double centerX, double centerY, double radius, Color color)
	{
		super(centerX, centerY, radius, color);
	}
	
	public double getX() 
	{
		return this.getCenterX();
	}
	
	public double getY() 
	{
		return this.getCenterY();
	}
	
	public void setX(double dist) 
	{
		this.setCenterX(this.getCenterX()+dist);
	}
	
	public void setY(double dist) 
	{
		this.setCenterY(this.getCenterY()+dist);
	}
	
	public void setColor(Color c)
	{
		this.setFill(c);
	}
	
	public BallCopy getClone()
	{
		String clr;
		if((Color)this.getFill()==Color.RED)
		{
			clr="RED";
		}
		else if((Color)this.getFill()==Color.BLUE)
		{
			clr="BLUE";
		}
		else if((Color)this.getFill()==Color.YELLOW)
		{
			clr="YELLOW";
		}
		else
		{
			clr="PURPLE";
		}
		BallCopy b=new BallCopy(clr,this.getY(),this.getRadius());
		return b;
	}
	

}
