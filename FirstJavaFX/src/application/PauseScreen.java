package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class PauseScreen {
	
	private static final int HEIGHT = 600;
	private static final int WIDTH = 400;
	
	private Stage mainStage;
	private AnchorPane mainPane;
	private Scene mainScene,prevScene,homeScene;
	
	private Button resume_button,save_button,home_button;
	private Label pause_label;
	private TextField name_field;
	
	private int flag=0;
	private static boolean saved;
	private static boolean resume;
	private String name;
	
	
	PauseScreen(Stage stage,Scene tempScene,Scene homeScene)
	{
		
		this.mainStage=stage;
		prevScene=tempScene;
		saved=false;
		resume=false;
		mainPane = new AnchorPane(); 
		mainScene = new Scene(mainPane, WIDTH, HEIGHT );
		this.homeScene=homeScene;
	}
	
	
	public void run() throws FileNotFoundException 
	{
		
		
		BackgroundFill background_fill = new BackgroundFill(Color.BLACK,CornerRadii.EMPTY, Insets.EMPTY); 
		Background background = new Background(background_fill); 
		mainPane.setBackground(background);
		
		mainStage.setScene(mainScene);  
        mainStage.show(); 
        addButtons();
        
        home_button.setOnAction(e -> {
			backToHome();
		});
        
        resume_button.setOnAction(e -> {
        	resume();
        });
        
        save_button.setOnAction(e -> {
        	//System.out.println("save button");
        	save();
        });
	}
	
	private void backToHome() {
		// TODO Auto-generated method stub
		mainStage.setScene(homeScene);
		
	}
	
	public void resume()
	{       
		resume=true;
        mainStage.setScene(prevScene);
	}
	
	public boolean getResume()
	{
		return resume;
	}
	
	public void setResume()
	{
		resume=false;
	}
	
	public void save()
	{
		name=name_field.getText();
		saved=true;
		mainStage.setScene(prevScene);
		
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean getSaved()
	{
		return saved;
	}


	public void addButtons() throws FileNotFoundException 
	{
		
		resume_button=new Button("RESUME");
		resume_button.setLayoutX(150);
		resume_button.setLayoutY(200);
		resume_button.setMinSize(120,70);
		resume_button.setMaxSize(120, 70);
		resume_button.setStyle("-fx-background-color: BlueViolet");
		resume_button.setTextFill(Color.WHITE);
		resume_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
	    
	    save_button=new Button("SAVE AS");
		save_button.setLayoutX(150);
		save_button.setLayoutY(300);
		save_button.setMinSize(120,70);
		save_button.setMaxSize(120, 70);
		save_button.setStyle("-fx-background-color: BlueViolet");
		save_button.setTextFill(Color.WHITE);
		save_button.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		
		name_field = new TextField ();
		name_field.setLayoutX(150);
		name_field.setLayoutY(400);
		name_field.setPrefSize(120, 70);
		name_field.setStyle("-fx-background-color: BlueViolet");
		name_field.setFont(Font.font ("Verdana",FontWeight.BOLD, 18));
		name_field.setAlignment(Pos.BASELINE_CENTER);
		
		Image img1 = new Image(new FileInputStream("C:\\Users\\AKASH\\eclipse-workspace\\FirstJavaFX\\src\\Images\\home.png"));  
	    ImageView view1 = new ImageView(img1);
	    view1.setFitHeight(50);
	    view1.setPreserveRatio(true);
	    home_button = new Button();
	    home_button.setTranslateX(0);
	    home_button.setTranslateY(0);
	    home_button.setPrefSize(50, 50);
	    home_button.setGraphic(view1);
	    home_button.setStyle("-fx-background-color: transparent;");
		
//		mainPane.getChildren().add(pause_label);
		mainPane.getChildren().add(resume_button);
		mainPane.getChildren().add(save_button);
		mainPane.getChildren().add(home_button);
		mainPane.getChildren().add(name_field);
	}
	

	
	
	

}
