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

public class GUIDriver extends Application {

	Die d1 = new Die(6);
	Die d2 = new Die(6);
	int currentRollV = 0;
	boolean diceRolled = false;
	int diceRoll = 0;
	int totalScore = 0;

	@Override
	public void start(Stage stage) throws Exception {
		VBox vbox = new VBox(10);

		// Create and display the title
		Label title = new Label("Shut The Box");
		vbox.getChildren().add(title);
		HBox tileBox = new HBox(10);
		Button[] tileBtns = new Button[9];
		// tileBtns.set

		for (int i = 0; i < tileBtns.length; i++) {
			tileBtns[i] = new Button(String.valueOf(i + 1));
			tileBtns[i].setStyle("-fx-background-color:#EEEEEE");
			tileBox.getChildren().add(tileBtns[i]);

		}

		for (int k = 6; k < tileBtns.length; k++) {

		}

		tileBox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(tileBox);

		Button btnRoll2 = new Button("ROLL 2 DIE");
		Button btnRoll1 = new Button("ROLL 1 DIE");
		Button btnTurn = new Button("Take a Turn");
		Button btnEnd = new Button("End Turn");
		Button player2 = new Button("Switch to Player 2");
		currentRollV = 0;

		Label result = new Label("Result");
		Label lblValue = new Label(); // output of results
		Label print = new Label("Not a valid move, Please try again");
		Label score = new Label("Final Score");

		Label scoreVPlay1 = new Label(); // output of the score
		print.setVisible(false);
		vbox.getChildren().addAll(btnRoll2, btnRoll1, result, lblValue, btnTurn, btnEnd, print, score, scoreVPlay1, player2);
		vbox.setAlignment(Pos.CENTER);
		btnRoll2.setDisable(false);
		btnRoll1.setDisable(true);
		btnTurn.setDisable(true);
		btnEnd.setDisable(true);
		player2.setDisable(true);
		
		btnRoll2.setOnAction(e -> {

			currentRollV = 0;
			System.out.println("curren rool value when btnRoll2 press" + currentRollV);
			diceRoll = d1.roll() + d2.roll();
			lblValue.setText(String.valueOf(diceRoll));
			btnTurn.setDisable(false);
			btnRoll2.setDisable(true);

		});

		for (Button t : tileBtns) {
			t.setOnAction(e -> {
				System.out.println("click");
				if (t.getStyle().equals("-fx-background-color:#9503a8")) {
					t.setStyle("-fx-background-color:#EEEEEE");

				} else {
					t.setStyle("-fx-background-color:#9503a8");
				}

			});
		}

		btnTurn.setOnAction(e -> {
			currentRollV = 0;
			System.out.println("When the turn button is press " + currentRollV);

			for (int i = 0; i < tileBtns.length; i++) {

				if (tileBtns[i].getStyle().equals("-fx-background-color:#9503a8") && !(tileBtns[i].isDisabled())) {

					currentRollV += i + 1;
				}

			}

			for (Button bt : tileBtns) {
				if (currentRollV == diceRoll) {
					if (bt.getStyle().equals("-fx-background-color:#9503a8")) {

						bt.setDisable(true);
					}
					btnRoll2.setDisable(false);
				}
			}

			if (currentRollV != diceRoll) {
				print.setVisible(true);
				System.out.println("the value of CurrentRoll is" + currentRollV);
				System.out.println("the value of dice roll" + diceRoll);
			} else {
				print.setVisible(false);
				btnTurn.setDisable(true);
			}
			btnEnd.setDisable(false);
		});

		btnEnd.setOnAction(e -> {

			for (int i = 0; i < tileBtns.length; i++) {
				if (tileBtns[i].getStyle().equals("-fx-background-color:#EEEEEE")) {
					totalScore += i + 1;
					System.out.println(totalScore);
					scoreVPlay1.setText(String.valueOf(totalScore));
					btnEnd.setDisable(true);
				}

			}
		});

		Scene scene = new Scene(vbox, 500, 500);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}