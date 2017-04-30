package com.example.app;

import com.gui.messagebox.CustomMessageBox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App2 extends Application{
	Button button;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		button = new Button();
		button.setText("Click Me");
		button.setOnAction(e -> CustomMessageBox.showMessageBox("Information", " Clicked Button  "));
		StackPane pane = new StackPane();
		pane.getChildren().add(button);
		Scene scene = new Scene(pane,400,250);
		primaryStage.setScene(scene);
		primaryStage.setTitle("My App");
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
