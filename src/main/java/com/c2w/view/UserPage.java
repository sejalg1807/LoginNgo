package com.c2w.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserPage {
private PlayerController c2w_pi_c2w_pi_playerController = new PlayerController(); // Service to interact with Firestore
private Scene c2w_pi_playerInfoScene, c2w_pi_userPageScene;
// Scenes for player info and user page
private Stage c2w_pi_primaryStage; // Primary stage of the application

VBox c2w_pi_vb; // VBox to hold the user scene components
public UserPage() {
// Default constructor
}
// Method to set the primary stage
public void setUserPage(Stage c2w_pi_primaryStage){
this.c2w_pi_primaryStage = c2w_pi_primaryStage;
}
// Method to set the user page scene
public void setUserPageScene(Scene c2w_pi_scene){
this.c2w_pi_userPageScene = c2w_pi_scene;
}
// Constructor to initialize the UserPage with the PlayerController instance
public UserPage(PlayerController c2w_pi_c2w_pi_playerController) {

this.c2w_pi_c2w_pi_playerController = c2w_pi_c2w_pi_playerController;
}
// Method to create the user scene
public VBox createUserScene(Runnable c2w_pi_logoutHandler) {
Button c2w_pi_logoutButton = new Button("Logout"); // Button to trigger logout action

c2w_pi_logoutButton.setStyle("-fx-pref-width: 120;-fx-min-height: 30;-fx-background-radius: 15; -fx-background-color : #2196F3; -fx-text-fill:#FFFFFF");

Label c2w_pi_title = new Label("Player List"); // Label to display the title

c2w_pi_title.setStyle("-fx-font-size:30 ;-fx-font-weight: bold; -fx-pref-width: 650; -fx-pref-height: 30; -fx-alignment : CENTER");

HBox c2w_pi_header = new HBox(50,c2w_pi_logoutButton,c2w_pi_title); // Header with logout button and title

c2w_pi_header.setStyle("-fx-pref-width: 1000; -fx-pref-height: 30;");

VBox c2w_pi_cardList = new VBox(10); // VBox to hold the player cards

c2w_pi_cardList.setStyle("-fx-background-color: rgba(211,211, 211, 1)");

// Fetch all countries from the PlayerController
Map<String,String> c2w_pi_countryLists = c2w_pi_c2w_pi_playerController.getAllCountries();
List<String> c2w_pi_c2w_pi_countryNames = new ArrayList<>(c2w_pi_countryLists.keySet());
// Create country cards for each country
for(String c2w_pi_country : c2w_pi_c2w_pi_countryNames){
c2w_pi_cardList.getChildren().add(createCountryCard(c2w_pi_country));
}
// Set action for the logout button
c2w_pi_logoutButton.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent c2w_pi_event) {
c2w_pi_logoutHandler.run(); // Run the logout handler
}
});
ScrollPane c2w_pi_scrollPane = new ScrollPane(); //ScrollPane to hold the card list

c2w_pi_scrollPane.setContent(c2w_pi_cardList);

c2w_pi_scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
c2w_pi_scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

c2w_pi_scrollPane.setFitToWidth(true);
c2w_pi_scrollPane.setPannable(true); // Enable panning
c2w_pi_scrollPane.setStyle("-fx-background: #D3D3D3;");
// Create a VBox layout for the user scene components
c2w_pi_vb = new VBox(30, c2w_pi_header, c2w_pi_scrollPane);

c2w_pi_vb.setStyle("-fx-background-color: rgba(211, 211,211, 1); -fx-background-size: cover; -fx-padding: 30;");
return c2w_pi_vb; // Return the created VBox
}
// Method to create a country card with player cards for each country
private VBox createCountryCard(String c2w_pi_country) {
Label c2w_pi_countryName = new Label(c2w_pi_country); // Label for the country name

c2w_pi_countryName.setStyle("-fx-font-size:20 ;-fx-font-weight: bold; -fx-pref-width: 650; -fx-pref-height: 20;");

HBox c2w_pi_cardList = new HBox(10); // HBox to hold player cards

c2w_pi_cardList.setStyle("-fx-background-color: #D3D3D3;");

// Fetch all players for the given country from the PlayerController

List<Player> c2w_pi_playerList = c2w_pi_c2w_pi_playerController.getAllPlayersByCountry(c2w_pi_country);

// Create player cards for each player

for(Player c2w_pi_player : c2w_pi_playerList){

c2w_pi_cardList.getChildren().add(createPlayerCard(c2w_pi_player));
}
ScrollPane c2w_pi_scrollPane1 = new ScrollPane(); // ScrollPane to hold the player card list

c2w_pi_scrollPane1.setContent(c2w_pi_cardList);

c2w_pi_scrollPane1.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER
);
c2w_pi_scrollPane1.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER
);

c2w_pi_scrollPane1.setPannable(true); // Enable panning
c2w_pi_scrollPane1.setStyle("-fx-background-color: #D3D3D3;");

VBox c2w_pi_countryPlayerCard = new VBox(5,c2w_pi_countryName,c2w_pi_scrollPane1); // VBox to hold country name and player list

c2w_pi_countryPlayerCard.setStyle("-fx-background-color: #D3D3D3;");

return c2w_pi_countryPlayerCard; // Return the created country player card
}
// Method to create a player card
HBox createPlayerCard(Player c2w_pi_player){

Image c2w_pi_playerImg = new Image(c2w_pi_player.getPlayerImg()); // Fetch player image
ImageView plImgView = new ImageView(c2w_pi_playerImg);

// Create ImageView for player image
plImgView.setFitHeight(120);
plImgView.setPreserveRatio(true);
plImgView.setStyle("-fx-border-color: black; -fx-border-width: 1px;-fx-border-style: solid;");

Label c2w_pi_playerName = new Label(c2w_pi_player.getPlayerName()); // Label for player name

c2w_pi_playerName.setStyle("-fx-font-size : 20px;-fx-font-weight: bold;");

HBox name = new HBox(c2w_pi_playerName);
Label c2w_pi_ageLabel = new Label("Age : ");
c2w_pi_ageLabel.setStyle("-fx-font-weight: bold;");
Label c2w_pi_playerAge = new Label(String.valueOf(c2w_pi_player.getPlayerAge())); // Label for player age

HBox c2w_pi_age = new HBox(c2w_pi_ageLabel,c2w_pi_playerAge);

Label c2w_pi_roleLabel = new Label("Role : ");
c2w_pi_roleLabel.setStyle("-fx-font-weight: bold;");
Label c2w_pi_playerRole = new Label(c2w_pi_player.getPlayerRole()); // Label for player role

HBox c2w_pi_role = new HBox(c2w_pi_roleLabel,c2w_pi_playerRole);

Label c2w_pi_batStyleLabel = new Label("Batting Style : ");

c2w_pi_batStyleLabel.setStyle("-fx-font-weight: bold;");
Label c2w_pi_battingStyle = new Label(c2w_pi_player.getBattingStyle()); // Label for batting style

HBox c2w_pi_batStyle = new HBox(c2w_pi_batStyleLabel,c2w_pi_battingStyle);

Label c2w_pi_bowlStyleLabel = new Label("Bowling Style : ");

c2w_pi_bowlStyleLabel.setStyle("-fx-font-weight: bold;");
Label c2w_pi_bowlingStyle = new Label(c2w_pi_player.getBowlingStyle()); // Label for bowling style

HBox bowlStyle = new HBox(c2w_pi_bowlStyleLabel,c2w_pi_bowlingStyle);

VBox c2w_pi_playerInfo = new VBox(5,name, c2w_pi_age, c2w_pi_role, c2w_pi_batStyle, bowlStyle); // VBox to hold player info

c2w_pi_playerInfo.setStyle("-fx-pref-width : 230");
HBox c2w_pi_card = new HBox(20,plImgView,c2w_pi_playerInfo); // HBox to hold player image and info

c2w_pi_card.setStyle("-fx-border-color: black; -fx-border-width: 2px;-fx-border-style: solid; -fx-border-radius: 5px; -fx-background-color: rgba(255, 255, 255, 1)");

c2w_pi_card.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent c2w_pi_event) {
initPlayerInfoScene(c2w_pi_player.getInfoUrl());

// Initialize player info scene
c2w_pi_primaryStage.setScene(c2w_pi_playerInfoScene); // Show player info scene

c2w_pi_primaryStage.setTitle("Admin Dashboard");
}
});
return c2w_pi_card; // Return the created player card
}


// Method to initialize the player info scene
private void initPlayerInfoScene(String c2w_pi_infoUrl) {
PlayerInfoPage c2w_pi_playerInfoPage = new PlayerInfoPage(c2w_pi_infoUrl); // Create PlayerInfoPage instance

c2w_pi_playerInfoScene = new Scene(c2w_pi_playerInfoPage.createPlayerInfoScene(this::handleBack), 1000, 800); // Create player info scene
}
// Method to handle the back action from the player info scene
private void handleBack() {
c2w_pi_primaryStage.setScene(c2w_pi_userPageScene); //Show user page scene
}
}