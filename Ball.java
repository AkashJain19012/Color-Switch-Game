package application;

import javafx.scene.shape.Circle;
import javafx.animation.AnimationTimer;
import javafx.scene.paint.Color;

public class Ball extends Circle {
	
	Ball(double centerX, double centerY, double radius, Color color)
	{
		super(centerX, centerY, radius, color);
	}
	
	public void moveUp()
	{
		setY(-6);	
	}
	
	public void moveDown()
	{
		setY(3);
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
		this.setCenterX(getX()+dist);
	}
	
	public void setY(double dist) 
	{
		this.setCenterY(getY()+dist);
	}
	
	public void setColor(Color c)
	{
		this.setFill(c);
	}
	

}
