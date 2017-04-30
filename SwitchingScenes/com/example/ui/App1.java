package com.example.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App1 extends Application {
	Scene scene2;
	Scene scene1;
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage window = primaryStage;
		
		Label label = new Label();
		label.setText("Scene1 Contents");
		
		Button button = new Button();
		button.setText("Next");
		button.setOnAction(e -> window.setScene(scene2));
		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(label,button);
		StackPane pane1 = new StackPane();
		pane1.getChildren().add(vBox);
		
		Button button2 = new Button();
		button2.setText("Back");
		button2.setOnAction(e -> window.setScene(scene1));
		StackPane pane2 = new StackPane();
		pane2.getChildren().add(button2);
		
		scene1 = new Scene(pane1, 300, 200);
		scene2 = new Scene(pane2, 300, 200);
		
		window.setScene(scene1);
		window.setTitle("Scene Change Demo");
		window.setResizable(false);
		window.show();
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
