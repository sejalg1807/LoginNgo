package com.c2w.view;

import java.util.List;
import com.c2w.controller.PlayerController;
import com.c2w.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
/**
* This class represents the UI for displaying a list of players.
*/
public class PlayerListPage {
private Stage c2w_pi_primaryStage;
private PlayerController c2w_pi_c2w_pi_playerController = new
PlayerController(); // Service to interact with Firestore
private Scene c2w_pi_c2w_pi_playerListScene,
c2w_pi_addPlayerScene;
static String c2w_pi_country = null;
VBox c2w_pi_vb; // VBox to hold the user scene components
/**
* Constructor to initialize the country for which player
list is displayed.
* @param c2w_pi_country The country name.

*/
public PlayerListPage(String c2w_pi_country) {
PlayerListPage.c2w_pi_country = c2w_pi_country;
}
/**
* Setter for the player list scene.
* @param scene The scene to set.
*/
public void setPlayerListScene(Scene scene){
this.c2w_pi_c2w_pi_playerListScene = scene;
}
/**
* Setter for the primary stage.
* @param c2w_pi_primaryStage The primary stage to set.
*/
public void setPlayerListPage(Stage c2w_pi_primaryStage){
this.c2w_pi_primaryStage = c2w_pi_primaryStage;
}
/**
* Constructor to initialize the PlayerListPage with a
specific PlayerController instance.
* @param c2w_pi_c2w_pi_playerController The PlayerController
instance to use.
*/
public PlayerListPage(PlayerController
c2w_pi_c2w_pi_playerController) {

this.c2w_pi_c2w_pi_playerController =

c2w_pi_c2w_pi_playerController;
}
/**
* Method to create the player list scene.
* @param c2w_pi_backHandler The handler for the back button.

* @return The VBox containing the player list scene
components.
*/
public VBox createPlayerListScene(Runnable
c2w_pi_backHandler) {

// Create UI components
Button c2w_pi_logoutButton = new Button("Back"); // Button to trigger logout action

c2w_pi_logoutButton.setStyle("-fx-pref-width: 120;-fx-min-height: 30;-fx-background-radius: 15; -fx-background-color : #2196F3; -fx-text-fill:#FFFFFF");
Label c2w_pi_title = new Label("Player List of " +c2w_pi_country); // Label to display the country name

c2w_pi_title.setStyle("-fx-font-size:30 ;-fx-font-weight: bold; -fx-pref-width: 700; -fx-pref-height: 30; -fx-alignment : CENTER");

Button c2w_pi_addPlayer = new Button("Add Player");
c2w_pi_addPlayer.setStyle("-fx-pref-width: 120;-fx-min-height: 30;-fx-background-radius: 15; -fx-background-color : #2196F3; -fx-text-fill:#FFFFFF");

HBox c2w_pi_header = new HBox(50,c2w_pi_logoutButton,c2w_pi_title,c2w_pi_addPlayer);
c2w_pi_header.setStyle("-fx-pref-width: 800; -fx-pref-height: 30; ");

VBox c2w_pi_c2w_pi_cardList = new VBox(10);
List<Player> c2w_pi_c2w_pi_playerList =

c2w_pi_c2w_pi_playerController.getAllPlayersByCountry(c2w_pi_country);

// Create player cards for each player in the list
for(Player c2w_pi_player : c2w_pi_c2w_pi_playerList){
c2w_pi_c2w_pi_cardList.getChildren().add(createPlayerCard(c2w_pi_player));

}
// Set action for the logout button
c2w_pi_logoutButton.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent c2w_pi_event) {
c2w_pi_backHandler.run(); // Run the back handler
}
});
// Set action for the add player button
c2w_pi_addPlayer.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent c2w_pi_event) {
initAddPlayerScene(); // Initialize add player scene
c2w_pi_primaryStage.setScene(c2w_pi_addPlayerScene); // Show add player scene

c2w_pi_primaryStage.setTitle("Admin Dashboard");
}
});
// Scroll pane to hold the list of player cards
ScrollPane c2w_pi_scrollPane = new ScrollPane();
c2w_pi_scrollPane.setContent(c2w_pi_c2w_pi_cardList);
c2w_pi_scrollPane.setFitToWidth(true);
c2w_pi_scrollPane.setStyle("-fx-background: #D3D3D3;");
// Create a VBox layout for the player list scene components

c2w_pi_vb = new VBox(30,c2w_pi_header, c2w_pi_scrollPane);

c2w_pi_vb.setStyle("-fx-background-color:#D3D3D3; -fx-padding: 30;"); // Set background color and padding
return c2w_pi_vb; // Return the created VBox
}
/**
* Initializes the add player scene.
*/
private void initAddPlayerScene() {

AddPlayerPage c2w_pi_addPlayerPage = new AddPlayerPage(c2w_pi_country); // Create AddPlayerPage instance
c2w_pi_addPlayerPage.setAddPlayerPage(c2w_pi_primaryStage);

c2w_pi_addPlayerScene = new Scene(c2w_pi_addPlayerPage.createPlayerScene(this::handleBack),1000, 800); // Create add player scene
}
/**
* Handler for navigating back from add player scene to
player list scene.
*/
private void handleBack() {
c2w_pi_primaryStage.setScene(c2w_pi_c2w_pi_playerListScene); //Show player list scene
}
/**
* Creates a player card UI component.
* @param c2w_pi_player The player object to display.
* @return The HBox containing the player card.
*/
HBox createPlayerCard(Player c2w_pi_player){
// Create and style player image

Image c2w_pi_playerImage = new Image(c2w_pi_player.getPlayerImg());
ImageView c2w_pi_plImageView = new ImageView(c2w_pi_playerImage);

c2w_pi_plImageView.setFitHeight(120);
c2w_pi_plImageView.setPreserveRatio(true);
c2w_pi_plImageView.setStyle("-fx-border-color: black; -fx-border-width: 1px;-fx-border-style: solid;");

Circle c2w_pi_clip = new Circle(60, 60, 60); // CenterX, CenterY, Radius

c2w_pi_plImageView.setClip(c2w_pi_clip);
// Create player name label
Label c2w_pi_playerName = new Label(c2w_pi_player.getPlayerName());

c2w_pi_playerName.setStyle("-fx-font-size : 20px;-fx-font-weight: bold;");

HBox c2w_pi_name = new HBox(c2w_pi_playerName);
// Create age label
Label ageLabel = new Label("Age : ");
ageLabel.setStyle("-fx-font-weight: bold;");
Label c2w_pi_playerAge = new Label(String.valueOf(c2w_pi_player.getPlayerAge()));
HBox age = new HBox(ageLabel,c2w_pi_playerAge);
// Create role label
Label c2w_pi_c2w_pi_roleLabel = new Label("Role : ");
c2w_pi_c2w_pi_roleLabel.setStyle("-fx-font-weight: bold;");

Label c2w_pi_playerRole = new Label(c2w_pi_player.getPlayerRole());
HBox c2w_pi_role = new HBox(c2w_pi_c2w_pi_roleLabel,c2w_pi_playerRole);

// Create batting style label

Label c2w_pi_c2w_pi_batStyleLabel = new Label("Batting Style : ");

c2w_pi_c2w_pi_batStyleLabel.setStyle("-fx-font-weight: bold;");

Label c2w_pi_battingStyle = new Label(c2w_pi_player.getBattingStyle());
HBox c2w_pi_batStyle = new HBox(c2w_pi_c2w_pi_batStyleLabel,c2w_pi_battingStyle);

// Create bowling style label
Label c2w_pi_c2w_pi_bowlStyleLabel = new Label("Bowling Style : ");

c2w_pi_c2w_pi_bowlStyleLabel.setStyle("-fx-font-weight: bold;");

Label c2w_pi_bowlingStyle = new Label(c2w_pi_player.getBowlingStyle());
HBox c2w_pi_bowlStyle = new HBox(c2w_pi_c2w_pi_bowlStyleLabel,c2w_pi_bowlingStyle);

// VBox to hold player information
VBox c2w_pi_playerInfo = new VBox(3,c2w_pi_name, age, c2w_pi_role, c2w_pi_batStyle, c2w_pi_bowlStyle);
// HBox to hold entire player card
HBox c2w_pi_card = new HBox(20,c2w_pi_plImageView,c2w_pi_playerInfo);

c2w_pi_card.setStyle("-fx-border-color: black; -fx-border-width: 2px;-fx-border-style: solid; -fx-border-radius: 5px; -fx-background: WHITE;");
return c2w_pi_card;
}
}