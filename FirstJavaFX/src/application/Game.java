package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	private int score=0,flagA;
	private String name;
	
	AnimationTimer timer,timer2;
	private ArrayList<Obstacle> obstacles;
	private ArrayList<Star> stars;
	private ArrayList<colorSwitcher> colorSwitchers;
	
	int flag;
	int value=80;
	
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
    	BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		mainPane.setBackground(background);
    	
    	
		
        addButtons();
        
        
//        StackPane sp = new StackPane();
//        
//        mainPane.getChildren().add(sp);
        mainPane.getChildren().add(player);
        play();
        

    }
    
    public void play()
    {
    	mainStage.setScene(mainScene);
        mainStage.show();
    	pause=new PauseScreen(mainStage,mainScene,homeScene);
    	hit_screen=new HitScreen(mainStage,mainScene,homeScene);
    	
    	timer=new AnimationTimer() {
    		public void handle(long now) {
    			if(pause.getSaved())
    			{
    				saved=true;
    				setName(pause.getName());
    				//pause.setSaved();
    				stop();
    				mainStage.setScene(prevScene);
    				
    			}
    			
    			if(pause.getClosed())
    			{
    				closed=true;
    				
    			}
    			
    			
    			
    			checkCollide();
    			
    			player.setY(2.5);
    			
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
    						player.setY(-5);
    					}
    					else
    					{
    						player.setY(-2);
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
    		o.rotate();
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
    

    
    public void moveObstacles()
    {
    	for(Obstacle o:obstacles)
    	{
    		o.moveDown();
    	}
    }
    
    public void moveStars()
    {
    	for(Star s:stars)
    	{
    		s.moveDown();
    	}
    }
    
    public void moveColorSwitchers()
    {
    	for(colorSwitcher c: colorSwitchers)
    	{
    		c.moveDown();
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
