package application;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.control.*;
import javafx.scene.effect.*;
import javafx.scene.paint.*;

public class Category{
    Scene scene1;
    Stage currentStage;
    Stage s;
    Scene sc;
    
    Button back;
    Button lan_button;
    Button cat_button;
    Button cat_in_button;
    
    Text Myanmar;
    Text English;
    Text Lan;

    Image Lang = new Image("lang.png");
    Image Arrow = new Image("arrow.png");
    
    ImageView langText = new ImageView(Lang);
    ImageView backArrow = new ImageView(Arrow);
    
    StackPane root;
    
    boolean languageChange;
    boolean nonesense=false;
    
    public void switchToScene1(ActionEvent event,int SelectValue,boolean lanSwap) {
    	languageChange = lanSwap;
       
        root = new StackPane();
        root.setStyle("-fx-background-color: #F79630");
        
        
        elements();
        lan_change();
        // Retrieve the stage from the event source
        currentStage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        
        scene1 = new Scene(root, currentStage.getWidth(), currentStage.getHeight());
        scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        currentStage.setScene(scene1);
        currentStage.show();
    }
    private void back() {
    	s = currentStage;
        currentStage.setScene(Main.scene);
        currentStage.setHeight(s.getHeight());
        currentStage.setWidth(s.getWidth());
        currentStage.show();
    }
    private void elements() {
    	back = new Button();
        back.getStyleClass().add("lets_start");
        back.setPrefSize(60, 60);
        back.setOnAction(a -> back());
        backArrow.setFitWidth(40);
        backArrow.setFitHeight(30);
        
        back.setGraphic(backArrow);
        StackPane.setAlignment(back, Pos.TOP_LEFT);
        StackPane.setMargin(back, new Insets(30,0,0,30));//top right bottom left
         
    	lan_button = new Button();
		lan_button.setPrefSize(78, 39);
		lan_button.getStyleClass().add("lets_start");
		lan_button.setOnAction(e->lan_click());
		StackPane.setAlignment(lan_button, Pos.TOP_LEFT);
		StackPane.setMargin(lan_button, new Insets(100,0,0,210));
		
		cat_in_button = new Button();
		cat_in_button.setPrefSize(410,65);
		cat_in_button.getStyleClass().add("category_in_button");
		
		cat_button = new Button();
		cat_button.setPrefSize(470,105);
		cat_button.getStyleClass().add("category_button");
		cat_button.setGraphic(cat_in_button);
		cat_button.setOnMouseEntered(e->{
			cat_in_button.setStyle("-fx-background-color: WHITE;");
		});
		cat_button.setOnMouseExited(e->{
			cat_in_button.setStyle("-fx-background-color: BLACK;");
		});
		StackPane.setAlignment(cat_button,Pos.CENTER_RIGHT);
		StackPane.setMargin(cat_button, new Insets(0,150,0,0));
		
		root.getChildren().addAll(lan_button,back,cat_button);
    }
    
    void lan_click() {
    	languageChange = !languageChange;
    	lan_change();
    }
    private void lan_change() {
    	if(languageChange) {
    		langText.setVisible(false);
    		
    		Lan = new Text("Language");
			Font lan_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 20);
			Lan.setFont(lan_font);
			Lan.setFill(Color.WHITE);
			StackPane.setAlignment(Lan, Pos.TOP_LEFT);
			StackPane.setMargin(Lan, new Insets(105,0,0,90));
			
    		English = new Text("ENG");
			Font English_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 20);
			English.setFont(English_font);
			English.setFill(Color.WHITE);
    		lan_button.setGraphic(English);
    		
    		root.getChildren().addAll(Lan);
    		nonesense=true;
    	}
    	else {
    		if(nonesense==true) {
    		Lan.setVisible(false);
    		}
    		langText = new ImageView(Lang);
			langText.setFitWidth(130);
			langText.setFitHeight(20);
			StackPane.setAlignment(langText, Pos.TOP_LEFT);
			StackPane.setMargin(langText, new Insets(110,0,0,70));
			
    		Myanmar = new Text("Myan");
			Font English_font = Font.loadFont(getClass().getResourceAsStream("/PoppinB.ttf"), 20);
			Myanmar.setFont(English_font);
			Myanmar.setFill(Color.WHITE);
    		lan_button.setGraphic(Myanmar);
    		
    		root.getChildren().addAll(langText);
    	}
    }
    private void test() {
    	
    }
}
