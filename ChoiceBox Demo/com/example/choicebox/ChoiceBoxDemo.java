package com.example.choicebox;

import java.util.HashMap;
import java.util.Map;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ChoiceBoxDemo extends Application {

	private Stage window;
	private Scene scene;
	private StackPane pane;
	private ChoiceBox<String> colors;
	private Map<String, Color> colorMap = new HashMap<>(); 
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		colorMap.put("ANTIQUEWHITE",Color.ANTIQUEWHITE);
		colorMap.put("AQUA",Color.AQUA);
		colorMap.put("AZURE",Color.AZURE);
		colorMap.put("BLANCHEDALMOND",Color.BLANCHEDALMOND);
		colorMap.put("DARKGRAY",Color.DARKGRAY);
		colorMap.put("CRIMSON",Color.CRIMSON);
		colorMap.put("CHOCOLATE",Color.CHOCOLATE);
		colorMap.put("CORAL",Color.CORAL);
		colorMap.put("HOTPINK",Color.HOTPINK);
		colorMap.put("DARKMAGENTA",Color.DARKMAGENTA);
		colorMap.put("TEAL",Color.TEAL);
		
		
		window = primaryStage;
		window.setTitle("ChoiceBox");
		
		colors = new ChoiceBox<String>();
		colors.getItems().addAll("ANTIQUEWHITE","AQUA", "AZURE","BLANCHEDALMOND", "CHOCOLATE", "DARKGRAY", "HOTPINK", "CORAL", "TEAL");
		colors.setValue("HOTPINK");
		colors.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			pane.setBackground(new Background(new BackgroundFill(colorMap.get(newValue),new CornerRadii(0), new Insets(0))));
			System.out.println(oldValue + " "+ newValue );
		});
		
		Button button = new Button("Color Code");
		button.setOnAction( e -> {
			String color = colors.getValue();
			System.out.println(colorMap.get(color).toString());
		});
		
		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(colors,button);
		vBox.setAlignment(Pos.TOP_CENTER);
		pane = new StackPane();
		pane.getChildren().addAll(vBox);
		pane.setBackground(new Background(new BackgroundFill(Color.HOTPINK,new CornerRadii(0), new Insets(0))));
		scene = new Scene(pane, 300, 200);
		window.setScene(scene);
		window.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
