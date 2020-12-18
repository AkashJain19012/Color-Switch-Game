package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Shoot {
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 400;
	private int id=-1;
	
	private Stage mainStage;
	private AnchorPane mainPane,resumePane;
	private Scene mainScene,prevScene,homeScene,resumeScene;
	private ShootingGame g,g2;
	private ComboBox list;
	
	private ArrayList<Integer> l;
	
	private Button play_button,resume_button,back_button,ok_button;
	
	private ArrayList<ShootingGame> savedGames;
	
	public Shoot(Stage stage, Scene tempScene,Scene homeScene) throws FileNotFoundException
	{
		mainPane = new AnchorPane(); 
		mainScene = new Scene(mainPane, WIDTH, HEIGHT );
		mainStage = stage;
		prevScene=tempScene;
		resumePane=new AnchorPane();
		resumeScene=new Scene(resumePane,WIDTH,HEIGHT);
		this.homeScene=homeScene;
		savedGames=new ArrayList<ShootingGame>();
		BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		mainPane.setBackground(background);
		resumePane.setBackground(background);
		addButtons();
		run();
		
	}
	
	public void run() throws FileNotFoundException
	{
        mainStage.setScene(mainScene);  
        mainStage.show();  
        
        play_button.setOnAction(e->{
			try {
				play();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        
        resume_button.setOnAction( e-> {
			try {
				if(savedGames.size()>0)
				{
					resume();
				}
				else
				{
					System.out.println("Empty");
				}
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
        
        back_button.setOnAction(e -> {
			back();
		});

	}
	
	public void play() throws FileNotFoundException
	{
		g=new ShootingGame(mainStage,mainScene,homeScene);
		g.run();
		System.out.println("making a new game");
		AnimationTimer timer=new AnimationTimer() {
    		public void handle(long now) {
    			if(g.getSaved())
    			{
    				savedGames.add(g);
    				
    				System.out.println("Initial Game Saved");
    				stop();
    			}
    		}
		};
		timer.start();
		
		
	}
	
	public void resume() throws FileNotFoundException
	{
//		id=-1;
//		System.out.println("In resume function");
//		list.getItems().clear();
//		l=new ArrayList<Integer>();
//		
//		
//		for(int i=0;i<savedGames.size();++i)
//		{
//			if(i<(savedGames.size()-1) && savedGames.get(i).getName()==savedGames.get(i+1).getName())
//			{
//				l.add(i-l.size());
//			}
//			if(savedGames.get(i).getClosed() || savedGames.get(i).getName()==null)
//			{
//				l.add(i-l.size());
//			}
//		}
//		
//		for(int i=0;i<l.size();++i)
//		{
//			savedGames.remove(savedGames.get(l.get(i)));
//		}
//		
//		for(int i=0;i<savedGames.size();++i)
//		{
//			System.out.println(savedGames.get(i).getName());
//			list.getItems().add(savedGames.get(i).getName());
//		}
//		System.out.println(savedGames.size());
//		mainStage.setScene(resumeScene);
//		ok_button.setOnAction(e->{
//			for(int i=0;i<list.getItems().size();++i)
//			{
//				if(list.getValue()==savedGames.get(i).getName())
//				{
//					id=i;
//					break;
//				}
//			}
//			try {
//				g2=(Game)savedGames.get(id).clone();
//			} catch (CloneNotSupportedException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//			g2.setSaved();
//			g2.play();
//			AnimationTimer timer=new AnimationTimer() {
//	    		public void handle(long now) {
//	    			if(g2.getSaved())
//	    			{
//	    				savedGames.add(g2);
//	    				
//	    				System.out.println("Updated Game Saved");
//	    				stop();
//	    			}
//	    		}
//			};
//			timer.start();
//			
//		});
		
		
		
	}
	
	public void back()
	{    
		System.out.println("back");
		mainStage.setScene(prevScene);
	}
	
	
	public void addButtons()
	{
		play_button=new Button("PLAY");
		play_button.setLayoutX(130);
		play_button.setLayoutY(150);
		play_button.setMinSize(120,70);
		play_button.setMaxSize(120, 70);
		play_button.setStyle("-fx-background-color: BlueViolet");
		play_button.setTextFill(Color.WHITE);
		play_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		
		resume_button=new Button("RESUME");
		resume_button.setLayoutX(130);
		resume_button.setLayoutY(250);
		resume_button.setMinSize(120,70);
		resume_button.setMaxSize(120, 70);
		resume_button.setStyle("-fx-background-color: BlueViolet");
		resume_button.setTextFill(Color.WHITE);
		resume_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		
		back_button=new Button("BACK");
		back_button.setLayoutX(130);
        back_button.setLayoutY(350);
        back_button.setMinSize(120, 70);
        back_button.setMaxSize(120, 70);
        back_button.setStyle("-fx-background-color: BlueViolet");
		back_button.setTextFill(Color.WHITE);
		back_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		
		ok_button=new Button("OK");
		ok_button.setLayoutX(130);
        ok_button.setLayoutY(300);
        ok_button.setMinSize(120, 70);
        ok_button.setMaxSize(120, 70);
        ok_button.setStyle("-fx-background-color: BlueViolet");
		ok_button.setTextFill(Color.WHITE);
		ok_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		
		list= new ComboBox();
		list.setPromptText("SELECT A GAME");
		list.setLayoutX(100);
		list.setLayoutY(200);
		list.setPrefSize(200,40);
		list.setStyle("-fx-background-color: White");
        
        mainPane.getChildren().add(play_button);
        mainPane.getChildren().add(resume_button);
        mainPane.getChildren().add(back_button);
        resumePane.getChildren().add(list);
		resumePane.getChildren().add(ok_button);
        
        
	}
}
