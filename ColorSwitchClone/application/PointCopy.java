package application;

import java.io.Serializable;

public class PointCopy implements Serializable {
	
	private double yCoordinate;
	private boolean used;
	
	PointCopy(double yCoordinate, boolean used)
	{
		this.yCoordinate=yCoordinate;
		this.used=used;
	}
	
	public double getYCoordinate()
	{
		return yCoordinate;
	}
	
	public boolean getUsed()
	{
		return used;
	}

}
