package com.gui.menus;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
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
		
		// Menu Items
		MenuItem undo = new MenuItem("Undo");
		undo.setDisable(true);
		
		MenuItem redo = new MenuItem("Redo  ");
		MenuItem separator3 = new SeparatorMenuItem();

		MenuItem cut = new MenuItem("Cut");
		MenuItem copy = new MenuItem("Copy");
		MenuItem paste = new MenuItem("Paste");

		editMenu.getItems().addAll(undo, redo, separator3, cut, copy, paste);

		// MenuBar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, editMenu);

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
