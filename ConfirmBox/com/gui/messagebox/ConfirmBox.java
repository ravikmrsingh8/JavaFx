package com.gui.messagebox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

	private static Stage stage;
	private static boolean answer;
	public static boolean showConfirmBox(String title, String message) {
		TextFlow textFlow = new TextFlow(new Text(message));
		textFlow.setTextAlignment(TextAlignment.CENTER);
		textFlow.setMaxWidth(380);
		textFlow.setMinWidth(250);
		
		Button yesButton = new Button(" Yes ");
		yesButton.setOnAction(e -> {
			answer = true;
			stage.close();
		});
		
		Button noButton = new Button("No");
		noButton.setOnAction(e -> {
			answer = false;
			stage.close();
		});
		
		
		ButtonBar buttonBar = new ButtonBar();
		buttonBar.getButtons().addAll( noButton,yesButton);
		buttonBar.setButtonMinWidth(80);
		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.CENTER);
		hBox.getChildren().add(buttonBar);
		
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(textFlow, hBox);
		vBox.setPadding(new Insets(10));

		stage = new Stage();
		stage.setScene(new Scene(vBox));
		stage.setTitle(title);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();
		return answer;
	}

}
