package com.example.app;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPrompt extends Application{

	private Stage window;
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Login");
		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10));
		grid.setVgap(8);
		grid.setHgap(8);
		
		Label userNameLabel = new Label("User Name:");
		GridPane.setConstraints(userNameLabel, 0, 0);
		
		TextField userNameInput = new TextField("Bucky");
		GridPane.setConstraints(userNameInput, 1, 0);
		
		Label passwordLabel = new Label("Password:");
		GridPane.setConstraints(passwordLabel, 0, 1);
		
		TextField passInput = new TextField();
		passInput.setPromptText("Password");
		GridPane.setConstraints(passInput, 1, 1);
		
		
		Button loginButton = new Button("Log In"); 
		GridPane.setConstraints(loginButton, 1, 2);
	
		loginButton.setOnAction(e -> {
			boolean status = login(userNameInput.getText(),passInput.getText());
		});
		
		grid.getChildren().addAll(userNameLabel,userNameInput,passwordLabel,passInput,loginButton);
		grid.setAlignment(Pos.CENTER);
		
		BorderPane pane = new BorderPane();
		pane.setCenter(grid);
		
		Scene scene = new Scene(pane, 400, 300);
		window.setScene(scene);
		window.setResizable(false);
		window.show();
	}
	
	private boolean login(String user, String pass) {
		return false;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}
}
