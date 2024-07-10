package com.c2w.view;


import java.io.File;
import java.util.HashMap;
import java.util.Map;
import com.c2w.controller.ImageUpload;
import com.c2w.controller.PlayerController;
import com.c2w.model.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class AddPlayerPage {
private PlayerController c2w_pi_playerController = new PlayerController();
private static String c2w_pi_country = null, c2w_pi_imgUrl = null;
private Stage c2w_pi_primaryStage;

/**
* Constructor to initialize the AddPlayerPage with a
specific country.
* @param c2w_pi_country The country for which the player is
being added.
*/
public AddPlayerPage(String c2w_pi_country){
AddPlayerPage.c2w_pi_country = c2w_pi_country;
}
/**
* Setter for the primary stage.
* @param c2w_pi_primaryStage The primary stage to set.
*/
void setAddPlayerPage(Stage c2w_pi_primaryStage){
this.c2w_pi_primaryStage = c2w_pi_primaryStage;
}
/**
* Method to create the player addition scene.
* @param c2w_pi_backHandler Runnable handler for the back
button action.
* @return The VBox containing the player addition UI
components.
*/
public VBox createPlayerScene(Runnable c2w_pi_backHandler) {
// Back button setup
Button c2w_pi_backButton = new Button("Back");
c2w_pi_backButton.setStyle("-fx-pref-width: 120;-fx-min-height: 30;-fx-background-radius: 15; -fx-background-color : #2196F3; -fx-text-fill:#FFFFFF");

c2w_pi_backButton.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent c2w_pi_event) {

c2w_pi_backHandler.run(); // Execute the back handler
}
});
// Title label setup
Label c2w_pi_title = new Label("Add Player");
c2w_pi_title.setStyle("-fx-font-size:30 ;-fx-font-weight: bold; -fx-pref-width: 500; -fx-pref-height: 30; -fx-alignment : CENTER; -fx-text-fill:#FFFFFF");

// Button box containing the back button
HBox c2w_pi_buttonBox = new HBox(100, c2w_pi_backButton);
c2w_pi_buttonBox.setStyle("-fx-pref-size : 1000 400; -fx-padding : 30 ; ");

c2w_pi_buttonBox.setAlignment(Pos.TOP_LEFT);
// Form for player details
VBox c2w_pi_form = createPlayerForm();
c2w_pi_form.getChildren().add(0, c2w_pi_title); // Add title to the top of the form

c2w_pi_form.setStyle("-fx-pref-height : 480 ; -fx-max-width : 440; -fx-alignment : TOP_CENTER ; -fx-padding : 20 20 20 40 ;-fx-background-color : rgba(0, 0, 0, 0.5);");
// VBox to hold all components of the player addition page

VBox c2w_pi_playerVBox = new VBox(10, c2w_pi_buttonBox, c2w_pi_form);

c2w_pi_playerVBox.setAlignment(Pos.TOP_CENTER);
c2w_pi_playerVBox.setStyle("-fx-background-image:url('images/cricketGround2.jpg'); -fx-background-size: cover; -fx-padding : 0 0 50 0");

return c2w_pi_playerVBox;
}

/**
* Creates the form for entering player details.
* @return The VBox containing the player detail form
components.
*/
private VBox createPlayerForm(){
// Default player image setup
Image c2w_pi_playerImage = new Image("images/dummy.png");
ImageView c2w_pi_playerImgView = new ImageView(c2w_pi_playerImage);

c2w_pi_playerImgView.setFitHeight(120);
c2w_pi_playerImgView.setStyle("-fx-border-color: black; -fx-border-width: 1px;-fx-border-style: solid;");
c2w_pi_playerImgView.setPreserveRatio(true);
HBox c2w_pi_playerImage_hb = new HBox(c2w_pi_playerImgView);

c2w_pi_playerImage_hb.setStyle("-fx-pref-size : 350 20;-fx-alignment : CENTER");
// Player name input setup
Label c2w_pi_playerNameLabel = new Label("Enter Player Name : ");
c2w_pi_playerNameLabel.setStyle("-fx-font-size:12;-fx-font-weight :bold; -fx-text-fill:#FFFFFF");

TextField c2w_pi_playerNametf = new TextField();
c2w_pi_playerNametf.setPromptText("Enter Player Name");
c2w_pi_playerNametf.setStyle("-fx-pref-width : 180; -fx-text-fill:#FFFFFF");

HBox c2w_pi_playerName = new HBox(10,
c2w_pi_playerNameLabel, c2w_pi_playerNametf);
c2w_pi_playerName.setMaxSize(400, 20);
// Player age input setup
Label c2w_pi_playerAgeLabel = new Label("Enter Player Age: ");

c2w_pi_playerAgeLabel.setStyle("-fx-font-size:12;-fx-font-weight: bold; -fx-text-fill:#FFFFFF");

TextField c2w_pi_playerAgetf = new TextField();
c2w_pi_playerAgetf.setPromptText("Enter Player Age");
c2w_pi_playerAgetf.setStyle("-fx-pref-width : 180; -fx-text-fill:#FFFFFF");

HBox c2w_pi_playerAge = new HBox(10,c2w_pi_playerAgeLabel, c2w_pi_playerAgetf);
c2w_pi_playerAge.setMaxSize(400, 20);
// Player country input setup
Label c2w_pi_playerCountryLabel = new Label("Enter Player Country : ");
c2w_pi_playerCountryLabel.setStyle("-fx-font-size:12;-fx-font-weight:bold; -fx-text-fill:#FFFFFF");

TextField c2w_pi_playerCountrytf = new TextField();
if(c2w_pi_country != null)
c2w_pi_playerCountrytf.setText(c2w_pi_country);
c2w_pi_playerCountrytf.setPromptText("Enter Player Country");

c2w_pi_playerCountrytf.setStyle("-fx-pref-width : 180; -fx-text-fill:#FFFFFF");

HBox c2w_pi_playerCountry = new HBox(10,c2w_pi_playerCountryLabel, c2w_pi_playerCountrytf);
c2w_pi_playerCountry.setMaxSize(400, 20);
// Player role input setup
Label c2w_pi_playerRoleLabel = new Label("Enter Player Role : ");
c2w_pi_playerRoleLabel.setStyle("-fx-font-size:12;-fx-font-weight :bold; -fx-text-fill:#FFFFFF");

TextField c2w_pi_playerRoletf = new TextField();
c2w_pi_playerRoletf.setPromptText("Enter Player Role");

c2w_pi_playerRoletf.setStyle("-fx-pref-width : 180; -fx-text-fill:#FFFFFF");

HBox c2w_pi_playerRole = new HBox(10,c2w_pi_playerRoleLabel, c2w_pi_playerRoletf);
c2w_pi_playerRole.setMaxSize(400, 20);
// Player batting style input setup
Label c2w_pi_playerBatStyleLabel = new Label("Enter Player Batting Style : ");
c2w_pi_playerBatStyleLabel.setStyle("-fx-font-size:12;-fx-font-weight:bold; -fx-text-fill:#FFFFFF");

TextField c2w_pi_playerBatStyletf = new TextField();
c2w_pi_playerBatStyletf.setPromptText("Enter Player Batting Style");

c2w_pi_playerBatStyletf.setStyle("-fx-pref-width : 180; -fx-text-fill:#FFFFFF");

HBox c2w_pi_playerBatStyle = new HBox(10,c2w_pi_playerBatStyleLabel, c2w_pi_playerBatStyletf);
c2w_pi_playerBatStyle.setMaxSize(400, 20);
// Player bowling style input setup
Label c2w_pi_playerBowlStyleLabel = new Label("Enter Player Bowling Style : ");
c2w_pi_playerBowlStyleLabel.setStyle("-fx-font-size:12;-fx-font-weight:bold; -fx-text-fill:#FFFFFF");

TextField c2w_pi_playerBowlStyletf = new TextField();
c2w_pi_playerBowlStyletf.setPromptText("Enter Player Bowling Style");

c2w_pi_playerBowlStyletf.setStyle("-fx-pref-width : 180; -fx-text-fill:#FFFFFF");

HBox c2w_pi_playerBowlStyle = new HBox(10,c2w_pi_playerBowlStyleLabel, c2w_pi_playerBowlStyletf);
c2w_pi_playerBowlStyle.setMaxSize(400, 20);
// Country flag input setup

Label c2w_pi_countryFlagLabel = new Label("Enter Country Flag : ");
c2w_pi_countryFlagLabel.setStyle("-fx-font-size:12;-fx-font-weight:bold; -fx-text-fill:#FFFFFF");

TextField c2w_pi_countryFlagtf = new TextField();
c2w_pi_countryFlagtf.setPromptText("Enter Country Flag");
c2w_pi_countryFlagtf.setStyle("-fx-pref-width : 180; -fx-text-fill:#FFFFFF");

HBox c2w_pi_countryFlagImg = new HBox(10,c2w_pi_countryFlagLabel, c2w_pi_countryFlagtf);
c2w_pi_countryFlagImg.setMaxSize(400, 20);
// Player info URL input setup
Label c2w_pi_playerInfoUrlLabel = new Label("Enter Info URL : ");
c2w_pi_playerInfoUrlLabel.setStyle("-fx-font-size:12;-fx-font-weight:bold; -fx-text-fill:#FFFFFF");

TextField c2w_pi_playerInfoUrltf = new TextField();
c2w_pi_playerInfoUrltf.setPromptText("Enter Info URL");
c2w_pi_playerInfoUrltf.setStyle("-fx-pref-width : 180; -fx-text-fill:#FFFFFF");

HBox c2w_pi_playerInfoUrl = new HBox(10, c2w_pi_playerInfoUrlLabel, c2w_pi_playerInfoUrltf);
c2w_pi_playerInfoUrl.setMaxSize(400, 20);
// Button to add player data
Button c2w_pi_addButton = new Button("Add Data");
c2w_pi_addButton.setStyle("-fx-pref-width: 120;-fx-min-height: 30;-fx-background-radius: 15; -fx-background-color : #2196F3; -fx-text-fill:#FFFFFF");
HBox c2w_pi_buttonBox = new HBox(c2w_pi_addButton);
c2w_pi_buttonBox.setAlignment(Pos.CENTER);
// Output label for messages
Label c2w_pi_output = new Label();

c2w_pi_output.setStyle("fx-font-size:12; -fx-text-fill:#FFFFFF");

// File chooser setup for player image selection
FileChooser c2w_pi_fileChooser = new FileChooser();
c2w_pi_fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
// Event handler for clicking on the player image view to select an image

c2w_pi_playerImgView.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent c2w_pi_event) {
File c2w_pi_selectedFile = c2w_pi_fileChooser.showOpenDialog(c2w_pi_primaryStage);
if (c2w_pi_selectedFile != null) {
String c2w_pi_imageUrl = ImageUpload.uploadImage(c2w_pi_selectedFile.getPath(), c2w_pi_selectedFile.getName());

c2w_pi_imgUrl = c2w_pi_imageUrl;
if (c2w_pi_imageUrl != null) {
Image c2w_pi_image = new Image(c2w_pi_imageUrl);
c2w_pi_playerImgView.setImage(c2w_pi_image);

}
}
}
});
// Event handler for adding player data
c2w_pi_addButton.setOnAction(new EventHandler<ActionEvent>() {

@Override

public void handle(ActionEvent c2w_pi_event) {
// Create a Player object and set its attributes from the input fields

Player c2w_pi_player = new Player();
c2w_pi_player.setPlayerName(c2w_pi_playerNametf.getText());
c2w_pi_player.setPlayerAge(c2w_pi_playerAgetf.getText());
c2w_pi_player.setCountry(c2w_pi_playerCountrytf.getText());
c2w_pi_player.setPlayerRole(c2w_pi_playerRoletf.getText());
c2w_pi_player.setBattingStyle(c2w_pi_playerBatStyletf.getText());
c2w_pi_player.setBowlingStyle(c2w_pi_playerBowlStyletf.getText());
c2w_pi_player.setInfoUrl(c2w_pi_playerInfoUrltf.getText());
c2w_pi_player.setFlag(c2w_pi_countryFlagtf.getText());

if(c2w_pi_imgUrl != null)
c2w_pi_player.setPlayerImg(c2w_pi_imgUrl);
else
c2w_pi_output.setText("Please add Image");
// Check if all compulsory fields are filled
if(checkCompulsoryFields(c2w_pi_player)){
// Attempt to add the player using the PlayerController
if(c2w_pi_playerController.addPlayers(c2w_pi_player)){
c2w_pi_output.setText("Player Added Successfully");

}else{
c2w_pi_output.setText("Player Not Added");

}
}else{
c2w_pi_output.setText("Fields are Empty");
}
}
});
// VBox to contain all form components and output label
VBox c2w_pi_page = new VBox(20, c2w_pi_playerImage_hb, c2w_pi_playerName, c2w_pi_playerAge, c2w_pi_playerCountry, c2w_pi_playerRole, c2w_pi_playerBatStyle, c2w_pi_playerBowlStyle, c2w_pi_countryFlagImg, c2w_pi_playerInfoUrl, c2w_pi_buttonBox, c2w_pi_output);

return c2w_pi_page;
}
/**
* Method to check if all compulsory fields in the player
object are filled.
* @param c2w_pi_player The player object to check.
* @return True if all compulsory fields are filled, false
otherwise.
*/
private boolean checkCompulsoryFields(Player c2w_pi_player) {
if(c2w_pi_player.getPlayerName().trim().isEmpty()
|| c2w_pi_player.getPlayerAge().trim().isEmpty()
|| c2w_pi_player.getPlayerImg().trim().isEmpty()
|| c2w_pi_player.getPlayerRole().trim().isEmpty()
|| c2w_pi_player.getCountry().trim().isEmpty()
|| c2w_pi_player.getBattingStyle().trim().isEmpty()
|| c2w_pi_player.getBowlingStyle().trim().isEmpty()
|| c2w_pi_player.getFlag().trim().isEmpty()
|| c2w_pi_player.getInfoUrl().trim().isEmpty()){
return false;

}



return true;
}
}