package com.c2w.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class PlayerInfoPage {
private static String c2w_pi_url; // URL of the player information page
/**
* Constructor to initialize PlayerInfoPage with a specific
URL.
* @param c2w_pi_url The URL of the player information page.
*/
public PlayerInfoPage(String c2w_pi_url) {
PlayerInfoPage.c2w_pi_url = c2w_pi_url;
}
/**
* Method to create the player information scene.
* @param c2w_pi_backHandler Runnable handler for the back
button action.
* @return The VBox containing the player information UI
components.
*/
public VBox createPlayerInfoScene(Runnable c2w_pi_backHandler) {
// Back button setup
Button c2w_pi_backButton = new Button("Back");
c2w_pi_backButton.setStyle("-fx-pref-width: 120;-fx-min-height: 30;-fx-background-radius: 15; -fx-background-color : #2196F3; -fx-text-fill:#FFFFFF");

// HBox to hold the back button
HBox c2w_pi_header = new HBox(50, c2w_pi_backButton);

c2w_pi_header.setStyle("-fx-pref-width: 800; -fx-pref-height: 30;");

// Set action for the back button
c2w_pi_backButton.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent event) {
c2w_pi_backHandler.run(); // Execute the back handler (logout handler)

}
});
// WebView setup to display the web content (player information)

WebView c2w_pi_webView = new WebView();
WebEngine c2w_pi_webEngine = c2w_pi_webView.getEngine();
c2w_pi_webEngine.load(c2w_pi_url); // Load the specified URL into the WebView

// BorderPane to contain the WebView
BorderPane c2w_pi_root = new BorderPane();
c2w_pi_root.setStyle("-fx-pref-height: 700");
c2w_pi_root.setCenter(c2w_pi_webView);
// VBox to hold all components of the player information page

VBox c2w_pi_vb = new VBox(30, c2w_pi_header, c2w_pi_root);

c2w_pi_vb.setStyle("-fx-background-color:#D3D3D3; -fx-padding: 30;"); // Set background color and padding for the VBox

return c2w_pi_vb; // Return the created VBox containing the player information UI
}
}