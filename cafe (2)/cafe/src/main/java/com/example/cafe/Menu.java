package com.example.cafe;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class Menu {

    public void menu(Stage stage, String user) {
        // StackPane for background and effects
        StackPane menupic = new StackPane();
        menupic.setId("menupic");
        menupic.setEffect(new GaussianBlur(10));

        // Text displaying the welcome message
        Text menuUsername = new Text("Welcome  " + user);
        menuUsername.getStyleClass().add("Text");  // Use this ID for styling via CSS

        // Buttons
        Button dashboard = new Button("Dashboard");
        dashboard.getStyleClass().add("button1");
        dashboard.setStyle("dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 2, 2);");
        Button inventory = new Button("Inventory");
        inventory.getStyleClass().add("button1");
        inventory.setOnAction(event -> {
            InventoryTableApp i1= new InventoryTableApp();
            i1.inventory(stage,user);
        });
        Button menu = new Button("Menu");
        menu.getStyleClass().add("button1");


        Button customers = new Button("Customers");
        customers.getStyleClass().add("button1");
        CafeManagementSystem cms = new CafeManagementSystem();
        Button backButtononLogin = new Button();
        backButtononLogin.getStyleClass().add("backBtn");
        backButtononLogin.setAlignment(Pos.TOP_LEFT);
        backButtononLogin.setOnAction(e->{
            cms.loginScreen(stage);
        });

        // VBox for buttons and text
        VBox menuVbox = new VBox();
        menuVbox.setAlignment(Pos.CENTER);
        menuVbox.setId("menuVbox");
        menuVbox.getChildren().addAll(menuUsername, dashboard, inventory, menu, customers);

        // StackPane for the main menu content
        StackPane mainMenuPane = new StackPane();
        mainMenuPane.getChildren().addAll(menupic, menuVbox,backButtononLogin);

        // Scene setup
        Scene mainMenuScene = new Scene(mainMenuPane, 300, 300);

        // Load the stylesheet
        var stylesheet = getClass().getResource("/com/example/cafe/style.css");
        if (stylesheet != null) {
            mainMenuScene.getStylesheets().add(stylesheet.toExternalForm());
        }

        // Set and show the stage
        stage.setScene(mainMenuScene);
        stage.show();
    }
}
