package com.example.ui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloWorld extends Application{
	Button button;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		button = new Button();
		button.setText("Click Me");
		button.setOnAction( new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("OOooo I love it when you tickle me there!!!");
				
			}
		});
		StackPane pane = new StackPane();
		pane.getChildren().add(button);
		Scene scene = new Scene(pane,400,250);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Hello World");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
