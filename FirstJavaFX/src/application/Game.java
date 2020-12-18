package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.Group;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo; 
import javafx.scene.shape.MoveTo; 
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.transform.Rotate; 
import javafx.scene.shape.Shape;

public class Game implements Cloneable{ 
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 400;
	
	
	private Stage mainStage;
	private AnchorPane mainPane;
	private Scene mainScene,prevScene,homeScene;
	
	private Button pause_button;
	private TextField score_display;
	
	private PauseScreen pause;
	private HitScreen hit_screen;
	
	boolean saved,closed;
	
	private Ball player;
	private int score=0,starsUsed=0,flagA;
	private String name;
	
	AnimationTimer timer,timer2;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Star> stars;
	private ArrayList<colorSwitcher> colorSwitchers;
	
	int flag;
	
	Game(Stage stage, Scene tempScene,Scene homeScene)
	{
		saved=false;
		closed=false;
		flagA=0;
		mainStage=stage;
		prevScene= tempScene;
		mainPane=new AnchorPane();
		mainScene= new Scene(mainPane, WIDTH, HEIGHT);
		obstacles=new ArrayList<Obstacle>();
		colorSwitchers = new ArrayList<colorSwitcher>();
		stars = new ArrayList<Star>();
		this.homeScene=homeScene;
		
	}
	
	public Object clone() throws CloneNotSupportedException 
	{ 
		return super.clone(); 
	} 
	
	public void setName(String name)
	{
		this.name=name;
	}
	
	public String getName()
	{
		return name;
	}
	
    public void run() throws FileNotFoundException
    {  
    	
    	player=new Ball(200, 510, 7, Color.RED);
    	
    	assignObstacles();
    	assignColorSwitchers();
    	assignStars();
        
        play();
        
    }
    
    public void play()
    {
    	BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		mainPane.setBackground(background);
		
        addButtons();
        
    	mainPane.getChildren().add(player);
    	mainStage.setScene(mainScene);
        mainStage.show();
    	pause=new PauseScreen(mainStage,mainScene,homeScene);
    	hit_screen=new HitScreen(mainStage,mainScene,homeScene);
    	
    	timer=new AnimationTimer() {
    		public void handle(long now) {
    			if(pause.getSaved())
    			{
//    				saved=true;
    				setName(pause.getName());
    				stop();
//    				mainStage.setScene(prevScene);
    				
    				
    				try {
						try {
							save();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    				
    			}
    			
    			if(pause.getClosed())
    			{
    				closed=true;
    				
    			}
    			
    			
    			if(timer2!=null)
    				checkCollide();
    			
    			//System.out.println(starsUsed);
    			//System.out.println(speed);
    			player.setY(2.5+starsUsed*0.1);
    			
    			//System.out.println(player.getY());
    			
    			if(player.getY()<obstacles.get(obstacles.size()-2).getRoot().getBoundsInParent().getCenterY())
    	    	{
    				System.out.println("assigning new components");
    	    		assignObstacles();
    	    		try {
						assignColorSwitchers();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	    		try {
						assignStars();
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    	    	}
    		}
    	};
    	
    	timer.start();
    	
    	
    	mainScene.setOnKeyPressed(e -> {
    		if(e.getCode() == KeyCode.A && flagA==0){
    			
    			flag=0;
    			timer2=new AnimationTimer() {
    				public void handle(long now) {
    					if((player.getY()-20) > HEIGHT/2)
    					{
    						player.setY(-5-starsUsed*0.1);
    					}
    					else
    					{
    						player.setY(-2-starsUsed*0.1);
    						moveObstacles();
    						moveStars();
    						moveColorSwitchers();
    					}
    					flag++;
//    					if (flag>30) {
//    						stop();
//    					}
    					if (flag>25) {
    						stop();
    					}
    				}
    			};
    			timer2.start();
    		}
        });
    	
    	
    	
    	
        
        pause_button.setOnAction(e -> {
        	try {
        		timer.stop();
				pauseScreen();

				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        
        
        AnimationTimer timer3=new AnimationTimer() {
    		public void handle(long now) {
    			if(pause.getSaved())
    			{
    				timer.start();
    				stop();
    			}
    			else if(pause.getResume())
    			{
    				pause.setResume();
    				timer.start();
    			}
    		}
    		
    	};
    	timer3.start();
    	
    	AnimationTimer timer4=new AnimationTimer() {
    		public void handle(long now) {
    			if(hit_screen.getUseStar())
    			{
    				score--;
    				flagA=0;
    				hit_screen.setUseStar();
    				timer.start();
    			}
    		}
    		
    	};
    	timer4.start();
    	
    	
       
    }
    
    
    
    
    public void save() throws ClassNotFoundException, IOException
    {
    	
    	SavedData saveData = new SavedData();
    	BallCopy ball= player.getClone();
    	ArrayList<ObstacleCopy> saveObstacles=new ArrayList<ObstacleCopy>();
    	ArrayList<PointCopy> saveStars=new ArrayList<PointCopy>();
    	ArrayList<PointCopy> saveColorSwitchers=new ArrayList<PointCopy>();
    	
    	for(int i=0;i<obstacles.size();++i)
    	{
    		saveObstacles.add(obstacles.get(i).getClone());
    		//System.out.println(saveObstacles.get(i).getYCoordinate());
    	}
    	
    	for(int i=0;i<stars.size();++i)
    	{
    		saveStars.add(stars.get(i).getClone());
    	}
    	
    	for(int i=0;i<colorSwitchers.size();++i)
    	{
    		saveColorSwitchers.add(colorSwitchers.get(i).getClone());
    	}
    	
    	saveData.feedData(score,name,ball, saveObstacles, saveStars, saveColorSwitchers, starsUsed);
    	Management.save(saveData, saveData.getName());
    	System.out.println(saveData.getName());
    	
//    	try {
//			Management.save(saveData, saveData.getName());
//			Saved saved;
//			try {
//				saved= (Saved)Management.loadList();
//				ArrayList<String> savedGames=saved.getSavedGame();
//				savedGames.add(saveData.getName());
//				Management.saveList(savedGames);
//				System.out.println(saveData.name);
//				System.out.println("Game Saved");
//			}
//			catch(FileNotFoundException e)
//			{
//				ArrayList<String> savedGames=new ArrayList<String>();
//				savedGames.add(saveData.getName());
//				Management.saveList(savedGames);
//				System.out.println(saveData.name);
//				System.out.println("Game Saved");
//			}
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			ArrayList<String> savedGames=new ArrayList<String>();
//			savedGames.add(saveData.getName());
//			try {
//				Management.saveList(savedGames);
//			} catch (IOException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			System.out.println(saveData.name);
//			System.out.println("Game Saved");
//			System.out.println("file not found");
//			//e.printStackTrace();
//		}
    	
    	mainStage.setScene(prevScene);
    }
    
    
    
    public void checkCollide() {
    	
    	boolean hit=false;
    	hit=obstacles.get(obstacles.size()-3).checkCollision(player);
		if (obstacles.size()<=3) 
		{
			hit = hit | obstacles.get(obstacles.size()-1).checkCollision(player);
			hit = hit | obstacles.get(obstacles.size()-2).checkCollision(player);
		}
		else 
		{
			hit = hit | obstacles.get(obstacles.size()-4).checkCollision(player);
			hit = hit | obstacles.get(obstacles.size()-5).checkCollision(player);
		}
		
		
		boolean colorHit=false;
		if (colorSwitchers.size()<=3)
		{
			
			for(int i=1;i<=3;++i)
			{
				
				if(colorSwitchers.get(colorSwitchers.size()-i).getUsed()==false)
				{
					player=colorSwitchers.get(colorSwitchers.size()-i).checkCollision(player);
					colorHit=colorSwitchers.get(colorSwitchers.size()-i).getUsed();
					if(colorHit)
					{
						System.out.println("colorHit");
						mainPane.getChildren().remove(colorSwitchers.get(colorSwitchers.size()-i).getRoot());
						break;
					}
				}
			}
			
			
		}
		else 
		{
			for(int i=3;i<=5;++i)
			{
				
				if(colorSwitchers.get(colorSwitchers.size()-i).getUsed()==false)
				{
					player=colorSwitchers.get(colorSwitchers.size()-i).checkCollision(player);
					colorHit=colorSwitchers.get(colorSwitchers.size()-i).getUsed();
					if(colorHit)
					{
						System.out.println("colorHit");
						mainPane.getChildren().remove(colorSwitchers.get(colorSwitchers.size()-i).getRoot());
						break;
					}
				}
			}
		}
		
		boolean starHit=false;
		if (stars.size()<=3) {
			for(int i=1;i<=3;++i)
			{
				if(stars.get(stars.size()-i).getUsed()==false)
				{
					starHit=stars.get(stars.size()-i).checkCollision(player);
					if(starHit)
					{
						System.out.println("StarHit");
						mainPane.getChildren().remove(stars.get(stars.size()-i).getRoot());
						score++;
						starsUsed++;
						break;
					}
				}
			}
		}
		else {
			for(int i=3;i<=5;++i)
			{
				
				if(stars.get(stars.size()-i).getUsed()==false)
				{
					starHit=stars.get(stars.size()-i).checkCollision(player);
					if(starHit)
					{
						System.out.println("StarHit");
						mainPane.getChildren().remove(stars.get(stars.size()-i).getRoot());
						score++;
						starsUsed++;
						break;
					}
				}	
			}
		}
		
		score_display.setText(Integer.toString(score));
		
//		System.out.println("Score : "+score);
		
		if(hit)
		{
			System.out.println("obstacleHit");
			timer2.stop();
			flagA=1;
			timer.stop();
			flag=50;
			player.setY(50);
			hit_screen.run();
			
		}
    }
    
	public void addButtons()
	{
		pause_button=new Button("||");
		pause_button.setLayoutX(340);
		pause_button.setLayoutY(0);
		pause_button.setPrefSize(60, 40);
		pause_button.setStyle("-fx-background-color: BlueViolet");
		pause_button.setTextFill(Color.WHITE);
		pause_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		
		score_display = new TextField ();
		score_display.setLayoutX(0);
		score_display.setLayoutY(0);
		score_display.setPrefSize(60, 40);
		score_display.setStyle("-fx-background-color: BlueViolet");
		score_display.setText("0");
		score_display.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		score_display.setAlignment(Pos.BASELINE_CENTER);
		
		
        mainPane.getChildren().add(pause_button);
        mainPane.getChildren().add(score_display);
        
        
	}
	
	
    public void pauseScreen() throws FileNotFoundException
    {
    	//System.exit(0);
//    	pause=new PauseScreen(mainStage,mainScene);
        pause.run();
//        System.out.println("lets go");
//        if(pause.getSaved())
//        {
//        	System.out.println("save it");
//        }
    }
    
    public void makePlayer(String name,BallCopy b,int starused,int score)
    {
    	this.name=name;
    	this.starsUsed=starused;
    	this.score=score;
    	
    	if(b.getColor()=="RED")
    	{
    		player=new Ball(200, b.getYCoordinate(), b.getRadius(), Color.RED);
    	}
    	else if(b.getColor()=="PURPLE")
    	{
    		player=new Ball(200, b.getYCoordinate(), b.getRadius(), Color.PURPLE);
    	}
    	else if(b.getColor()=="BLUE")
    	{
    		player=new Ball(200, b.getYCoordinate(), b.getRadius(), Color.BLUE);
    	}
    	else
    	{
    		player=new Ball(200, b.getYCoordinate(), b.getRadius(), Color.YELLOW);
    	}
    }
    
    void assignObstacles()
    {
    	if(obstacles.size()>=3)
    	{
    		Obstacle o=obstacles.get(obstacles.size()-1);
    		
    		Random rd=new Random();
    		
    		
    		for(int i=0;i<3;++i)
    		{
    			int x=rd.nextInt(3);
    			if(x==0)
    			{
    				obstacles.add(new squareObstacle("square"));
    	        	obstacles.get(obstacles.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-700-i*400);
    	        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
    			}
    			else if(x==1)
    			{
    				obstacles.add(new xObstacle("x"));
    	        	obstacles.get(obstacles.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-700-i*400);
    	        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
    			}
    			else
    			{
    				obstacles.add(new circleObstacle("circle"));
    	        	obstacles.get(obstacles.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-700-i*400);
    	        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
    			}
    		}	
    	}
    	else
    	{
    		obstacles.add(new squareObstacle("square"));
        	obstacles.get(0).create(0);
        	//System.out.println((int)obstacles.get(0).getRoot().getBoundsInParent().getCenterY());
        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
        	obstacles.add(new xObstacle("x"));
        	obstacles.get(1).create(-400);
        	//System.out.println((int)obstacles.get(1).getRoot().getBoundsInParent().getCenterY());
        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
        	obstacles.add(new circleObstacle("circle"));
        	obstacles.get(2).create(-800);
        	//System.out.println((int)obstacles.get(2).getRoot().getBoundsInParent().getCenterY());
        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
    	}
    	
    	    	        
        for(Obstacle o:obstacles)
    	{
    		o.rotate(0);
    	}
        
    }
    
    public void makeObstacles(ArrayList<ObstacleCopy> copy)
    {
    	for(int i=0;i<copy.size();++i)
    	{
    		if(copy.get(i).getType().compareTo("square")==0)
    		{
    			obstacles.add(new squareObstacle("square"));
    			System.out.println("added square");
    		}
    		else if(copy.get(i).getType().compareTo("x")==0)
    		{
    			obstacles.add(new xObstacle("x"));
    			System.out.println("added x");
    		}
    		else
    		{
    			obstacles.add(new circleObstacle("circle"));
    			System.out.println("added circle");
    		}
//    		System.out.println(copy.get(i).getYCoordinate());
    		obstacles.get(i).create((int)copy.get(i).getYCoordinate());
    		obstacles.get(i).rotate(copy.get(i).getAngle());
        	mainPane.getChildren().add(obstacles.get(i).getRoot());
    	}
    }
    
    
    
    
    void assignStars() throws FileNotFoundException
    {
    	if(stars.size()>=3)
    	{
    		Star o=stars.get(stars.size()-1);
    		stars.add(new Star());
    		
        	stars.get(stars.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-700);
        	mainPane.getChildren().add(stars.get(stars.size()-1).getRoot());
        	stars.add(new Star());
        	stars.get(stars.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-1100);
        	mainPane.getChildren().add(stars.get(stars.size()-1).getRoot());
        	stars.add(new Star());
        	stars.get(stars.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-1500);
        	mainPane.getChildren().add(stars.get(stars.size()-1).getRoot());
    	}
    	else
    	{
    		stars.add(new Star());
        	stars.get(0).create(0);
        	stars.add(new Star());
        	stars.get(1).create(-400);
        	stars.add(new Star());
        	stars.get(2).create(-800);
        	    	
            mainPane.getChildren().add(stars.get(0).getRoot());
            mainPane.getChildren().add(stars.get(1).getRoot());
            mainPane.getChildren().add(stars.get(2).getRoot());
    	}
        
    }
    
    public void makeStars(ArrayList<PointCopy> copy) throws FileNotFoundException
    {
    	for(int i=0;i<copy.size();++i)
    	{
    		stars.add(new Star());
    		stars.get(i).create((int)copy.get(i).getYCoordinate());
    		if(copy.get(i).getUsed())
    		{
    			stars.get(i).setUsed(true);
    		}
    		else
    		{
    			mainPane.getChildren().add(stars.get(i).getRoot());
    		}
    	}
    }
    
    void assignColorSwitchers() throws FileNotFoundException
    {
    	if(colorSwitchers.size()>=3)
    	{
    		colorSwitcher o=colorSwitchers.get(colorSwitchers.size()-1);
    		colorSwitchers.add(new colorSwitcher());
    		
        	colorSwitchers.get(colorSwitchers.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-550);
        	mainPane.getChildren().add(colorSwitchers.get(colorSwitchers.size()-1).getRoot());
        	colorSwitchers.add(new colorSwitcher());
        	colorSwitchers.get(colorSwitchers.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-950);
        	mainPane.getChildren().add(colorSwitchers.get(colorSwitchers.size()-1).getRoot());
        	colorSwitchers.add(new colorSwitcher());
        	colorSwitchers.get(colorSwitchers.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-1350);
        	mainPane.getChildren().add(colorSwitchers.get(colorSwitchers.size()-1).getRoot());
    	}
    	else
    	{
    		colorSwitchers.add(new colorSwitcher());
        	colorSwitchers.get(0).create(-50);
        	//System.out.println((int)colorSwitchers.get(0).getRoot().getBoundsInParent().getCenterY());
        	colorSwitchers.add(new colorSwitcher());
        	colorSwitchers.get(1).create(-450);
        	//System.out.println((int)colorSwitchers.get(1).getRoot().getBoundsInParent().getCenterY());
        	colorSwitchers.add(new colorSwitcher());
        	colorSwitchers.get(2).create(-850);
        	//System.out.println((int)colorSwitchers.get(2).getRoot().getBoundsInParent().getCenterY());
        	    	
            mainPane.getChildren().add(colorSwitchers.get(0).getRoot());
            mainPane.getChildren().add(colorSwitchers.get(1).getRoot());
            mainPane.getChildren().add(colorSwitchers.get(2).getRoot());
    	}
    	
        
    }
    
    public void makeColorSwitchers(ArrayList<PointCopy> copy)
    {
    	for(int i=0;i<copy.size();++i)
    	{
    		colorSwitchers.add(new colorSwitcher());
    		colorSwitchers.get(i).create((int)copy.get(i).getYCoordinate());
    		if(copy.get(i).getUsed())
    		{
    			colorSwitchers.get(i).setUsed(true);
    		}
    		else
    		{
    			mainPane.getChildren().add(colorSwitchers.get(i).getRoot());
    		}
    	}
    }
    


    
    public void moveObstacles()
    {
    	for(Obstacle o:obstacles)
    	{
    		o.moveDown(starsUsed);
    	}
    }
    
    public void moveStars()
    {
    	for(Star s:stars)
    	{
    		s.moveDown(starsUsed);
    	}
    }
    
    public void moveColorSwitchers()
    {
    	for(colorSwitcher c: colorSwitchers)
    	{
    		c.moveDown(starsUsed);
    	}
    }
    
    public boolean getSaved()
    {
    	return saved;
    }
    
    public void setSaved()
    {
    	saved=false;
    }
    
    public void setClosed()
    {
    	closed=true;
    }
    
    public boolean getClosed()
    {
    	return closed; 
    }
    
    
    
    
} 
