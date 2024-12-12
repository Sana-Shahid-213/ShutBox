package shahid.sana;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUIDriver2 extends Application {

	Die d1 = new Die(6);
	Die d2 = new Die(6);
	int currentRollV;
	boolean diceRolled= false;
	boolean gameOver; 
	int inputValue = 0;
	
	@Override
	public void start(Stage stage) throws Exception {
		VBox vbox = new VBox(10);
		
		// Create and display the title
		Label title = new Label("Shut The Box");
		vbox.getChildren().add(title);
		HBox tileBox = new HBox(10);
		Button[] tileBtns = new Button[9];
		//tileBtns.set
		Tile[] tiles = new Tile[9];
			
		tileBox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(tileBox);
		
		Button btnRoll2 = new Button("ROLL 2 DIE");
		Button btnRoll1 = new Button("ROLL 1 DIE");
		Button btnTurn = new Button("Take a Turn");
		Button btnEnd = new Button("End Turn");
		
		Label result = new Label("Result");
		Label lblValue = new Label(); // output of results
		vbox.getChildren().addAll(btnRoll2, btnRoll1, result,lblValue, btnEnd);
		vbox.setAlignment(Pos.CENTER);

		for (int i=0; i<tileBtns.length; i++) {
			tileBtns[i] = new Button(String.valueOf(i+1));
			tiles[i] = new Tile(i+1);
			tileBox.getChildren().add(tileBtns[i]);
		}
		
		for (Button t : tileBtns) {
			t.setOnAction(e -> {
		
				if(t.getStyle().equals("-fx-background-colour:#00FFFF")) {
					t.setStyle("-fx-background-colour:#EEEEEE");
				}
				else {
					t.setStyle("-fx-background-colour:#00FFFF");
					}
			
			});
			}
			//get the sytle of all the button 
			
			//if totale == current Rolll, disable the bottuns if its valid 
	
		Scene scene = new Scene(vbox,500,300);
		stage.setScene(scene);
		stage.show();
	}
	
	
	// for button selection, check if the first button is less than or equal to the dice rolled
	// then after check if the first button and the second button when pressed are less than or 
	//equal to the value of the dice roll IF GREATER THAN, DO NOT ALLOW THEM TO PREESS THE BUTTON. 
	public static void main(String[] args) {
		launch(args);
	}
}
