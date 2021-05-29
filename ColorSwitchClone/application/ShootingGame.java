package application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.shape.Path;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ShootingGame implements Cloneable{
	
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
	private ArrayList<Rotator> rotators;
	private Rotator r1;
	private int rotatoridx;
	
	private TranslateTransition playerMovement;
	
	int flag;
	int value=80;
	
	ShootingGame(Stage stage, Scene tempScene,Scene homeScene)
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
		rotators=new ArrayList<Rotator>();
		this.homeScene=homeScene;
		rotatoridx=0;
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
    	
    	
    	//player=new Ball(200, 510, 7, Color.RED);
    	
    	assignObstacles();
    	assignRotator();
    	BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		mainPane.setBackground(background);
	
        addButtons();

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
    			moveObstacles();
    			moveRotator();
    			
    			Obstacle temp=obstacles.get(obstacles.size()-2);
    			if (temp.getRoot().getBoundsInParent().getMaxY()>0)
    			{
    				//System.out.println("Adding new obstacles");
    				assignObstacles();
    				assignRotator();
    			}
    			
    		}
    	};
    	
    	timer.start();
    	
    	
    	mainScene.setOnKeyPressed(e -> {
    		if(e.getCode() == KeyCode.A && flagA==0){

    			
    			player=new Ball(7, rotators.get(rotatoridx).getColor());
    			mainPane.getChildren().add(player);
    			
    			playerMovement = new TranslateTransition();
    			playerMovement.setDuration(Duration.millis(1000));  
    			playerMovement.setNode(player); 
    			
    			double centerX=(rotators.get(rotatoridx).getRoot1().getBoundsInParent().getMinX()+rotators.get(rotatoridx).getRoot1().getBoundsInParent().getMaxX())/2;
    			double centerY=(rotators.get(rotatoridx).getRoot1().getBoundsInParent().getMinY()+rotators.get(rotatoridx).getRoot1().getBoundsInParent().getMaxY())/2;
    			playerMovement.setFromX(centerX);
    			playerMovement.setFromY(centerY);
    			
    			//System.out.println((rotators.get(0).getRoot().getRotate())%360);
    			double angle=(rotators.get(rotatoridx).getRoot2().getRotate())%360;
    			double toreachX,toreachY,inradian;
    			
    			if (angle>=0 && angle<=90) {
    				inradian=Math.toRadians(angle);
    				toreachX=Math.sin(inradian);
    				toreachX=0-toreachX;
    				toreachY=Math.cos(inradian);
    			}
    			else if (angle>=90 && angle<=180) {
    				angle=180-angle;
    				inradian=Math.toRadians(angle);
    				toreachX=Math.sin(inradian);
    				toreachX=0-toreachX;
    				toreachY=Math.cos(inradian);
    				toreachY=0-toreachY;
    			}
    			else if (angle>=180 && angle<=270) {
    				angle=angle-180;
    				inradian=Math.toRadians(angle);
    				toreachX=Math.sin(inradian);
    				toreachY=Math.cos(inradian);
    				toreachY=0-toreachY;
    			}
    			else {
    				angle=360-angle;
    				inradian=Math.toRadians(angle);
    				toreachX=Math.sin(inradian);
    				toreachY=Math.cos(inradian);
    			}
    			
    			playerMovement.setByX(500*toreachX);
    			playerMovement.setByY(500*toreachY);
    			
    		    
    			player.boundsInParentProperty().addListener(new ChangeListener<Bounds>() {
    	            @Override
    	            public void changed(ObservableValue<? extends Bounds> observable,
    	                    Bounds oldValue, Bounds newValue) {

    	            	checkCollide();
//    	            	if (player.getBoundsInParent().getCenterY()<rotators.get(rotatoridx+1).getRoot1().getBoundsInParent().getCenterY() && player.getBoundsInParent().getCenterY()>1) 
//    	    			{
//    	    				timer.stop();
//    	    				playerMovement.stop();
//    	    			}
    	            	//System.out.println(player.getBoundsInParent().getCenterY());

    	            }
    	        });
    			
    			playerMovement.setOnFinished(new EventHandler<ActionEvent>() {
    	            @Override
    	            public void handle(ActionEvent event) {
    	                mainPane.getChildren().remove(player);
    	            }
    	        });
    			
    		    playerMovement.play();

    		}
        });
    	
    	
    	
    	
        
        pause_button.setOnAction(e -> {
        	try {
        		//timer.stop();
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
    				//timer.start();
    				stop();
    			}
    			else if(pause.getResume())
    			{
    				pause.setResume();
    				//timer.start();
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
	
	void assignObstacles()
    {
    	if(obstacles.size()>=3)
    	{
    		Obstacle o=obstacles.get(obstacles.size()-1);
    		obstacles.add(new squareObstacle("square"));
    		
        	obstacles.get(obstacles.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-700);
        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
        	obstacles.add(new xObstacle("x"));
        	obstacles.get(obstacles.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-1100);
        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
        	obstacles.add(new circleObstacle("circle"));
        	obstacles.get(obstacles.size()-1).create((int)o.getRoot().getBoundsInParent().getCenterY()-1500);
        	mainPane.getChildren().add(obstacles.get(obstacles.size()-1).getRoot());
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
    
    
    void assignRotator() {
    	
//    	r1=new Rotator();
//    	r1.create(370);
//    	r1.rotate();
//    	mainPane.getChildren().add(r1.getRoot());
    	if(rotators.size()>=5)
    	{
    		Rotator o=rotators.get(rotators.size()-1);
    		
    		rotators.add(new Rotator());
        	rotators.get(rotators.size()-1).create(0,(int)o.getRoot1().getBoundsInParent().getCenterY()-350,Color.RED);
        	mainPane.getChildren().add(rotators.get(rotators.size()-1).getRoot1());
        	mainPane.getChildren().add(rotators.get(rotators.size()-1).getRoot2());
    		rotators.add(new Rotator());
    		
        	rotators.get(rotators.size()-1).create(0,(int)o.getRoot1().getBoundsInParent().getCenterY()-550,Color.BLUE);
        	mainPane.getChildren().add(rotators.get(rotators.size()-1).getRoot1());
        	mainPane.getChildren().add(rotators.get(rotators.size()-1).getRoot2());
        	rotators.add(new Rotator());
        	rotators.get(rotators.size()-1).create(0,(int)o.getRoot1().getBoundsInParent().getCenterY()-950,Color.YELLOW);
        	mainPane.getChildren().add(rotators.get(rotators.size()-1).getRoot1());
        	mainPane.getChildren().add(rotators.get(rotators.size()-1).getRoot2());
        	
        	rotators.add(new Rotator());
        	rotators.get(rotators.size()-1).create(0,(int)o.getRoot1().getBoundsInParent().getCenterY()-1150,Color.PURPLE);
        	mainPane.getChildren().add(rotators.get(rotators.size()-1).getRoot1());
        	mainPane.getChildren().add(rotators.get(rotators.size()-1).getRoot2());
        	
        	rotators.add(new Rotator());
        	rotators.get(rotators.size()-1).create(0,(int)o.getRoot1().getBoundsInParent().getCenterY()-1350,Color.BLUE);
        	mainPane.getChildren().add(rotators.get(rotators.size()-1).getRoot1());
        	mainPane.getChildren().add(rotators.get(rotators.size()-1).getRoot2());
    	}
    	else
    	{
    		rotators.add(new Rotator());
        	rotators.get(0).create(0,150,Color.RED);
    		rotators.add(new Rotator());
        	rotators.get(1).create(0,-50,Color.BLUE);
        	rotators.add(new Rotator());
        	rotators.get(2).create(0,-450,Color.YELLOW);
        	rotators.add(new Rotator());
        	rotators.get(3).create(0,-650,Color.PURPLE);
        	//System.out.println((int)rotators.get(1).getRoot().getBoundsInParent().getCenterY());
        	rotators.add(new Rotator());
        	rotators.get(4).create(0,-850,Color.BLUE);
        	//System.out.println((int)rotators.get(2).getRoot().getBoundsInParent().getCenterY());
        	    	
            mainPane.getChildren().add(rotators.get(0).getRoot1());
            mainPane.getChildren().add(rotators.get(0).getRoot2());
            mainPane.getChildren().add(rotators.get(1).getRoot1());
            mainPane.getChildren().add(rotators.get(1).getRoot2());
            mainPane.getChildren().add(rotators.get(2).getRoot1());
            mainPane.getChildren().add(rotators.get(2).getRoot2());
            mainPane.getChildren().add(rotators.get(3).getRoot1());
            mainPane.getChildren().add(rotators.get(3).getRoot2());
            mainPane.getChildren().add(rotators.get(4).getRoot1());
            mainPane.getChildren().add(rotators.get(4).getRoot2());
//            mainPane.getChildren().add(rotators.get(5).getRoot());
    	}
    	
    	
    	for(Rotator o:rotators)
    	{
    		o.rotate();
    	}
    }
    
    public void checkCollide() {
    	
    	boolean hit =false;
    	
    	for (Obstacle o:obstacles)
    	{
    		hit=o.checkCollision(player);
    		if (hit) {
    			playerMovement.stop();
    			timer.stop();
    			mainPane.getChildren().remove(player);
    			break;
    		}
    	}
    	
    	if (rotators.get(rotatoridx+1).checkCollision(player)) {
    		System.out.println("Collision success");
			rotatoridx++;
    		playerMovement.stop();
    		mainPane.getChildren().remove(player);
    	}
    	
    	if (player.getBoundsInParent().getCenterY()<rotators.get(rotatoridx+1).getRoot1().getBoundsInParent().getCenterY() && player.getBoundsInParent().getCenterY()>1) 
		{
			timer.stop();
			playerMovement.stop();
			hit=true;
			mainPane.getChildren().remove(player);
		}
    	
    	if (hit) {
    		hit_screen.run();
    	}
  
    	
    }
    
    public void pauseScreen() throws FileNotFoundException
    {
        pause.run();
    }
    
    public void moveObstacles()
    {
    	for(Obstacle o:obstacles)
    	{
    		o.moveDown2();
    	}
    }
    
    public void moveRotator()
    {
    	for (Rotator o:rotators)
    	{
    		o.moveDown();
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
