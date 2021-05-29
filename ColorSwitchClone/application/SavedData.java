package application;

import java.io.Serializable;
import java.util.ArrayList;

public class SavedData implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public String name;
	public BallCopy ball;
	public ArrayList<ObstacleCopy> obstacles;
	public ArrayList<PointCopy> stars;
	public ArrayList<PointCopy> colorSwitchers;
	public int starsUsed;
	public int score;
	
	public void feedData(int score,String name,BallCopy ball,ArrayList<ObstacleCopy> obstacles,ArrayList<PointCopy> stars,ArrayList<PointCopy> colorSwitchers,int starsUsed)
	{
		this.score=score;
		this.name=name;
		this.ball=ball;
		this.obstacles=obstacles;
		this.stars=stars;
		this.colorSwitchers=colorSwitchers;
		this.starsUsed=starsUsed;
	}
	
	public String getName()
	{
		return name;
	}
	
	public BallCopy getBallCopy()
	{
		return ball;
	}
	
	public ArrayList<ObstacleCopy> getObstacleCopy()
	{
		return obstacles;
	}
	
	public ArrayList<PointCopy> getStarCopy()
	{
		return stars;
	}
	
	public ArrayList<PointCopy> getColorSwitcherCopy()
	{
		return colorSwitchers;
	}
	
	public int getStarUsed()
	{
		return starsUsed;
	}
	
	public int getScore()
	{
		return score;
	}
	
	
	

}
