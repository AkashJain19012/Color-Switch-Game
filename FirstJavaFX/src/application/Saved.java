package application;

import java.io.Serializable;
import java.util.ArrayList;

public class Saved implements Serializable{

	public ArrayList<String> savedGame;
	
	Saved(ArrayList<String> savedGame)
	{
		this.savedGame=savedGame;
	}
	
	public ArrayList<String> getSavedGame()
	{
		return savedGame;
	}
}
