package com.c2w.view;

import com.c2w.controller.BackgroundImageController;
import com.c2w.controller.UserController;
import com.c2w.model.UserDetail;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import javafx.stage.Stage;
/**
* This class represents the login page of the application.
*/
public class LoginPage extends Application {
private Stage c2w_pi_primaryStage; // The primary stage for displaying scenes
private Scene c2w_pi_loginScene; // Scene for the login page
private Scene c2w_pi_userScene, c2w_pi_adminScene; // Scenes for the user and admin dashboards
private UserController c2w_pi_userController = new UserController(); // Controller for user-related operations
private BackgroundImageController c2w_pi_backgroundImg = new BackgroundImageController(); // Controller for background image
public static String c2w_pi_key; // Static key to store the logged-in username
// Method to initialize the login page
public void getLoginPage(Stage c2w_pi_primaryStage) {
this.c2w_pi_primaryStage = c2w_pi_primaryStage;
initLoginScene(); // Initialize the login scene
}
// Method to initialize the login scene
private void initLoginScene() {
ImageView c2w_pi_logo = new ImageView("images/c2w.png");

// Logo image

c2w_pi_logo.setFitWidth(40);
c2w_pi_logo.setPreserveRatio(true);
Label c2w_pi_title = new Label("Welcome Back"); // Title label

c2w_pi_title.setStyle("-fx-font-size:25 ;-fx-font-weight: bold; -fx-pref-width: 600; -fx-pref-height: 30; -fx-alignment :CENTER; -fx-text-fill:#FFFFFF");

VBox c2w_pi_header = new VBox(10, c2w_pi_logo, c2w_pi_title); // Header VBox containing logo and title

c2w_pi_header.setAlignment(Pos.CENTER);
Label c2w_pi_userLabel = new Label("Username"); // Label for username

TextField c2w_pi_userTextField = new TextField(); // TextField for username input

c2w_pi_userTextField.setPromptText("Enter Username");
c2w_pi_userTextField.setStyle("-fx-max-width: 270; -fx-min-height: 30; -fx-background-radius: 15;");
c2w_pi_userTextField.setFocusTraversable(false);
Label c2w_pi_passLabel = new Label("Password"); // Label for password

PasswordField c2w_pi_passField = new PasswordField(); // PasswordField for password input

c2w_pi_passField.setFocusTraversable(false);
c2w_pi_passField.setPromptText("Enter Password");
c2w_pi_passField.setStyle("-fx-min-width: 270; -fx-min-height: 30;-fx-background-radius: 15;");

TextField c2w_pi_textFieldPassword = new TextField(); // TextField to show password in plain text

c2w_pi_textFieldPassword.setPromptText("Enter Password");
c2w_pi_textFieldPassword.setFocusTraversable(false);
c2w_pi_textFieldPassword.setVisible(false);
c2w_pi_textFieldPassword.setStyle("-fx-min-width: 270; -fx-min-height: 30;-fx-background-radius: 15;");
c2w_pi_textFieldPassword.textProperty().bindBidirectional(c2w_pi_passField.textProperty()); // Bind text properties

Image c2w_pi_hide = new Image("images/hide.png"); // Image for hide icon

Image c2w_pi_show = new Image("images/show.png"); // Image for show icon

ImageView c2w_pi_icon = new ImageView(c2w_pi_show); // ImageView for toggle icon

c2w_pi_icon.setFitWidth(30);
c2w_pi_icon.setPreserveRatio(true);
HBox c2w_pi_passBox = new HBox(10, c2w_pi_passField); // HBox for password fields

c2w_pi_passBox.setPrefWidth(400);
HBox c2w_pi_iconBox = new HBox(10, c2w_pi_icon); // HBox for toggle icon

c2w_pi_iconBox.setMaxWidth(70);
c2w_pi_iconBox.setAlignment(Pos.BASELINE_LEFT);
StackPane c2w_pi_passFieldStackPane = new StackPane(c2w_pi_passBox, c2w_pi_iconBox); // StackPane for password field and icon
c2w_pi_passFieldStackPane.setAlignment(Pos.BASELINE_RIGHT);
Label c2w_pi_output = new Label(); // Label for output messages

c2w_pi_output.setStyle("-fx-text-fill: white;");
Button c2w_pi_loginButton = new Button("Login"); // Button to trigger login action

c2w_pi_loginButton.setStyle("-fx-pref-width: 70;-fx-min-height: 30; -fx-background-radius: 15;-fx-background-color : #2196F3; -fx-text-fill:#FFFFFF");
Label c2w_pi_signupButton = new Label("Signup"); // Button to navigate to signup scene

c2w_pi_signupButton.setStyle(" -fx-background-radius: 15; -fx-text-fill : white");

// Set action for the login button
c2w_pi_loginButton.setOnAction(new EventHandler<ActionEvent>() {

@Override
public void handle(ActionEvent c2w_pi_event) {

if (!c2w_pi_userTextField.getText().isEmpty() &&!c2w_pi_passField.getText().isEmpty()) {

if

(c2w_pi_userController.authenticateUser(c2w_pi_userTextField.getText(), c2w_pi_passField.getText())) {

UserDetail c2w_pi_userDetail = c2w_pi_userController.getUserDetail(c2w_pi_userTextField.getText(
));

if

(c2w_pi_userDetail.getRole().equals("USER")) {

initUserScene(); // Initialize user scene
c2w_pi_primaryStage.setScene(c2w_pi_userScene); // Show user scene

} else if

(c2w_pi_userDetail.getRole().equals("ADMIN")) {

initAdminScene(); // Initialize admin scene
c2w_pi_primaryStage.setScene(c2w_pi_adminScene); // Show admin scene

}
c2w_pi_userTextField.clear(); // Clear username field

c2w_pi_passField.clear(); // Clea password field

} else {
c2w_pi_output.setText("Invalid Username or Password"); // Show error message

}
} else {
c2w_pi_output.setText("Please Enter Username and Password"); // Show error message

}
}
});

// Toggle visibility of password
c2w_pi_icon.setOnMouseClicked(ne EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent c2w_pi_event) {
if (c2w_pi_passField.isVisible()) {
c2w_pi_passField.setVisible(false);
c2w_pi_textFieldPassword.setVisible(true);
c2w_pi_passBox.getChildren().remove(0);
c2w_pi_passBox.getChildren().add(0,

c2w_pi_textFieldPassword);

c2w_pi_icon.setImage(c2w_pi_hide);
} else {
c2w_pi_passField.setVisible(true);
c2w_pi_textFieldPassword.setVisible(false);
c2w_pi_passBox.getChildren().remove(0);
c2w_pi_passBox.getChildren().add(0, c2w_pi_passField);

c2w_pi_icon.setImage(c2w_pi_show);
}
}
});
// Set action for the signup button
c2w_pi_signupButton.setOnMouseClicked(ne EventHandler<MouseEvent>() {
@Override
public void handle(MouseEvent c2w_pi_event) {
showSignupScene(); // Show signup scene
c2w_pi_userTextField.clear(); // Clear usernamefield

c2w_pi_passField.clear(); // Clear password field

}
});

// Style the labels
c2w_pi_userLabel.setStyle("-fx-text-fill: white;");
c2w_pi_passLabel.setStyle("-fx-text-fill: white;");
// Create VBox layouts for the fields and buttons
VBox c2w_pi_fieldBox1 = new VBox(10, c2w_pi_userLabel,c2w_pi_userTextField); // VBox for username
c2w_pi_fieldBox1.setMaxSize(300, 30);
VBox c2w_pi_fieldBox2 = new VBox(10, c2w_pi_passLabel, c2w_pi_passFieldStackPane); // VBox for password
c2w_pi_fieldBox2.setMaxSize(300, 30);
// Main VBox layout for the login page
VBox c2w_pi_loginBox = new VBox(20, c2w_pi_header, c2w_pi_fieldBox1, c2w_pi_fieldBox2, c2w_pi_loginButton, c2w_pi_signupButton, c2w_pi_output);

c2w_pi_loginBox.setStyle("-fx-pref-height : 200 ;-fx-alignment : TOP_CENTER ; -fx-padding : 30 ;-fx-background-color : rgba(0, 0, 0, 0.5);");
c2w_pi_loginBox.setMaxSize(400, 200);
StackPane c2w_pi_sp = new StackPane(c2w_pi_loginBox); //StackPane for the login page

c2w_pi_sp.setStyle("-fx-background-image:url('" + c2w_pi_backgroundImg.imageData() + "');-fx-background-size:cover;");

c2w_pi_loginScene = new Scene(c2w_pi_sp, 1000, 800); //Create login scene
}
// Method to initialize the user scene
private void initUserScene() {
UserPage c2w_pi_userPage = new UserPage(); // Create UserPage instance

c2w_pi_userPage.setUserPage(c2w_pi_primaryStage);

c2w_pi_userScene = new Scene(c2w_pi_userPage.createUserScene(this::handleLogout), 1000,800); // Create user scene

c2w_pi_userPage.setUserPageScene(c2w_pi_userScene);
}
// Method to initialize the admin scene
private void initAdminScene() {
CategoriesPage c2w_pi_adminPage = new CategoriesPage();

// Create CategoriesPage instance

c2w_pi_adminPage.setCategoryPage(c2w_pi_primaryStage);
c2w_pi_adminScene = new Scene(c2w_pi_adminPage.createCategoryScene(this::handleLogout),1000, 800); // Create admin scene

c2w_pi_adminPage.setCategoryScene(c2w_pi_adminScene);
}
// Method to get the login scene
public Scene getLoginScene() {
return c2w_pi_loginScene;
}
// Method to show the login scene
public void showLoginScene() {
c2w_pi_primaryStage.setScene(c2w_pi_loginScene);
c2w_pi_primaryStage.show();
}
// Method to show the signup scene
private void showSignupScene() {
SignupPage signupPage = new SignupPage(); // Create SignupPage instance

Scene signupScene = signupPage.createSignupScene(this::handleBack); // Create signup scene

c2w_pi_primaryStage.setScene(signupScene);
c2w_pi_primaryStage.show();

}
// Method to handle logout action
private void handleLogout() {
c2w_pi_primaryStage.setScene(c2w_pi_loginScene); // Show login scene
}
// Method to handle back action from signup
private void handleBack() {
c2w_pi_primaryStage.setScene(c2w_pi_loginScene); // Show login scene
}
@Override
public void start(Stage c2w_pi_primaryStage) throws Exception
{
Class.forName("com.c2w.configuration.FirebaseInitialization");
// Initialize Firebase

LoginPage loginController = new LoginPage(); // Create LoginPage instance

loginController.getLoginPage(c2w_pi_primaryStage); //Initialize login page
c2w_pi_primaryStage.setScene(loginController.getLoginScene());
// Set the initial scene to the login scene

c2w_pi_primaryStage.setTitle("Players Information"); //Set the title of the primary stage window
c2w_pi_primaryStage.getIcons().add(newImage("images/c2w.png")); // Set the icon of the primary stage window

c2w_pi_primaryStage.show(); // Show the primary stage window
}
}