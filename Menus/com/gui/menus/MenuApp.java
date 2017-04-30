package com.gui.menus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuApp extends Application {
	private Stage window;

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		// File Menu
		Menu fileMenu = new Menu("_File");

		// Menu Items
		MenuItem newItem = new MenuItem("New ");
		MenuItem openFile = new MenuItem("Open File...");
		MenuItem separator = new SeparatorMenuItem();

		MenuItem save = new MenuItem("Save");
		MenuItem saveAs = new MenuItem("Save As...");
		MenuItem separator2 = new SeparatorMenuItem();

		MenuItem exit = new MenuItem("Exit");
		exit.setOnAction(e -> window.close());
		
		fileMenu.getItems().addAll(newItem, openFile, separator, save, saveAs, separator2, exit);

		// Edit Menu
		Menu editMenu = new Menu("_Edit");
		
		
		MenuItem undo = new MenuItem("Undo");
		undo.setDisable(true);
		
		MenuItem redo = new MenuItem("Redo  ");
		MenuItem separator3 = new SeparatorMenuItem();

		MenuItem cut = new MenuItem("Cut");
		MenuItem copy = new MenuItem("Copy");
		MenuItem paste = new MenuItem("Paste");

		editMenu.getItems().addAll(undo, redo, separator3, cut, copy, paste);

		//Help Menu
		Menu helpMenu = new Menu("Help");
		CheckMenuItem showLineNumber = new CheckMenuItem("Show Line Numbers");
		showLineNumber.setOnAction(e -> {
			System.out.println("Show Line Num "+showLineNumber.isSelected());
		});
		CheckMenuItem autoSave = new CheckMenuItem("Auto Save");
		autoSave.setOnAction(e -> {
			System.out.println("Auto Save "+autoSave.isSelected());
		});	
		helpMenu.getItems().addAll(showLineNumber,autoSave);
		
		
		
		//Difficulty Menu - Radio Menu Items
		Menu difficulty = new Menu("Difficulty");
		ToggleGroup difficultyGroup = new ToggleGroup();
		
		RadioMenuItem easy = new RadioMenuItem("Easy");
		easy.setOnAction(e -> System.out.println("Easy Selected"));
		
		RadioMenuItem medium = new RadioMenuItem("Medium");
		medium.setOnAction(e -> System.out.println("Medium Selected"));
		
		RadioMenuItem hard = new RadioMenuItem("Hard");
		hard.setOnAction(e -> System.out.println("Hard Selected"));
		
		easy.setToggleGroup(difficultyGroup);
		medium.setToggleGroup(difficultyGroup);
		hard.setToggleGroup(difficultyGroup);
		
		difficulty.getItems().addAll(easy,medium,hard);
		// MenuBar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, editMenu, helpMenu,difficulty);

		// BorderPane
		BorderPane layout = new BorderPane();
		layout.setTop(menuBar);

		Scene scene = new Scene(layout, 400, 300);
		window.setTitle("Menu Bar Example");
		window.setScene(scene);
		window.setResizable(false);
		window.show();
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
