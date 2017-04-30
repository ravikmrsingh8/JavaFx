package com.gui.treeview;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TreeViewDemo extends Application {

	private Stage window;
	private TreeView<String> tree;
	private Button button;
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Tree View Demo");
		
		button  = new Button("Submit");
		button.setOnAction(e -> handleSubmit());
		
		TreeItem<String> root = new TreeItem<>();
		tree = new TreeView<String>();
		tree.setRoot(root);
		root.setExpanded(true);
		tree.setShowRoot(false);
		tree.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
			processTreeItemSelection(v, oldValue, newValue);
		});
		tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		TreeItem<String> bucky = makeBranch(root,"Bucky");
		TreeItem<String> megan = makeBranch( root, "Megan");
		
		makeBranch(bucky, "YouTube");
		makeBranch(bucky, "Facebook");
		makeBranch(bucky, "Twitter");
		makeBranch(bucky, "Whatsapp");
		
		makeBranch(megan, "Glitter");
		makeBranch(megan, "Makeup");
		makeBranch(megan, "Lipgloss");
		makeBranch(megan, "Nivia");
	
		VBox vBox = new VBox(10);
		vBox.setPadding(new Insets(10));
		vBox.setAlignment(Pos.TOP_LEFT);
		vBox.getChildren().addAll(tree,button);
		
		Scene scene = new Scene(vBox, 400,200);
		window.setScene(scene);
		window.setResizable(false);
		window.show();
	}

	private void processTreeItemSelection(ObservableValue<? extends TreeItem<String>> v, TreeItem<String> oldValue,
			TreeItem<String> newValue) {
		if(newValue != null) {
			Logger.getLogger(getClass().getName()).log(Level.INFO,"New Value "+newValue.getValue());
		}
	}

	private Object handleSubmit() {
		Logger.getLogger(getClass().getName()).log(Level.INFO,"Selected Value "+tree.getSelectionModel().getSelectedItems());
		return null;
	}

	private TreeItem<String> makeBranch(TreeItem<String> root , String child ) {
		TreeItem<String> item = new TreeItem<String>(child);
		root.getChildren().add(item);
		
		return item;
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
