package com.example.app;

import com.gui.messagebox.ConfirmBox;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App4 extends Application{
	Button button;
	Stage window;
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		button = new Button();
		button.setText("Done");
		button.setMinWidth(100);
		button.setOnAction(e -> closeProgram());
		
		StackPane pane = new StackPane();
		pane.getChildren().add(button);
		Scene scene = new Scene(pane,400,250);
		
		window = primaryStage; 
		window.setScene(scene);
		window.setTitle("My App");
		window.setResizable(false);
		window.setOnCloseRequest(e -> {
			e.consume();   // Handle the queued event
			closeProgram();// Use our custom method
		});
		window.show();
		
	}
	private void closeProgram() {
		boolean confirmation = ConfirmBox.showConfirmBox("Conform","Are you Done? sure?");
		if(confirmation) {
			System.out.println("Wearing Shirt.");
			System.out.println("Putting pants on.");
			System.out.println("Leaving Girlfriend's place.");
			System.out.println("All Cleaned up..");
			window.close();
		}
	}
	public static void main(String[] args) {
		Application.launch(args);
	}
}
