package com.gui.listview;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewDemo extends Application {

	private Stage window;
	private ListView<String> list;
	Button button;
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("ListView");
		
		Label label = new Label("Select Skills");
		list = new ListView<>();
		list.getItems().addAll("C","C++", "Java","Python", "Spring Framework","Hibernate","Restful WebService","Java Messaging Service");
		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		list.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue)->{
			Logger.getLogger(getClass().getName()).log(Level.INFO, "Selected "+ newValue);
		});
		
		button = new Button("Submit");
		button.setOnAction(e -> processSelectedList());
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(20));
		vBox.getChildren().addAll(label,list,button);
		Scene scene = new Scene(vBox, 300, 250);
		window.setScene(scene);
		window.setResizable(false);
		window.show();
	}

	private Object processSelectedList() {
		StringBuilder skills = new StringBuilder();
		ObservableList<String>  skillList = list.getSelectionModel().getSelectedItems();
		for(String skill : skillList) {
			skills.append(skill+"\n");
		}
		Logger.getLogger(getClass().getName()).log(Level.INFO, skills.toString());
		return null;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
