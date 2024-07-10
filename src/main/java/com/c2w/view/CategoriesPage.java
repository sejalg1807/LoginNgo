package com.c2w.view;

import java.util.Map;
import com.c2w.controller.PlayerController;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.scene.text.TextFlow;

import javafx.stage.Stage;
import javafx.util.Duration;

public class CategoriesPage {
private Stage c2w_pi_primaryStage;
private PlayerController c2w_pi_playerController = new PlayerController(); // Service to interact with Firestore
private Scene c2w_pi_categoryScene, c2w_pi_playerListScene,
c2w_pi_addPlayerScene;
VBox c2w_pi_vb; // VBox to hold the user scene components
public CategoriesPage() {
// Default constructor
}
public void setCategoryScene(Scene c2w_pi_scene){
this.c2w_pi_categoryScene = c2w_pi_scene;
}
public void setCategoryPage(Stage c2w_pi_primaryStage){
this.c2w_pi_primaryStage = c2w_pi_primaryStage;
}
// Constructor to initialize the CategoriesPage with the PlayerController instance
public CategoriesPage(PlayerController c2w_pi_playerController) {

this.c2w_pi_playerController = c2w_pi_playerController;
}
// Method to create the category scene
public VBox createCategoryScene(Runnable c2w_pi_logoutHandler) {

Button c2w_pi_logoutButton = new Button("Logout"); // Button to trigger logout action

c2w_pi_logoutButton.setStyle("-fx-pref-width: 120;-fx-min-height: 30;-fx-background-radius: 15; -fx-background-color : #2196F3; -fx-c2w_pi_text-fill:#FFFFFF");
Label c2w_pi_title = new Label("Countries"); // Label to display the title

c2w_pi_title.setStyle("-fx-font-size:30 ;-fx-font-weight: bold; -fx-pref-width: 700; -fx-pref-height: 30; -fx-alignment : CENTER ;-fx-c2w_pi_text-fill:#FFFFFF");

Button c2w_pi_addPlayer = new Button("Add Player"); // Button to add a new player

c2w_pi_addPlayer.setStyle("-fx-pref-width: 120;-fx-min-height: 30;-fx-background-radius: 15; -fx-background-color : #2196F3; -fx-c2w_pi_text-fill:#FFFFFF");
HBox c2w_pi_header = new HBox(50, c2w_pi_logoutButton, c2w_pi_title); // HBox for header section

c2w_pi_header.setStyle("-fx-pref-width: 800; -fx-pref-height: 30;");

Map<String, String> c2w_pi_countryLists = c2w_pi_playerController.getAllCountries(); // Get the list of countries

GridPane c2w_pi_circles = createCircles(c2w_pi_countryLists); // Create circles representing countries

// Set action for the logout button
c2w_pi_logoutButton.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent c2w_pi_event) {
c2w_pi_logoutHandler.run(); // Run the logout handler
}
});

// Set action for the add player button
c2w_pi_addPlayer.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent c2w_pi_event) {
initAddPlayerScene();

c2w_pi_primaryStage.setScene(c2w_pi_addPlayerScene); // Show add player scene

c2w_pi_primaryStage.setTitle("Admin Dashboard");
}
});
ScrollPane c2w_pi_scrollPane = new ScrollPane(); // ScrollPane to hold circles

c2w_pi_scrollPane.setFitToWidth(true);
// Instructions text
Text c2w_pi_point1 = new Text("Welcome Admin");
c2w_pi_point1.setFont(Font.font("Arial", 20));
c2w_pi_point1.setFill(Color.BLACK);
c2w_pi_point1.setBoundsType(TextBoundsType.VISUAL);
Text c2w_pi_point2 = new Text("1. Here are the countries of which we have\n Players listed.");

c2w_pi_point2.setFont(Font.font("Times New Roman", 16));
c2w_pi_point2.setFill(Color.BLACK);
c2w_pi_point2.setBoundsType(TextBoundsType.VISUAL);
// Player parameters text
Text c2w_pi_line1 = new Text("2. Player contains following parameters\n");

Text c2w_pi_line2 = new Text("\tName\n");
Text c2w_pi_line3 = new Text("\tAge\n");
Text c2w_pi_line4 = new Text("\tImage\n");
Text c2w_pi_line5 = new Text("\tRole\n");
Text c2w_pi_line6 = new Text("\tCountry\n");

Text c2w_pi_line7 = new Text("\tCountry Flag (url)\n");
Text c2w_pi_line8 = new Text("\tBatting Style\n");
Text c2w_pi_line9 = new Text("\tBowling Style\n");
Text c2w_pi_line10 = new Text("\tInfo URL (cricbuzz)");
// Set the font and color for each Text node
Text[] c2w_pi_lines = {c2w_pi_line1, c2w_pi_line2, c2w_pi_line3, c2w_pi_line4, c2w_pi_line5, c2w_pi_line6, c2w_pi_line7, c2w_pi_line8, c2w_pi_line9, c2w_pi_line10};

for (Text c2w_pi_line : c2w_pi_lines) {
c2w_pi_line.setFont(Font.font("Times New Roman",16));

c2w_pi_line.setFill(Color.BLACK);
c2w_pi_line.setBoundsType(TextBoundsType.VISUAL);
}
// Create a TextFlow container and add the Text nodes
TextFlow c2w_pi_textFlow = new TextFlow(c2w_pi_lines);
c2w_pi_textFlow.setLineSpacing(10);
// Additional instruction text
Text c2w_pi_point3 = new Text("You can add a Player by clicking below button\n\n\t\t\t\t 👇");

c2w_pi_point3.setFont(Font.font("Times New Roman", 16));
c2w_pi_point3.setFill(Color.BLACK);
c2w_pi_point3.setBoundsType(TextBoundsType.VISUAL);
// VBox for instruction points
VBox c2w_pi_instructionPoints = new VBox(30, c2w_pi_point1, c2w_pi_point2, c2w_pi_textFlow, c2w_pi_point3);
c2w_pi_instructionPoints.setStyle("-fx-pref-height: 500;");

// Create a VBox layout for the instructions and add player button

VBox c2w_pi_instructions = new VBox(40, c2w_pi_instructionPoints, c2w_pi_addPlayer);

c2w_pi_instructions.setStyle("-fx-pref-width: 300; -fx-pref-height: 800; -fx-background-color: rgba(255, 255, 255,0.8); -fx-alignment: BOTTOM_CENTER; -fx-padding: 40 10 50 10;");

HBox c2w_pi_body = new HBox(c2w_pi_instructions, c2w_pi_circles); // HBox for body section

c2w_pi_vb = new VBox(100, c2w_pi_header, c2w_pi_body);

// VBox to hold the header and body

c2w_pi_vb.setStyle("-fx-background-image: url('images/cricketGround.jpg'); -fx-background-size: cover; -fx-padding: 30 20 20 20;");

return c2w_pi_vb; // Return the created VBox
}
// Method to initialize the add player scene
private void initAddPlayerScene() {
AddPlayerPage c2w_pi_addPlayerPage = new AddPlayerPage(null); // Create AddPlayerPage instance
c2w_pi_addPlayerPage.setAddPlayerPage(c2w_pi_primaryStage);

c2w_pi_addPlayerScene = new Scene(c2w_pi_addPlayerPage.createPlayerScene(this::handleBack),1000, 800); // Create add player scene
}
// Method to initialize the player list scene
private void initPlayerListScene(String c2w_pi_country) {
PlayerListPage c2w_pi_playerListPage = new PlayerListPage(c2w_pi_country); // Create PlayerListPage instance
c2w_pi_playerListPage.setPlayerListPage(c2w_pi_primaryStage);

c2w_pi_playerListScene = new Scene(c2w_pi_playerListPage.createPlayerListScene(this::handleBack), 1000, 800); // Create player list scene

c2w_pi_playerListPage.setPlayerListScene(c2w_pi_playerListScene);
}
// Method to handle back button action
private void handleBack() {
c2w_pi_primaryStage.setScene(c2w_pi_categoryScene); // Show category scene
}
// Method to create circles representing countries
private GridPane createCircles(Map<String, String>
c2w_pi_countries) {

GridPane c2w_pi_gridPane = new GridPane();
c2w_pi_gridPane.setHgap(70); // Horizontal gap between columns

c2w_pi_gridPane.setVgap(70); // Vertical gap between rows
c2w_pi_gridPane.setStyle("-fx-padding: 50 100 50 100");
int i = 0, j = 0;
for (Map.Entry<String, String> c2w_pi_entry : c2w_pi_countries.entrySet()) {

String c2w_pi_countryName = c2w_pi_entry.getKey();
String c2w_pi_flag = c2w_pi_entry.getValue();
Image c2w_pi_image = new Image(c2w_pi_flag);
// Create an ImageView
ImageView c2w_pi_imageView = new ImageView(c2w_pi_image);

c2w_pi_imageView.setFitHeight(100); // Set the height of the image view

c2w_pi_imageView.setPreserveRatio(true);
// Create a Circle
Circle c2w_pi_clip = new Circle(50, 50, 50); // CenterX, CenterY, Radius

c2w_pi_clip.setFill(new ImagePattern(c2w_pi_image));

// Text for country name
Text c2w_pi_text = new Text(c2w_pi_countryName);
c2w_pi_text.setFont(Font.font("Arial", 16));
c2w_pi_text.setFill(Color.WHITE);
c2w_pi_text.setBoundsType(TextBoundsType.VISUAL);
VBox c2w_pi_vb = new VBox(10, c2w_pi_clip, c2w_pi_text); // VBox for circle and text
c2w_pi_vb.setAlignment(Pos.CENTER);
// Set action for clicking on a country
c2w_pi_vb.setOnMouseClicked(new EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent c2w_pi_event) {
initPlayerListScene(c2w_pi_countryName);
c2w_pi_primaryStage.setScene(c2w_pi_playerListScene); // Show player list scene

c2w_pi_primaryStage.setTitle("Admin Dashboard");
}
});
// Animation for zooming in when mouse enters
ScaleTransition c2w_pi_scaleTransition = new ScaleTransition(Duration.seconds(0.5), c2w_pi_vb);
c2w_pi_scaleTransition.setFromX(1.0);
c2w_pi_scaleTransition.setFromY(1.0);
c2w_pi_scaleTransition.setToX(1.1);
c2w_pi_scaleTransition.setToY(1.1);
c2w_pi_scaleTransition.setCycleCount(1);
c2w_pi_scaleTransition.setAutoReverse(false);
// Animation for zooming out when mouse exits

ScaleTransition c2w_pi_resetTransition = new
ScaleTransition(Duration.seconds(0.5), c2w_pi_vb);
c2w_pi_resetTransition.setFromX(1.1);
c2w_pi_resetTransition.setFromY(1.1);
c2w_pi_resetTransition.setToX(1.0);
c2w_pi_resetTransition.setToY(1.0);
c2w_pi_resetTransition.setCycleCount(1);
c2w_pi_resetTransition.setAutoReverse(false);
c2w_pi_vb.setOnMouseEntered(c2w_pi_event -> c2w_pi_scaleTransition.play());

c2w_pi_vb.setOnMouseExited(c2w_pi_event -> c2w_pi_resetTransition.play());

c2w_pi_gridPane.add(c2w_pi_vb, i, j); // Add VBox to GridPane

if(i == 2){
    j++;
    i = -1;
    }
    i++;
}
return c2w_pi_gridPane; // Return the created GridPane
}
}