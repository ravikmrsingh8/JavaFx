package com.gui.combobox;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ComboBoxDemo extends Application {

	private Stage window;
	private ComboBox<String> comboBox;
	private Button button;

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("ComboBox is pretty cool!");
		comboBox = new ComboBox<>();
		comboBox.getItems().addAll("Good will Hunting", "Forrest Gump", "Cast Away", "Catch me if you can", "Inferno",
				"Da vinci code", "Terminal", "Angels and Demons");
		comboBox.setEditable(false);
		comboBox.setOnAction(e -> processSelectedOption());
		comboBox.setPromptText("Choose your movie");
		button = new Button("Submit");
		button.setOnAction(e -> handleSubmitButton());
		
		VBox vBox = new VBox(10);
		vBox.setAlignment(Pos.TOP_CENTER);
		vBox.getChildren().addAll(comboBox,button);
		
		Scene scene = new Scene(vBox, 300, 200);
		window.setScene(scene);
		window.setResizable(false);
		window.show();
	}

	private void processSelectedOption() {
		System.out.println(comboBox.getValue());
	}
	
	private void handleSubmitButton() {
		System.out.println("On Button Click ->Movies Name "+ comboBox.getValue());
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
