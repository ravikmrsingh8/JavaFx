package com.gui.tableview;

import com.model.Product;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewDemo extends Application {
	private Stage window;
	private TableView<Product> productsTable;
	ButtonBar buttonBar;
	Button add;
	Button edit;
	Button delete;
	Button save;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Product Table");
		
		add = new Button("Add");
		edit = new Button("Edit");
		delete = new Button("Delete");
		save = new Button("Save");
		
		add.setOnAction(e -> processAddRow());
		edit.setOnAction(e -> processDeleteRow());
		delete.setOnAction(e -> processDelete());
		save.setOnAction( e -> processSave());
		
		buttonBar = new ButtonBar();
		//buttonBar.setButtonMinWidth(100);
		buttonBar.getButtons().addAll(add,edit,delete,save); 
		
		HBox hBox = new HBox();
		hBox.setPadding(new Insets(10,5,0,10));
		hBox.setSpacing(10);
		hBox.getChildren().add(buttonBar);
		
		productsTable = new TableView<Product>();
		TableColumn<Product, String> name = new TableColumn<>("Name");
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		name.setMinWidth(200);
		
		TableColumn<Product, Double> price = new TableColumn<>("Price");
		price.setCellValueFactory(new PropertyValueFactory<>("price"));
		price.setMinWidth(100);
		
		TableColumn<Product, String> quantity = new TableColumn<>("Quantity");
		quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		quantity.setMinWidth(100);
		
		
		productsTable.getColumns().addAll(name,price,quantity);
		productsTable.setItems(getProducts());
		productsTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		productsTable.setMaxHeight(300);
		
		VBox vBox = new VBox(10);
		vBox.getChildren().addAll(hBox, productsTable);
		
		Scene scene = new Scene(vBox);
		
		window.setScene(scene);
		window.setResizable(false);
		window.sizeToScene();
		window.show();
	}

	private Object processSave() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object processDelete() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object processDeleteRow() {
		// TODO Auto-generated method stub
		return null;
	}

	private Object processAddRow() {
		return null;
	}

	private ObservableList<Product> getProducts() {
		ObservableList<Product> products = FXCollections.observableArrayList();
		products.add(new Product("Laptop", 345, 2));
		products.add(new Product("Toilet", 40, 12));
		products.add(new Product("Movies", 234, 120));
		products.add(new Product("Mango shake", 454, 109));
		products.add(new Product("Friends DVD",4, 1));
		products.add(new Product("Meatball", 2, 100));
		return products;
	}
	public static void main(String[] args) {
		Application.launch(args);
	}

}
