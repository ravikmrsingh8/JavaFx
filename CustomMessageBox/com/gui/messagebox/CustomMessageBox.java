package com.gui.messagebox;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CustomMessageBox {

	private static Stage stage;

	public static void showMessageBox(String title, String message) {
		TextFlow textFlow = new TextFlow(new Text(message));
		textFlow.setTextAlignment(TextAlignment.CENTER);
		textFlow.setMaxWidth(380);
		textFlow.setMinWidth(250);
		Button okButton = new Button(" Ok ");
		okButton.setMinWidth(80);
		okButton.setOnAction(e -> stage.close());
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.CENTER);
		vBox.getChildren().addAll(textFlow, okButton);
		vBox.setPadding(new Insets(10));

		stage = new Stage();
		stage.setScene(new Scene(vBox));
		stage.setTitle(title);
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.showAndWait();

	}

}
