package application;

import java.io.Serializable;

import javafx.scene.paint.Color;

public class BallCopy implements Serializable {
	
	private double yCoordinate;
	private double radius;
	private String color;
	
	BallCopy(String color,double yCoordinate, double radius)
	{
		this.yCoordinate=yCoordinate;
		this.color=color;
		this.radius=radius;
	}
	
	public double getYCoordinate()
	{
		return yCoordinate;
	}
	
	public double getRadius()
	{
		return radius;
	}
	
	public String getColor()
	{
		return color;
	}

}
