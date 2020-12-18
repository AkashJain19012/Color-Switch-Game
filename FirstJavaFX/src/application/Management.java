package application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Management {

	public static void save(Serializable data,String fileName) throws IOException
	{
		
		ObjectOutputStream out=new ObjectOutputStream(Files.newOutputStream(Paths.get(fileName)));
		out.writeObject(data);
		
	}
	
	public static Object load(String fileName) throws IOException, ClassNotFoundException
	{
		ObjectInputStream in=new ObjectInputStream(Files.newInputStream(Paths.get(fileName)));
		return in.readObject();
	}
	
	public static void saveList(Serializable data) throws IOException
	{
		
		ObjectOutputStream out=new ObjectOutputStream(Files.newOutputStream(Paths.get("SAVING")));
		out.writeObject(data);
		
	}
	
	public static Object loadList() throws IOException, ClassNotFoundException
	{
		ObjectInputStream in=new ObjectInputStream(Files.newInputStream(Paths.get("SAVING")));
		return in.readObject();
	}
	
	

}
