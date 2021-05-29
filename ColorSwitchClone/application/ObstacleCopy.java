package application;

import java.io.Serializable;

public class ObstacleCopy implements Serializable{
	
	private double yCoordinate;
	private double angle;
	private String type;
	
	ObstacleCopy(String type,double yCoordinate, double angle)
	{
		this.yCoordinate=yCoordinate;
		this.type=type;
		this.angle=angle;
	}
	
	public double getYCoordinate()
	{
		return yCoordinate;
	}
	
	public double getAngle()
	{
		return angle;
	}
	
	public String getType()
	{
		return type;
	}

}
